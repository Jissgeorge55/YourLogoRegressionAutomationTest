package com.yourlogo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.yourlogo.pages.CartPage;
import com.yourlogo.pages.GetAPage;
import com.yourlogo.pages.HomePage;
import com.yourlogo.pages.SearchPage;
import com.yourlogo.pages.SelectProduct;

import selenium.framework.testbase.TestBase;
import selenium.framework.utilities.ReadConfigFile;
import selenium.framework.utilities.ReadExcel;

public class CartPageTest extends TestBase {
	
	

	HomePage homepage;
	SearchPage searchpage;
	CartPage cartpage;

	public CartPageTest() {
		super(); // to call the constructor of the super class ie Base
	}

	@BeforeMethod(alwaysRun=true)
	public void precondition() throws InterruptedException {
		

		homepage = new HomePage();
		homepage.SearchProduct();

		/*searchpage = new SearchPage();
		           searchpage.addtocart();
		cartpage = searchpage.proccedToCheckout();*/
	}

	@Test(enabled = true)
	public void VerifyCartPagetitleTest() throws IOException, InterruptedException {
		
		searchpage = new SearchPage();
        searchpage.addtocart();
cartpage = searchpage.proccedToCheckout();
		String ActualTitle = cartpage.cartPagetitle();

		String ExpectedTitile = "Order - My Store";

		Assert.assertEquals(ActualTitle, ExpectedTitile);
		cartpage.cartPagescreenshot();

	}

	@Test(groups={"Smoke"})
	public void VerifyContinueShopping() throws InterruptedException {
		searchpage = new SearchPage();
        searchpage.addtocart();
cartpage = searchpage.proccedToCheckout();
		searchpage = cartpage.ContinueShopping();

		String ExpectedTitle = driver.getTitle();
		String ActualTitle = "Search - My Store";

		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@Test
	public void DeleteProductTest() throws InterruptedException {
		searchpage = new SearchPage();
        searchpage.addtocart();
cartpage = searchpage.proccedToCheckout();
		boolean EmptyShoppingCart = cartpage.deleteProduct();
		Assert.assertEquals(true, EmptyShoppingCart);
	}
	
	
	@Test
	public void VerifyTotalPriceTest()
	{
		SelectProduct.standardProduct();
	}
	
	
	@Test(dataProvider = "GetNormalProduct")
	public void VerifyPriceDetails_fromExcel(String ProductName, String UnitPrice, String ShppingPrice, String TotalPrice, String url)
	{
		
	}

	@DataProvider(name = "GetNormalProduct")
	public String[][] getProduct() throws IOException
	{
		
		String[][]  productdetails = getdata("Normal_Product");
		return productdetails;			
	}
	
	
	public String[][] getdata(String sheetname) throws IOException
			{
		String xlfile = (System.getProperty("user.dir"))+"/src/test/java/selenium/framework/testdata/Products Data.xlsx";
		int rownum = ReadExcel.getRowCount(xlfile, sheetname);
		int colnum = ReadExcel.getCellCount(xlfile, sheetname, rownum);
		
		String[][]  testdata = new String[rownum][colnum];
		
		for(int i =1;i<=rownum;i++)
		{
			for (int j=0;j<colnum;j++)
			{
				testdata[i-1][j]=ReadExcel.getCellData(xlfile, sheetname, rownum, colnum);
			}
		}
		
		return testdata;
			}
	
	@AfterMethod(alwaysRun=true)
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			captureScreen(driver, result.getMethod().getMethodName());
			System.out.println(result.getMethod().getMethodName()+" Failed");
			
		}
		
	}

}
