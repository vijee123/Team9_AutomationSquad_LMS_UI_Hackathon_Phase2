@login
Feature: Class Module 

Background: Admin logged on the Dashboard page  
   Given Admin launch the browser  
   When Admin gives the correct LMS portal URL  
   Then Admin should land on the login page  
   And Admin should land on dashboard page by passing login credential "ValidCredentials"

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
		|sheet	|testcase|
		|Sheet1	|validInputMandatory|
		
		