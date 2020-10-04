package com.yourlogo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import selenium.framework.testbase.TestBase;

public class HomePage extends TestBase {
	
	//---------Page Factory------//
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
    WebElement Logo;
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signinbtn;
	
	@FindBy(xpath="//*[@id='contact-link']//*[contains(text(),'Contact us')]")
	WebElement contactusbtn;
	
	@FindBy(xpath="//span[contains(text(),'Test Tester')]")
	WebElement loginname;
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	WebElement Dresses;
	
	@FindBy(id="search_query_top")
	WebElement Searchbox;
	
	@FindBy(xpath="//button[@class='btn btn-default button-search']")
	WebElement Searchbutton;
	
	@FindBy(xpath ="//a[@title=\"View my shopping cart\"]")
	WebElement Cart;
	
	@FindBy(className = "ajax_cart_block_remove_link")
	WebElement remove_product;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);   //initialize element
	}
	
	
	//=======Actions=====//
	
	 public String validatetitle()
	 {
		 return driver.getTitle();
	 }
	 
	 public boolean validateLogo()
	 {
		 return Logo.isDisplayed();
	 }
	 
	 public LoginPage SignIn()
	 {
		 signinbtn.click();
		 return new LoginPage();
	 }
	 
	 public ContactusPage Contactus()
	 {
		 contactusbtn.click();
		 return new ContactusPage(); 
	 }
	 
	 public QuickView Dresses()
	 
	 {
		 Dresses.click();
		return new QuickView();
		 
	 }
	 
	 public SearchPage SearchProduct()
	 {
		 Searchbox.clear();
		 Searchbox.sendKeys("Dresses");
		 Searchbutton.click();
		 
		 return new SearchPage();
		 
	 }
	 
	 public void deleteProduct()
	 {
		Cart.click();
		remove_product.click();
		
	 }
}
