package pages;

import Utils.User;
import Utils.Warning;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;
    static String expectedMyAccountHeader = "Moje konto";

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(name = "login")
    WebElement submitButton;

    @FindBys({
            @FindBy(css = "div.entry-header-inner"),
            @FindBy(css = "h1.entry-title")
    })
    static WebElement myAccountHeader;

    @FindBy(className = "woocommerce-error")
    WebElement loginError;

    @FindBy(linkText = "Kokpit")
    WebElement cockpit;

    @FindBy(css = "button[class='toggle search-toggle desktop-search-toggle'")
    WebElement searchingLogo;

    @FindBy(id = "search-form-1")
    WebElement searchingField;

    @FindBy(linkText = "Home")
    WebElement home;


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginUser(User user) {
        if (user.userName != null) {
            usernameInput.sendKeys(user.userName);
        }
        if (user.userPassword != null) {
            passwordInput.sendKeys(user.userPassword);
        }
    }

    public void login() {
        submitButton.click();
    }

    public String getNoLoginErrorText() {
        return loginError.getText();
    }

    public void navigateTo() {
        driver.get("http://34.79.156.100/moje-konto/");
        Warning.print(isVisible(), "Expected: " + expectedMyAccountHeader + " Actual: " + myAccountHeader.getText());
    }

    public static boolean isVisible() {
        return myAccountHeader.getText().equals(expectedMyAccountHeader);
    }

    public boolean cockpitIsDisplayed() {
        return cockpit.isDisplayed();
    }

    public boolean searchingLogoIsVisible() {
        return searchingLogo.isDisplayed();
    }

    public void openSearchingField() {
        searchingLogo.click();
    }

    public boolean searchingFieldIsVisible() {
        return searchingField.isDisplayed();
    }

    public void goToHomePage() {
        home.click();
    }

    public String logInAsNonExistingUser() {
        return loginError.getText();
    }

}
