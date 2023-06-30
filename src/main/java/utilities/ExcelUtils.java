package utilities;

import exceptions.ExcelFileReadException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtils {
    private ExcelUtils(){};

    private static List<Map<String,String>> list = new ArrayList<>();


    public static List<Map<String,String>> ReadExcelFile(String FilePath, String SheetName) {

        try ( FileInputStream ExcelFile = new FileInputStream(FilePath)){

            XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile);
            XSSFSheet sheet = workbook.getSheet(SheetName);
            int totalRow = sheet.getLastRowNum();
            int totalCol = sheet.getRow(0).getLastCellNum();

            list = new ArrayList<>();
            Map<String, String> map = null;

            for (int i = 1; i <= totalRow; i++) {
                    map = new HashMap<>();
                for (int j = 0; j < totalCol; j++) {
                    map.put(sheet.getRow(0).getCell(j).getStringCellValue(),//Map Keys from Header row=0
                            sheet.getRow(i).getCell(j).getStringCellValue());//Values from next rows
                }
                list.add(map);
            }

        } catch (IOException e) {
            throw new ExcelFileReadException("Unable to read Excel file");
        }

        return list;
    }

}
