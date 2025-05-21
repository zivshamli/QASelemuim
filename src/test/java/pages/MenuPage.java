package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {

	private WebDriver driver;

	private By myOrdersLink = By.xpath("//*[@id=\"Menu\"]/div[1]/a[2]");
	private By logoutLink = By.xpath("//*[@id=\"Menu\"]/div[1]/a[4]");
	private By signupLink = By.xpath("//*[@id=\"Menu\"]/div[1]/a[2]");

	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToOrders() {
		driver.findElement(myOrdersLink).click();
	}

	public void logout() {
		driver.findElement(logoutLink).click();
	}

	public void signup() {
		driver.findElement(signupLink).click();
	}
}
