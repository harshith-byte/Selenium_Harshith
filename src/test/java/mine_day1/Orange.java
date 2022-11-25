package mine_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Orange {

//	public static void main(String[] args) throws InterruptedException {
	
		// TODO Auto-generated method stub
	@Test
public void test4() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("index.php"));
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a//b[text()='Admin']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='systemUser[employeeName][empName]']")).sendKeys("Mukesh Otwani");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='systemUser[userName]']")).sendKeys("Akash");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='systemUser[password]']")).sendKeys("Akash@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='systemUser[confirmPassword]']")).sendKeys("Akash@123");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='btnSave']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Akash");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Akash@123");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	}

}
