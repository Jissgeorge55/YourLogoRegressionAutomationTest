package com.yourlogo.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.framework.testbase.TestBase;



public class CartPage extends TestBase {
	
	JavascriptExecutor je=(JavascriptExecutor)driver;
	
	@FindBy(id="5_19_0_0")
	//(xpath="//i[@class='icon-trash']")
	
	WebElement deletebutton;
	
	@FindBy(xpath="//i[@class='icon-plus']")
	WebElement plusbutton;
	
	@FindBy(xpath="//i[@class='icon-minus']")
	WebElement minusbutton;
	
	@FindBy(xpath="//td[@class='cart_description']")
	WebElement CartDescription;
	
	@FindBy(xpath="//a[@class='button-exclusive btn btn-default']")
	WebElement continueshopping;
	
	
	
	
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);   //initialize element
	}
	
	public String cartPagetitle()
	{
		String title= driver.getTitle();
		return title;
		
	}
	
	public void cartPagescreenshot() throws IOException
	{
		je.executeScript("arguments[0].scrollIntoView();",CartDescription);
		Actions act=new Actions(driver);
		act.moveToElement(CartDescription).build().perform();
		
		//takescreenshot("Cartpage");
	}
	
	public SearchPage ContinueShopping() {
		
		continueshopping.click();
		return new SearchPage();
	}
	
	public boolean deleteProduct() throws InterruptedException
	{
		deletebutton.click();
		
		Thread.sleep(5000);
		
		boolean test=driver.findElement(By.xpath("//p[@class='alert alert-warning']")).isDisplayed();
		return test;
		
		
	}

}
