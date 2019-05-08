/**
 * 
 */
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

/**
 * @author Neel
 *
 */
public class ContactsPage extends TestBase {
	
	HomePage hp=new HomePage();
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
		WebElement contactsPageChk;
	
	@FindBy(xpath = "//legend[contains(text(),'Contact Information')]")
	WebElement newContactPageChk;
	
	@FindBy(name = "title")
	WebElement newCntctTitle;
	
	@FindBy(name = "first_name")
	WebElement newCntctFirstName;
	
	@FindBy(name = "surname")
	WebElement newCntctLastName;
	
	@FindBy(name = "client_lookup")
	WebElement newCntctCompany;
	
	@FindBy(name= "phone")
	WebElement newCntctPhone;
	
	@FindBy(name= "mobile")
	WebElement newCntctmobile;
	
	@FindBy(name = "email")
	WebElement newCntcEmail;
	
	@FindBy(xpath = "//input[contains(@value,'Save and Create Another (same company)')]")
	WebElement saveNContinue;
	
	
	
	
	public ContactsPage() {

			PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsPage() {
		
		return contactsPageChk.isDisplayed();
	}
	
	public boolean verifyNewContactPage() {
		wait.until(ExpectedConditions.textToBePresentInElementValue(newContactPageChk, "Contact Information"));
		return newContactPageChk.isDisplayed();
		
	}
	
	
	public void createNewContact(String title,String fname,String lname,String company, String phonenum, String mobile,String emailid ) {
		
		hp.clickOnNewContacts();
		
		Select select=new Select(newCntctTitle);
		select.selectByVisibleText(title);
		
		newCntctFirstName.sendKeys(fname);
		
		newCntctLastName.sendKeys(lname);
		
		newCntctCompany.sendKeys(company);
		
		
//		newCntctPhone.sendKeys(Double.toString(phonenum));
//		
//		newCntctmobile.sendKeys(Double.toString(mobile));
		
		newCntctPhone.sendKeys(phonenum);
		
		newCntctmobile.sendKeys(mobile);
	
		
		newCntcEmail.sendKeys(emailid);
		
		saveNContinue.click();
		
		
	}
	






}


