package mine_day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstSeleniumScript4 {

//	public static void main(String[] args) throws InterruptedException {
	@Test
	public void test3() throws InterruptedException {
		
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		Assert.assertTrue(driver.getCurrentUrl().contains("ineuron"));
		driver.findElement(By.linkText("New user? Signup")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Name')]")).sendKeys("Akash Udaykumar");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Email')]")).sendKeys("akash@gmail.com");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Password')]")).sendKeys("1234567890");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()= 'Selenium']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()= 'Male']")).click();
		
		WebElement stateDropdown= driver.findElement(By.id("state"));
		Select state= new Select(stateDropdown);
		state.selectByIndex(2);
		Thread.sleep(2000);
		state.selectByVisibleText("Goa");
		Thread.sleep(2000);
		state.selectByVisibleText("Karnataka");
		List<WebElement> allValues=state.getOptions();
		
		for(WebElement ele : allValues) {
			if(ele.getText().equalsIgnoreCase("Rajasthan")) {
				break;
			}
			System.out.println(ele.getText());
		}
		 driver.findElement(By.xpath("//button[text()='Sign up']")).click();
//		driver.findElement(By.xpath())
		
		
//		Thread.sleep(1000);
//		driver
//		stateDropdown= driver.findElement(By.)
		

	}

}
