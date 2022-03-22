package com.sdetfasttrack.tests;

import com.sdetfasttrack.pages.VyTrackDashboardPage;
import com.sdetfasttrack.pages.VyTrackLoginPage;
import com.sdetfasttrack.utilities.ConfigurationReader;
import com.sdetfasttrack.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class VyTrackLoginDDTTest {

    VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();
    VyTrackLoginPage loginPage = new VyTrackLoginPage();

    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @After
    public void tearDown() {
        //close browser here

    }

    @Test
    public void loginDDTTest() throws Exception {

        //open excel workbook:
        String filePath = "VyTrackQa2Users.xlsx";
        FileInputStream in = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(in);

        XSSFSheet workSheet = workbook.getSheetAt(0);
        /**
       String userName = "user1";
       String password = "UserUser123";
       String firstName = "John";
       String lastName = "Doe";
        */
        for(int i = 1; i <= workSheet.getLastRowNum(); i++) {

            String userName = workSheet.getRow(i).getCell(0).toString();
            String password = workSheet.getRow(i).getCell(1).toString();
            String firstName = workSheet.getRow(i).getCell(2).toString();
            String lastName = workSheet.getRow(i).getCell(3).toString();

            loginPage.login(userName, password);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
            wait.until(ExpectedConditions.visibilityOf(dashboardPage.fullName));
            System.out.println("Full name = " + dashboardPage.fullName.getText());

            String actualFullName = dashboardPage.fullName.getText();

            //Assert.assertTrue(actualFullName.contains(firstName) && actualFullName.contains(lastName));

            XSSFCell resultCell = workSheet.getRow(i).getCell(4);

            if (actualFullName.contains(firstName) && actualFullName.contains(lastName)) {
                System.out.println("PASS");
                resultCell.setCellValue("PASS");
            } else {
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");
            }

            dashboardPage.logout();
        }

        //save changes in the excel file
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);

        in.close();
        out.close();
        workbook.close();

    }

}
