Feature: Add new Employee

  Background: 
    Given user is logged with valid admin credentials
    And user navigates to AddEmployeePage

  @smoke
  Scenario: Add employee with first and last name
    When user enters employee "John" and "Smith"
    And user clicks save button
    Then "John Smith" is added successfully

  @regression
  Scenario: Add employee without employee id
    When user enters employee first and last name
    And user deletes employee id
    And user clicks save button
    Then employee is added successfully

  @smoke
  Scenario: Add employee and create login credentials
    When user enters employee first and last name
    And user clicks on create login checkbox
    Then employee is added successfully

  #to perform DDT in cucumber we use Scenario Outline with Examples
  @regression
  Scenario Outline: Adding multiple employees
    When user enters employee "<FirstName>", "<MiddleName>" and "<LastName>"
    And user clicks save button
    Then "<FirstName>", "<MiddleName>" and "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName |
      | James     | J          | Smith    |
      | Margarita | M          | Malevan  |
      | Luna      | M          | Cat      |
      | Oliver    | B          | Cat      |

  #adding multiple employees using Cucumber DataTable
  @inProgress
  Scenario: Adding multiple employees
    When user enters employee details and clicks on save
      | FirstName | MiddleName | LastName |
      | John      | J          | Smith    |
      | Jane      | J          | Smith    |
    Then employee is added successfully

  @excel
  Scenario: Adding multiple employees from excel
    When user enters employee data from "EmployeeLoginCredentials" excel sheet then employee is added
