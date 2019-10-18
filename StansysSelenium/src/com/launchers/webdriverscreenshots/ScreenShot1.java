package com.launchers.webdriverscreenshots;

import java.io.File;
import java.io.IOException;

import javax.swing.plaf.FileChooserUI;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot1 
{

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\jars\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\DELL\\Desktop\\gmail.jpeg"));
		
		
		//File srcscreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(srcscreen, new File("C:\\Users\\DELL\\Desktop\\gmail.png"));
				
		
		//File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(srcscreen, new File("C:\\Users\\DELL\\Desktop\\gmail.png"));
		//FileHandler.copy(srcfile, new File("C:\\Users\\DELL\\Desktop\\gmail1.png"));
			
	}
}
