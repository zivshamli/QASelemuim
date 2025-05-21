package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    private By saveButton = By.xpath("//*[@id=\"CenterForm\"]/form/div/button");

    public void updatePassword(String newPassword, String repeatPassword) {
        driver.findElement(newPasswordInput).clear();
        driver.findElement(newPasswordInput).sendKeys(newPassword);
        driver.findElement(repeatPasswordInput).clear();
        driver.findElement(repeatPasswordInput).sendKeys(repeatPassword);
    }

    public void updateContactInfo(String firstName, String lastName, String email,
                                  String phone, String address1, String address2,
                                  String city, String state, String zip, String country) {
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
