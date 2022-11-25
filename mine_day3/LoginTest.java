package mine_day3;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver d;
	
	@Test
	public void verifyUrl() {
		
		AssertJUnit.assertTrue(d.getCurrentUrl().contains("index.php"));
	}
	@Test
	public void verifyTitle() {
		AssertJUnit.assertTrue(d.getTitle().contains("OrangeHRM"));
	}
	@Test
	public void verifySocialMediaCount() {
		AssertJUnit.assertEquals(d.findElements(By.xpath("//div [@id ='social-icons']//img")).size(), 4);
	}
	@Test
	public void verifyForgetPassword() {
		WebElement f= d.findElement(By.linkText("Forgot your password?"));
		AssertJUnit.assertTrue(f.isDisplayed());
	}
	@BeforeMethod
	public void setup() {
		d= new ChromeDriver();
		d.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
	}
	@AfterMethod
	public void teardown() {
		d.quit();
	}
}
