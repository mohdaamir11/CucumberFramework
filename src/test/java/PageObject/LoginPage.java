package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(ldriver, this);

	}

	@FindBy(xpath = "//input[@name='Email']")
	WebElement emailfield;

	@FindBy(xpath = "//input[@name='Password']")
	WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy (xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;

	public void enterEmail(String email) {

		emailfield.clear();
		emailfield.sendKeys(email);
	}

	public void enterpassword(String password) {

		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void clickLogin() {

		loginButton.click();
	}


	public void clickLogout() {

		logout.click();
	}


}
