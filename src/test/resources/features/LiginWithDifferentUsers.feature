
Feature: Data driven testing with different user accounts

  @diffUser
  Scenario Outline: As a user, I should be able to login with different users using their correct emails and
     passwords. When I login, I should be able to see username in the account username section.
    Given User is on the library login page
    When User enters username "<email>"
    And User enters password "<pass>"
    And User clicks login button
    Then User should see homepage

    Examples:
    |email|pass|
    |student3380@library|Mm4RFh95|
    |student3381@library|CtuCIbwS|
    |student3382@library|05rxFBkM|
    |librarian1264@library|xKYxVcB5|
    |librarian1263@library|6Zyvp0zv|
    |librarian1262@library|NLhOB6EE|
