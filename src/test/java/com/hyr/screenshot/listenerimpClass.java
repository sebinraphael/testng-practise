package com.hyr.screenshot;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listenerimpClass extends BaseClass implements ITestListener {
	ExtentReports report;
	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		threadsafe.getExtentTest().fail(result.getMethod().getMethodName());
		threadsafe.getExtentTest().fail(result.getThrowable());
	
		try {
			captureScreenshot(result.getMethod().getMethodName()+ getDate()+".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = report.createTest(result.getMethod().getMethodName());
		threadsafe.setExtentTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		threadsafe.getExtentTest().pass((result.getMethod().getMethodName()));		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		threadsafe.getExtentTest().skip((result.getMethod().getMethodName()));
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extent/");
		spark.config().setDocumentTitle("testing orangehr");
		spark.config().setReportName("Report Name"+ getDate());
		spark.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating System", "Windows 10");
		report.setSystemInfo("Browser name", "Chrome");
		report.setSystemInfo("Browser Verision", "107");
		report.setSystemInfo("Reporter Name", "Daniel");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();		
	}

}
