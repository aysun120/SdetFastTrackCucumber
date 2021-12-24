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

public class LoginStepDefinitionsParameters {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the library login page")
    public void user_is_on_the_library_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("libraryURL"));
    }

    @When("student enters username {string} and password {string}")
    public void student_enters_username_and_password(String username, String password) {

        loginPage.inputEmail.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);

    }

    @When("student click login button")
    public void student_click_login_button() {
        loginPage.loginButton.click();
    }

    @Then("user student should see dashboard")
    public void user_student_should_see_dashboard() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("Library"));
        String expectedTitle = "Library";
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals("Title did not match.", expectedTitle, actualTitle);
    }


}
