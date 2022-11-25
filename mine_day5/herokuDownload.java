package mine_day5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class herokuDownload {
	
	WebDriver d;
	ChromeOptions options =new ChromeOptions();
	@BeforeMethod
	public void setup() {
		d= new ChromeDriver();
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
	}
	
	@AfterMethod
	public void teardown() {

		d.quit();
	}
	
	@Test
	public void test() throws IOException, InterruptedException {
		
		d.get("https://the-internet.herokuapp.com/");
		options.addArguments("start-maximize");
		d.findElement(By.xpath("//li//a[text()='File Download']")).click();
		Map<String,Object> preps=new HashMap<String,Object>();
		preps.put("download.default_directory", "C:/Users/harr7/down");
		options.setExperimentalOption("preps", preps);
		d.findElement(By.xpath("")).click();
		
		long count;
		try (Stream<Path> files = Files.list(Paths.get("C:/Users/harr7/down"))) {
		    count = files.count();
		}
		
		
//		int f=new File(<path>).list().length;
		
		d.findElement(By.xpath("//a[text()='DateTime.txt']")).click();
		Thread.sleep(2000);
		long count1;
		try (Stream<Path> files = Files.list(Paths.get(""))) {
		    count1 = files.count();
		}
		
		if(count1>count) {
			System.out.println("file created");
		}
		
		File f=new File("DateTime.txt");
		if(f.delete()) {
			System.out.println("file deleted");
		}
		else {
			System.out.println("file not deleted");
		}
	}
	
}
