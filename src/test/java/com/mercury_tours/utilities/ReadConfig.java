package com.mercury_tours.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
static Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public  String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public  String getUserName()
	{
	String username=pro.getProperty("userName");
	return username;
	}
	
	public  String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}

	public String getTripType()
	{
	String trip_type=pro.getProperty("trip_type");
	return trip_type;
	}
	
	public int getPassengerCnt()
	{
	int passenger_cnt=Integer.parseInt(pro.getProperty("passenger_cnt"));
	return passenger_cnt;
	}
	
	public String getDeparture()
	{
	String departure=pro.getProperty("departure");
	return departure;
	}
	
	public String getOnMonth()
	{
	String onMonth=pro.getProperty("onMonth");
	return onMonth;
	}
	
	public int getOnDay()
	{
	int onDay=Integer.parseInt(pro.getProperty("onDay"));
	return onDay;
	}
	
	public String getArrival()
	{
	String arrival=pro.getProperty("arrival");
	return arrival;
	}
	
	public String getReturnMonth()
	{
	String returnMonth=pro.getProperty("returnMonth");
	return returnMonth;
	}
	
	public int getReturnDay()
	{
	int returnDay=Integer.parseInt(pro.getProperty("returnDay"));
	return returnDay;
	}
	
	public String getServiceClass()
	{
	String serviceClass=pro.getProperty("serviceClass");
	return serviceClass;
	}
	
	public String getAirlineName()
	{
	String airlineName=pro.getProperty("airlineName");
	return airlineName;
	}
	
	public String getFirstName0()
	{
	String firstName0=pro.getProperty("firstName0");
	return firstName0;
	}
	
	public String getLastName0()
	{
	String lastName0=pro.getProperty("lastName0");
	return lastName0;
	}
	
	public String getFirstName1()
	{
	String firstName1=pro.getProperty("firstName1");
	return firstName1;
	}
	
	public String getLastName1()
	{
	String lastName1=pro.getProperty("lastName1");
	return lastName1;
	}
	
	public String getFirstName2()
	{
	String firstName2=pro.getProperty("firstName2");
	return firstName2;
	}
	
	public String getLastName2()
	{
	String lastName2=pro.getProperty("lastName2");
	return lastName2;
	}
	
	public String getFirstName3()
	{
	String firstName3=pro.getProperty("firstName3");
	return firstName3;
	}
	
	public String getLastName3()
	{
	String lastName3=pro.getProperty("lastName3");
	return lastName3;
	}
	
	public int getCreditNo()
	{
	String creditNo=pro.getProperty("creditNo");
	return Integer.parseInt(creditNo);
	}
	
}




