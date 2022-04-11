package de.htw_berlin.imi.db.ss2022.samples.intro;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.List;

public class CsvReader<semesterColumnIndex> {
    private static final int semesterColumnIndex = 5;

    static void readFromFile(final String fileName) throws IOException {
        final ClassLoader classLoader = CsvReader.class.getClassLoader();
        try (final InputStream in = classLoader.getResourceAsStream(fileName)) {
//            final List<String[]> linesAndColumns =  ; // ...
            double sum = 0;
            final int numberOfLines = 0;
            semester(in);
            System.out.println("Csv read, average: " + sum / numberOfLines + ", " + numberOfLines + " lines.");
        }
    }


    private static String semester(final InputStream inputStream) throws IOException {
        CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
        final List<String[]> linesAndColumns = reader.readAll();
        String[] cell;

        for (String[] rows : linesAndColumns) {
            for (String row : rows) {
                cell = row.split(";");
            }
        }

        return "";
    }
}

//        while (linesAndColumns.iterator().hasNext()) {
//
//        }


//    static void readFromFile(final String fileName) throws IOException {
//        final ClassLoader classLoader = FileReader.class.getClassLoader();
//        try (final InputStream in = classLoader.getResourceAsStream(fileName)) {
//            double sum = 0;
//            int numberOfLines = readLines(in) - 1;
//            System.out.println("Csv read, average: " + sum / numberOfLines + ", " + numberOfLines + " lines.");
//        }
//    }
//
//    private static int readLines(final InputStream inputStream) throws IOException {
//        try (final InputStreamReader reader = new InputStreamReader(inputStream)) {
//            final LineNumberReader lineNumberReader = new LineNumberReader(reader);
//            int lines = 0;
//            String line = lineNumberReader.readLine();
//            while (line != null) {
//                line = lineNumberReader.readLine();
//                lines++;
//            }
//            return lines;
//        }
//    }
