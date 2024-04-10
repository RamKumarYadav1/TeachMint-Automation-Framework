package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class DashboardPage 
{
    public WebDriver driver;
    WaitHelper waitHelper;
    
    public DashboardPage(WebDriver rdriver) 
    {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
        waitHelper = new WaitHelper(rdriver);
    }

    // Page Objects
    
	@FindBy(xpath="//a[@href='/institute/dashboard/certificate-templates/student/']")
	@CacheLookup
	WebElement generateCertificateButton;


	// Action Methods
	
    public String getDashboardPageTitle() 
    {
    	return driver.getTitle();
    }
    
    public void clickGenerateCertificateButton() 
    {
    	waitHelper.waitForVisibility(generateCertificateButton, Duration.ofSeconds(15));
    	generateCertificateButton.click();
    }
}
