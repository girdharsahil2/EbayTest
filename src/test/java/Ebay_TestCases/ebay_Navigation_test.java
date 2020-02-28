package Ebay_TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import Ebay_Utilities.BaseClass;

@Listeners(Ebay_Utilities.Listners.class)
public class ebay_Navigation_test extends BaseClass{



	@Test
	public void ebay_navigation_valid() throws Exception 
	{
		logger=reports.createTest("Ebay Navigation TestCase","This is to test the Navigation to Ebay website");
		logger.info("Ebay navigation test case started");
		logger.pass("Successfully opened the browser");
		logger.pass("Successfully Entered the URL");
		String title = driver.getTitle();
		Thread.sleep(3000);
		logger.pass("Successfully fetched the title which is "+title);
		System.out.println("The title of navigated page is "+title);
		AssertJUnit.assertEquals(title, "Electronics, Cars, Fashion, Collectibles & More | eBay");
		logger.pass("Successfully matched the title");

		System.out.println("Title matched hence test is passed");
		logger.info("Test Passed : Successfully navigated to Ebay website");

	}

}

