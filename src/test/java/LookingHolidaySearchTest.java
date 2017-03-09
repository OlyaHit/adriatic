import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import businessFunctions.AdvancedSearchParams;
import businessFunctions.BasicSearchParams;
import businessFunctions.SearchTrip;
import pageObjects.AccomodationSearchPage;
import static helpers.WebLibrary.*;
import helpers.Rules;

import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Title("suite:Looking Holiday Search")
@Description("Looking Holiday Search:")
@Features("Search")
@Stories("Looking Holiday Search")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LookingHolidaySearchTest {

	private static final Logger log = Logger.getLogger(LookingHolidaySearchTest.class);
	public WebDriver driver = new FirefoxDriver();
	public AccomodationSearchPage searchPage = new AccomodationSearchPage(driver);
	public SearchTrip searchTrip = new SearchTrip(driver);

	@Rule
	public Rules rules = new Rules(driver);

	@BeforeClass
	public static void beforeAll(){
		log.info("Running suite: LookingHolidaySearchTest");
	}

	@Before
	public void beforeEach() {
		setUpDriver(driver, 30);
		goToUrl(driver, "http://www.adriatic.hr/");
	}

	@Title("Private Accommodation Search")
	@Description("Private Accommodation Search description")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void privateAccommodationSearch(){
		log.info("Running test - privateAccommodationSearch: \n");	
		BasicSearchParams basicParams = new BasicSearchParams();
		basicParams.accomodationBasicSearch = "private";
		basicParams.numberOfPersons="3";
		basicParams.location = "Istria";
		
		searchTrip.privateSearch(basicParams);
		clickButton(searchPage.searchButton); 
		
		int res = searchPage.searchResult.size();//camelCase
		log.info("Search results equals " + res + "\n");
	    Assert.assertTrue("Search results equals " + res + ", should be more than 0", res > 0);	
	}
	
	@Title("Private Accommodation Search with anvanced options")
	@Description("Private Accommodation Search with anvanced options description")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void privateAccommodationSearchWithAdvandcedSearch(){
		BasicSearchParams basicParams = new BasicSearchParams();
		AdvancedSearchParams params = new AdvancedSearchParams();
		
		basicParams.numberOfPersons = "2";
		basicParams.location = "Istria";
		params.accomodationType = "appartment";
		params.numberOfBedrooms = "2";
		params.priceFrom = "100";
		params.priceTo = "1000";
		params.additionalServices = "wifi";
		params.category = "booking";
		params.isLandorMainland = "mainland";
		params.location = "Istria";

		searchTrip.privateSearch(basicParams);
		searchTrip.privateAdvancedSearch(params);
		
		int res = searchPage.searchResult.size();
		log("Search results equals " + res + "\n");
	    Assert.assertTrue("Search results equals " + res + ", should be more than 0", res > 0);
	}
	
	@Title("Hotel Accommodation Search")
	@Description("Hotel Accommodation Search description")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void hotelAccommodationSearch(){
		log.info("Running test - privateAccommodationSearch: \n");	
		BasicSearchParams basicParams = new BasicSearchParams();
		basicParams.accomodationBasicSearch = "hotels";
		basicParams.numberOfPersons="2";
		basicParams.category="4";
		basicParams.hotelsDestination="Kvarner";
		
		searchTrip.hotelsOrVilligeSearch(basicParams);
		clickButton(searchPage.searchButton);
		
		int res = searchPage.SearchResultHotels.size();
		log.info("Search results equals " + res + "\n");
	    Assert.assertTrue("Search results equals " + res + ", should be more than 0", res > 0);	
	}
	
	@Title("Hotel Accommodation Search with anvanced options")
	@Description("Hotel Accommodation Search with anvanced options description")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void hotelAccommodationWithAdvandcedSearch(){
		log.info("hotelAccommodationWithAdvandcedSearch: \n");	
		BasicSearchParams basicParams = new BasicSearchParams(); 
		AdvancedSearchParams params = new AdvancedSearchParams();
		
		basicParams.accomodationBasicSearch = "hotels";
		basicParams.numberOfPersons="2";
		basicParams.category="4";
		basicParams.hotelsDestination="Istra";
		
		params.beachDistance="200";
		params.otherCriteria="pool";
		
		searchTrip.hotelsOrVilligeSearch(basicParams);
		searchTrip.hotelAndVillageAdvancedSearch(params);
	
		
		int res = searchPage.SearchResultHotels.size();
		log.info("Search results equals " + res + "\n");
	    Assert.assertTrue("Search results equals " + res + ", should be more than 0", res > 0);	
	}

	@Title("Villages Accommodation Search")
	@Description("Villages Accommodation Search description")
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void villagesAccommodationSearch(){
		log.info("Running test - villagesAccommodationSearch: \n");	
		BasicSearchParams basicParams = new BasicSearchParams();
		basicParams.accomodationBasicSearch = "village";
		basicParams.numberOfPersons="2";
		basicParams.category="4";
		basicParams.hotelsDestination="Istra";
		
		searchTrip.hotelsOrVilligeSearch(basicParams);
		clickButton(searchPage.searchButton);
		
		int res = searchPage.SearchResultHotels.size();
		log.info("Search results equals " + res + "\n");
	    Assert.assertTrue("Search results equals " + res + ", should be more than 0", res > 0);	
	}
	
	@Title("Villages Accommodation Search with anvanced options")
	@Description("Villages Accommodation Search with anvanced options description")
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void villagesAccommodationWithAdvandcedSearch(){
		log.info("Running test - villagesAccommodationWithAdvandcedSearch: \n");	
		BasicSearchParams basicParams = new BasicSearchParams();
		AdvancedSearchParams advanceParams = new AdvancedSearchParams();
		
		basicParams.accomodationBasicSearch = "village";
		basicParams.numberOfPersons="2";
		basicParams.category="4";
		basicParams.hotelsDestination="Istra";
		
		advanceParams.beachDistance = "200";
		advanceParams.otherCriteria = "parking";	
		
		searchTrip.hotelsOrVilligeSearch(basicParams);
		searchTrip.hotelAndVillageAdvancedSearch(advanceParams);
		
		int res = searchPage.SearchResultHotels.size();
		log.info("Search results equals " + res + "\n");
	    Assert.assertTrue("Search results equals " + res + ", should be more than 0", res > 0);	
	}

	@Title("Yacht Accommodation Search")
	@Description("Yacht Accommodation Search description")
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void yachtAccommodationSearch(){
		log.info("Running test - yachtAccommodationSearch: \n");	
		BasicSearchParams basicParams = new BasicSearchParams();
		basicParams.accomodationBasicSearch = "yacht";
		basicParams.numberOfCabin="2";
		basicParams.yachtCategory="sailboats";
		basicParams.yachtModel="131";
		basicParams.port="5";
		
		searchTrip.yachtSearch(basicParams);
		clickButton(searchPage.searchButton);
		
		int res = searchPage.SearchResultHotels.size();
		log.info("Search results equals " + res + "\n");
	    Assert.assertTrue("Search results equals " + res + ", should be more than 0", res > 0);	
	}
	
	@Title("Yacht Accommodation Search with anvanced options")
	@Description("Yacht Accommodation Search with anvanced options description")
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void yachtAccommodationAdvancedSearch(){
		log.info("Running test - yachtAccommodationSearch: \n");	
		BasicSearchParams basicParams = new BasicSearchParams();
		AdvancedSearchParams advanceParams = new AdvancedSearchParams();
		
		basicParams.accomodationBasicSearch = "yacht";
		basicParams.numberOfCabin="2";
		basicParams.yachtCategory="sailboats";
		basicParams.yachtModel="131";
		basicParams.port="5";
		advanceParams.weeklyPrice = "-1000";
		
		searchTrip.yachtSearch(basicParams);
		searchTrip.yachtAdvancedSearch(advanceParams);
		
		int res = searchPage.SearchResultHotels.size();
		log.info("Search results equals " + res + "\n");
	    Assert.assertTrue("Search results equals " + res + ", should be more than 0", res > 0);	
	}
}
