Feature: Library app login
  User Story: As a different type of user
  I should be able to login and dashboard should be displayed.

  Background: user is on the login page
    Given user is on the library login page


  Scenario: Login as a student
    When student enters username "student3367@library" and password "GbZeYc7z"
    And student click login button
    Then user student should see dashboard


  Scenario: Login as Librarian
    When student enters username "librarian1261@library" and password "ICf9pm9S"
    And student click login button
    Then user student should see dashboard