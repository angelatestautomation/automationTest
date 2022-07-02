import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactPage;
import pages.HomePage;
import pages.MyAccountPage;

import java.util.concurrent.TimeUnit;

public class PageToPageTests {
    public static WebDriver driver;
    HomePage homePage;
    MyAccountPage myAccountPage;
    ContactPage contactPage;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        contactPage = new ContactPage(driver);
    }

    @AfterEach
    void afterEach() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    @Test
    void homeToContactPage() {
        homePage.navigateTo();
        homePage.goToContactPage();
        Assertions.assertTrue(ContactPage.isVisible());
    }

    @Test
    void myAccountPageToHomePage() {
        myAccountPage.navigateTo();
        myAccountPage.goToHomePage();
        Assertions.assertTrue(HomePage.isVisible());
    }

    @Test
    void homeToMyAccountPage() {
        homePage.navigateTo();
        homePage.goToMyAccountPage();
        Assertions.assertTrue(MyAccountPage.isVisible());
    }
}
