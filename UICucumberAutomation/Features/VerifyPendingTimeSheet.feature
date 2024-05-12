@Timesheets
Feature: Get the Timesheets from application
Scenario: Verify the Timesheets

	Given User on homepage
	When User Clicks on the time option from menu
	And User enters name as "John Doe"
	And click the view button
	
	Then user should see the message as "No Timesheets Found"
	