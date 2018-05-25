package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderMenusPage {
	
private WebDriver driver;
	
	By logout=By.linkText("Logout");
	By NewLead=By.linkText("New Lead");
	By Leads=By.linkText("Leads");
	
	
	public HeaderMenusPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void ClickLogout()
	{
		driver.findElement(logout).click();
	}
	
	public void ClickNewLead()
	{
		driver.findElement(NewLead).click();
	}
	
	public void ClickLeads()
	{
		driver.findElement(Leads).click();
	}
	
	public String verifyLogout()
	{
		String log=driver.findElement(logout).getText();
		return log;
	}
	

}
