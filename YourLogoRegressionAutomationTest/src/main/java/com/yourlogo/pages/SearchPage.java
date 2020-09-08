package com.yourlogo.pages;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.framework.seleniumElements.SeleniumElements;

import selenium.framework.testbase.TestBase;

public class SearchPage extends TestBase {

	static JavascriptExecutor je = (JavascriptExecutor) driver;

	@FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']")
	WebElement product1;

	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	WebElement addtocart;

	@FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
	WebElement proceedTocheckout;

	@FindBy(id = "selectProductSort")
	WebElement SortDropdown;

	@FindBy(id = "search_query_top")
	WebElement searchbox;

	@FindBy(xpath = "//button[@class='btn btn-default button-search']")
	WebElement submit;

	@FindBy(xpath = "//span[contains(text(),'More')]")
	WebElement more;
	
	@FindBy(xpath = "//span[contains(text(),\"Quick view\")]")
	WebElement quickView;
	
	@FindBy(xpath ="//span[@class=\"heading-counter\"]")
	WebElement NumofProducts;
	
	@FindBy(xpath="//span[contains(text(),'There is 1 item in your cart.')]")
	WebElement productaddedmsg;
	
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']/h2")
	WebElement AddToCartsuccessMsg;
	
	//div[@class='layer_cart_product col-xs-12 col-md-6']/h2
	
	@FindBy(css="#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > h2 > span.ajax_cart_product_txt")
	WebElement AddToCartMsgCSS;
	
	@FindBy(id="wishlist_button")
	WebElement WishListButton;
	
	@FindBy(xpath = "//p[contains(text(),'Added to your wishlist.')]")
	WebElement WishlistSuccessMsg;
	
	
	
	
	
	

	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean sortByLowestPrice() {
		Select sort = new Select(SortDropdown);
		sort.selectByVisibleText("Price: Lowest first");

		List<WebElement> pricelist = driver.findElements(By.xpath("//span[@class='price product-price']"));

		List<WebElement> oldpricelist = driver.findElements(By.xpath("//div[@itemprop='offers']//span[@class='old-price product-price']"));
		List<WebElement> offerpricelist = driver.findElements(By.xpath("//div[@itemprop='offers']//span[@class='old-price product-price']//preceding-sibling::span"));
		int size = pricelist.size();
		System.out.println(size);

		// Array List to store price values
		List<String> priceRate = new ArrayList<String>();
		
		List<String> oldpriceRate = new ArrayList<String>();
		List<String> offerpriceRate = new ArrayList<String>();
		
		
		//div[@itemprop='offers']//span[@class='old-price product-price']//preceding-sibling::span

		// storing each price text to Array list
		for (int i = 1; i < size; i++) {
			priceRate.add(pricelist.get(i).getText());
		}

		// remove unwanted texts, here unwanted element is showing as space
		for (int i = 1; i < size; i++) {
			priceRate.remove(new String());
		}
		
		for (int i = 1; i < oldpricelist.size(); i++) {
			oldpriceRate.add(oldpricelist.get(i).getText());
		}
		
		for (int i = 1; i < oldpricelist.size(); i++) {
			oldpriceRate.remove(new String());
		}
		
		for (int i = 1; i < offerpricelist.size(); i++) {
			offerpriceRate.add(offerpricelist.get(i).getText());
		}
		
		for (int i = 1; i < offerpricelist.size(); i++) {
			offerpriceRate.remove(new String());
		}
		
		
		

		System.out.println("Price from the page: " + priceRate);
		System.out.println("Old Price from the page: " + oldpriceRate);
		System.out.println("Offer Price from the page: " + offerpriceRate);
		
		for(int j = 1; j < size; j++)
		{
			for(int i = 1; i< offerpricelist.size(); i++) {
				
				if((pricelist.get(j).getText()).equals(offerpricelist.get(i).getText()))
				{
					int index=priceRate.indexOf(priceRate.get(j));
					priceRate.set(index,oldpricelist.get(i).getText());
				}
				
				else
				{
					continue;
				}
				
			}
		}
		
		System.out.println("Orginal Price : "+priceRate);
			
			
		

		// making another copy of array list to compare
		List<String> sortedPrices = new ArrayList<String>(priceRate);

		// sorting sortedPrices in assending order
		Collections.sort(sortedPrices);

		System.out.println("Price Sorted " + sortedPrices);

		// true if the prices are sorted
		boolean result = sortedPrices.equals(priceRate);

		return result;

	}

	
	

	
	public CartPage proccedToCheckout()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(proceedTocheckout));

		proceedTocheckout.click();

		return new CartPage();
	}

	public String searchbox() {
		searchbox.clear();
		searchbox.sendKeys("t-shirt");
		submit.click();

		String searchresult = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();

		return searchresult;

	}

	public boolean moreButton()
	{
		elements.scrollAndHoverToElement(product1, driver);
		
		more.click();
		
		//WebElement quantity= driver.findElement(By.id("quantity_wanted"));
		
		WebElement linkonPage = driver.findElement(By.xpath("//*[@id=\"columns\"]/div[2]/strong/a"));
		
		String text= linkonPage.getText();
		
		System.out.println(text);
		
		boolean result= linkonPage.isDisplayed();
		
		return result;	
		
	}
	
	public boolean quickView() throws InterruptedException
	{
		elements.scrollAndHoverToElement(product1, driver);
		
		quickView.click();
		
		WebElement closeButton=driver.findElement(By.xpath("//a[@class=\"fancybox-item fancybox-closea\"]"));
        boolean result= closeButton.isDisplayed();
        closeButton.click();
        Thread.sleep(1000);
		
		return result ;
	}
	
	
	public boolean productsPerPage(int num)
	{
		List<WebElement>allproducts= driver.findElements(By.xpath("//ul[@class=\"product_list grid row\"]/li"));
		
		int produtsperpage= allproducts.size();
		
		System.out.println(produtsperpage);
		
		if(num==produtsperpage)
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
		
		
	}

	public void clearsearchfield() {
		searchbox.clear();
		
	}

	public String addtocart() throws InterruptedException {
		elements.scrollAndHoverToElement(product1, driver);

		addtocart.click();
		Thread.sleep(2000);
		  String msg=AddToCartsuccessMsg.getText();
		  boolean bool=AddToCartMsgCSS.isDisplayed();
		  return msg;
	}

	public boolean addtowishlist() {
		elements.scrollAndHoverToElement(product1, driver);
		more.click();
		WishListButton.click();
		boolean result = WishlistSuccessMsg.isDisplayed();
		
		return result;
		
		
		
	}
	
	
	public void scrollToProduct(WebElement product)
	{
		elements.scrollToElement(product,driver);
		//je.executeScript("arguments[0].scrollIntoView();", product);
		Actions act = new Actions(driver);
		act.moveToElement(product).build().perform();
		
	}
	
	
}
