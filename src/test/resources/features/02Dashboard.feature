Feature: Verify the features of Dashboard page

  Background: 
    Given Admin logs into the application

  Scenario: Verify LMS title on Dashboard page
    Then Admin should see LMS -Learning management system as title

  Scenario: Verify LMS title alignment
    Then LMS title should be on the top left corner of page

  Scenario: Validate navigation bar text
    Then Admin should see correct spelling in navigation bar text

  Scenario: Validate LMS title has correct spelling and space
    Then Admin should see correct spelling and space in LMS title

  Scenario: Validate alignment for navigation bar
    Then Admin should see the navigation bar text on the top right side

  Scenario: Validate navigation menu bar order sequence
    Then Admin should see menu bar items in the following sequence of HOME PROGRAM BATCH CLASS and LOGOUT

  Scenario: verify pie-chart presence
    Then Admin should see piechart

  Scenario: Verify bar chart
    Then Admin should see bar chart for Active and inactive user

  Scenario: Verify user details
    Then Admin should see welcome message with user name and role

  Scenario: Verify previous page icon disable
    Then Admin should see previous page icon disabled

  Scenario: Verify first page icon disabled
    Then Admin should see first page icon disabled

  Scenario: Verify staff table pagination
    Then Admin should see staff table with pagination icons

  Scenario: Verify staff data page split
    Then Admin should see 5 staff data in a page

  Scenario: Verify user count
    Then Admin should see user count including active and inactive

  Scenario: Verify staff count
    Then Admin should see staff count including Active and inactive

  Scenario: Verify program count
    Then Admin should see Program count including Active and inactive

  Scenario: Verify batch count
    Then Admin should see batch count including Active and inactive
