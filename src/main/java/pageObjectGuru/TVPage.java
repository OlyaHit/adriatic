package pageObjectGuru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static helpers.WebLibrary.*;

public class TVPage extends BasePageG{
	public TVPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getAddToWishList (String text) {
    	return driver.findElement(By.xpath("//a[contains(@class,'link-wishlist') and contains(@href,'product/" + text + "')]"));
    }
	
	public void clickAddToWishList(String numberOfProduct){
		clickLink(getAddToWishList(numberOfProduct));
	}
}
