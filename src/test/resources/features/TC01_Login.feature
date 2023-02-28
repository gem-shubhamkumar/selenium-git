Feature: Login in orangeHM

  Scenario: Login with valid credentials
    Given User login with valid credentials
    And User should navigate to dashboard page

    Scenario Outline: Login with empty password
      Given User login with empty password
      Then Verify "<message>" message should be visible in field "<field>"
      Examples:
       | message |field|
       |Required | Password   |


  Scenario Outline: Login with empty password
    Given User login with empty password
    Then Verify "<message>" message should be visible in field "<field>"
    Examples:
      | message  | field    |
      | Required | Password |

  Scenario Outline: Login with empty username
    Given User login with empty username
    Then Verify "<message>" message should be visible in field "<field>"
    Examples:
      | message  | field    |
      | Required | Username |

  Scenario Outline: Login with empty username and password
    Given User login with empty username and password
    Then Verify "<message>" message should be visible in fields "<fields>"
    Examples:
      | message  | fields            |
      | Required | Username,Password |

