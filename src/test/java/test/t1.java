package test;






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




public class t1 {
	
	
	private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  
	 
	  
	   

	
	
	 @After
	  public void tearDown() {
	  //  driver.quit();
	  }
	
	
	  @Before
	  public void setUp() throws IOException {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\acer\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	    
			    
	    
	  }
	    
	   
	  
	    
	    
	  
	 
	  
	  
	  
	  @Test
	  public void simple() throws InterruptedException {
		  
		  
	    driver.get("https://www.saucedemo.com");
	    driver.manage().window().setSize(new Dimension(1004, 724));
	    
	    
	  	    
	    driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	    
	  	      
	  
	    
	   driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	    
	       
	    
	 
	  
	    
	    driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	    
	    
//	  System.out.println(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]")).getText());
	List<WebElement>
	  products=driver.findElements(By.className("inventory_item_name"));
	for(WebElement i:products) {
		System.out.println(i.getText());
	}
	  
	    
	    
	    
	    
	    
	 	      			
	   			
	   			
	   			
	   			

				
				
				
	    
	    
	  
	   	
	    
	  
	    
	    
	   
	
 

		
		
		  
		  }
	  
	  public static void main(String args[]) {
		  JUnitCore junit = new JUnitCore();
		  junit.addListener(new TextListener(System.out));
		  org.junit.runner.Result result = junit.run(t1.class); // Replace "SampleTest" with the name of your class
		  if (result.getFailureCount() > 0) {
		    System.out.println("Test failed.");
		    System.exit(1);
		  } else {
		    System.out.println("Test finished successfully.");
		    System.exit(0);
		  }
		}
	}
















