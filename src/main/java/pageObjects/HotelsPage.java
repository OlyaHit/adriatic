package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import static helpers.WebLibrary.*;
public class HotelsPage extends BasePage {

    public HotelsPage(WebDriver driver) {
        super(driver);
    }



    //Search results
    @FindBy(xpath= "//article[@class=\"searchObjectWrap\"]")
    public List<WebElement> HotelSearchResults;
    
    //proba
    @FindBy(xpath= "//article[@class=\"searchObjectWrap\"]")
    private WebElement signInButtonHotels; 
    
//    @Override
//    public void clickSignInButton() {
//    	// TODO Auto-generated method stub
//    	super.clickSignInButton();
//    }
    
    public void clickSignInButton (){
    	signInButtonHotels.click();
    }
    
    public void usePrivateElement (){
    	getSignInButton().click();
    }
  
   
}
