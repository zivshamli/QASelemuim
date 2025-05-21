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
	private JSONArray user;
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
			FileReader reader;
			reader = new FileReader("correctUser.json");

			// Read JSON file
			user = (JSONArray) jsonParser.parse(reader);

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


			driver.get("https://jpetstore.aspectran.com/account/signonForm");
			logger.info("opening Sign in screen");
			driver.manage().window().setSize(new Dimension(1004, 724));

			driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[1]/input")).clear();
			logger.debug("clear username field ");

			driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[2]/input")).clear();
			logger.debug("clear password field ");

			driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[1]/input"))
					.sendKeys((String) obj.get("username"));
			logger.debug("enter username in username field ");

			driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[2]/input"))
					.sendKeys((String) obj.get("password"));
			logger.debug("enter password in password field ");

			driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/div/button")).click();
			logger.debug("click the sign up button");
			driver.findElement(By.xpath("//*[@id=\"Menu\"]/div[1]/a[2]")).click();
			logger.debug("go to my orders ");


			List<WebElement> orders = driver.findElements(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr"));
			logger.debug("check if the orders are shown ");

			

			if (orders.size() - 1 == order) {
				System.out.println("test failed");

			} else {
				System.out.println("test passed");

			}
		}
		JSONObject obj = (JSONObject) user.get(0);
	


		driver.get("https://jpetstore.aspectran.com/account/signonForm");
		logger.info("opening Sign in screen");
		driver.manage().window().setSize(new Dimension(1004, 724));

		driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[1]/input")).clear();
		logger.debug("clear username field ");

		driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[2]/input")).clear();
		logger.debug("clear password field ");

		driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[1]/input"))
				.sendKeys((String) obj.get("username"));
		logger.debug("enter username in username field ");

		driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[2]/input"))
				.sendKeys((String) obj.get("password"));
		logger.debug("enter password in password field ");

		driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/div/button")).click();
		logger.debug("click the sign up button");
		driver.findElement(By.xpath("//*[@id=\"Menu\"]/div[1]/a[2]")).click();
		logger.debug("go to my orders ");
		driver.findElement(By.xpath("//*[@id=\"Menu\"]/div[1]/a[4]")).click();
		logger.debug("log out ");
		
		
		driver.findElement(By.xpath("//*[@id=\"Menu\"]/div[1]/a[2]")).click();
		logger.debug("sign in");

		obj = (JSONObject) user.get(1);
		driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[1]/input")).clear();
		logger.debug("clear username field ");

		driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[2]/input")).clear();
		logger.debug("clear password field ");

		driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[1]/input"))
				.sendKeys((String) obj.get("username"));
		logger.debug("enter username in username field ");

		driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[2]/input"))
				.sendKeys((String) obj.get("password"));
		logger.debug("enter password in password field ");

		driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/div/button")).click();
		logger.debug("click the sign up button");
		driver.findElement(By.xpath("//*[@id=\"Menu\"]/div[1]/a[2]")).click();
		
		logger.debug("go to my orders ");
		Long orderLong = (Long) obj.get("orders");
		int order = orderLong.intValue();
		
		List<WebElement> orders = driver.findElements(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr"));
		logger.debug("check if the orders are shown ");

		

		if (orders.size() - 1 == order) {
			System.out.println("test failed");

		} else {
			System.out.println("test passed");

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

}
