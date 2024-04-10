package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.CertificatePage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.StudentPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Steps extends BaseClass 
{
	// Page Object Classes Instances
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public StudentPage studentPage = new StudentPage(driver);
    public CertificatePage certificatePage = new CertificatePage(driver);
	
	// Using hook for setting up the browser before the Test Scenario 
	
	@Before
	public void setup() throws IOException 
	{
		// Logger configuration
		logger = Logger.getLogger("TechMint");
		PropertyConfigurator.configure("Log4j.properties");

		// Loading Config.properties file 
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);

		// Browser configuration
		String browser = configProp.getProperty("browser");

		if (browser.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equals("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	@Given("Login to the Application")
	public void login_to_the_Application() throws InterruptedException
	{
		loginPage = new LoginPage(driver);
		
		logger.info("********* Launching the browser *********");
		String baseUrl = configProp.getProperty("baseUrl");
		
		logger.info("********* Opening the URL *********");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		
		logger.info("********* Enterring the Username *********");
		String username = configProp.getProperty("username");
		loginPage.setUserName(username);
		
		logger.info("********* Clicking the Next Button *********");
		loginPage.clickNextButton();
		
		logger.info("********* Clicking the Login With Password link *********");
		loginPage.clickLoginWithPasswordLink();
		
		logger.info("********* Enterring the Password *********");		
		String password = configProp.getProperty("password");
		loginPage.setPassword(password);
			
		logger.info("********* Clicking the Login Button *********");
		loginPage.clickLoginButton();
		
		logger.info("********* Choosing the Automation User Profile *********");
		loginPage.clickAutomationUserProfile();
	}
	
	@Then("Navigate to certificates")
	public void navigate_to_certificates () throws InterruptedException
	{
		dashboardPage = new DashboardPage(driver);
				
		logger.info("********* Verifying the Title of the Dashboard Page *********");
		String expectedTitle = "Login to Teachmint Dashboard";
		String actualTitle = dashboardPage.getDashboardPageTitle();				
		Assert.assertEquals(expectedTitle, actualTitle);
		
		logger.info("********* Clicking Generate Certificate Button *********");
		dashboardPage.clickGenerateCertificateButton();
	}

	@And("Select the certificate type")
	public void select_the_certificate_type () throws InterruptedException
	{
		logger.info("********* Selecting School Leaving Certificate *********");
		studentPage.clickSchoolLeavingCertificateButton();
		
		logger.info("********* Clicking the Generate Certificate Button *********");
		studentPage.clickGenerateCertificateButton();
	}
	
	@Then("Search and select the student")
	public void search_and_select_the_student () throws InterruptedException
	{
		logger.info("********* Entering the Student Name and Searching in the Search Bar *********");
		String studentName = configProp.getProperty("studentName");
		certificatePage.setSearchBar(studentName);
	}
	
	@And("Click on generate")
	public void click_on_generate () throws InterruptedException
	{
		logger.info("********* Clicking the Generate Certificate Button *********");
		certificatePage.clickGenerateCertificateButton();
	}
	
	@Then("Update remarks")
	public void update_remarks () throws InterruptedException
	{
		logger.info("********* Entering and Updating the Student Remarks *********");
		String remarks = configProp.getProperty("remarks");
		certificatePage.setRemarkTextBox(remarks);
	}
	
	@And("Generate and download")
	public void generate_and_download () throws InterruptedException
	{
		logger.info("********* Clicking the Download Button to download the Certificate *********");
		certificatePage.clickDownloadButton();
	}
	
	// Using Hook for closing the WebDriver session and closing the browser
	
	@After
	public void tearDown() 
	{
		driver.quit();
	}
}
