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
	
	By addtocart = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	
	By quantity_increase = By.xpath("//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/button[2]");
	
	By finalcartvalue = By.cssSelector("div._1Er18h div._6t1WkM._3HqJxg div._1YokD2._2GoDe3.col-12-12 div._1YokD2._3Mn1Gg.col-4-12._78xt5Y:nth-child(2) div._1AtVbE.col-12-12 div.dimARw div._35mLK5 div._I_XQO div._3LxTgx:nth-child(4) div.Ob17DV span:nth-child(2) div._1dqRvU div.Ob17DV._3X7Jj1 > span:nth-child(2)");
	
	
    public FlipkartAddToCart(WebDriver driver)
    {
    	this.driver = driver;
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
