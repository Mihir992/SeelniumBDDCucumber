Feature: To test Login functionality

Scenario Outline: Test user Login with different credentials

Given user on the Login Page
When User enter the Usename "<username>" and Password "<password>"
Then User should be logged in successfully
When user click on Logoff icon
And click on Continue button
Then validate the Logout page title

Examples:
    | username   | password |
    | testadmin| admin |
