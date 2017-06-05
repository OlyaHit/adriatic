package pageObjectGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class AccountPage extends BasePageG{

	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css=".button[title='Create an Account']")
	public WebElement creatAccountButton;
	
	
	
}
