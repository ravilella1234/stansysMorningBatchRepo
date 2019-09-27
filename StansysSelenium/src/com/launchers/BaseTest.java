package com.launchers;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static String dataPath=projectPath+"//data.properties";
	public static Properties p;
	
	public static void init()
	{
		try 
		{
			FileInputStream fis=new FileInputStream(dataPath);
			p=new Properties();
			p.load(fis);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\jars\\chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, projectPath+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\jars\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", projectPath+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Given browser was not matching...");
		}
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(p.getProperty(url));
		driver.navigate().to(p.getProperty(url));
	}

}








