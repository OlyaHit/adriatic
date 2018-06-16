import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.BasePage;
import pageObjects.LiveChatPopup;
import static helpers.WebLibrary.*;
import ru.yandex.qatools.allure.annotations.*;
import helpers.Rules;
import java.util.Set;
import org.junit.runners.MethodSorters;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Title("suite:Live Chat Online Test")
@Description("Live Chat Online Test:")
@Features("Live Chat")
@Stories("Open Live Chat Online")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Ignore
public class LiveChatOnlineTest {

	private static final Logger log = Logger.getLogger(LiveChatOnlineTest.class);
	public WebDriver driver = new ChromeDriver();
	public BasePage basePage = new BasePage(driver);
	public LiveChatPopup liveChatPage = new LiveChatPopup(driver);

	@Rule
	public Rules rules = new Rules(driver);

	@BeforeClass
	public static void beforeAll(){
		log.info("Running suite: LiveChatOnlineTest");
			}

	@Before
	public void beforeEach() {
		setUpDriver(driver,20);
		goToUrl(driver, "http://www.adriatic.hr/");
	}

	@Title("Send Message With Empty Email")
	@Description("Should not send message with empty Email")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void sendMessageWithEmptyEmail () {
		log.info("Running test - sendMessageWithEmptyEmail");
		log.info("Click LiveChatOnlineButton");	
		clickButton(basePage.LiveChatButton);
		
		Set<String> AllWindowHandles = driver.getWindowHandles();
		int windowsQuantity = AllWindowHandles.toArray().length;
		log.info("windows:" + windowsQuantity);
		
		log.info("get LiveChatOnlineWindow window");
		//String parentWindow = (String) AllWindowHandles.toArray()[0];
		String LiveChatOnlineWindow = (String) AllWindowHandles.toArray()[1];
		log.info("Switching from parent window to LiveChatOnlineWindow");
		driver.switchTo().window(LiveChatOnlineWindow);
		
		log.info("Fill LiveChatUsernameField");
		setTextIntoWebElement(liveChatPage.LiveChatUsernameField, "Katya");
		log.info("Fill LiveChatMessageField");
		setTextIntoWebElement(liveChatPage.LiveChatMessageField, "Hello!");
		
		log.info("Click LiveChatSendButton");
		clickButton(liveChatPage.LiveChatSendButton);
		
		boolean result = isElementDisplayed(liveChatPage.LiveChatErrorMessage);
		log.info("error is displayed:" + result);
		Assert.assertTrue("error is displayed",result);
		

		//newWait(driver, 5,textToBePresentInElement(liveChatPage.LiveChatEmailField, "hello") );
	}


	@Title("Send Message With Empty Message Field")
	@Description("Should not send message with empty message filed")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void sendMessageWithEmptyMessageField () {
		log.info("Running test - sendMessageWithEmptyEmail");
		log.info("Click LiveChatOnlineButton");	
		clickButton(basePage.LiveChatButton);
		
		Set<String> AllWindowHandles = driver.getWindowHandles();
		int windowsQuantity = AllWindowHandles.toArray().length;
		log.info("windows:" + windowsQuantity);
		
		log.info("get LiveChatOnlineWindow window");
		//String parentWindow = (String) AllWindowHandles.toArray()[0];
		String LiveChatOnlineWindow = (String) AllWindowHandles.toArray()[1];
		log.info("Switching from parent window to LiveChatOnlineWindow");
		driver.switchTo().window(LiveChatOnlineWindow);
		
		log.info("Fill LiveChatMessageField");
		setTextIntoWebElement(liveChatPage.LiveChatEmailField, "hjggfg@gmail.com");
		log.info("Fill LiveChatUsernameField");
		setTextIntoWebElement(liveChatPage.LiveChatUsernameField, "Katya");
		
		
		log.info("Click LiveChatSendButton");
		clickButton(liveChatPage.LiveChatSendButton);
		
		boolean result = isElementDisplayed(liveChatPage.LiveChatErrorMessage);
		log.info("error is displayed:" + result);
		Assert.assertTrue("error is displayed",result);
	}
}
