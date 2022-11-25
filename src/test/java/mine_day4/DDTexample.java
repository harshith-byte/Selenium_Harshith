package mine_day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTexample {

	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.out.println("Running Before Method- Creating Browser Session");
		driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();

	}
	
	@Test(dataProvider = "emails")
	public void login(String username,String password) {
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//button [text()= 'Sign out']")).isDisplayed());
	    driver.findElement(By.xpath("//button [text()= 'Sign out']")).click();
	   
		
		
		
	}
	
	
	@DataProvider(name="test")
	public Object myTest() {
		Object arr[][]=new Object[4][2];
		
		arr[0][0]= "sample9@gmail.com";
		arr[0][1]= "Mukesh1234";
		
		arr[1][0]= "samplemukesh@gmail.com";
		arr[1][1]= "Mukesh1234";
		
		arr[2][0]= "samplemukesh1@gmail.com";
		arr[2][1]= "Mukesh1234";
		
		arr[3][0]= "samplemukesh2@gmail.com";
		arr[3][1]= "Mukesh1234";
		
		return arr;
		
	}

	@DataProvider(name="emails")
	public Object email() {
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File("./Test-data/emails.xlsx")));
			
			System.out.println(workbook.getSheet("sheet1").getRow(0).getCell(0).getStringCellValue());
			
			int row=workbook.getSheet("sheet1").getPhysicalNumberOfRows();
			int col=workbook.getSheet("sheet1").getRow(0).getPhysicalNumberOfCells();
			
			
			
			Object arr[][]=new Object[row][col];
			
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					arr[i][j]=workbook.getSheet("sheet1").getRow(i).getCell(j).getStringCellValue();
				}
			}
			
			
			
			return arr;
		}catch(IOException e) {
		
			e.printStackTrace();

		}
		String s="data was not picked by this method";
		return s;
		
	
	}
	
	
}
