package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookHotelPage {
	WebDriver driver;
	public BookHotelPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="first_name")
	WebElement first_name;
	@FindBy(id="last_name")
	WebElement last_name;
	@FindBy(id="address")
	WebElement addr;
	@FindBy(id="cc_type")
	WebElement card_type;
	@FindBy(id="cc_num")
	WebElement credit_card_no;
	@FindBy(id="cc_exp_month")
	WebElement month;
	@FindBy(id="cc_exp_year")
	WebElement year;
	@FindBy(id="cc_cvv")
	WebElement cvv;
	@FindBy(id="book_now")
	WebElement book_now;
	@FindBy(id="logout")
	WebElement logout;
	
	public void enter_first_name(String fn)
	{
		first_name.sendKeys(fn);
	}
	public void enter_last_name(String ln)
	{
		last_name.sendKeys(ln);
	}
	public void enter_address(String a)
	{
		addr.sendKeys(a);
	}
	public void enter_credit_card_no(String cn)
	{
		credit_card_no.sendKeys(cn);
	}
    public void select_card_type(String ct)
    {
    	Select s=new Select(card_type);
    	s.selectByVisibleText(ct);
    }
    public void select_month(String m)
    {
    	Select s=new Select(month);
    	s.selectByVisibleText(m);
    }
    public void select_year(String y)
    {
    	Select s=new Select(year);
    	s.selectByVisibleText(y);
    }
    public void enter_cvv(String cv)
    {
    	cvv.sendKeys(cv);
    }
    public void click_book_now()
    {
    	book_now.click();
    }
    public void logout()
    {
    	logout.click();
    	
    }
    
}
