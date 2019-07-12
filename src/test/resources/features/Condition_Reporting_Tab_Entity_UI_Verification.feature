Feature: Condition Reporting UI Verifcation for Conditions Entity Report Type

Background:
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then They check whether the application displays the Environment selection screen
And They select Region and check whether the Landing Page is displayed
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

Scenario: Verify the Report Type Conditions Associations
Given User is on Conditions Reporting page, they select "Conditions Entity" for "Report type:"
Then "Report format:" must be displayed
Then "Report name:" must be displayed
Then "Entity Criteria Panel" must be displayed

Scenario: Verify the Report format dropdown list
Given User is on Conditions Reporting page, they select "Conditions Entity" for "Report type:"
Then They check whether "Report format:" dropdown list displays "PDF,Delimited,Mass Change Upload"

Scenario: Verify the buttons in the Entity Criteria Panel
Given User is on Conditions Reporting page, they select "Conditions Entity" for "Report type:"
Then "Remove Selected Tags Button for Entity" must be displayed
Then "Remove Selected Condition ID Button for Entity" must be displayed
Then "Report Button for Entity" must be displayed
Then "Reset Button for Entity" must be displayed

Scenario: Verifying Remove Selected and CD prefix
Given User is on Conditions Reporting page, they select "Conditions Entity" for "Report type:"
Then They check whether "Tags Add Button for Entity" is disabled
Then They check whether "Remove Selected Tags Button for Entity" is disabled
And They determine whether the "CD" prefix shows up in front of "Condition ID CD for Entity" field
And They check whether "Condition ID Table for Entity" displays "No records found."
And They check whether "Tags Table for Entity" displays "No records found."

Scenario: Verify the Application Type dropdown list
Given User is on Conditions Reporting page, they select "Conditions Entity" for "Report type:"
Then They check whether "Source for Entity" dropdown list displays "Field,Drug List,Pharmacy List,Prescriber List"

Scenario: Verify the Application Type dropdown list
Given User is on Conditions Reporting page, they select "Conditions Entity" for "Report type:"
Then They check whether "Type for Entity" dropdown list displays "Single,Compound"

Scenario: Verify the Application Type dropdown list
Given User is on Conditions Reporting page, they select "Conditions Entity" for "Report type:"
Then They check whether "Status for Entity" dropdown list displays "Not Ready,Ready for Use,Do Not Use Anymore"

Scenario: Verify the Application Type dropdown list
Given User is on Conditions Reporting page, they select "Conditions Entity" for "Report type:"
Then They check whether "Sub-status for Entity" dropdown list displays "Associated,Not Associated"

Scenario: Verify the Application Type dropdown list
Given User is on Conditions Reporting page, they select "Conditions Entity" for "Report type:"
Then They check whether "Sub-status for Entity" dropdown list displays "Associated,Not Associated"

Scenario: Verify the Tags edit field 
Given User is on Conditions Reporting page, they select "Conditions Entity" for "Report type:"
Then "Tags for Entity" must be displayed 

Scenario: Verify the Tags Table
Given User is on Conditions Reporting page, they select "Conditions Entity" for "Report type:"
Then They check whether "Tags Table for Entity" displays "No records found."
Then They check whether "Tags Table for Entity" displays "Tag Name"
Then "Tags check all for Entity" must be displayed

Scenario: Verify the Add button beside Condition ID and Tags edit fields
Given User is on Conditions Reporting page, they select "Conditions Entity" for "Report type:"
Then "Condition ID Add Button for Entity" must be displayed
Then "Tags Add Button for Entity" must be displayed