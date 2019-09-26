package com.launchers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		driver=new FirefoxDriver();
		driver.get("https://www.bestbuy.com");

	}

}
