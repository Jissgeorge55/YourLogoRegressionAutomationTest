package com.yourlogo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.pages.HomePage;
import com.yourlogo.pages.QuickView;
import selenium.framework.testbase.TestBase;

public class QuickViewTest extends TestBase{
	
	HomePage homepage;
	QuickView quickview;
	
	
	public QuickViewTest()
	{
		super();           //to call the constructor of the super class ie Base
	}
	
	@BeforeMethod
	public void setup()
	{
	
    homepage=new HomePage();
    quickview= homepage.Dresses();
	}
    
    @Test (enabled = true)
    public void VerifyProductAddtoCartTest() throws InterruptedException
    {
    	String pagetitle=quickview.AddToCart();
    	
    	System.out.println(pagetitle);
    	Assert.assertEquals(pagetitle,"Order - My Store");
}

    @AfterMethod (enabled = true)
	public void teardown()
	{
		driver.quit();
	}
    
    
    
}