package com.project.DigitalProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static String dataPath=projectPath+"//data.properties";
	public static String orPath=projectPath+"//or.properties";
	public static String log4jPath=projectPath+"//log4j.properties";
	public static Properties p;
	public static Properties or;
	
	public static ExtentReports report=ExtentManager.getInstance();
	public static ExtentTest test;
	
	public static void init()
	{
		try 
		{
			FileInputStream fis=new FileInputStream(dataPath);
			p=new Properties();
			p.load(fis);
			
			FileInputStream fis1=new FileInputStream(orPath);
			or=new Properties();
			or.load(fis1);
			
			FileInputStream fis2=new FileInputStream(log4jPath);
			PropertyConfigurator.configure(fis2);
			
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void launch(String browser)
	{
		if(browser.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\jars\\chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, projectPath+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
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
		driver.manage().window().maximize();
	}
	
	public static WebElement getElement(String locatorKey)
	{
		WebElement element=null;
		
		if(locatorKey.endsWith("_id")){
			element=driver.findElement(By.id(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element=driver.findElement(By.name(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element=driver.findElement(By.className(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element=driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element=driver.findElement(By.linkText(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallink")) {
			element=driver.findElement(By.partialLinkText(or.getProperty(locatorKey)));
		}
		return element;
		
	}
	
	
	public static void clickElement(String locatorKey) 
	{
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(or.getProperty(locatorKey))).click();
	}

	public static void typeValue(String locatorKey, String value) 
	{
		getElement(locatorKey).sendKeys(or.getProperty(value));
		//driver.findElement(By.id(or.getProperty(locatorKey))).sendKeys(or.getProperty(value));
	}

	public static void selectOption(String locatorKey, String option) 
	{
		getElement(locatorKey).sendKeys(or.getProperty(option));
		//driver.findElement(By.id(or.getProperty(locatorKey))).sendKeys(or.getProperty(option));
	}
	
	
	// ************************* Verificatons  *******************
	
	public static boolean verifyTitle(String expectedTitle)
	{
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle))
			return true;
		else 
			return false;
	}
	
	
	public  static boolean verifyElement(String expectedLink)
	{
		String actualLink = driver.findElement(By.linkText("AmazonBasics")).getText();
		if(actualLink.equals(expectedLink))
			return true;
		else
			return false;
	}
	
	
	// ************************** Reportings   ******************
	
	public static void passReport(String passMessage) 
	{
		test.log(LogStatus.PASS, passMessage);
	}

	public static void failReport(String failureMessage) 
	{
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenshot();
	}

	public static void takeScreenshot() 
	{
		Date dt=new Date();
		String screenshotFileName = dt.toString().replace(":", "_").replace(" ", "_")+".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(scrFile, new File(projectPath+"//failure//"+screenshotFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//put screen shot file in extent reports
		test.log(LogStatus.INFO, "Screenshot --> "+ test.addScreenCapture(projectPath+"//failure//"+screenshotFileName));
		
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}
	

}








