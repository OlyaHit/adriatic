package pageObjectGuru;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class BasePageG {
	
	public BasePageG (WebDriver driver){
	PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//a[text()='Mobile']")
	public WebElement mobileMenu;
	
	@FindBy(xpath="//a[text()='TV']")
	public WebElement tVMenu;
	
	@FindBy(xpath="//span[text()='Account']")
	public WebElement accountLink;
	
	@FindBy(xpath="//div[@id='header-account']//a[@title='My Account']")
	public WebElement myAccountLinkHeader;
	
	}
