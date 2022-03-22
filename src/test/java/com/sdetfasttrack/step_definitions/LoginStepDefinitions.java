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

public class LoginStepDefinitions {

    LoginPage loginPage= new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
     String url=ConfigurationReader.getProperty("libraryURL");
     Driver.getDriver().get(url);
    }

    @When("student enters username")
    public void student_enters_username() {
     loginPage.inputEmail.sendKeys(ConfigurationReader.getProperty("studentUsername"));
    }

    @When("student enters password")
    public void student_enters_password() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("studentPassword"));
    }
    @When("student clicks login button")
    public void student_clicks_login_button() {
        loginPage.loginButton.click();
    }
    @Then("student should see dashboard")
    public void student_should_see_dashboard() {
      WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
      wait.until(ExpectedConditions.titleIs("Library"));
      String expectedTitle="Librar";
      String actualTitle=Driver.getDriver().getTitle();
      assertEquals("Title did not match!",expectedTitle,actualTitle);

    }

    @When("librarian enters username")
    public void librarian_enters_username() {
        loginPage.inputEmail.sendKeys(ConfigurationReader.getProperty("libraryUsername"));
    }

    @When("librarian enters password")
    public void librarian_enters_password() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("libraryPassword"));
    }
    @When("librarian clicks login button")
    public void librarian_clicks_login_button() {
        loginPage.loginButton.click();
    }
    @Then("librarian should see dashboard")
    public void librarian_should_see_dashboard() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Library"));
        String expectedTitle="Library";
        String actualTitle=Driver.getDriver().getTitle();
        assertEquals("Title did not match!",expectedTitle,actualTitle);
    }

}
