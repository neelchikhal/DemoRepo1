package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	static LoginPage login;
	static HomePage homePage;
	static TestUtil testUtil;
	static ContactsPage contactsPage;
	

	public HomePageTest() {
		super();
	
	}
	
	@BeforeMethod
	public static void setUp() {
		
		TestBase.initialization();
		login=new LoginPage();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		homePage=login.login(prop.getProperty("username"), prop.getProperty("pwd"));
		
		
	}
	
	
	@Test(priority = 0)
	public static void verifyHomePageTitleTest() {
		
		
		String homepageTitle=HomePage.verifyHomePageTitle();
		
		Assert.assertEquals(homepageTitle, "CRMPRO");
		
	}
	
	@Test(priority = 1)
	public static void verifyUserNameTest() {
		
		testUtil.switchToFrame();
		
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	
	@Test(priority = 3)
	public static void verifyContactsLink() {
		
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
		
	}

	@AfterMethod
	public static void tearDown() {
		
		driver.quit();
		
		
	}
}
