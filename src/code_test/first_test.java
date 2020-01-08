package code_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class first_test {
	String os = System.getProperty("os.name").toLowerCase();
	WebDriver driver;

	public void runTest() {
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver",  "/Users/aj/Downloads/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver",  "/Users/aj/Downloads/chromedriver.exe");

		}
		driver = new ChromeDriver();
		driver.get("https://www.webstaurantstore.com/");
		driver.findElement(By.name("searchval")).sendKeys("stainless work table");
		driver.findElement(By.className("banner-search-btn")).submit();
	
	}

	public static void main(String[] args) {
		first_test obj = new first_test();
		obj.runTest();

	}

}
