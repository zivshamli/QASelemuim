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

import pages.CartPage;
import pages.CatalogPage;
import pages.QuickLinkPage;
import pages.SidebarPage;

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
		logger.debug("test 1 - add product to empty cart");
		SidebarPage siderbar = new SidebarPage(driver);
		siderbar.clickFish();
		logger.debug("go to fish section");
		int rowProduct = 2;
		CatalogPage catalog = new CatalogPage(driver);
		catalog.selectProduct(rowProduct);
		logger.debug(" product choose");

		String productName = catalog.getProductName(rowProduct, 1);
		logger.debug("get product name");

		catalog.addToCart(rowProduct);
		logger.debug(" add product to cart ");
		products.put(productName, 1);
		logger.debug(" save product and quantity to comparson ");
		CartPage cart = new CartPage(driver);
		List<WebElement> productsInCart = cart.getProductsInCart();
		logger.debug(" get all products in cart ");

		if (productsInCart.size() - 2 != products.size()) {
			logger.debug("test failed");

		} else {
			List<WebElement> cells = productsInCart.get(1).findElements(By.tagName("td"));
			logger.debug(" compare between the carts  ");
			productName = cells.get(0).getText();
			if (products.containsKey(productName)) {
				logger.debug("test passed");

			} else {
				logger.debug("test failed");

			}

		}

		cart.RemoveAll();
		logger.info("clear cart");
		products.clear();
		
		logger.debug("test 2 - add product to cart that have diffrent product");

		QuickLinkPage quickPage = new QuickLinkPage(driver);
		quickPage.clickFishQuickLink();
		logger.debug("go to fish section");

		catalog = new CatalogPage(driver);
		catalog.selectProduct(rowProduct);
		logger.debug(" product choose");

		productName = catalog.getProductName(rowProduct, 1);
		logger.debug("get product name");

		catalog.addToCart(rowProduct);
		logger.debug(" add product to cart ");
		products.put(productName, 1);
		logger.debug(" save product and quantity to comparson ");

		quickPage = new QuickLinkPage(driver);
		quickPage.clickDogsQuickLink();
		logger.debug("go to dog section");

		catalog = new CatalogPage(driver);
		catalog.selectProduct(rowProduct);
		logger.debug(" product choose");

		productName = catalog.getProductName(rowProduct, 1);
		logger.debug("get product name");
		catalog.addToCart(rowProduct);
		logger.debug(" add product to cart ");
		products.put(productName, 1);
		logger.debug(" save product and quantity to comparson ");
		cart = new CartPage(driver);
		productsInCart = cart.getProductsInCart();
		logger.debug(" get all products in cart ");

		if (productsInCart.size() - 2 != products.size()) {
			logger.debug("test failed");

		} else {
			boolean pass = true;
			for (int i = 0; i < products.size(); i++) {
				List<WebElement> cells = productsInCart.get(i + 1).findElements(By.tagName("td"));
				logger.debug(" compare between the carts  ");
				productName = cells.get(0).getText();
				if (!products.containsKey(productName)) {
					logger.debug("test failed");
					i = products.size();
					pass = false;

				}

			}
			if (pass) {
				logger.debug("test passed");

			}
		}

		cart.RemoveAll();
		logger.info("clear cart");
		products.clear();
		logger.debug("test 3 - add to cart product and after that same product");
		quickPage = new QuickLinkPage(driver);
		quickPage.clickFishQuickLink();
		logger.debug("go to fish section");

		catalog.selectProduct(rowProduct);
		logger.debug(" product choose");

		productName = catalog.getProductName(rowProduct, 1);
		logger.debug("get product name");

		catalog.addToCart(rowProduct);
		logger.debug(" add product to cart ");

		if (products.containsKey(productName)) {
			int quantity = products.get(productName);
			products.put(productName, quantity + 1);
		} else {
			products.put(productName, 1);
		}

		logger.debug(" save product and quantity to comparson ");
		quickPage = new QuickLinkPage(driver);
		quickPage.clickDogsQuickLink();
		logger.debug("go to dog section");

		catalog.selectProduct(rowProduct);
		logger.debug(" product choose");

		productName = catalog.getProductName(rowProduct, 1);
		logger.debug("get product name");
		catalog.addToCart(rowProduct);
		logger.debug(" add product to cart ");

		if (products.containsKey(productName)) {
			int quantity = products.get(productName);
			products.put(productName, quantity + 1);
		} else {
			products.put(productName, 1);
		}

		logger.debug(" save product and quantity to comparson ");

		quickPage = new QuickLinkPage(driver);
		quickPage.clickFishQuickLink();
		logger.debug("go to fish section");

		catalog = new CatalogPage(driver);
		catalog.selectProduct(rowProduct);
		logger.debug(" same product choose");

		productName = catalog.getProductName(rowProduct, 1);
		logger.debug("get product name");

		catalog.addToCart(rowProduct);
		logger.debug(" add product to cart ");
		if (products.containsKey(productName)) {
			int quantity = products.get(productName);
			products.put(productName, quantity + 1);
		} else {
			products.put(productName, 1);
		}
		cart = new CartPage(driver);
		productsInCart = cart.getProductsInCart();
		logger.debug(" get all products in cart ");
		if (productsInCart.size() - 2 != products.size()) {
			logger.debug("test failed");

		} else {
			boolean pass = true;
			for (int i = 0; i < products.size(); i++) {
				List<WebElement> cells = productsInCart.get(i + 1).findElements(By.tagName("td"));
				logger.debug(" compare between the carts  ");
				productName = cells.get(0).getText();
				WebElement input = (WebElement) cells.get(4).findElement(By.tagName("input"));
				int quantity = Integer.parseInt(input.getAttribute("value"));
				if (!products.containsKey(productName) || products.get(productName) != quantity) {
					logger.debug("test failed");
					i = products.size();
					pass = false;

				}

			}
			if (pass) {
				logger.debug("test passed");

			}
		}
		cart.RemoveAll();
		logger.debug("test 4 - add to cart product that not have in stock");

			rowProduct = 5;
			quickPage = new QuickLinkPage(driver);
			quickPage.clickDogsQuickLink();
			logger.debug("go to dog section");

			catalog.selectProduct(rowProduct);
			logger.debug(" product choose");

			productName = catalog.getProductName(2, 1);
			logger.debug("get product name");
			catalog.addToCart(2);

			if (products.containsKey(productName)) {
				int quantity = products.get(productName);
				products.put(productName, quantity + 1);
			} else {
				products.put(productName, 1);
			}
		
		cart = new CartPage(driver);
		int quan=9035;
		cart.updateProduct(2,quan );
		cart.updateCart();
		products.put(productName,quan);
		List<WebElement>erorrs=cart.getMessageError();
		logger.debug("fetch erorr messages");
		if(erorrs.size()!=0) {
			logger.debug("test passed");
		}
		else {
			logger.debug("test failed");

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
