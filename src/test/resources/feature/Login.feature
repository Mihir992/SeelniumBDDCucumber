Feature:To test Login functionality

@TestngTest
Feature:To test Login functionality


Scenario Outline: Test user Login with different credentials

Given user on the Login Page
When valid "<username>" and "<password>" is entered
Then User should be logged in successfully

Examples:
    | username   | password |
    | testadmin | Test@123 |
    | testadmin| admin |
