package com.yourlogo.testcases;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.yourlogo.pages.HomePage;
import com.yourlogo.pages.LoginPage;
import com.yourlogo.pages.RegistrationPage;
import selenium.framework.testbase.TestBase;
import selenium.framework.utilities.ReadExcel;
//import selenium.framework.utilities.TestUtil;

public class RegestrationPageTest extends TestBase {
	



	
	HomePage homepage;
	LoginPage loginpage;
	RegistrationPage RegPage;
	
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
    RegPage=loginpage.Createaccnt("testjs2@gmail.com");
     
    
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
	public void verifyReadDatafromExcel(String title, String firstname, String lastname, String password,String DOB, String address, String city, String state, String zipcode,String country, String phone)
	{
		//RegPage.Registeration(firstname, lastname,  password,   address, city, state, zipcode, country, phone);
		System.out.println(firstname);
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
