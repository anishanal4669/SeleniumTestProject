package scriptUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public void readData(String FilePath, String SheetName) throws IOException {
    FileInputStream FIS = null;
    try{
        FIS = new FileInputStream(new File(FilePath));
        System.out.println("File Found");
    }
    catch(Exception e){
        System.out.println("File Not Found");
        e.printStackTrace();
    }
    XSSFWorkbook wb = new XSSFWorkbook(FIS);
        XSSFSheet sh = wb.getSheet(SheetName);

        int rownum = sh.getLastRowNum();
        int colNum = sh.getRow(0).getLastCellNum();
        String[][] Data = new String [rownum][colNum];
        for(int i=0; i<rownum; i++){
            XSSFRow row = sh.getRow(i);
            for(int j=0; j<colNum; j++){
                XSSFCell Col = row.getCell(j);
                String value = Col.getStringCellValue();
                Data[i][j] = value;
            }
        }
        for(int i=0;i<rownum;i++)
        {
            for(int j=0;j<colNum;j++)
                System.out.println(Data[i][j]);

        }
        }

}