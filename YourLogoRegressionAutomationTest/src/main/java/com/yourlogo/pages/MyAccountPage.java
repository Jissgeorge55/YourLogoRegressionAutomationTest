package com.yourlogo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.framework.testbase.TestBase;

public class MyAccountPage extends TestBase {
	
	
	@FindBy(id="search_query_top")
	WebElement searchBoxId;
	//---pageFactory--//
	
	@FindBy(name="submit_search")
	WebElement SubmitButton;
	
	
	public MyAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String pagetitle()
	{
		String mccnttitle= driver.getTitle();
		return mccnttitle;
	}

	public SearchPage searchText(String Text) {
		
		searchBoxId.clear();
		searchBoxId.sendKeys(Text);
		SubmitButton.click();
		
		return new SearchPage();
	}

}