Feature: Library app login
  User Story: As a different type of user
  I should be able to login and dashboard should be displayed.

Background: user is on login page
  Given user is on login page

  @student
  Scenario: Login as a student
    When student enters username
    And student enters password
    And student clicks login button
    Then student should see dashboard

  @librarian
  Scenario: Login as a librarian
    When librarian enters username
    And librarian enters password
    And librarian clicks login button
    Then librarian should see dashboard