package accessabilityTest;

import freemarker.template.TemplateException;
import io.github.sridharbandi.AxeRunner;
//import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.sridharbandi.HtmlCsRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

/**
 * A sample test to demonstrate
 */
public class MyAccessabilityTest {

    private WebDriver driver;
    private static HtmlCsRunner htmlCsRunner;
 
    @Before
   
    public void beforeTest() {
    
    	//System.setProperty("webdriver.chrome.driver","C:\\Users\\acer\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        htmlCsRunner = new HtmlCsRunner(driver);
   

    }
    @After
   
    public void tearDown() throws TemplateException, IOException, URISyntaxException {
        htmlCsRunner.execute();
   
       // driver.quit();
        htmlCsRunner.generateHtmlReport();
   
    }

 

    @Test
    public void googleTest() {
        driver.get("https://jpetstore.aspectran.com");
    }

  
}









	
	


