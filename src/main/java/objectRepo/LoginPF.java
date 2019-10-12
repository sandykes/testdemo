package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPF {

	
	public WebDriver driver;
	
	public LoginPF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	@FindBy(id="user_email")
	WebElement Email;
	
	@FindBy(id="user_password")
	WebElement Password;
	@FindBy(xpath="//input[@type='submit']")
	
	WebElement Go;
	
	public WebElement Email()
	{
		return Email;
	}
	public WebElement Password()
	{
		return Password;
	}
	public WebElement Go()
	{
		return Go;
	}
	
}
