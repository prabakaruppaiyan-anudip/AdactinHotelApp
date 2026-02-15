package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="username")
	WebElement uname;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login")
	WebElement login_button;
	
	public void enter_username(String un)
	{
		uname.sendKeys(un);
	}
	public void enter_passwor(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void login()
	{
		login_button.click();
	}
	
	
	

}
