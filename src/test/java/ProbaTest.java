import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.BasePage;
import static helpers.WebLibrary.*;
import helpers.Rules;
import pageObjects.PagesForProbaTest;


public class ProbaTest {
	public WebDriver driver = new FirefoxDriver();
	public BasePage basePage = new BasePage(driver);
	public PagesForProbaTest probaPages = new PagesForProbaTest(driver);
	public static String url = "http://www.adriatic.hr/";
	
	private static final Logger log = Logger.getLogger(LiveChatTest.class);
    @Rule
    public Rules rules = new Rules(driver);
	
	 @BeforeClass
	    public static void beforeAll() {
	        log.info("Running spec: ProbaTest");
	    }
	 @Before
	 public void beforeEach() {
		 setUpDriver(driver,10);
	 }
	 
	 @Test
	 public void TestWebElementMethod() throws Exception{
		 log.info("Open Baseurl: " + "www.adriatic.hr");
		 goToUrl(driver, url);
		 log.info("click OtherServicesTab");
		 clickWebElement(basePage.OtherServicesTab);
		 log.info("click sailboatsLink");
		 clickLink(probaPages.sailboatsLink);
		 //boolean actualResult = isElementPresent(driver, "//article[@class='searchObjectWrap']");
		 //Assert.assertTrue("Result sould be true", actualResult);
	 }
}
