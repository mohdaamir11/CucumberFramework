package StepDefination;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewFormPage;
import PageObject.LoginPage;
import Utilities.ReadConfig;

public class BaseClass {

	public WebDriver driver;
	public LoginPage loginPg;
	public AddNewFormPage formPage;
	public static Logger log;
	public ReadConfig readconf;
	
	public String generateEmailId() {
		
		return RandomStringUtils.randomAlphabetic(5);
	}
	
}
