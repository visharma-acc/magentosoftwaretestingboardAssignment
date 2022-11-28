package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pojo.UserPoja;
import resources.Base;
import resources.CommonOperations;

public class ShippingPage extends Base {
	
	
	
	private By firstname=By.name("firstname");
	private By lastname=By.name("lastname");
	//private By email=By.id("customer-email");
	private By street=By.name("street[0]");
	private By city=By.name("city");
	private By state=By.name("region_id");
	private By zipcode=By.name("postcode");
	private By country=By.name("country_id");
	private By phone=By.name("telephone");
	private By shipping=By.name("ko_unique_1");
	private By nextButton=By.xpath("//button//*[text()='Next']");
	
    public void enterShippingDetails(WebDriver driver,UserPoja user,WebDriverWait wait)
    {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
    	wait.until(ExpectedConditions.presenceOfElementLocated(firstname));
    	wait.until(ExpectedConditions.presenceOfElementLocated(lastname));
    	wait.until(ExpectedConditions.presenceOfElementLocated(city));
    	//wait.until(ExpectedConditions.elementToBeSelected(country));
    	//wait.until(ExpectedConditions.elementToBeSelected(state));
    	//CommonOperations.InsertValueInTextField(driver, email, user.getEmail());
    	CommonOperations.InsertValueInTextField(driver, firstname, user.getFirstname());
    	CommonOperations.InsertValueInTextField(driver, lastname, user.getLastname());
    	CommonOperations.InsertValueInTextField(driver, street, user.getAddress().getLocation());
    	CommonOperations.InsertValueInTextField(driver, city, user.getAddress().getCity());
    	CommonOperations.SelectDropDown(driver, country, user.getAddress().getCountry());
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	//wait.until(ExpectedConditions.elementToBeSelected(state));
    	CommonOperations.SelectDropDown(driver, state, user.getAddress().getState());
    	CommonOperations.InsertValueInTextField(driver, zipcode, user.getAddress().getPostcode());
    	CommonOperations.InsertValueInTextField(driver, phone, user.getAddress().getPhone());
    	//CommonOperations.ClickElement(driver, shipping);
    	CommonOperations.ClickElement(driver, nextButton);
    	
    }
	
	

}
