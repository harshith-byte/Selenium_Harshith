package mine_Day_3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class inueron {

	public static void main(String[] args) {
		// TODO Auto-generated method 

		WebDriver driver = new ChromeDriver();

		driver.get("https://ineuron-courses.vercel.app/login");
		
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("ineuron@ineuron.ai");

		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("ineuron");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Actions act=new Actions(driver);
		WebElement move=driver.findElement(By.xpath("//span[text()='Manage']"));
		act.moveToElement(move).perform();
		
	
		driver.findElement(By.xpath("//span[text()='Manage Categories']")).click();
		

		List<String> pages=new ArrayList<String>(driver.getWindowHandles());
		
		String mainpage=pages.get(0);
		String ManageCategoryPage = pages.get(1);
		
		driver.switchTo().window(ManageCategoryPage);
		
		
		driver.findElement(By.xpath("//button[text()='Add New Category ']")).click();
		
		Alert alt = driver.switchTo().alert();
		alt.sendKeys("cricket");
		alt.accept();
		
		//driver.switchTo().window(ManageCategoryPage);
		String category="cricket";
		
		driver.findElement(By.xpath("//*[contains(text(),'cricket')]//following::button[1]")).click();
	
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		
		List<WebElement> cat=driver.findElements(By.xpath("//td[text()='"+category+"']"));
		
		System.out.println(cat.size());
			
			
		
		
	}

}


