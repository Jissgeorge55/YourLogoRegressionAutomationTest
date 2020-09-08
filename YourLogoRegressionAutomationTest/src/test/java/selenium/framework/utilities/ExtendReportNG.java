package selenium.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportNG extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeSuite	
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/Extent-Report/"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-report.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Jiss George");
		extent.setSystemInfo("OS","Windows");
		extent.setSystemInfo("Selenium Version", "3.141.59");
		extent.setSystemInfo("Java Version", "1.8.0_181");
		
		
		htmlReporter.config().setDocumentTitle("Your Logo UI Test Project"); // Tile of report
		htmlReporter.config().setReportName("Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());// create new entry in th report
		String details = tr.getMethod().getQualifiedName();
		String Description[] = details.split("[.]");
		String TestDescription = "Test Case " +Description[4]+ " in "+Description[3]+" is Passed";
		logger.log(Status.PASS,MarkupHelper.createLabel(TestDescription, ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted.  tr.getName()
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		String details = tr.getMethod().getQualifiedName();
		String Description[] = details.split("[.]");
		String TestDescription = "Test Case " +Description[4]+ " in "+Description[3]+" is Failed. Please more details below.";
		logger.log(Status.FAIL,MarkupHelper.createLabel(TestDescription,ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		logger.log(Status.FAIL, tr.getThrowable());
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		//File f = new File(screenshotPath); 
		
		//if(f.exists())
		{
		try {
			//logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			logger.fail("Screenshot is below:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
		
	}
	
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		logger.log(Status.SKIP, tr.getThrowable());
		
	}
	@AfterSuite
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

}
