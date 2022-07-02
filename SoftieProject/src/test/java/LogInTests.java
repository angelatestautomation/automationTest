import Utils.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MyAccountPage;

import java.util.concurrent.TimeUnit;

public class LogInTests {

    public static WebDriver driver;
    MyAccountPage myAccountPage;


    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.navigateTo();
    }

    @AfterEach
    void afterEach() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    @Test
    void logInWithoutUsername() {
        myAccountPage.loginUser(User.EmptyLoginUser);
        myAccountPage.login();
        Assertions.assertTrue(myAccountPage.getNoLoginErrorText().contains("Nazwa użytkownika jest wymagana."));
    }

    @Test
    void logInWithoutPassword() {
        myAccountPage.loginUser(User.EmptyPasswordUser);
        myAccountPage.login();
        Assertions.assertEquals("Błąd\n" + ": Hasło jest puste.", myAccountPage.getNoLoginErrorText());
    }

    @Test
    void logInWithExistingUser() {
        myAccountPage.loginUser(User.SoftieUser);
        myAccountPage.login();
        Assertions.assertTrue(myAccountPage.cockpitIsDisplayed());
    }

    @Test
    void logInWithNoExistingUser() {
        myAccountPage.loginUser(User.WrongUser);
        myAccountPage.login();
        Assertions.assertEquals("Nieznany użytkownik. Proszę spróbować ponownie lub użyć swojego adresu e-mail.", myAccountPage.logInAsNonExistingUser());
    }

}
