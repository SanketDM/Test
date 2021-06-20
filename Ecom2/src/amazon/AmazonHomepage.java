package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomepage 
{

	WebDriver driver;
	
	By searchbox = By.id("twotabsearchtextbox");
	
	By submitsearch = By.id("nav-search-submit-button");
	
	By productselect = By.xpath("//span[contains(text(),'New Apple iPhone 12 (128GB) - Black')]");
	
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
	
	public void selectProduct()
	{
		driver.findElement(productselect).click();
	}
}
