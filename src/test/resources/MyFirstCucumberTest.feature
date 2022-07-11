Feature: Sauce demo login feature

  Scenario: User can login with correct username/password
    Given user navigates to 'https://www.saucedemo.com/'
    Then user sees page title 'Swag Labs'
    When user enters 'standard_user' and 'secret_sauce'
    And user clicks login button
    Then user sees inventory page