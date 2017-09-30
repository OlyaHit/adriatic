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
	
	//CREATE AN ACCOUNT
	@FindBy(id="firstname")
	public WebElement firstName;
	
	@FindBy(id="lastname")
	public WebElement lastName;
	
	@FindBy(id="email_address")
	public WebElement email;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="confirmation")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//button[@title='Register']")
	public WebElement registerAccountButton;
	
	@FindBy(xpath="//li[@class='success-msg']//span")
	public WebElement successMessageRegisteAccont;
	
	@FindBy(xpath="//div[@class='input-box']//input[@id='email']")
	private WebElement emailAddressRegisteredUser;

	public WebElement getEmailAddressRegisteredUser() {
		return emailAddressRegisteredUser;
	}

	public WebElement getPasswordRegisteredUser() {
		return passwordRegisteredUser;
	}

	public WebElement getLoginButtonRegisteredUser() {
		return loginButtonRegisteredUser;
	}

	@FindBy(xpath="//div[@class='input-box']//input[@id='pass']")
	private WebElement passwordRegisteredUser;
	
	@FindBy(id="send2")
	private WebElement loginButtonRegisteredUser;
	
	@FindBy(xpath="//a[text()='View Order']")
	private WebElement viewOrderLink;
	
	public void clickViewOrderLink(){
		viewOrderLink.click();
	}
	
	@FindBy(xpath="//a[@class='link-print']")
	private WebElement printOrderLink;
	
	public void clickPrintOrderLink(){
		printOrderLink.click();
	}
	
	@FindBy(xpath="//h1[contains(text(),'Order')]")
	private  WebElement orderNumber;
	
	public WebElement getOrderNumber(){
		return orderNumber;
	}
	
	public String getOrderNumberText(){
		return orderNumber.getText();
	}
	
}
