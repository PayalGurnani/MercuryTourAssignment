package com.mercury_tours.testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mercury_tours.pageObjects.BaseClass;
import com.mercury_tours.pageObjects.SignOn;

public class TC_SignOn_001 extends BaseClass{
	
	@Test
	public void SignOnTest() throws IOException
	{
		// Sign on
		logger.info("****URL Launched****");
		SignOn signOn = new SignOn(driver);
		
		signOn.clickSignOnLink();
		signOn.setUserName(userName);
		logger.info("****User name entered****");
		signOn.setPassword(password);
		logger.info("****Password entered****");
		signOn.clickSubmit();
		
		if(driver.getTitle().equals("Find a Flight: Mercury Tours:"))
		{
			Assert.assertTrue(true);
			logger.info("****Sign On test - PASS****");
			
		}
		else
		{
			captureScreen(driver,"Sign On Test");
			Assert.assertTrue(false);
			logger.info("****Sign On test - FAIL****");
		}
		
	}

}
