package com.hyr.screenshot;

import com.aventstack.extentreports.ExtentTest;

public class threadsafe 
{
	
private static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<>();
	
	
	public static ExtentTest getExtentTest()
	{
		return extentTest.get();
    }
	
	public static void setExtentTest(ExtentTest sExtentTest)
	{
		extentTest.set(sExtentTest);
	}
}
