Feature:To test Login functionality

Scenario: Verify page title functionality 
Given user on the Login Page
Then Verify page title "Account Login"

Scenario: Verify login functionality with valid credentials
Given user on the Login Page
When user enters username "testadmin" and password "admin"   
And user clicks on Login button
Then verify page title "My Account" 