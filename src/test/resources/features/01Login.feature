@login_Scenarios
Feature: Login  Page Verification

  Scenario: Verify Admin is able to land on login page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page
    And Admin should land on dashboard page by passing login credential "ValidCredentials"  
