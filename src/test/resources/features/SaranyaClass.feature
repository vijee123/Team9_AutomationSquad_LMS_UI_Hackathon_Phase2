@login_Scenarios
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
