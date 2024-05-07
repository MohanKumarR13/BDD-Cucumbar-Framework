Feature: Login to OrangeHRM
Scenario: login to OrangeHRM Live application in browser 

	Given You are in entering to login page in the browser
	When Your valid credentials for login
	|username|password|
	|Admin |admin123|
	
	
		
	And Click the login button action
	Then You should navigating to home page screen