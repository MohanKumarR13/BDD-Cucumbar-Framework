Feature: Login 

Scenario: Sucessful Login with valid credentials 
	Given User launch  browser 
	When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" 
	And User enters the email as "admin@yourstore.com" and password as "admin" 
	And Click to Login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User click on Logout link 
	Then Page Title should be "Your store. Login" 
	And  close browser 
	
Scenario Outline: Login Data Driven
	Given User launch  browser 
	When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" 
	And User enters the email as "<email>" and password as "<password>" 
	And Click to Login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User click on Logout link 
	Then Page Title should be "Your store. Login" 
	And  close browser 
	
	Examples: 
		|email | password |
		|admin@yourstore.com | admin |
		|admin@yourstore1.com | admin123 |
     	