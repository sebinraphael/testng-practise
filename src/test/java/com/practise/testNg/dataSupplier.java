package com.practise.testNg;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class dataSupplier {
	@DataProvider
	public  String[][] getData() throws Exception
	{
		
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
//		 wb.close();
//		 fis.close();
		 return value;
		 
//		 for(String[] valarr:value)
//		 {
//			 System.out.println(Arrays.toString(valarr));
//		 }
		 
		
		
		 
	}
	
		 
}
}
  