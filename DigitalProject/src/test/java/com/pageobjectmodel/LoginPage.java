package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(xpath="//a[@class='login']")WebElement signIn;
	@FindBy(id="email")WebElement customerEmail;
	@FindBy(id="passwd")WebElement customerPassword;
	@FindBy(id="SubmitLogin")WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")WebElement customerError;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public  void login()
	{
		signIn.click();
		customerEmail.sendKeys("qatest845787@gmail.com");
		customerPassword.sendKeys("password");
		submitLogin.click();
	}
	
	public String verifyLoginError()
	{
		String actualError = customerError.getText();
		return actualError;
	}
	

}
