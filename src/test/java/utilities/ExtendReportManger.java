package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
	public ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static Map<String, ExtentTest> classTestMap = new ConcurrentHashMap<>();

	String repName;
	
	public synchronized ExtentReports getExtentReports()
	{
		if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String repName = "Test-Report-" + timestamp + ".html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(".\\Reports\\" + repName);
            sparkReporter.config().setDocumentTitle("OrangeHRM Automation Report");
            sparkReporter.config().setReportName("Functional Testing");
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Application", "OrangeHRM");
            extent.setSystemInfo("Module", "Admin");
            extent.setSystemInfo("Submodule", "Customers");
            extent.setSystemInfo("User Name", System.getProperty("user.name"));
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
	}
	
	public void onTestStart(ITestResult result) {
		String className = result.getTestClass().getName(); // fully qualified class name
	    ExtentTest parent;

	    // If parent for this class already exists, use it
	    if (classTestMap.containsKey(className)) {
	        parent = classTestMap.get(className);
	    } else {
	        // Create parent node for the class
	        parent = getExtentReports().createTest(className);
	        classTestMap.put(className, parent);
	    }

	    // Create child test for the method
	    String methodNameColored = "<b style='color:limegreen'>" + result.getMethod().getMethodName() + "</b>";
	    ExtentTest child = parent.createNode(methodNameColored);
	    test.set(child); // Thread-local for logging
    }
	
	public void onStart(ITestContext context)
	{
        getExtentReports();

				
	}

	public void onTestSuccess(ITestResult result) {
		 if (test.get() == null) {
	            ExtentTest newTest = extent.createTest(result.getMethod().getMethodName());
	            test.set(newTest);
	        }
	    test.get().assignCategory(result.getMethod().getRealClass().getSimpleName());
	    test.get().log(Status.PASS, result.getName() + " got successfully executed");
	}


	public void onTestFailure(ITestResult result) {
		
		 if (test.get() == null) {
		        ExtentTest newTest = extent.createTest(result.getMethod().getMethodName());
		        test.set(newTest);
		    }
	    test.get().assignCategory(result.getMethod().getRealClass().getSimpleName());
	    test.get().log(Status.FAIL, result.getName() + " got failed");
	    test.get().log(Status.FAIL, result.getThrowable());
	    try {
	        String impath = new BaseClass().capturescreen(result.getName());
	        if (impath != null) {
	            test.get().addScreenCaptureFromPath(impath);
	        }
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    }
	}
	
	public void onFinish(ITestContext testcontect)
	{
		 if (extent != null) {
	            extent.flush(); // flush only once
	        }
		
	}
}

