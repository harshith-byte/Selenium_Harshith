package mine_Day_2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		driver.findElement(By.xpath("//input[contains(@id,'datepicker')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='25']")).click();
		
		Thread.sleep(1000);
		driver.close();
		
		ChromeDriver driver1 = new ChromeDriver();
		driver1.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		driver1.findElement(By.xpath("//input[contains(@id,'datepicker')]")).click();
		
		List<WebElement> date=driver1.findElements(By.xpath("//a[@class='ui-state-default']"));
		
		for(WebElement ele:date) {
			String str= ele.getText();
			System.out.println(str);
			
			if(str.contains("26")) {
				ele.click();
				break;
			}
		}
		
		
		
		
		
	}

}
