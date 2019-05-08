/**
 * 
 */
package com.crm.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;

/**
 * @author Neel
 *
 */
public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public static Actions action;
	public static WebDriverWait wait;
	
	

	public TestBase() {
		
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("D:\\eclipse-workspace\\FreeCRMTestAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		
		
		} catch (FileNotFoundException e) {
			System.out.println("Incorrect config file path!");
			
		} catch (IOException e) {
			System.out.println("Some Input Output Error Occured!");
		}
		
		
					
		}// end of constructor
		
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "D:\\eclipse-workspace\\FreeCRMTestAutomation\\Library\\geckodriver.exe");
			driver=new FirefoxDriver();
			}
		else
		{
			System.setProperty("webdriver.chromedriver.driver", "D:\\eclipse-workspace\\TestNGBasics'\\Lib\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		action=new Actions(driver);
		driver.get(prop.getProperty("url"));
		
		
	} // end if initialization
		
	}//end of class
	
	
	


