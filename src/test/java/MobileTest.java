import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.ThreadedRefreshHandler;

import businessFunctionsGuru.AccountFunctions;

import static helpers.WebLibrary.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pageObjectGuru.AccountPage;
import pageObjectGuru.BasePageG;
import pageObjectGuru.DetailOfProductsPage;
import pageObjectGuru.MobilePage;
import pageObjectGuru.MyWishList;
import pageObjectGuru.ShoppingCart;
import pageObjectGuru.TVPage;

import java.io.BufferedInputStream;
//import java.net.URL;
//import org.apache.pdfbox.cos.COSDocument;
//import org.apache.pdfbox.pdfparser.PDFParser;
//import org.apache.pdfbox.pdmodel.PDDocument;

public class MobileTest {
	
	private static final Logger log = Logger.getLogger(LiveChatOnlineTest.class);
	
	public static  WebDriver driver;
	public BasePageG basePage;
	public MobilePage mobilePage;
	public DetailOfProductsPage detailPage;
	public ShoppingCart cartPage;
	public AccountPage account;
	public AccountFunctions accountFunctions;
	
	@BeforeClass
	public static void beforeAll(){
		log.info("Running suite: MobileTest");
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		setUpDriver(driver,15);
			}
	@Before
	public void beforeEach() {
		goToUrl(driver, "http://live.guru99.com/index.php");
		basePage = new BasePageG(driver);
		mobilePage = new MobilePage(driver);
		detailPage = new DetailOfProductsPage(driver);
		cartPage = new ShoppingCart(driver);
		account = new AccountPage(driver);
		accountFunctions = new AccountFunctions(driver);
	}
	@After
	public void shutDown (){
		driver.quit();
	}
	@Ignore
	@Test
	public void verifyMobileSortedByName (){
		log.info("click link mobileMenu" );
		clickLink(basePage.getMobileMenu());
		log.info("sortBy Name in DropDownForMobile" );
		selectDropDownByIndex(driver, mobilePage.getSortByDropDownForMobile(),1);
		
		String expectedResult = "IPHONE";
		String actualResult = mobilePage.mobileProductNames.get(0).getText();
		log.info("get actual result" + actualResult);
		
		Assert.assertEquals("Wrong sorted should be IPhone",expectedResult,actualResult);
	
	}
	@Ignore
	@Test
	public void verifyCostOfMobileBetweenListPageAndDetailPage (){
		log.info("click link mobileMenu" );
		clickLink(basePage.getMobileMenu());
		String expectedCostListPageSonyXP = mobilePage.sonyXperiaPrice.getText();
		log.info("Save cost of Sony Xperia on ListPage " + expectedCostListPageSonyXP );
		
		log.info("click on sonyXperiaImageLink and go to detail page" );
		clickLink(mobilePage.sonyXperiaImageLink);
		String actualCostDetailPageSonyXP= detailPage.sonyXperiaPriceDetailPage.getText();
		log.info("Save cost of Sony Xperia on DetailPage " + actualCostDetailPageSonyXP );
		
		Assert.assertEquals("Product price in list and details page should be equal ($100)",
				expectedCostListPageSonyXP,actualCostDetailPageSonyXP );
		
	}
	@Ignore
	@Test 
	public void verifyAddingProductsToCart(){
		log.info("click link mobileMenu" );
		clickLink(basePage.getMobileMenu());
		log.info("click addToCartOfsonyXperia" );
		mobilePage.clickButtonAddToCartOfsonyXperia();
		String actualMessage = cartPage.messageAddedProductToCart.getText();
		log.info("message is appread " + actualMessage );
		String expectedPartOfMessage = "was added to your shopping cart.";
		
		Assert.assertTrue("Wrong Message should be " + expectedPartOfMessage, actualMessage.endsWith(expectedPartOfMessage));
	}
	@Ignore
	@Test
	public void verifyAddingProductsToCartMoreThenAvailable(){
		log.info("click link mobileMenu" );
		clickLink(basePage.getMobileMenu());
		log.info("click addToCartOfsonyXperia" );
		mobilePage.clickButtonAddToCartOfsonyXperia();
		
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
	@Ignore
	@Test
	public void verifyPossibilityCompareTwoMobile() throws InterruptedException{
		log.info("click link mobileMenu" );
		clickLink(basePage.getMobileMenu());
		log.info("click add To CompareList sonyXperia" );
		mobilePage.clickLinkAddToCompareSonyXperia();
		
		log.info("click add To CompareList Iphone" );
		mobilePage.clickButtonAddToCompareIphone();
		log.info("click compare Button" );
		mobilePage.clickCompareButton();
		
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
	@Ignore
	@Test
	public void verifyAccountCreation(){
		log.info("click link Myaccount" );
		basePage.clickMyAccountLinkHeader();
		clickButton(account.creatAccountButton);
		accountFunctions.createAccount(account);
		
		String expectedMessage = "Thank you for registering with Main Website Store.";
		String actualMessage = account.successMessageRegisteAccont.getText();
		Assert.assertEquals("Wrong title",expectedMessage, actualMessage);
	}
	
	@Ignore
	@Test
	public void shareWishList(){
		TVPage tvPage = new TVPage(driver);
		MyWishList myWishListPage = new MyWishList(driver);
		tvPage.clickAccountLink();
		tvPage.clickMyAccountLinkHeader();
		accountFunctions.loginAsValidUser(account);
		
		tvPage.clickTvMenu();
		tvPage.clickAddToWishList("4");
		myWishListPage.clickShareWishlistButton();
		myWishListPage.setTextEmailToShare("gdhhhh@gmail.com, gdgfg@gmail.com");
		myWishListPage.setTextMessageField("to share");
		
		myWishListPage.clickShareWishlist();
		String expectedResult = "Your Wishlist has been shared.";
		Assert.assertEquals(expectedResult, myWishListPage.getSharedResult());
		
	}

	@Ignore
	@Test
	public void verifyEnteredTextInSearchField(){
		basePage.setTextInSearchField("alla");
		String actualResult = basePage.getSearchField().getAttribute("value");
		System.out.println(actualResult);
		Assert.assertEquals("Wrong text", "alla", actualResult);
	}
	

	@Test
	public void verifyAllOptionInDropDown(){
		basePage.clickMobileMenu();
		List <String> listSort = mobilePage.getOptionSortByMobile();
		ArrayList<String> actualList = new ArrayList<String>();
		
		for (int i = 0; i < listSort.size(); i++) { 		      
			actualList.add(listSort.get(i).trim());		
	      }  
		System.out.println("Elements are:"+actualList);
		List <String> expectedList = new ArrayList<String>(Arrays.asList("Position", "Name", "Price"));
		Assert.assertArrayEquals(expectedList.toArray(),actualList.toArray());
	}
	

	@Test
	public void verifyDiscountCoupon(){
		mobilePage.clickMobileMenu();
		clickButton(mobilePage.getAddToCart("2"));
		mobilePage.setCouponCode();
		mobilePage.clickApplyButton();
		String expectedResult = "GURU50";
		
		Assert.assertTrue(mobilePage.getCouponResult().contains(expectedResult));
	}
	}

	

