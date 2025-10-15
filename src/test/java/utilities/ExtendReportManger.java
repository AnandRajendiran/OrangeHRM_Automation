package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtendReportManger implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext context)
	{
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.ss").format(new Date());
		
		repName = "Test-Report-"+timestamp +".html";
		sparkReporter = new ExtentSparkReporter(".\\Reports\\"+ repName);
		sparkReporter.config().setDocumentTitle("OrangeHRM Automation Report");
		sparkReporter.config().setReportName("Funcational testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "OrangeHRM");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Submodule", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");
				
	}

	public void onTestSuccess(ITestResult result)
	{
		test =extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getRealClass().getSimpleName());
		test.log(Status.PASS, result.getName() +"Got successfully executed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
		test.assignCategory(result.getMethod().getMethodName());
		
		test.log(Status.FAIL, result.getName()+ "Got failed");
		try
		{
			String impath = new BaseClass().capturescreen(result.getName());
			test.addScreenCaptureFromPath(impath);
			
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}
	
	public void onFinish(ITestContext testcontect)
	{
		extent.flush();
		
	}
}

