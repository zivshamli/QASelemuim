package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {

    WebDriver driver;

    // Constructor
    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

   

    // Click on a product at a specific row and column
    public void selectProduct(int row) {
        String xpath = String.format("//*[@id=\"Catalog\"]/table/tbody/tr[%d]/td[%d]/a", row,1);
        driver.findElement(By.xpath(xpath)).click();
    }

    // Get the name of a product at a specific row and column
    public String getProductName(int row, int col) {
        String xpath = String.format("//*[@id=\"Catalog\"]/table/tbody/tr[%d]/td[%d]/a", row, 1);
        return driver.findElement(By.xpath(xpath)).getText();
    }

    // Click "Add to Cart" link at a specific row
    public void addToCart(int row) {
        String xpath = String.format("//*[@id=\"Catalog\"]/table/tbody/tr[%d]/td[5]/a", row);
        driver.findElement(By.xpath(xpath)).click();
    }
}