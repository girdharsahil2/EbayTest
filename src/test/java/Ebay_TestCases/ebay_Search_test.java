package Ebay_TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Ebay_Pages.Shoe_Searchpage;
import Ebay_Utilities.BaseClass;

@Listeners(Ebay_Utilities.Listners.class)
public class ebay_Search_test extends BaseClass 
{

	@Test
	public void Search_Ebay() throws Throwable 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Shoe_Searchpage shoesearch = new Shoe_Searchpage(driver);
		
		logger=reports.createTest("Ebay Search Testcase","This is to test the Search functionality of Ebay website");
		logger.info("Ebay search test case started");
		logger.pass("Successfully opened the browser");
		logger.pass("Successfully Entered the URL");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		landingpage.getSearch_textbox().sendKeys(testdata.getSearch_text());
		logger.pass("Entered Shoes text successfully");
		
		landingpage.getSearch_btn().sendKeys(Keys.RETURN);
		logger.pass("Clicked on search button successfully");
		Thread.sleep(5000);
		
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
		action.moveToElement(shoesearch.getincprice_dropdown()).click().perform();
		Thread.sleep(5000);
		
		String shoeresult_raw = (shoesearch.getshoe_searchresult().getText()).substring(0, 5);
		System.out.println("The search results for size 10 PUMA shoes is "+shoeresult_raw);
		Thread.sleep(5000);
		
		List<WebElement> ls = shoesearch.getlist_productsearched();
		int count = ls.size();
		System.out.println("Total Search reasults are in the current page is "+count);
		
		for(int i=0;i<5;i++) { 
			String shoetext = ls.get(i).getText();
			//System.out.println("The name of the product is "+shoetext); 
			List<WebElement> ls_price = shoesearch.getproductprice();
			String ShoePrice = ls_price.get(i).getText();
			System.out.println("The name of the product is "+shoetext+" And The price is "+ShoePrice);
			}
		
		
	}


}
