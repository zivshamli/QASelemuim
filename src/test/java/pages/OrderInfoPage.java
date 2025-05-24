package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderInfoPage {
	WebDriver driver;

	public  OrderInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	private By deleteBtn = By.xpath("//*[@id=\"CenterForm\"]/div/button");


	public void deleteOrder() {
		driver.findElement(deleteBtn).click();
	}



}

