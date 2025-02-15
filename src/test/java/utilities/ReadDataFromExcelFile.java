package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelFile 
{
	
	public static String[][] getData() throws IOException
	{
		//Reading data from excel file
		File f=new File("./Data/Book1.xlsx");
		FileInputStream fis=new FileInputStream(f);	
		XSSFWorkbook workbook=new XSSFWorkbook(fis);		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rows=sheet.getLastRowNum(); //5--> it give index basis value starting from 0,1,2,3,4,5
		
		int cols = sheet.getRow(0).getLastCellNum(); //2---> gives value in index form and add +1
			
		System.out.println("number pf rows " + rows); //5
		System.out.println("number pf columns " + cols ); //2
		 
		//int a[]=new int[5];
		//int a[][]=new int[4][2];
		                            //5   //2
		String data[][]=new String[rows][cols];   
		              
		                //5
		for(int i=1 ; i<=rows   ; i++)     //1, 2
		{
			
				 XSSFRow row=sheet.getRow(i);    //akshay@gmail  akshay123
	                          //2
	          for( int j=0 ; j<cols  ;j++)  //0, 1 
	          {
		        	XSSFCell cell = row.getCell(j);      //akshay@gmail 
		        	System.out.print(cell);
			        data[i-1][j]=cell.toString();					
	          }
					         
		    
		}
		return data;
		
	}

}
