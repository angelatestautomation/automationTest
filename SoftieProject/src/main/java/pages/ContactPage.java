package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    WebDriver driver;
    static String expectedContactHeader = "Kontakt";

    @FindBy(css = "h1[class='entry-title']")
    static WebElement contactPageHeader;

    public ContactPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static boolean isVisible() {
        return contactPageHeader.getText().equals(expectedContactHeader);
    }
}
