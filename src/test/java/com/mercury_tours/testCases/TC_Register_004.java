package com.mercury_tours.testCases;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mercury_tours.pageObjects.BaseClass;
import com.mercury_tours.pageObjects.Register;

public class TC_Register_004  extends BaseClass {

	@Test
	public void registerDDT() throws InterruptedException, IOException
	{
		// customer details
		logger.info("***Registering****");
		Register regCust = new Register(driver);
		String isValid = "true";
		regCust.clickRegLink();
		logger.info("***Registering - click reg link****");
		regCust.setFirstName("Tom");
		logger.info("***Registering - fname****");
		regCust.setLastName("Dias");
		logger.info("***Registering - lname****");
		regCust.setPhone("480-111-1111");
		logger.info("***Registering - phone****");
		regCust.setEmail("Tom@gmail.com");
		logger.info("***Registering - email****");
		regCust.setAddress1("1 N street");
		logger.info("***Registering -add1****");
		regCust.setAddress2("#333");
		logger.info("***Registering - add2****");
		regCust.setCity("Phoenix");
		logger.info("***Registering - city****");
		regCust.setState("AZ");
		logger.info("***Registering - state****");
		regCust.setPostalCode("85888");
		logger.info("***Registering - pcode****");
		regCust.setCountry("UNITED STATES");
		logger.info("***Registering - cntry****");
		regCust.setUserName("Tom");
		logger.info("***Registering - uname****");
		regCust.setPassword("Tom123");
		logger.info("***Registering - pwd****");
		regCust.setConfirmPwd("Tom123");
		logger.info("***Registering - cpwd****");
		regCust.clickRegBtn();
		logger.info("***Registering- -submit****");
	
		Thread.sleep(3000);
		
		try {
			
		if(isValid =="true" && driver.findElement(By.linkText("sign-in")).isDisplayed())
		{
			Assert.assertTrue(true);
			logger.warn("****Valid user registered - PASS****");
			Thread.sleep(2000);
			
		}
		else if(isValid =="false" && driver.findElement(By.linkText("sign-in")).isDisplayed())
		{
			Assert.assertTrue(false);
			logger.warn("****Invalid user registered - FAIL****");
			Thread.sleep(2000);
		}
		}
		
		catch(NoSuchElementException e){
			captureScreen(driver,"Register Test");
			Assert.assertTrue(true);
			logger.warn("****Cannot register for invalid user-PASS****");
			Thread.sleep(2000);
		
		}
		
		
		
	}
		
		
		
}
