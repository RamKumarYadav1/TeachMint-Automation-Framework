package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class LoginPage 
{
    public WebDriver driver;
    WaitHelper waitHelper;
    
    public LoginPage(WebDriver rdriver) 
    {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
        waitHelper = new WaitHelper(rdriver);
    }

    // Page Objects
    
	@FindBy(xpath="//input[@id='user-input']")
	@CacheLookup
	WebElement userNameTextBox;

	@FindBy(xpath = "//input[@id='send-otp-btn-id']")
	@CacheLookup
	WebElement nextButton;
	
	@FindBy(xpath = "//div//span[contains(text(),'Login with password')]")
	@CacheLookup
	WebElement loginWithPasswordLink;
	
	@FindBy(xpath = "//input[@id='login-password']")
	@CacheLookup
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[@id='submit-otp-btn-id']")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(text(),'@Automation-2')]")
	@CacheLookup
	WebElement automationUserProfile;


	// Action Methods
	
    public void setUserName(String username) 
    {
    	waitHelper.waitForVisibility(userNameTextBox, Duration.ofSeconds(15));
    	userNameTextBox.clear();
    	userNameTextBox.sendKeys(username);
    }
    
    public void clickNextButton() 
    {
    	waitHelper.waitForVisibility(nextButton, Duration.ofSeconds(15));
    	nextButton.click();
    }
    
    public void clickLoginWithPasswordLink() 
    {
    	waitHelper.waitForVisibility(loginWithPasswordLink, Duration.ofSeconds(15));
    	loginWithPasswordLink.click();
    }
    
    public void setPassword(String password) 
    {
    	waitHelper.waitForVisibility(passwordTextBox, Duration.ofSeconds(15));
    	passwordTextBox.clear();
    	passwordTextBox.sendKeys(password);
    }    
      
    public void clickLoginButton() 
    {
    	waitHelper.waitForVisibility(loginButton, Duration.ofSeconds(15));
    	loginButton.click();
    }    

    public void clickAutomationUserProfile() 
    {
    	waitHelper.waitForVisibility(automationUserProfile, Duration.ofSeconds(15));
    	automationUserProfile.click();
    }
}
