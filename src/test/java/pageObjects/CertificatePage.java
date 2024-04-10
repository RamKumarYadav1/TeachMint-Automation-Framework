package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class CertificatePage 
{
    public WebDriver driver;
    WaitHelper waitHelper;
    
    public CertificatePage(WebDriver rdriver) 
    {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
        waitHelper = new WaitHelper(rdriver);
    }

    // Page Objects
    
	@FindBy(xpath="//input[@name='search']")
	@CacheLookup
	WebElement searchBar;

	@FindBy(xpath = "//button//div[text()='Generate']")
	@CacheLookup
	WebElement generateCertificateButton;
	
	@FindBy(xpath = "//input[@placeholder='Remarks']")
	@CacheLookup
	WebElement remarkTextBox;
	
	@FindBy(xpath = "//button[@id='download']")
	@CacheLookup
	WebElement downloadButton;
	
	// Action Methods
	
    public void setSearchBar(String name) 
    {
    	waitHelper.waitForVisibility(searchBar, Duration.ofSeconds(15));
    	searchBar.clear();
    	searchBar.sendKeys(name);
    }
    
    public void clickGenerateCertificateButton() 
    {
    	waitHelper.waitForVisibility(generateCertificateButton, Duration.ofSeconds(15));
    	generateCertificateButton.click();
    }
    
    public void setRemarkTextBox(String remarkComments) 
    {
    	waitHelper.waitForVisibility(remarkTextBox, Duration.ofSeconds(15));
    	remarkTextBox.clear();
    	remarkTextBox.sendKeys(remarkComments);
    }    
      
    public void clickDownloadButton() 
    {
    	waitHelper.waitForVisibility(downloadButton, Duration.ofSeconds(15));
    	downloadButton.click();
    }    
}
