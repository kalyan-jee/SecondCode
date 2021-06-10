package Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utility.ConfigClass;
public class Login {
	
	WebDriver driver;
	ConfigClass objConfig = new ConfigClass();
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement login;
@FindBy(className ="a-dropdown-prompt")
	
	WebElement userName;
	
	@FindBy(id = "s-result-sort-select_2")
	WebElement dropdown;
	
	
	@FindBy(name = "password")
	WebElement password;
	
   public Login(WebDriver driver)
   {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
   }
	
   public void ClickLogin() throws FileNotFoundException
   { 
	  String Value = objConfig.readConfig("value");
	   login.sendKeys(Value);
	   login.sendKeys(Keys.ENTER);
   }
   
   public void sendUserName()
   {
	   userName.click();
	   dropdown.click();
   }
   
   public void sendPassword()
   {
	   password.sendKeys("Nike1234");
   }
	

}
