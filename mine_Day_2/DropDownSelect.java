package mine_Day_2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownSelect {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		
		driver.findElement(By.xpath("//a[text()='JavaScript']")).click();
		
		Thread.sleep(1000);
		
		driver.close();
		
		
		ChromeDriver driver1 = new ChromeDriver();

		driver1.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver1.findElement(By.xpath("//button[@type='button']")).click();
		
		List<WebElement> elements=driver1.findElements(By.xpath("//li[@role='presentation']//a"));
		
		for(WebElement ele:elements) {
			String str= ele.getText();
			System.out.println(str);
			
			if(str.contains("CSS")) {
				ele.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver1.close();
		
	}

}
