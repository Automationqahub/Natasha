package com.vtiger.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class loginPage {
	
	private WebDriver driver;
	
	//By logo=By.xpath("//img[@src='include/images/vtiger-crm.gif']");
	//By username=By.name("user_name");
	//By pwd=By.name("user_password");
	//By theme=By.xpath("//select[@name='login_theme']");
	//By loginbutton=By.name("Login");
	//By errormsg=By.xpath("//td[contains(text(),'You must specify a valid username and password')]");
	
	@FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']")
	WebElement logo;
	
	//@FindBy(how = How.NAME, using = "user_name") 
	@FindBy(name="user_name")
	WebElement username;
	
	@FindBy(name="user_password")
	WebElement pwd;
	
	@FindBy(xpath="//select[@name='login_theme']")
	WebElement theme;
	
	@FindBy(name="Login")
	WebElement loginbutton;
	
	@FindBy(xpath="//td[contains(text(),'You must specify a valid username and password')]")
	WebElement errormsg;
	
	
	
	
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String user,String password)
	{
		username.clear();
		username.sendKeys(user);
		pwd.clear();
		pwd.sendKeys(password);
		loginbutton.click();
	}
	
	public String verifyerrormessage()
	{
		String actualerror=errormsg.getText();
		return actualerror;
	}
	
	public String verifythemevalues()
	{
		String Values="";
		Select sel=new Select(theme);
		List<WebElement> lst=sel.getOptions();
		for(WebElement val:lst)
		{
			String value=val.getText();
			 Values=Values+";"+value;
		}		
		return Values;
	}

}
