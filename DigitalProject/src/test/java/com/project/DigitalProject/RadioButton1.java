package com.project.DigitalProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class RadioButton1 extends BaseTest
{

	@BeforeMethod(groups= {"regression","smoke"})
	@Parameters("browser")
	  public void beforeMethod(String bType) 
	  {
		
		System.out.println("startprocess");
	  	test=report.startTest("RadioButton1");
		
		init();
		test.log(LogStatus.INFO, "Initilazing the properties files.....");
		
		launch(bType);
		test.log(LogStatus.INFO, "Opened the Browser :-" + p.getProperty("chromebrowser"));
		
		
		navigateUrl("radiourl");
		test.log(LogStatus.INFO, "Navigated to url :- " + p.getProperty("radiourl"));
		
	  }
	
	
	@Test(groups= {"regression","smoke"})
	public void checkboxTest()
	{
		WebElement radio=driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		List<WebElement> rbutton=radio.findElements(By.name("group1"));
		for(int i=0;i<rbutton.size();i++)
		{
			System.out.println(rbutton.get(i).getAttribute("value")+ "----" + rbutton.get(i).getAttribute("checked"));
		}
	}
 

  @AfterMethod(groups= {"regression","smoke"})
  public void afterMethod() 
  {
	 closeBrowser();
	 report.endTest(test);
	  report.flush();
  }
	
}
