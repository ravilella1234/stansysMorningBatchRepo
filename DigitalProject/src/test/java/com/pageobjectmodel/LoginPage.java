package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.DigitalProject.BaseTest;

public class LoginPage extends BaseTest
{
	//loginPage Properties
	@FindBy(xpath="//a[@class='login']")WebElement signIn;
	@FindBy(id="email")WebElement customerEmail;
	@FindBy(id="passwd")WebElement customerPassword;
	@FindBy(id="SubmitLogin")WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")WebElement customerError;
	
	
	//Registration Page Properties
			@FindBy(id="email_create") public WebElement custEmail;
			@FindBy(id="SubmitCreate") public WebElement Submit;
			@FindBy(xpath=".//*[@id='create_account_error']/ol/li") public WebElement error;
			@FindBy(id="id_gender1") public WebElement Title_gen1;
			@FindBy(id="id_gender2") public WebElement Title_gen2;
			@FindBy(id="customer_firstname") public WebElement FirstName;
			@FindBy(id="customer_lastname") public WebElement LastName;
			@FindBy(id="days") public WebElement DOB_day;
			@FindBy(id="months") public WebElement DOB_month;
			@FindBy(id="years") public WebElement DOB_year;
			@FindBy(id="firstname") public WebElement FirtName_address;
			@FindBy(id="lastname") public WebElement LastName_address;
			@FindBy(id="company") public WebElement Company;
			@FindBy(id="address1") public WebElement Address_1;
			@FindBy(id="address2") public WebElement Address_2;
			@FindBy(id="city") public WebElement City;
			@FindBy(id="id_state") public WebElement State;
			@FindBy(id="postcode") public WebElement Postcode;
			@FindBy(id="id_country") public WebElement Country;
			@FindBy(id="other") public WebElement TextArea;
			@FindBy(id="phone") public WebElement Phone;
			@FindBy(id="phone_mobile") public WebElement Mobile_Phone;
			@FindBy(id="alias") public WebElement Alias_address;
			@FindBy(id="submitAccount") WebElement submitAccount;
	
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void customerRegistration() throws InterruptedException
	{
		signIn.click();
		custEmail.sendKeys(p.getProperty("firstname")+p.getProperty("lastname")+ranNumber()+p.getProperty("domain"));
		System.out.println(custEmail.getAttribute("value"));
		Submit.click();
		
		//Thread.sleep(3000);
		
		waitForElement(Title_gen1, 30);
	
		Title_gen1.click();
		FirstName.sendKeys("qa");
		LastName.sendKeys("test");
		customerPassword.sendKeys("password");
		DOB_day.sendKeys("12");
		DOB_month.sendKeys("April");
		DOB_year.sendKeys("2015");
		Address_1.sendKeys("Hyderabad");
		City.sendKeys("hyderabad");
		State.sendKeys("California");
		Postcode.sendKeys("12345");
		Country.sendKeys("United States");
		Mobile_Phone.sendKeys("9676273760");
		Alias_address.sendKeys("USA");
		submitAccount.click();
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
