package pageObjectGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static helpers.WebLibrary.*;
/**
 * Created by Olga Kh on 12.10.2017.
 */
public class CheckoutPage extends BasePageG {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='billing-buttons-container']/button")
    private WebElement continueButtonBillingInformation;

    public void clickContinueButtonBillingInformation(){
        continueButtonBillingInformation.click();
    }

    @FindBy(xpath = "//*[@id='shipping-method-buttons-container']/button")
    private WebElement continueButtonShippingMethod;

    public void clickContinueButtonShippingMethod(){
        waitElementToBeClickable(driver,10,continueButtonShippingMethod);
        continueButtonShippingMethod.click();
    }

    @FindBy(xpath = "//*[@id='p_method_checkmo']")
    private WebElement checkMoneyPaymentRadioButton;

    public void clickCheckMoneyPaymentRadioButton(){
        waitElementToBeClickable(driver,10,checkMoneyPaymentRadioButton);
        setRadioButtonState(checkMoneyPaymentRadioButton, "selected");
    }

    @FindBy(xpath = "//*[@id='payment-buttons-container']/button")
    private WebElement continueButtonPaymentInfo;

    public void clickContinueButtonPaymentInfo(){
        continueButtonPaymentInfo.click();
    }

    @FindBy(xpath = "//button[contains(@class,'btn-checkout')]")
    private WebElement proccedToCheckOutButton;

    public void clickProccedToCheckOutButton(){
        waitElementToBeClickable(driver,10,proccedToCheckOutButton);
        proccedToCheckOutButton.click();
    }

    @FindBy(xpath = "//p[contains(text(),'Your order')]")
    private WebElement orderNumberMessage;

    public String getOrderNumberMessage(){
       return orderNumberMessage.getText();
    }

}
