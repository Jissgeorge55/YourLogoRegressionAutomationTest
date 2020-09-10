package com.yourlogo.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.pages.HomePage;
import com.yourlogo.pages.LoginPage;
import selenium.framework.testbase.TestBase;

public class HomePageTest extends TestBase {
	
	

	HomePage homepage;
    LoginPage loginpage;
	
		public HomePageTest()
		{
			super();           //to call the constructor of the super class ie Base
		}
		
		@BeforeMethod(alwaysRun=true)
		public void setup()
		{
		
		homepage=new HomePage();
		}
		
		
		@Test
		
		public void VerifyHomePagetitletest()
		{
			
			String title= homepage.validatetitle();
			Assert.assertEquals(title, "My Store");
		}
		
		
	   @Test
	   public void VerifyHomePageLogotest()
	   {
		 boolean  flag=homepage.validateLogo();
		 Assert.assertTrue(flag);  
	   }
		
	   @Test
	   public void VerifyHomePageSignInbuttonTest()
	   {
		   loginpage= homepage.SignIn();
	   }
	   
	   
	   
		@AfterMethod(alwaysRun=true)
		
			public void teardown()
			{
				driver.quit();
				
			}
	}


