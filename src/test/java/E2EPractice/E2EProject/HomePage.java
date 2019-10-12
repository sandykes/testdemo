package E2EPractice.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepo.HomePagePF;
import objectRepo.LoginPF;
import resources.Base;

public class HomePage extends Base {
	public static Logger log=LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initilize() throws IOException
	{
		driver=intilizeDriver();

	}
	
@Test
	public void HPNavigation() throws IOException 
	{
	driver.get(prop.getProperty("Url"));

	
		HomePagePF Hp= new HomePagePF(driver);
		Hp.Login().click();
		log.info(driver.getTitle());
		
	}
@ Test(dataProvider="getData")
public void  Login(String UserName, String Password)
{
	driver.get(prop.getProperty("Url"));
	HomePagePF Hp= new HomePagePF(driver);
	Hp.Login().click();

	LoginPF lp=new LoginPF(driver);
	lp.Email().sendKeys(UserName);
	lp.Password().sendKeys(Password);
	lp.Go().click();
	log.info("Data driven test is completed");
	
	
}
@AfterTest
public void tearDown()
{
	driver.close();
	driver=null;
}
@DataProvider
public Object[][]  getData()
{
	Object[][] data= new Object[3][2];
	//3 sets of data (userName and passowrd)
	data[0][0]="test1@Test.com";
	data[0][1]="test123";
	data[1][0]="sandy@test.com";
	data[1][1]="test456";
	data[2][0]="ray@test.com";
	data[2][1]="test897";
	return data;
	
	
}

}
