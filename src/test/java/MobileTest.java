import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
import pageObjectGuru.CheckoutPage;
import java.io.BufferedInputStream;
//import java.net.URL;
//import org.apache.pdfbox.cos.COSDocument;
//import org.apache.pdfbox.pdfparser.PDFParser;
//import org.apache.pdfbox.pdmodel.PDDocument;

public class MobileTest {
	
	private static final Logger log = Logger.getLogger(MobileTest.class);
	
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
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olga Kh\\Desktop\\IDEA\\src\\main\\resources\\chromedriver.exe");
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
		driver.manage().deleteAllCookies();
	}
	@AfterClass
	public static void shutDown (){
		driver.quit();
	}

//	@Ignore
	@Test
	public void verifyMobileSortedByName (){
		log.info("run verifyMobileSortedByName" );
		log.info("click link mobileMenu" );
		clickLink(basePage.getMobileMenu());
		log.info("sortBy Name in DropDownForMobile" );
		selectDropDownByIndex(driver, mobilePage.getSortByDropDownForMobile(),1);
		
		String expectedResult = "IPHONE";
		String actualResult = mobilePage.mobileProductNames.get(0).getText();
		log.info("get actual result" + actualResult);
		
		Assert.assertEquals("Wrong sorted should be IPhone",expectedResult,actualResult);
	
	}
//	@Ignore
	@Test
	public void verifyCostOfMobileBetweenListPageAndDetailPage (){
		log.info(" run verifyCostOfMobileBetweenListPageAndDetailPage " );
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

	//@Ignore
	@Test
	public void verifyPossibilityCompareTwoMobile() throws InterruptedException{
		log.info("run verifyPossibilityCompareTwoMobile" );
		log.info("click link mobileMenu" );
		clickLink(basePage.getMobileMenu());
		String mainWindow = getMainWindowHandle(driver);
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
//		for(String popup : driver.getWindowHandles()) {
//			if (!popup.equals(mainWindow)) {
//				driver.close();
//				driver.switchTo().window(mainWindow);
//			}
//		}

        closeCurrentWindowAndSwitchToParent(driver,mainWindow);

		Assert.assertEquals("Wrong title",expectedTitle,actualTitle);
		Assert.assertEquals("Wrong mobile1",expectedMobile1,actualMobile1);
		Assert.assertEquals("Wrong mobile2",expectedMobile2,actualMobile2);
	}
	@Ignore
	@Test
	public void verifyAccountCreation(){
		log.info("run verifyAccountCreation" );
		basePage.clickAccountLink();
		log.info("click link Myaccount" );
		basePage.clickMyAccountLinkHeader();
		account.clickCreatAccountButton();
		accountFunctions.createAccount(account);
		
		String expectedMessage = "Thank you for registering with Main Website Store.";
		String actualMessage = account.successMessageRegisteAccont.getText();
		Assert.assertEquals("Wrong title",expectedMessage, actualMessage);
	}
	
	//@Ignore
	@Test
	public void shareWishList(){
		log.info("run shareWishList" );
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

	//@Ignore
	@Test
	public void verifyEnteredTextInSearchField(){
		log.info("run verifyEnteredTextInSearchField" );
		basePage.setTextInSearchField("alla");
		String actualResult = basePage.getSearchField().getAttribute("value");
		System.out.println(actualResult);
		Assert.assertEquals("Wrong text", "alla", actualResult);
	}
	
	//@Ignore
	@Test
	public void verifyAllOptionInDropDown(){
		log.info("run verifyAllOptionInDropDown" );
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
    public void verifyPlaceOfOrder(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        log.info("run TEST verifyPlaceOfOrder" );
        log.info("goToMyAccount" );
        accountFunctions.goToMyAccount();
        log.info("login as user" );
        accountFunctions.loginAsValidUser(account);

        log.info("go to mobileMenu" );
        mobilePage.clickMobileMenu();
        log.info("add to cart sonyXperia" );
        mobilePage.clickButtonAddToCartOfsonyXperia();

        log.info("click procced to CheckOut" );
        cartPage.clickProccedToCheckOutButton();
        log.info("click continue in Billing Info" );
        checkoutPage.clickContinueButtonBillingInformation();

        log.info("click continue in Shipping method" );
        checkoutPage.clickContinueButtonShippingMethod();
        log.info("set check Money radio button" );
        checkoutPage.clickCheckMoneyPaymentRadioButton();

        log.info("click continue Payment Info" );
        checkoutPage.clickContinueButtonPaymentInfo();

        log.info(" Procced To CheckOut Button" );
        checkoutPage.clickProccedToCheckOutButton();

        String expectedResult = "Your order";

        Assert.assertTrue("Order was not reseved",
                checkoutPage.getOrderNumberMessage().contains(expectedResult));
    }

	}

