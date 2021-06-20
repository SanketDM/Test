package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonAddToCart 
{
	public String finalPriceA;
	
	WebDriver driver;
	
	By beforeprice = By.id("priceblock_dealprice");
	
	By addtocart = By.id("add-to-cart-button");
	
	By finalprice = By.id("attach-accessory-cart-subtotal");
	
	public AmazonAddToCart(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void initialPrice() throws InterruptedException
	{
		String initPrice = driver.findElement(beforeprice).getText().substring(1);
		System.out.println("Price of the product in Amazon before adding to the cart "+initPrice);
		Thread.sleep(3000);
	}
	
	public void addToCart() throws InterruptedException
	{
		driver.findElement(addtocart).click();
		Thread.sleep(3000);
	}
	
	public void totalCartValue() throws InterruptedException
	{
		finalPriceA = driver.findElement(finalprice).getText().substring(1);
		System.out.println("Price of the product in Amazon after adding to the cart "+finalPriceA);
		Thread.sleep(3000);
		
	}

}
