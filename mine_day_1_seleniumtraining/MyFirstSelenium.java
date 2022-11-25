package mine_day_1_seleniumtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyFirstSelenium {

	WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}
		
	@Parameters("browser")
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	@Parameters("browser")
	@Test
	public void google() {
		driver.findElement(By.name("q")).sendKeys("harshith",Keys.ENTER);
		
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		String title = driver.getTitle();
		
		System.out.println("title is "+title);
		
		String url = driver.getCurrentUrl();
		System.out.println("URL is "+url);
		
		Assert.assertTrue(url.contains("google"));
	}
	

		

	

}
