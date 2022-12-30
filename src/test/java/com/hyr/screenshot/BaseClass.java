package com.hyr.screenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
	
	public void captureScreenshot(String fileName) throws IOException 
	{
		TakesScreenshot t=(TakesScreenshot) driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+fileName);
		FileUtils.copyFile(src, dest);
		System.out.println("screenshot saved successfully");
	}
	
	public String getDate()
	{
	Date d=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYY_HH_mm_sss");
	String dat = sdf.format(d);
	return dat;
	}
}
