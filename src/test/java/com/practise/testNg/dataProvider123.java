package com.practise.testNg;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataProvider123 {
	@Test(dataProvider = "getData")
	public void testLogin(String username,String password) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"))
						.isDisplayed());
		System.out.println("login is successful");
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	@DataProvider
	public  String[][] getData() throws Exception
	{
		
		FileInputStream fis =new FileInputStream("./src/test/resources/practise dataprovider.xlsx");
		 Workbook wb=WorkbookFactory.create(fis);
		 Sheet sh=wb.getSheet("data");
		 
		 int numofrows=sh.getLastRowNum();
 		 int numofcols=sh.getRow(0).getLastCellNum();
		 
		 
		 String value[][]=new String[numofrows][numofcols];
		 for(int i=0;i<numofrows;i++)
		 {
			 for(int j=0;j<numofcols;j++) 
			  {
				DataFormatter df=new DataFormatter();
				value[i][j]= df.formatCellValue(sh.getRow(i+1).getCell(j));
//				System.out.println(value[i][j]);
				}
		 }   
		 wb.close();
		 fis.close();
		 return value;
		 
//		 for(String[] valarr:value)
//		 {
//			 System.out.println(Arrays.toString(valarr));
//		 }
		 
		
		
		 
	}
	
		 
}
	

