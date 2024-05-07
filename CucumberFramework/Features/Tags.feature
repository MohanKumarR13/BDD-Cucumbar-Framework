@simpleLogin @login
Feature: login feature 
@Positive
Scenario: Valid login to application 

	Given User enters login 
	When User enter a username with password 
	And Enter  login button action
	

@Negative
Scenario: Invalid login to application 

	Given User enters login 
	When User enter a username with password 
	And Enter  login button action 
	 
	