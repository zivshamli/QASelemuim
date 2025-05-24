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
import pages.MenuPage;
import pages.OrdersPage;
import pages.RegisterPage;

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

public class RegisterTest {
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
			reader = new FileReader("registerUser.json");

			// Read JSON file
			user = (JSONArray) jsonParser.parse(reader);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void simple() throws InterruptedException {
		RegisterPage regPage = new RegisterPage(driver);
		driver.manage().window().setSize(new Dimension(1004, 724));
		for (int i = 0; i < user.size(); i++) {
			regPage.open();
			logger.debug("open sign up site");
			JSONObject obj = (JSONObject) user.get(i);
			regPage.clearAllFields();
			logger.debug("clear all fields");
			regPage.fillUserInformation((String) obj.get("userId"), (String) obj.get("password"),
					(String) obj.get("password"));
			regPage.fillAccountInformation((String) obj.get("firstName"), (String) obj.get("lastName"),
					(String) obj.get("email"), (String) obj.get("phone"), (String) obj.get("address1"),
					(String) obj.get("address2"), (String) obj.get("city"), (String) obj.get("state"),
					(String) obj.get("zip"), (String) obj.get("country"));
			regPage.selectPreferences((String) obj.get("languagePreference"), (String) obj.get("favouriteCategory"),
					(Boolean) obj.get("enableMyList"), (Boolean) obj.get("enableMyBanner"));
			logger.debug("enter user details " + (String) obj.get("description"));

			regPage.submit();
			logger.debug("submit user");

			List<WebElement> errors = regPage.getMessageError();
			logger.debug("fetch error message");

			switch (i) {
			case 0: {
				if (errors.size() == 0) {
					logger.debug("test passed");

				} else {
					logger.debug("test failed");

				}
				break;

			}
			case 1: {
				if (errors.size() == 0) {
					logger.debug("test failed");

				} else {
					for (WebElement el : errors) {
						String text = el.getText().trim();
						if(!text.isEmpty())
						logger.debug("error display :" + text);

					}
					logger.debug("test passed");

				}
				break;
			}
			case 2: {
				if (errors.size() == 0) {
					logger.debug("test failed");

				} else {
					for (WebElement el : errors) {
						String text = el.getText().trim();
						if(!text.isEmpty())
						logger.debug("error display :" + text);

					}
					logger.debug("test passed");

				}
				break;
			}
			case 3: {
				if (errors.size() == 0) {
					logger.debug("test failed");

				} else {
					for (WebElement el : errors) {
						String text = el.getText().trim();
						if(!text.isEmpty())
						logger.debug("error display :" + text);

					}
					logger.debug("test passed");

				}
				break;
			}
			case 4: {
				if (errors.size() == 0) {
					logger.debug("test failed");

				} else {
					for (WebElement el : errors) {
						String text = el.getText().trim();
						if(!text.isEmpty())
						logger.debug("error display :" + text);

					}
					logger.debug("test passed");

				}
				break;
			}
			case 5: {
				if (errors.size() == 0) {
					logger.debug("test passed");

				} else {
					logger.debug("test failed");

				}
				break;

			}
			case 6: {
				if (errors.size() == 0) {
					logger.debug("test failed");

				} else {
					for (WebElement el : errors) {
						String text = el.getText().trim();
						if(!text.isEmpty())
						logger.debug("error display :" + text);

					}
					logger.debug("test passed");

				}
				break;
			}

			}
		}

	}

	public static void main(String args[]) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		org.junit.runner.Result result = junit.run(RegisterTest.class); // Replace "SampleTest" with the name of your
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
