package com.mercury_tours.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercury_tours.pageObjects.BaseClass;
import com.mercury_tours.pageObjects.SignOn;
import com.mercury_tours.utilities.XLUtils;

public class TC_SignOnDDT_002 extends BaseClass{
	
	@Test(dataProvider="SignOnData")
	public void SignOnDDT(String uName, String pwd, String isValid) throws InterruptedException, IOException
	{
		SignOn signOn = new SignOn(driver);
		signOn.clickSignOnLink();
		signOn.setUserName(uName);
		logger.info("****DDT User name entered****");
		signOn.setPassword(pwd);
		logger.info("****DDT User name entered****");

		signOn.clickSubmit();
		
		Thread.sleep(2000);
		
		if(isValid.equals("TRUE") && driver.getTitle().equals("Find a Flight: Mercury Tours:"))
		{
			captureScreen(driver,"Sign On Test - DDT - Pass");
			Assert.assertTrue(true);
			logger.warn("****DDT Sign On passed for valid user****");
			signOn.clickSignOffLink();
			Thread.sleep(2000);
			
		}
		else if (isValid.equals("FALSE") && driver.getTitle().equals("Find a Flight: Mercury Tours:"))
		{
			captureScreen(driver,"Sign On Test - DDT - Fail");
			Assert.assertTrue(false);
			logger.warn("****DDT Sign On successful for an invalid user****");
			
		}
		
		else if (isValid.equals("FALSE"))
		{
			captureScreen(driver,"Sign On Test - DDT -cannot login for invalid user - Pass");
			Assert.assertTrue(true);
			logger.warn("****DDT Cannot Sign On for invalid user ****");
		
		}		
		
	}
	
	//fetching sign on data from the excel file
	@DataProvider(name="SignOnData")
	String[][] getData() throws IOException
	{
		String path =System.getProperty("user.dir")+"/src/test/java/com/mercury_tours/testData/MercuryToursTestData.xlsx";
		
		int rowNum = XLUtils.getRowCount(path, "SignOn");
		int colNum = XLUtils.getCellCount(path, "SignOn", 1);
		
		String signOnData[][] = new String[rowNum][colNum];
		
		
		for(int i=1; i<=rowNum; i++)
		{
			for(int j = 0; j<colNum; j++)
			{
				
				if(j!=colNum-1)
				{
				signOnData[i-1][j]=XLUtils.getCellData(path, "SignOn", i, j);
				}
				else
				{
					signOnData[i-1][j]=XLUtils.getCellData(path, "SignOn", i, j);
				
				}
				
			}
		}
	
		return signOnData;
	}
	
}
