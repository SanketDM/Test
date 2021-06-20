package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomepage 
{

	WebDriver driver;
	
	By searchbox = By.id("twotabsearchtextbox");
	
	By submitsearch = By.id("nav-search-submit-button");
		
	public AmazonHomepage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void searchProduct(String productname)
	{
		driver.findElement(searchbox).sendKeys(productname);
	}
	
	public void clickSearchLookup()
	{
		driver.findElement(submitsearch).click();
	}
	
	public void selectProduct(String productName)
	{
		productName = productName.substring(productName.indexOf("("));
		
		productName = productName.substring(1,productName.indexOf(" ")-1);
		
		By val = By.xpath("//h2//span[contains(text(),'iPhone') and contains(text(),'"+productName+"')]");
		driver.findElement(val).click();
	}
}
