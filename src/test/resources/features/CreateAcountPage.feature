Feature: Create new Account Functionality For LUMA website

  As a customer of the LUMA website
  I want to create personal account
  So that I can access my account-related features and manage my orders

  Background:
    Given I'm in LUMA HomePage

  Scenario Outline: Successful login with valid credentials
    Given I'm on Create New Customer Account Page
    When   I have entered First name: "<FirstName>" & Last name: "<LastName>"
    And   I have entered Email: "<Email>" & Password: "<Password>" & Confirm Password: "<ConfirmPassword>"
    And   I have clicked on Create an account button
    Then  I should be created a new customer and redirected to his Account Page

    Examples:
      |FirstName    |LastName   |Email                      |Password         |ConfirmPassword|
      |Sharaf       |Ibrahim    |GHAZA5@val1.com              |P@ssw0rd         |P@ssw0rd       |

