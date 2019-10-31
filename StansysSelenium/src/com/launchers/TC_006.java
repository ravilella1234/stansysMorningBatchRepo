package com.launchers;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class TC_006 extends BaseTest
{

	public static void main(String[] args) 
	{
		test=report.startTest("TC_006");
		
		init();
		test.log(LogStatus.INFO, "Initilazing the properties files.....");
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :-" + p.getProperty("chromebrowser"));
		
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + p.getProperty("amazonurl"));
		
		
		
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		if(!verifyTitle(expectedTitle))
			failReport("Both Titles are not equal...");
		else
			passReport("Both Titles are equal...");
		
		
		
		String expectedLink="AmazonBasic";
		if(!verifyElement(expectedLink))
			failReport("Both elements are not equal...");
		else
			passReport("Both elements are equal...");
		
		report.endTest(test);
		report.flush();

	}

	

}
