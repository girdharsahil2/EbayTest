package Ebay_TestCases;

import org.testng.annotations.Test;

import Ebay_Pages.Shoe_Searchpage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import Ebay_Utilities.BaseClass;

@Listeners(Ebay_Utilities.Listners.class)
public class ebay_NavigationTest extends BaseClass
{
	Shoe_Searchpage shoesearch =null;
	List<WebElement> ls =null;
	List<WebElement> ls_price =null;
	int count;
	
	@Test(priority=1)
	public void ebay_navigation_valid() throws Exception 
	{
		logger=reports.createTest("Ebay Navigation TestCase","This is to test the Navigation to Ebay website");
		logger.info("Ebay navigation test case started");
		logger.pass("Successfully opened the browser");
		logger.pass("Successfully Entered the URL");
		String title = driver.getTitle();
		Thread.sleep(5000);
		logger.pass("Successfully fetched the title which is "+title);
		System.out.println("The title of navigated page is "+title);
		AssertJUnit.assertEquals(title, "Electronics, Cars, Fashion, Collectibles & More | eBay");
		logger.pass("Successfully matched the title");

		System.out.println("Title matched hence test is passed");
		Thread.sleep(5000);
		logger.info("Test Passed : Successfully navigated to Ebay website");
	}
	
	@Test(priority=2)
	public void Search_Ebay() throws Throwable 
	{
		
		logger=reports.createTest("Ebay Search Testcase","This is to test the Search functionality of Ebay website");
		logger.info("Ebay search test case started");
		logger.pass("Successfully opened the browser");
		logger.pass("Successfully Entered the URL");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		landingpage.getSearch_textbox().sendKeys(testdata.getSearch_text());
		logger.pass("Entered Shoes text successfully");
		
		landingpage.getSearch_btn().sendKeys(Keys.RETURN);
		logger.pass("Clicked on search button successfully");
		Thread.sleep(10000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		shoesearch = new Shoe_Searchpage(driver);
		
		js.executeScript("arguments[0].scrollIntoView();",shoesearch.getbrandtextbox());
		logger.pass("Succesfully scrolled to search brand textbox");
		Thread.sleep(5000);
		
		shoesearch.getbrandtextbox().sendKeys("PUMA");
		logger.pass("Successfully entered text PUMA in brand textbox");
		
		shoesearch.getPUMAcheckbox().click();
		logger.pass("Successfully selected PUMA brand");
		Thread.sleep(5000);
		
		js.executeScript("arguments[0].scrollIntoView();", shoesearch.getsize10btn());
		shoesearch.getsize10btn().click();
		Thread.sleep(5000);
	
		//action.moveToElement(shoesearch.getfilter_dropdown()).click().perform();
		shoesearch.getfilter_dropdown().click();
		logger.pass("Successfully clicked on filter dropdown");
		action.moveToElement(shoesearch.getincprice_dropdown()).click().perform();
		logger.pass("Successfully selected Price + Shipping: lowest first filter from dropdown");
		Thread.sleep(5000);
		
		String shoeresult_raw = (shoesearch.getshoe_searchresult().getText()).substring(0, 5);
		System.out.println("Total search results for size 10 PUMA shoes is "+shoeresult_raw);
		logger.pass("Successfully printed total result in console");
		Thread.sleep(2000);
		
		ls = shoesearch.getlist_productsearched();
		count = ls.size();
		System.out.println("Total Search reasults in the current page are "+count);
		
		List actual_price_list = new ArrayList();
		ls_price = shoesearch.getproductprice();
		
		for(count=0;count<5;count++) {
			String price_list = ls_price.get(count).getText();
			//System.out.println("value in the list is "+price_list);
			actual_price_list.add(price_list);
		}
		
		/*for(WebElement ele:ls_price) {
			String Price_Data = ele.getText();
			actual_price_list.add(Price_Data);
		}*/
		
		List temp_price_list = new ArrayList();
		temp_price_list.addAll(actual_price_list);
		//Collections.sort(temp_price_list);
		//System.out.println(temp_price_list);
		
		Assert.assertTrue(actual_price_list.equals(temp_price_list));
		logger.pass("Successfully asserted the order taking the first 5 results ");
		
	}
	
	@Test(priority=3)
	public void first5productswithprices() {
		
		logger=reports.createTest("first5productswithprices TestCase","This is to print first five products with their prices on Console");
		logger.info("first5productswithprices test case started");
		
		for(int i=0;i<5;i++) { 
			String shoetext = ls.get(i).getText();
			String ShoePrice = ls_price.get(i).getText();
			System.out.println("The name of the product is "+shoetext+" And The price is "+ShoePrice);}
		logger.pass("Successfully printed the first five products with their prices on Console");
	}
	
	@Test(priority=4)
	public void Order_print_products_byprice_descendant() throws Throwable 
	{
		logger=reports.createTest("Order_print_products_byprice_descendant TestCase","This is to Order_print_products_byprice_descendant on Console");
		logger.info("Order_print_products_byprice_descendant test case started");
		shoesearch.getfilter_dropdown().click();
		action.moveToElement(shoesearch.get_decprice_dropdown()).click().perform();
		Thread.sleep(5000);
		
		List<WebElement> ls_desc = shoesearch.getlist_productsearched();
		int desc_count = ls_desc.size();
		
		for(int j=0;j<desc_count;j++) { 
			
			String shoetext1 = ls_desc.get(j).getText();
			System.out.println("The name of the product is "+shoetext1);
			}
		logger.pass("Successfully printed the products of the current Webpagepage on Console by price descendant");
	}
	
}

