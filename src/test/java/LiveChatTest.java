import config.*;
import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.Homepage;
import pageObjects.LiveChatPopup;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;
import static helpers.WebLibrary.*;
import java.util.concurrent.TimeUnit;
import helpers.Rules;

@Title("suite:Live Chat")
@Description("Live Chat Functionality:")
@Features("Live Chat")
@Stories("Open Live Chat popup")
public class LiveChatTest {

    private static final Logger log = Logger.getLogger(LiveChatTest.class);
    public WebDriver driver = new FirefoxDriver();
    public Homepage homepage = new Homepage(driver);
    public LiveChatPopup liveChat = new LiveChatPopup(driver);

    @Rule
    public Rules rules = new Rules(driver);

    @BeforeClass
    public static void beforeAll() {
        log.info("Running spec: LiveChatSpec");
    }

    @Before
    public void beforeEach() {
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Title("Open Live Chat")
    @Description("open Live Chat popup window")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void OpenLiveChat() {
        log.info("Open Baseurl: " + Config.baseUrl);
        driver.get(Config.baseUrl);

        String mainWindow = driver.getWindowHandle();

        log.info("Open livechat popup");
        homepage.LiveChatButton.click();

        //Switch to popup window
        for(String popup : driver.getWindowHandles()){
            if (!popup.equals(mainWindow)){
                log.info("Switch to popup window");
                driver.switchTo().window(popup);
            }
        }

        log.info("Populate email");
        liveChat.LiveChatEmailField.sendKeys("invalid email");
        log.info("Populate username");
        liveChat.LiveChatUsernameField.clear();
        liveChat.LiveChatUsernameField.sendKeys("username");
        log.info("Populate message");
        liveChat.LiveChatMessageField.sendKeys("Test message. please ignor");

        log.info("Hit send button");
        liveChat.LiveChatSendButton.click();

        String ErrorMessage = liveChat.LiveChatErrorMessage.getText();
        log.info("Message: " + ErrorMessage + "\n");
        Assert.assertEquals("Please fill \"Your email\" correctly.", ErrorMessage);
    }
}
