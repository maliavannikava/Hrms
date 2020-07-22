Feature: Employee Search

  Background: 
    Given user is logged with valid admin credentials
    And user navigate to employee list page

@smoke
  Scenario: Search employee by id
    When user enters valid employee id "10079"
    And click on search button
    Then user sees employee information is displayed
    
@regression
  Scenario: Search employee by name
    When user enters valid employee name and last name
    And click on search button
    Then user sees employee information is displayed
