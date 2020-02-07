package com.mercury_tours.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlight {
	WebDriver local_driver;
	
	 public SelectFlight(WebDriver remote_driver)
	{
		local_driver=remote_driver;
		PageFactory.initElements(remote_driver,this);
		
	}
	
	@FindBy(name="outFlight")
	 @CacheLookup
	List<WebElement> departFlight;
	
	@FindBy(name="inFlight")
	 @CacheLookup
	List<WebElement> returnFlight;
	
	@FindBy(name="reserveFlights")
	 @CacheLookup
	WebElement resvFlightBtn;
	
	public void setDepartFlight(String depFlight)
	{
		 for(WebElement departFlight: departFlight) { 

			    if(departFlight.getAttribute("value").contains(depFlight))
			    	departFlight.click();
			}
	}
	
	public void setReturnFlight(String retFlight)
	{
		 for(WebElement returnFlight: returnFlight) { 

			    if(returnFlight.getAttribute("value").contains(retFlight))
			    	returnFlight.click();
			}
	}
	
	public void clickReserveFlights()
	{
		resvFlightBtn.click();
	}
	
	
	
	
}
