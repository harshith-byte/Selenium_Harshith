package mine_day_1_seleniumtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Script3 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		
		WebElement username =  driver.findElement(By.name("email1"));
		username.sendKeys("SapientTraining@gmail.com");
		
		WebElement password = driver.findElement(By.name("password1"));
		password.sendKeys("Abcd@1234");
		
		driver.findElement(By.className("submit-btn")).click();
		
//		WebElement Xpath=
		Thread.sleep(9000);
		System.out.println("driver 1");
		driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();

		System.out.println("driver 2");
	}

}
