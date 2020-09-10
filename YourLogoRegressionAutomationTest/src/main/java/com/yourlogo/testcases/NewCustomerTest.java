package com.yourlogo.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.pages.HomePage;
import com.yourlogo.pages.LoginPage;
import com.yourlogo.pages.RegistrationPage;
import selenium.framework.testbase.TestBase;

public class NewCustomerTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	RegistrationPage RegPage;
	
	public NewCustomerTest()
	
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
	
    homepage=new HomePage();
    
    loginpage=homepage.SignIn();
    RegPage=loginpage.Createaccnt("testjs2@gmail.com");
     
    
	}

	@Test
	public void VerifyRegistrationMandatoryFieldsTest()
	{
		
		//RegPage.Registeration("Ricky","Ponding","testjs2@gmail.com" , "test@123", "Rickyy", "Pondingg", "123 street, Ausis","Suncity", "Florida","4355244","6677366");
	}
}
