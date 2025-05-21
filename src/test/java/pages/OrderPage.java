package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

    private WebDriver driver;
    private By ordersTableRows = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getOrders() {
        return driver.findElements(ordersTableRows); // Subtract header row
	}
}
