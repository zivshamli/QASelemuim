package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By usernameField = By.xpath("//*[@id=\"Signon\"]/form/div/label[1]/input");
	private By passwordField = By.xpath("//*[@id=\"Signon\"]/form/div/label[2]/input");
	private By signUpButton = By.xpath("//*[@id=\"Signon\"]/form/div/div/button");
	private By error_Message = By.xpath("//*[@id=\"Signon\"]/form/div/div[2]");

	// Clear username field
	public void clearUsername() {
		driver.findElement(usernameField).clear();
	}

	// Clear password field
	public void clearPassword() {
		driver.findElement(passwordField).clear();
	}

	// Enter username
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	// Enter password
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	// Click the sign-up button
	public void clickSignUp() {
		driver.findElement(signUpButton).click();
	}

	public List<WebElement> getMessageError() {
		return driver.findElements(error_Message);
	}
}
