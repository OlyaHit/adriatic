package pageObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;


public class AccomodationSearchPage {

    public AccomodationSearchPage(WebDriver driver) {
    	 PageFactory.initElements(driver, this);
    }

    //Advanaced Search
    @FindBy(xpath = "//div[@class='homepageSearch']")
    public WebElement HomepageSearchForm;

    //Accomodation dropdown
    @FindBy(id = "accTypeSelected")
    public WebElement AccomodationDropdown;
    
    
    @FindBy(id="//label[@for='privateSearchForm_p_dist")
    public WebElement InMoreThanCheckBox;

    //Private Accomodation item
    @FindBy(xpath = "//ul/li[contains(@class, \"private\")]")
    public WebElement AccomodationPrivate;

    //Accomodation item Hotels
    @FindBy(css = ".hotel")
    public WebElement AccomodationHotels;

    //Accomodation item Vacation Villages
    @FindBy(xpath = "//ul/li[contains(@class, \"resort\")]")
    public WebElement AccomodationVacationVillages;

    //Accomodation item Yacht charter
    @FindBy(xpath = "//ul/li[contains(@class, \"charter\")]")
    public WebElement AccomodationYachtCharter;


    //Accomodation item rent a car
    @FindBy(xpath = "//ul/li[contains(@class, \"rentacar\")]")
    public WebElement AccomodationRentCar;


    //Arrival&departure dates
    @FindBy(id = "privateSearchForm_to_visual")
    public WebElement ArrivalDate;

    @FindBy(xpath = "//input[contains(@id, 'SearchForm_to_visual')]")
    public WebElement DepartureDate;
    
    @FindBy(xpath = "//input[contains(@id, 'SearchForm_persons')]")
    public WebElement Persons;

    @FindBy(xpath = "//td[@data-handler=\"selectDay\"][2]")
    public WebElement TodayIcon;

    @FindBy(xpath = "//div[@class='ui-datepicker-group ui-datepicker-group-last']//tr[2]/td[1]")
    public WebElement EndDate;
    
    @FindBy(id="privateSearchForm_location")
    public WebElement LocationSearch;
    
    @FindBy(id ="ui-id-3")
    public WebElement Country;
    
    @FindBy(id="hotelSearchForm_category")
    public WebElement HotelsCategory;
    
    @FindBy(id="hotelSearchForm_destination")
    public WebElement HotelsDestination;
    
    @FindBy(xpath = "//select[@id='hotelSearchForm_beach_distance']")
    public WebElement Beachdistance;
    
    //SearchButton
    @FindBy(xpath = "//input[@value='Search']")
    public WebElement searchButton;
    
    @FindBy(xpath = "//div[@class='quickObjContent']")
    public List<WebElement> searchResult;
    
    @FindBy(xpath ="//article[@class='searchObjectWrap']")
    public List<WebElement> SearchResultHotels;
    
    @FindBy(xpath ="//div/a[@id='advancedSearch2']")
    public WebElement AdvancedSearchLink;
    
    //Accommodation type
    @FindBy(xpath="//label[@for='privateSearchForm_t_apartment']")
    public WebElement ApartmentAccommodationType;
    
    @FindBy(xpath="//label[@for='privateSearchForm_t_house']")
    public WebElement HouseAccommodationType;
    
    @FindBy(id="privateSearchForm_bedrooms")
    public WebElement BedroomsDropDown;
    
    @FindBy(id="privateSearchForm_prc_min")
    public WebElement FromPrice;
    		
    @FindBy(id="privateSearchForm_prc_max")
    public WebElement ToPrice;
    
    @FindBy(id="privateSearchForm_be_d']")
    public WebElement DistanceBeach;
    
    //Beach type
    @FindBy(xpath="//label[@for='privateSearchForm_be_t_sand']")
    public WebElement SandBeachType;
    
    @FindBy(xpath="//label[@for='privateSearchForm_be_t_pebble']")
    public WebElement pebbleBeachType;
    
    //Additional Services
    @FindBy(xpath="//label[@for='privateSearchForm_outer_view_sea']")
    public WebElement SeaView;
    
    @FindBy(xpath="//label[@for='privateSearchForm_inet']")
    public WebElement Wifi;
    
