package scriptUtil;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelReader {

        public static String getColumnVal(String ColumnName) throws IOException {
            String CellVal="";
            File file1 = new File("D:\\Selenium\\TestProject\\src\\main\\resources\\TestData2.xlsx");
            FileInputStream file = new FileInputStream(file1);

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int noOfColumns = sheet.getRow(0).getLastCellNum();
            //System.out.println(noOfColumns);
            String[] Headers = new String[noOfColumns];
            for (int j=0;j<noOfColumns;j++){
                Headers[j] = sheet.getRow(0).getCell(j).getStringCellValue();
            }
            for (int a=0;a<noOfColumns;a++){
                if(Headers[a].equals(ColumnName)){
                    CellVal =sheet.getRow(1).getCell(a).getStringCellValue();
                    return CellVal;

                }
                break;
            }


            return CellVal;
        }

}
