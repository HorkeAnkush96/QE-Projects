@RegressionTestSuite @AccountMouleTestSuite
Feature: Accounts Module Automated tests
  I want to verify functionality of account module

  Background: 
    Given user navigates to the application url
    When user enter valid username
    And user enter valid passowrd
    And user click on signin button
    Then user should navigated to application home page
    And user should see all menus are present
    And user should see user name on right side of corener on homepage

@SmokeTestSuite @SanityTestSuite
  Scenario: Verify Account Balance functionality as cleark role using Scenario option
    When user search for an "<123456>" account in search option
    Then user should get the account record
    When user click on "<123456>" account link
    Then user should navigate to "<123456>" account page
    When user click on debit button
    And user enter "100" rupees in debit amount field
    And user click on submit button
    Then user should see "100" debited suceessfully
    And user verify "100" is debited from user account

  Scenario Outline: Verify <Account_Number> Account Balance functionality using Scenario Outline option
    When user search for an given account in search option
      |    123456 |
      |   0215151 |
      | 521541515 |
    Then user should get the account record
    When user click on "<Account_Number>" account link
    Then user should navigate to "<Account_Number>" account page
    When user click on debit button
    And user enter "<Amount>" rupees in debit amount field
    And user click on submit button
    Then user should see "<Amount>" debited suceessfully
    And user verify "<Amount>" is debited from user account
    Examples: 
      | Account_Number | Amount |
      |         123456 |  44444 |
      |        0215151 |   4444 |
      |      521541515 |   5444 |
      |     1154154154 |  44154 |
