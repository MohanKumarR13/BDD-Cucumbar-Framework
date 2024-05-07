Feature: Login to OrangeHRM 
Scenario Outline: login to OrangeHRM Live application in browser 

	Given You are on entering to login page landed in the browser 
	When Your valid credentials for user login "<username>" and "<password>" 
		
	And Click the login button action in the browser 
	Then You should navigating to home screen
	
	Examples:
	|username|password|
	|Admin |admin123|
	|Admin |admin123|