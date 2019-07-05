Feature: Condition Details Tab UI Verification for Compound Condition

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
"Conditions Header" -- Header tab (default tab) when New Button is clicked
"Details" -- Details tab when New Button is clicked
__________________________________________________________________________________________________________

Background:
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then They check whether the application displays the Environment selection screen
And They select Region and check whether the Landing Page is displayed
Then User navigates from Landing page to "Condition" application
When They check whether the "Condition Home" is displayed 
Then They click on "Conditions New"
Then They check if the "Conditions Header" is currently showing by checking for "Tracking ID:"
When They enter the following header data and press "Next"
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type     |
 |	123456789954621  | Argus Master Customer Set |  00100461      | Samyu       | Ready for Use   | Compound | 

Scenario Outline: Navigate to Condition Details Tab
Given User is on Condition Header tab
When Provide required data and click on Next button
 | Tracking ID   | Master customer set   | Condition ID   | Name      | Status   | Type   |
 | <Tracking_ID> | <Master_customer_set> | <Condition_ID> | <CD_name> | <status> | <type> | 
Then Condition Details <tab> should display

Examples: 
|Tracking_ID  | Master_customer_set   | Condition_ID   | CD_name  |status       |type       |
|123456789456 | <Master_customer_set> | <Condition_ID> |<CD_name> |<status>     |Compound   |


Scenario: Verify the Compound Operator, Condition ID labels
Given User is on Conditions Details Tab
When verify Compound Operator, Condition ID labels
Then Compound Operator, Condition ID labels should display

@ConditionDetailsTabUserInterface7

Scenario: Verify the Compound Operator dropdown list

Given User is on Conditions Details Tab
When verify Compound Operator dropdown list
Then Compound Operator dropdown list should display the items "OR", "AND"

@ConditionDetailsTabUserInterface8

Scenario: Verify prefix beside Condition ID edit field

Given User is on Conditions Details Tab
When verify Condition ID prefix
Then prefix CD should display beside Condition ID edit field

@ConditionDetailsTabUserInterface9

Scenario: Verify Add button

Given User is on Conditions Details Tab
When verify Add button
Then Add button should display

@ConditionDetailsTabUserInterface10

Scenario: Verify Compound conditions table

Given User is on Conditions Details Tab
When verify Compound conditions table
Then Compound conditions table should display the columns Condition ID and Condition Name

@ConditionDetailsTabUserInterface11

Scenario: Verify the checkbox in Compound conditions table

Given User is on Conditions Details Tab
When verify checkbox in Compound conditions table
Then checkbox should display before the columns Condition ID and Condition Name

@ConditionDetailsTabUserInterface12

Scenario: Verify the message "Conditions Included In Compound" in Compound conditions table

Given User is on Conditions Details Tab
When verify the message
Then message "Conditions Included In Compound" should display in Compound conditions table

@ConditionDetailsTabUserInterface13

Scenario: Verify the Remove Selected buton in Compound conditions table

Given User is on Conditions Details Tab
When verify the  Remove Selected buton
Then  Remove Selected buton should be disabled by default

@ConditionDetailsTabUserInterface14

Scenario: Verify the display of Previous, Next and Cancel buttons

Given user is on Conditions Details Tab
When verify Previous, Next and Cancel buttons
Then Previous, Next and Cancel buttons should display at the top right corner and bottom right corner in Details tab
