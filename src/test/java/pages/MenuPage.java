package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {

	private WebDriver driver;

	private By myOrdersLink = By.xpath("//*[@id=\"Menu\"]/div[1]/a[2]");
	private By logoutLink = By.xpath("//*[@id=\"Menu\"]/div[1]/a[4]");
	private By myAccountLink = By.xpath("//*[@id=\"Menu\"]/div[1]/a[3]");
	private By signinLink = By.xpath("//*[@id=\"Menu\"]/div[1]/a[2]");



	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToOrders() {
		driver.findElement(myOrdersLink).click();
	}

	public void logout() {
		driver.findElement(logoutLink).click();
	}

	public void signin() {
		driver.findElement(signinLink).click();
	}
	
	public void gotoMyAccount() {
		driver.findElement(myAccountLink).click();
	}
}
