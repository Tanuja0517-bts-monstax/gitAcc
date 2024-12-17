package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Reading_WritingDataFromExcelFile {
	public Workbook wb;
	Sheet sh;
	Row rw;
	Cell cell;
	FileInputStream fis=null;
	
	public String readingDataFromExcelFile(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		fis=new FileInputStream("./src/test/resources/TestCaseData.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet(sheetName);
		return sh.getRow(row).getCell(cell).toString();
	}
	
	public int getTotalNumberOfRows() {
		return sh.getPhysicalNumberOfRows();
	}
	
	public int getTotalNumberOfColumns() {
		return sh.getRow(1).getPhysicalNumberOfCells();
	}
	
	public void writeDataInExcelSheet(String sheetName,int rowNo,int cellNo,String value) throws Exception, IOException {
		fis=new FileInputStream("./src/test/resources/TestCaseData.xlsx");
		wb=WorkbookFactory.create(fis);
		cell=wb.getSheet(sheetName).getRow(rowNo).createCell(cellNo);
		cell.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/TestCaseData.xlsx");
		wb.write(fos);
		fos.flush();
		wb.close();
	}
}
