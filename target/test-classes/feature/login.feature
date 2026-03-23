
Feature:Login
Scenario:Login valid credentials

Given I am on the Login Page 
When i enter the valid username "<username>" and password "<password>"
When i click the Login button 
Then the user can see the successful message

Examples:

|username|password|
|student|Password123|
