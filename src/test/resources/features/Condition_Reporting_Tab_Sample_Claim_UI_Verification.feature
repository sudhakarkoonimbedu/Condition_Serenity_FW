Feature: Condition Reporting UI Verifcation for Sample Claim Testdata Report Type

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

Scenario: Verify the Report Type Sample Claim Test data
Given User is on Conditions Reporting page, they select "Sample Claim Test Data" for "Report type:"
Then "Report format:" must be displayed
Then "Report name:" must be displayed
Then "Sample Claim Test Data Criteria Panel" must be displayed

Scenario: Verify the Report format dropdown list
Given User is on Conditions Reporting page, they select "Sample Claim Test Data" for "Report type:"
Then They check whether "Report format:" dropdown list displays "PDF,Delimited"

Scenario: Verify the Sample Claim Test Data Criteria Panel
Given User is on Conditions Reporting page, they select "Sample Claim Test Data" for "Report type:"
Then They check whether all of the correct fields are showing in the Sample Claim Test Data Criteria Panel

Scenario: Verifying Remove Selected and CD prefix
Given User is on Conditions Reporting page, they select "Sample Claim Test Data" for "Report type:"
Then They check whether "Coverage Code Add Button for Sample Claim" is disabled
Then They check whether "Remove Button for Sample Claim" is disabled
And They determine whether the "CD" prefix shows up in front of "Condition ID CD for Sample Claim" field
And They check whether "Coverage Code Table for Sample Claim" displays "No records found."

Scenario: Verify the Report,Reset buttons
Given User is on Conditions Reporting page, they select "Sample Claim Test Data" for "Report type:"
Then "Report Button for Sample Claim" must be displayed
Then "Reset Button for Sample Claim" must be displayed
