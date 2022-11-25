package mine_Day_2;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_handling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        
		driver.get("http://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		WebElement element=null;
		
		for(int i=0;i<20;i++) {
			try {
				Alert alt = driver.switchTo().alert();
				String msg=alt.getText();
				if(msg.contains("Selenium")) {
					alt.accept();	
					break;
				}
			}catch(NoAlertPresentException e) {
				System.out.println("Waiting for webElement");
				Thread.sleep(1000);
			}
		}

		if(element.isDisplayed()) {
			System.out.println("Element found");
			
			
		}
		else {
			System.out.println("Not found");
		}
		
	}

}
