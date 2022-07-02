package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    public static String expectedCartHeader = "Koszyk";

    @FindBy(css = "h1[class='entry-title']")
    static WebElement cartHeader;

    @FindBy(linkText = "Golden Bitcoin")
    WebElement goldenBitcoin;

    @FindBy(linkText = "Golden Polish JP2")
    WebElement goldenPolishJP2;

    @FindBys({
            @FindBy(className = "product-remove"),
            @FindBy(css = "a[data-product_id='20']")
    })
    WebElement removeGoldenPolishJP2;

    @FindBy(className = "woocommerce-message")
    WebElement deleteMessage;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static boolean isVisible(){
        return cartHeader.getText().equals(expectedCartHeader);
    }

    public boolean isGoldenBitcoinInCart(){
        return goldenBitcoin.isDisplayed();
    }

    public boolean isGoldenPolishJP2InCart(){
        return goldenPolishJP2.isDisplayed();
    }

    public void removeGoldenPolishJP2(){
        removeGoldenPolishJP2.click();
    }

    public String getDeleteMessage(){
        return deleteMessage.getText();
    }
}
