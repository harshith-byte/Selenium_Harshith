package mine_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Facebook {
@Test
//	public static void main(String[] args) throws InterruptedException {
public void xtest() throws InterruptedException {
		ChromeDriver d= new ChromeDriver();
		d.get("https://www.facebook.com/");
		Assert.assertTrue(d.getCurrentUrl().contains("facebook"));
		d.findElement(By.xpath("//a[text() = 'Create New Account']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@placeholder= 'First name']")).sendKeys("Akash");
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@name= 'lastname']")).sendKeys("Udaykumar");
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@name= 'reg_email__']")).sendKeys("9632807430");
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@name= 'reg_passwd--']")).sendKeys("akash2000");
//		Assert.
	}

}
