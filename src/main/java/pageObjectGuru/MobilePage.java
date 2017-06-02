package pageObjectGuru;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class MobilePage extends BasePageG {
	
	public MobilePage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//select[@title='Sort By']")
	public WebElement sortByDropDownForMobile;
	
	@FindBy(xpath="//h2[@class='product-name']//a")
	public List <WebElement> mobileProductNames;


}
