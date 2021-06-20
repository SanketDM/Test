package testCases;

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
		
		flipSelectTest();
		
		amazSearchTest();
		
		amazSelectTest();
		
		finalResult();
	}
	
	public static void flipSearchTest() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sanket\\eclipse-workspace\\Ecom2\\dependencies\\chromedriver.exe");
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
	
	public static void flipSelectTest() throws InterruptedException
	{
		FlipkartAddToCart FlipKartobj = new FlipkartAddToCart(driver);
		
		for(String tab:driver.getWindowHandles())
        {
        	driver.switchTo().window(tab);
        }
		
		FlipKartobj.pincode();
		
		FlipKartobj.pinCheck();
		
		FlipKartobj.printPrice();
		
		FlipKartobj.addtocart();
		
		FlipKartobj.finalCartValue();
		
		str1 = FlipKartobj.finalpriceF.replace(",", "");	
	}
	
	public static void amazSearchTest() throws InterruptedException
	{
		AmazonHomepage AmazHomeobj = new AmazonHomepage(driver);
		
		driver.get("http://www.amazon.in");
		Thread.sleep(3000);
		
		AmazHomeobj.searchProduct("Iphone 12");
		
		AmazHomeobj.clickSearchLookup();
		
		AmazHomeobj.selectProduct();
		
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
