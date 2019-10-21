package com.launchers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class TC_005 extends BaseTest 
{

	public static void main(String[] args) 
	{
		
		test=report.startTest("TC_004");
		
		init();
		test.log(LogStatus.INFO, "Initilazing the properties files.....");
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :-" + p.getProperty("chromebrowser"));
		
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + p.getProperty("amazonurl"));
		
		
		/*WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		loc.sendKeys("sony");
		String actualValue = loc.getAttribute("value");
		System.out.println(actualValue);*/
		
		
		
		/*String actualLink = driver.findElement(By.linkText("AmazonBasics")).getAttribute("innerHTML");
		String expectedLink="AmazonBasics";
		
		System.out.println("Actual Link is  : "+ actualLink);
		System.out.println("Expected Link is  : "+ expectedLink);
		
		//if(actualLink.equals(expectedLink))
		//if(actualLink.equalsIgnoreCase(expectedLink))
		//if(actualLink.contains(expectedLink))
		if(actualLink.contentEquals(expectedLink))
		{
			System.out.println("Both links are equal...");
		}
		else
		{
			System.out.println("Both links are not equal...");
		}*/
		
		String actualLink = driver.findElement(By.linkText("AmazonBasics")).getAttribute("innerHTML");
		String expectedLink="AmazonBasic";
		
		System.out.println("Actual Link is  : "+ actualLink);
		System.out.println("Expected Link is  : "+ expectedLink);
		
		//Assert.assertEquals(actualLink, expectedLink);
		
		//Assert.assertTrue(actualLink.equals(expectedLink), "Both links are not equal...");
		SoftAssert s=new SoftAssert();
		
		s.assertTrue(actualLink.equals(expectedLink), "Both links are not equal...");
		
		System.out.println("end of Test...");
		
		s.assertAll();

	}

}
