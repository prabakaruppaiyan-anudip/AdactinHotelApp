package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseClass{
	
  @Test
  public void login() {
	  LoginPage l=new LoginPage(driver);
	  l.enter_username("prabamahi");
	  l.enter_passwor("praba123");
	  l.login();
	  String expected_url="https://adactinhotelapp.com/SearchHotel.php";
	  Assert.assertEquals(expected_url,driver.getCurrentUrl());
  }
}
