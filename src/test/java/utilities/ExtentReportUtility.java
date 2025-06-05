package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportUtility implements ITestListener {
	
	ExtentSparkReporter sparkreporter; //ui of the report
	ExtentReports extent; //populate common information on the report
	ExtentTest test; //creating test case entries and updating test method statuses on the report
	String repname;
	
	
	public void onStart(ITestContext context) {
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname="Test-Report-"+timestamp+".html";
		sparkreporter=new ExtentSparkReporter(".\\reports\\"+ repname);
		sparkreporter.config().setDocumentTitle("Automation Report");
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("Functional Testing");
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("username", System.getProperty("user.name"));
		String os =context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		String browser=context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("browsername", browser);
		List<String> includedGroups=context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
		
	    
	  }
	
	public void onTestSuccess(ITestResult result) {
		test =extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+"got successfully exected");
	  }
	public void onTestFailure(ITestResult result) {
		test =extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+"gotfailed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		try {
		String imgPath=new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgPath);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
	  }
	public void onTestSkipped(ITestResult result) {
		test =extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,result.getName()+"gotfailed");
		test.log(Status.INFO,result.getThrowable().getMessage());
	  }
	
	public void onFinish(ITestContext context) {
		 extent.flush();
		 
		 
	  }

}
