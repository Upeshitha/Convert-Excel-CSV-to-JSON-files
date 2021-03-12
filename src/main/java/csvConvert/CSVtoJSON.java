package csvConvert;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.simpleflatmapper.csv.CsvParser;
import org.simpleflatmapper.lightningcsv.CloseableCsvReader;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class CSVtoJSON {

    public static void main(String[] args) throws IOException {
        File input = new File("E:\\User\\Downloads\\customers-1.csv");
        CloseableCsvReader reader = CsvParser.reader(input);

        JsonFactory jsonFactory = new JsonFactory();

        Iterator<String[]> iterator = reader.iterator();
        String[] headers = iterator.next();

        try (JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File("output.json"), JsonEncoding.UTF8)) {

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
