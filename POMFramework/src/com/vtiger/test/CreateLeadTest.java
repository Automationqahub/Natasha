package com.vtiger.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vtiger.pages.HeaderMenusPage;
import com.vtiger.pages.NewLeadPage;
import com.vtiger.pages.loginPage;

public class CreateLeadTest {
	
public WebDriver driver;
	
@Parameters("browser")
	@BeforeClass
	public void launchApp(String browser)
	{
		if(browser.equals("ff"))  
		{
			System.setProperty("webdriver.gecko.driver","E:\\Selenium\\Selenium_Software\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}
		else if(browser.equals("ch"))  
		{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Selenium_Software\\chromedriver.exe");
		driver=new ChromeDriver();
		}		
		driver.get("http://localhost:100/");	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void createLead()
	{
		loginPage lp=new loginPage(driver);
		lp.login("admin", "admin");
		HeaderMenusPage hm=new HeaderMenusPage(driver);
		String vAct=hm.verifyLogout().trim();
		Assert.assertEquals(vAct, "Logout");
		hm.ClickNewLead();
		NewLeadPage nlp=new NewLeadPage(driver);
		nlp.createLead("Modi", "BJP");
		
	}
	
	
	
	
	
	
	@AfterClass
	public void CloseApp()
	{
		driver.quit();
	}


}
