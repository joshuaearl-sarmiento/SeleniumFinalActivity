package Resources;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class ExcelUtils {
    public static Object[][] readExcel(String filePath,String sheetName) throws IOException {
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/java/Data/FinalActivityData.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.getCell(j);
                data[i][j] = cell.toString();
            }
        }

        workbook.close();
        inputStream.close();
        return data;
    }

    public static HashMap<String, String> readExcelToHash(String filePath, String sheetName) throws IOException {
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/java/Data/FinalActivityData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sh = workbook.getSheet(sheetName);

        HashMap<String, String> map
                = new HashMap<String, String>();

        for (int r = 0; r <= sh.getLastRowNum(); r++) {
            int key = (int)sh.getRow(r)
                    .getCell(0)
                    .getNumericCellValue();
            String value = sh.getRow(r)
                    .getCell(1)
                    .getStringCellValue();
            map.put(String.valueOf(key), value);
        }

        workbook.close();
        inputStream.close();
        return map;
    }



}
