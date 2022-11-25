package mine_day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingExcel3 {

	@Test
	public void testData() {
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
		
		
		
		
	}catch(IOException e) {
	
		e.printStackTrace();

	}
	}
}
