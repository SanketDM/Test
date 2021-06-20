package flipkart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FlipkartHomepage 
{
	WebDriver driver;
	
	By close_loginpopup = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	
	By textbox_search = By.name("q");
	
	By button_search = By.className("_34RNph");
	
	By firstLink_click = By.xpath("//div[@class='_4rR01T']");
	
	
	public FlipkartHomepage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void closeLoginPopup()
	{
		driver.findElement(close_loginpopup).click();
	}
	
	public void setTextInSearchBox(String text)
	{
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() throws InterruptedException
	{
		driver.findElement(button_search).click();
		Thread.sleep(3000);
	}
	
	public void clickFirstLink()
	{
		driver.findElement(firstLink_click).click();
	}

}
