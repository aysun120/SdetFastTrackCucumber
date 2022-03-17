package com.sdetfasttrack.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void readExcel() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("SampleData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Employees");

        System.out.println(sheet.getRow(3).getCell(2));

        System.out.println(sheet.getLastRowNum());
        int rowNum = sheet.getLastRowNum();
        int rowNumber=sheet.getPhysicalNumberOfRows();
        System.out.println(rowNumber);
        for (int i = 0; i < rowNum; i++) {
            if (sheet.getRow(i).getCell(2).toString().equals("Singer")) {
                System.out.println(sheet.getRow(i).getCell(0));
            }
        }
    }}

