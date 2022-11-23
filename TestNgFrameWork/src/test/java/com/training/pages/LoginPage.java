package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LoginPage extends BasePage 
{
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id = "email_field")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='password_field']")
	WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'Login to Account')]")
	WebElement button;	
	
	public void enterIntoEmail(String stremail) 
	{
		waitForElement(30, email);
		email.sendKeys(stremail);
	}
	
	public void enterIntoPassword(String strpassword) 
	{
		password.sendKeys(strpassword);
	}
	
	public void cilckOnLogin() 
	{
		button.click();
	}


}
