@GetCFOName 
Feature: Get the CEO Name from application 
Scenario: Verify the CEO name 

	Given User entering to login page in the browser 
	When User Clicks on directory option from menu bar 
	And Select the job title as "Chief Executive Officer" from employeename
	And click the search button 
	
	Then user should see the CFO name as "John Doe"
	