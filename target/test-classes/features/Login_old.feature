Feature: Login

  Scenario: valid admin login
    When user enter valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    
  Scenario: valid ess login
    When user enter valid ess username and password
    And user clicks on login button
    Then ess user is successfully logged in

  Scenario: Login with valid username and invalid password
    When user enter valid username and invalid password
    And user clicks on login button
    Then User see Invalid Credentials text on login page

  Scenario: Login with invalid Credentials
    When I enter invalid username and password and see error message
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid credentials |
      | Hello    | Syntax123! | Invalid credentials |
