package com.yourlogo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.pages.HomePage;
import com.yourlogo.pages.SearchPage;
import selenium.framework.testbase.TestBase;

public class SearchPageTest extends TestBase {

	HomePage homepage;
	SearchPage searchpage;

	public SearchPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
	

		homepage = new HomePage();
		searchpage = homepage.SearchProduct();
		//searchpage.clearsearchfield();

	}

	@Test(enabled = true)
	public void SortByLowestPriceTest() {
		boolean result = searchpage.sortByLowestPrice();

		Assert.assertEquals(result, true);
	}

	@Test(enabled = true)
	public void keywordFromSearchPageTest() {

		String ActualResult = searchpage.searchbox();

		String ExpectedResult = "\"T-SHIRT\"";
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test(enabled = false)
	public void MoreButtonTest() {
		boolean ActualResult = searchpage.moreButton();

		Assert.assertEquals(true, ActualResult);

	}
	
	@Test(enabled = true)
	public void QuickViewLinkTest() throws InterruptedException
	{
		boolean ActualResult = searchpage.quickView();
		
		Assert.assertEquals(true, ActualResult);
		
	}
	
	@Test(enabled=false)
	public void ProductsPerPageTest()
	{
		boolean ActualResult = searchpage.productsPerPage(7);
		Assert.assertEquals(true, ActualResult);
	}
	
	@Test
	public void AddToCartTest() throws InterruptedException
	{
		String expected= searchpage.addtocart();
		String actual = "Product successfully added to your shopping cart";
		
		//.out.println(expected+" msg");
	boolean result = expected.contains(actual);
		Assert.assertTrue(result);
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException, InterruptedException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Thread.sleep(1000);
			captureScreen(driver, result.getName());
			System.out.println(result.getMethod().getMethodName()+" Failed");
			
		}
		
	}
}
