Feature: Condition Home UI Verification

HashMap is implemented to create an association between WebElements and xpaths; the following are the strings used to create the association between items on page and corresponding xpaths.
Strings inputs are case-sensitive. 
Legend for WebElements:
"Condition Home"  -- Condition Home Tab
"Conditions Home Breadcrumb" -- located top left corner of contentFrame
"Condition Home Icon" -- house icon located top left corner of contentFrame
"Master customer set:" -- MCS dropdown list
"Type:" -- Type dropdown list
"Condition Id" -- Condition ID text edit field
"Name:" -- Name text edit field
"Status:" -- Status dropdown list
"Source:" -- Source dropdown list
"Advanced Search" -- Advanced Search link below Source dropdown
"Sub-status:" -- Sub-status dropdown list (displayed once Advanced Search is clicked)
"Tags:" -- Tags text edit field (displayed once Advanced Search is clicked)
"Add" -- Add Button (displayed once Advanced Search is clicked)
"Tags Table" -- table that is displayed once Advanced Search is clicked
"Tag Check Box" -- Check Box located in top left corner of Tags Table
"Remove Selected" -- Button located below Tags Table Check Box
"Conditions Search" -- Search Button
"Conditions Reset" -- Reset Button 
"Conditions New" -- New Button in top right corner of Condition Home Tab
"Results Panel" -- Panel to the right of Search; xpath points to text reading "Results"

____________________________________________________________________________________________________________

Background: User Performs Login
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then User navigates from Landing page to "Condition" application

Scenario: User Checks Breadcrumb display
When They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
And They check whether the "Condition Home Breadcrumb" is displayed
Then They check whether the "Condition Home Icon" is displayed

Scenario: User Determines Visibility of Search Panel; Checking for default blank
When They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
Then They check whether dropdown current selected option for "Master customer set:" displays ""
And They check whether dropdown current selected option for "Type:" displays ""
And They check whether field "Condition ID:" displays ""
And They check whether field "Name:" displays ""
And They check whether dropdown current selected option for "Source:" displays ""
And They check whether dropdown current selected option for "Status:" displays "Ready for Use"

Scenario Outline: User Verifies the Fields in the Search Panel
When They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
Then They should be able to view the the following "<label>" in the Search Panel

Examples:
	| label |
	| Master customer set | 
	| Type |
	| Condition ID |
	| Name |
	| Status |
	| Source |
	
Scenario: User Verifies MCS dropdown
When They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
Then They should be able to view the available contents of "Master customer set:" 

Scenario: User Verifies Type dropdown
When They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
Then They should be able to view "Single,Compound" contents for "Type:"

Scenario: User Verifies Status dropdown
When They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
Then They should be able to view "Not Ready,Ready for Use,Do Not Use Anymore" contents for "Status:"

Scenario: User Verifies Source dropdown
When They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
Then They should be able to view "Field,Drug List,Pharmacy List,Prescriber List" contents for "Source:"

Scenario: User Verifies functionality of text edit fields
When They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
Then User is able view the prefix "CD" in the "Condition ID CD" field
And They check whether "Name:" field is clickable
And They check whether "Condition ID:" field is clickable

Scenario: User Checks Existence of Advanced Search link 
When They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
Then They check whether the "Advanced Search" is displayed 

Scenario Outline: User Verifies Sub-Status and Tag Labels in Search Panel
Given They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
When They click on "Advanced Search"
Then They should be able to view the the following "<label>" in the Search Panel

Examples:
| label |
| Sub-status |
| Tags |
 
Scenario: User Verifies Drop Down List functionality for Sub-Status
Given They check whether "Condition Home" is currently showing by checking for "Advanced Search"
When They click on "Advanced Search"
Then They should be able to view "Associated,Not Associated" contents for "Sub-status:"

Scenario: User Verifies Tags Edit in Search Panel
Given They check whether "Condition Home" is currently showing by checking for "Advanced Search"
When They click on "Advanced Search"
Then They check whether the "Tags:" is displayed

Scenario: User Determines Whether Tags Table displays correctly
Given They check whether "Condition Home" is currently showing by checking for "Advanced Search"
When They click on "Advanced Search"
Then They check whether the "Tags Table" is displayed
Then They check whether "Tags Table" contains "Tag Name"
Then They check whether "Tags Table" contains "No records found."

Scenario: User Verifies Check Box display for Tags Table
When They click on "Advanced Search"
Then They check whether the "Tag Check Box" is displayed

Scenario: User Checks Whether Add Button is enabled
When They click on "Advanced Search"
Then They check whether "Add" field is clickable

Scenario: User Verifies Remove Selected Button in Search Panel
When They click on "Advanced Search"
Then "Remove Selected" should be disabled
 
Scenario: User Verifies Search and Reset Buttons
When They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
Then They check whether the "Conditions Search" is displayed
#Checking whether search button is displayed
Then They check whether the "Conditions Reset" is displayed
#Checking whether reset button is displayed

Scenario: User Verifies New Button
When They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
Then They check whether the "Conditions New" is displayed
#Checking whether new button is displayed

Scenario: User Verifies Results Panel
When They check whether "Condition Home" is currently showing by checking for "Advanced Search"
Then They check whether the "Results Panel" is displayed