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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vtiger.common.commonFunctions;
import com.vtiger.pages.HeaderMenusPage;
import com.vtiger.pages.loginPage;

public class LoginTest {
	
	public static ExtentReports report;
	public static ExtentTest logger; 
	public static String extentReport;
	
	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void launchApp(String browser)
	{
		report=commonFunctions.setupResult();
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
	    System.out.println("GIT Jenkins integrations");
	}
	
	
	@Test
	public void validLogin()
	{
		logger=report.startTest("validLogin", "Verify valid login scenario");
		logger.log(LogStatus.INFO, "Application Lauched successfully");
		loginPage lp=new loginPage(driver);
		lp.login("admin", "admin");
		logger.log(LogStatus.PASS, "Login successfull");
		HeaderMenusPage hm=new HeaderMenusPage(driver);
		String vAct=hm.verifyLogout().trim();
		Assert.assertEquals(vAct, "Logout");
		logger.log(LogStatus.PASS, "Logout successfull");
		report.endTest(logger);
	}
	
	
	@Test
	public void InvalidLogin()
	{
		logger=report.startTest("InvalidLogin", "Verify invalid login scenario");
		logger.log(LogStatus.INFO, "Application Lauched successfully");
		loginPage lp=new loginPage(driver);
		lp.login("admin1", "admin1");		
		String vAct=lp.verifyerrormessage();
		try
		{
		Assert.assertEquals(vAct, "You must specify a valid username and password.");
		logger.log(LogStatus.PASS, "error message validated successfull");
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
			logger.log(LogStatus.FAIL, "Assert unsuccessfull");
		}
		
		report.endTest(logger);
	}
	
	
	
	
	@AfterClass
	public void CloseApp()
	{
		report.flush();
		driver.quit();
	}

}
