package code_test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class first_test {
	
	// Setting variable for the OS name to be used for multi OS compatibility
	String os = System.getProperty("os.name").toLowerCase();
	
	// Creating object of WebDriver
	WebDriver driver;
	
	
	// Creating method that will execute task   
	public void runTest() {
		// Determines if OS is Mac or Windows and sets property to correct location
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"\\chromedriver.exe");
		}
		
		// Launch browser and navigate to page
		driver = new ChromeDriver();
		driver.get("https://www.webstaurantstore.com/");
		
		// Input search text and perform search
		driver.findElement(By.name("searchval")).sendKeys("stainless work table");
		driver.findElement(By.className("banner-search-btn")).submit();
		
		// Timeout to allow all results to load
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// Confirm all returned contain the word table 
		driver.findElement(By.id("search_within")).sendKeys("Table");
		driver.findElement(By.id("searchWithinForm")).submit();
		
		// Select last element returned add to cart
		int length = (driver.findElements(By.className("gtm-product")).toArray().length);
		String theID = "productBox" + length;
		WebElement lastItem = driver.findElement(By.id(theID));
		lastItem.findElement(By.xpath("//div[@id='"+theID+"']//div[@class='add-to-cart']//form")).submit();
		
		// Empty cart
		driver.findElement(By.className("deleteCartItemButton")).click();
		
	}
	
	// Calling method to run test
	public static void main(String[] args) {
		first_test obj = new first_test();
		obj.runTest();

	}

}
