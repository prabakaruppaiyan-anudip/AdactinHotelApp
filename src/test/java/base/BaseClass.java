package base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	  public static WebDriver driver;
	  @BeforeSuite
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://adactinhotelapp.com/");
	    }

	    @AfterSuite
	    public void tearDown() {
	        driver.quit();
	    }
	    @AfterMethod
	    public void takeScreenshotOnFailure(ITestResult result) throws Exception {

	        if (ITestResult.FAILURE == result.getStatus()) {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);
	            File dest = new File("C:\\Screenshots\\" + result.getName() + ".png");
	            FileUtils.copyFile(src, dest);
	        }
	    }
  
}