    //Category
    @FindBy(xpath="//label[@for='privateSearchForm_category_family_friendly']")
    public WebElement FamilyWithKids;
    
    @FindBy(xpath="//label[@for='privateSearchForm_ob']")
    public WebElement OnlineBooking;
    
    //Island or mainland
    @FindBy(xpath="//label[@for='privateSearchForm_land_mainland']")
    public WebElement mainland;
    
    @FindBy(xpath="//label[@for='privateSearchForm_land_island_bridge']")
    public WebElement Landislandbridge;
    
    @FindBy(xpath= "//input[@class='buttonNew large orange fRight']")
    public WebElement AdvancedSearchButton;
    
    //hotels-village search advanced
    //Other criteria
    
    @FindBy(xpath="//label[@for='hotelSearchForm_features_pool']")
    public WebElement Pool;
    
    @FindBy(xpath="//label[@for='hotelSearchForm_features_parking']")
    public WebElement Parking;
    
    @FindBy(xpath="//label[@for='hotelSearchForm_features_forfamilies']")
    public WebElement Forfamilies;
    
    //Yacht search
 
    @FindBy(id="charterSearchForm_cabins")
    public WebElement numberOfCabinsDropDown;
    
    @FindBy(id="charterSearchForm_category")
    public WebElement yachtCategoryDropDown;
    
    @FindBy(id="charterSearchForm_id")
    public WebElement yachtModelDropDown;
    
    @FindBy(id="charterSearchForm_port")
    public WebElement portDropDown;
   
    @FindBy(id="charterSearchForm_length")
    public WebElement yachtLengthDropDown;
    
    @FindBy(id="charterSearchForm_price")
    public WebElement yachtWeeklyPriceDropDown;
    
    @FindBy(id="rentaCarSearchForm_pickup")
    public WebElement pickupLocationRantCarDropDown;
    
    @FindBy(id="rentaCarSearchForm_return")
    public WebElement returnLocationRantCarDropDown;		
    
    //Calculation and Reservation
    @FindBy(xpath="//img[contains(@alt,'Visit Croatia')]")
    public WebElement beachAccommodation;
    
    @FindBy(xpath="(//a[contains(@class,'detailPresentLink')])[1]")
    public WebElement detailedPresentationButton;
    
    @FindBy(id="R_u_0_a1")
    public WebElement adultsDropDown;
    
    @FindBy(id="R_u_0_c3")
    public WebElement childrenDropDown;
    
    @FindBy(xpath="//a[contains(@class,'nextStep green')]")
    public WebElement continueButton;
    
    @FindBy(id="R_i_from_visual")
    public WebElement arrivalDateForCalculation;
    
    @FindBy(xpath="//div[@class='ui-datepicker-group ui-datepicker-group-first']//td[7]/a[text()='9']")
    public WebElement startDateForCalculation;
    
    @FindBy(id="R_i_to_visual")
    public WebElement depatureDateForCalculation;
    
    @FindBy(xpath="//div[@class='ui-datepicker-group ui-datepicker-group-first']//td[2]/a[text()='11']")
    public WebElement endDateForCalculation;
    
    @FindBy(css="label[for=R_u_type_old]")
    public WebElement existingUserCheckBox;
    
    @FindBy(id="R_user_login_username")
    public WebElement existingUserEmail;
    
    @FindBy(id="R_user_login_password")
    public WebElement passwordExistingUser;
    
    @FindBy(id="loginButton")
    public WebElement continueButtonExistingUser;
    
    @FindBy(xpath="//div[8]/input[@id='registerButton']")
    public WebElement continueButtonNewUser;
    
    @FindBy(css="label[for=R_conditions_agree]")
    public WebElement confirmAgreementCheckBox;
    
    @FindBy(id="orderinfo")
    public WebElement orderInfo;
    
    @FindBy(id="R_user_register_first_name")
    public WebElement newUserName;
    
    @FindBy(id="R_user_register_last_name")
    public WebElement newUserSurname;
    
    @FindBy(id="R_user_register_phone_number")
    public WebElement newUserphoneNumber;
    
    @FindBy(id="R_user_register_email")
    public WebElement newUserEmail;
    
    @FindBy(xpath="//a[contains(@data-nextstep,'4')]")
    public WebElement continueButtonForConfirmation;
    		
}
