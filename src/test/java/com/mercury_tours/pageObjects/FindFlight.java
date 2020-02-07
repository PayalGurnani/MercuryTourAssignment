package com.mercury_tours.pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FindFlight {
	
	WebDriver local_driver;
	
	 public FindFlight(WebDriver remote_driver)
	{
		local_driver=remote_driver;
		PageFactory.initElements(remote_driver,this);
		
	}
	
	@FindBy(name="tripType")
	 @CacheLookup
	List<WebElement> type;
	
	@FindBy(name="passCount")
	 @CacheLookup
	WebElement passengers;
	
	@FindBy(name="fromPort")
	 @CacheLookup
	WebElement departure;
	
	@FindBy(name="fromMonth")
	 @CacheLookup
	WebElement onMonth;
	
	@FindBy(name="fromDay")
	 @CacheLookup
	WebElement onDay;
	
	@FindBy(name="toPort")
	 @CacheLookup
	WebElement arrival;
	
	@FindBy(name="toMonth")
	 @CacheLookup
	WebElement returnMonth;
	
	@FindBy(name="toDay")
	 @CacheLookup
	WebElement returnDay;
 
	@FindBy(name="servClass")
	 @CacheLookup
	 List<WebElement> serviceClass;
	
	@FindBy(name="airline")
	 @CacheLookup
	WebElement airlineName;
	
	@FindBy(name="findFlights")
	 @CacheLookup
	WebElement findBtn;
	
	
	
	public void setType(String trip_type)
	{
		 for(WebElement type: type) { 

			    if(type.getAttribute("value").equals(trip_type))
			    	type.click();
			}
	}
	
	
	public void setPassengerCount(int pass_cnt)
	{
		 Select pCnt = new Select(passengers);
		 pCnt.selectByVisibleText(String.valueOf(pass_cnt));
	}
	
	
	public void setDeparture(String dep)
	{
		Select d = new Select(departure);
		 d.selectByVisibleText(dep);
	}
	
	
	public void setOnMonth(String frm_mnth)
	{
		Select fMnth = new Select(onMonth);
		 fMnth.selectByVisibleText(frm_mnth);
	}
	
	
	public void setOnDay(int frm_day)
	{
		Select fDy = new Select(onDay);
		 fDy.selectByVisibleText(String.valueOf(frm_day));
	}
	
	
	public void setArrival(String arr)
	{
		Select a = new Select(arrival);
		 a.selectByVisibleText(arr);
	}
	
	public void setReturnMonth(String to_mnth)
	{
		Select tMnth = new Select(returnMonth);
		 tMnth.selectByVisibleText(to_mnth);
	}
	
	
	public void setReturnDay(int to_day)
	{
		Select tDy = new Select(returnDay);
		 tDy.selectByVisibleText(String.valueOf(to_day));
	}

	public void setServiceClass(String sClass)
	{
		   for(WebElement serviceClass: serviceClass) { 

			    if(serviceClass.getAttribute("value").equals(sClass))
			    	serviceClass.click();
			}
		
	}
	
	public void setAirlineName(String aName)
	{
		Select aNm = new Select(airlineName);
		 aNm.selectByVisibleText(aName);
	}
	
	public void clickFindFlight()
	{
		findBtn.click();
	}
	

}
