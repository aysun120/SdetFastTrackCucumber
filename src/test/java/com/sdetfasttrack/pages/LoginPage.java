package com.sdetfasttrack.pages;

import com.sdetfasttrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {



    /**
     * TC#1:
     * Task summary:
     * -> Create a new feature file named Login.feature
     * -> Create 2 scenarios for different user logins for: librarian, student.
     * -> Create new step definition named Login_StepDefinitions class and implement these
     * 2 scenarios.
     */

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="inputEmail")
    public WebElement inputEmail;

    @FindBy(id="inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath="//button[.='Sign in']")
    public WebElement loginButton;

}
