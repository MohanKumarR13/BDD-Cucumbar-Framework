@simpleLogin
Feature: Open Google 

Scenario: Open Google Scenario 
Given User entering google.co.in
When User enters "github"
And Enters the return key
Then user should see the result set
	