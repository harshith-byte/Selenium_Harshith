package mine_Day_2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAutoSuggestions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");

		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Mukesh Otwani");
		
		Thread.sleep(2000);
		
		List<WebElement> elements= driver.findElements(By.xpath("//div[@role='option']"));
		
		for(WebElement ele:elements) {
			String str= ele.getText();
			System.out.println(str);
			
			if(str.contains("github")) {
				ele.click();
			}
		}
	}

}
