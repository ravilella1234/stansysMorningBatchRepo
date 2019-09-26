package com.launchers;

public class TC_002 extends BaseTest
{

	public static void main(String[] args) 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
	}

}
