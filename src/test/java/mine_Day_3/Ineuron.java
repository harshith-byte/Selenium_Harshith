package mine_Day_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ineuron {

	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
}
