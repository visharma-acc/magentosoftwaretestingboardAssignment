package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Base;
import resources.CommonOperations;

public class ReviewPage extends Base{
	
	private By placeorder=By.xpath("//*[text()='Place Order']");
	
	private By orderPlaced=By.xpath("//span[contains(text(),'Thank you')]");
	
	private By OrderNo=By.xpath("//a[@class='order-number']");
	
	public void clickPlaceOrder(WebDriver driver , WebDriverWait wait)
	{
		wait.until(ExpectedConditions.elementToBeClickable(placeorder));
		WebElement ele = driver.findElement(placeorder);
		//CommonOperations.ClickElement(driver, placeorder);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
	}
	
    public String GetorderPlacedText(WebDriver driver,WebDriverWait wait)
    {
      wait.until(ExpectedConditions.visibilityOfElementLocated(OrderNo));	
      System.out.println(CommonOperations.GetText(driver, OrderNo));	
      return CommonOperations.GetText(driver, orderPlaced);
    }
    
    

}
