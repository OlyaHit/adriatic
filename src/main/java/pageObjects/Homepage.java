package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends BasePage {

    public Homepage(WebDriver driver) {
        super(driver);
    }


    // ***Homepage Search***

    @FindBy(xpath = "//div[@class='homepageSearch']")
    public WebElement HomepageSearchForm;

    private void waitForVisibility(WebDriver driver, WebElement element) throws Error{
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }


    @FindBy(id="newsletter_email")
    public WebElement NewsletterEmailField;
    
    @FindBy(id="subscribeBtn")
    public WebElement SubscribeButtonNewsletter;
    
    @FindBy(id="newsletterSatus")
    public WebElement newsletterSatus;
    
    
    
    
    
    // ***Carousel***

    //Wrapper
    @FindBy(id = "carouselWrap")
    public WebElement HomepageCarouselWrapper;

    /*
    *Other Carousel elements goes here
    */


    // ***BoxWrap***
    // ***Left Content***
    // ***Sidebar Content***
    // ...


}
