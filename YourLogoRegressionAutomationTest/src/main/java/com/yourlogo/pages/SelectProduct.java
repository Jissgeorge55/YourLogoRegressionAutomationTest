package com.yourlogo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.framework.testbase.TestBase;
import selenium.framework.utilities.ReadConfigFile;

public class SelectProduct extends TestBase {
	
	static ReadConfigFile readproduct = new ReadConfigFile("Products.properties");
	static SelectProduct set =new SelectProduct();
	
	static String url;
	String productname;
	static String size;
	static String colour;
	String price;

	public static void standardProduct() {
		
		url= readproduct.getProductUrl("normalProductURL");
		size = readproduct.getProductSize("normalProductSize");
		colour = readproduct.getProductColour("normalProductColour");
		
		GetAPage.ProductPage(url);
		
		set.setSize(size);
		set.setColour(colour);
		
		
	}
	
private void setColour(String colour) {
	String xpath = "//a[@title ='"+colour+"']";
	WebElement colourElement =driver.findElement(By.xpath(xpath));
	colourElement.click();
	}

/*public static void discountProduct() {
		
		url= readproduct.getProductUrl();
		size = readproduct.getProductSize();
		colour = readproduct.getProductSize();
		
	}*/
	
	
private void setSize(String SizeValue)
{
	WebElement sizeElement =driver.findElement(By.id("group_1"));
	elements.select("TEXT", sizeElement, 0, SizeValue, "");
}
}
