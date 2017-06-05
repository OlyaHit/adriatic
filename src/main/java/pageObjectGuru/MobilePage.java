package pageObjectGuru;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class MobilePage extends BasePageG {
	
	public MobilePage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//select[@title='Sort By']")
	public WebElement sortByDropDownForMobile;
	
	@FindBy(xpath="//h2[@class='product-name']//a")
	public List <WebElement> mobileProductNames;
	
	@FindBy(css="#product-price-1>span.price")
	public WebElement sonyXperiaPrice;
	
	@FindBy(css="#product-collection-image-1")
	public WebElement sonyXperiaImageLink;
	
	@FindBy(css=".button.btn-cart[onclick*='product/1']")
	public WebElement addToCartOfsonyXperia;
	
	@FindBy(xpath="//a[contains(@class,'link-compare') and contains(@href,'product/1')]")
	public WebElement addToCompareSonyXperia;
	
	@FindBy(xpath="//a[contains(@class,'link-compare') and contains(@href,'product/2')]")
	public WebElement addToCompareIphone;
	
	@FindBy(css=".button[title='Compare']")
	public WebElement compareButton;
	
	//popUp window
	
	@FindBy(css=".page-title.title-buttons>h1")
	public WebElement compareProductsTitle;
	
	@FindBy(css=".product-name>a[title='Sony Xperia']")
	public WebElement sonyXperiaText;
	
	@FindBy(css=".product-name>a[title='IPhone']")
	public WebElement IPhoneText;
}
