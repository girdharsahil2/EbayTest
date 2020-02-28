package Ebay_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class TestData_Reader {

	Properties prop;
	public TestData_Reader() {
		
		prop = new Properties();
		try 
		{
			FileInputStream datafile = new FileInputStream("/Users/sahilgirdhar/eclipse-workspace-new/Ebay_AutomationProject/src/test/java/Ebay_Utilities/TestData.properties");
			prop.load(datafile);
		} 
		catch (Exception e) 
		{
			System.out.println("Not able to load test data file_reason_"+e.getMessage());
		} 
		
	}
	
	public String getBrowserName() {
		return prop.getProperty("BrowserName");
	}
	
	public String getURL() {
		return prop.getProperty("URL");
	}
	
	public String getSearch_text() {
		return prop.getProperty("Search_text");
	}
}
