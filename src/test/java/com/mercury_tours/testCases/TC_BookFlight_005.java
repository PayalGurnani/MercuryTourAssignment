package com.mercury_tours.testCases;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mercury_tours.pageObjects.BaseClass;
import com.mercury_tours.pageObjects.BookFlight;
import com.mercury_tours.pageObjects.FindFlight;
import com.mercury_tours.pageObjects.SelectFlight;
import com.mercury_tours.pageObjects.SignOn;
import com.mercury_tours.utilities.ReadConfig;

public class TC_BookFlight_005 extends BaseClass{
	
	@Test
	public void bookFlight() throws InterruptedException, ParseException, IOException
	{
		// Signing in
	  logger.info("****URL Launched****");
	  SignOn signOn = new SignOn(driver);
	  signOn.clickSignOnLink();
	  signOn.setUserName(userName);
	  logger.info("****Username entered****");
	  signOn.setPassword(password);
	  logger.info("****Password entered****");
	  signOn.clickSubmit();
	  
	  Thread.sleep(2000);
	  
	  //Filling in 1st page details to find the flights for the given criteria
	  FindFlight fnFlight = new FindFlight(driver);
	  ReadConfig rc = new ReadConfig();
	  fnFlight.setType(rc.getTripType());
	  fnFlight.setPassengerCount(rc.getPassengerCnt());
	  fnFlight.setDeparture(rc.getDeparture());
	  fnFlight.setOnMonth(rc.getOnMonth());
	  fnFlight.setOnDay(rc.getOnDay());
	  fnFlight.setArrival(rc.getArrival());
	  fnFlight.setReturnMonth(rc.getReturnMonth());
	  fnFlight.setReturnDay(rc.getReturnDay());
	  fnFlight.setServiceClass(rc.getServiceClass());
	  fnFlight.setAirlineName(rc.getAirlineName());
	  fnFlight.clickFindFlight();
	  Thread.sleep(3000);
	  logger.info("****Find a Flight details entered****");
	  
	  //2nd page - Selecting the last flights from the lists
	  SelectFlight slFlight = new SelectFlight(driver);
	  
	  List<WebElement> dep_cols = driver.findElements(By
	            .xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[2]"));
	  //tr[@name='']
	  /*for(int i =0;i<dep_cols.size();i++) {
     	 String elementText = dep_cols.get(i).getText(); 
     	 System.out.println("dep_cols::::"+elementText); 
     	}*/

	    List<WebElement> dep_rows = driver.findElements(By
	            .xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr"));
	 /*   for(int i =0;i<dep_rows.size();i++) {
	     	 String elementText= dep_rows.get(i).getText(); 
	     	 System.out.println("dep_rows::::"+elementText); 
	    }*/
	    
	  String lastDepartFlight = lastFlightSelect(dep_rows,dep_cols);
	  
	  slFlight.setDepartFlight(lastDepartFlight);
	  
	  List<WebElement> ret_cols = driver.findElements(By
	            .xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[2]"));
	  System.out.println("Cols222:::"+dep_cols);
	    List<WebElement> ret_rows = driver.findElements(By
	            .xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr"));
	    
	  
	    
	    String lastReturnFlight = lastFlightSelect(ret_rows,ret_cols);
	    slFlight.setReturnFlight(lastReturnFlight);
	  	    
	    slFlight.clickReserveFlights();
	    Thread.sleep(4000);
	    logger.info("****Select flights details entered****");
	  
	  //3rd page - entering passenger details and booking the flight
	    BookFlight bkFlight = new BookFlight(driver);
	    int ps_cnt = rc.getPassengerCnt();
	
	    switch(ps_cnt)
	    {
	    case 1: bkFlight.setFirstName0(rc.getFirstName0());
	     		bkFlight.setLastName0(rc.getLastName0());   
		   break;
		   
	    case 2: 
	    		bkFlight.setFirstName0(rc.getFirstName0());
			    bkFlight.setLastName0(rc.getLastName0());  
	    	
			    bkFlight.setFirstName1(rc.getFirstName0());
			    bkFlight.setLastName1(rc.getLastName0());   
		   break;
		   
	    case 3: 
	    	bkFlight.setFirstName0(rc.getFirstName0());
		    bkFlight.setLastName0(rc.getLastName0());  
    	
		    bkFlight.setFirstName1(rc.getFirstName0());
		    bkFlight.setLastName1(rc.getLastName0()); 
		    
	    	bkFlight.setFirstName2(rc.getFirstName0());
		    bkFlight.setLastName2(rc.getLastName0());   
		   break;
		   
	    case 4: 
	    	bkFlight.setFirstName0(rc.getFirstName0());
		    bkFlight.setLastName0(rc.getLastName0());  
    	
		    bkFlight.setFirstName1(rc.getFirstName0());
		    bkFlight.setLastName1(rc.getLastName0()); 
		    
	    	bkFlight.setFirstName2(rc.getFirstName0());
		    bkFlight.setLastName2(rc.getLastName0()); 
	    	
	    	bkFlight.setFirstName3(rc.getFirstName0());
		    bkFlight.setLastName3(rc.getLastName0());   
		   break;
		   
		   default : bkFlight.setFirstName0(rc.getFirstName0());
    				bkFlight.setLastName0(rc.getLastName0());   
    				break;
	    }
	  
	   bkFlight.setCreditNumber(rc.getCreditNo());
	   bkFlight.clickBookFlights();
	   Thread.sleep(5000);
	   logger.info("****Flight booking details entered****");
	   
	   try {
		   //flight booked confirmation message
	   if(driver.findElement(By.xpath("//img[@src='/images/masts/mast_confirmation.gif']")).isDisplayed())
	   {
		   Assert.assertTrue(true);
			logger.warn("****Flight Successfully booked - PASS****");
			Thread.sleep(2000);
			
	   }
	   }
	   catch(NoSuchElementException e)
	   {
		   captureScreen(driver,"Book flight Test");
			Assert.assertTrue(false);
			logger.warn("****Flight booking unsuccessful****");
			Thread.sleep(2000);
	   }
	    
	}
	  

 //function to fetch the last flight of the day record 
	private String lastFlightSelect( List<WebElement> rows, List<WebElement> cols) throws ParseException {

		 DateFormat inFormat = new SimpleDateFormat("hh:mm"); 
		    String time = "00:00";
		    String colValueTime;
		    
		    for (int rowCount = 2; rowCount < rows.size(); rowCount++) {
		        List<WebElement> rowCells = rows.get(rowCount).findElements(
		                By.tagName("td"));
		        
		      /*  for(int i =0;i<rowCells.size();i++) {
		        	 String elementText = rowCells.get(i).getText(); 
		        	 System.out.println("rowCells::::"+elementText); 
		        	}*/
		        
		        if(rowCells.size()>1) {
		        for (int count = 0; count < cols.size(); count++) {
		            // Get  time into list
		            if (cols.get(count).getText().contains("DEPART")) {
		            	colValueTime =  rowCells.get(2).getText();
		                
		                if(inFormat.parse(colValueTime).compareTo(inFormat.parse(time))>0) 
		                {

		                	   time =colValueTime;
		                	 
		                 }
		               }   
		        	}
		        }
		    
	 }
	    
	        return time;
	}
}

