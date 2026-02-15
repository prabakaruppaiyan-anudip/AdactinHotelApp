package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage {
	WebDriver driver;
	public SelectHotelPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="radiobutton_2")
	WebElement choose_hotel;
	@FindBy(id="continue")
	WebElement continue_button;
	
	public void select_hotel()
	{
		choose_hotel.click();
	}
	public void click_continue()
	{
		continue_button.click();
	}

}
