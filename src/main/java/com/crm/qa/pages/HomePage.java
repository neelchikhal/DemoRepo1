/**
 * 
 */
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.TestBase;

/**
 * @author Neel
 *
 */
public class HomePage extends TestBase {
	
	
	@FindBy(xpath = "//td[contains(text(),'neel chikhal')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(@title,'Contacts')]")
	static
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[@title=\"Deals\"]")
	WebElement dealsLink;
	

	@FindBy(xpath = "//a[contains(@title,'New Contact')]")
	WebElement newContactsLabel;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this );
	
	}
	
	public static String verifyHomePageTitle() {
				
		return driver.getTitle();
			
	}
	
	public boolean verifyCorrectUserName() {
		
		return userNameLabel.isDisplayed();
		
	}
	
	public ContactsPage clickOnContactsLink() {
		wait.until(ExpectedConditions.elementToBeClickable(contactsLink));
		contactsLink.click();
		return new ContactsPage();
			
	}
	
	public DealsPage clickOnDealsLink() {
		wait.until(ExpectedConditions.elementSelectionStateToBe(dealsLink, true));
		dealsLink.click();
		return new DealsPage();
			
	}
	
	
	
	public void clickOnNewContacts() {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.contactsLink));
		action.moveToElement(HomePage.contactsLink).build().perform();
		
		newContactsLabel.click();
	}

}
