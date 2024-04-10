package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class StudentPage 
{
    public WebDriver driver;
    WaitHelper waitHelper;
    
    public StudentPage(WebDriver rdriver) 
    {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
        waitHelper = new WaitHelper(rdriver);
    }

    // Page Objects

	@FindBy(xpath = "//div[@class='Cards_cardDetails__WsZ-E']//h6[text()='School leaving certificate']")
	@CacheLookup
	WebElement schoolLeavingCertificateButton;
	
	@FindBy(xpath = "//button[@body='Generate']")
	@CacheLookup
	WebElement generateCertificateButton;
	
	@FindBy(xpath = "//span[@data-qa='icon-close']")
	@CacheLookup
	WebElement previewCloseButton;	

	// Action Methods	
    
    public void clickSchoolLeavingCertificateButton() 
    {
    	waitHelper.waitForVisibility(schoolLeavingCertificateButton, Duration.ofSeconds(15));
    	schoolLeavingCertificateButton.click();
    }
    
    public void clickGenerateCertificateButton() 
    {
    	waitHelper.waitForVisibility(generateCertificateButton, Duration.ofSeconds(15));
    	generateCertificateButton.click();
    }
    
    public void clickPreviewCloseButton() 
    {
    	waitHelper.waitForVisibility(previewCloseButton, Duration.ofSeconds(15));
    	previewCloseButton.click();
    }
}
