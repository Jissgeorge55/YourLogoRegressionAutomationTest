package com.yourlogo.testcases;


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
	
	@DataProvider
	/*public Iterator<Object[]> getData()
	{
		ArrayList<Object[]> testdata= TestUtil.getDataFromExcel();
		return testdata.iterator();
	}
	

	@Test(dataProvider="getData")
	public void verifyReadDatafromExcel(String firstname, String lastname, String email, String password, String addname1, String addname2, String address, String city, String state, String postcode, String phone)
	{
		RegPage.Registeration(firstname, lastname, email, password, addname1, addname2, address, city, state, postcode, phone);
		
	}*/

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
