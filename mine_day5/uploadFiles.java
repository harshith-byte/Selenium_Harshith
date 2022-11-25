package mine_day5;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class uploadFiles {

	@Test
	public void test() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/upload");
		
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(By.id("file-upload"))).click().perform();
		
		Thread.sleep(1000);
	
		Runtime.getRuntime().exec("C:\\Users\\harr7\\Desktop\\script.exe");
	
		driver.findElement(By.id("file-submit")).click();
	}
	
}
