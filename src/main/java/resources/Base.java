package resources;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.RequestCall.RestClient;

import Pojo.UserPoja;



public class Base {
	
	protected WebDriver driver;
	public static UserPoja user;
	private WebDriverWait wait;
	private Actions actions;
	
	private By createAccount =By.linkText("Create an Account");
		
	public WebDriver initializeDriver()
	{
		// can enhance code here to read from properties files , properties such as browser
		
		if(user==null)
		{
			 RestClient ob =new RestClient();
		       user=ob.getrequest();
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(createAccount).click();
		
		
	     
		return driver;
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public UserPoja getUser() {
		
	   return user;
	}

	public WebDriverWait getWait() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		return wait;
	}

	public Actions getActions() {
		actions = new Actions(driver);
		return actions;
	}

	public void setActions(Actions actions) {
		this.actions = actions;
	}
	
	

	
	
	
	


}
