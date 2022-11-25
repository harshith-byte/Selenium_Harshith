package office_day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAutoSuggestion {
//	public static void main(String[] args) throws InterruptedException {
	@Test
	public void test7() throws InterruptedException {
		
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://google.com");
		Assert.assertTrue(d.getCurrentUrl().contains("google"));
		d.findElement(By.name("q")).sendKeys("Mukesh Otwani");
		
		Thread.sleep(3000);
		 List<WebElement> allElements= d.findElements(By.xpath("//div[@role= 'option']"));
		  for(WebElement ele: allElements)
		  {
			  String str = ele.getText();
			  System.out.println(str);
			  if(str.contains("github")) {
				  ele.click();
				  break;
			  }
		  }
		
	}

}
