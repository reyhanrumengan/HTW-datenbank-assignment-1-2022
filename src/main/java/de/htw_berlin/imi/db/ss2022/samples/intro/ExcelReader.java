package de.htw_berlin.imi.db.ss2022.samples.intro;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.util.CellReference;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;


public class ExcelReader {
    public static final int SEMESTER_COLUMN_INDEX = 5;

    public static void readFromFile(final String fileName) throws IOException {
        final ClassLoader classLoader = ExcelReader.class.getClassLoader();
        try (final InputStream in = classLoader.getResourceAsStream(fileName)) {

            double sum = 0;
            int lines = 0;
            double average = 0;

            Iterator<Row> rowIterator = getRowIterator(in);

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if(row.getRowNum() != 0){
                    Iterator<Cell> cellIterator = row.cellIterator();

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();

                        if(cell.getColumnIndex() == SEMESTER_COLUMN_INDEX){
                            double currentSemester = cell.getNumericCellValue();

                            sum += currentSemester;
                            lines++;
                        }
                        average = sum / lines;
                    }
                }
            }

            System.out.println("Excel read, average: " + average + ", " + lines + " lines");

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    private static Iterator<Row> getRowIterator(final InputStream in) throws InvalidFormatException, IOException {
        final OPCPackage opcPackage = OPCPackage.open(in);
        final XSSFWorkbook wb = XSSFWorkbookFactory.createWorkbook(opcPackage);
        final Sheet sh = wb.getSheetAt(wb.getActiveSheetIndex());
        final Iterator<Row> rowIterator = sh.rowIterator();

        return rowIterator;
    }
}












//            File excelFile = new File(classLoader);
//            Workbook workBook = WorkbookFactory.create(excelFile);
//            Sheet sheet = workBook.getSheet("studierende");
//            DataFormatter formatter = new DataFormatter();



//    DataFormatter formatter = new DataFormatter();
//    Sheet sheet1 = wb.getSheetAt(0);
//        for (Row row : sheet1) {
//            for (Cell cell : row) {
//                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
//                System.out.print(cellRef.formatAsString());
//                System.out.print(" - ");
//
//                // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
//                String text = formatter.formatCellValue(cell);
//                System.out.println(text);
//
//                // Alternatively, get the value and format it yourself
//                switch (cell.getCellType()) {
//                    case CellType.STRING:
//                        System.out.println(cell.getRichStringCellValue().getString());
//                        break;
//                    case CellType.NUMERIC:
//                        if (DateUtil.isCellDateFormatted(cell)) {
//                            System.out.println(cell.getDateCellValue());
//                        } else {
//                            System.out.println(cell.getNumericCellValue());
//                        }
//                        break;
//                    case CellType.BOOLEAN:
//                        System.out.println(cell.getBooleanCellValue());
//                        break;
//                    case CellType.FORMULA:
//                        System.out.println(cell.getCellFormula());
//                        break;
//                    case CellType.BLANK:
//                       System.out.println();
//                       break;
//                    default:
//                        System.out.println();
//                }
//            }
//        }
