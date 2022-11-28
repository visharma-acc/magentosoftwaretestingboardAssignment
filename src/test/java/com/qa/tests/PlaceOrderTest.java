package com.qa.tests;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Pages.CreateAccountPage;
import Pages.HomePage;
import Pages.ReviewPage;
import Pages.ShippingPage;
import Pages.ShoppingCartPage;
import Pages.WatchesPages;
import Pojo.UserPoja;
import resources.*;
import utility.Log;

public class PlaceOrderTest extends Base {
	
	WebDriver driver;
	WebDriverWait wait;
	CreateAccountPage obj;
	HomePage home;
	WatchesPages watchpage;
	ShoppingCartPage shoppingcart;
	ShippingPage shippingpage;
	ReviewPage reviewpage;
	UserPoja user;
	Actions actions;
	
	public  PlaceOrderTest() {
		Base ob=new Base();
	    driver=ob.initializeDriver();
	    user=ob.getUser();
	    obj=new CreateAccountPage();
	    wait=ob.getWait();
	    home=new HomePage();
	    watchpage=new WatchesPages();
	    shoppingcart=new ShoppingCartPage();
	    shippingpage=new ShippingPage();
	    reviewpage=new ReviewPage();
	    actions=ob.getActions();
	  
	    
	    
	}
	
	@Test(enabled = true, description = "Create Account and Place Order Test")
	public void ordertest()
	{
		Log.startTestCase("ordertest");
		obj.resgiter(driver,user);
		String registertext= home.getRegisterText(driver, home.getElementRegisterText(), wait);
		// check Registration is success
		Log.info("Validating Registration is Succes......");
		Assert.assertEquals(registertext, "Thank you for registering with Fake Online Clothing Store.");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	    	
    	home.selectWatchMenu(driver, actions);
    	String itemaddedtext= watchpage.AddWatchToCart(driver, actions, wait);	
    	// check Item Added to Cart 
    	Log.info("Validating Item Added to Cart......");
    	Assert.assertEquals(itemaddedtext,"You added Didi Sport Watch to your shopping cart.");	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	 
    	watchpage.clickonCart(driver);
    	shoppingcart.clickonCheckout(driver);
    	shippingpage.enterShippingDetails(driver, user,wait);
    	reviewpage.clickPlaceOrder(driver,wait);
    	String placedText=reviewpage.GetorderPlacedText(driver,wait);
    	// Check Order Placed
    	Log.info("Validating Order Placed......");  
    	Assert.assertEquals(placedText,"Thank you for your purchase!");
    	
    	Log.endTestCase("ordertest");
	}
	
	@AfterTest()
	public void teardown()
	{
		driver.quit();
	}
	
}
