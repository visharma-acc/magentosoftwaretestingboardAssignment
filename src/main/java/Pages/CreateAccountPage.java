package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pojo.UserPoja;
import resources.CommonOperations;
import utility.Log;
import resources.Base;

public class CreateAccountPage extends Base{
	
	private By firstname=By.id("firstname");
	private By lastname=By.id("lastname");
	private By email=By.name("email");
	private By password=By.id("password");
	private By confirmPassword=By.name("password_confirmation");
	private By createAccountButton=By.xpath("//button[@title='Create an Account']");
	
	
	public void resgiter(WebDriver driver,UserPoja user)
	{
		Log.info("perfmoing register on page.."+this.getClass().getName());
		CommonOperations.InsertValueInTextField(driver, firstname, user.getFirstname());
		CommonOperations.InsertValueInTextField(driver, lastname, user.getLastname());
		CommonOperations.InsertValueInTextField(driver, email, user.getEmail());
		CommonOperations.InsertValueInTextField(driver, password, user.getPassword());
		CommonOperations.InsertValueInTextField(driver, confirmPassword, user.getPassword());
		CommonOperations.ClickElement(driver, createAccountButton);
	}
	
}
