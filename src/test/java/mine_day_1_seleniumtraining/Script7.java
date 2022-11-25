package mine_day_1_seleniumtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Script7 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Harshith");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("R");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("harshithr929@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("harshithr929@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Harshith@123");
		WebElement date = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select date1 = new Select(date);
		date1.selectByValue("22");
		
		WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select month1=new Select(month);
		month1.selectByVisibleText("Jan");
		
		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select year1=new Select(year);
		year1.selectByVisibleText("2000");
		
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
	}

}
