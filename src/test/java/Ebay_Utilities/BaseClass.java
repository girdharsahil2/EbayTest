package Ebay_Utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Ebay_Pages.ebay_landingpage;

public class BaseClass {

	public WebDriver driver=null;
	public TestData_Reader testdata=null;
	public ebay_landingpage landingpage=null;
	public static Actions action=null;
	public static ExtentReports reports=null;
	public static ExtentTest logger=null;


	@BeforeSuite
	public void SetupSuite() {
		//System.out.println("driver="+driver);
		testdata = new TestData_Reader();
		ExtentHtmlReporter html = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/ExecutionReports/ebay_"+Helper.Currentdatetime()+".html"));
		reports = new ExtentReports();
		reports.attachReporter(html);

	}

	@BeforeTest
	public void setuptest() {
		driver = BrowserFactory.startApplication(driver, testdata.getBrowserName(), testdata.getURL());
		action = new Actions(driver);
		landingpage = new ebay_landingpage(driver);
		String title = driver.getTitle();
		if(title.equalsIgnoreCase("Artículos electrónicos, autos, ropa, objetos de colección, cupones y más | eBay")) {

			System.out.println("Navigated to Ebay website in Spanish language ");
			System.out.println("***********Converting to english language***********");

			action.moveToElement(landingpage.getLanguage_element()).perform();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			action.moveToElement(landingpage.getLanguage_eng_element()).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(title.equalsIgnoreCase("Electronic items, cars, clothing, collectibles, coupons and more | eBay")) {

			System.out.println("Navigated to Ebay website in English language");
		}

		else 
		{
			System.out.println("navigated to wrong website");

		}

	}

	@AfterMethod
	public void teardownmethod(ITestResult result) throws Exception {

		if (result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());

		}

		else if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
		}
		reports.flush();
	}

	@AfterTest
	public void quitbrowser() {
		BrowserFactory.CloseApplication(driver);
	}
}
