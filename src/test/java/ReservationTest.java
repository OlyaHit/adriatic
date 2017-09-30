import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import businessFunctions.ReservationParams;
import businessFunctions.SearchTrip;
import pageObjects.AccomodationSearchPage;
import static helpers.WebLibrary.*;
import org.junit.runners.MethodSorters;
import ru.yandex.qatools.allure.annotations.*;
import helpers.Rules;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Title("suite:Reservation Test")
@Description("Reservation Functionality:")
@Features("Reservation")
@Stories("Reservation Test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReservationTest {

private static final Logger log = Logger.getLogger(LookingHolidaySearchTest.class);
	
	public WebDriver driver = new FirefoxDriver();
	public AccomodationSearchPage searchPage = new AccomodationSearchPage(driver);
	public SearchTrip searchTrip = new SearchTrip(driver);

	@Rule
	public Rules rules = new Rules(driver);

	@BeforeClass
	public static void beforeAll(){
		log.info("Running suite: ReservationTest");
	}

	@Before
	public void beforeEach() {
		setUpDriver(driver, 20);
		goToUrl(driver, "http://www.adriatic.hr/");
	}

	@Title("Calculation Reservation With Existing User")
	@Description("Should calculate Reservation for Existing User")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void calculationReservationWithExistingUser() throws InterruptedException{
		log.info("Running test - yachtAccommodationSearch: \n");
		ReservationParams reservationParameters = new ReservationParams();
		
		reservationParameters.numberOfAdults = "2";
		reservationParameters.numberOfChildren = "1";
		reservationParameters.emailExistingUser = "olyahit@gmail.com";
		reservationParameters.passwordExistingUser= "Good458";
	
		searchTrip.calculationReservation(reservationParameters);
		
		Assert.assertTrue("Order info is displayed:", isElementDisplayed(searchPage.orderInfo));	
	}

	@Title("Calculation Reservation With New User")
	@Description("Should calculate Reservation for new User")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void calculationReservationWithNewUser() throws InterruptedException{
		log.info("Running test - yachtAccommodationSearch: \n");
		ReservationParams reservationParameters = new ReservationParams();
		
		reservationParameters.numberOfAdults = "2";
		reservationParameters.numberOfChildren = "1";
		reservationParameters.isNewUser = true;
		reservationParameters.newUserName = "Katya";
		reservationParameters.newUserSurname = "Pushkareva";
		reservationParameters.newUserEmail = "kataryaP@gmail.com";
		reservationParameters.newUserphoneNumber = "+3808956545361245";
		
		searchTrip.calculationReservation(reservationParameters);
		
		Assert.assertTrue("Order info is displayed:", isElementDisplayed(searchPage.orderInfo));	
	}
}
