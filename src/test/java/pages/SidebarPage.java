package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidebarPage {
    private WebDriver driver;

    // Exact XPaths based on sidebar position
    private By fishLink = By.xpath("//*[@id='SidebarContent']/a[1]");
    private By dogsLink = By.xpath("//*[@id='SidebarContent']/a[2]");
    private By reptilesLink = By.xpath("//*[@id='SidebarContent']/a[4]");
    private By catsLink = By.xpath("//*[@id='SidebarContent']/a[3]");
    private By birdsLink = By.xpath("//*[@id='SidebarContent']/a[5]");

    public SidebarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFish() {
        driver.findElement(fishLink).click();
    }

    public void clickDogs() {
        driver.findElement(dogsLink).click();
    }

    public void clickReptiles() {
        driver.findElement(reptilesLink).click();
    }

    public void clickCats() {
        driver.findElement(catsLink).click();
    }

    public void clickBirds() {
        driver.findElement(birdsLink).click();
    }
}
