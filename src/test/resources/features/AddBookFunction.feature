Feature: Add Book Function


  Scenario: Verify that librarian should be able to add new book in api
    Given User logged Library api using "librarian1@library" and "rs4BNN9G"
    When I post add book function in api
    And statuscode should be 200
    Then verify added book is visible on database


