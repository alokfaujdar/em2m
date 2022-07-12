@LoginPage
Feature: Login Page Test 
	In order to test functionality of Login page
	We will test different combination of credentials to test the login functionality


@LoginPage_LoginPageLoad
Scenario: Scenario_01 Wait for login page to Load Successfully
	Given Launch the URL do the necessary initializations
	Then Verify User is on login page

@LoginPage_LoginPage_InvalidCredentials
Scenario: Scenario_02 Verify the un successful login with invalid credentials
	Given Verify User is on login page
	When We are on login page and we use invalid username and password for login
		| username 			| password               |
		| invalidUsername	| invalidPassword	     |
	Then Verify the login error message "Invalid username or password. Please try again."

@LoginPage_LoginPageSuccessfulLogin
Scenario: Scenario_03 Verify the successful login with valid credentials
	Given Verify User is on login page
	When We are on login page and we use valid username and password for login
		| username 					            | password      |
		| divya.bika@faberwork.com          	| Testfaber123!	|
	Then Verify the user is successfully logged in
	Then Logout
	
	
