package com.frames;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.DigitalProject.BaseTest;

public class FrameDemo1 extends BaseTest
{

	@BeforeTest
	@Parameters("browser")
	public void startProcess(String btype)
	{
		init();	
		launch(btype);
		navigateUrl("javadocsurl");
	}
	
	@Test(enabled=false)
	public void frameDemo1()
	{
		//driver.switchTo().frame(1);
		driver.switchTo().frame(driver.findElement(By.name("contents")));
		driver.findElement(By.xpath("//p[7]//font[1]")).click();
	}
	
	@Test
	public void javadocs() throws InterruptedException
	{
		driver.switchTo().frame(driver.findElement(By.name("packageListFrame")));
		driver.findElement(By.xpath("//a[contains(text(),'java.applet')]")).click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.name("packageFrame")));
		driver.findElement(By.xpath("//a[contains(text(),'Applet')]")).click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.name("classFrame")));
		driver.findElement(By.xpath("//div[@class='description']//dl[1]//dd[1]//a[1]")).click();
		driver.switchTo().defaultContent();
		
	}
	
	

}
