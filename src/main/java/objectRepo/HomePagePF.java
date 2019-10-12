package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePF {

	public WebDriver driver;
	
public HomePagePF(WebDriver driver)
{
this.driver=driver;	
PageFactory.initElements(driver,this);


}
@FindBy(xpath="//*[text()='Login']")
	WebElement Login;
@FindBy(xpath="//*[contains(text(),'Featured Courses')]")
WebElement Title;

@FindBy(xpath="//a[contains(text(),'Contact')]")
WebElement contact;

public WebElement Login()
{
	return Login;
}
public WebElement Title()
{
	return Title;
}
public WebElement Contact()
{
	return contact;
}

}
