package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import java.util.List;

public class PrivateAccomodationPage extends BasePage{

    public PrivateAccomodationPage(WebDriver driver) {
        super(driver);
    }


    //Search results
    @FindBy(xpath= "//article[contains(@class, \"searchObjectWrap\")]")
    public List<WebElement> PrivateAccomodationSearchResults;
}
