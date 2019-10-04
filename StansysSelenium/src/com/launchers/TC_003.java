package com.launchers;

public class TC_003 extends BaseTest
{

	public static void main(String[] args) 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		selectOption("amazondrowdown_id","amazondropvalue");
		
		typeValue("amazonsearchtextbox_name","amazonsearchtext");
		
		clickElement("amazonsearchbutton_xpath");
		
		/*driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry potter");
		
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();*/
		
	}

	

}
