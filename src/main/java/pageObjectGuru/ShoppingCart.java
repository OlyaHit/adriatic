package pageObjectGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;;

public class ShoppingCart extends BasePageG {

	public ShoppingCart(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//table[@id='shopping-cart-table']//input")
	public WebElement quantityTextField;
	
	@FindBy(css=".button.btn-update")
	public WebElement buttonUpdate;
	
	@FindBy(css=".success-msg>ul>li>span")
	public WebElement messageAddedProductToCart;
	
	@FindBy(css=".product-image>img")
	public WebElement productImageInCart;
	
	@FindBy(css=".item-msg.error")
	public WebElement errorMessagesMaxQuantity;
	
	@FindBy(css=".error-msg>ul>li>span")
	public WebElement errorMessagesProductNotOrrder;
	
	
}
