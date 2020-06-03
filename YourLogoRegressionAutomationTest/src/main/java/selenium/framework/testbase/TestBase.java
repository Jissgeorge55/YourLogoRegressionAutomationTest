package selenium.framework.testbase;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//import com.gurubanking.pages.HomePage;

import selenium.framework.seleniumElements.SeleniumElements;
import selenium.framework.utilities.ReadConfigFile;
import selenium.framework.utilities.utilities;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	static ReadConfigFile readconfig = new ReadConfigFile();
	public SeleniumElements elements = new SeleniumElements();
	
	
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public static void setup(String br)
	{
		TestBase base = new TestBase();
		
		

		String directory= System.getProperty("user.dir");
		String browser = readconfig.getbrowser();
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", directory+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", directory+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(br.equals("InternetExplorer"))
		{
			System.setProperty("webdriver.gecko.driver", directory+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else {
			System.out.println("Unknown browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(utilities.pageLoadTimeinSec, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(utilities.implicitWaitinSec, TimeUnit.SECONDS);
		
		driver.get(readconfig.getApplicationURL());
		//driver.get("http://demo.guru99.com/V4/");
		
		try
		{
			driver.findElement(By.name("button")).click();
		}catch(NoSuchElementException e)
		{
			
		}
		
	}
	
	/*public static HomePage Login()
	{
		String username= readconfig.getUsername();
		String password= readconfig.getPassword();
		
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		return new HomePage();*/
		
	//}
	
	public static void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File((System.getProperty("user.dir"))+"\\Screenshots\\"+tname+".png");
		FileUtils.copyFile(source,target);
	}
	
	@AfterClass(alwaysRun=true)
	public void teardown()
	{
		driver.quit();
	}
	/*public static void main(String[] args)
	{
		setup();
	}
*/
}
