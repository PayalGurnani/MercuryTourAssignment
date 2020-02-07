package com.mercury_tours.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlight {
	WebDriver local_driver;
	
	 public BookFlight(WebDriver remote_driver)
	{
		local_driver=remote_driver;
		PageFactory.initElements(remote_driver,this);
		
	}

	@FindBy(name="passFirst0")
	 @CacheLookup
	WebElement firstName0;
	
	@FindBy(name="passLast0")
	 @CacheLookup
	WebElement lastName0;

	@FindBy(name="passFirst1")
	 @CacheLookup
	WebElement firstName1;
	
	@FindBy(name="passLast1")
	 @CacheLookup
	WebElement lastName1;
	
	@FindBy(name="passFirst2")
	 @CacheLookup
	WebElement firstName2;
	
	@FindBy(name="passLast2")
	 @CacheLookup
	WebElement lastName2;
	
	@FindBy(name="passFirst3")
	 @CacheLookup
	WebElement firstName3;
	
	@FindBy(name="passLast3")
	 @CacheLookup
	WebElement lastName3;
	
	@FindBy(name="creditnumber")
	 @CacheLookup
	WebElement creditNo;
	
	@FindBy(name="buyFlights")
	 @CacheLookup
	WebElement bookFlightBtn;
	

	 public void setFirstName0(String fName)
	 {
		 firstName0.sendKeys(fName);
	 }
	 
	 public void setLastName0(String lName)
	 {
		 lastName0.sendKeys(lName);
	 }
	 
	 public void setFirstName1(String fName)
	 {
		 firstName1.sendKeys(fName);
	 }
	 
	 public void setLastName1(String lName)
	 {
		 lastName1.sendKeys(lName);
	 }
	 
	 public void setFirstName2(String fName)
	 {
		 firstName2.sendKeys(fName);
	 }
	 
	 public void setLastName2(String lName)
	 {
		 lastName2.sendKeys(lName);
	 }
	 
	 public void setFirstName3(String fName)
	 {
		 firstName3.sendKeys(fName);
	 }
	 
	 public void setLastName3(String lName)
	 {
		 lastName3.sendKeys(lName);
	 }
	 
	 public void setCreditNumber(int cNo)
	 {
		 creditNo.sendKeys(String.valueOf(cNo));
	 }
	 
	 public void clickBookFlights()
		{
			bookFlightBtn.click();
		}
	 
}
