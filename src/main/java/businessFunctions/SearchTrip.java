package businessFunctions;

import static helpers.WebLibrary.*;
import pageObjects.AccomodationSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.*;

public class SearchTrip {
	
	public AccomodationSearchPage searchPage;
	public SearchTrip(WebDriver driver) {
		searchPage = new AccomodationSearchPage(driver);
	}

	@Step("Private Search:")
	public void privateSearch(BasicSearchParams basicParameters){
		selectEndDate();
		selectNumberOfPersons(basicParameters.numberOfPersons);
		selectLocation(basicParameters.location);
	}
	
	@Step("Hotels Or Village Search:")
	public void hotelsOrVilligeSearch(BasicSearchParams basicParameters){
		selectAccomodationInDropDown(basicParameters.accomodationBasicSearch);
		selectEndDate();
		selectNumberOfPersons(basicParameters.numberOfPersons);
		
		log("Select category \"" + basicParameters.category + "\"");
		Select category = new Select(searchPage.HotelsCategory);
		category.selectByValue(basicParameters.category);
		
		log("select location \"" + basicParameters.hotelsDestination + "\"");
		Select hotelsLocation = new Select(searchPage.HotelsDestination);
		hotelsLocation.selectByValue(basicParameters.hotelsDestination);
	}
	
	@Step("Private Advanced Search:")
	public void privateAdvancedSearch(AdvancedSearchParams parameters) {
		log("click AdvancedSearchLink ");
		clickLink(searchPage.AdvancedSearchLink);

		selectAccomodationType(parameters.accomodationType);

		log("select bedrooms \"" + parameters.numberOfBedrooms + "\"");
		Select bedroom = new Select(searchPage.BedroomsDropDown);
		bedroom.selectByValue(parameters.numberOfBedrooms);

		log("select FromPrice \"" + parameters.priceFrom + "\"");
		setTextIntoWebElement(searchPage.FromPrice, parameters.priceFrom);
		log("select ToPrice \"" + parameters.priceTo + "\"");
		setTextIntoWebElement(searchPage.ToPrice, parameters.priceTo);

		selectAdditionalServices(parameters.additionalServices);
		selectCategory(parameters.category);
		selectIslandormainland(parameters.isLandorMainland);
		selectLocation(parameters.location);
		startSearch();
	}
	
	@Step("Hotels and Village Advanced Search:")
	public void hotelAndVillageAdvancedSearch(AdvancedSearchParams parameters){
		log("click AdvancedSearchLink ");
		clickWebElement(searchPage.AdvancedSearchLink);

		selectOtherCriteria(parameters.otherCriteria);
		log("select distance to the beach \"" + parameters.beachDistance + "\"");
		Select distance = new Select(searchPage.Beachdistance);
		distance.selectByValue(parameters.beachDistance);
		startSearch();
	}

	@Step("Yacht Search:")
	public void yachtSearch (BasicSearchParams basicParameters){
		selectAccomodationInDropDown(basicParameters.accomodationBasicSearch);
		selectEndDate();
		
		log("select numberOf cabin \"" + basicParameters.numberOfCabin + "\"");
		Select cabins = new Select(searchPage.numberOfCabinsDropDown);
		cabins.selectByValue(basicParameters.numberOfCabin);
		
		log("Select yachtCategory \"" + basicParameters.yachtCategory + "\"");
		Select yachtCategory = new Select(searchPage.yachtCategoryDropDown);
		yachtCategory.selectByValue(basicParameters.yachtCategory);
		
		log("select yachtModel \"" + basicParameters.yachtModel + "\"");
		Select yachtModel = new Select(searchPage.yachtModelDropDown);
		yachtModel.selectByValue(basicParameters.yachtModel);
		
		log("select port \"" + basicParameters.port + "\"");
		Select port = new Select(searchPage.portDropDown);
		port.selectByValue(basicParameters.port);
	}
	
