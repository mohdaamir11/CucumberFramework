package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewFormPage;
import PageObject.LoginPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDef extends BaseClass {

	
	@Before("@sanity")      // these are conditional hooks - this will only run for sanity tagged scenarios
	public void setup1() throws IOException {
		
		log = LogManager.getLogger("StepDef.class"); 
		
		System.out.println("setup1 sanity before method executed");
		
		readconf = new ReadConfig();
		String browser = readconf.getBrowser();
		
		//launch browser
				switch(browser.toLowerCase())
				{
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;

				case "msedge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;

				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				default:
					driver = null;
					break;

				}
		
		log.info("Setup1 executed...");
		
	}
	
	@Before ("@regression")
	public void setup2() {
		
		System.out.println("setup2 regression before method executed");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info("Setup2 executed...");
	}

	@Given("User Launch chrome Browser")
	public void user_launch_chrome_browser() {

		loginPg = new LoginPage(driver);
		formPage = new AddNewFormPage(driver);
		log.info("user launch chrome browser...");

	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);
		log.info("URL is launched");
	}

	@When("user enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailaddress, String password) {
		loginPg.enterEmail(emailaddress);
		loginPg.enterpassword(password);
	}
	
	@When("user enters Email as {string} and password as ddt {string}")
	public void user_enters_email_as_and_password_as_ddt(String string, String string2) {
		loginPg.enterEmail(string);
		loginPg.enterpassword(string2);
	}



	@When("click on Login")
	public void click_on_login() {

		loginPg.clickLogin();
	}

	@Then("page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
//		String actualTitle = driver.getTitle();
//		if(actualTitle.equals(expectedTitle))
//		{
//			Assert.assertTrue(true);
//		}
//		else {
//			Assert.assertTrue(false);
//		}

	}

	@When("User clicks on log out link")
	public void user_clicks_on_log_out_link() {

//		loginPg.clickLogout();
	}




	@Then("close browser")
	public void close_browser() {
		driver.close();
		
	}
	
	// fill form ============
	
	@When("user enters name {string} and password {string} and message {string}")
	public void user_enters_name_and_password_and_message(String string, String string2, String string3) {
	 
		formPage.enterName(string);
		formPage.enterPassword(string2);
		formPage.enterMessage(string3);
		
		log.info("entered name, password and message ");
	}
	
	@When("user clicks submit button")
	public void user_clicks_submit_button() {
	
		formPage.clickSubmit();
		
		
	}
	
	@Then("alert message contains {string}")
	public void alert_message_contains(String expectedAlertMessage) {
	    
		String actualAlertMessage  = formPage.fetchAlertMessage();
		
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
	}
	
	@Then("use clicks on alert ok")
	public void use_clicks_on_alert_ok() {
	    
		formPage.acceptAlertMessage();
	}
	
//	@BeforeStep   // these are step hooks
//	public void beforeStepMethodDemo() {
//		System.out.println("before step");
//	}
//	
//	@AfterStep
//	public void afterStepMethodDemo() {
//		System.out.println("after step");
//	}


	@After            // these are scenario hooks
	public void teardown(Scenario sc) throws IOException {
		
		System.out.println("tear down method executed");
		
		if(sc.isFailed())
		{
			// convert web driver object to take screenshot
			String fileWithPath = "C:\\Users\\msaqu\\eclipse-workspace\\CucumberFramework\\Screenshot\\failedscreenshot.png";
		    TakesScreenshot scrshot =(TakesScreenshot)driver;	
		
		    // create image file
		    File scrFile = scrshot.getScreenshotAs(OutputType.FILE);
		    
		    // move image file to destination
		    File destFile = new File(fileWithPath);
		    
		    // copy file at destination
		    FileUtils.copyFile(scrFile, destFile);
		   
		    log.debug("test failed so taking screenshot");
		    
		}
		
		driver.quit();
	}
	
	

}
