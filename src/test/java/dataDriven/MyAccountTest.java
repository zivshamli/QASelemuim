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
import pages.MyAccountPage;
import pages.OrderPage;

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

public class MyAccountTest {
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
			reader = new FileReader("currentMyAcoountUsers.json");

			// Read JSON file
			user = (JSONArray) jsonParser.parse(reader);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void simple() throws InterruptedException {

		JSONObject obj = (JSONObject) user.get(0);

		driver.get("https://jpetstore.aspectran.com/account/signonForm");
		logger.info("opening Sign in screen");
		driver.manage().window().setSize(new Dimension(1004, 724));
		login(driver, obj, logger);
		MenuPage menu = new MenuPage(driver);
		menu.gotoMyAccount();
		logger.debug("go to my account and compare values");
		MyAccountPage accountPage = new MyAccountPage(driver);
		boolean succesCompare = compareUserDataWithPageData(accountPage, obj);
		if (succesCompare) {
			logger.debug("test passed");

		} else {
			logger.debug("test failed");

		}
		menu.logout();
		
		logger.debug("now in this test we enter to user we signout and than we enter to other user and compare parts");
		menu.signin();
		JSONObject obj1 = (JSONObject) user.get(1);
		login(driver, obj1, logger);
		menu.logout();
		logger.debug(" we enter to other user and compare parts");
		menu.signin();
		login(driver, obj, logger);
		menu.gotoMyAccount();
		logger.debug("go to my account and compare values");
		succesCompare = compareUserDataWithPageData(accountPage, obj);
		if (succesCompare) {
			logger.debug("test passed");

		} else {
			logger.debug("test failed");

		}
		



		


	}

	public static void main(String args[]) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		org.junit.runner.Result result = junit.run(MyAccountTest.class); // Replace "SampleTest" with the name of your
																			// class
		if (result.getFailureCount() > 0) {
			System.out.println("Test failed.");
			System.exit(1);
		} else {
			System.out.println("Test finished successfully.");
			System.exit(0);
		}
	}

	public static void login(WebDriver driver, JSONObject obj, Logger logger) {
		String username = (String) obj.get("userId");
		String password = (String) obj.get("password");
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

	}

	public boolean compareUserDataWithPageData(MyAccountPage page, JSONObject obj) {
		String firstName = (String) obj.get("firstName");
		String lastName = (String) obj.get("lastName");
		String email = (String) obj.get("email");
		String phone = (String) obj.get("phone");
		String address1 = (String) obj.get("address1");
		String address2 = (String) obj.get("address2");
		String city = (String) obj.get("city");
		String state = (String) obj.get("state");
		String zip = (String) obj.get("zip");
		String country = (String) obj.get("country");
		String language = (String) obj.get("languagePreference");
		String favouriteCategory = (String) obj.get("favouriteCategory");
		Boolean enableMyList = (Boolean) obj.get("enableMyList");
		Boolean enableMyBanner = (Boolean) obj.get("enableMyBanner");

		if (!firstName.equalsIgnoreCase(page.getFirstName())) {
			logger.error("Mismatch in firstName: expected '{}' but found '{}'", firstName, page.getFirstName());
			return false;
		}

		if (!lastName.equalsIgnoreCase(page.getLastName())) {
			logger.error("Mismatch in lastName: expected '{}' but found '{}'", lastName, page.getLastName());
			return false;
		}

		if (!email.equalsIgnoreCase(page.getEmail())) {
			logger.error("Mismatch in email: expected '{}' but found '{}'", email, page.getEmail());
			return false;
		}

		if (!phone.equalsIgnoreCase(page.getPhone())) {
			logger.error("Mismatch in phone: expected '{}' but found '{}'", phone, page.getPhone());
			return false;
		}

		if (!address1.equalsIgnoreCase(page.getAddress1())) {
			logger.error("Mismatch in address1: expected '{}' but found '{}'", address1, page.getAddress1());
			return false;
		}

		if (!address2.equalsIgnoreCase(page.getAddress2())) {
			logger.error("Mismatch in address2: expected '{}' but found '{}'", address2, page.getAddress2());
			return false;
		}

		if (!city.equalsIgnoreCase(page.getCity())) {
			logger.error("Mismatch in city: expected '{}' but found '{}'", city, page.getCity());
			return false;
		}

		if (!state.equalsIgnoreCase(page.getState())) {
			logger.error("Mismatch in state: expected '{}' but found '{}'", state, page.getState());
			return false;
		}

		if (!zip.equalsIgnoreCase(page.getZip())) {
			logger.error("Mismatch in zip: expected '{}' but found '{}'", zip, page.getZip());
			return false;
		}

		if (!country.equalsIgnoreCase(page.getCountry())) {
			logger.error("Mismatch in country: expected '{}' but found '{}'", country, page.getCountry());
			return false;
		}

		if (!language.equalsIgnoreCase(page.getLanguage())) {
			logger.error("Mismatch in language: expected '{}' but found '{}'", language, page.getLanguage());
			return false;
		}

		if (!favouriteCategory.equalsIgnoreCase(page.getFavoriteCategory())) {
			logger.error("Mismatch in favouriteCategory: expected '{}' but found '{}'", favouriteCategory,
					page.getFavoriteCategory());
			return false;
		}

		if (enableMyList != page.isEnableListChecked()) {
			logger.error("Mismatch in enableMyList: expected '{}' but found '{}'", enableMyList,
					page.isEnableListChecked());
			return false;
		}

		if (enableMyBanner != page.isEnableBannerChecked()) {
			logger.error("Mismatch in enableMyBanner: expected '{}' but found '{}'", enableMyBanner,
					page.isEnableBannerChecked());
			return false;
		}

		logger.info("All fields match!");
		return true;
	}

}
