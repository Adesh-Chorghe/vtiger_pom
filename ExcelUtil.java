package commonutils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
public String getDataFromExcel(String Sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
	
	 FileInputStream file=new FileInputStream("src\\test\\resources\\Data.xlsx");
     Workbook workbook	=WorkbookFactory.create(file);
     Sheet sheetno = workbook.getSheet(Sheetname);  //sheet1 is excel sheet number
     Row row = sheetno.getRow(rownum);
     Cell cell = row.getCell(cellnum);
     String data = cell.getStringCellValue();
     return data;
}

}
