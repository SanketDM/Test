package flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartAddToCart 
{
	public String finalpriceF;
	
	WebDriver driver;
	
	By pin_text = By.id("pincodeInputId");
	
	By pin_check = By.className("_2P_LDn");
	
	By price_beforeAddingToCart = By.xpath("//div[@class='_30jeq3 _16Jk6d']");
	
	By addtocart = By.xpath("//button[text()='ADD TO CART']");
	
	By quantity_increase = By.xpath("(//div[text()='Save for later']/../..//button)[2]");
	
	By finalcartvalue = By.xpath("(//div[text()='Total Amount']/../..//span)[2]");
	
	By productName = By.xpath("//h1/span");
	
    public FlipkartAddToCart(WebDriver driver)
    {
    	this.driver = driver;
    }
    
    public String getProductName()
    {
    	return driver.findElement(productName).getText();
    }
    
    public void pincode() throws InterruptedException
    {
    	Thread.sleep(3000);
    	driver.findElement(pin_text).clear();    	
    	Thread.sleep(2000);
    	driver.findElement(pin_text).sendKeys("560001");
    	Thread.sleep(2000);
    }
    
    public void pinCheck() throws InterruptedException
    {
    	driver.findElement(pin_check).click();
    	Thread.sleep(3000);
    }
	
    public void printPrice() throws InterruptedException
    {
    	String Price = driver.findElement(price_beforeAddingToCart).getText().substring(1);
    	System.out.println("Price of the product in Flipkart before adding to the cart "+Price);
    	Thread.sleep(2000);
    }
    
    public void addtocart() throws InterruptedException
    {
    	driver.findElement(addtocart).click();
    	Thread.sleep(3000);
    }
    
    public void addquantity() throws InterruptedException
    {
    	driver.findElement(quantity_increase).click();
    	Thread.sleep(3000);
    }
    
    public void finalCartValue()
    {
    	finalpriceF = driver.findElement(finalcartvalue).getText().substring(1);
    	System.out.println("Price of the product in Flipkart after adding to the cart "+finalpriceF);
    }
	

}
