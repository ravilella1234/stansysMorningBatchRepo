package com.pageobjectmodel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.DigitalProject.BaseTest;

public class LoginTest extends BaseTest
{
	LoginPage page;
  
  @BeforeMethod
  @Parameters("browser")
  public void beforeTest(String btype) 
  {
	  init();
	  launch(btype);
	  navigateUrl("automationurl");
  }
  
  
  @Test(priority=1)
  public void login() 
  {
	  page=new LoginPage(driver);
	  page.login();  
	  Assert.assertEquals(page.verifyLoginError(), "Authentication failed."); 
  }
  
 
  @Test(priority=2)
  public void registration() throws InterruptedException
  {
	  page=new LoginPage(driver);
	  page.customerRegistration();
  }

  @AfterMethod
  public void afterTest() 
  {
	  driver.quit();
  }

}
