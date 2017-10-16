package businessFunctionsGuru;
import static helpers.WebLibrary.*;

import org.openqa.selenium.WebDriver;

import pageObjectGuru.AccountPage;

public class AccountFunctions {

	public AccountPage account;
	
	public AccountFunctions(WebDriver driver){
		account=new AccountPage(driver);
	}

	public void goToMyAccount(){
		account.clickAccountLink();
		account.clickMyAccountLinkHeader();
	}
	public void createAccount(AccountPage account){
		setTextIntoWebElement(account.firstName, "Olga");
		setTextIntoWebElement(account.lastName, "kuku");
		setTextIntoWebElement(account.email, "mailMy@gmail.com");
		setTextIntoWebElement(account.password, "qwertyOl5");
		setTextIntoWebElement(account.confirmPassword,"qwertyOl5");
		clickButton(account.registerAccountButton);
	}
	
	public void loginAsValidUser(AccountPage account){
		setTextIntoWebElement(account.getEmailAddressRegisteredUser(), "mailMy@gmail.com");
		setTextIntoWebElement(account.getPasswordRegisteredUser(),"qwertyOl5");
		clickButton(account.getLoginButtonRegisteredUser());
		
		
		
	}
}
