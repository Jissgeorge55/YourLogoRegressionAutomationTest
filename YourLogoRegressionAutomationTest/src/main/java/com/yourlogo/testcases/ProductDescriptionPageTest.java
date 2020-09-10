package com.yourlogo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.pages.GetAPage;
import com.yourlogo.pages.HomePage;
import com.yourlogo.pages.LoginPage;
import com.yourlogo.pages.MyAccountPage;
import com.yourlogo.pages.PageType;
import com.yourlogo.pages.ProductDescriptionPage;
import com.yourlogo.pages.SearchPage;

import selenium.framework.testbase.TestBase;
import selenium.framework.utilities.ReadConfigFile;

public class ProductDescriptionPageTest extends TestBase {
	
	ReadConfigFile readconfig=new ReadConfigFile();
	HomePage homepage;
	LoginPage loginpage;
	MyAccountPage myaccountpage;
	ProductDescriptionPage productpage;
	
	public ProductDescriptionPageTest()
	{
		super();
	}

	
	@BeforeMethod(alwaysRun=true)
	public void setup()
	{
		homepage = new HomePage();
		productpage=(ProductDescriptionPage) GetAPage.gotopage(PageType.ProductDescriptionPage);
		
	}
	
	@Test(groups={"Smoke"})
	public void VerifyAddtoCartTest()
	{
		String actual=productpage.addToCart();
		String expected = "Product successfully added to your shopping cart";
		
		Assert.assertTrue((actual.contains(expected)));
		
		
	}
	
	@Test
	public void VerifyAddToWishlistTest()
	{
		loginpage= (LoginPage) GetAPage.gotopage(PageType.LoginPage);
		loginpage.login(readconfig.getUsername(),readconfig.getPassword());
		productpage=(ProductDescriptionPage) GetAPage.gotopage(PageType.ProductDescriptionPage);
		 boolean expected = productpage.addtowishlist();
		 
		 Assert.assertTrue(expected);
		 
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void getResult(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
				{
			captureScreen(driver, result.getName());
			System.out.println(result.getMethod().getMethodName()+ "Failed");
		
				}
	}
}
