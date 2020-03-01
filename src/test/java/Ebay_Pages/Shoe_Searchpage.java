package Ebay_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shoe_Searchpage {

	By brand_textbox_loc = By.id("w4-w12-0[0]");
	By puma_checkbox_loc = By.xpath("//input[@type='checkbox' and @aria-label='PUMA']");
	By size_10_loc = By.xpath("//input[@type='checkbox' and @aria-label='10']");
	By ShoeSearchResult_loc = By.xpath("//h1[@class='srp-controls__count-heading']");
	By filter_dropdwn_loc = By.xpath("//button[@id='w23-button'][@class='fake-menu-button__button expand-btn expand-btn--small expand-btn--secondary']");
	By inc_price_loc = By.xpath("//span[@id='w23-content-0[3]']");
	By prod_list_loc = By.xpath("//*[h3[starts-with(@class, 's-item__title')]]");
	By prod_price_loc = By.xpath("//*[starts-with(@class, 's-item__price')]");
	
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
	
	public WebElement getshoe_searchresult() {
		return driver.findElement(ShoeSearchResult_loc);
	}
	
	public WebElement getfilter_dropdown() {
		return driver.findElement(filter_dropdwn_loc);
	}
	
	public WebElement getincprice_dropdown() {
		return driver.findElement(inc_price_loc);
	}
	
	public List<WebElement> getlist_productsearched() {
		return driver.findElements(prod_list_loc);
		
	}
	
	public List<WebElement> getproductprice() {
		return driver.findElements(prod_price_loc);
		
	}
}
