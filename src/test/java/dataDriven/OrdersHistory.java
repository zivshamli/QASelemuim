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
import pages.ConfirmPaymentPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.OrderInfoPage;
import pages.OrdersPage;
import pages.QuickLinkPage;

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

public class OrdersHistory {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	private JSONArray user ,products;

	private Logger logger;

	@After
	public void tearDown() {
		// driver.quit();
	}

	@Before
	public void setUp() throws IOException, ParseException {
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\acer\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		logger = LogManager.getLogger(OrdersHistory.class);
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader reader,reader2;
			reader = new FileReader("correctUser.json");
			reader2=new FileReader("products.json");

			// Read JSON file
			user = (JSONArray) jsonParser.parse(reader);
			products=(JSONArray) jsonParser.parse(reader2);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void simple() throws InterruptedException {
		
		for (int i = 0; i < user.size(); i++) {
			JSONObject obj = (JSONObject) user.get(i);
			Long orderLong = (Long) obj.get("orders");
			int order = orderLong.intValue();
			logger.debug((String)obj.get("description"));

			driver.get("https://jpetstore.aspectran.com/account/signonForm");
			logger.info("opening Sign in screen");
			driver.manage().window().setSize(new Dimension(1004, 724));
			login(driver, obj, logger);
			MenuPage menu= new MenuPage(driver);
			menu.goToOrders();
			logger.debug("go to my orders ");
			OrdersPage orderPage = new OrdersPage(driver);



			List<WebElement> orders =orderPage.getOrders();
			logger.debug("check if the orders are shown ");

			

			if (orders.size() - 1 == order) {
				logger.debug("test passed");

			} else {
				if(orderPage.notOrders())
				{
				logger.debug("test passed");

				}
				else
				logger.debug("test failed");

			}
		}
		JSONObject obj = (JSONObject) user.get(0);
	


		driver.get("https://jpetstore.aspectran.com/account/signonForm");
	
		logger.debug("test enter with user and then log out and enter to second user to see that the orders are of the second user ");
		login(driver, obj, logger);
		
		MenuPage menu= new MenuPage(driver);
		menu.goToOrders();
		logger.debug("go to my orders ");
		menu.logout();
		logger.debug("log out ");
		menu.signin();
		logger.debug("sign in");

		obj = (JSONObject) user.get(1);
		login(driver, obj, logger);
		menu.goToOrders();
		logger.debug("go to my orders ");
		OrdersPage orderPage = new OrdersPage(driver);
		List<WebElement> orders =orderPage.getOrders();
		Long orderLong = (Long) obj.get("orders");
		int order = orderLong.intValue();		
		logger.debug("check if the orders are shown ");
		
		if (orders.size() - 1 == order) {
			logger.debug("test passed");

		} else {
			if(orderPage.notOrders())
			{
			logger.debug("test passed");

			}
			else
			logger.debug("test failed");

		}
		
		logger.debug("test check if order that add will update the history");
		makeOrder(driver);
		menu.goToOrders();
		logger.debug("go to my orders ");
		 orderPage = new OrdersPage(driver);
		 orders =orderPage.getOrders();
		 orderLong = (Long) obj.get("orders");
		 order = orderLong.intValue();	
	
		logger.debug("check if the orders are shown ");
		
		if (orders.size() - 1 == (order+1)) {
			logger.debug("test passed");

		} else {
			logger.debug("test failed");

		}
		
		
		logger.debug("test check if order that remove will update the history");
		orderPage.gotoLatestOrder();
		logger.debug("go to last order");
		OrderInfoPage orderinfo= new OrderInfoPage(driver);
		orderinfo.deleteOrder();
		logger.debug("delete the last order");
		 orderPage = new OrdersPage(driver);
		 orders =orderPage.getOrders();
		 orderLong = (Long) obj.get("orders");
		 order = orderLong.intValue();		
		logger.debug("check if the orders are shown ");
		
		if (orders.size() - 1 == order) {
			logger.debug("test passed");

		} else {
			if(orderPage.notOrders())
			{
			logger.debug("test passed");

			}
			else
			logger.debug("test failed");

		}
		
		

		
		
		
		

		
		
		
		

	}
	

	public static void main(String args[]) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		org.junit.runner.Result result = junit.run(OrdersHistory.class); // Replace "SampleTest" with the name of your
																			// class
		if (result.getFailureCount() > 0) {
			System.out.println("Test failed.");
			System.exit(1);
		} else {
			System.out.println("Test finished successfully.");
			System.exit(0);
		}
	}
	
	public static void login(WebDriver driver ,JSONObject obj,Logger logger) {
		String username = (String) obj.get("username");
		String password = (String) obj.get("password");
		LoginPage loginPage =new LoginPage(driver);
		loginPage.clearUsername();
		logger.debug("clear username field ");

		loginPage.clearPassword();
		logger.debug("clear password field ");

		loginPage.enterUsername(username);
		logger.debug("enter username in username field ");

		loginPage.enterPassword(password);
		logger.debug("enter password in password field ");

		loginPage.clickSignUp();
		logger.debug("click the sign up button");

				
	}
	
	public  void makeOrder(WebDriver driver)
	{
		QuickLinkPage quicklinkPage=new QuickLinkPage(driver);
		quicklinkPage.clickBirdsQuickLink();
		logger.debug("go to bird section");

		CatalogPage catalog=new CatalogPage(driver);
		JSONObject obj = (JSONObject)products.get(0);
		Long row = (Long) obj.get("row");
		int rowInt = row.intValue();
		catalog.selectProduct(rowInt);
		logger.debug("select product");

		catalog.addToCart(rowInt);
		logger.debug("add  the product to the cart");

		CartPage cart=new CartPage(driver);
		cart.proccedToPayment();
		logger.debug("procced to check out");

		ConfirmPaymentPage confirmPage=new ConfirmPaymentPage(driver);
		confirmPage.continuetoConfirm();
		logger.debug("confirm order");

		confirmPage.continuetoConfirm();
		logger.debug("confirm payment");


		
		

		
	}
	

}
