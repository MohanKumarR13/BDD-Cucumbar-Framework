Feature: Customers 
Background: Below are common points for every scenarios 
	Given User launch  browser 
	When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" 
	And User enters the email as "admin@yourstore.com" and password as "admin" 
	And Click to Login 
	Then User can view Dashboad 
@santiy 
Scenario: Add new Customer 

	When User click on customers Menu 
	And click on customers Menu Item 
	And click on Add new button 
	Then User can view Add new customer page 
	When User enter customer info 
	And click on Save button 
	Then User can view confirmation message "The new customer has been added successfully." 
	And  close browser 
	
@regression 
Scenario: Search Customer by EMailID 

	When User click on customers Menu 
	And click on customers Menu Item 
	And Enter customer EMail 
	When Click on search button 
	Then User should found Email in the Search table 
	And close browser 
	
@regression 
Scenario: Search Customer by Name 
	When User click on customers Menu 
	And click on customers Menu Item 
	And Enter customer FirstName 
	And Enter customer LastName 
	When Click on search button 
	Then User should found Name in the Search table 
	And close browser 