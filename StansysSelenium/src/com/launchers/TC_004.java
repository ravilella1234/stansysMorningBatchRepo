package com.launchers;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.LogStatus;

public class TC_004 extends BaseTest
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
		
		
		selectOption("amazondrowdown_id","amazondropvalue");
		test.log(LogStatus.INFO, "Seleceted the option :- "+ or.getProperty("amazondropvalue") + " by using the locator :- " + or.getProperty("amazondrowdown_id"));

		
		typeValue("amazonsearchtextbox_name","amazonsearchtext");
		test.log(LogStatus.INFO, "Entered the text :- " + or.getProperty("amazonsearchtext") + " by using locator :- "+ or.getProperty("amazonsearchtextbox_name"));

		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.INFO, "Clicked on element by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));
				
		
		report.endTest(test);
		report.flush();
		
		/*driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry potter");
		
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();*/
		
	}

	

}
