package com.yourlogo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import selenium.framework.testbase.TestBase;

public class MyAccountPage extends TestBase {
	
	
	@FindBy(id="search_query_top")
	WebElement searchBoxId;
	//---pageFactory--//
	
	
	
	public String pagetitle()
	{
		String mccnttitle= driver.getTitle();
		return mccnttitle;
	}

	public SearchPage searchText(String Text) {
		
		searchBoxId.clear();
		searchBoxId.sendKeys(Text);
		return new SearchPage();
	}

}