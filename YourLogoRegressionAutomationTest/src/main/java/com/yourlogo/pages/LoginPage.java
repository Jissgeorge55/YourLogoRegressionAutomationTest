package com.yourlogo.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.framework.seleniumElements.SeleniumElements;
import selenium.framework.testbase.TestBase;


public class LoginPage extends TestBase {
	
	
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"passwd\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"SubmitLogin\"]/span")
	WebElement signinbutton;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement emailfield;
	
	@FindBy(xpath="//button[@id=\"SubmitCreate\"]")
	WebElement createbutton;
	
	@FindBy(xpath="//div[@class=\"alert alert-danger\"]")
	WebElement InvalidemailMsg;
	
	
	@FindBy(xpath="//a[contains(text(), 'Forgot your password?')]")
	WebElement forgetpassword;
	
	
	@FindBy(xpath="//a[@class='logout' and @title='Log me out']")
	WebElement logout;
	
	@FindBy(xpath="//a[@title='View my shopping cart']")
	WebElement Cartlink;
	
	@FindBy(id="search_query_top")
	WebElement Searchbox;
	
	@FindBy(xpath="//button[@type='submit' and @name='submit_search']")
	WebElement searchbutton;
	
	@FindBy(xpath="//a[text()='Forgot your password?']")
	WebElement ForgetPassword;
	
	@FindBy (id="email")
	WebElement retrivePasswordEmail;
	
	@FindBy (xpath="//span[text()='Retrieve Password']")
	WebElement retrivePasswordButton;
	
	@FindBy(xpath="//p[text()='New Password Send']")
	WebElement newPasswordText;
	
	
	//div[@id='block_top_menu']/ul/li/a[@title='Women']
	String topnavxpath1="//div[@id='block_top_menu']/ul/li/a[@title='";
	String topnavxpath2 ="']";
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);   //initialize element
	}
	
	//--------------Actions-------------//
	
	public String title()
	{
		return driver.getTitle();
	}
	
	public MyAccountPage login(String un, String pwd)
	{
		email.sendKeys(un);
		password.sendKeys(pwd);
		signinbutton.click();
		
		return new MyAccountPage();	
	}
	
	public boolean logout(String un, String pwd)
	{
		email.sendKeys(un);
		password.sendKeys(pwd);
		signinbutton.click();
		
		logout.click();
		
		boolean display=signinbutton.isDisplayed();
		return display;
	}
	public String invalidcredentials(String un, String pwd)
	{
		email.sendKeys(un);
		password.sendKeys(pwd);
		signinbutton.click();
		
		String text=driver.findElement(By.xpath("//div[@id='center_column']//div[@class='alert alert-danger']")).getText();
		return text;
		
	}
	
	public CartPage Cartlink()
	{
		Cartlink.click();
		return new CartPage();
	}
	
	
	public void search(String keyword)
	{
		Searchbox.sendKeys(keyword);
		searchbutton.click();
		
	}
	public String CreateError() throws InterruptedException
	{
		createbutton.click();
		Thread.sleep(5000);
		
		String errmsg= InvalidemailMsg.getText();
		
		System.out.println(errmsg);
		return errmsg;
		 
	}
	
		
	
	public RegistrationPage Createaccnt(String emil) {
		emailfield.sendKeys(emil);
		createbutton.click();
		return new RegistrationPage();
		
	}
	
	
	public String forgetPassword(String username)
	{
		ForgetPassword.click();
		retrivePasswordEmail.sendKeys(username);
		retrivePasswordButton.click();
		
		String text = newPasswordText.getText();
		return text;
	}

	public String clickTopNavigation(String topnav)
	{
		String xpath = topnavxpath1+topnav+topnavxpath2;
		WebElement topNav=elements.findByXpath(xpath, driver);
		topNav.click();
		String title = driver.getTitle();
		
		return title;
		
	}
	
	/*public RegistrationPageDataDriven CreatAccount(String emil) {
		emailfield.sendKeys(emil);
		createbutton.click();
		return new RegistrationPageDataDriven();
		
	}*/
	
}
