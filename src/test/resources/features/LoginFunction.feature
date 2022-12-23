
Feature: Login Function US-001
  Agile Story : 1-User can login with valid credentials (We have 2 types user such as student and librarian).
                2-User can not login with invalid credentials.


  Scenario: verify information about logged user
    Given I logged Library api using "librarian1@library" and "rs4BNN9G"
    When I get the current user information from api
    Then status code should be 200

  Scenario Outline: 1.1-Librarian can login with valid credentials (We have 2 types user such as student and librarian).
    Given User is on the login page
    When Librarian enter "<username>" and "<password>"
    Then Verify Librarian logged in successfully
    Examples:
      | username           | password |
      | librarian1@library | rs4BNN9G |
      | librarian2@library | eb2VQKEj |
      | librarian3@library | I6JMMwLb |
      | librarian4@library | 7jrGZdaV |
      | librarian5@library | 4p4ewVgW |


  Scenario Outline: 1.2-Student can login with valid credentials (We have 2 types user such as student and librarian).
    Given User is on the login page
    When Student enter "<username>" and "<password>"
    Then Verify Student logged in successfully
    Examples:
      | username         | password |
      | student1@library | i2A9TgXa |
      | student2@library | 80qynl9d |
      | student3@library | 1f3ZGRGj |
      | student4@library | 1AHF6MHk |
      | student5@library | uElqihO2 |


  Scenario Outline: 2-User can not login with invalid credentials.
      Given User is on the login page
      When User enter "<username>" and "<password>"
      Then Verify user can not log in
    Examples:
      | username     | password  |
      | stud@library | i2AasdgXa |
      | stud@library | assdda    |

    @db
    Scenario: verify book categories from api and database
      Given I logged Library api using "librarian1@library" and "rs4BNN9G"
      When I get the book categories from api and database
      Then the book categories from api and database should match



