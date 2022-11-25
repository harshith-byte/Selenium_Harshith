package mine_day5;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectorhubPracticePage {

	
	@Test
	public void test() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
	
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.cssSelector("#userName"));
		
		SearchContext shadow=ele.getShadowRoot();
		shadow.findElement(By.cssSelector(null));
		
	}
}
