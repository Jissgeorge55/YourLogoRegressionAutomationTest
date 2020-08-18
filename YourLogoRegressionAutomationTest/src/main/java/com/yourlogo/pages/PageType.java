package com.yourlogo.pages;

public enum PageType {
	
	LoginPage
		
	("http://automationpractice.com/index.php?controller=authentication&back=my-account"),
	
	MyAccountPage
	("http://automationpractice.com/index.php?controller=my-account"),
	
	CartPage
	("http://automationpractice.com/index.php?controller=order"),
	
   ProductDescriptionPage
   ("http://automationpractice.com/index.php?id_product=3&controller=product");
	
	private String url;
	
	private PageType(String url)
	{
		this.url=url;
	}
	
	public String getURL()
	{
		return url;
	}
}
