package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.SearchHotelPage;
import pages.SelectHotelPage;

public class SelectHotelPageTest extends BaseClass {
  @Test
  public void select_hotel() {
	  LoginPage l=new LoginPage(driver);
	  l.enter_username("prabamahi");
	  l.enter_passwor("praba123");
	  l.login();
	  String expected_url="https://adactinhotelapp.com/SearchHotel.php";
	  Assert.assertEquals(expected_url,driver.getCurrentUrl());
	  SearchHotelPage sh=new SearchHotelPage(driver);
	  sh.select_loc("Sydney");
	  sh.search_click();
	  String selectHotel_url="https://adactinhotelapp.com/SelectHotel.php";
	  Assert.assertEquals(selectHotel_url, driver.getCurrentUrl());
	  SelectHotelPage hotel=new SelectHotelPage(driver);
	  hotel.select_hotel();
	  hotel.click_continue();
	  String  bookHotel_url="https://adactinhotelapp.com/BookHotel.php";
	  Assert.assertEquals(bookHotel_url, driver.getCurrentUrl());
	  
  }
}
