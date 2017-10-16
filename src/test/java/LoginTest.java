
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.*;
import pageObjects.BasePage;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static helpers.WebLibrary.*;
import helpers.Rules;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Title("suite:Login Test")
@Description("Login Functionality:")
@Features("Login")
@Stories("Login Test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

	private static final Logger log = Logger.getLogger(LoginTest.class);
	public WebDriver driver = new FirefoxDriver();
	public BasePage basePage = new BasePage(driver);
	public Actions actions;

	@Rule
	public Rules rules = new Rules(driver);

	@BeforeClass
	public static void beforeAll(){
		log.info("Running suite: LoginTest");
			}
	
	@Before
	public void beforeEach() {
		setUpDriver(driver,20);
		goToUrl(driver, "http://www.adriatic.hr/");
	}

	@Title("Login as Valid User")
	@Description("Should login as valid user")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginValidUser(){
		 log.info("Running test - LoginValidUser");
		 log.info("Click SignInButton");
		 basePage.clickSignInButton();
		 
		 log.info("Fill EmailTextfield");
		 setTextIntoWebElement(basePage.EmailTextfield, "olyahit@gmail.com");
		 log.info("Fill PasswordTextfield");
		 setTextIntoWebElement(basePage.PasswordTextfield, "Good458");
		 
		 log.info("unchecked checkbox");
		 setCheckBoxState(basePage.RememberCheckbox,"unchecked");
		 log.info("Click logInButton");
		 clickButton(basePage.logInButton);
		 
		 boolean result = isElementDisplayed(basePage.SignoutButton);
		 log.info("User is log in:" + result);
		 Assert.assertTrue("User is LogIn", result); 
	}

	@Title("Login with invalid email")
	@Description("Should not login with invalid email")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginInvalidEmail() {
		 log.info("Running test - LoginInvalidEmail");
		 log.info("Click SignInButton");
		 basePage.clickSignInButton();
		
		 log.info("Fill EmailTextfield");
		 setTextIntoWebElement(basePage.EmailTextfield, "tyuutf@gmail.com");
		 log.info("Fill PasswordTextfield");
		 setTextIntoWebElement(basePage.PasswordTextfield, "Good458");
		 
		 log.info("Click logInButton");
		 clickButton(basePage.logInButton);
		 
		 String errorMessage = basePage.ErrorMessageLogin.getText();
		 log.info("Error message is display -" + errorMessage);
		 Assert.assertEquals("Username or E-Mail - The combination of the entered e-mail address and password is invalid", errorMessage );
	}

	@Title("Login with invalid Password")
	@Description("Should not login with invalid Password")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginInvalidPassword() {
		 log.info("Running test - LoginInvalidPassword");
		 log.info("Click SignInButton");
		 basePage.clickSignInButton();
		
		 log.info("Fill EmailTextfield");
		 setTextIntoWebElement(basePage.EmailTextfield, "olyahit@gmail.com");
		 log.info("Fill PasswordTextfield");
		 setTextIntoWebElement(basePage.PasswordTextfield, "hhjr09fjh");
		 
		 log.info("Click logInButton");
		 clickButton(basePage.logInButton);
		 
		 String errorMessage = basePage.ErrorMessageLogin.getText();
		 log.info("Error message is display -" + errorMessage);
		 Assert.assertEquals("Username or E-Mail - The combination of the entered e-mail address and password is invalid", errorMessage );
	}

	@Title("Sign Out")
	@Description("Should sign out")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void signOut(){
		 log.info("Running test - signOut");
		 log.info("Click SignInButton");
		 basePage.clickSignInButton();
		 log.info("Fill EmailTextfield");
		 setTextIntoWebElement(basePage.EmailTextfield, "olyahit@gmail.com");
		 
		 log.info("Fill PasswordTextfield");
		 setTextIntoWebElement(basePage.PasswordTextfield, "Good458");
		 log.info("unchecked checkbox");
		 setCheckBoxState(basePage.RememberCheckbox,"unchecked");
		 
		 log.info("Click logInButton");
		 clickButton(basePage.logInButton);
		 log.info("Click SignoutButton");
		 clickButton(basePage.SignoutButton);
		 
		 boolean result = isElementDisplayed(basePage.getSignInButton());
		 log.info("User is logout:" + result);
		 Assert.assertTrue("User is LogIn", result); 
	}
	
	@Ignore
	@Title("Reset Password With Valid Email")
	@Description("Should Reset Password With Valid Email")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void resetPasswordWithValidEmail(){
		log.info("Running test - resetPasswordWithValidEmail");
		log.info("Click SignInButton");
		basePage.clickSignInButton();
		log.info("Click ForgotYourPassword");
		clickLink(basePage.ForgotYourPassword);
		
		log.info("Fill Email");
		setTextIntoWebElement(basePage.EmailFieldForResetPassword, "olyahit@gmail.com");
		log.info("Click SendPasswordButton");
		clickButton(basePage.SendPasswordButton);
		
		String message = basePage.ValidationMessageAfterClickSendPassword.getText();
		log.info("ValidationMessage is display:-"+ message);
		Assert.assertEquals("Enter the password we sent to your e-mail address.", message);
	}

	@Title("Reset Password With invalid Email")
	@Description("Should Reset Password With invalid Email")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void resetPasswordWithInvalidEmail(){
		log.info("Running test - resetPasswordWithInvalidEmail");
		log.info("Click SignInButton");
		basePage.clickSignInButton();
		log.info("Click ForgotYourPassword");
		clickLink(basePage.ForgotYourPassword);
		
		log.info("Fill Invalid Email");
		setTextIntoWebElement(basePage.EmailFieldForResetPassword, "yuiyuy@gmail.com");
		log.info("Click SendPasswordButton");
		clickButton(basePage.SendPasswordButton);
		
		String message = basePage.ErrorMessageResetPasswordWithInvalidEmail.getText();
		log.info("Error Message is display:-"+ message);
		Assert.assertEquals("User with this e-mail address does not exist.", message);
	}

	@Title("Login cancel")
	@Description("Should cancel login")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void loginCancel(){
		 log.info("Running test - loginCancel");
		 log.info("Click SignInButton");
		 basePage.clickSignInButton();
		
		 log.info("Fill EmailTextfield");
		 setTextIntoWebElement(basePage.EmailTextfield, "olyahit@gmail.com");
		 log.info("Fill PasswordTextfield");
		 setTextIntoWebElement(basePage.PasswordTextfield, "hhjr09fjh");
		 
		 log.info("Click logInButton");
		 clickButton(basePage.logInButton);
		 
		 log.info("Move to HomeTab");
		// moveMouse(driver, basePage.HomeTab);
		 log.info("Move to CancelLoginButton and click");
		 moveAndClickMouse (driver, basePage.CancelLoginButton);
		 
		 String currentPageUrl = driver.getCurrentUrl();
		 log.info("Get url:-"+ currentPageUrl);
		 Assert.assertEquals("http://www.adriatic.hr/en",currentPageUrl);
	}
}
