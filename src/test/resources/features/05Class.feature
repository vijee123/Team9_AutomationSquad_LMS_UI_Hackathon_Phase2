@class_Scenarios
Feature: Class Module

 Scenario: Validating the class manage page
    When Admin clicks the "Class" in the Header in class
    Then Admin should land on the "Manage Class" in class
    
 Scenario: Validating Edit Disable option
    When Admin clicks on the edit icon
    Then Admin should see batch name field is disabled
    
 Scenario: Check disabled class topic
 Then Admin should see class topic field is disabled
 
 Scenario: Check if the fields are updated with valid data
  Given  Admin is on the Edit Class Popup window
  When   Update the fields with valid data and click save
  Then   Admin gets message "class details updated Successfully " and see the updated values in data table
  
 Scenario: Check if the fields are updated with invalid values
 When  Update the fields with invalid values and click save
 Then Admin should get Error message 
 
 Scenario: Check if the mandatory fields are updated with valid data
 When  Update the mandatory fields with valid values and click save
 
Scenario: Check if the optional fields are updated with valid data
When Update the optional fields with valid values and click save

Scenario: Validate Cancel button on Edit popup
When Admin clicks Cancel button on edit popup
Then Admin can see the class details popup disappears and can see nothing changed for particular Class

Scenario: Class link on navigation bar
Given  Admin is in Manage Class page
When  Admin clicks on Class link on Manage Class page
Then Admin is redirected to class page

Scenario: Logout link on navigation bar
When Admin clicks on Logout link on Manage class page
Then Admin is redirected to Login page

Scenario:Search class by Batch Name
Given Admin is the Manage class page
When Admin enter the Batch Name in search textbox
Then Admin should see Class details are searched by Batch Name

Scenario: Search class by Class topic
When Admin enter the Class topic in search textbox
Then Admin should see Class details are searched by Class topic


Scenario:  Validate row level delete icon
Given  Admin should on Manage Class Page
When   Admin clicks the delete icon
Then   Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion

Scenario: Validate Common Delete button enabled after clicking on any checkbox
Given Admin  in Manage Class page
When Admin clicks any checkbox in the data table
Then Admin should see common delete option enabled under header Manage class

Scenario: Admin is on Confirm Deletion alert
Given Admin is on Confirm Deletion alert
When   Admin clicks yes option
Then  Admin gets a message "Successful Class Deleted" alert and do not see that Class in the data table
