package com.sdetfasttrack.step_definitions;

import com.sdetfasttrack.pages.LoginPage;
import com.sdetfasttrack.utilities.ConfigurationReader;
import com.sdetfasttrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;

public class LoginScenarioOutlineStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("User is on the library login page")
    public void user_is_on_the_library_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("libraryURL"));
    }

    @When("User enters username {string}")
    public void user_enters_username(String email) {
        loginPage.inputEmail.sendKeys(email);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        loginPage.inputPassword.sendKeys(password);
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @Then("User should see homepage")
    public void user_should_see_homepage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("Library"));
        String expectedTitle = "Library";
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals("Title did not match.", expectedTitle, actualTitle);
    }

}
