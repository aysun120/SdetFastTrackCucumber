package com.sdetfasttrack.pages;

import com.sdetfasttrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataTableLibrary {

    public DataTableLibrary() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement inputUsername;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement inputPassword;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(id = "month")
    public WebElement monthSelector;


    /**
     * http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
     * C#27: SmartBear order process
     * Scenario: User should be able to login with
     * correct credentials
     *  Given User is on the login page of SmartBear
     *  When User enters below info
     *  |username|Tester|
     *  |password|test |
     *  Then User should see title changed to Web Orders
     */

    /**
     *
     *   @dataTable
     *   Scenario: User should be able to see all 12 months in months dropdown
     *     Given User is on the dropdowns page of practice tool
     *     Then User should see below info in month dropdown
     *       | January   |
     *       | February  |
     *       | March     |
     *       | April     |
     *       | May       |
     *       | June      |
     *       | July      |
     *       | August    |
     *       | September |
     *       | October   |
     *       | November  |
     *       | December  |
     */

}