package helpers;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.*;


public class WebLibrary {
	@Step("{0}")
	public static void log(String value) {
	
	}

	//common methods
	@Step("Open URL \"{1}\"")
	public static void goToUrl (WebDriver driver, String url){
		driver.get(url);
	}
	
	@Step("Maximize window")
	public static void maximazeWindow (WebDriver driver){
		driver.manage().window().maximize();
	}
	
	@Step("Set implicit wait to \"{1}\" sec")
	public static void setImplicitlyWait (WebDriver driver, long seconds ){
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	@Step("Setup driver: ")
	public static void setUpDriver(WebDriver driver, long seconds){
		maximazeWindow(driver);
		setImplicitlyWait(driver, seconds);
	}

	@Step("Enable logs in browser")
	public static WebDriver createFirefoxDriver(){
		LoggingPreferences logs = new LoggingPreferences();
		logs.enable(LogType.BROWSER, Level.WARNING);
		logs.enable(LogType.SERVER, Level.ALL);
		logs.enable(LogType.DRIVER, Level.SEVERE);
		logs.enable(LogType.PROFILER, Level.OFF);
		logs.enable(LogType.CLIENT, Level.ALL);

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);

		WebDriver driver = new FirefoxDriver(capabilities);
		return driver;
	}
	
	@Step("Wait Element Present for \"{1}\" seconds")
	public static void waitElementPresent(WebDriver driver,long seconds,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element)); 
	}
	
	@Step("Wait Element for \"{1}\" seconds")
	public  static void waitElementToBeClickable (WebDriver driver, long seconds, WebElement element ){
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//-----------------actions-------------
	@Step("Move mouse to element")
	public static void moveMouse (Actions actions,WebDriver driver,WebElement element){
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	@Step("Move mouse to element and click")
	public static void moveAndClickMouse (WebDriver driver,WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
	@Step("dragAndDrop element")
	public static void dragAndDrop(WebDriver driver,WebElement fromElement,WebElement toElement ){
		Actions actions = new Actions(driver);
		actions.dragAndDrop(fromElement, toElement).build().perform();
	}
	@Step("move slider")
	public static void moveSlider(WebDriver driver,WebElement element,int xOffset, int yOffset ){
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, xOffset, yOffset).perform();
	}
	
	//good method
	
	@Step("Is Element Present \"{1}\"")
	public static  boolean isElementPresentForList (WebDriver driver,List <WebElement> elements) throws Exception{
		
		List <WebElement> element1 = elements;
		int numberOfElements = element1.size();
		
		if (numberOfElements==0){
			return false;
		}else if (numberOfElements==1){
			return true;
			
		}else {
			throw new Exception("There are more than 1 elemnt with current locator on the page");
		}
	
	}
	
	@Step("Is Element Present \"{1}\"")
	public static  boolean isElementPresentForOneElement (WebDriver driver,WebElement element) throws Exception{
		
		List <WebElement> elements = new ArrayList<WebElement>();
		elements.add(element);
		int numberOfElements = elements.size();
		
		if (numberOfElements==0){
			return false;
		}else if (numberOfElements==1){
			return true;
		}else {
			throw new Exception("There are more than 1 elemnt with current locator on the page");
		}
	}
	
	@Step("Click web element")
	public static void clickWebElement(WebElement element){
		element.click();
	}
	
	@Step("Is Element Enabled")
	public static boolean isElementEnable (WebElement element){
		boolean Enable =  element.isEnabled();
		return Enable;
	}
	
	@Step("Is Element Displayed")
	public static boolean isElementDisplayed (WebElement element){
		boolean Displayed = element.isDisplayed();
		return Displayed;
	}
	
	@Step("Is Element Selected")
	public static boolean isElementSelected(WebElement element){
	
		boolean selected = element.isSelected();
		return selected;
		
	}

	@Step("Get Text from WebElement")
	public static String getTextFromWebElement (WebElement element) {
		
		String text = element.getText();
		return text;
	}

	@Step("Set Text into WebElement \"{1}\"")
	public static void setTextIntoWebElement(WebElement element, String text){
		element.click();
		clearTextField(element);
		log("Sending text \"" + text + "\" to element...");
		element.sendKeys(text);
	}
	
	@Step("Clear Text Field")
	public static void clearTextField(WebElement element){
		element.clear();
	}

	@Step("Click Link")
	public static void clickLink(WebElement link){
		link.click();
	}

	@Step("Click Button")
	public static void clickButton(WebElement button){
		button.click();
	}

	@Step("Get Radio Button State")
	public static boolean getRadioButtonState(WebElement radioButton){
		if (radioButton.isSelected()) {
			return true;
		} else {
			return false;
		}
	}
	
	@Step("Set Radio Button State")
	public static void setRadioButtonState(WebElement radioButton, String expectedState) {
		boolean actualState = getRadioButtonState(radioButton);

		 if (actualState == true && expectedState == "selected") {
			  log("RadioButton is already selected");
		  } else if (actualState == false && expectedState == "selected") {
			  clickWebElement(radioButton);
		  }
	}

	@Step("Get Checkbox State")
	public static boolean getCheckBoxState (WebElement checkbox){
		if (checkbox.isSelected()){
			return true;
		} else {
			return false;
		}
	}
	
	@Step("Set Checkbox State \"{1}\"")
	public static void setCheckBoxState (WebElement checkbox, String expectedState) {
		boolean actualState = getCheckBoxState(checkbox);
		
		  if (actualState == true && expectedState=="checked" ) {
			  log("checkbox is already checked");
		  } else if (actualState == true && expectedState == "unchecked"){
			  clickWebElement(checkbox);
		  } else if (actualState == false && expectedState =="checked"){
			  clickWebElement(checkbox);
		  }
		  else if (actualState == false && expectedState == "unchecked"){
			  log("checkbox is already unchecked");
		 }
	}

	@Step("Verify Checkbox State")
	public static void verifyCheckBoxState(WebElement checkbox, String expectedState) throws Exception {
		boolean actualState = getCheckBoxState(checkbox);
		boolean expectedStateBoolean;
		
		if (expectedState == "checked") {
			expectedStateBoolean = true;
		} else if (expectedState == "unchecked") {
			expectedStateBoolean = false;
		} else {
			throw new Exception ("Expected state has to be checked or uchecked only.");
		}
		
		if (actualState == expectedStateBoolean){
			 log("checkbox is " + expectedState + " as expected.");
			 
		} else {
			throw new Exception ("checkbox is not " + expectedState +
					" as expected. Actual value is " + actualState);
		}
	}

	@Step("Click combo box")
	public static void clickComboBox(WebElement comboBox){
		comboBox.click();
	}
	@Step("Accept Alert")
	public static void acceptAlert (WebDriver driver){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Step("Dismiss Alert")
	public static void dismissAlert (WebDriver driver){
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	@Step("Get Alert message")
	public static String getAllertMessageAndAccept(WebDriver driver){
		String message= null;
		try {
			Alert alert = driver.switchTo().alert();
			message = alert.getText();
			alert.accept();
		}catch(Exception e){
			message=null;
		}
		System.out.println("message"+message);
		return message;
	}
	
	@Step("Get Alert message")
	public static String getAllertMessageAndDismiss(WebDriver driver){
		String message= null;
		try {
			Alert alert = driver.switchTo().alert();
			message = alert.getText();
			alert.dismiss();
		}catch(Exception e){
			message=null;
		}
		System.out.println("message"+message);
		return message;
	}
	@Step("selectRadioButtonByValue \"{2}\"")
	public static void selectRadioButtonByValue(WebDriver driver, List<WebElement> elements, String value) {
		List<WebElement> select = elements;
		for (WebElement element : select) {
			if (element.getAttribute("value").equalsIgnoreCase(value)) {
				element.click();
			}
		}
	}
	
	@Step("selectDropdownByVisibleText \"{2}\"")
	public static void selectDropdownByVisibleText(WebDriver driver, WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}
	
	@Step("selectDropDownByIndex \"{2}\"")
	public static void selectDropDownByIndex(WebDriver driver, WebElement element, int index){
		new Select(element).selectByIndex(index);
	}
	
	@Step("selectDropDownByIndex \"{2}\"")
	public static void selectDropDownByValue(WebDriver driver, WebElement element, String value){
		new Select(element).selectByValue(value);
	}
	
	public static void printSelectedOptionsInDropDown(WebDriver driver, WebElement element){
	List<WebElement> selectedOptions = new Select(element).getAllSelectedOptions();
	for (WebElement option : selectedOptions) {
		System.out.println(option.getText());
	}
	}
	//---------------//Windows------------
	@Step("getMainWindowHandle")
	public static String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}
	@Step("switchToAnotherWindow")
	public void switchBetweenWindows(WebDriver driver, String parentWindow){
		 for(String popup : driver.getWindowHandles()){
	            if (!popup.equals(parentWindow)){
	                driver.switchTo().window(popup);
	            }
	        } 
	}
	@Step("getCurrentWindowTitle")
	public static String getCurrentWindowTitle(WebDriver driver) {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	@Step("waitForNewWindowAndSwitchToIt")
	public static void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
        String parentHandle = getMainWindowHandle(driver);
        String newWindowHandle = null;
        Set<String> allWindowHandles = driver.getWindowHandles();
        
        //Wait for 20 seconds for the new window and throw exception if not found
        for (int i = 0; i < 20; i++) {
            if (allWindowHandles.size() > 1) {
                for (String allHandlers : allWindowHandles) {
                    if (!allHandlers.equals(parentHandle))
                    	newWindowHandle = allHandlers;
                }
                driver.switchTo().window(newWindowHandle);
                break;
            } 
        }
        if (parentHandle == newWindowHandle) {
            throw new RuntimeException(
                    "Time out - No window found");
        }
    }
	
	@Step("Switch to frame ")
	public static void switchToFrameSmallMethod(WebDriver driver, WebElement elem){
		driver.switchTo().frame(elem);
	}
	
	@Step("Switch to default frame")
	public void switchtoDefaultFrame(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
			System.out.println("Navigated back to webpage from frame");
		} catch (Exception e) {
			System.out
					.println("unable to navigate back to main webpage from frame"
							+ e.getStackTrace());
		}
	}
	@Step("Switch to frame")
	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		try {
			if (isElementDisplayed(frameElement)) {
				driver.switchTo().frame(frameElement);
				System.out.println("Navigated to frame with element "+ frameElement);
			} else {
				System.out.println("Unable to navigate to frame with element "+ frameElement);
			}
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with element " + frameElement + e.getStackTrace());
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + frameElement + "is not attached to the page document" + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with element " + frameElement + e.getStackTrace());
		}
	}
	
	
	
	
	
	
	
	
	
}
	
	
	
	
/*	 Selecting CheckBox

	 public static void selectCheckboxes(WebDriver driver, By locator,String value)
	 {
	 List abc = driver.findElements(locator);
	 List list = new ArrayListArrays.asList(value.split(",")));
	 for (String check : list){
	 for (WebElement chk : abc){
	 if(chk.getAttribute("value").equalsIgnoreCase(check)){
	 chk.click();
	 }}}}*/

