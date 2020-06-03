package com.yourlogo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.framework.testbase.TestBase;


public class QuickView extends TestBase {
	
	JavascriptExecutor je=(JavascriptExecutor)driver;
	
	@FindBy(xpath="//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//div[@class='product-container']//div[@class='left-block']//div[@class='product-image-container']")
	WebElement product;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[2]")
	WebElement More1;

	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement addtocart;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']//span")
	WebElement ProceedCheckout;
	
	@FindBy(xpath="//a[@id=\"wishlist_button\"]")
	WebElement Wishlist;
	
	@FindBy(xpath="//p[@class=\"fancybox-error\"]")
	WebElement AddedWishlist;
	
	
	public QuickView()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String AddToCart() throws InterruptedException
	
	{
		je.executeScript("arguments[0].scrollIntoView();",product);
		Actions act=new Actions(driver);
		act.moveToElement(product).build().perform();
		
		
		More1.click();
		addtocart.click();
		 Thread.sleep(5000);
		ProceedCheckout.click();
		
		return driver.getTitle();
		
	}
	
	
	public String AddToWishlist()
	{
		More1.click();
		Wishlist.click();
		String message= AddedWishlist.getText();
		
		return message;
		
		
	}
}
