package dataDriven;

import org.junit.Test;
import org.junit.Before;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.t1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
//import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Row;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.geom.Arc2D.Double;
import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//import org.apache.poi.ss.usermodel.Row;

//import org.apache.poi.ss.usermodel.Workbook;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.naming.spi.DirStateFactory.Result;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.logging.log4j.*;

public class AddtoCart {

	private WebDriver driver;
	private Logger logger;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	private Map<String, Integer> products = new HashMap<String, Integer>();

	@After
	public void tearDown() {
		// driver.quit();
	}

	@Before
	public void setUp() throws IOException {
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\acer\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		logger = LogManager.getLogger(AddtoCart.class);

	}

	@Test
	public void simple() throws InterruptedException {

		driver.get("https://jpetstore.aspectran.com");
		logger.info("opening the website");

		driver.manage().window().setSize(new Dimension(1004, 724));
		driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[1]")).click();
		logger.debug("go to fish section");

		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).click();
		logger.debug(" product choose");

		String productName = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).getText();
		logger.debug("get product name");

		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();
		logger.debug(" add product to cart ");
		products.put(productName, 1);
		logger.debug(" save product and quantity to comparson ");

		List<WebElement> productsInCart = driver.findElements(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr"));
		logger.debug(" get all products in cart ");

		if (productsInCart.size() - 2 != products.size()) {
			System.out.println("test failed");

		} else {
			List<WebElement> cells = productsInCart.get(1).findElements(By.tagName("td"));
			logger.debug(" compare between the carts  ");
			productName = cells.get(0).getText();
			if (products.containsKey(productName)) {
				System.out.println("test passed");

			} else {
				System.out.println("test failed");

			}

		}
		
		
		driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[3]/td[5]/a")).click();
		logger.info("clear cart");
		products.clear();

		
		driver.manage().window().setSize(new Dimension(1004, 724));
		driver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[1]")).click();
		logger.debug("go to fish section");

		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).click();
		logger.debug(" product choose");

		productName = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).getText();
		logger.debug("get product name");

		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();
		logger.debug(" add product to cart ");
		products.put(productName, 1);
		logger.debug(" save product and quantity to comparson ");
		driver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[2]")).click();
		logger.debug("go to dog section");

		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).click();
		logger.debug(" product choose");

		productName = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).getText();
		logger.debug("get product name");
		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();
		logger.debug(" add product to cart ");
		products.put(productName, 1);
		logger.debug(" save product and quantity to comparson ");
		
		productsInCart = driver.findElements(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr"));
		logger.debug(" get all products in cart ");
		
		if (productsInCart.size() - 2 != products.size()) {
			System.out.println("test failed");

		} else {
			boolean pass=true;
			for(int i=0;i<products.size();i++) {
			List<WebElement> cells = productsInCart.get(i+1).findElements(By.tagName("td"));
			logger.debug(" compare between the carts  ");
			productName = cells.get(0).getText();
			if (!products.containsKey(productName)) {
				System.out.println("test failed");
				i=products.size();
				pass=false;

			
			}

		}
			if(pass) {
				System.out.println("test passed");

			}
		}
		
		
		
		
		
		
		
		driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[4]/td[5]/a")).click();
		logger.info("clear cart");
		products.clear();

		
		driver.manage().window().setSize(new Dimension(1004, 724));
		driver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[1]")).click();
		logger.debug("go to fish section");

		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).click();
		logger.debug(" product choose");

		productName = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).getText();
		logger.debug("get product name");

		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();
		logger.debug(" add product to cart ");
		
		if(products.containsKey(productName)) {
			int quantity= products.get(productName);
			products.put(productName,quantity+1);
		}else {
			products.put(productName,1);
		}
		
		logger.debug(" save product and quantity to comparson ");
		driver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[2]")).click();
		logger.debug("go to dog section");

		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).click();
		logger.debug(" product choose");

		productName = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).getText();
		logger.debug("get product name");
		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();
		logger.debug(" add product to cart ");
		
		if(products.containsKey(productName)) {
			int quantity= products.get(productName);
			products.put(productName,quantity+1);
		}else {
			products.put(productName,1);
		}
		
		logger.debug(" save product and quantity to comparson ");
		
		driver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[1]")).click();
		logger.debug("go to fish section");

		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).click();
		logger.debug(" same product choose");

		productName = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).getText();
		logger.debug("get product name");

		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();
		logger.debug(" add product to cart ");
		
		productsInCart = driver.findElements(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr"));
		logger.debug(" get all products in cart ");
		if(products.containsKey(productName)) {
			int quantity= products.get(productName);
			products.put(productName,quantity+1);
		}else {
			products.put(productName,1);
		}
		
		if (productsInCart.size() - 2 != products.size()) {
			System.out.println("test failed");

		} else {
			boolean pass=true;
			for(int i=0;i<products.size();i++) {
			List<WebElement> cells = productsInCart.get(i+1).findElements(By.tagName("td"));
			logger.debug(" compare between the carts  ");
			productName = cells.get(0).getText();
			WebElement input =  (WebElement) cells.get(4).findElement(By.tagName("input"));
			int quantity = Integer.parseInt(input.getAttribute("value"));
			if (!products.containsKey(productName)||products.get(productName)!=quantity) {
				System.out.println("test failed");
				i=products.size();
				pass=false;

			
			}

		}
			if(pass) {
				System.out.println("test passed");

			}
		}

	}
	
	

	public static void main(String args[]) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		org.junit.runner.Result result = junit.run(AddtoCart.class); // Replace "SampleTest" with the name of your class
		if (result.getFailureCount() > 0) {
			System.out.println("Test failed.");
			System.exit(1);
		} else {
			System.out.println("Test finished successfully.");
			System.exit(0);
		}
	}
}
