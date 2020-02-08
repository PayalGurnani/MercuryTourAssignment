package com.mercury_tours.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register {
	
	WebDriver local_driver;
	
	 public Register(WebDriver remote_driver)
		{
			local_driver=remote_driver;
			PageFactory.initElements(remote_driver,this);
			
		}
	 
	 @FindBy(how = How.LINK_TEXT, using = "REGISTER" )
	 @CacheLookup
	 WebElement registerLink;
	 
	 @FindBy(how = How.NAME, using = "firstName" )
	 @CacheLookup
	 WebElement firstName;
	 
	 @FindBy(how = How.NAME, using = "lastName" )
	 @CacheLookup
	 WebElement lastName;
	 
	 @FindBy(how = How.NAME, using = "phone" )
	 @CacheLookup
	 WebElement phone;
	 
	 @FindBy(how = How.NAME, using = "userName" )
	 @CacheLookup
	 WebElement email;
	 
	 @FindBy(how = How.NAME, using = "address1" )
	 @CacheLookup
	 WebElement address1;
	 
	 @FindBy(how = How.NAME, using = "address2" )
	 @CacheLookup
	 WebElement address2;
	 
	 @FindBy(how = How.NAME, using = "city" )
	 @CacheLookup
	 WebElement city;
	 
	 @FindBy(how = How.NAME, using = "state" )
	 @CacheLookup
	 WebElement state;
	 
	 @FindBy(how = How.NAME, using = "postalCode" )
	 @CacheLookup
	 WebElement postalCode;
	 
	 @FindBy(how = How.NAME, using = "country" )
	 @CacheLookup
	 WebElement country;

	 @FindBy(how = How.NAME, using = "email" )
	 @CacheLookup
	 WebElement userName;
	 
	 @FindBy(how = How.NAME, using = "password" )
	 @CacheLookup
	 WebElement password;
	 
	 @FindBy(how = How.NAME, using = "confirmPassword" )
	 @CacheLookup
	 WebElement confirmPwd;
	 
	 @FindBy(how = How.NAME, using = "register" )
	 @CacheLookup
	 WebElement registerBtn;
	 
	 
	 
	 public void clickRegLink()
	 {
		 registerLink.click();
	 }
	 
	 public void clickRegBtn()
	 {
		 registerBtn.click();
	 }
	 
	 public void setFirstName(String fName)
	 {
		 firstName.sendKeys(fName);
	 }
	 
	 
	 public void setLastName(String lName)
	 {
		 lastName.sendKeys(lName);
	 }
	 
	 public void setPhone(String phNo)
	 {
		 phone.sendKeys(phNo);
	 }
	 
	 public void setEmail(String eml)
	 {
		 email.sendKeys(eml);
	 }
	 
	 public void setAddress1(String add1)
	 {
		 address1.sendKeys(add1);
	 }
	 
	 public void setAddress2(String add2)
	 {
		 address2.sendKeys(add2);
	 }
	 
	 public void setCity(String cName)
	 {
		 city.sendKeys(cName);
	 }
	 
	 public void setState(String sName)
	 {
		 state.sendKeys(sName);
	 }
	 
	 public void setPostalCode(String pCode)
	 {
		 postalCode.sendKeys(pCode);
	 }
	 
	 public void setCountry(String cntry)
	 {
		 Select countryVal = new Select(country);
		 countryVal.selectByVisibleText(cntry);
	 }
	 
	 public void setUserName(String uName)
	 {
		 userName.sendKeys(uName);
	 }
	 
	 public void setPassword(String pwd)
	 {
		 password.sendKeys(pwd);
	 }
	 
	 public void setConfirmPwd(String cPwd)
	 {
		 confirmPwd.sendKeys(cPwd);
	 }
	 
}
