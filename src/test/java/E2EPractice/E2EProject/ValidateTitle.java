package E2EPractice.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepo.HomePagePF;
import objectRepo.LoginPF;
import resources.Base;

public class ValidateTitle extends Base {
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initilize() throws IOException
	{
		driver=intilizeDriver();
		log.info("driver is intilized");
		driver.get(prop.getProperty("Url"));
		log.info("Navigated to Home Page");

	}
@Test
	public void HPNavigation() throws IOException 
	{
		
		
		HomePagePF Hp= new HomePagePF(driver);
		System.out.println(driver.getTitle());
	String 	actualText=Hp.Title().getText();
	String expectedText= "FEATURED COURSES";
	Assert.assertEquals(actualText, expectedText);
	log.info("Validation is successful");
	}
@AfterTest
public void tearDown()
{
	driver.close();
	driver=null;
}


}
