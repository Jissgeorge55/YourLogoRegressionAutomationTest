package selenium.framework.seleniumElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;



public class SeleniumElements  {

	public static final int SHORT_SLEEP = 1000;
	public static final int MEDIUM_SLEEP = 4000;
	public static final int LONG_SLEEP = 7000;

	public void refresh(Object driver) {
		WebDriver seleniumDriver = (WebDriver) driver;
		seleniumDriver.navigate().refresh();

	}

	public void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void select(String elementProperty, Object element, int index, String textOrValue, String errorMess,
			Object driver) {
		WebDriver seleniumDriver = (WebDriver) driver;
		WebElement seleniumElement = (WebElement) element;
		try {
			
			 WebDriverWait wait = new WebDriverWait(seleniumDriver, 40);
			 wait.until(ExpectedConditions.visibilityOf(seleniumElement));
			 

			Select select = new Select(seleniumElement);
			if (elementProperty.equals("VALUE")) {
				select.selectByValue(textOrValue);
			}

			else if (elementProperty.equals("TEXT")) {
				select.selectByVisibleText(textOrValue);
			}

			else if (elementProperty.equals("INDEX")) {
				select.selectByIndex(index);
			}

		} catch (RuntimeException e) {
			System.out.println("Invalid Selection");
		}

	}

	public void hoverAndClickOnElement(Object hoverOverElement, Object tryClickOnElement, Object driver) {
		WebDriver seleniumDriver = (WebDriver) driver;
		WebElement seleniumhoverOverElement = (WebElement) hoverOverElement;
		WebElement seleniumTryClickOnElement = (WebElement) tryClickOnElement;
		Actions action = new Actions(seleniumDriver);
		action.moveToElement(seleniumhoverOverElement).perform();
		pause(1000);
		seleniumTryClickOnElement.click();

	}

	public void switchToFrame(String frame, Object driver) {

		WebDriver seleniumDriver = (WebDriver) driver;
		try {
			WebDriverWait wait = new WebDriverWait(seleniumDriver, 40);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		} catch (RuntimeException firstAttempt) {

			pause(MEDIUM_SLEEP);
			seleniumDriver.switchTo().frame(frame);
		}
	}

	public void alert(boolean accept, String errorMess, Object driver) {
		WebDriver seleniumDriver = (WebDriver) driver;
		Alert alert = null;
		try {
			alert = seleniumDriver.switchTo().alert();
		} catch (RuntimeException firstAttempt) {
			try {
				pause(MEDIUM_SLEEP);// Wait for chrome
				alert = seleniumDriver.switchTo().alert();
			} catch (RuntimeException secondAttempt) {

			}
		}
		if (accept) {
			alert.accept();
		} else {
			alert.dismiss();
		}

	}

	public String switchToAlert(Object driver) {
		WebDriver seleniumDriver = (WebDriver) driver;
		Alert alert = null;

		alert = seleniumDriver.switchTo().alert();
		String alertMessage = alert.getText();
		return alertMessage;
	}

	public void explictWait(WebElement element, int time, Object driver) {
		WebDriverWait wait = new WebDriverWait((WebDriver) driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void rightClick(WebElement element,Object driver)
	{
		Actions actions= new Actions((WebDriver) driver);
		actions.contextClick(element);
	}
	
	public void doubleClick(WebElement element,Object driver)
	{
		Actions actions= new Actions((WebDriver) driver);
		actions.doubleClick(element);
	}
	
	public void scrollToElement(WebElement element,Object driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) (WebDriver) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}

	public WebElement findByXpath(String locator, Object driver) {
		WebDriver seleniumDriver = (WebDriver) driver;
		WebElement element = null;    	
    	try {
    		element = seleniumDriver.findElement(By.xpath(locator));  
		} catch (RuntimeException firstAttempt) {
										    
		}    	
    	return element;
	}
}
