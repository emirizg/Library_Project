
Feature: Login Function US-001
  Agile Story : 1-User can login with valid credentials (We have 2 types user such as student and librarian).
                2-User can not login with invalid credentials.

  @wip
  Scenario: 1.1-Librarian can login with valid credentials (We have 2 types user such as student and librarian).
    Given User is on the login page
    When User enter "username" and "password"
    And User click the login button
    Then Verify user logged in successfully

  Scenario: 1.2-Student can login with valid credentials (We have 2 types user such as student and librarian).
    Given User is on the login page
    When User enter "username" and "password"
    And User click the login button
    Then Verify user logged in successfully

    Scenario: 2-User can not login with invalid credentials.
      Given User is on the login page
      When User enter an invalid "username" and "password"
      And User click the login button
      Then Verify user can not log in



