//package de.htw_berlin.imi.db.ss2022.samples.intro;
//
//import java.sql.*;
//
//public class DatabaseReader {
//
//    static void countRecords(final String jdbcConnectionString, final String tableName) throws SQLException {
//        final Connection conn = DriverManager.getConnection(jdbcConnectionString);
//        final Statement statement = conn.createStatement();
//        statement.execute("SELECT count(*), avg(anzahl_semester) FROM " + tableName);
//        final ResultSet resultSet = statement.getResultSet();
//        resultSet.next();
//        final int lines = resultSet.getInt(1);
//        final double average = resultSet.getDouble(2);
//        System.out.println("DB read, average: " + average + ", " + lines + " lines.");
//    }
//}
