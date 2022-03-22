package com.sdetfasttrack.step_definitions;

import com.sdetfasttrack.pages.GoogleSearchPage;
import com.sdetfasttrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class Google_StepDefinitions {

    GoogleSearchPage searchPage = new GoogleSearchPage();

    @Given("User is on Google home page")
    public void user_is_on_google_home_page() {

        Driver.getDriver().get("https://www.google.com");

    }


    @When("User searches for apple")
    public void user_searches_for_apple() {

        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.searchBar.sendKeys("apple" + Keys.ENTER);

    }

    @Then("User should see apple in the title")
    public void user_should_see_apple_in_the_title() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = "apple";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }
    
    @Then("User should be able to search for following:")
    public void userShouldBeAbleToSearchForFollowing(List<String> items) {
        System.out.println("items = " + items);
        //loop and search for each item on google
        GoogleSearchPage searchPage = new GoogleSearchPage();

        for(String eachItem : items) {
            searchPage.searchBar.clear();
            searchPage.searchBar.sendKeys(eachItem + Keys.ENTER);
        }
    }

    @When("User searches for {string} capital")
    public void userSearchesForCapital(String countryName) {
        System.out.println("Searching for capital city of " + countryName);
        searchPage.searchBar.sendKeys("what is capital city of " + countryName + Keys.ENTER);
    }

    @Then("User should see {string} in the result")
    public void userShouldSeeInTheResult(String capitalCity) {
        System.out.println("Expected Capital City name: " + capitalCity);
        Assert.assertEquals(capitalCity, searchPage.searchResultCityName.getText());
    }
}
