Feature: This is a fearture where we are practiving parameterization

Scenario: parameterizing the single step
	Given I have numbers 1 and 16
	When I add them
	Then check if the result is prime



Scenario: accept word as parameter
	Given I have first name piyush
	Then print the first name

	
Scenario Outline: This is my first DDT case
	Given I have <pincodes><Cityname>
	Then print the <Cityname>
Examples:
	|pincodes|Cityname|
	|'433113'|'amravati'|
	|'433133'|'nagpur'|
	|'433151'|'nashik'|
	|'433411'|'kolhapur'|
	|'439111'|'khandala'|
	|'433811'|'thane'|
	
	
	
	
	
	
	
	
	
	
	
	
	
	
