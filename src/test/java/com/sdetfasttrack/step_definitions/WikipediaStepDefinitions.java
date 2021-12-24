package com.sdetfasttrack.step_definitions;

import com.sdetfasttrack.pages.WikipediaPage;
import com.sdetfasttrack.utilities.ConfigurationReader;
import com.sdetfasttrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class WikipediaStepDefinitions {

WikipediaPage wikipediaPage=new WikipediaPage();

    @Given("user is on the wikipedia main page")
    public void user_is_on_the_wikipedia_main_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wikiUrl"));
    }

    @When("user searches for Steve Jobs")
    public void user_searches_for_steve_jobs() {
        wikipediaPage.searchInput.sendKeys("Steve Jobs");
    }
    @When("user clicks search button")
    public void user_clicks_search_button() {
        wikipediaPage.searchButton.click();
    }
    @Then("user should see Steve Jobs on the title")
    public void user_should_see_steve_jobs_on_the_title() {
        String expectedTitle="Steve Jobs";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue("Title did not match.",actualTitle.contains(expectedTitle));
    }

    @Then("user should see Steve Jobs on the main header")
    public void user_should_see_steve_jobs_on_the_main_header() {
        String expectedHeader="Steve Jobs";
        String actualHeader=wikipediaPage.headerText.getText();
        Assert.assertEquals("Header Text did not match.",expectedHeader,actualHeader);
    }

    @Then("user should see Steve Jobs on the image")
    public void user_should_see_steve_jobs_on_the_image() {
        String expectedImageText="Steve Jobs";
        String actualImageText=wikipediaPage.imageText.getText();

        Assert.assertEquals("Image text did not match.",expectedImageText,actualImageText);
    }

    @When("user searches for {string}")
    public void user_searches_for(String expected) {
        wikipediaPage.searchInput.sendKeys(expected);//Steve Jobs
    }


    @Then("user should see {string} on the main header")
    public void user_should_see_on_the_main_header(String expected) {
        String actualHeader=wikipediaPage.headerText.getText();
        Assert.assertEquals("Header Text did not match.",expected,actualHeader);
    }

    @Then("user should see {string} on the image")
    public void user_should_see_on_the_image(String expected) {
        String actualImageText=wikipediaPage.imageText.getText();
        Assert.assertEquals("Image text did not match.",expected,actualImageText);
    }

    @When("User searches {string}")
    public void user_searches(String expected) {
        wikipediaPage.searchInput.sendKeys(expected);
    }

    @Then("User should see {string} on the image text")
    public void user_should_see_on_the_image_text(String expected) {
        String actual=wikipediaPage.imageText.getText();
        Assert.assertEquals(expected,actual);
    }
    @Then("User should see {string} on the header text")
    public void user_should_see_on_the_header_text(String expected) {
        String actual=wikipediaPage.headerText.getText();
        Assert.assertEquals(expected,actual);
    }
    @Then("User should see {string} on the title text")
    public void user_should_see_on_the_title_text(String expected) {
        String actual=Driver.getDriver().getTitle();
        Assert.assertTrue("Title did not match.",actual.contains(expected));

    }

}
