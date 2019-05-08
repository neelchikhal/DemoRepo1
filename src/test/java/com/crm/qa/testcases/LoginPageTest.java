/**
 * 
 */
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

/**
 * @author Neel
 *
 */
public class LoginPageTest extends TestBase {
	//if this is not done then we will have null pointer exception for prop
	public LoginPageTest() {
		super();
	}
	
	static LoginPage login;
	static HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		
		TestBase.initialization();
		login=new LoginPage(); //initialize all object repository
	}
	
	
	@Test(priority=1)
	public static void loginPageTitleTest() {
		
		String actualTitle=login.verifyPageTitle();
		
		Assert.assertEquals(actualTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority=2)
	public static void crmLogoImageTest() {
		
		boolean flag=login.validateCrmLogo();
		
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public static void loginTest() {
		
		
		homePage=login.login(prop.getProperty("username"), prop.getProperty("pwd"));
	}
	
	@AfterMethod
	public static void tearDown() {
		
		driver.quit();
	}
		
	
		
	}//end of class




