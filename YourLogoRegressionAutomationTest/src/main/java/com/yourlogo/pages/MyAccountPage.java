package com.yourlogo.pages;

import selenium.framework.testbase.TestBase;

public class MyAccountPage extends TestBase {
	
	
	//---pageFactory--//
	
	
	
	public String pagetitle()
	{
		String mccnttitle= driver.getTitle();
		return mccnttitle;
	}

}