package pageObjectGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static helpers.WebLibrary.*;

public class MyWishList extends BasePageG {

	public MyWishList(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css=".button.btn-share")
	private WebElement shareWishlistButton;
	
	public void clickShareWishlistButton(){
		clickButton(shareWishlistButton);
	}

	//Share Your Wishlist
	@FindBy(id="email_address")
	private WebElement emailToShare;
	
	public void setTextEmailToShare(String text){
		setTextIntoWebElement(emailToShare, text);
	}
	
	@FindBy(id="message")
	private WebElement messageField;
	
	public void setTextMessageField(String text){
		setTextIntoWebElement(messageField, text);
	}
	
	@FindBy(xpath="//button[@title='Share Wishlist']")
	private WebElement shareWishlist;
	
	public void clickShareWishlist(){
		clickButton(shareWishlist);
	}
	
	@FindBy(xpath="//span[contains(text(),'shared')]")
	private WebElement sharedResult;
	
	public String getSharedResult(){
		return  sharedResult.getText();
	}
	
}
