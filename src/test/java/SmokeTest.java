import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import pageObjects.BasePage;
import pageObjects.Homepage;
import static helpers.WebLibrary.*;
import java.util.Set;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import helpers.Rules;
import ru.yandex.qatools.allure.annotations.*;

import ru.yandex.qatools.allure.model.SeverityLevel;

@Title("suite:Smoke Test")
@Description("Basic Functionality:")
@Features("Smoke Test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SmokeTest {
	
	private static final Logger log = Logger.getLogger(SmokeTest.class);

	public WebDriver driver = new FirefoxDriver();
	public BasePage basePage = new BasePage(driver);
	public Homepage homePage = new Homepage(driver);

	@Rule
	public Rules rules = new Rules(driver);
	
	@BeforeClass
	public static void beforeAll(){
		log.info("Running suite: SmokeTest");
			}

	@Before
	public void beforeEach() {
		setUpDriver(driver,20);
		goToUrl(driver, "http://www.adriatic.hr/");
	}

	@Title("Sign In")
	@Description("Should sign in")
	@Features("Login")
	@Stories("Login Test")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void signIn(){
		 log.info("Running test - signIn");
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

	@Title("Sign Out")
	@Description("Should sign out")
	@Severity(SeverityLevel.BLOCKER)
	@Features("Login")
	@Stories("Login Test")
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

	@Title("Register Form")
	@Description("Should Register new user")
	@Severity(SeverityLevel.BLOCKER)
	@Features("Register")
	@Stories("Register Form")
	@Test
	public void registerForm () {
	log.info("Running test - RegisterForm");
	log.info("Click RegisterButton");
	clickButton(basePage.RegisterButton);
	
	log.info("Select Title");
	Select title = new Select(basePage.title);
	title.selectByIndex(1);
	log.info("Type Name");
	setTextIntoWebElement(basePage.name, "Olga");
	
	log.info("Type SurName");
	setTextIntoWebElement(basePage.surname, "Bonya");
	
	log.info("Select Country");
	Select country = new Select(basePage.country);
	country.selectByValue("zw");
	log.info("Type email");
	setTextIntoWebElement(basePage.email, "OlgaBonya@gmail.com");
	
	log.info("Type password");
	setTextIntoWebElement(basePage.password, "wert$%67734f");
	log.info("Type password2");
	setTextIntoWebElement(basePage.password2, "wert$%67734f");
	
	log.info("Select phone");
	Select phone = new Select(basePage.phone);
	phone.selectByValue("1");
	
	log.info("Type phoneNumber");
	setTextIntoWebElement(basePage.phoneNumber, "+3047783668567");
	log.info("Click addAnotherButton");
	log.info("click registerButton");
	clickButton(basePage.registerButton);
	
	String ErrorMessage = basePage.validationMessageWrongCode.getText();
    log.info("Message: " + ErrorMessage + "\n");
	Assert.assertEquals("Wrong verify code, please try again",ErrorMessage);
	}

	@Title("Shortlist")
	@Description("Should display Shortlist")
	@Severity(SeverityLevel.BLOCKER)
	@Features("Shortlist")
	@Stories("Shortlist page")
	@Test
	public void shortlistIsDisplay () {
		log.info("Running test - ShortlistIsDisplay");
		log.info("Click Shortlist");
		clickButton(basePage.ShortlistButton);
		
		String result = basePage.ShortlistResult.getText();
		log.info("Shortlist is display :" + result);
		Assert.assertEquals("Shortlist", result);
	}

	@Title("Compare")
	@Description("Should display Compare")
	@Severity(SeverityLevel.BLOCKER)
	@Features("Compare")
	@Stories("Compare page")
	@Test
	public void compareIsDisplay (){
		log.info("Running test - CompareIsDisplay");
		log.info("Click CompareButton");
		clickButton(basePage.CompareButton);
		
		String result = basePage.CompareResult.getText();
		log.info("Compare is display:" + result);
		Assert.assertEquals("Compare", result);
		
	}

	@Title("Open Live Chat")
	@Description("open Live Chat popup window")
	@Severity(SeverityLevel.BLOCKER)
	@Features("Live Chat")
	@Stories("Open Live Chat popup")
	@Test
	public void liveChatOnlineOpen () {
		log.info("Running test - LiveChatOnlineOpen");
		log.info("Click LiveChatOnlineButton");	
		clickButton(basePage.LiveChatButton);
		
		Set<String> AllWindowHandles = driver.getWindowHandles();
		log.info("get parent window");
		int windowsQuantity = AllWindowHandles.toArray().length;
		log.info("windows:" + windowsQuantity);
		
		String LiveChatOnlineWindow = (String) AllWindowHandles.toArray()[1];
		log.info("Switching from parent window to LiveChatOnlineWindow");
		driver.switchTo().window(LiveChatOnlineWindow);
		
		String result = basePage.pageTitleResult.getText();
		log.info("windows:" + result);
		Assert.assertEquals("Leave your message",result);
		driver.close();
	}

	@Title("Change Language")
	@Description("Should change language")
	@Severity(SeverityLevel.BLOCKER)
	@Features("Localization")
	@Stories("Change Language")
	@Test
	public void changeLanguage(){
	log.info("Running test - ChangeLanguage");

	log.info("click LanguageList");
	clickWebElement(basePage.LanguageList);
	log.info("select languageDeutsch");
	clickWebElement(basePage.languageDeutsch);

	boolean result = isElementDisplayed(basePage.languageDeutsch);
	log.info("windows:" + result);
	Assert.assertTrue("Deutsch is display",result);
	}

	@Title("Page header")
	@Description("Should display page header")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void headerIsDisplay(){
		log.info("Running test - HeaderIsDisplay");
		boolean result = isElementDisplayed(basePage.header);
		log.info("Header Is Display:" + result);
		Assert.assertTrue("Header Is Display: ", result);
	}

	@Title("Page body")
	@Description("Should display page body")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void bodyIsDisplay(){
		log.info("Running test - bodyIsDisplay");
		boolean result = isElementDisplayed(basePage.body);
		log.info("body Is Display:" + result);
		Assert.assertTrue("body Is Display: ", result);
	}

	@Title("Page footer")
	@Description("Should display page footer")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void footerIsDisplay(){
		log.info("Running test - footerIsDisplay");
		boolean result = isElementDisplayed(basePage.getFooter());
		log.info("footer Is Display:" + result);
		Assert.assertTrue("footer Is Display: ", result);
	}

	@Title("Private Accommodation Menu")
	@Description("Should display Private Accommodation Menu")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void privateAccommodationMenuIsDisplay(){
		log.info("Running test - PrivateAccommodationMenuIsDisplay");

		log.info("click PrivateAccomodationTab");
		clickWebElement(basePage.PrivateAccomodationTab);
		Assert.assertTrue("PrivateAccomodationMenu Is Display: ", isElementDisplayed(basePage.PrivateAccomodationMenu));
	}

	@Title("Hotels Menu")
	@Description("Should display Hotels Menu")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void hotelsMenuIsDisplay(){
		log.info("Running test - HotelsMenuIsDisplay");

		log.info("click HotelsTab");
		clickWebElement(basePage.HotelsTab);
		Assert.assertTrue("HotelsMenu Is Display: ", isElementDisplayed(basePage.HotelsMenu));
	}

	@Title("Other services Menu")
	@Description("Should display Other services Menu")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void otherServicesMenuIsDisplay(){
		log.info("Running test - OtherServicesMenuIsDisplay");

		log.info("click OtherServicesTab");
		clickWebElement(basePage.OtherServicesTab);
		Assert.assertTrue("OtherServicesMenu Is Display: ", isElementDisplayed(basePage.OtherServicesMenu));
	}

	@Title("Croatia Menu")
	@Description("Should display Croatia Menu")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void croatiaMenuIsDisplay(){
		log.info("Running test - CroatiaMenuIsDisplay");

		log.info("click OtherServicesTab");
		clickWebElement(basePage.CroatiaTab);
		Assert.assertTrue("CroatiaMenu Is Display ", isElementDisplayed(basePage.CroatiaMenu));
	}

	@Title("Looking Holiday Search Menu")
	@Description("Should display Looking Holiday Search Menu")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void lookingHolidaySearchFormIsDisplay(){
		log.info("Running test - LookingHolidaySearchFormIsDisplay");
		boolean result = isElementDisplayed(homePage.HomepageSearchForm);
		log.info("LookingHolidaySearchForm Is Display: " + result);
		Assert.assertTrue("CroatiaMenu Is Display", result);
		
	}

	@Title("Subscribe to newsletter")
	@Description("Should subscribe to newsletter")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void newsletterSubscribe(){
		log.info("Running test - NewsletterSubscribe");
		log.info("Fill email in NewsletterEmailField ");
		setTextIntoWebElement(homePage.NewsletterEmailField, "olhitr@gmail.com");
		
		log.info("Click SubscribeButtonNewsletter ");
		clickButton(homePage.SubscribeButtonNewsletter);
		
		String message  = homePage.newsletterSatus.getText();
		log.info("Text is display: "+ message);
		Assert.assertEquals("E-mail address olhitr@gmail.com is successfully subscribed to our mailing list.", message);
	}
}
	

