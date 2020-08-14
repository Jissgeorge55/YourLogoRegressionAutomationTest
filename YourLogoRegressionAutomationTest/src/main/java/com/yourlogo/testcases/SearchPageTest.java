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
	
	@Test
	public void AddToWishlist()
	{
		loginpage= (LoginPage) GetAPage.gotopage(PageType.LoginPage);
		myaccountpage=loginpage.login(readconfig.getUsername(),readconfig.getPassword());
		 searchpage=myaccountpage.searchText("Dresses");
		 boolean expected = searchpage.addtowishlist();
		 
		 Assert.assertTrue(expected);
		 
	}

	@Test
	public void LoadPage()
	{
		GetAPage.gotopage(PageType.CartPage);
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
