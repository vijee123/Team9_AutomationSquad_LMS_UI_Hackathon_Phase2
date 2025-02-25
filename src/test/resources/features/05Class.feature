@classsenario
Feature: Class Module

  Background: 
    Given Admin logs into the application

  @TC_Class_01
  Scenario: Validating the class manage page
    When Admin clicks the "Class" in the Header in class
    Then Admin should land on the "Manage Class" in class
    And Admin should see the "LMS - Learning Management System" Title in class
    And Admin should see the Searchbar in class
    And Admin should see the datatable heading like Batchname,class topic,class description,status,class Date,staff name,Edit/Delete

  @TC_Class_02
  Scenario: Add New Class Validation
    When Admin clicks add new class under the class menu bar in class
    Then Admin should see a manage class pop up with empty form and <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window in class
    Then Admin should see few input fields and their respective text boxes in the class details window in class

  @TC_Class_03
  Scenario Outline: Class Details pop up Validation
    Given Admin is on the Class Popup window in class
    When Admin enters "<sheet>" mandatory fields in the "<scenario>" form and clicks on save button in class
    Then Admin gets message Class added Successfully in class

    Examples: 
      | sheet  | testcase            |
      | Sheet1 | validInputMandatory |

  @classPagination1
  Scenario: Verify Next page link(>)
    # Given Admin is on the Manage Class page
    When Admin clicks Next page link on the class table
    Then Admin should see the next page record on the table  with Pagination has next active link enabled

  @classPagination2
  Scenario: Verify Last page link(>>)
    #Given Admin is on the Manage Class page
    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled

  @classPagination3
  Scenario: Verify First page link(<)
    Given Admin is on last page of class table
    When Admin clicks First page link
    Then Admin should see the previous page record on the table with pagination has previous page link enabled

  @classPagination4
  Scenario: Verify Start page link(<<)
    Given Admin is on Previous class page
    When Admin clicks Start page link
    Then Admin should see the very first page record on the table with Previous page link are disabled

  @classSorting1
  Scenario: Sort Class by Batch name
    #Given Admin is on the Manage Class page
    When Admin clicks on the Batchname sort icon
    Then Admin should see Class details are sorted by Batch Name

  @classSorting2
  Scenario: Sort Class by Class topic
    # Given Admin is on the Manage Class page
    When Admin clicks on the Class topic sort icon
    Then Admin should see Class details are sorted by Class topic

  @classSorting3
  Scenario: Sort Class by Class Descreption
    # Given Admin is on the Manage Class page
    When Admin clicks on the descreption sort icon
    Then Admin should see Class details are sorted by descreption

  @classSorting4
  Scenario: Sort Class by Class Status
    #Given Admin is on the Manage Class page
    When Admin clicks on the Status sort icon
    Then Admin should see Class details are sorted by Status

  #@classSorting5
  #Scenario: Sort Class by Class date
  #Given Admin is on the Manage Class page
  #When Admin clicks on the Class Date sort icon
  #Then Admin should see Class details are sorted by Class Date
  @classSorting6
  Scenario: Sort Class by staff name
    #Given Admin is on the Manage Class page
    When Admin clicks on the Staff Name sort icon
    Then Admin should see Class details are sorted by Staff Name

  #   @logout
  #Scenario: Validate logout
  #When Admin clicks on the logout in the menu bar
  #Then Admin should be redirected to login page "Please login to LMS application"


  Scenario: Validating Edit Disable option
    When Admin clicks on the edit icon
    Then Admin should see batch name field is disabled

  Scenario: Check disabled class topic
    Then Admin should see class topic field is disabled

  Scenario: Check if the fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Update the fields with valid data and click save
    Then Admin gets message "class details updated Successfully " and see the updated values in data table

  Scenario: Check if the fields are updated with invalid values
    When Update the fields with invalid values and click save
    Then Admin should get Error message

  Scenario: Check if the mandatory fields are updated with valid data
    When Update the mandatory fields with valid values and click save

  Scenario: Check if the optional fields are updated with valid data
    When Update the optional fields with valid values and click save

  Scenario: Validate Cancel button on Edit popup
    When Admin clicks Cancel button on edit popup
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class

  Scenario: Class link on navigation bar
    Given Admin is in Manage Class page
    When Admin clicks on Class link on Manage Class page
    Then Admin is redirected to class page

  Scenario: Logout link on navigation bar
    When Admin clicks on Logout link on Manage class page
    Then Admin is redirected to Login page

  Scenario: Search class by Batch Name
    Given Admin is the Manage class page
    When Admin enter the Batch Name in search textbox
    Then Admin should see Class details are searched by Batch Name

  Scenario: Search class by Class topic
    When Admin enter the Class topic in search textbox
    Then Admin should see Class details are searched by Class topic

  Scenario: Validate row level delete icon
    Given Admin should on Manage Class Page
    When Admin clicks the delete icon
    Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion

  Scenario: Validate Common Delete button enabled after clicking on any checkbox
    Given Admin  in Manage Class page
    When Admin clicks any checkbox in the data table
    Then Admin should see common delete option enabled under header Manage class

  Scenario: Admin is on Confirm Deletion alert
    Given Admin is on Confirm Deletion alert
    When Admin clicks yes option
    Then Admin gets a message "Successful Class Deleted" alert and do not see that Class in the data table
