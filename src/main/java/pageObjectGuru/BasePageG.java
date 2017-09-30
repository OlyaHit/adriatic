package pageObjectGuru;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import static helpers.WebLibrary.*;

public class BasePageG {
	protected WebDriver driver;
	public BasePageG (WebDriver driver){
		this.driver=driver;
	PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//a[text()='Mobile']")
	private WebElement mobileMenu;
	
	public WebElement getMobileMenu(){
		return mobileMenu;
	}
	public void clickMobileMenu(){
		clickLink(mobileMenu);
	}
	
	@FindBy(xpath="//a[text()='TV']")
	private WebElement tVMenu;
	
	public WebElement getTVMenu(){
		return tVMenu;
	}
	
	public void clickTvMenu(){
		clickLink(tVMenu);
	}
	
	@FindBy(xpath="//span[text()='Account']")
	private WebElement accountLink;
	
	public void clickAccountLink(){
		clickButton(accountLink);
	}
	
	@FindBy(xpath="//div[@id='header-account']//a[@title='My Account']")
	private WebElement myAccountLinkHeader;
	
	@FindBy(xpath="//div[@class='footer']//a[@title='My Account']")
	private WebElement myAccountLinkFooter;
	
	public void clickMyAccountLinkHeader(){
		clickLink(myAccountLinkHeader);
	}
	
	@FindBy(id="search")
	private WebElement searchField;
	
	public WebElement getSearchField() {
		return searchField;
	}
	
	public void setTextInSearchField (String text){
		searchField.clear();
		searchField.sendKeys(text);
	}

	private WebElement getElementByText (String text) {
    	return driver.findElement(By.xpath("//a[@id='signIn']/span[contains(text(),'" + text + "')]"));
    }
	
	}
