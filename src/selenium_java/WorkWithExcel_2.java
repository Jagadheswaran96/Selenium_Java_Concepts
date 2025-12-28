package selenium_java;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WorkWithExcel_2 {

	public String excelLogin(String sheetName, int rowValue, int CellValue) throws EncryptedDocumentException, IOException {
		String data=null;	
		FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Jagadhez\\OneDrive\\Desktop\\Book.xlsx");
		Workbook workbook=WorkbookFactory.create(fileInputStream);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rowValue);
		Cell cell=row.getCell(CellValue);
		//returnValue=cell.getStringCellValue();
		//System.out.println(returnValue);
		if(cell.getCellType()==CellType.STRING) 
		    data = cell.getStringCellValue(); 
		else if(cell.getCellType()==CellType.NUMERIC) 
		   data = String.valueOf(cell.getNumericCellValue());
		System.out.println(cell);
		workbook.close();
		return data;
	}
	public static void main(String args[]) {
		WorkWithExcel_2 workWithExcel_2 = new WorkWithExcel_2();
		try {
			workWithExcel_2.excelLogin("Sheet1", 0, 1);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
