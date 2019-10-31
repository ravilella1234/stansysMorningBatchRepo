package com.launchers;

import org.apache.log4j.Logger;

public class TC_003 extends BaseTest
{
	
	private static final Logger log=Logger.getLogger(TC_003.class.getName());

	public static void main(String[] args) 
	{
		init();
		log.info("Initilazing the properties files.....");
		
		launch("chromebrowser");
		log.info("Opened the Browser :-" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url :- " + p.getProperty("amazonurl"));
		
		selectOption("amazondrowdown_id","amazondropvalue");
		log.info("Seleceted the option :- "+ or.getProperty("amazondropvalue") + " by using the locator :- " + or.getProperty("amazondrowdown_id"));
		
		typeValue("amazonsearchtextbox_name","amazonsearchtext");
		log.info("Entered the text :- " + or.getProperty("amazonsearchtext") + " by using locator :- "+ or.getProperty("amazonsearchtextbox_name"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on element by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		
		
		/*driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry potter");
		
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();*/
		
	}

	

}
