package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPage {

	private WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	private By newPasswordInput = By.xpath("//*[@id=\"CenterForm\"]/form/table[1]/tbody/tr[2]/td[2]/input");
	private By repeatPasswordInput = By.xpath("//*[@id=\"CenterForm\"]/form/table[1]/tbody/tr[3]/td[2]/input");

	private By firstNameInput = By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[1]/td[2]/input");
	private By lastNameInput = By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[2]/td[2]/input");
	private By emailInput = By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[3]/td[2]/input");
	private By phoneInput = By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[4]/td[2]/input");

	private By address1Input = By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[5]/td[2]/input");
	private By address2Input = By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[6]/td[2]/input");
	private By cityInput = By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[7]/td[2]/input");
	private By stateInput = By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[8]/td[2]/input");
	private By zipInput = By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[9]/td[2]/input");
	private By countryInput = By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[10]/td[2]/input");
	private By language = By.xpath("//*[@id=\"CenterForm\"]/form/table[3]/tbody/tr[1]/td[2]/select");
	private By favCate = By.xpath("//*[@id=\"CenterForm\"]/form/table[3]/tbody/tr[2]/td[2]/select");
	private By enableList = By.xpath("//*[@id=\"CenterForm\"]/form/table[3]/tbody/tr[3]/td[2]/input");// checkbox
	private By enableBanner = By.xpath("//*[@id=\"CenterForm\"]/form/table[3]/tbody/tr[3]/td[2]/input");// checkbox

	private By saveButton = By.xpath("//*[@id=\"CenterForm\"]/form/div/button");

	public void updatePassword(String newPassword, String repeatPassword) {
		driver.findElement(newPasswordInput).clear();
		driver.findElement(newPasswordInput).sendKeys(newPassword);
		driver.findElement(repeatPasswordInput).clear();
		driver.findElement(repeatPasswordInput).sendKeys(repeatPassword);
	}



	public String getFirstName() {
		return driver.findElement(firstNameInput).getAttribute("value");
	}

	public String getLastName() {
		return driver.findElement(lastNameInput).getAttribute("value");
	}

	public String getEmail() {
		return driver.findElement(emailInput).getAttribute("value");
	}

	public String getPhone() {
		return driver.findElement(phoneInput).getAttribute("value");
	}

	public String getAddress1() {
		return driver.findElement(address1Input).getAttribute("value");
	}

	public String getAddress2() {
		return driver.findElement(address2Input).getAttribute("value");
	}

	public String getCity() {
		return driver.findElement(cityInput).getAttribute("value");
	}

	public String getState() {
		return driver.findElement(stateInput).getAttribute("value");
	}

	public String getZip() {
		return driver.findElement(zipInput).getAttribute("value");
	}

	public String getCountry() {
		return driver.findElement(countryInput).getAttribute("value");
	}

	public String getLanguage() {
		Select select = new Select(driver.findElement(language));
		return select.getFirstSelectedOption().getText();
	}

	public String getFavoriteCategory() {
		Select select = new Select(driver.findElement(favCate));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isEnableListChecked() {
		return driver.findElement(enableList).isSelected();
	}

	public boolean isEnableBannerChecked() {
		return driver.findElement(enableBanner).isSelected();
	}

	public void updateContactInfo(String firstName, String lastName, String email, String phone, String address1,
			String address2, String city, String state, String zip, String country) {
		driver.findElement(firstNameInput).clear();
		driver.findElement(firstNameInput).sendKeys(firstName);

		driver.findElement(lastNameInput).clear();
		driver.findElement(lastNameInput).sendKeys(lastName);

		driver.findElement(emailInput).clear();
		driver.findElement(emailInput).sendKeys(email);

		driver.findElement(phoneInput).clear();
		driver.findElement(phoneInput).sendKeys(phone);

		driver.findElement(address1Input).clear();
		driver.findElement(address1Input).sendKeys(address1);

		driver.findElement(address2Input).clear();
		driver.findElement(address2Input).sendKeys(address2);

		driver.findElement(cityInput).clear();
		driver.findElement(cityInput).sendKeys(city);

		driver.findElement(stateInput).clear();
		driver.findElement(stateInput).sendKeys(state);

		driver.findElement(zipInput).clear();
		driver.findElement(zipInput).sendKeys(zip);

		driver.findElement(countryInput).clear();
		driver.findElement(countryInput).sendKeys(country);
	}

	public void saveChanges() {
		driver.findElement(saveButton).click();
	}
}
