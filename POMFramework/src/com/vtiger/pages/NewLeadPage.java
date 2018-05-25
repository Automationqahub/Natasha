package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewLeadPage extends HeaderMenusPage{
	
private WebDriver driver;
	
	
	By lastname=By.xpath("//input[@name='lastname']");
	By company=By.xpath("//input[@name='company']");
	By SaveBtn=By.xpath("//input[@name='button']");
	
	public NewLeadPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	
	public void createLead(String lname, String Comp)
	{
		driver.findElement(lastname).sendKeys(lname);
		driver.findElement(company).sendKeys(Comp);
		driver.findElement(SaveBtn).click();
	}
	
	

}
