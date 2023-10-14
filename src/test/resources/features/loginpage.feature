Feature: Login Functionality For LUMA website

  As a user of the LUMA website
  I want to be able to log in with my account
  So that I can access my account-related features and manage my orders

  Background:
    Given I'm in LUMA HomePage

  Scenario: Successful login with valid credentials
    Given I'm on LUMA login page
    And   I have entered a valid username and password
    When  I click on Sign In button
    Then  I should be logged in successfully


  Scenario Outline: Unsuccessful login with invalid credentials
    Given I'm on LUMA login page
    And   I have entered invalid "<username>" & "<password>"
    When  I click on Sign In button
    Then  I get error message: "<error_message>"

    Examples:
      | username                | password        | error_message                                         |
      | validemail@tester.com   | invalidPassword | The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later. |
      | invalidmail@aa.com      | validPassword   | The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later. |
      | invalidmail@aa.com      | invalidPassword | The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later. |

