package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.BookHotelPage;
import pages.LoginPage;
import pages.SearchHotelPage;
import pages.SelectHotelPage;
@Listeners(listeners.TestListener.class)
public class AdactinHotelAppEndToEndTest extends BaseClass {
  @Test(priority=0)
  public void login() {
	  LoginPage l=new LoginPage(driver);
	  l.enter_username("prabamahi");
	  l.enter_passwor("praba123");
	  l.login();
	  verify_login();
	  
  }
  public void verify_login()
  {
	  String expected_url="https://adactinhotlapp.com/SearchHotel.php";
	  Assert.assertEquals(expected_url,driver.getCurrentUrl());
  }
  @Test(priority=1)
  public void searchHotel()
  {
	  SearchHotelPage sh=new SearchHotelPage(driver);
	  sh.select_loc("Sydney");
	  sh.search_click();
	  verify_searchHotel();
  }
  public void verify_searchHotel()
  {
	String selectHotel_url="https://adactinhotelapp.com/SelectHotel.php";
	Assert.assertEquals(selectHotel_url, driver.getCurrentUrl());
  }
  @Test(priority=4)
  public void select_hotel()
  {
    SelectHotelPage hotel=new SelectHotelPage(driver);
	hotel.select_hotel();
	hotel.click_continue();
  }
  @Test(priority=5)
  public void verify_selectHotel()
  {
      String  bookHotel_url="https://adactinhotelapp.com/BookHotel.php";
	  Assert.assertEquals(bookHotel_url, driver.getCurrentUrl());
  }
  @Test(priority=6)
  public void book_hotel()
  {
	BookHotelPage bh=new BookHotelPage(driver);
	bh.enter_first_name("praba");
	bh.enter_last_name("K");
	bh.enter_address("Bangalore");
	bh.enter_credit_card_no("1343343213433432");
	bh.select_card_type("VISA");
	bh.select_month("March");
	bh.select_year("2030");
	bh.enter_cvv("5465");
	bh.click_book_now();
	bh.logout();
  }
}
