Feature: This is the login feature 
Scenario: login to application 

	Given User entering to login page 
	When User enters valid username and password 
	And Enters the login button 
	Then user should navigate to home page 
	