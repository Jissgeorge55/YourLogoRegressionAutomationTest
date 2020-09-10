package com.yourlogo.testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.yourlogo.pages.CartPage;
import com.yourlogo.pages.HomePage;
import com.yourlogo.pages.LoginPage;
import com.yourlogo.pages.MyAccountPage;
import selenium.framework.testbase.TestBase;
import selenium.framework.utilities.ReadConfigFile;

public class LoginPageTest extends TestBase
{
	ReadConfigFile readconfig=new ReadConfigFile();
	HomePage homepage;
	LoginPage loginpage;
	MyAccountPage myaccountpage;
	CartPage cartpage;

	
	public LoginPageTest()
	{
		super();           //to call the constructor of the super class ie Base
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup()
	{

    homepage=new HomePage();
    
    loginpage=homepage.SignIn();
	}
	
	
	
	
//This test is to verify the title of the Login page
@Test (enabled = true)

public void VerifyLoginPagetitletest() 
	{
		
		String title= loginpage.title();
		Assert.assertEquals(title, "Login - My Store");
	}




//This test case is to verify whether user can login with valid credentials.
@Test (groups={"Smoke"})
public void ValidateLoginTest()
	{
		myaccountpage=loginpage.login(readconfig.getUsername(),readconfig.getPassword());
		String MyAccountTitle=myaccountpage.pagetitle();
		String ExpectedTitle= "My account - My Store";
		Assert.assertEquals(MyAccountTitle, ExpectedTitle);
	}




//This test case is to verify whether user can successfully Logout.
@Test(groups={"Smoke"})
public void VerifySignOutTest()
	{
		boolean SignInButtonDisplay=loginpage.logout(readconfig.getUsername(),readconfig.getPassword());
		
		Assert.assertEquals(SignInButtonDisplay, true);
	}




//This test case is to verify that user should not login with invalid credentials
@Test(enabled = true)
public void InvalidCredentialsTest()
	{
		String ErrorMessage = loginpage.invalidcredentials("ttesst@hhdj.com", "dscsdgcv");
		
		String ExpectedError="Authentication failed.";
		boolean expected=false;
		
		if(ErrorMessage.contentEquals(ExpectedError))
		{
			expected=true;
		}
		
		Assert.assertTrue(expected);
		}




//This test case is to verify that user should not able to enter invalid email 
//to create new customer
	
@Test(enabled = true)
public void validateInvalidCreateEmail() throws InterruptedException, IOException
	{
		String errorMsg=loginpage.CreateError();
		Assert.assertEquals(errorMsg, "Invalid email address.");
		//takescreenshot ("login_error");
		
	}




//This test is to verify the cart link in Login page
	
@Test
public void VerifyCartLinkTest()
	{
		cartpage= loginpage.Cartlink();
		String PageTitle=driver.getTitle();
		
		String ExpectedTitle="Order - My Store";
		Assert.assertEquals(PageTitle, ExpectedTitle);
	}




//This test is to verify the search box in login page.
@Test
public void VerifySearchBox()
{
	loginpage.search("dresses");
	
	String ActualTitle=driver.getTitle();
	String ExpectedTitle="Search - My Store";
	
	Assert.assertEquals(ActualTitle, ExpectedTitle);
	
}

@Test(groups={"Smoke"})
public void VerifyForgetPasswordtest()
{
	String expectedtext=loginpage.forgetPassword(readconfig.getUsername());
	String actualtext= "A confirmation email has been sent to your address: "+readconfig.getUsername() ;
	
	Assert.assertEquals(actualtext,expectedtext );
}

@Test(dataProvider = "topNavigations")
public void VerifyTopNavigationOnLogin(String topnav)
{
	String actualtitle=loginpage.clickTopNavigation(topnav);
	System.out.println(actualtitle);
	
	String expectedtitle= topnav+" - My Store";
	Assert.assertEquals(actualtitle,expectedtitle );
}

@DataProvider(name="topNavigations")
public Object topNavigations()
{
	return new Object[][]
			{	
		{readconfig.gettopnav1()},
		{readconfig.gettopnav2()},
		{readconfig.gettopnav3()},
		};
}



	
	
private Object Object(String gettopnav1, String gettopnav2, String gettopnav3) {
	// TODO Auto-generated method stub
	return null;
}

@AfterMethod (alwaysRun=true)
public void getResult(ITestResult result) throws IOException
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		captureScreen(driver, result.getName());
		System.out.println(result.getMethod().getMethodName()+" Failed");
		
	}
	
	try {
		
		loginpage.Signout();
		
	}
	catch(Exception e)
	{
		
	}
	
}
}
