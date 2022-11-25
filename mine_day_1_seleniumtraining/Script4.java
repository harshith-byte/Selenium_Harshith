package mine_day_1_seleniumtraining;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Script4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//a[text()='New user? Signup']")).click();
	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("harshith");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("harshith@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Abcd@1234");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='selenium']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		
//		driver.findElement(By.xpath("//label[text()='Testing']")).click()		
		WebElement stateDropDown = driver.findElement(By.id("state"));
		Select state = new Select(stateDropDown);
		
		state.selectByIndex(2);
		Thread.sleep(2000);
		
		state.selectByVisibleText("Goa");
		
		Thread.sleep(2000);
		
		state.selectByValue("Rajasthan");
		
		List<WebElement> allvalues = state.getOptions();
		
		for(WebElement ele:allvalues) {
			if(ele.getText().equalsIgnoreCase("Rajasthan")) {
				break;
			}
			System.out.println(ele.getText());
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Sign up']")).click();
	}

}
