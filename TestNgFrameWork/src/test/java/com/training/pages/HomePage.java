package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	//Comment added to home page
	//Extra comment
	
    //inspecting elements	
	@FindBy(xpath = "//a[text()='Home']")
	WebElement HomeButton;
	
	@FindBy(id = "name")
	WebElement Name;
	
	//actions on elements
	public void clickHome() 
	{
		waitForElement(10, HomeButton);
		HomeButton.click();
	}
	
	public void enterName(String fname) 
	{
		Name.sendKeys(fname);
	}

}
