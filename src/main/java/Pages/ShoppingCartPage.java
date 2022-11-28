package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.Base;
import resources.CommonOperations;

public class ShoppingCartPage extends Base{

	private By checkoutbutton=By.xpath("//button[@class='action primary checkout' and @data-role='proceed-to-checkout']");
	
	public void clickonCheckout(WebDriver driver)
	{
		CommonOperations.ClickElement(driver, checkoutbutton);
	}
}
