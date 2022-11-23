package com.training.tests;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

//Tests - Sequence of steps

public class LoginTest extends BaseTest
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
		//System.out.println(driver);
		//System.out.println(url);
		Log.info("url of the appliction");
		driver.get(url);
		driver.manage().window().maximize();
		//when we give the parameter in object this will call constructor.
		login = new LoginPage(driver); //creating object for LoginPage		
		home = new HomePage(driver); //creating object for HomePage
		DOMConfigurator.configure("log4j.xml");
	}
	@Test    
	public void loginValidUserName()
	{
		System.out.println("TestCase started");
		Log.info("starting the TestCase"); //log files will save the information from console in folder what ever we give print with log.info. 
		Log.info("Username entered" +email);
		Log.info("Password entered"+password);
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.cilckOnLogin();		
		//home.clickHome();
		System.out.println("TestCase ended");

	}
	
//	@Test    
//	public void loginInvalidusernameandpassword()
//	{
//		
//
//	}
	
	@AfterMethod
	public void teardown()
	{
		takescreenShot(driver);
		driver.close();
	}

}
