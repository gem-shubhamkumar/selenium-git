Feature: Orange HRM Add Employee

  Background: User Login
    Given User login with valid credentials
    And User should navigate to dashboard page

  Scenario Outline: TC11 Add Employee with Valid Details
    When Click on "PIM" Section
    And Click on "Add Employee" option
    Then Enter employee details "<firstName>" "<middleName>" "<lastName>" and "<employeeId>"
    And Click on save button
    And Verify success notification "<message>"

    Examples:
      | firstName | middleName | lastName | employeeId |
      | First     | Middle     | Last     | EID001     |

