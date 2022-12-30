package com.hyr.screenshot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.hyr.screenshot.listenerimpClass.class)
public class TestClass extends BaseClass{
	@Test
	public void testGoogle() throws Exception {
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("HYR tutorials");
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/descendant::input[@name='btnK']")).click();
		String expectedTitle="HYR tutorials - Google Search";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}
	@Test
	public void testLogin() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"))
						.isDisplayed());
		System.out.println("login is successful");
	}
	@Test
	public void testGoogle2() throws Exception {
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("HYR tutorials");
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/descendant::input[@name='btnK']")).click();
		String expectedTitle="HYR tutorials - Google Searc";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}

}
