

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarSelection {
	private WebDriver driver;
	private String baseUrl;
	private String today;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

    @Test
	public void test1() {
		driver.get(baseUrl);
		// Click flights tab
		today = getCurrentDay();
		System.out.println("Current day "+ today);
		driver.findElement(By.id("tab-flight-tab")).click();
		// Find departing field
		WebElement departingField = driver.findElement(By.id("flight-departing"));
		departingField.sendKeys(today);	
	}
    
    @Test
	public void test2() {
		driver.get(baseUrl);
		// Click flights tab
		today = getCurrentDay2();
		System.out.println("Current day "+ today);
		driver.findElement(By.id("tab-flight-tab")).click();
		// Find departing field
		WebElement departingField = driver.findElement(By.id("flight-departing"));
		departingField.click();
		WebElement dateWidgetFrom = 
		driver.findElement(By.xpath("//div[2]/table[@class='datepicker-cal-weeks']/tbody[@class='datepicker-cal-dates'][1]"));

		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
		
		for(WebElement cell:columns){
			if(cell.getText().equals(today)){
				cell.click();
				break;
			}
		}	

    }
    
	
    //Get The Current Day
    private String getCurrentDay (){
    	 //get current date time with Date()
  	  Date date = new Date();
  	   
  	   // Create object of SimpleDateFormat class and decide the format
  	  DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
  	   
  	   // Now format the date
  	   String date1= dateFormat.format(date);
  	   return date1;
    }
    
    private String getCurrentDay2 (){
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH)+3;
        System.out.println("Today Int: " + todayInt +"\n");

        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");

        return todayStr;
  	   
    }
    
    
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}


