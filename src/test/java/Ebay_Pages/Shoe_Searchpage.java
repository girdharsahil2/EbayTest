package Ebay_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shoe_Searchpage {

	By brand_textbox_loc = By.id("w4-w12-0[0]");
	By puma_checkbox_loc = By.xpath("//input[@type='checkbox' and @aria-label='PUMA']");
	By size_10_loc = By.xpath("//input[@type='checkbox' and @aria-label='10']");
	public WebDriver driver;
	
	public Shoe_Searchpage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getbrandtextbox() {
		
		return driver.findElement(brand_textbox_loc);
	}
	
	public WebElement getPUMAcheckbox() {
		
		return driver.findElement(puma_checkbox_loc);
	}
	
	public WebElement getsize10btn() {
		
		return driver.findElement(size_10_loc);
	}
}
