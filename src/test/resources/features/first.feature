Feature: User Management

Scenario: verify If  NameOf Already Created  User Popuplates In List

	#Given application url is launched
	And User is logged into system
	When User clicks on PIM Menu
	And Clicks on Add button
	And Creates one user with valid details
	When user clicks on admin menu
	And Clicks on Add button on user management page
	When user selects role as ESS
	And clicks types employee name
	Then populated list must contains newly created user's name
	#Then close
	
	
	
	
	
