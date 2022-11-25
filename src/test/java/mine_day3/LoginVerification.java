package mine_day3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginVerification {
	WebDriver d;
	@BeforeClass
		public void setup() {
			d= new ChromeDriver();
			d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			d.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		@AfterClass
		public void teardown() {
			d.quit();
		}
	@Test(priority= 1)
	public void emptyUsernamePassword() {
		
		d.findElement(By.xpath("//input [@name= 'Submit']")).click();
		WebElement f= d.findElement(By.xpath("//span [text()= 'Username cannot be empty']"));
		AssertJUnit.assertTrue(f.isDisplayed());
		
	}
	@Test(priority=2)
	public void emptyPassword() {
		WebElement f= d.findElement(By.xpath("//input [@name= 'txtUsername']"));
		f.sendKeys("akash");
		WebElement f1= d.findElement(By.xpath("//input [@name= 'txtPassword']"));
		d.findElement(By.xpath("//input [@name= 'Submit']")).click();
		WebElement f2=d.findElement(By.xpath("//span [text()= 'Password cannot be empty']"));
		AssertJUnit.assertTrue(f2.isDisplayed());
		
	}
	@Test(priority=3)
	public void emptyUsername() {
		WebElement f= d.findElement(By.xpath("//input [@name= 'txtUsername']"));
		WebElement f1= d.findElement(By.xpath("//input [@name= 'txtPassword']"));
		f.clear();
		f1.sendKeys("akash");
		d.findElement(By.xpath("//input [@name= 'Submit']")).click();
		WebElement f2=d.findElement(By.xpath("//span [text()= 'Username cannot be empty']"));
		AssertJUnit.assertTrue(f2.isDisplayed());
	}
	@Test(priority = 4)
	public void invalidCredintial() {
		WebElement f= d.findElement(By.xpath("//input [@name= 'txtUsername']"));
		WebElement f1= d.findElement(By.xpath("//input [@name= 'txtPassword']"));
		f.clear();
		f1.clear();
		f.sendKeys("akash");
		f1.sendKeys("akash");
		
		d.findElement(By.xpath("//input [@name= 'Submit']")).click();
		WebElement f2=d.findElement(By.xpath("//span [text()= 'Invalid credentials']"));
		AssertJUnit.assertTrue(f2.isDisplayed());
		
	}

}
