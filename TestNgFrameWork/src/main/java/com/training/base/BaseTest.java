package com.training.base;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static com.training.utilities.Constants.*; // if you put .* after constant all constants will import itself, no need to import each constant. 
//import static com.training.utilities.Constants.USER_DIR;
//import static com.training.utilities.Constants.FILE_SEPARATOR;
//import static com.training.utilities.Constants.SCREENSHOT_PATH;

public class BaseTest 
{
	private WebDriver driver;
	
	public WebDriver getDriver(String browser) 
	{
		if (browser.equalsIgnoreCase("chrome")) 
		{		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} 		
		return driver;
	}
	
	public void takescreenShot(WebDriver driver) //creating method for taking screenshots
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver); //syntax
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE); //syntax
		
		//if we need to take more than one screenshot we need to use this time format, and this will give orderly by using time.
		Date currentDate = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
		
		//String fileSeparator = System.getProperty("file.separator");
		//String reportFilePath = System.getProperty("user.dir")+fileSeparator+"ScreenShot";
		String reportFilePath = USER_DIR+FILE_SEPARATOR+SCREENSHOT_PATH;
		String fileName = "neelima "+timeStamp+".png";
		String filepath = reportFilePath+FILE_SEPARATOR+fileName;
		System.out.println(filepath);
		
		File destFile = new File(filepath); //if you want do with hard coded filePath you can give here filePath, then no need to use above 4 lines. 
		try {
			FileUtils.copyFile(scrfile, destFile);
		} catch (IOException e) 
		{			
			e.printStackTrace();
		}//ScreenShot folder path
	}
	

}
