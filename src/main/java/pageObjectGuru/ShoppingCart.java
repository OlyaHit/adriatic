package pageObjectGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;;

public class ShoppingCart extends BasePageG {

	public ShoppingCart(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//table[@id='shopping-cart-table']//input")
	private WebElement quantityTextField;

	public void setQuantityInField(String quantity){
		quantityTextField.clear();
		quantityTextField.sendKeys(quantity);
	}
	
	@FindBy(css=".button.btn-update")
	private WebElement buttonUpdate;

	public WebElement getButtonUpdate(){
		return buttonUpdate;
	}
	public void clickUpdateButton(){
		buttonUpdate.click();
	}

	@FindBy(xpath = "//td[@class='product-cart-total']//span[@class='price']")
	private WebElement subTotal;

	public String getSubTotalPrice(){
		return subTotal.getText();
	}

	@FindBy(css=".success-msg>ul>li>span")
	public WebElement messageAddedProductToCart;
	
	@FindBy(css=".product-image>img")
	public WebElement productImageInCart;
	
	@FindBy(css=".item-msg.error")
	public WebElement errorMessagesMaxQuantity;
	
	@FindBy(css=".error-msg>ul>li>span")
	public WebElement errorMessagesProductNotOrrder;

	@FindBy(xpath = "//button[contains(@class,'btn-checkout')]")
	private WebElement proccedToCheckOutButton;

	public void clickProccedToCheckOutButton(){
		proccedToCheckOutButton.click();
	}
	
	
}
