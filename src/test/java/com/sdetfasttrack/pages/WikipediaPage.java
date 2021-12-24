package com.sdetfasttrack.pages;

import com.sdetfasttrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPage {

    public WikipediaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='searchInput']")
    public WebElement searchInput;

    @FindBy(xpath = "//input[@id='searchButton']")
    public WebElement searchButton;

    @FindBy(xpath = "//h1[@id='firstHeading']")
    public WebElement headerText;

    @FindBy(xpath = "//th[contains(@class,'infobox-above')]")
    public WebElement imageText;
    /**
     * TC#25: Wikipedia Search Functionality Title Verification
     * 1. User is on Wikipedia home page
     * 2. User types Steve Jobs in the wiki search box
     * 3. User clicks wiki search button
     * 4. User sees Steve Jobs is in the wiki title
     *
     * Note: Follow POM
     * TC#26: Wikipedia Search Functionality Header Verification
     * 1. User is on Wikipedia home page
     * 2. User types Steve Jobs in the wiki search box
     * 3. User clicks wiki search button
     * 4. User sees Steve Jobs is in the main header
     *
     * Note: Follow POM
     * TC#27: Wikipedia Search Functionality Image Header Verification
     * 1. User is on Wikipedia home page
     * 2. User types Steve Jobs in the wiki search box
     * 3. User clicks wiki search button
     * 4. User sees Steve Jobs is in the image header
     */
}
