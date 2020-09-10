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
import com.yourlogo.pages.SearchPage;
import selenium.framework.testbase.TestBase;
import selenium.framework.utilities.ReadConfigFile;

public class SearchPageTest extends TestBase {

	ReadConfigFile readconfig=new ReadConfigFile();
	HomePage homepage;
	SearchPage searchpage;
	LoginPage loginpage;
	MyAccountPage myaccountpage;

	public SearchPageTest() {
		super();

	}

	@BeforeMethod(alwaysRun=true)
	public void setup() {
	

		homepage = new HomePage();
		searchpage = homepage.SearchProduct();
		//searchpage.clearsearchfield();

	}

	@Test(enabled = true)
	public void VerifySortByLowestPriceTest() {
		boolean result = searchpage.sortByLowestPrice();

		Assert.assertEquals(result, true);
	}

	@Test(groups={"Smoke"})
	public void VerifykeywordFromSearchPageTest() {

		String ActualResult = searchpage.searchbox();

		String ExpectedResult = "\"T-SHIRT\"";
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test(enabled = false)
	public void ValidateMoreButtonTest() {
		boolean ActualResult = searchpage.moreButton();

		Assert.assertEquals(true, ActualResult);

	}
	
	@Test(enabled = true, priority = 0)
	public void ValidateQuickViewLinkTest() throws InterruptedException
	{
		boolean ActualResult = searchpage.quickView();
		
		Assert.assertEquals(true, ActualResult);
		
	}
	
	@Test(enabled=false)
	public void VerifyProductsPerPageTest()
	{
		boolean ActualResult = searchpage.productsPerPage(7);
		Assert.assertEquals(true, ActualResult);
	}
	
	@Test(groups={"Smoke"})
	public void VerifyAddToCartTest() throws InterruptedException
	{
		String expected= searchpage.addtocart();
		String actual = "Product successfully added to your shopping cart";
		
		//.out.println(expected+" msg");
	boolean result = expected.contains(actual);
		Assert.assertTrue(result);
		GetAPage.gotopage(PageType.HomePage);
	}
	
	

	
	@AfterMethod(alwaysRun=true)
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
