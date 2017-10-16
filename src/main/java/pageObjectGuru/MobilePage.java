package pageObjectGuru;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;
import static helpers.WebLibrary.*;

public class MobilePage extends BasePageG {
	
	public MobilePage(WebDriver driver){
		super(driver);
	}
	
	
	@FindBy(xpath="//select[@title='Sort By']")
	private WebElement sortByDropDownForMobile;
	
	public WebElement getSortByDropDownForMobile() {
		return sortByDropDownForMobile;
	}

	//Retrieve the option values from Dropdown using getOptions() method
	public List<String> getOptionSortByMobile() {
		Select selectMobile = new Select(sortByDropDownForMobile);
		List<String> actOptions = new ArrayList<String>();
		for (WebElement option : selectMobile.getOptions()) {
			actOptions.add(option.getText());
		}
		return actOptions;

	}
	
	@FindBy(xpath="//h2[@class='product-name']//a")
	public List <WebElement> mobileProductNames;
	
	@FindBy(css="#product-price-1>span.price")
	public WebElement sonyXperiaPrice;
	
	@FindBy(css="#product-collection-image-1")
	public WebElement sonyXperiaImageLink;
	
	@FindBy(css=".button.btn-cart[onclick*='product/1']")
	private WebElement addToCartOfsonyXperiaButton;
	
	public void clickButtonAddToCartOfsonyXperia(){
		addToCartOfsonyXperiaButton.click();
	}
	
	@FindBy(xpath="//a[contains(@class,'link-compare') and contains(@href,'product/1')]")
	private WebElement addToCompareSonyXperiaLink;
	
	public void clickLinkAddToCompareSonyXperia () {
		addToCompareSonyXperiaLink.click();
	}
	
	@FindBy(xpath="//a[contains(@class,'link-compare') and contains(@href,'product/2')]")
	private WebElement addToCompareIphoneButton;
	
	public void clickButtonAddToCompareIphone(){
		addToCompareIphoneButton.click();
	}
	
	@FindBy(css=".button[title='Compare']")
	private WebElement compareButton;
	
	public void clickCompareButton(){
		compareButton.click();
	}
	
	//popUp window
	
	@FindBy(css=".page-title.title-buttons>h1")
	public WebElement compareProductsTitle;
	
	@FindBy(css=".product-name>a[title='Sony Xperia']")
	public WebElement sonyXperiaText;
	
	@FindBy(css=".product-name>a[title='IPhone']")
	public WebElement IPhoneText;
	
	public WebElement getAddToCart (String text) {
    	return driver.findElement(By.xpath("//button[contains(@class,'btn-cart') and contains(@onclick,'product/"+text+"')]"));
    }

    public void clickAddToCart (String numberOfmobile){
		getAddToCart(numberOfmobile).click();
	}
	
	@FindBy(id="coupon_code")
	private WebElement couponCodeField;
	
	public void setCouponCode(){
		setTextIntoWebElement(couponCodeField, "GURU50");
	}
	
	@FindBy(xpath="//button[@title='Apply']")
	private WebElement applyButton;
	
	public void clickApplyButton(){
		clickButton(applyButton);
	}
	
	@FindBy(xpath="//span[contains(text(),'GURU50')]")
	private WebElement couponResult;
	
	public String getCouponResult(){
		return couponResult.getText();
	}
	
}
