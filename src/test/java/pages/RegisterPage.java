package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://jpetstore.aspectran.com/account/newAccountForm");
    }

    private By userIdInput = By.xpath("//*[@id=\"CenterForm\"]/form/table[1]/tbody/tr[1]/td[2]/input");
    private By passwordInput = By.xpath("//*[@id=\"CenterForm\"]/form/table[1]/tbody/tr[2]/td[2]/input");
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

    private By languageSelect = By.xpath("//*[@id=\"CenterForm\"]/form/table[3]/tbody/tr[1]/td[2]/select");
    private By categorySelect = By.xpath("//*[@id=\"CenterForm\"]/form/table[3]/tbody/tr[2]/td[2]/select");
    private By myListCheckbox = By.xpath("//*[@id=\"CenterForm\"]/form/table[3]/tbody/tr[3]/td[2]/input");
    private By myBannerCheckbox = By.xpath("//*[@id=\"CenterForm\"]/form/table[3]/tbody/tr[4]/td[2]/input");
	private By error_Message = By.className("error-msg");


    private By saveButton = By.xpath("//*[@id=\\\"CenterForm\\\"]/form/div/button");

    public void fillUserInformation(String userId, String password, String repeatPassword) {
        driver.findElement(userIdInput).sendKeys(userId);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(repeatPasswordInput).sendKeys(repeatPassword);
    }

    public void fillAccountInformation(String firstName, String lastName, String email,
                                       String phone, String address1, String address2,
                                       String city, String state, String zip, String country) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(address1Input).sendKeys(address1);
        driver.findElement(address2Input).sendKeys(address2);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(stateInput).sendKeys(state);
        driver.findElement(zipInput).sendKeys(zip);
        driver.findElement(countryInput).sendKeys(country);
    }

    public void selectPreferences(String language, String category, boolean listOpt, boolean bannerOpt) {
        new Select(driver.findElement(languageSelect)).selectByVisibleText(language);
        new Select(driver.findElement(categorySelect)).selectByVisibleText(category);

        if (driver.findElement(myListCheckbox).isSelected() != listOpt) {
            driver.findElement(myListCheckbox).click();
        }
        if (driver.findElement(myBannerCheckbox).isSelected() != bannerOpt) {
            driver.findElement(myBannerCheckbox).click();
        }
    }
    
    public void clearAllFields() {
        driver.findElement(userIdInput).clear();
        driver.findElement(passwordInput).clear();
        driver.findElement(repeatPasswordInput).clear();

        driver.findElement(firstNameInput).clear();
        driver.findElement(lastNameInput).clear();
        driver.findElement(emailInput).clear();
        driver.findElement(phoneInput).clear();
        driver.findElement(address1Input).clear();
        driver.findElement(address2Input).clear();
        driver.findElement(cityInput).clear();
        driver.findElement(stateInput).clear();
        driver.findElement(zipInput).clear();
        driver.findElement(countryInput).clear();
    }
    
    public List<WebElement> getMessageError() {
		return driver.findElements(error_Message);
	}

    public void submit() {
        driver.findElement(saveButton).click();
    }
}