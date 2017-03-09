package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LiveChatPopup {

    public LiveChatPopup(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    //Email textfield
    @FindBy (name = "email")
    public WebElement LiveChatEmailField;

    //Username textfield
    @FindBy (name = "name")
    public WebElement LiveChatUsernameField;

    //Message textarea
    @FindBy (name = "message")
    public WebElement LiveChatMessageField;

    //Send button
    @FindBy (id = "sndmessagelnk")
    public WebElement LiveChatSendButton;

    //Error message
    @FindBy (css = ".error")
    public WebElement LiveChatErrorMessage;
}
