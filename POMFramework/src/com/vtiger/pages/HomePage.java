package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends HeaderMenusPage {
	
	private WebDriver driver;
	
	
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	
	public void verifydashboard()
	{
		System.out.println("verification done for dashboard");
	}

}
