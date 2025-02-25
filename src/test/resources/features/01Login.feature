@login
Feature: Login Page Verification

  Background: 
    Given The browser is open
    When Admin gives the correct LMS portal URL

  Scenario: Verify Admin is able to land on login page
    Then Admin should land on the login page

  Scenario: Verify application name
    Then Admin should see application name

  Scenario: Verify for broken link
    Then Admin should verify the broken links

  Scenario: Verify company name
    Then Admin should see company name below the app name

  Scenario: Validate sign in content
    Then Admin should see Please login to LMS application text displayed

  Scenario: Verify text field is present
    Then Admin should see 2 text field

  Scenario: Verify text on the first field
    Then Admin should see "User" in the first text field

  Scenario: Verify text on the second field
    Then Admin should see "Password" in the second text field

  Scenario: Verify asterisk mark symbol next to user text
    Then Admin should see asterisk mark symbol next to User "User" text

  Scenario: Verify asterisk mark symbol next to password text
    Then Admin should see asterisk mark symbol next to password "Password" text

  Scenario: Verify dropdown is present
    Then Admin should see one dropdown

  Scenario: Verify placeholder in dropdown to select role
    Then Admin should see Select The Role placeholder in dropdown

  Scenario: Verify dropdown option to select role
    Then Admin should see Admin Staff and Student options in dropdown

  Scenario: verify Login button is present
    Then Admin should see login button

  Scenario: Verify the text spelling in the page
    Then Admin should see correct spellings in all fields

  Scenario: Verify input descriptive test in user field
    Then Admin should see user in gray color

  Scenario: Verify input descriptive test in password field
    Then Admin should see password in gray color

  Scenario: Verify the alignment input field for the login
    Then Admin should see input field on the centre of the page

  Scenario: Verify input descriptive text in user field
    Then Admin should see user in gray color

  Scenario: Verify input descriptive text in password field
    Then Admin should see password in gray color

  #Scenario: Login to the application with Valid details
     #Given Admin logs into the application 

  Scenario Outline: Validate login with different data in all field
    When Admin enter required data from login "<sheet>" for required "<scenario>" and clicks login button
    Then Admin should get proper response on webpage based on "<scenario>"

    Examples: 
      | sheet     | scenario    |
      | loginData | validLogin  |
      | loginData | invalidUser |
      | loginData | invalidPwd  |
      | loginData | invalidRole |
      | loginData | withoutUser |
      | loginData | withoutPwd  |
      | loginData | withoutRole |

  
  Scenario Outline: verify login button action through mouse
    When Admin enter required data from login "<sheet>" for required "<scenario>" and clicks login button
    Then Admin should land on dashboard page

    Examples: 
      | sheet     | scenario   |
      | loginData | validLogin |

  Scenario Outline: verify login button action through keyboard
    When Admin enter required data from login "<sheet>" for required "<scenario>" and clicks login button through keyboard
    Then Admin should land on dashboard page

    Examples: 
      | sheet     | scenario   |
      | loginData | validLogin |

  Scenario: Verify Admin is able to land on home page with invalid URL
    When Admin gives the invalid LMS portal URL
    Then Admin should receive application error
