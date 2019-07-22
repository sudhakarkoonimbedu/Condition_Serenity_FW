Feature: Condition Reporting UI Verifcation for Field Admin Report Type

Background: performLogin
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then User navigates from Landing page to "Condition" application
When They check whether the "Condition Home" is displayed 
Then They click on "Reporting"

Scenario: Verifying whether Reporting tab is properly displayed
Then They determine if "Reporting" is showing by checking for "Report type:"

Scenario Outline: Verify the Reporting page fields
Given They determine if "Reporting" is showing by checking for "Report type:"
Then They check whether the following "<label>" are shown in the Reporting Panel

Examples:
 | label |
 | Report type |
 | Report format |
 | Report name | 
 
Scenario: Verify the Report Type dropdown list
Given They determine if "Reporting" is showing by checking for "Report type:"
Then They check whether "Report type:" dropdown list displays "Conditions Associations,Conditions Entity,Field Admin Usage,Sample Claim Test Data"

Scenario: Verify the Report Type Field Admin Usage
Given User is on Conditions Reporting page, they select "Field Admin Usage" for "Report type:"
Then "Report format:" must be displayed
Then "Report name:" must be displayed
Then "Field Admin Usage Criteria Panel" must be displayed

Scenario: Verify the Report format dropdown list
Given User is on Conditions Reporting page, they select "Field Admin Usage" for "Report type:"
Then They check whether "Report format:" dropdown list displays "PDF,Delimited"

Scenario: Verify the Field Admin Criteria Panel
Given User is on Conditions Reporting page, they select "Field Admin Usage" for "Report type:"
Then They check whether all of the correct fields are showing in the Field Admin Usage Panel

Scenario: Verify the Report,Reset buttons
Given User is on Conditions Reporting page, they select "Field Admin Usage" for "Report type:"
Then "Report Button for Field Admin Usage" must be displayed
Then "Reset Button for Field Admin Usage" must be displayed

Scenario: Verify the Status Dropdown list
Given User is on Conditions Reporting page, they select "Field Admin Usage" for "Report type:"
Then They check whether "Status for FAU" dropdown list displays "Not Ready,Ready for Use,Do Not Use Anymore"

Scenario: Verify Retained in history Dropdown list
Given User is on Conditions Reporting page, they select "Field Admin Usage" for "Report type:"
Then They check whether "Retained in history for FAU" dropdown list displays "Yes,No"

Scenario: Verify Include available Argus Master Checkbox
Given User is on Conditions Reporting page, they select "Field Admin Usage" for "Report type:"
Then "Include available Argus Master fields checkbox" must be displayed

