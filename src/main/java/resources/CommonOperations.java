package resources;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.*;
public class CommonOperations {
	
	
	
	public static void InsertValueInTextField(WebDriver driver,By element, String data)
	{
		Log.info("Entering data in text field:"+ element.toString());
	  	driver.findElement(element).sendKeys(data);
	  	Log.info("Data entered in text field:"+ element.toString());
	}
	
	public static void ClickElement(WebDriver driver,By element)
	{
		Log.info("perfmoring click operation on:"+ element.toString());
		driver.findElement(element).click();
		Log.info("click operation perfmoed on:"+ element.toString());
	}
	
	public static void SelectDropDown(WebDriver driver,By element ,String Data)
	{
		Select select = new Select(driver.findElement(element));
		
	
		List<WebElement> options = select.getOptions();
		boolean flag=false;
	
		for (WebElement item :options)
		{
			//System.out.println(item.getText());
			if(item.getText().contains(Data))
			{	
				System.out.println("Select Condition Satisfied..");
				System.out.println(Data);
				select.selectByVisibleText(item.getText());
				flag=true;
			}	
			if(flag==false)
				select.selectByIndex(1);
		}
		
		Log.info("Perfomed Select on dropdown on:"+ element.toString());
		
		//select.selectByVisibleText(Data);
		
	}

	public static String GetText(WebDriver driver, By element)
	{
	  Log.info("Get Text for web element"+ element.toString());
	  return driver.findElement(element).getText();	
	}
	
	
	
}
