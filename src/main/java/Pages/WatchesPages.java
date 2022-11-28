package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Base;
import resources.CommonOperations;

public class WatchesPages extends Base{
	
	private By watchItem=By.xpath("//a[contains(text(),'Didi Sport')]");
	
	private By AddToCart=By.xpath("//a[contains(text(),'Didi Sport')]//following::div[6]//span[contains(text(),'Cart')]");
	
	private By itemadded=By.xpath("//div[contains(text(),'You added Didi Sport Watch')]");
	
	private By shoppingcart=By.xpath("//a[text()='shopping cart']");
	//WebElement watchItem = driver.findElement(By.xpath("//a[contains(text(),'Didi Sport')]"));
	
	
	
	
	// AddToCart = driver.findElement(By.xpath("//a[contains(text(),'Didi Sport')]//following::div[6]//span[contains(text(),'Cart')]")); 
	//Mouse hover menuOption 'Rock'
//	actions.moveToElement(AddToCart).click().build().perform();
	
	
	

//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'You added Didi Sport Watch')]")));
	//WebElement itemadded=driver.findElement(By.xpath("//div[contains(text(),'You added Didi Sport Watch')]"));
	//System.out.println(itemadded.getText() );
	
	public String AddWatchToCart(WebDriver driver, Actions actions, WebDriverWait wait)
	{
		WebElement menuOption = driver.findElement(watchItem);
		actions.moveToElement(menuOption).perform();
		WebElement subMenuOption = driver.findElement(AddToCart); 
    	actions.moveToElement(subMenuOption).click().build().perform();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(itemadded));
    	return CommonOperations.GetText(driver, itemadded);
		
	}
	
	public void clickonCart(WebDriver driver)
	{
		CommonOperations.ClickElement(driver, shoppingcart);
	}

	public void cart(WebDriver driver , WebDriverWait wait)
	{
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	    	
	    	
    	 
		   WebElement ele=driver.findElement(By.xpath("//a[@class='action showcart']"));
		       
		       executor.executeScript("arguments[0].click();", ele);
		       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		      // driver.switchTo().activeElement(); 
		      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Proceed to Checkout']")));
		      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		     WebElement element= driver.findElement(By.xpath("//button[@title='Proceed to Checkout']"));    
		      executor.executeScript("arguments[0].click();", element);
	}
	
}
