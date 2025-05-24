package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPaymentPage {
	WebDriver driver;

	public  ConfirmPaymentPage(WebDriver driver) {
		this.driver = driver;
	}

	private By continueBtn = By.xpath("//*[@id=\"CenterForm\"]/form/div/button[1]");
	private By cancelBtn = By.xpath("//*[@id=\"CenterForm\"]/form/div/button[2]");

	public void continuetoConfirm() {
		driver.findElement(continueBtn).click();
	}

	public void cancel() {
		driver.findElement(cancelBtn).click();

	}

}

