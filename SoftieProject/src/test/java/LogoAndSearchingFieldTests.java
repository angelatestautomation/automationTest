import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.MyAccountPage;

import java.util.concurrent.TimeUnit;

public class LogoAndSearchingFieldTests {
    public static WebDriver driver;
    HomePage homePage;
    MyAccountPage myAccountPage;

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
        myAccountPage = new MyAccountPage(driver);
    }

    @AfterEach
    void afterEach(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    @Test
    void isLogoAndSearchingFieldExistingOnHomePage(){
        Assertions.assertTrue(homePage.searchingLogoIsVisible());
        homePage.openSearchingField();
        Assertions.assertTrue(homePage.isSearchingFieldDisplayed());
    }

    @Test
    void isLogoAndSearchingFieldExistingOnMyAccountPage(){
        homePage.goToMyAccountPage();
        Assertions.assertTrue(myAccountPage.searchingLogoIsVisible());
        myAccountPage.openSearchingField();
        Assertions.assertTrue(myAccountPage.searchingFieldIsVisible());
    }

}
