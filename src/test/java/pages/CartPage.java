package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get all products in the cart
    public List<WebElement> getProductsInCart() {
        return driver.findElements(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr"));
    }
}