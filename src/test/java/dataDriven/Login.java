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

import pages.LoginPage;

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

public class Login {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	private JSONArray users, users2;
	final int CHANCES = 5;
	private Logger logger;

	@After
	public void tearDown() {
		// driver.quit();
	}

	@Before
	public void setUp() throws IOException, ParseException {
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\acer\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		logger = LogManager.getLogger(Login.class);
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader reader, reader2;
			reader = new FileReader("login.json");
			reader2 = new FileReader("loginblock.json");

			// Read JSON file
			users = (JSONArray) jsonParser.parse(reader);
			users2 = (JSONArray) jsonParser.parse(reader2);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void simple() throws InterruptedException {
		for (int i = 0; i < users.size(); i++) {
			JSONObject obj = (JSONObject) users.get(i);
			String username = (String) obj.get("username");
			String password = (String) obj.get("password");
			String expectedError = (String) obj.get("expectedResult");

			driver.get("https://jpetstore.aspectran.com/account/signonForm");
			logger.info("opening Sign in screen");
			driver.manage().window().setSize(new Dimension(1004, 724));
			LoginPage loginPage = new LoginPage(driver);

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

			List<WebElement> errors = loginPage.getMessageError();
			logger.debug("Getting the error message");

			logger.debug("comparing the error message expect with execepted error message");
			if (expectedError.isEmpty()) {
				if (errors.size() == 0) {
					System.out.println("test passed");

				} else {
					System.out.println("test failed");

				}

			} else {
				if (errors.get(0).getText().equalsIgnoreCase(expectedError)) {
					System.out.println("test passed");

				} else {
					System.out.println("test failed");

				}

			}

		}

		JSONObject obj = (JSONObject) users2.get(0);
		String username = (String) obj.get("username");
		String password = (String) obj.get("password");
		driver.get("https://jpetstore.aspectran.com/account/signonForm");
		logger.info("opening Sign in screen");
		LoginPage loginPage = new LoginPage(driver);

		driver.manage().window().setSize(new Dimension(1004, 724));
		for (int i = 0; i < CHANCES; i++) {

			loginPage.clearUsername();
			logger.debug("clear username field ");

			loginPage.clearPassword();
			logger.debug("clear password field ");

			loginPage.enterUsername(username);
			logger.debug("enter wrong username in username field chance : " + i);

			loginPage.enterPassword(password);
			logger.debug("enter wrong password in password field chance : " + i);

			loginPage.clickSignUp();
			logger.debug("click the sign up button");

		}

		obj = (JSONObject) users2.get(1);
		username = (String) obj.get("username");
		password = (String) obj.get("password");

		loginPage.clearUsername();
		logger.debug("clear username field ");

		loginPage.clearPassword();
		logger.debug("clear password field ");

		loginPage.enterUsername(username);

		logger.debug("enter right username in username field ");

		loginPage.enterPassword(password);

		logger.debug("enter right password in password field ");

		loginPage.clickSignUp();
		logger.debug("click the sign up button");

		List<WebElement> errors = loginPage.getMessageError();
		logger.debug("if showing block message ");

		if (errors.size() == 0) {
			System.out.println("test failed");

		} else {
			System.out.println("test passed");

		}

	}

	public static void main(String args[]) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		org.junit.runner.Result result = junit.run(Login.class); // Replace "SampleTest" with the name of your class
		if (result.getFailureCount() > 0) {
			System.out.println("Test failed.");
			System.exit(1);
		} else {
			System.out.println("Test finished successfully.");
			System.exit(0);
		}
	}
}
