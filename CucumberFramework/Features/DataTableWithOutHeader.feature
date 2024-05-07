Feature: Login to OrangeHRM
Scenario: login to OrangeHRM Live application in browser 

	Given You are on entering to login page in the browser
	When Your valid credentials 
	|Admin | 
	|admin123|
	And Click the login button 
	Then You should navigating to home page