package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCasess.BaseCase;

public class ExtentReportManager  implements ITestListener
{
	ExtentSparkReporter spartReporter;
	ExtentReports extent;
	ExtentTest test ;
	WebDriver driver;
	
	
	@Override
	public void onStart(ITestContext context) 
	{
		spartReporter=new ExtentSparkReporter("./Reports/executuion.html");//for UI
		spartReporter.config().setDocumentTitle("Automation Report");
		spartReporter.config().setReportName("Function Testing");
		spartReporter.config().setTheme(Theme.STANDARD);
		
		
		extent=new ExtentReports();  //other information
		extent.attachReporter(spartReporter);
		extent.setSystemInfo("computer name", "local host");
		extent.setSystemInfo("operating system", "Window10");
		extent.setSystemInfo("environment ", "QA");
		extent.setSystemInfo("browser name ", "chrome");
		extent.setSystemInfo("tester name ", "xyz");
	}
	

	@Override
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test passed" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed" + result.getName());
		
	    try {
			String path1 = screenshot(result.getName());
			test.addScreenCaptureFromPath(path1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test skipped" + result.getName());
	}

	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}

	public String screenshot(String testname) throws IOException
	{
		 driver=DriverManager.getDriver();
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\" + testname + "_" + timeStamp + ".png";
		
		File targetFile=new File(targetFilePath);   
		FileUtils.copyFile(sourceFile, targetFile);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
