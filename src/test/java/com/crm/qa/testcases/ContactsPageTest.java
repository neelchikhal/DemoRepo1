package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.report.ExtentReoporter;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	public static HomePage homePage;
	public static LoginPage login;
	public static TestUtil testUtil;
	public static ContactsPage contactsPage;
	public static ExtentReoporter erp;
	
	public ContactsPageTest() {
		super();
		
	}

	@BeforeTest
	public void testInit() {
		
		TestBase.initialization();
		LoginPage login=new LoginPage();
		testUtil=new TestUtil();
		homePage=new HomePage();
		contactsPage=new ContactsPage();
		login.login(prop.getProperty("username"), prop.getProperty("pwd"));
		
	
		
		
		
	}
	
	@Test(priority = 0)
	public static void  clickOnNewContactLinkTest() {
		
		testUtil.switchToFrame();
		homePage.clickOnNewContacts();
			}
	
	@DataProvider
	public Iterator<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> testData= TestUtil.readExcelData(); //since the functionreadExcelData is public static we call directly call by ClassName.FunctionName
		//testData array list holds the entire data of excel,we need to iterate it
		return testData.iterator();
		
		
	}

	@Test(dataProvider = "getDataFromExcel")
	public void createNewContactTest(String title,String fname,String lname,String company,String phonenum,String mobile,String emailid) {
		
		
		contactsPage.createNewContact(title, fname, lname, company, phonenum, mobile, emailid);
	}
	
	@AfterTest
	public static void tearDown() {
		
		driver.quit();
	}
}
