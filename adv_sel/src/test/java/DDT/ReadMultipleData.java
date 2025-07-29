package DDT;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\heman\\OneDrive\\Desktop\\ddt\\ddt_excel.xlsx");
		Workbook ws = WorkbookFactory.create(fis);
		Sheet sh = ws.getSheet("Sheet1");
		int lastdata = sh.getLastRowNum();
		for(int i=0;i<=lastdata;i++)
		{
		Row rw = sh.getRow(i);
		String cel1 = rw.getCell(0).toString();
		String cel2 = rw.getCell(1).toString();
		
		System.out.println(cel1);
		System.out.println(cel2);
		
		}
		ws.close();
		
		
		
	}

}
