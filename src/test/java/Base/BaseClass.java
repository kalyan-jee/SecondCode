package Base;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Pages.Login;
import Utility.Screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	WebDriver driver;
	
	String log4Jpath = System.getProperty("user.dir")+"/log4j.properties";
	Logger logger = Logger.getLogger(BaseClass.class.getName());
	
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void LoginTest() throws InterruptedException, FileNotFoundException
	{
		driver.get("https://www.amazon.in/");
		String title = driver.getTitle();
		
		Login loginObj = new Login(driver);
		Screenshot srcObj = new Screenshot();
		//srcObj.takescreenshot(driver);
		logger.info("first log");
		loginObj.ClickLogin();
		//srcObj.takescreenshot(driver);
		loginObj.sendUserName();
		srcObj.takescreenshot(driver);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(5000);
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}
