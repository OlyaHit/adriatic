import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static helpers.WebLibrary.*;
import pageObjectGuru.BasePageG;
import pageObjectGuru.MobilePage;

public class MobileTest {
	
	private static final Logger log = Logger.getLogger(LiveChatOnlineTest.class);
	public static WebDriver driver = new FirefoxDriver();
	public BasePageG basePage = new BasePageG(driver);
	public MobilePage mobilePage = new MobilePage(driver);
	
	@BeforeClass
	public static void beforeAll(){
		log.info("Running suite: MobileTest");
			}
	@Before
	public void beforeEach() {
		setUpDriver(driver,15);
		goToUrl(driver, "http://live.guru99.com/index.php");
	}
	@AfterClass
	public static void shutDown (){
		driver.quit();
	}
	@Test
	public void verifyMobileSortedByName (){
		log.info("click link mobileMenu" );
		clickLink(basePage.mobileMenu);
		log.info("sortBy Name in DropDownForMobile" );
		selectDropDownByIndex(driver, mobilePage.sortByDropDownForMobile, 1);
		
		String expectedResult = "IPHONE";
		String actualResult = mobilePage.mobileProductNames.get(0).getText();
		log.info("get actual result" + actualResult);
		
		Assert.assertEquals("Wrong sorted should be IPhone",expectedResult,actualResult);
		
		
	}
	
}
