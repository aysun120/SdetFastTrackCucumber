package com.sdetfasttrack.step_definitions;

import com.sdetfasttrack.pages.DataTableLibrary;
import com.sdetfasttrack.utilities.ConfigurationReader;
import com.sdetfasttrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SmartBearStepDefinition {

    DataTableLibrary dataTableLibrary = new DataTableLibrary();

    @Given("User is on the login page of SmartBear")
    public void user_is_on_the_login_page_of_smart_bear() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartBearUrl"));
    }

    @When("User enters below info")
    public void user_enters_below_info(Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        dataTableLibrary.inputUsername.sendKeys(username);
        dataTableLibrary.inputPassword.sendKeys(password);
        dataTableLibrary.loginButton.click();

    }

    @Then("User should see title changed to Web Orders")
    public void user_should_see_title_changed_to_web_orders() {
        String expectedTitle = "Web Orders";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Title did not match",expectedTitle,actualTitle);
    }

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
     Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");
    }

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {
       Select select=new Select(dataTableLibrary.monthSelector);
       List<WebElement> listOfWebElement= select.getOptions();
       List<String> actualMonths=listOfWebElement.stream().map(WebElement::getText).collect(Collectors.toList());
       Assert.assertEquals("Size did not match.",expectedMonths.size(),actualMonths.size());
        for (int i = 0; i <= expectedMonths.size()-1; i++) {
            Assert.assertEquals("The months did not match",expectedMonths.get(i),actualMonths.get(i));
        }

    }

}
