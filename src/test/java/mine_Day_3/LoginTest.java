package mine_Day_3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	@Test(priority = 1)
	public void checkWithoutUsername() {
		WebElement ele= driver.findElement(By.xpath("//input[@id='txtPassword']"));
		
		WebElement ele1=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		ele1.clear();
		ele.sendKeys("abcd");


		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='spanMessage']")).getText(),"Username cannot be empty");
	}
	
	@Test(priority = 2)
	public void checkWithoutPassword() {
		WebElement ele=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		
		WebElement ele1= driver.findElement(By.xpath("//input[@id='txtPassword']"));
		ele1.clear();
		ele.sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='spanMessage']")).getText(),"Password cannot be empty");
	}
	
	@Test(priority = 3)
	public void checkWithoutCredentials() {
		WebElement ele=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		ele.clear();
		WebElement ele1= driver.findElement(By.xpath("//input[@id='txtPassword']"));
		ele1.clear();
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='spanMessage']")).getText(),"Username cannot be empty");
	}
	
	@Test(priority = 4)
	public void checkLogin() {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	
	@Test(dependsOnMethods="checkLogin")
	public void createUser() {
		driver.findElement(By.xpath("//a//b[text()='Admin']")).click();
		driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
		
		driver.findElement(By.xpath("//input[@name='systemUser[employeeName][empName]']")).sendKeys("Mukesh Otwani");
		driver.findElement(By.xpath("//input[@name='systemUser[userName]']")).sendKeys("Harshith");
		driver.findElement(By.xpath("//input[@name='systemUser[password]']")).sendKeys("Harshith@123");
		driver.findElement(By.xpath("//input[@name='systemUser[confirmPassword]']")).sendKeys("Harshith@123");
		
		driver.findElement(By.xpath("//input[@name='btnSave']")).click();
		
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("index.php"));
	}
	
	@Test(priority = 6)
	public void SignInWithNewUser() {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Harshith");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Harshith@123");
		
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	
	
}
