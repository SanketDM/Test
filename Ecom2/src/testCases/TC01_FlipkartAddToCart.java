package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import flipkart.FlipkartAddToCart;
import flipkart.FlipkartHomepage;

public class TC01_FlipkartAddToCart 
{
    
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		flipSearchTest();
		
		flipSelectTest();
	}
	
	public static void flipSearchTest() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sanket\\Desktop\\Selenium\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
        FlipkartHomepage FlipPage1obj = new FlipkartHomepage(driver);
        
        driver.get("http://flipkart.com");
        Thread.sleep(3000);
        
        FlipPage1obj.closeLoginPopup();
        
        FlipPage1obj.setTextInSearchBox("Iphone 11");
        
        FlipPage1obj.clickSearchButton();        
        
        FlipPage1obj.clickFirstLink();
        
       
  	}
	
	public static void flipSelectTest() throws InterruptedException
	{
		FlipkartAddToCart Page2 = new FlipkartAddToCart(driver);
		
		for(String tab:driver.getWindowHandles())
        {
        	driver.switchTo().window(tab);
        }
		
		Page2.pincode();
		
		Page2.pinCheck();
		
		Page2.printPrice();
		
		Page2.addtocart();
		
		Page2.addquantity();
		
		Page2.finalCartValue();
	}

}