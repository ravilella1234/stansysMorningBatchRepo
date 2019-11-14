package com.pageobjectmodel;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.DigitalProject.BaseTest;

public class LoginTest extends BaseTest
{
	LoginPage page;
  
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String btype) 
  {
	  init();
	  launch(btype);
	  navigateUrl("automationurl");
  }
  
  
  @Test
  public void f() 
  {
	 
	  page=new LoginPage(driver);
	  page.login();
	  
	  Assert.assertEquals(page.verifyLoginError(), "Authentication failed.");
	  
  }

  @AfterTest
  public void afterTest() 
  {
	  
  }

}
