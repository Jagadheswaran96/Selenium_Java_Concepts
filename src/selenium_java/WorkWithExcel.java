package selenium_java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WorkWithExcel {

	public static void main(String[] args) {
		
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\Jagadhez\\OneDrive\\Desktop\\Book.xlsx");
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheet("sheet1");
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			//String string = cell.getStringCellValue();
			if(cell.getCellType()==CellType.STRING) 
			    cell.getStringCellValue(); 
			else if(cell.getCellType()==CellType.NUMERIC) 
				String.valueOf(cell.getNumericCellValue());
			System.out.println(cell);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
