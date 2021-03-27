package com.yourlogo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.framework.testbase.TestBase;

public class HomePage1 extends TestBase {
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
    WebElement Logo;
	
	public HomePage1()
	{
		PageFactory.initElements(driver, this);   //initialize element
	}
	
	
	public boolean validateLogo()
	{
		 return this.Logo.isDisplayed();
	}

}


