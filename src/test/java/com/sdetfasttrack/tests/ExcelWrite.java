package com.sdetfasttrack.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {


    @Test
    public void excelWrite() throws IOException {

        FileInputStream fileInputStream=new FileInputStream("SampleData.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook((fileInputStream));
        XSSFSheet sheet=workbook.getSheet("Employees");

        XSSFCell keerthi=sheet.getRow(4).getCell(1);
        keerthi.setCellValue("Shantel");

        System.out.println("After changing lastName: "+keerthi);

        // Change Dynamically Vinod's Job_ID to be BA/QA

        int rowNum= sheet.getLastRowNum();

        for (int i = 0; i <rowNum ; i++) {

            if(sheet.getRow(i).getCell(0).toString().equals("Vinod")){
                sheet.getRow(i).getCell(2).setCellValue("BA/QA");
            }

        }





     FileOutputStream fileOutputStream = new FileOutputStream("SampleData.xlsx");
     workbook.write(fileOutputStream);

     fileInputStream.close();
     fileOutputStream.close();
     workbook.close();

    }
}
