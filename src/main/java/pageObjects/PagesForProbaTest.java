package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagesForProbaTest {
	public PagesForProbaTest(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//article[@class='searchObjectWrap']") 
		public List <WebElement> yachts;
		
		@FindBy(xpath="//a[text()='Sailboats']")
		public WebElement sailboatsLink;
	}
