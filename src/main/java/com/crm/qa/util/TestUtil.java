/**
 * 
 */
package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.qa.base.TestBase;

/**
 * @author Neel
 *
 */
public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10; 
	
	public static String TEST_DATA_SHEET_PATH="D:\\eclipse-workspace\\FreeCRMTestAutomation\\Library\\DataDrivenApproach.xlsx";

	public static String title;
	public static String fname;
	public static String lname;
	public static String company;
	public static String phonenum;
	public static String mobilenum;
	public static String emailid;

	public void switchToFrame() {
		
		driver.switchTo().frame("mainpanel");
		
	}


	public static ArrayList<Object[]> readExcelData() {
		
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		
		File src=new File(TEST_DATA_SHEET_PATH);
		
	 
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			
			XSSFSheet sh1=wb.getSheetAt(0);
			
			int rowcount=sh1.getLastRowNum();
			
			int i=0,j=0;
			
			for (i=1;i<=rowcount;i++) {
				
				title=sh1.getRow(i).getCell(j).getStringCellValue();
				j++;
				fname=sh1.getRow(i).getCell(j).getStringCellValue();
				j++;
				lname=sh1.getRow(i).getCell(j).getStringCellValue();
				j++;
				company=sh1.getRow(i).getCell(j).getStringCellValue();
				j++;
				phonenum=String.valueOf(sh1.getRow(i).getCell(j).getNumericCellValue());
				j++;
				mobilenum=String.valueOf(sh1.getRow(i).getCell(j).getNumericCellValue());
				j++;
				emailid=sh1.getRow(i).getCell(j).getStringCellValue();
				j=0;
				
				Object[] ob= {title,fname,lname,company,phonenum,mobilenum,emailid}; //Storing data first in object array
				
				myData.add(ob);
			}
			
			wb.close();
		} catch (FileNotFoundException e) {
			System.out.println("Incorrect File PAth");
		
		} catch (IOException e) {
			System.out.println("Some Input Output Error Occured");
		} 
		
	
		return myData;
	}
	
}


