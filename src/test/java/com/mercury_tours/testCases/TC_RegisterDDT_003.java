package com.mercury_tours.testCases;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercury_tours.pageObjects.BaseClass;
import com.mercury_tours.pageObjects.Register;
import com.mercury_tours.utilities.XLUtils;

public class TC_RegisterDDT_003 extends BaseClass {
	//fetch customers data from the excel file
	@DataProvider(name = "RegisterData")
	public String[][] getData() throws IOException
	{
		String path =System.getProperty("user.dir")+"/src/test/java/com/mercury_tours/testData/MercuryToursTestData.xlsx";
		
		int rowNum = XLUtils.getRowCount(path, "Register");
		int colNum = XLUtils.getCellCount(path, "Register", 1);
		
		String registerData[][] = new String[rowNum][colNum];
		
		
		for(int i=1; i<=rowNum; i++)
		{
			for(int j = 0; j<colNum; j++)
			{
				
				if(j!=colNum-1)
				{
					registerData[i-1][j]=XLUtils.getCellData(path, "Register", i, j);
				System.out.println("Credentials::::"+registerData[i-1][j]);
				}
				else
				{
					registerData[i-1][j]=XLUtils.getCellData(path, "Register", i, j);
					System.out.println("Is valid:::::"+registerData[i-1][j]);
				
				}
				
			}
		}
		for(int i=0;i<registerData.length;i++)
		{
			for (int j = 0; j < registerData[i].length; j++) 
			{
				System.out.println("Registered data:::::"+registerData[i][j]);
			}
		}
	
		return registerData;
	}

	@Test(dataProvider = "RegisterData")
	public void registerDDT(String fName, String lName, String phone, String email, String add1, String add2, String city, String state, String pCode, String cntry, String uName, String pwd, String cPwd,String isValid) throws InterruptedException, IOException
	{
		logger.info("***Registering****");
		Register regCust = new Register(driver);
		
		regCust.clickRegLink();
		logger.info("***Registering - click reg link****");
		regCust.setFirstName(fName);
		logger.info("***Registering - fname****");
		regCust.setLastName(lName);
		logger.info("***Registering - lname****");
		regCust.setPhone(phone);
		logger.info("***Registering - phone****");
		regCust.setEmail(email);
		logger.info("***Registering - email****");
		regCust.setAddress1(add1);
		logger.info("***Registering -add1****");
		regCust.setAddress2(add2);
		logger.info("***Registering - add2****");
		regCust.setCity(city);
		logger.info("***Registering - city****");
		regCust.setState(state);
		logger.info("***Registering - state****");
		regCust.setPostalCode(pCode);
		logger.info("***Registering - pcode****");
		regCust.setCountry(cntry);
		logger.info("***Registering - cntry****");
		regCust.setUserName(uName);
		logger.info("***Registering - uname****");
		regCust.setPassword(pwd);
		logger.info("***Registering - pwd****");
		regCust.setConfirmPwd(cPwd);
		logger.info("***Registering - cpwd****");
		regCust.clickRegBtn();
		logger.info("***Registering- -submit****");
	
		Thread.sleep(3000);
		try {
		if(isValid.equals("TRUE") && driver.findElement(By.linkText("sign-in")).isDisplayed())
		{
			captureScreen(driver,"Register Test - Pass");
			Assert.assertTrue(true);
			logger.warn("****Valid user registered - PASS****");
			Thread.sleep(2000);
			
		}
		else if (isValid.equals("FALSE") &&  driver.findElement(By.linkText("sign-in")).isDisplayed())
		{
			captureScreen(driver,"Register Test - Fail");
			Assert.assertTrue(false);
			logger.warn("****Registration successful for an invalid user-FAIL****");
			Thread.sleep(2000);
			
		}
		}
		
		catch(NoSuchElementException e) {
		if(isValid.equals("FALSE"))
		{
			captureScreen(driver,"Register Test - Cannot register for invalid user-PASS");
			Assert.assertTrue(true);
			logger.warn("****Cannot register for invalid user-PASS****");
			Thread.sleep(2000);
		
		}
		}
		
		
		
	}
		
		
		
	
	
		
}
