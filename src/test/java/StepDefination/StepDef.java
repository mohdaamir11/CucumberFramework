package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDef {

	public WebDriver driver;
	public LoginPage loginPg;

	@Given("User Launch chrome Browser")
	public void user_launch_chrome_browser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		loginPg = new LoginPage(driver);

	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);
	}

	@When("user enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailaddress, String password) {
		loginPg.enterEmail(emailaddress);
		loginPg.enterpassword(password);
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
		driver.quit();
	}

}
