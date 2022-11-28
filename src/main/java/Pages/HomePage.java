package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import resources.Base;
import resources.CommonOperations;

public class HomePage extends Base{
	
	private By RegisterText=By.xpath("//div[contains(text(),'Thank you')]");
	private By GearMenu =By.xpath("//span[text()='Gear']");
	private By WatchMenu=By.xpath("//span[text()='Watches']"); 
	
	
	public String getRegisterText(WebDriver driver, By element , WebDriverWait wait)
	{
	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterText));
		return CommonOperations.GetText(driver, RegisterText);
		
	}

	public void selectWatchMenu(WebDriver driver,Actions actions)
	{
		WebElement menuOption = driver.findElement(GearMenu);
    	actions.moveToElement(menuOption).perform();
    	WebElement subMenuOption = driver.findElement(WatchMenu); 
    	actions.moveToElement(subMenuOption).click().build().perform();
	}
	

	public By getElementRegisterText() {
		return RegisterText;
	}


	public void setRegisterText(By registerText) {
		RegisterText = registerText;
	}
	


	 
}
