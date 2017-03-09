package helpers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.By;
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
	public  static void newWait (WebDriver driver, long seconds, ExpectedCondition <Boolean>condition){
		(new WebDriverWait(driver, seconds)).until(condition);
	}
	
	
	@Step("Move mouse to element")
	public static void moveMouse (Actions actions,WebDriver driver,WebElement element){
		actions = new Actions(driver);
		actions.moveToElement(element);
		actions.build().perform();
	}

	@Step("Move mouse to element and click")
	public static void moveAndClickMouse (Actions actions, WebDriver driver,WebElement element){
		actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click().build().perform();
	}
	
	//good method
	@Step("Is Element Present \"{1}\"")
	public static boolean isElementPresent (WebDriver driver, String xpath) throws Exception{
		
		List <WebElement> elements = driver.findElements(By.xpath(xpath));
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
	
	@Step("Switch to frame")
	public static void switchToFrame(WebDriver driver, WebElement elem){
		driver.switchTo().frame(elem);
	}
	
	@Step("Switch to default frame")
	public static void switchToDefaultFrame (WebDriver driver){
		driver.switchTo().defaultContent();
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
	
//	public void selectComboValue(String elementId, String value) {
//	    Select selectBox = new Select(findElement(By.id(elementId)));
//	    select.SelectByText("Option3");
//	    selectBox.selectByValue(value);
//	}
}
