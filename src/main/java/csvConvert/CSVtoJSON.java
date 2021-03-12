package csvConvert;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.apache.commons.io.FilenameUtils;
import org.simpleflatmapper.csv.CsvParser;
import org.simpleflatmapper.lightningcsv.CloseableCsvReader;
import searchingFile.FindFilesName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CSVtoJSON {

    private static String filePath;
    private static FileWriter fileWriter;
    private static List<String> filePaths;
    private static int numofFiles;

    public static void getCSVPath() throws IOException {
        FindFilesName findFilesName = new FindFilesName();
        filePaths = findFilesName.sendLocation();
        numofFiles = filePaths.size();
        String oldFileName;
        String newFileName;

        for (int i=0; i<numofFiles; i++){
            filePath = filePaths.get(i);
            oldFileName = filePath.substring(filePath.lastIndexOf("\\")+1);
            newFileName = FilenameUtils.removeExtension(oldFileName).concat(".json");
            CSVtoJSON.convertCSV(filePath,newFileName);
        }
    }

    public static void convertCSV(String path, String fileName) throws IOException {
        File input = new File(path);
        CloseableCsvReader reader = CsvParser.reader(input);

        JsonFactory jsonFactory = new JsonFactory();

        Iterator<String[]> iterator = reader.iterator();
        String[] headers = iterator.next();

        try (JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File(fileName),
                JsonEncoding.UTF8)) {

            jsonGenerator.writeStartArray();

            while (iterator.hasNext()) {
                jsonGenerator.writeStartObject();
                String[] values = iterator.next();
                int nbCells = Math.min(values.length, headers.length);
                for(int i = 0; i < nbCells; i++) {
                    jsonGenerator.writeFieldName(headers[i]);
                    jsonGenerator.writeString(values[i]);
                }
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
        }
    }
}
