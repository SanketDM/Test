package testCases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import amazon.AmazonHomepage;
import flipkart.FlipkartAddToCart;
import flipkart.FlipkartHomepage;
import amazon.AmazonAddToCart;

public class TC02_ComparePrices 
{
	static String str1;
	static String str2;
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		flipSearchTest();
		
		String productName = flipSelectTest();
		
		amazSearchTest(productName);
		
		amazSelectTest();
		
		finalResult();
		
		driver.quit();
	}
	
	public static void flipSearchTest() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+File.separator+"dependencies"+File.separator+"chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		FlipkartHomepage FlipHomeobj = new FlipkartHomepage(driver);
        
        driver.get("http://flipkart.com");
        Thread.sleep(3000);
        
        FlipHomeobj.closeLoginPopup();
        
        FlipHomeobj.setTextInSearchBox("Iphone 12");
        
        FlipHomeobj.clickSearchButton();
        
        FlipHomeobj.clickFirstLink();
        
        
        
        
        
       
  	}
	
	public static String flipSelectTest() throws InterruptedException
	{
		String productName = "";
		FlipkartAddToCart FlipKartobj = new FlipkartAddToCart(driver);
		
		for(String tab:driver.getWindowHandles())
        {
        	driver.switchTo().window(tab);
        }
		
		
		FlipKartobj.pincode();
		
		productName = FlipKartobj.getProductName();
		FlipKartobj.pinCheck();
		
		FlipKartobj.printPrice();
		
		FlipKartobj.addtocart();
		
		FlipKartobj.finalCartValue();
		
		str1 = FlipKartobj.finalpriceF.replace(",", "");	
		
		return productName;
	}
	
	public static void amazSearchTest(String productName) throws InterruptedException
	{
		AmazonHomepage AmazHomeobj = new AmazonHomepage(driver);
		
		driver.get("http://www.amazon.in");
		Thread.sleep(3000);
		
		AmazHomeobj.searchProduct(productName);
		
		AmazHomeobj.clickSearchLookup();
		
		AmazHomeobj.selectProduct(productName);
		
	}
	
	public static void amazSelectTest() throws InterruptedException
	{
		AmazonAddToCart AmazCartobj = new AmazonAddToCart(driver);
		
		for(String tab2:driver.getWindowHandles())
        {
        	driver.switchTo().window(tab2);
        }
		
		AmazCartobj.initialPrice();
		
		AmazCartobj.addToCart();
		
		AmazCartobj.totalCartValue();
		
		str2 = AmazCartobj.finalPriceA.replace(",", "");						
	}
	
	public static void finalResult()
	{	 
        int r1 = Integer.parseInt(str1);
        double d1 = Double.parseDouble(str2);
        int r2 = (int)d1;
        
        
        if(r1>r2)
        {
        	System.out.println("Product is available at low cost in Amazon.com");
        }
        else if(r1==r2)
        {
        	System.out.println("Price of the product is same in both the websites");
        }
        else
        {
        	System.out.println("Product is available at low cost in Flipkart.com");
        }
	}

}
