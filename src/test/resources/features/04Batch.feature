Feature: Batch Page Navigation

  Background: 
    Given Admin successfully logged on to the LMS Portal

  Scenario: Verify Admin Navigate to Batch page successfully
    Given For batch Admin is on the home page
    When Admin clicks on the Batch menu from the header
    Then Admin should be in the Manage Batch Page

  Scenario: Validate Title in Batch Page
    Given For batch Admin is on the home page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the LMS-Learning Management System Title for batch page

  Scenario: Validate Heading in the Batch Page
    Given For batch Admin is on the home page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the Manage Batch Heading

  Scenario: Validate disabled Delete Icon under the header in the Batch Page
    Given For batch Admin is on the home page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the disabled Delete Icon under the header in the Batch Page

  Scenario: Validate pagination in the Batch Page
    Given For batch Admin is on the home page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the enabled pagination controls under the data table in the Batch Page

  Scenario: Validate edit icon in each data row
    Given For batch Admin is on the home page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the edit icon in each row in the Batch Page

  Scenario: Validate delete icon in each data row
    Given For batch Admin is on the home page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the delete icon in each row in the Batch Page

  Scenario: Validate checkbox in each data row
    Given For batch Admin is on the home page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the checkbox in each row in the Batch Page

  Scenario: Validate Datatable headers
    Given For batch Admin is on the home page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the datatable headers Batch Name, Batch Description, Batch Status, No Of Classes, Program Name, Edit Delete in the Batch Page

  Scenario: Validate Checkbox in the Datatable header row
    Given For batch Admin is on the home page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the checkbox in the datatable header row in the Batch Page

  Scenario: Validate Sort Icon next to all the datatable headers
    Given For batch Admin is on the home page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the sort icon next to all Datatable headers in the Batch Page

  Scenario: Verify sub-menu displayed in batch menu bar
    Given Admin is on the batch page
    When Admin clicks Batch on the navigation bar
    Then Admin should see sub-menu in menu bar as Add New Batch

  Scenario: Validate Admin able to click on the Add New Batch Option
    Given Admin is on the home page
    When Admin clicks on Add New Batch under the Batch menu bar
    Then Admin should see the Batch Details pop-up window

  Scenario: Validate all the fields exist in pop up
    Given Admin is on the Batch Details Pop Up Window
    When Admin checks all the fields are enabled in the Batch Page
    Then The pop up should include the fields Batch Name, Number of classes, and Description as text box, Program Name as drop down in the Batch Page

  Scenario: Validate batch name prefix selected program name
    Given Admin is on the Batch Details Pop Up Window
    When Admin selects program name present in the dropdown of batch page
    Then Admin should see selected program name in the batch name prefix box

  Scenario: Validate batch name suffix box should accept only numbers
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters alphabets in batch name suffix box
    Then Admin should get error message below the text box of respective field for batch page

  Scenario: Validate batch name prefix box is not editable
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters alphabets in batch name prefix box
    Then Admin should see empty text box for batch page

  Scenario: Validate input data only for mandatory fields
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters the data only to the mandatory fields and clicks save button for batch page
    Then Admin should get a successful message for batch page

  Scenario: Validate input data missing for mandatory fields
    Given Admin is on the Batch Details Pop Up Window
    When Admin leaves blank one of the mandatory fields for batch page
    Then Admin should get an error message on the respective mandatory field for batch page

  Scenario: Validate save button in Batch details pop up
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters the valid data to all the mandatory fields and clicks save button for batch page
    Then Admin should get a successful message for batch page

  Scenario: Validate cancel button in Batch details pop up
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters the valid data to all the mandatory fields and clicks cancel button for batch page
    Then Admin can see the batch details popup closes without creating any batch

  Scenario: Validate close icon on the batch details pop up
    Given Admin is on the Batch Details Pop Up Window
    When Admin clicks on the close icon for batch page
    Then Batch details pop up closes

  Scenario: Validate Edit icon feature in any row
    Given Admin is on the Batch page
    When Admin clicks the edit icon for batch page
    Then Admin should see the Batch details pop up window

  Scenario: Validate program name value is disabled to edit
    Given Admin is on the Batch page
    When Admin clicks the edit icon for batch page
    Then Admin should see Program name value field is disabled for editing for batch page

  Scenario: Validate batch name value is disabled to edit
    Given Admin is on the Batch page
    When Admin clicks the edit icon for batch page
    Then Admin should see batch name value field is disabled for editing

  Scenario: Validate editing description and No of classes fields with invalid data in the pop up
    Given Admin is on the Batch Details Page
    When Admin updates any fields with invalid data and clicks save button for batch page
    Then Admin should get an error message under the respective field for batch page

  Scenario: Validate save button in Batch details pop up
    Given Admin is on the Batch Details Page
    When Admin enters the valid data to all the mandatory fields and clicks save button for batch page
    Then Admin should get a successful message for editing the batch for batch page

  Scenario: Validate cancel button in Batch details pop up
    Given Admin is on the Batch Details Page
    When Admin enters the valid data to all the mandatory fields and clicks cancel button for batch page
    Then Admin can see the batch details popup closes without editing the batch

  Scenario: Validate delete icon on any row
    Given Admin is on the Batch page
    When Admin clicks the delete icon on any row for batch page
    Then Admin should see the confirm alert box with yes and no button for batch page

  Scenario: Validate yes button on the confirm alert box
    Given Admin is on the batch confirm popup page
    When Admin clicks on the delete icon and clicks the yes button for batch page
    Then Admin should see the successful message and the batch should be deleted for batch page

  Scenario: Validate no button on the confirm alert box
    Given Admin is on the batch confirm popup page
    When Admin clicks on the delete icon and clicks the no button for batch page
    Then Admin should see the alert box closed and the batch is not deleted for batch page

  Scenario: Validate close icon on the alert box
    Given Admin is on the batch confirm popup page
    When Admin clicks on the close icon for batch page
    Then Admin should see the alert box closed for batch page

  Scenario: Validate single row delete with checkbox
    Given Admin is on the Batch page
    When Admin clicks on the delete icon under the Manage batch header
    Then The respective row in the table should be deleted for batch page

  Scenario: Validate multiple row delete with checkbox
    Given Admin is on the Batch page
    When Admin clicks on the delete icon under the Manage batch header
    Then The respective rows in the table should be deleted for batch page

  Scenario: Validate next page link
    Given Admin is on the Batch page
    When Admin clicks the next page link on the data table for batch page
    Then Admin should see the next enabled link for batch page

  Scenario: Validate last page link
    Given Admin is on the Batch page
    When Admin clicks the last page link on the data table for batch page
    Then Admin should see the last page link with the next page link disabled on the table for batch page

  Scenario: Validate previous page link
    Given Admin is on the Batch page
    When Admin clicks the previous page link on the data table for batch page
    Then Admin should see the previous page on the table for batch page

  Scenario: Validate first page link
    Given Admin is on the Batch page
    When Admin clicks the first page link on the data table for batch page
    Then Admin should see the very first page on the data table for batch page

  Scenario: Validate search box functionality
    Given Admin is on the Batch page
    When Admin enters the batch name in the search text box
    Then Admin should see the filtered batches in the data table

  Scenario: Validate logout option in the header is visible and enabled from the batch page
    Given Admin is on the Batch page
    When Admin clicks on the logout button for batch page
    Then Admin should see the Login screen page from batch page
