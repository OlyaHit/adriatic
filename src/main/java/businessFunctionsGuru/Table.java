package businessFunctionsGuru;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Table {
	private WebDriver driver;
	
	public Table(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	//To locate table.
	@FindBy (xpath="//table[@name='BookTable']/tbody/")
	private WebElement webTable;
	
	@FindBy (xpath = "//table[@name='BookTable']/tbody/tr/th")
	private List <WebElement> allHeadersOfTable;
	
	 //To calculate of headers In table.
	public int getTotalHeaders(){
		return allHeadersOfTable.size();
	}
	
	public void getAllHeadersText() {
		for (WebElement headers : allHeadersOfTable) {
			System.out.println(headers.getText());
		}
	}
	
	@FindBy (xpath="//table[@name='BookTable']/tbody/tr")
	private List <WebElement> rowsTable;
	
	  //To calculate no of rows In table.
	  public int getRowCount (){
		  return rowsTable.size();
	  }

	//To locate column of table. 
	  public List <WebElement> getColumnsInRow (String indexOfRow) {
	    	return driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr["+indexOfRow+"]/td"));
	    }
	  
	  //method to get table content.
	  public String selectTableContent(int row, int column)
	  {
	    String content=driver.findElement(By.xpath("//table[@id='table1']//tr["+row+"]/td["+column+"]")).getText();
	    return content;
	  }
}
