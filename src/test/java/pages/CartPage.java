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
    private By productsInCart=By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr");
    private By proccedPayment=By.xpath("//*[@id=\"Cart\"]/a");
	private By error_Message = By.className("error-msg");

    
    // Get all products in the cart
    public List<WebElement> getProductsInCart() {
        return driver.findElements(productsInCart);
    }
    public void removeFromCart(int row) {
        String xpath = String.format("//*[@id=\"Cart\"]/form/table/tbody/tr[%d]/td[8]/a", row);
        driver.findElement(By.xpath(xpath)).click();
    }
    public void RemoveAll() {
        String xpath = String.format("//*[@id=\"Cart\"]/form/table/tbody/tr[%d]/td[5]/a", this.getProductsInCart().size());
        driver.findElement(By.xpath(xpath)).click();
    }
    
    public void updateProduct(int row, int quantity) {
        String xpath = String.format("//*[@id=\"Cart\"]/form/table/tbody/tr[%d]/td[5]/input", row);
        WebElement quantityInput = driver.findElement(By.xpath(xpath));
        quantityInput.clear(); 
        quantityInput.sendKeys(String.valueOf(quantity)); 
    }

    
    public void updateCart() {
        String xpath = String.format("//*[@id=\"Cart\"]/form/table/tbody/tr[%d]/td[2]/button", this.getProductsInCart().size());
        driver.findElement(By.xpath(xpath)).click();
    }
    public void proccedToPayment() {
    	driver.findElement(proccedPayment).click();
    }
    public List<WebElement> getMessageError() {
		return driver.findElements(error_Message);
	}
    
}