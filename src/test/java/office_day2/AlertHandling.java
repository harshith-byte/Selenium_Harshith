package office_day2;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertHandling {
@Test
//	public static void main(String[] args) throws InterruptedException {
	public void test5() throws InterruptedException {
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		
//		ChromeDriver driver = new ChromeDriver();        
//        driver.manage().window().maximize();
        d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        d.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        
        d.get("http://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
        Assert.assertTrue(d.getCurrentUrl().contains("blogspot"));
        
        d.findElement(By.xpath("//button[text()='Try it']")).click();
        
        WebElement e=null;
        for(int i=0;i<20;i++) {
            try {
                
                e.findElement(By.xpath("//p[text()='WebDriver']"));
            }catch(NoSuchElementException ee) {
                System.out.println("Waiting for webElement");
                Thread.sleep(1000);
            }
        }
        if(e.isDisplayed()) {
            System.out.println("Element found");
            
        }
        else {
            System.out.println("Not found");
        }
        
        
		

	}

}
