package pages;
import Utils.Warning;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    static String expectedHomeHeader = "Home";

    @FindBy(className = "woocommerce-products-header__title")
    static WebElement homeHeader;

    @FindBy(linkText = "Moje konto")
    WebElement myAccount;

    @FindBy(css = "button[class='toggle search-toggle desktop-search-toggle']")
    WebElement searchingLogo;

    @FindBy(id = "search-form-1")
    WebElement searchingField;

    @FindBy(linkText = "Kontakt")
    WebElement contact;

    @FindBys({
            @FindBy(css = "li.post-15"),
            @FindBy(css = "a.add_to_cart_button")
    })
    WebElement goldenBitCoinAddToCartButton;

    @FindBys({
            @FindBy(css = "li.post-15"),
            @FindBy(css = "a.added_to_cart")
    })
    WebElement goldenBitCoinGoToCart;

    @FindBys({
            @FindBy(css = "li.post-20"),
            @FindBy(css = "a.add_to_cart_button")
    })
    WebElement goldenPolishJP2AddToCartButton;

    @FindBys({
            @FindBy(css = "li.post-20"),
            @FindBy(css = "a.added_to_cart")
    })
    WebElement goldenPolishJP2GoToCart;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToMyAccountPage() {
        myAccount.click();
        Warning.print(MyAccountPage.isVisible(), "Expected: " + MyAccountPage.expectedMyAccountHeader
                + " Actual: " + MyAccountPage.myAccountHeader.getText());
    }

    public void navigateTo() {
        driver.get("http://34.79.156.100/");
        Warning.print(this.isVisible(), "Expected: " + expectedHomeHeader + " Actual: "
                + homeHeader.getText());
    }

    public static boolean isVisible() {
        return homeHeader.getText().equals(expectedHomeHeader);
    }

    public boolean searchingLogoIsVisible() {
        return searchingLogo.isDisplayed();
    }

    public void openSearchingField() {
        searchingLogo.click();
    }

    public boolean isSearchingFieldDisplayed() {
        return searchingField.isDisplayed();
    }

    public void goToContactPage() {
        contact.click();
        Warning.print(ContactPage.isVisible(), "Expected: " + ContactPage.expectedContactHeader
                + " Actual: " + ContactPage.contactPageHeader.getText());
    }

    public boolean isGoldenBitCoinAddToCartDisplayed() {
        return goldenBitCoinAddToCartButton.isDisplayed();
    }

    public void goldenBitcoinAddToCart() {
        Actions action = new Actions(driver);
        action.moveToElement(goldenBitCoinAddToCartButton, 0, -5).click().build().perform();
    }

    public boolean isGoldenBitCoinGoToCartDisplayed() {
        return goldenBitCoinGoToCart.isDisplayed();
    }

    public void goldenBitCoinGoToCart() {
        Actions action = new Actions(driver);
        action.moveToElement(goldenBitCoinGoToCart, 0, -5).click().build().perform();
        Warning.print(CartPage.isVisible(), "Expected: " + CartPage.expectedCartHeader
                + " Actual: " + CartPage.cartHeader.getText());
    }

    public boolean isGoldenPolishJP2AddToCartDisplayed() {
        return goldenPolishJP2AddToCartButton.isDisplayed();
    }

    public void goldenPolishJP2AddToCart() {
        Actions action = new Actions(driver);
        action.moveToElement(goldenPolishJP2AddToCartButton, 0, -5).click().build().perform();
    }

    public boolean isGoldenPolishJP2GotoCartDisplayed() {
        return goldenPolishJP2GoToCart.isDisplayed();
    }

    public void goldenPolishJP2GoToCart() {
        Actions action = new Actions(driver);
        action.moveToElement(goldenPolishJP2GoToCart, 0, -5).click().build().perform();
        Warning.print(CartPage.isVisible(), "Expected: " + CartPage.expectedCartHeader
                + " Actual: " + CartPage.cartHeader.getText());
    }


}
