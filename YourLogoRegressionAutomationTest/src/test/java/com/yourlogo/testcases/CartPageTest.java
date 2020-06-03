package com.yourlogo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.pages.CartPage;
import com.yourlogo.pages.HomePage;
import com.yourlogo.pages.SearchPage;
import selenium.framework.testbase.TestBase;

public class CartPageTest extends TestBase {

	HomePage homepage;
	SearchPage searchpage;
	CartPage cartpage;

	public CartPageTest() {
		super(); // to call the constructor of the super class ie Base
	}

	@BeforeMethod
	public void precondition() throws InterruptedException {
		

		homepage = new HomePage();
		homepage.SearchProduct();

		searchpage = new SearchPage();
		cartpage = searchpage.addtocart1();
	}

	@Test(enabled = true)
	public void VerifyCartPagetitleTest() throws IOException {
		String ActualTitle = cartpage.cartPagetitle();

		String ExpectedTitile = "Order - My Store";

		Assert.assertEquals(ActualTitle, ExpectedTitile);
		cartpage.cartPagescreenshot();

	}

	@Test(enabled = true)
	public void VerifyContinueShopping() {

		searchpage = cartpage.ContinueShopping();

		String ExpectedTitle = driver.getTitle();
		String ActualTitle = "Search - My Store";

		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@Test
	public void DeleteProductTest() throws InterruptedException {
		boolean EmptyShoppingCart = cartpage.deleteProduct();
		Assert.assertEquals(true, EmptyShoppingCart);
	}

	@AfterMethod(enabled = true)
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			captureScreen(driver, result.getMethod().getMethodName());
			System.out.println(result.getMethod().getMethodName()+" Failed");
			
		}
		
	}

}
