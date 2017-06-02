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
	
	}
