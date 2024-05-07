Feature: Login to OrangeHRM
Scenario: login to OrangeHRM Live application in browser 

	Given User entering to login page in the browser
	When Entering valid credentials "Admin" and "admin123" 
	And Press login button 
	Then user should navigating to home page 
	