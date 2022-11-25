package office_day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HandleMultipleWindow2 {


	WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
		
		
	@Parameters("browser")
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	@Parameters("browser")
	@Test
	public void orangehrm() {

		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		
		String parent=driver.getWindowHandle();
		
		System.out.println("parent window handle is "+parent);
		
		List<WebElement> allSocialMediaLinks=driver.findElements(By.xpath("//div[@id='social-icons']//img"));
		
		for(WebElement ele:allSocialMediaLinks)
		{
			ele.click();
		}
		
		Set<String> allWindows=driver.getWindowHandles();
		
		List<String> socialMediaList=new ArrayList<String>(allWindows);
		
		String first=socialMediaList.get(0);
		
		String second=socialMediaList.get(1);
		
		String third=socialMediaList.get(2);
		
		String fourth=socialMediaList.get(3);
		
		
		driver.switchTo().window(third);
		System.out.println("Title is "+driver.getTitle());	
		
		driver.switchTo().window(parent);
	
		System.out.println("Title is "+driver.getTitle());
		
		driver.switchTo().window(fourth);
		
		System.out.println("Title is "+driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(),"OrangeHRM Inc");

	}

}
