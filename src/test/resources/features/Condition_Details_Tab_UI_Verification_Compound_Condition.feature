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
Then User navigates from Landing page to "Condition" application
When They check whether the "Condition Home" is displayed 
Then They click on "Conditions New"
Then They check if the "Conditions Header" is currently showing by checking for "Tracking ID:"
When They enter the following header data and press "Next"
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type     |
 |	123456789954621  | Argus Master Customer Set |  00100461      | Samyu       | Ready for Use   | Compound | 

Scenario Outline: Verify the Compound Operator, Condition ID labels
Given They ensure that they are on "Details" by checking for "Compound Operator:"
Then They check whether "<label>" is displayed in the Details Panel

Examples:
 | label |
 | Compound Operator |
 | Condition ID |

Scenario: Verify the Compound Operator dropdown list
Given They ensure that they are on "Details" by checking for "Compound Operator:"
Then They determine whether the "Compound Operator:" dropdown list contains "AND,OR" options

Scenario: Verify prefix beside Condition ID edit field
Given They ensure that they are on "Details" by checking for "Compound Operator:"
Then prefix "CD" should display beside "Condition ID CD" edit field

Scenario: Verify Add button
Given They ensure that they are on "Details" by checking for "Compound Operator:"
Then They ensure that "Add Button" is displayed

Scenario: Verify Compound conditions table
Given They ensure that they are on "Details" by checking for "Compound Operator:"
Then They ensure that "Condition ID,Condition Name" are shown for "Condition Table"

Scenario: Verify the checkbox in Compound conditions table
Given They ensure that they are on "Details" by checking for "Compound Operator:"
Then They ensure that "Condition Table Checkbox" is displayed

Scenario: Verify the message "Conditions Included In Compound" in Compound conditions table
Given They ensure that they are on "Details" by checking for "Compound Operator:"
Then They ensure that "Conditions Included In Compound" is displayed

Scenario: Verify the Remove Selected button in Compound conditions table
Given They ensure that they are on "Details" by checking for "Compound Operator:"
Then  They ensure that "Remove Selected" is disabled by default

Scenario: Verify the display of Upper Previous, Next and Cancel buttons
Given They ensure that they are on "Details" by checking for "Compound Operator:"
Then They ensure that "PreviousU" is displayed
Then They ensure that "NextU" is displayed
Then They ensure that "CancelU" is displayed

Scenario: Verify the display of Lower Previous, Next and Cancel buttons
Given They ensure that they are on "Details" by checking for "Compound Operator:"
Then They ensure that "PreviousD" is displayed
Then They ensure that "NextD" is displayed
Then They ensure that "CancelD" is displayed
