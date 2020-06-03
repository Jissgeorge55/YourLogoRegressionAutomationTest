package com.yourlogo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import selenium.framework.testbase.TestBase;

public class RegistrationPage extends TestBase {
	
	@FindBy(xpath="//input[@type='radio' and @value='1']")
	WebElement Mr;
	
	@FindBy(xpath="//input[@type='radio' and @value='2']")
	WebElement Mrs;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='text' and @name='firstname']")
	WebElement Addname1;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement AddName2;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement Address;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement City;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement Postcode;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement State;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement Phone;
	
	
	
	public RegistrationPage()
	{
		PageFactory.initElements(driver, this);   //initialize element
	}
	
	public void Registeration(String fstname, String lstname, String emil1, String pswd, String addfstnme, String addlstnme, String addrs, String cty, String title, String pstcd, String phn)
	{
		Mr.click();
		FirstName.sendKeys(fstname);
		LastName.sendKeys(lstname);
		Email.clear();
		Email.sendKeys(emil1);
		
		Password.sendKeys(pswd);
		
		Addname1.clear();
		Addname1.sendKeys(addfstnme);
		
		AddName2.clear();
		AddName2.sendKeys(addlstnme);
		
		Address.clear();
		Address.sendKeys(addrs);
		
		City.clear();
		City.sendKeys(cty);
		
		Select state = new Select(State);
		state.selectByVisibleText(title);
		
		Postcode.clear();
		Postcode.sendKeys(pstcd);
		Phone.clear();
		Phone.sendKeys(phn);
		
		
				
		
	}
	
	
	
	
	
	

	
	
	
	
	

}
