package office_day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Calender {
@Test
//	public static void main(String[] args) throws InterruptedException {
	public void test6() throws InterruptedException {
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		d.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		   Assert.assertTrue(d.getCurrentUrl().contains("blogspot"));
		d.findElement(By.xpath("//input [@id= 'datepicker']")).click();
		Thread.sleep(1000);
//		d.findElement(By.xpath("//a [text()= '25']")).click();
		List<WebElement> allElements= d.findElements(By.xpath("//table[contains(@class, 'calendar')]//a"));
		  for(WebElement ele: allElements)
		  {
			  String str = ele.getText();
			  System.out.println(str);
			  if(str.contains("25")) {
				  ele.click();
				  break;
			  }
		  }
		
		

	}

}
