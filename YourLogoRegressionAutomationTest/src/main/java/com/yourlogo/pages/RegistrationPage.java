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
	
	@FindBy(id="customer_firstname")
	WebElement FirstName;
	
	@FindBy(id="customer_lastname")
	WebElement LastName;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="passwd")
	WebElement Password;
	
	@FindBy(id="days")
	WebElement Day;
	
	@FindBy(id="months")
	WebElement Month;
	
	@FindBy(id="years")
	WebElement Year;
	
	
	@FindBy(id="firstname")
	WebElement FirstName1;
	
	@FindBy(id="lastname")
	WebElement LastName2;
	
	@FindBy(id="company")
	WebElement Company;
	

	
	
	@FindBy(id="address1")
	WebElement Address;
	
	@FindBy(id="city")
	WebElement City;
	
	@FindBy(id="postcode")
	WebElement Postcode;
	
	@FindBy(id="id_state")
	WebElement State;
	
	@FindBy(id="phone_mobile")
	WebElement Phone;
	
	@FindBy(id="submitAccount")
	WebElement RegisterButton;
	
	
	
	
	public RegistrationPage()
	{
		PageFactory.initElements(driver, this);   //initialize element
	}
	
	public void EnterDetails(String title, String firstname, String lastname, String password,String DOB, String address, String city, String state, String zipcode,String country, String phone)
	{
		
		if(title.equals("Mr"))
		{
			Mr.click();
		}
		
		else if(title.equals("Mrs"))
		{
			Mrs.click();
		}
		

		elements.clearAndSendKeys(FirstName, firstname);
		elements.clearAndSendKeys(LastName, lastname);
		elements.clearAndSendKeys(Password, password);
		elements.clearAndSendKeys(FirstName1, firstname);
		elements.clearAndSendKeys(LastName2, lastname);
		elements.clearAndSendKeys(Address, address);
		elements.clearAndSendKeys(City, city);
		elements.clearAndSendKeys(Postcode, zipcode);
		
		elements.select("TEXT", State, 1, state, "");
		
		elements.clearAndSendKeys(Phone, phone);
	
		
	}
	
	
	public MyAccountPage clickRegesterButton()
	{
		RegisterButton.click();
		
		return new MyAccountPage();
	}
	
	

		
		
	}
	
	
	
	
	
	

	
	
	
	
	

