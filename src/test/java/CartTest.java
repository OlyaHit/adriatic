/**
 * Created by Olga Kh on 12.10.2017.
 */
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static helpers.WebLibrary.*;

import pageObjectGuru.BasePageG;
import pageObjectGuru.MobilePage;
import pageObjectGuru.ShoppingCart;

public class CartTest {
    private static final Logger log = Logger.getLogger(MobileTest.class);

    public static  WebDriver driver;

    @BeforeClass
    public static void beforeAll(){
        log.info("Running suite: CartTest");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        setUpDriver(driver,15);
    }
    @Before
    public void beforeEach() {
        goToUrl(driver, "http://live.guru99.com/index.php");
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public static void shutDown (){
        driver.quit();
    }

    @Test
    public void verifyAddingProductsToCart(){

        BasePageG basePage = new BasePageG(driver);
        MobilePage mobilePage = new MobilePage(driver);
        ShoppingCart cartPage = new ShoppingCart(driver);

        log.info(" run verifyAddingProductsToCart" );
        log.info("click link mobileMenu" );
        clickLink(basePage.getMobileMenu());
        log.info("click addToCartOfsonyXperia" );
        mobilePage.clickButtonAddToCartOfsonyXperia();

        String actualMessage = cartPage.messageAddedProductToCart.getText();
        log.info("message is appread " + actualMessage );
        String expectedPartOfMessage = "was added to your shopping cart.";

        Assert.assertTrue("Wrong Message should be " + expectedPartOfMessage,
                actualMessage.endsWith(expectedPartOfMessage));
    }

    @Test
    public void verifyAddingProductsToCartMoreThenAvailable(){
        BasePageG basePage = new BasePageG(driver);
        MobilePage mobilePage = new MobilePage(driver);
        ShoppingCart cartPage = new ShoppingCart(driver);

        log.info("run verifyAddingProductsToCartMoreThenAvailable" );
        log.info("click link mobileMenu" );
        clickLink(basePage.getMobileMenu());
        log.info("click addToCartOfsonyXperia" );
        mobilePage.clickButtonAddToCartOfsonyXperia();

        log.info("type 501 quantity in cart" );
        cartPage.setQuantityInField("501");
        log.info("wait element to be click" );
        waitElementToBeClickable(driver, 10, cartPage.getButtonUpdate());
        log.info("click update button" );
        cartPage.clickUpdateButton();

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
    public void verifyDiscountCoupon(){
        MobilePage mobilePage = new MobilePage(driver);
        log.info("run verifyDiscountCoupon" );
        mobilePage.clickMobileMenu();
        mobilePage.clickAddToCart("2");
        mobilePage.setCouponCode();
        mobilePage.clickApplyButton();
        String expectedResult = "GURU50";

        Assert.assertTrue(mobilePage.getCouponResult().contains(expectedResult));
    }

    @Test
    public void changeQTYInCart(){
        MobilePage mobilePage = new MobilePage(driver);
        ShoppingCart cart = new ShoppingCart(driver);
        log.info("run changeQTYInCart" );
        log.info("go to mobiles" );
        mobilePage.clickMobileMenu();

        log.info("add to cart mobile" );
        mobilePage.clickAddToCart("1");
        log.info("change QTY to 10" );
        cart.setQuantityInField("10");
        log.info("click update" );
        waitElementToBeClickable(driver,10,cart.getButtonUpdate());
        cart.clickUpdateButton();

        String expectedPrice = "1,000";

        Assert.assertTrue("Wrong price: ",
                cart.getSubTotalPrice().contains(expectedPrice));

    }
}
