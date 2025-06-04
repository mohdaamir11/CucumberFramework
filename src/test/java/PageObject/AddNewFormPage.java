package PageObject;

import java.awt.event.ActionEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewFormPage {

	public WebDriver ldriver;
	
	public AddNewFormPage(WebDriver driver) {
		
		ldriver = driver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy(xpath = "//label[contains(text(),\"Name\")]/input")
	WebElement name;
	
	@FindBy(xpath = "//label[contains(text(),\"Password\")]/input")
	WebElement password;
	
	@FindBy(xpath = "//textarea[@id='message']")
	WebElement message;
	
	@FindBy(xpath = "//button[@id='submit-btn']")
	WebElement submitBtn;
	
	public void enterName(String strName) {
		name.sendKeys(strName);
	}
	
	public void enterPassword(String strPassword) {
		password.sendKeys(strPassword);
	}
	
	public void enterMessage(String strMessage) {
		message.sendKeys(strMessage);
	}
	
	public void clickSubmit() {
		
		ldriver.manage().window().maximize();
		 WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10)); // Wait for 10 seconds
		    ((JavascriptExecutor) ldriver).executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		    wait.until(ExpectedConditions.elementToBeClickable(submitBtn)); // Wait for element to be clickable
		    
		    submitBtn.click();
	}
	
	public String fetchAlertMessage() {
	
	return ldriver.switchTo().alert().getText();
	}
	
	public void acceptAlertMessage() {
		ldriver.switchTo().alert().accept();
	}
	
}
