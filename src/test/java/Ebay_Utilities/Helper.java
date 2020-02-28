package Ebay_Utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	static WebDriver driver;
	public static String CaptureScreenshot(WebDriver driver) {
		
		String screenshotpath = System.getProperty("user.dir")+"/Screenshots/ebay"+Currentdatetime()+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(screenshotpath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to take screenshot"+e.getMessage());
		}
		return screenshotpath;
		
	}
	
	public static String Currentdatetime() {
		DateFormat CustomFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return CustomFormat.format(currentDate);
	}
	
}
