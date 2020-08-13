package com.yourlogo.pages;

import selenium.framework.testbase.TestBase;

public class GetAPage extends TestBase {
	static Object page;

	
	public static void gotopage(PageType PageType)
	{
		switch(PageType) {
		
		case LoginPage:
		
			GetAPage.LoginPage(PageType);
			break;
			
		case MyAccountPage:
				
			GetAPage.MyAccountPage(PageType);
			break;	
				
			
		case CartPage:
			GetAPage.CartPage(PageType);
			break;
			
		
		}
		
			
	}
		
		

	private static CartPage CartPage(PageType pageType) {
		String url=pageType.getURL();
		 driver.get(url);
		 return new CartPage();
	}



	private static MyAccountPage MyAccountPage(PageType pageType) {
		String url=pageType.getURL();
		 driver.get(url);
		 return new MyAccountPage();
		 
		
	}



	private static LoginPage LoginPage(PageType pageType) {
		String url=pageType.getURL();
		 driver.get(url);
		return new LoginPage();
		
	}
	
}
