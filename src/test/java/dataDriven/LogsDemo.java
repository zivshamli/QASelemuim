package dataDriven;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

import org.apache.logging.log4j.*;


public class LogsDemo {
    /**
		* @param args
    */
	public static WebDriver driver;
	
    public static void main(String[] args) {
    	
         // TODO Auto-generated method stub
    	//System.setProperty("webdriver.chrome.driver","C:\\Users\\acer\\Downloads\\chromedriver_win32\\chromedriver.exe");

    	
    	driver = new ChromeDriver();
	   

         //Logger log = Logger.getLogger("devpinoyLogger");
         Logger logger=LogManager.getLogger(LogsDemo.class);
         
         driver.get("http://healthunify.com/bmicalculator/");
		 logger.info("opening webiste");
       //  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 logger.debug("entring weight");
		 driver.findElement(By.name("wg")).sendKeys("87");
         logger.debug("selecting kilograms");
         driver.findElement(By.name("opt1")).sendKeys("kilograms");
         logger.debug("selecting height in feet");
         driver.findElement(By.name("opt2")).sendKeys("5");
         logger.debug("selecting height in inchs");
         driver.findElement(By.name("opt3")).sendKeys("10");
         logger.debug("Clicking on calculate");
         driver.findElement(By.name("cc")).click();

         logger.debug("Getting SIUnit value");
         String SIUnit = driver.findElement(By.name("si")).getAttribute("value");
         logger.debug("Getting USUnit value");
         String USUnit = driver.findElement(By.name("us")).getAttribute("value");
         logger.debug("Getting UKUnit value");
         String UKUnit = driver.findElement(By.name("uk")).getAttribute("value");
         logger.debug("Getting overall description");
         String note = driver.findElement(By.name("desc")).getAttribute("value");
      
         System.out.println("SIUnit = " + SIUnit);
         System.out.println("USUnit = " + USUnit);
         System.out.println("UKUnit = " + UKUnit);
         System.out.println("note = " + note); 
		driver.quit();
	}
}


