import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.HomePage;


import java.util.concurrent.TimeUnit;

public class CartPageTests {
    public static WebDriver driver;
    CartPage cartPage;
    HomePage homePage;

    @BeforeAll
    static void beforeAll(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        homePage.navigateTo();
        cartPage = new CartPage(driver);
    }

    @AfterEach
    void afterEach(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    @Test
    void addCoinToCart(){
        Assertions.assertTrue(homePage.isGoldenBitCoinAddToCartDisplayed(),"Element is not displayed");
        homePage.goldenBitcoinAddToCart();
        Assertions.assertTrue(homePage.isGoldenBitCoinGoToCartDisplayed(),"Element is not displayed");
        homePage.goldenBitCoinGoToCart();
        Assertions.assertTrue(cartPage.isGoldenBitcoinInCart(), "Element is not displayed");
    }

    @Test
    void addAndRemoveCoinFromCart(){
        Assertions.assertTrue(homePage.isGoldenPolishJP2AddToCartDisplayed(),"Element is not displayed");
        homePage.goldenPolishJP2AddToCart();
        Assertions.assertTrue(homePage.isGoldenPolishJP2GotoCartDisplayed());
        homePage.goldenPolishJP2GoToCart();
        Assertions.assertTrue(cartPage.isGoldenPolishJP2InCart());
        cartPage.removeGoldenPolishJP2();
        Assertions.assertTrue(cartPage.getDeleteMessage().contains("Usunięto: „Golden Polish JP2“."));
    }

}
