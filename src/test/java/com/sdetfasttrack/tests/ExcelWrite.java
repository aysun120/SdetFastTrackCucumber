package com.sdetfasttrack.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;


    @Test
    public void excel_writing_test() throws IOException {
        String path = "SampleData.xlsx";

        // to read from excel we need to load it to FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);
        // workbook > sheet > row > cell
        workbook = new XSSFWorkbook(fileInputStream);
        //get the seet
        sheet = workbook.getSheet("Employees");

        /**
         * King's row
         */
        row = sheet.getRow(1);

        //King;s cell
        cell = row.getCell(1);

        XSSFCell adamsCell = sheet.getRow(2).getCell(0);

        System.out.println("Before: "+ adamsCell);

        //this method will override existing cell
        adamsCell.setCellValue("CodingHot");
        System.out.println("After: "+adamsCell);

        // TODO: CHANGE STEVEN'S NAME TO DONALD


        for (int rowNum = 0; rowNum <sheet.getLastRowNum() ; rowNum++) {

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Steven")) {
                sheet.getRow(rowNum).getCell(0).setCellValue("Donald");
            }
        }


        //Use FileOutputStream to push changes
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        //Write to file using FileOutputStream
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();





    }
}
