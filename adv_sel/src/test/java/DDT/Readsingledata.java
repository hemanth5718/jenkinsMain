package DDT;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readsingledata {

	public static void main(String[] args) throws Throwable  {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\heman\\OneDrive\\Desktop\\ddt\\ddt_excel.xlsx");
	  Workbook wb = WorkbookFactory.create(fis);
	  Sheet sh = wb.getSheet("Sheet1"); 
	  Row rw = sh.getRow(1);
	 Cell cel = rw.getCell(1);
	 String data = cel.getStringCellValue();
	 System.out.println(data);
	 wb.close();
		

	}

}
