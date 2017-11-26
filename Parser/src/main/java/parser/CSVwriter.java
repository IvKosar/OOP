package parser;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVwriter {
    public static void csvWrite(ArrayList<String[]> sentiments, String url) throws IOException {
        if (sentiments.size() != 0) {
            String filename = "data/" + url.split("/")[4] + ".csv";
            FileWriter writer = new FileWriter(filename);
            CSVWriter csvwriter = new CSVWriter(writer, ',');
            for (String[] sentiment : sentiments) {
                csvwriter.writeNext(sentiment);
            }
            csvwriter.close();
        }
        System.out.println(sentiments.size() + " reviews from " + url);
    }
}
