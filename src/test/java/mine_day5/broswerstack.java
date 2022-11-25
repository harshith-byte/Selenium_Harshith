package mine_day5;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class broswerstack {

	URL url;
	WebDriver driver;
	
	@Parameters({"os","osVersion","browser","browserVersion"})
	@BeforeMethod
	public void setup(String os,String osVersion,String browser,String browserVersion) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("os", os);
		capabilities.setCapability("osVersion", osVersion);
		capabilities.setCapability("browser", browser);
		capabilities.setCapability("browserVersion", browserVersion);
		
		 url = new URL("https://harshith_CIKeWq:HqfxeswBHhyspfwbPiwi@hub-cloud.browserstack.com/wd/hub");
		 driver = new RemoteWebDriver(url,capabilities);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void test() {
//		driver.get("https://www.naukri.com/");
//		Assert.assertEquals(driver.getTitle().contains("Recruitment"), true);
		
		driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
		
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

		driver.findElement(By.xpath("//a//b[text()='Admin']")).click();

		
		driver.findElement(By.xpath("//input[@name='btnAdd']")).click();

		
		driver.findElement(By.xpath("//input[@name='systemUser[employeeName][empName]']")).sendKeys("Mukesh Otwani");
		driver.findElement(By.xpath("//input[@name='systemUser[userName]']")).sendKeys("Harshith");
		driver.findElement(By.xpath("//input[@name='systemUser[password]']")).sendKeys("Harshith@123");
		driver.findElement(By.xpath("//input[@name='systemUser[confirmPassword]']")).sendKeys("Harshith@123");

		driver.findElement(By.xpath("//input[@name='btnSave']")).click();

		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Harshith");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Harshith@123");

		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	}
	
	
}
