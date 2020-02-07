package com.mercury_tours.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOn {
	
	WebDriver local_driver;
	
	 public SignOn(WebDriver remote_driver)
	{
		local_driver=remote_driver;
		PageFactory.initElements(remote_driver,this);
		
	}
	
	@FindBy(linkText="SIGN-ON")
	 @CacheLookup
	WebElement signOnLink;
	
	@FindBy(name="userName")
	 @CacheLookup
	WebElement userNameText;
	
	@FindBy(name="password")
	 @CacheLookup
	WebElement passwordText;
	
	@FindBy(name="login")
	 @CacheLookup
	WebElement loginButton;
	
	@FindBy(linkText="SIGN-OFF")
	 @CacheLookup
	WebElement signOffLink;
	


	public void clickSignOnLink()
	{
		signOnLink.click();
	}
	
	public void setUserName(String user_name)
	{
		userNameText.sendKeys(user_name);
	}
	
	public void setPassword(String pwd)
	{
		passwordText.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		loginButton.click();
	}

	public void clickSignOffLink()
	{
		signOffLink.click();
	}


}