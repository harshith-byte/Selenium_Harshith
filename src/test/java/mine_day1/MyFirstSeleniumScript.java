package mine_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstSeleniumScript {
//	public static void main(String[] args) {
	@Test
		public void test() {
	    ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Akash Udaykumar",Keys.ENTER);
		String title= driver.getTitle();
		System.out.println("Title is"+title);
		String url= driver.getCurrentUrl();
		System.out.println("URL is "+url);
		Assert.assertTrue(driver.getCurrentUrl().contains("google"));
//		driver.quit();
	}

}
