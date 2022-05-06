package com.itesm.financial;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PrintReport {
    // "CSV Filename"
    private static final String CSV_FILENAME = "taxi-data.csv";

    public static void buildReport() throws Exception {
        System.out.println("Financial Report Generation");
        List<Ride> result = new ArrayList<>(); //

        // "CSV Reader"
        // Chaining 
        InputStream inputStream = Client.class.getClassLoader().getResourceAsStream(CSV_FILENAME); //
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8); //
        BufferedReader reader = new BufferedReader(streamReader); //

        // "CSV Parser"
        for (String rawLine; (rawLine = reader.readLine()) != null;) {
            List<String> line = CSVUtils.parseLine(rawLine);
            Ride newRide = RidesParser.parseFromList(line);
            if(newRide != null) {
                result.add(newRide);
            }
        }

        // "HTML Reporter"
        WebReport webReport = new WebReport();
        String htmlReport = webReport.createContent(result);
        webReport.createFile(htmlReport);

        // "HTML Report in console"
        String htmlReportASCII = webReport.createContentASCII(result);
        System.out.println(htmlReportASCII);
    }
}
