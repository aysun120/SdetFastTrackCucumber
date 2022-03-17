package com.sdetfasttrack.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {
    /*
    in this method we learn how to read from excel file step by step
     */

    @Test
    public void read_from_excel_file() throws IOException {
        String path = "SampleData.xlsx";

        // to read from excel we need to load it to FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);
        //workbook>sheet>row>cell

        // <1> Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // <2> We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //<3> Select row and cell
        //Print out Steven;s cell
        //Indexes start from 0
        System.out.println("sheet.getRow(1).getCell(0) = " + sheet.getRow(1).getCell(0));

        //print Singer
        System.out.println("sheet.getRow(3).getCell(2) = " + sheet.getRow(3).getCell(2));

        //print Orkhan
        System.out.println("sheet.getRow(4).getCell(0) = " + sheet.getRow(4).getCell(0));

        // Return the count of used cells only
        //Strats counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println("Used rows "+usedRows);

        /*
        Returns the number from top cell to bottom cell
        it does not care if the cell is empty or not
        Starts counting from 0
         */
        int lastUsedRow = sheet.getLastRowNum();
        System.out.println("lastUsedRow = " + lastUsedRow);

        //TODO: 1 Create a logic to print Orkhan's name DYNAMICALLY

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Orkhan")){
                System.out.println("Apache POI found you! Name is " +sheet.getRow(rowNum).getCell(0) );
            }
        }

        //TODO: 2 - CREATE A LOGIC TO PRINT OUT STEVEN KING'S JOB_ID
        // CHECK IF NAME IS STEVEN --> PRINT OUT JOB_ID

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Steven")){
                System.out.println("Steven's JOB_ID is " + sheet.getRow(rowNum).getCell(2));
            }
        }


    }


}
