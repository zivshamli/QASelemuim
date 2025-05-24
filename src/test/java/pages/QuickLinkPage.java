package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickLinkPage {
	WebDriver driver;

	// QuickLinks menu items
	private By fishQuickLink = By.xpath("//*[@id='QuickLinks']/a[1]");
	private By dogsQuickLink = By.xpath("//*[@id='QuickLinks']/a[2]");
	private By reptilesQuickLink = By.xpath("//*[@id='QuickLinks']/a[4]");
	private By catsQuickLink = By.xpath("//*[@id='QuickLinks']/a[3]");
	private By birdsQuickLink = By.xpath("//*[@id='QuickLinks']/a[5]");

	public QuickLinkPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickFishQuickLink() {
		driver.findElement(fishQuickLink).click();
	}

	public void clickDogsQuickLink() {
		driver.findElement(dogsQuickLink).click();
	}

	public void clickReptilesQuickLink() {
		driver.findElement(reptilesQuickLink).click();
	}

	public void clickCatsQuickLink() {
		driver.findElement(catsQuickLink).click();
	}

	public void clickBirdsQuickLink() {
		driver.findElement(birdsQuickLink).click();
	}
}
