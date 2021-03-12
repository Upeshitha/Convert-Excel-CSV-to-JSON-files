package excelConvert;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import home.Main;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FilenameUtils;
import searchingFile.FindFilesName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExceltoJSON {

    private static String filePath;
    private static FileWriter fileWriter;
    private static List<String> filePaths;
    private static int numofFiles;

    public static void getFilePath(){
        FindFilesName findFilesName = new FindFilesName();
        filePaths = findFilesName.sendLocation();
        numofFiles = filePaths.size();
        String oldFileName;
        String newFileName;

        for (int i=0; i<numofFiles; i++){
            filePath = filePaths.get(i);
            oldFileName = filePath.substring(filePath.lastIndexOf("\\")+1);
            newFileName = FilenameUtils.removeExtension(oldFileName).concat(".json");
            JsonObject object = getExcelDataAsJsonObject(new File(filePath));
            writeObjects2JsonFile(object,newFileName);
        }
        System.out.println("Successfully converted");
    }

    public static JsonObject getExcelDataAsJsonObject(File excelFile) {

        JsonObject sheetsJsonObject = new JsonObject();
        Workbook workbook = null;


        try {
            workbook = new XSSFWorkbook(excelFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

            JsonArray sheetArray = new JsonArray();
            ArrayList<String> columnNames = new ArrayList<String>();
            Sheet sheet = workbook.getSheetAt(i);
            Iterator<Row> sheetIterator = sheet.iterator();

            while (sheetIterator.hasNext()) {

                Row currentRow = sheetIterator.next();
                JsonObject jsonObject = new JsonObject();

                if (currentRow.getRowNum() != 0) {

                    for (int j = 0; j < columnNames.size(); j++) {

                        if (currentRow.getCell(j) != null) {
                            if (currentRow.getCell(j).getCellTypeEnum() == CellType.STRING) {
                                jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getStringCellValue());
                            } else if (currentRow.getCell(j).getCellTypeEnum() == CellType.NUMERIC) {
                                jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getNumericCellValue());
                            } else if (currentRow.getCell(j).getCellTypeEnum() == CellType.BOOLEAN) {
                                jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getBooleanCellValue());
                            } else if (currentRow.getCell(j).getCellTypeEnum() == CellType.BLANK) {
                                jsonObject.addProperty(columnNames.get(j), "");
                            }
                        } else {
                            jsonObject.addProperty(columnNames.get(j), "");
                        }

                    }

                    sheetArray.add(jsonObject);

                } else {
                    // store column names
                    for (int k = 0; k < currentRow.getPhysicalNumberOfCells(); k++) {
                        columnNames.add(currentRow.getCell(k).getStringCellValue());
                    }
                }

            }

            sheetsJsonObject.add(workbook.getSheetName(i), sheetArray);

        }

        return sheetsJsonObject;

    }

    private static void writeObjects2JsonFile(JsonObject customers, String pathFile){
        try {
            fileWriter = new FileWriter(pathFile);
            fileWriter.write(String.valueOf(customers));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
