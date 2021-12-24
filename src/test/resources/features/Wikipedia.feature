Feature: Wikipedia Search Feature

 @wikipedia
  Scenario: Wikipedia Search title verification
    Given user is on the wikipedia main page
    When user searches for Steve Jobs
    And user clicks search button
    Then user should see Steve Jobs on the title

  Scenario: Wikipedia Search header verification
    Given user is on the wikipedia main page
    When user searches for Steve Jobs
    And user clicks search button
    Then user should see Steve Jobs on the main header

  Scenario: Wikipedia Search image verification
    Given user is on the wikipedia main page
    When user searches for Steve Jobs
    And user clicks search button
    Then user should see Steve Jobs on the image

  Scenario: Wikipedia Search header verification
    Given user is on the wikipedia main page
    When user searches for "Steve Jobs"
    And user clicks search button
    Then user should see "Steve Jobs" on the main header

  Scenario: Wikipedia Search image verification
    Given user is on the wikipedia main page
    When user searches for "Steve Jobs"
    And user clicks search button
    Then user should see "Steve Jobs" on the image

  @wip
  Scenario Outline: Wekipedia Search
    Given user is on the wikipedia main page
    When User searches "<keyword>"
    And user clicks search button
    Then User should see "<expectedImage>" on the image text
    And User should see "<expectedHeader>" on the header text
    And User should see "<expectedTitle>" on the title text
    Examples:
      | keyword      | expectedImage | expectedHeader | expectedTitle |
      | Steve Jobs   | Steve Jobs    | Steve Jobs     | Steve Jobs    |
      | John Snow    | John Snow     | John Snow      | John Snow     |
      | Jimmy Fallon | Jimmy Fallon  | Jimmy Fallon   | Jimmy Fallon  |