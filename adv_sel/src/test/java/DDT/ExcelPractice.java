package DDT;
	import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelPractice {

	    public static void main(String[] args) {
	        String filePath = "./testData/testData.xlsx"; // path to your Excel file

	        try {
	            FileInputStream fis = new FileInputStream(filePath);
	            Workbook workbook = new XSSFWorkbook(fis);
	            Sheet sheet = workbook.getSheetAt(1); // read first sheet

	            int rows = sheet.getPhysicalNumberOfRows();
	            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

	            for (int i = 0; i < rows; i++) {
	                Row row = sheet.getRow(i);
	                for (int j = 0; j < cols; j++) {
	                    Cell cell = row.getCell(j);

	                    switch (cell.getCellType()) {
	                        case STRING:
	                            System.out.print(cell.getStringCellValue() + "\t");
	                            break;
	                        case NUMERIC:
	                            System.out.print(cell.getNumericCellValue() + "\t");
	                            break;
	                        default:
	                            System.out.print(" \t");
	                    }
	                }
	                System.out.println();
	            }

	            workbook.close();
	            fis.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



