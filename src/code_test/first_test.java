package code_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class first_test {
	WebDriver driver;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",  "/Users/aj/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.webstaurantstore.com/");
		driver.findElement(By.name("searchval")).sendKeys("stainless work table");
		driver.findElement(By.className("banner-search-btn")).submit();
	
	}

	public static void main(String[] args) {
		first_test obj = new first_test();
		obj.launchBrowser();

	}

}
