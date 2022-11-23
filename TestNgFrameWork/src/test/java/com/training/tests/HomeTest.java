package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeTest extends BaseTest
{
	 WebDriver driver;
     String url;
	 CommonUtilities common = new CommonUtilities();
	 String browser;
	 LoginPage login;
     String email;
     String password;
     HomePage home;
	 
	@BeforeMethod
	 public void beforemethod() throws IOException 
	 {
		url = common.getproperty("url");
		browser = common.getproperty("browser");
		email = common.getproperty("email");
		password = common.getproperty("password");
		driver = getDriver(browser);
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
	 }
	
	 @Test	
	 public void validateHomeScreen() 
	 {
		 login.enterIntoEmail(email);
		 login.enterIntoPassword(password);
		 login.cilckOnLogin();	
		 home.clickHome();
		 home.enterName("Neelima");
	 }
	
//	 @Test
//	 public void validateUserTab() 
//	 {
//		
//	 }
 
}
