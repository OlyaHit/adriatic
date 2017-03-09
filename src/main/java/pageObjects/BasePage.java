package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class BasePage {


	public BasePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    // ***Elements - Utility Bar***

	//Header
	
	@FindBy (id="serviceHeader")
	public WebElement header;
	
	// Body 
	@FindBy (id="serviceWrapper")
	public WebElement body;
	
	//Footer
	@FindBy (id="serviceFooter")
	public WebElement footer;
	
	
	
    //SignIn Form
    @FindBy(xpath = "//a[@id='signIn']/span[contains(text(),'Sign in')]")
    public WebElement SignInButton;

    @FindBy(id = "loginPopup")
    public WebElement LoginPopupWrapper;

    @FindBy(id = "signin_username")
    public WebElement EmailTextfield;

    @FindBy(id = "signin_password")
    public WebElement PasswordTextfield;
    
    @FindBy(id="forgetPass")
    public WebElement ForgotYourPassword; 
    
    @FindBy(xpath = "//div[@class='formInputInner']//a[text()='Cancel']")
    public WebElement CancelLoginButton;
    
    @FindBy( id="sfApplyResetRequest_username_or_email")
    public WebElement EmailFieldForResetPassword;
    
    @FindBy(xpath = "//div[@class='validationMessage']//li")
    public WebElement ValidationMessageAfterClickSendPassword;
    
  //Error message for reset password with invalid email
  
    @FindBy(xpath = "//div[@class='validationMessage']//li")
    public WebElement ErrorMessageResetPasswordWithInvalidEmail;
    
    @FindBy(xpath = "//input[@value='Send password']")
    public WebElement SendPasswordButton;

    @FindBy(id = "logInButton")
    public WebElement logInButton;
    
    @FindBy(id="userSignInSignOut")
    public WebElement UserSignInSignOut;
    
    @FindBy(xpath = "//a/span[contains(text(), 'Sign out')]")
    public WebElement SignoutButton;

    @FindBy(xpath = "//label[@for=\"signin_remember\"]")
    public WebElement RememberCheckbox;

    //Error message for login 
    @FindBy(xpath = "//div[@class='validationMessage']//li[contains(text(),'is invalid')]")
    public WebElement ErrorMessageLogin;
    

    //Register Form
    @FindBy(xpath = "//a/span[contains(text(),'Register')]")
    public WebElement RegisterButton;

   
    //Register form elements goes here
    
    @FindBy(xpath = "//select[@id='sfApplyApply_title']")
    public WebElement title;
   
    @FindBy(xpath = "//input[@id='sfApplyApply_first_name']")
    public WebElement name;
    
    @FindBy(xpath = "//input[@id='sfApplyApply_last_name']")
    public WebElement surname;
    
    @FindBy(xpath = "//select[@id='sfApplyApply_country']")
    public WebElement country;
    
    @FindBy(xpath = "//input[@id='sfApplyApply_email']")
    public WebElement email;
    
    @FindBy(xpath = "//input[@id='sfApplyApply_password']")
    public WebElement password;
    
    @FindBy(xpath = "//input[@id='sfApplyApply_password2']")
    public WebElement password2;
    
    @FindBy(xpath = "//select[@id='sfApplyApply_phone_type']")
    public WebElement phone;
    
    @FindBy(xpath = "//input[@id='sfApplyApply_phone_number']")
    public WebElement phoneNumber;
    
    @FindBy(xpath = "//span[@class='iconAdd']")
    public WebElement addAnotherButton;
    
    @FindBy(xpath = "//input[@id='sfApplyApply_newsletter']")
    public WebElement newsletterNotificationCheckbox;
    
    @FindBy(xpath = "//input[@value='Register']")
    public WebElement registerButton;
    
    @FindBy(xpath = "//a[@id='closeBtnRegister']")
    public WebElement cancelRegisterButton;
    
    @FindBy(xpath = "//div[@class='validationMessage']//li")
    public WebElement validationMessageWrongCode;
  
    
    //Shortlist Button
    
    @FindBy(xpath = "//a/span[@class='utilityTheIcon myFavHeart']")
    public WebElement ShortlistButton;
    
    //element for result of checking Shortlist smoke test
    @FindBy(xpath = "//h1[@class='pageTitle2']")
    public WebElement ShortlistResult;

    //CompareButton
    @FindBy(xpath = "//a/span[@class='utilityTheIcon compareIt']")
    public WebElement CompareButton;
    
  //element for result of checking CompareButton smoke test
    @FindBy(xpath = "//h1[@class='pageTitle2']")
    public WebElement CompareResult;
    
    //Live chat Button
    @FindBy(xpath = "//a/span[@class='utilityTheIcon liveChat']")
    public WebElement LiveChatButton;
    
    //Live chat title for result of smoke test LiveChatOnlineOpen
    @FindBy(id = "page-title")
    public WebElement pageTitleResult;

    //Language selector
    @FindBy(xpath = "//ul[@id='userLanguage']")
    public WebElement LanguageList;
    
    @FindBy(xpath = "//ul[@id='userLanguage']//span[@class='flagIcon flag-de']")
    public WebElement languageDeutsch;

    @FindBy(xpath = "//a[@class=\"languageChange\"]/span[contains(text(), \"English\")]")
    public WebElement LanguageEnglish;

    @FindBy(xpath = "//*[@id='userLanguage']/li/span[@class=\"flagIcon flag-en\"]")
    public WebElement SelectedEnglish;



    //   ***Elements - ServiceHeader***

    //Logo
    @FindBy(xpath = "//a[@id=\"logo\"]")
    public WebElement Logo;

    //CompanyInfo
    @FindBy(xpath = "//div[@class=\"bannerInfo\"]/a[contains(text(), \"About us\")]")
    public WebElement AboutUsLink;

    @FindBy(xpath = "//div[@class=\"bannerInfo\"]/a[contains(text(), \"Contact\")]")
    public WebElement ContactLink;

    @FindBy(xpath = "//div[@class=\"bannerInfo\"]/a[contains(text(), \"Guestbook\")]")
    public WebElement GuestbookLink;

    @FindBy(xpath = "//div[@class=\"bannerInfo\"]/a[contains(text(), \"Partners\")]")
    public WebElement PartnersLink;

    @FindBy(xpath = "//div[@class=\"bannerInfo\"]/a[contains(text(), \"Homeowners\")]")
    public WebElement Homeowners;

    //Tabs
    @FindBy(id = "homepageTab")
    public WebElement HomeTab;
    

    @FindBy(id = "privatepageTab")
    public WebElement PrivateAccomodationTab;
    
    @FindBy(id="privatepageMenu")
    public WebElement PrivateAccomodationMenu;

    @FindBy(xpath = "//a[@class='menuTitle'][contains(text(),'Hotels')]")
    public WebElement HotelsTab;
    
    @FindBy(xpath = " //div[@class='submenu tab2']")
    public WebElement  HotelsMenu;
 
    @FindBy(xpath = "//a[@class='menuTitle'][contains(text(),'Other services')]")
    public WebElement OtherServicesTab;
    
    @FindBy(xpath = " //div[@class='submenu tab3']")
    public WebElement  OtherServicesMenu;
    
    @FindBy(xpath = "//a[@class='menuTitle'][contains(text(),'Croatia')]")
    public WebElement CroatiaTab;
    
    @FindBy(id="menuCroatia")
    public WebElement CroatiaMenu;

    
    
    
    // ***Elements - ServiceFooter***

    //Wrapper
    @FindBy (id = "serviceFooter")
    public WebElement ServiceFooterWrapper;

    //Footer Payment
    @FindBy (css = ".footerPayment")
    public WebElement FooterPaymentWrapper;

    /*
    *Other service footer elements goes here
    */


    // ***Elements - BottomFooter***

    //Wrapper
    @FindBy (id = "footerBottomWrap")
    public WebElement BottomFooterWrapper;

    //Terms and conditions
    @FindBy(xpath = "//li/a[contains(text(), \"Website Terms and Conditions\")]")
    public WebElement TermsAndConditionsLink;

    /*
    *Other bottom footer elements goes here
    */

}
