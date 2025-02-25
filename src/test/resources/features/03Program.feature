Feature File:
@Program_LMS_UI
Feature: In Program module Navigation
Background:
Given Admin logs into the application
And Admin clicks Program on the navigation bar
@Navigation
Scenario: Verify that Admin is able to navigate to Program module
Then Admin should be navigated to Program module
@Navigation2
Scenario: Verify any broken links on program page
Then Admin should not have any broken links for Program module
@Navigation
Scenario: Verify heading in menu bar
Then Admin should see the heading LMS - Learning Management System
@Navigation
Scenario: Verify other modules name displayed in menu bar
Then Admin should see the module names as in order Program, Batch, Class, Logout
@Navigation5
Scenario: Verify Logout displayed in menu bar
Then Admin should see Logout in menu bar
@Navitation6
Scenario: Verify sub menu displayed in program menu bar
Then Admin should see sub menu in menu bar as Add New Program
##--------PageValidation
@PageValidation1
Scenario: Verify heading in manage program
Then Admin should see the heading Manage Program
@PageValidation2
Scenario: Verify view details of programs
Then Admin should able to see Program name, description, and status for each program
@PageValidation3
Scenario: Verify the Multiple Delete button state
Then Admin should see a Delete button in left top is disabled
@PageValidation4
Scenario: Verify the Search button
Then Admin should see Search bar with text as "Search..."
@PageValidation5
Scenario: Verify column header name of data table
Then Admin should see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit/Delete
@PageValidation6
Scenario: Verify checkbox default state beside Program Name column header
Then Admin should see checkbox default state as unchecked beside Program Name column header as Program Name, Program Description, Program Status, Edit/Delete
@PageValidation7
Scenario: Verify checkboxes default state beside each Program names in the data table
Then Admin should see check box default state as unchecked on the left side in all rows against program name
@PageValidation8
Scenario: Verify Sort icon in manage program
Then Admin should see the sort arrow icon beside to each column header except Edit and Delete
@PageValidation9
Scenario: Verify edit and delete icon in manage program
Then Admin should see the Edit and Delete buttons on each row of the data table
@PageValidation10
Scenario: Verify pagination icons below data table in manage program
Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table. x- starting record number on that page, y-ending record number on that page, z-Total number of records
@PageValidation11
Scenario: Verify footer message in manage program
Then Admin should see the footer as In total there are z programs. z- Total number of records
##---Menu Bar
@MenuBarProgramAddNewProgram1
Scenario: Verify title of the pop up window
Then Admin should see window title as Program Details
@MenuBarProgramAddNewProgram2
Scenario: Verify mandatory fields with red "*" mark
When Admin clicks on New Program under the Program menu bar
Then Admin should see red star mark beside mandatory field Name
@MenuBarProgramAddNewProgram3
Scenario: Verify empty form submission
When Admin clicks save button without entering mandatory
Then Admin gets message field is required
@MenuBarProgramAddNewProgram4
Scenario: Verify cancel button
When Admin clicks Cancel button
Then Admin can see Program Details form disappears
@MenuBarProgramAddNewProgram5
Scenario: Verify enter program name
When Admin enters the Name in the text box
Then Admin can see the text entered
@MenuBarProgramAddNewProgram6
Scenario: Verify enter description
When Admin enters the Description in text box
Then Admin can see the text entered in description box
@MenuBarProgramAddNewProgram7
Scenario: Verify select Status
When Admin selects the status of the program by clicking on the radio button Active/InActive
Then Admin can see Active/Inactive status selected
@MenuBarProgramAddNewProgram8
Scenario Outline: Verify Admin is able to save the program details
When Admin enter valid details for mandatory fields <ProgramName>,<ProgramDescription>,<ProgramStatus> and Click on save button
Then Admin gets message <Message>
Examples:
| ProgramName | ProgramDescription | ProgramStatus | Message |
| "proDetailsNameU" | "proDetails Desc" | "Active" | "Successful" |
| "proDetailsNameV" | "proDetails Desc" | "Inactive" | "Successful" |
| "proDetailsName6 " | "proDetails Desc" | "Active" | "Failed" |
| "proDetailsName6 " | "proDetails Desc" | "Inactive" | "Failed" |
@MenuBarProgramAddNewProgram9
Scenario: Verify cancel program details
When Admin clicks Cancel button
Then Admin can see program details form disappear
@MenuBarProgramAddNewProgram10
Scenario: Verify added Program is created
When Admin searches with newly created Program Name
Then Records of the newly created Program Name is displayed and match the data entered
@MenuBarProgramAddNewProgram11
Scenario: Verify close window with "X"
When Admin Click on Cross button
Then Admin can see program details form disappear
##-----------------------EDIT PROGRAM ----------------------------
@EditProgram1
Scenario: Verify Edit option
When Admin clicks on Edit option for particular program
Then Admin lands on Program details form
@EditProgram2
Scenario: Verify title of the pop up window
When Admin clicks on Edit option for particular program
Then Admin should see window title as Program Details
@EditProgram
Scenario: Verify mandatory fields with red ASTERISK mark
When Admin clicks on Edit option for particular program
Then Admin should see red ASTERISK mark beside mandatory field Name
@EditProgram
Scenario: Verify edit Program Name
When Admin edits the program name and click on save button
Then Updated program name is seen by the Admin
@EditProgram
Scenario: Verify edit Description
When Admin edits the description text and click on save button
Then Admin can see the description is updated
@EditProgram
Scenario: Verify edit Status
When Admin can change the status of the program and click on save button
Then Status updated can be viewed by the Admin
@EditProgram
Scenario: Verify Admin is able to click Cancel
When Admin click on cancel button
Then Admin can see the Program details form disappear
@EditProgram
Scenario: Verify edited Program details
When Admin searches with newly updated Program Name
Then Admin verifies that the details are correctly updated.
@EditProgram
Scenario: Verify close the window with X
When Admin Click on X button
Then Admin can see the Program details form disappear
#--------------------------DELETE PROGRAM ---------------------------------------
@DeleteProgram1
Scenario: Verify delete feature
When Admin clicks on delete button for a program
Then Admin will get confirm deletion popup
@DeleteProgram2
Scenario: Verify Admin is able to click YES
And Admin clicks on delete button for a program
When Admin clicks on YES button
Then Admin can see Successful Program Deleted message
@DeleteProgram3
Scenario: Verify Admin is able to search deleted program
When Admin Searches for Deleted Program name
Then There should be zero results.
@DeleteProgram4
Scenario: Verify Admin is able to click NO
Given Admin is on Program Confirm Deletion Page after selecting a program to delete
When Admin clicks on NO button
Then Admin can see the Program details form disappear
@DeleteProgram5
Scenario: Verify Admin is able to close the window with X
Given Admin is on Program Confirm Deletion Page after selecting a program to delete
When Admin Click on X button of Confirm Delete window
Then Admin can see the Program details form disappear
@MultipleDelete
Scenario: Verify Admin is able to select multiple programs
When Admin selects more than one program by clicking on the checkbox
Then Programs get selected
@MultipleDelete
Scenario: Verify Admin is able to delete Multiple programs
Given Admin selects more than one program by clicking on the checkbox
When Admin clicks on the delete button on the left top of the program page
Then Admin will get confirm deletion popup
@MultipleDelete
Scenario: Verify Admin is able to click YES
Given Admin is on Program Confirm Deletion Page after selecting multiple program to delete
When Admin clicks on YES button
Then Admin can see Successful Program Deleted message
@MultipleDelete
Scenario: Verify Admin is able to deleted program
When Admin Searches for Deleted Program names
Then There should be zero results.
@MultipleDelete
Scenario: Verify Admin is able to click NO
When Admin clicks on NO button
Then Admin can see Programs are still selected and not deleted
@MultipleDelete
Scenario: Verify Admin is able to close the window with X
When Admin Click on X button of Confirm Delete window
Then Admin can see Confirm Deletion form disappear
#------------------------------SEARCH PROGRAM--------------------------------------
@Search1
Scenario: Verify Admin is able to search results found for program name
When Admin enter the program to search By program name
Then Admin should able to see Program name Description and Status for searched program name
@Search2
Scenario: Verify Admin is able to search results found for program description
When Admin enter the program to search By program description
Then Admin should able to see Program name Description and Status for searched program description
@Search3
Scenario: Verify Admin is able to search results not found
When Admin enter the program to search By program name that does not exist
Then There should be zero results.
@Search4
Scenario: Verify Admin is able to search with partial program name
When Admin enter the program to search By partial name of program
Then Admin should able to see partial Program name Description and Status for searched program name
#------------------------------SORTING PROGRAM--------------------------------------
@Sorting
Scenario: Verify sorting of Program name in Ascending order/Descending order
When Admin clicks on Arrow next to program Name
Then Admin See the Program Name is sorted in Ascending order/Descending order
When Admin clicks on Arrow next to program Name
Then Admin See the Program Name is sorted in Ascending order/Descending order
@Sorting
Scenario: Verify sorting of Program Description in Ascending order/Descending order
When Admin clicks on Arrow next to Program Description
Then Admin See the program Description is sorted in Ascending order/Descending order
When Admin clicks on Arrow next to Program Description
Then Admin See the program Description is sorted in Ascending order/Descending order
@Sorting
Scenario: Verify sorting of Program status in Ascending order/Descending order
When Admin clicks on Arrow next to Program status
Then Use See the Program Status is sorted in Ascending order/Descending order
When Admin clicks on Arrow next to Program status
Then Use See the Program Status is sorted in Ascending order/Descending order
#-----------------------------PAGINATION-------------------------------------
@Pagination
Scenario: Verify Admin is able to click Next page link
When Admin clicks Next page link on the program table
Then Admin should see the Pagination has NEXT active link
@Pagination
Scenario: Verify Admin is able to click Last page link
When Admin clicks Last page link
Then Admins should see the last page record on the table with Next page link are disabled
@Pagination
Scenario: Verify Admin is able to click Previous page link
When Admin clicks Previous page link
Then Admin should see the previous page record on the table with pagination has previous page link
@Pagination
Scenario: Verify Admin is able to click First page link
When Admin clicks First page link
Then Admins should see the very first page record on the table with Previous page link are disabled
@Pagination
Scenario: Verify count of Programs displayed in Footer Message
Then Count of programs in footer should match total programs
#-----------------------------------------------END------------------------------------------------------------------



















