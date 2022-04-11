package de.htw_berlin.imi.db.ss2022.samples.intro;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class FileReader {

    public static final int BUF_SIZE = 256;
    public static final int NUMBER_OF_HEADER_LINES = 1;
    public static final char LINE_BREAK_CHAR = '\n';

    static void readFromFile(final String fileName) throws IOException {
        final ClassLoader classLoader = FileReader.class.getClassLoader();
        try (final InputStream in = classLoader.getResourceAsStream(fileName)) {
            final int numberOfLines = readBytes(in) - NUMBER_OF_HEADER_LINES;
            System.out.println("byte read:\t" + numberOfLines + " lines.");
        }
        try (final InputStream in = classLoader.getResourceAsStream(fileName)) {
            final int numberOfLines = readLines(in) - NUMBER_OF_HEADER_LINES;
            System.out.println("line read:\t" + numberOfLines + " lines.");
        }
    }

    private static int readLines(final InputStream inputStream) throws IOException {
        try (final InputStreamReader reader = new InputStreamReader(inputStream)) {
            final LineNumberReader lineNumberReader = new LineNumberReader(reader);
            int count = 0;
            String line = lineNumberReader.readLine();

            double totalSem = 0;

            while (line != null) {
                //my Code
                String[] semester = line.split(";");

                if(count == 0){ //leave empty to ignore first line

                } else{
                    System.out.println("Semesters are: " + semester[5]);
                    System.out.println("Zeile: " + count);
                    totalSem += Double.parseDouble(semester[5]);
                }
                line = lineNumberReader.readLine();
                count++;

            }
            double average = totalSem/(count-1);
            System.out.println("Der durchschnitt der Anzahl der Semester lautet: " + average);

            return count;
        }
    }

    private static int readBytes(final InputStream inputStream) throws IOException {
        int count = 1;
        final byte[] buf = new byte[BUF_SIZE];
        int read = inputStream.read(buf);
        while (read > -1) {
            int bufLineCounter = 0;
            for (int i = 0; i < read; i++) {
                if (buf[i] == LINE_BREAK_CHAR) {
                    bufLineCounter++;
                }
            }
            count += bufLineCounter;
            read = inputStream.read(buf);
        }
        return count;
    }
}











//      try (final InputStream in = classLoader.getResourceAsStream(fileName)) {
//            final double averageSemester = countAverageSemester(in);
//            System.out.println("average Semester:\t" + averageSemester + " Semesters.");
//        }

//    private static int readLines(final InputStream inputStream) throws IOException {
//        try (final InputStreamReader reader = new InputStreamReader(inputStream)) {
//            final LineNumberReader lineNumberReader = new LineNumberReader(reader);
//            int count = 0;
//            String line;
//
//            while ((line = lineNumberReader.readLine()) != null) {
//                count++;
//            }
//            return count;
//        }
//    }


//    private static double countAverageSemester(final InputStream inputStream) throws IOException {
//        try (final InputStreamReader reader = new InputStreamReader(inputStream)) {
//            final LineNumberReader lineNumberReader = new LineNumberReader(reader);
//            int count = 0;
//
//            double average = 0;
//            String line;
//            String[] columns; // split the column and put it in an array
//
//            while ((line = lineNumberReader.readLine()) != null) {
//                count++;
//                columns = line.split(";"); // split the string
//                if(count > 1){
//                    int currentSemester = Integer.parseInt(columns[5]); // take the 6th column and change it into integer
//                    countSemester += currentSemester;
//                    countStudent++;
//                }
//            }
//            average = countSemester / countStudent;
//            return average;
//        }
//    }