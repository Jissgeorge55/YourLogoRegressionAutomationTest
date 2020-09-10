package com.yourlogo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.pages.GetAPage;
import com.yourlogo.pages.HomePage;
import com.yourlogo.pages.PageType;
import com.yourlogo.pages.QuickView;
import selenium.framework.testbase.TestBase;

public class QuickViewTest extends TestBase{
	
	HomePage homepage;
	QuickView quickview;
	
	
	public QuickViewTest()
	{
		super();           //to call the constructor of the super class ie Base
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup()
	{
	
    homepage=new HomePage();
    quickview= homepage.Dresses();
	}
    
    @Test (groups={"Smoke"})
    public void VerifyProductAddtoCartTest() throws InterruptedException
    {
    	String pagetitle=quickview.AddToCart();
    	
    	System.out.println(pagetitle);
    	Assert.assertEquals(pagetitle,"Order - My Store");
}

    @AfterMethod (enabled = true)
    public void getResult(ITestResult result) throws IOException, InterruptedException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Thread.sleep(1000);
			captureScreen(driver, result.getName());
			System.out.println(result.getMethod().getMethodName()+" Failed");
			GetAPage.gotopage(PageType.HomePage);
			
		}
		
	}
    
    
    
}