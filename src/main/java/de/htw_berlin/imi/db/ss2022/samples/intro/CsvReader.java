package de.htw_berlin.imi.db.ss2022.samples.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class CsvReader {

    static void readFromFile(final String fileName) throws IOException, CsvException {
        final ClassLoader classLoader = CsvReader.class.getClassLoader();
        try (final InputStream in = classLoader.getResourceAsStream(fileName)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            CsvToBean<CsvStudenten> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CsvStudenten.class)
                    .withSeparator(';')
                    .withSkipLines(1)
                    .build();

            Iterator<CsvStudenten> myUserIterator = csvToBean.iterator();

            double sum = 0;
            int numberOfLines = 0;

            while (myUserIterator.hasNext()) {
                CsvStudenten myUser = myUserIterator.next();
                sum += myUser.getAnzahl_semester();

                System.out.println("Anzahl Semeseter : " + myUser.getAnzahl_semester());
                System.out.println("---------------------------");
                numberOfLines++;
            }
            CSVReader csvReader = new CSVReader(reader);
            final List<String[]> linesAndColumns = csvReader.readAll();
            System.out.println("Csv read, average: " + sum / numberOfLines + ", " + numberOfLines + " lines.");
        }
    }
}










//    static void readFromFile(final String fileName) throws IOException {
//        final ClassLoader classLoader = CsvReader.class.getClassLoader();
//        try (final InputStream in = classLoader.getResourceAsStream(fileName)) {
////            final List<String[]> linesAndColumns =  ; // ...
//            double sum = 0;
//            final int numberOfLines = 0;
////            average(in);
//            System.out.println("Csv read, average: " + sum / numberOfLines + ", " + numberOfLines + " lines.");
//        }
//    }


//    private static String average(final InputStream inputStream) throws IOException {
//        CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
//        final List<String[]> linesAndColumns = reader.readAll();
//        String[] cells;
//
//        for (String[] rows : linesAndColumns) {
//            for (String row : rows) {
//                cells = row.split(";");
//                System.out.println(row);
////                for(String cell : cells){
////
////                }
//            }
//        }
//
//        return "";
//  }



