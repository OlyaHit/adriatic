

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by ONUR BASKIRT on 13.08.2016.
 */
public class TurkishAirlinesDatePickerTest {

    static WebDriver driver;
    private String today;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
        driver.navigate().to("http://www.turkishairlines.com/tr-tr/");
        driver.manage().window().maximize();
    }

    @Test
    public void datePickerTest() {
        //Declare a implicit wait for synchronisation
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Get Today's number
        today = getCurrentDay();
        System.out.println("Today's number: " + today + "\n");

        //Click and open the datepickers
        driver.findElement(By.xpath("//input[@id='godate']")).click();

        //This is from date picker table
        WebElement dateWidgetFrom = driver.findElement(By.xpath("//div[@id='dateGo']/div[@class='dp-applied'][1]//table[@class='jCalendar']/tbody"));

        //This are the rows of the from date picker table
        //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));

        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));

        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: columns) {
            /*
            //If you want to click 18th Date
            if (cell.getText().equals("18")) {
            */
            //Select Today's Date
            if (cell.getText().equals("26")) {
                cell.click();
                break;
            }
        }

      
        driver.findElement(By.xpath("//input[@id='from']")).click();
        
    }

    //Close Driver


    //Get The Current Day
    private String getCurrentDay (){
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
}