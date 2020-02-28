package Ebay_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ebay_landingpage {

	By signin_button_loc = By.xpath("//a[contains(text(),'Sign in')]");
	By ebay_language_loc = By.className("gh-eb-Geo-txt");
	By english_link_loc = By.xpath("//span[contains(text(),'English')]");
	By Search_Textbox_loc = By.name("_nkw");
	By Search_Btn_loc = By.xpath("//input[@id='gh-btn']");
	
	public WebDriver driver;
	
	public ebay_landingpage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getSignin_btn_eng() {
		return driver.findElement(signin_button_loc);
	
	}
	
	public WebElement getLanguage_element() {
		return driver.findElement(ebay_language_loc);
		
	}
	
	public WebElement getLanguage_eng_element() {
		return driver.findElement(english_link_loc);
		
	}
	
	public WebElement getSearch_textbox() {
		return driver.findElement(Search_Textbox_loc);
		
	}
	
	public WebElement getSearch_btn() {
		return driver.findElement(Search_Btn_loc);
		
	}
	
}
