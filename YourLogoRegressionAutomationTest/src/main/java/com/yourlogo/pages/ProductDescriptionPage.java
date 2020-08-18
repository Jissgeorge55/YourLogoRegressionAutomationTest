package com.yourlogo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.framework.testbase.TestBase;

public class ProductDescriptionPage extends TestBase{
	
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addtocartbutton;
	
	@FindBy(id="wishlist_button")
	WebElement WishListButton;
	
	@FindBy(xpath = "//p[contains(text(),'Added to your wishlist.')]")
	WebElement WishlistSuccessMsg;
	
	
	public ProductDescriptionPage()
	{
		PageFactory.initElements(driver,this);
	}

	public String addToCart() {
		
		addtocartbutton.click();
		String messagexpath = "//h2[contains(.,'Product successfully added to your shopping cart')]";
		WebElement messagetext=elements.findByXpath(messagexpath, driver);
		elements.explictWait(messagetext, 3, driver);
		String text = messagetext.getText();
		
		System.out.println(text);
		
		return text;
	}

	public boolean addtowishlist() {
		
		WishListButton.click();
		boolean result = WishlistSuccessMsg.isDisplayed();
		return result;
		
		
	}

}
