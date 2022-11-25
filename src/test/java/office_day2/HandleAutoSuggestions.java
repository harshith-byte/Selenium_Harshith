package office_day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HandleAutoSuggestions {

	WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Parameters("browser")
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
		

	@Parameters("browser")
	@Test
	public void autosuggestion() {
	
		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys("any text");

		
		List<WebElement> allElements= driver.findElements(By.xpath("//div[@role='option']"));
		
		
		for(WebElement ele:allElements)
		{
			String str=ele.getText();
			System.out.println(str);
			
			if(str.contains("english"))
			{
				ele.click();
				Assert.assertTrue(str.contains("english"));
				break;
			}
			
		}
		
		
		
	}

}
