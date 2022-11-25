package mine_day_1_seleniumtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script6 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		/*
		Options opt= driver.manage();
	
		Window win=opt.window();
	
		win.maximize();
		*/
		
		driver.get("https://ineuron-courses.vercel.app/login");
		
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		
		WebElement email=driver.findElement(By.id("email1"));
		
		System.out.println(email.isDisplayed());
		System.out.println(email.isEnabled());
		System.out.println(email.getAttribute("placeholder"));
		System.out.println(email.getTagName());
		System.out.println(email.getCssValue("font-size"));
		
		
	}

}
