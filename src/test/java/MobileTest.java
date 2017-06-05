import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static helpers.WebLibrary.*;
import pageObjectGuru.BasePageG;
import pageObjectGuru.DetailOfProductsPage;
import pageObjectGuru.MobilePage;
import pageObjectGuru.ShoppingCart;

public class MobileTest {
	
	private static final Logger log = Logger.getLogger(LiveChatOnlineTest.class);
	public  WebDriver driver = new FirefoxDriver();
	public BasePageG basePage = new BasePageG(driver);
	public MobilePage mobilePage = new MobilePage(driver);
	public DetailOfProductsPage detailPage = new DetailOfProductsPage(driver);
	public ShoppingCart cartPage = new ShoppingCart(driver);
	
	@BeforeClass
	public static void beforeAll(){
		log.info("Running suite: MobileTest");
			}
	@Before
	public void beforeEach() {
		setUpDriver(driver,15);
		goToUrl(driver, "http://live.guru99.com/index.php");
	}
	@After
	public void shutDown (){
		driver.quit();
	}
	@Ignore
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
	@Ignore
	@Test
	public void verifyCostOfMobileBetweenListPageAndDetailPage (){
		log.info("click link mobileMenu" );
		clickLink(basePage.mobileMenu);
		String expectedCostListPageSonyXP = mobilePage.sonyXperiaPrice.getText();
		log.info("Save cost of Sony Xperia on ListPage " + expectedCostListPageSonyXP );
		
		log.info("click on sonyXperiaImageLink and go to detail page" );
		clickLink(mobilePage.sonyXperiaImageLink);
		String actualCostDetailPageSonyXP= detailPage.sonyXperiaPriceDetailPage.getText();
		log.info("Save cost of Sony Xperia on DetailPage " + actualCostDetailPageSonyXP );
		
		Assert.assertEquals("Product price in list and details page should be equal ($100)",
				expectedCostListPageSonyXP,actualCostDetailPageSonyXP );
		
	}
	@Test 
	public void verifyAddingProductsToCart(){
		log.info("click link mobileMenu" );
		clickLink(basePage.mobileMenu);
		log.info("click addToCartOfsonyXperia" );
		clickButton(mobilePage.addToCartOfsonyXperia);
		String actualMessage = cartPage.messageAddedProductToCart.getText();
		log.info("message is appread " + actualMessage );
		String expectedPartOfMessage = "was added to your shopping cart.";
		
		Assert.assertTrue("Wrong Message should be " + expectedPartOfMessage, actualMessage.endsWith(expectedPartOfMessage));
	}
	@Ignore
	@Test
	public void verifyAddingProductsToCartMoreThenAvailable(){
		log.info("click link mobileMenu" );
		clickLink(basePage.mobileMenu);
		log.info("click addToCartOfsonyXperia" );
		clickButton(mobilePage.addToCartOfsonyXperia);
		
		log.info("type 501 quantity in cart" );
		setTextIntoWebElement(cartPage.quantityTextField, "501");
		log.info("wait element to be click" );
		waitElementToBeClickable(driver, 10, cartPage.buttonUpdate);
		log.info("click update button" );
		clickButton(cartPage.buttonUpdate);
		
		String expectedMessageMaxQuantity = "* The maximum quantity allowed for purchase is 500.";
		String actualMessageMaxQuantity = cartPage.errorMessagesMaxQuantity.getText().trim();
		log.info("get error message MessageMaxQuantity: " + actualMessageMaxQuantity );
		String expectedMessageProductNotOrrder ="Some of the products cannot be ordered in requested quantity.";
		String actualMessageProductNotOrrder = cartPage.errorMessagesProductNotOrrder.getText().trim();
		log.info("get error message MessageProductNotOrrder: " + actualMessageProductNotOrrder );
		
		Assert.assertEquals("Error MessageMaxQuantity is not same", expectedMessageMaxQuantity,actualMessageMaxQuantity );
		Assert.assertEquals("Error MessageProductNotOrrder is not same", expectedMessageProductNotOrrder,actualMessageProductNotOrrder );
	}
	@Test
	public void verifyPossibilityCompareTwoMobile() throws InterruptedException{
		log.info("click link mobileMenu" );
		clickLink(basePage.mobileMenu);
		log.info("click add To CompareList sonyXperia" );
		clickLink(mobilePage.addToCompareSonyXperia);
		
		log.info("click add To CompareList Iphone" );
		clickButton(mobilePage.addToCompareIphone);
		log.info("click compare Button" );
		clickButton(mobilePage.compareButton);
		
		log.info("switch to new window" );
		waitForNewWindowAndSwitchToIt(driver);
		String expectedTitle = "COMPARE PRODUCTS";
		String actualTitle = mobilePage.compareProductsTitle.getText();
		log.info("get actual title of compare page" +actualTitle );
		
		String expectedMobile1 = "SONY XPERIA";
		String expectedMobile2= "IPHONE";
		String actualMobile1 = mobilePage.sonyXperiaText.getText();
		
		log.info("get actualMobile1" +actualMobile1 );
		String actualMobile2 = mobilePage.IPhoneText.getText();
		log.info("get actualMobile2" +actualMobile2 );
		log.info("close popUp window" );
		driver.close();
		
		Assert.assertEquals("Wrong title",expectedTitle,actualTitle);
		Assert.assertEquals("Wrong mobile1",expectedMobile1,actualMobile1);
		Assert.assertEquals("Wrong mobile2",expectedMobile2,actualMobile2);
	}
	@Test
	public void verifyAccountCreation(){
		
	}
	
}
