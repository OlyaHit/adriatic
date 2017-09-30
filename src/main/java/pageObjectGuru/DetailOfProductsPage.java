package pageObjectGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class DetailOfProductsPage extends BasePageG{

	public DetailOfProductsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="#product-price-1>span.price")
	public WebElement sonyXperiaPriceDetailPage;
	
	
	
}
