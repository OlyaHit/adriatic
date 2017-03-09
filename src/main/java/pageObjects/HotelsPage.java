package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HotelsPage extends BasePage {

    public HotelsPage(WebDriver driver) {
        super(driver);
    }



    //Search results
    @FindBy(xpath= "//article[@class=\"searchObjectWrap\"]")
    public List<WebElement> HotelSearchResults;

}
