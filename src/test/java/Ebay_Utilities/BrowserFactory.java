package Ebay_Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver,String BrowserName, String URL) {
		
		String projectpath = System.getProperty("user.dir");
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectpath+"/Drivers/ChromeDriver/chromedriver");
			driver= new ChromeDriver();
		}
		
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectpath+"/Drivers/geckoDriver/geckodriver");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void CloseApplication(WebDriver driver) {
		driver.close();
	}
	
	
}
