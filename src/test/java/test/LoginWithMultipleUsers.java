package test;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithMultipleUsers {
	WebDriver driver;
	  @BeforeMethod
	  public void setUp() {
	      driver = new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      driver.manage().window().maximize();
	      driver.get("https://adactinhotelapp.com/");
	  }
	  @Test(dataProvider="testData")
	  
	  public void loginPositive(String un, String pwd) {
		  WebElement username=driver.findElement(By.id("username"));
		  WebElement password=driver.findElement(By.id("password"));
		  username.sendKeys(un);
		  password.sendKeys(pwd);
		  driver.findElement(By.id("login")).click();
		  String url="https://adactinhotelapp.com/SearchHotel.php";
		  Assert.assertEquals(url,driver.getCurrentUrl());
		  
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
	  @DataProvider(name="testData")
	  public Object[][] credentials()
	  {
		  return new Object[][] {
		        {"testuser", "test123"},
		        {"kprab", "pra12"},
		        {"", ""}, 
		        {"prabamahi", "praba123"}
		    };
		  
	  }
}
