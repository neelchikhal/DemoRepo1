/**
 * 
 */
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

/**
 * @author Neel
 *
 */
public class LoginPage extends TestBase {
	
	
	@FindBy(name="username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//1.) Initializing Page Objects
	//to initialize above web elements we have to use page factory method inside constructor
		public LoginPage() {
		PageFactory.initElements(driver, this);
	//this meanas initialize current(LoginPage) class elements	
		
	}
	
		
		//2.) Actions:
		
		//verifying title
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	
	//verifying logo
	public boolean validateCrmLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	//Login Method -- will redirect to homepage
	
	public HomePage login(String un,String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginBtn.click();
		
		return new HomePage();
		
		
	}
}
