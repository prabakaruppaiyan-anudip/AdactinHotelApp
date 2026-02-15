package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage {
	WebDriver driver;
	public SearchHotelPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	WebElement select_location;
	@FindBy(id="Submit")
	WebElement search_button;
	
	public void select_loc(String loc)
	{
		select_location.click();
		Select s=new Select(select_location);
		s.selectByVisibleText(loc);
		
	}
	public void search_click()
	{
		search_button.click();
	}

}
