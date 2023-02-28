Feature: Forget Password

  Scenario: TC07 Forget password with valid username
    When User clicks on Forget your password link
    Then The user enters "priyanshu.prajapati" to identify your account for password reset
    Then User clicks on reset password button
    And User verifies reset password links has been successfully sent