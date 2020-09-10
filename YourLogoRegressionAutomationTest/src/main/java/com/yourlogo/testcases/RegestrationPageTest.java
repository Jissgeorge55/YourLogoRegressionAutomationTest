package com.yourlogo.testcases;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.yourlogo.pages.HomePage;
import com.yourlogo.pages.LoginPage;
import com.yourlogo.pages.MyAccountPage;
import com.yourlogo.pages.RegistrationPage;
import selenium.framework.testbase.TestBase;
import selenium.framework.utilities.ReadExcel;
//import selenium.framework.utilities.TestUtil;

public class RegestrationPageTest extends TestBase {
	



	
	HomePage homepage;
	LoginPage loginpage;
	RegistrationPage RegPage;
	MyAccountPage myaccountpage;
	
	public RegestrationPageTest()
	
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
	//initialization();
    homepage=new HomePage();
    
    loginpage=homepage.SignIn();
    
    try {
    RegPage=loginpage.Createaccnt("testjs2@gmail.com");
    }catch (Exception e)
    {
    	
    }
     
    
	}
	
	@DataProvider(name ="Testdata")
	public String[][] getData() throws IOException
	{
		String xlfile = (System.getProperty("user.dir"))+"/src/test/java/selenium/framework/testdata/TestData3.xlsx";
		int rownum = ReadExcel.getRowCount(xlfile, "Sheet1");
		int columnnum = ReadExcel.getCellCount(xlfile, "Sheet1", rownum);
		String[][] testdata= new String[rownum][columnnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<columnnum;j++)
			{
				testdata[i-1][j] = ReadExcel.getCellData(xlfile,"Sheet1",i, j );
			}
		}
		
		return testdata;
				
				
	}
	

	@Test(dataProvider ="Testdata")
	public void verifyReadDatafromExcel(String title, String firstname, String lastname,String email, String password,String DOB, String address, String city, String state, String zipcode,String country, String phone)
	{
		RegPage = loginpage.Createaccnt(email);
		RegPage.EnterDetails(title,firstname, lastname,  password, DOB,address, city, state, zipcode, country, phone);
		myaccountpage=RegPage.clickRegesterButton();
		String actual = myaccountpage.pagetitle();
		
		String expected = "My account - My Store";
		
		Assert.assertEquals(actual, expected);
		
		
		
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
				{
			captureScreen(driver, result.getName());
			System.out.println(result.getMethod().getMethodName()+ "Failed");
		
				}
	}
	
}
