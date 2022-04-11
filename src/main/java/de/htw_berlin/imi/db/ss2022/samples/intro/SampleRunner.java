package de.htw_berlin.imi.db.ss2022.samples.intro;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.sql.SQLException;

public class SampleRunner {

    private static final String FILE_NAME = "studierende.csv";
    private static final String EXCEL_FILE_NAME = "studierende.xlsx";

    private static final String SERVER_NAME = "localhost";
    private static final String DB_NAME = "uni-sample";
    private static final String TABLE_NAME = "uni.studierende";
    private static final String PASSWORD = "postgres";
    private static final String USER_NAME = "postgres";

    private static final String JDBC_CONNECTION_STRING =
            "jdbc:postgresql" + "://" + SERVER_NAME + "/" + DB_NAME + "?user=" + USER_NAME + "&password=" + PASSWORD + "&ssl=false";

    public static void main(final String[] args) throws IOException, SQLException, CsvException {
        FileReader.readFromFile(FILE_NAME);
        CsvReader.readFromFile(FILE_NAME);
//        DatabaseReader.countRecords(JDBC_CONNECTION_STRING, TABLE_NAME);
        ExcelReader.readFromFile(EXCEL_FILE_NAME);

    }
}