	@Step("Yacht Advanced Search:")
	public void yachtAdvancedSearch(AdvancedSearchParams parameters){
		log("click AdvancedSearchLink ");
		clickWebElement(searchPage.AdvancedSearchLink);
		
		log("select weekly price \"" + parameters.weeklyPrice + "\"");
		Select weeklyPrice = new Select(searchPage.yachtWeeklyPriceDropDown);
		weeklyPrice.selectByValue(parameters.weeklyPrice);
		startSearch();
	}
	
	@Step("Rent Car Search:")
	public void rentCarSearch(BasicSearchParams basicParameters){
		selectAccomodationInDropDown(basicParameters.accomodationBasicSearch);
		selectEndDate();
		
		log("select pickupLocation \"" + basicParameters.pickupLocationRantCar + "\"");
		Select pickupLocation = new Select(searchPage.pickupLocationRantCarDropDown);
		pickupLocation.selectByValue(basicParameters.pickupLocationRantCar);
		
		log("Select returnLocation \"" + basicParameters.returnLocation + "\"");
		Select returnLocation = new Select(searchPage.returnLocationRantCarDropDown);
		returnLocation.selectByValue(basicParameters.returnLocation);
		startSearch();
	}
	
	@Step("Calculation Reservation:")
	public void calculationReservation(ReservationParams reservationParameters) throws InterruptedException{
		log("click beachAccommodation");
		clickWebElement(searchPage.beachAccommodation);
		
		log("click detailedPresentationButton");
		clickButton(searchPage.detailedPresentationButton);
		
		log("select number of adults from dropdown \"" + reservationParameters.numberOfAdults + "\"");
		Select adults = new Select(searchPage.adultsDropDown);
		adults.selectByValue(reservationParameters.numberOfAdults);
		
		log("select number of children < 4years from dropdown \"" + reservationParameters.numberOfChildren + "\"");
		Select children = new Select(searchPage.childrenDropDown);
		children.selectByValue(reservationParameters.numberOfChildren);
		
		log("select arrival date");
		clickWebElement(searchPage.arrivalDateForCalculation);
		clickWebElement(searchPage.startDateForCalculation);
		
		log("select depature date");
		clickWebElement(searchPage.depatureDateForCalculation);
		clickWebElement(searchPage.endDateForCalculation);
		
		Thread.sleep(3000);
		log("click continue button");
		clickWebElement(searchPage.continueButton);
		
		if(reservationParameters.isNewUser == true){
			reserveAccommodationNewUser(reservationParameters);
		}else{
			reserveAccommodationExistingUser(reservationParameters);
		}
		
	}
	
	@Step("Reserve Accommodation Existing User \"{0}\"")
	public void reserveAccommodationExistingUser(ReservationParams reservationParameters) throws InterruptedException{
		setCheckBoxState(searchPage.existingUserCheckBox, "checked");

		log("Select emailExistingUser \"" + reservationParameters.emailExistingUser + "\"");
		setTextIntoWebElement(searchPage.existingUserEmail, reservationParameters.emailExistingUser);

		log("Select passwordExistingUser \"" + reservationParameters.passwordExistingUser + "\"");
		setTextIntoWebElement(searchPage.passwordExistingUser, reservationParameters.passwordExistingUser);

		clickButton(searchPage.continueButtonExistingUser);
		setCheckBoxState(searchPage.confirmAgreementCheckBox, "checked");
		//Thread.sleep(3000);
		clickButton(searchPage.continueButtonForConfirmation);
	}
	
