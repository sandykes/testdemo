package resources;

import java.io.File;
import org.apache.commons.io.FileUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public static WebDriver driver;
	public Properties prop;
	public  WebDriver intilizeDriver() throws IOException
	{
		 prop=new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\surya\\eclipse-SandyWorksapce\\E2EProject\\data.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			driver=new InternetExplorerDriver();
		}
		else if (browserName.equalsIgnoreCase("FireFox"))
		
		{
			driver= new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		return driver;
	}
	
	public void takeScreenShot(String result) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Sandya\\Selenium\\"+result+"_screenshot.png"));
	}

}
