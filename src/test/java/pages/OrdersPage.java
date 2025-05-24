package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrdersPage {

    private WebDriver driver;
    private By ordersTableRows = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr");

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getOrders() {
        return driver.findElements(ordersTableRows); // Subtract header row
	}
    public void gotoLatestOrder(){
         driver.findElements(ordersTableRows).get(1).findElements(By.tagName("td")).get(0).click();

    }
    public boolean notOrders()
    {
    	String message= this.getOrders().get(1).findElements(By.tagName("td")).get(0).getText();
    	return message.equalsIgnoreCase("You have placed no orders.");

    	
    }
    
}