	@Step("Reserve Accommodation New User \"{0}\"")
	public void reserveAccommodationNewUser(ReservationParams reservationParameters){
		log("Select newUserName \"" + reservationParameters.newUserName + "\"");
		setTextIntoWebElement(searchPage.newUserName, reservationParameters.newUserName);

		log("Select newUserSurname \"" + reservationParameters.newUserSurname + "\"");
		setTextIntoWebElement(searchPage.newUserSurname, reservationParameters.newUserSurname);

		log("Select newUserphoneNumber \"" + reservationParameters.newUserphoneNumber + "\"");
		setTextIntoWebElement(searchPage.newUserphoneNumber, reservationParameters.newUserphoneNumber);

		log("Select newUserEmail \"" + reservationParameters.newUserEmail + "\"");
		setTextIntoWebElement(searchPage.newUserEmail,reservationParameters.newUserEmail);
		clickButton(searchPage.continueButtonNewUser);
	}
	
	@Step("Select Accomodation Type \"{0}\"")
	private void selectAccomodationType(String accomodationType) {
		if (accomodationType.toLowerCase() == "appartment") {
			setCheckBoxState(searchPage.ApartmentAccommodationType, "checked");
		} else if(accomodationType.toLowerCase() == "house") {
			setCheckBoxState(searchPage.HouseAccommodationType, "checked"); 
		}
	}
	
	@Step("Select Accomodation in dropdown \"{0}\"")
	private void selectAccomodationInDropDown(String accomodation) {

		if (accomodation.toLowerCase() != "private"){
			clickWebElement(searchPage.AccomodationDropdown);
		} else if (accomodation.toLowerCase() == "hotels") {
			clickWebElement(searchPage.AccomodationHotels);
		} else if (accomodation.toLowerCase() == "village") {
			clickWebElement(searchPage.AccomodationVacationVillages);
		} else if (accomodation.toLowerCase() == "yacht") {
			clickWebElement(searchPage.AccomodationYachtCharter);
		} else if (accomodation.toLowerCase() == "car") {
			clickWebElement(searchPage.AccomodationRentCar);
		}
	}

	@Step("Select Additional Services \"{0}\"")
	private void selectAdditionalServices(String additionalServices) {
		if (additionalServices.toLowerCase() == "wifi") {
			setCheckBoxState(searchPage.Wifi, "checked");
		} else if (additionalServices.toLowerCase() == "sea view") {
			setCheckBoxState(searchPage.SeaView, "checked"); 
		}
	}
	
	@Step("Select Category \"{0}\"")
	private void selectCategory(String category) {
		if (category.toLowerCase() == "kids") {
			setCheckBoxState(searchPage.FamilyWithKids, "checked");
		} else if(category.toLowerCase() == "booking") {
			setCheckBoxState(searchPage.OnlineBooking, "checked"); 
		}
	}
	
	@Step("Select Is land or main land \"{0}\"")
	private void selectIslandormainland(String islandormainland) {
		if (islandormainland.toLowerCase() == "mainland") {
			setCheckBoxState(searchPage.mainland, "checked");
		} else if(islandormainland.toLowerCase() == "bridge") {
			setCheckBoxState(searchPage.Landislandbridge, "checked"); 
		}
	}
	
	@Step("Select Other Criteria \"{0}\"")
	private void selectOtherCriteria(String otherCriteria) {		
		if (otherCriteria.toLowerCase() == "pool") {
			setCheckBoxState(searchPage.Pool, "checked");
		} else if (otherCriteria.toLowerCase() == "parking") {
			setCheckBoxState(searchPage.Parking, "checked");
		}  else if (otherCriteria.toLowerCase() == "families") {
			setCheckBoxState(searchPage.Forfamilies, "checked");
		}	
	}

	@Step("Select End Date")
	private void selectEndDate() {
		clickWebElement(searchPage.DepartureDate);
		clickWebElement(searchPage.EndDate);
	}
	
	@Step("Select Number Of Persons \"{0}\"")
	private void selectNumberOfPersons(String number) {
		setTextIntoWebElement(searchPage.Persons, number);
	}
	
	@Step("Select Location \"{0}\"")
	private void selectLocation(String location) {
		setTextIntoWebElement(searchPage.LocationSearch, location);
	}
	
	@Step("Start Search")
	private void startSearch() {
		clickButton(searchPage.searchButton);
	}
}
	

