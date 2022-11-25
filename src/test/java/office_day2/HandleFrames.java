package office_day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HandleFrames {

	WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Parameters("browser")
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	@Parameters("browser")
	@Test
	public void iframe() {
		
		
		driver.manage().window().maximize();
		


		
		// Using index
		//driver.switchTo().frame(0);
		
		// Using name or id
		//driver.switchTo().frame("");
		
		// using WebElement
		WebElement child_frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	
		driver.switchTo().frame(child_frame);
		
		WebElement src=driver.findElement(By.id("draggable"));

		WebElement destination=driver.findElement(By.id("droppable"));

		Actions act=new Actions(driver);
		
		act.dragAndDrop(src, destination).perform();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("jqueryui"));
		
		
	}

}
