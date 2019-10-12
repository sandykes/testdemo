package E2EPractice.E2EProject;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRepo.HomePagePF;
import resources.Base;

public class ValidateContacts extends Base {
@BeforeTest
public void initilize() throws IOException
{
	driver=intilizeDriver();
	driver.get(prop.getProperty("Url"));

}
	@Test
	public void VerifyContacts() throws IOException
	{
		
		HomePagePF hp=new HomePagePF(driver);
		Assert.assertTrue(hp.Contact().isDisplayed());
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}
