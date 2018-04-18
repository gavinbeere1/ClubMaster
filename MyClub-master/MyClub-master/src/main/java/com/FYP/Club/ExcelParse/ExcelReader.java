package com.FYP.Club.ExcelParse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {
    public static final String SAMPLE_XLSX_FILE_PATH = "Z:/4th & Final/Sem 1/FYP/Excel/Player2.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

  
        // 1. You can obtain a sheetIterator and iterate over it
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        System.out.println("Retrieving Sheets using Iterator");
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            System.out.println("=> " + sheet.getSheetName());
        }

  

        /*
           ==================================================================
           Iterating over all the rows and columns in a Sheet (Multiple ways)
           ==================================================================
        */

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
   
            	
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
               
                if (cellValue.equals("Tackle"))
                {
                	System.out.println(cellValue);
                    Cell cell2 = cellIterator.next();
                    String cellValue2 = dataFormatter.formatCellValue(cell2);
                	System.out.println("Value: " + cellValue2);	
                }
                if (cellValue.equals("Carries"))
                {
                	System.out.println(cellValue);
                    Cell cell2 = cellIterator.next();
                    String cellValue2 = dataFormatter.formatCellValue(cell2);
                	System.out.println("Value: " + cellValue2);	
                }
                if (cellValue.equals("Try"))
                {
                	System.out.println(cellValue);
                    Cell cell2 = cellIterator.next();
                    String cellValue2 = dataFormatter.formatCellValue(cell2);
                	System.out.println("Value: " + cellValue2);	
                }
                if (cellValue.equals("Ball Placement"))
                {
                	System.out.println(cellValue);
                    Cell cell2 = cellIterator.next();
                    String cellValue2 = dataFormatter.formatCellValue(cell2);
                	System.out.println("Value: " + cellValue2);	
                }
                if (cellValue.equals("Ruck"))
                {
                	System.out.println(cellValue);
                    Cell cell2 = cellIterator.next();
                    String cellValue2 = dataFormatter.formatCellValue(cell2);
                	System.out.println("Value: " + cellValue2);	
                }
                if (cellValue.equals("Lineout"))
                {
                	System.out.println(cellValue);
                    Cell cell2 = cellIterator.next();
                    String cellValue2 = dataFormatter.formatCellValue(cell2);
                	System.out.println("Value: " + cellValue2);	
                }
               
            }
           
        }

        // Closing the workbook
        workbook.close();
    }
}