Feature: Condition Header Tab UI Verification

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
___________________________________________________________________________________________________________________

Background: perform Login
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then They check whether the application displays the Environment selection screen
And They select Region and check whether the Landing Page is displayed
Then User navigates from Landing page to "Condition" application
And They wait for the busy icon
Then They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
Then They click on "Conditions New"

Scenario: Verifying "Add a Condition" Breadcrumb
Then They check if "Add a Condition" displays

Scenario: Ensuring Default Enable of Header Tab
Then They check whether the "Conditions Header" is currently enabled

Scenario Outline: Verify labels in Header tab 
Given They determine whether "Condition Header" is currently showing by checking for "Tracking ID:"
Then They determine whether the following "<label>" are displayed in the Header panel

Examples:
 | label |
 | Tracking ID: |
 | Reason: |
 | Master customer set: |
 | Condition ID: |
 | Name: |
 | Status: |
 | Type: |
 
Scenario: Verify "Notes:" label in Header Panel
Given They determine whether "Condition Header" is currently showing by checking for "Tracking ID:"
Then They determine whether the "Notes:" is displayed in the Header panel

Scenario: Verify Next and Cancel buttons in Header tab
Given They determine whether "Condition Header" is currently showing by checking for "Tracking ID:"
Then They check whether Next and Cancel buttons are displayed


Scenario: Verifying Text Edit Fields in Header Panel
Given They determine whether "Condition Header" is currently showing by checking for "Tracking ID:"
Then They check if "Tracking ID:" displays
Then They check if "Reason:" displays
Then They check if "Condition ID:" displays
Then They check if "Name:" displays
Then They check if "Notes:" displays

Scenario: Verify Master customer set drop down list in Header tab
Given They determine whether "Condition Header" is currently showing by checking for "Tracking ID:"
Then They should be able to view contents of "Master customer set:"

Scenario: Verify prefix beside Condition ID edit field in Header tab
Given They determine whether "Condition Header" is currently showing by checking for "Tracking ID:"
Then User should be able to view the prefix "CD" in the "Condition ID prefix" field

Scenario: Verify Status drop down list in Header tab
Given They determine whether "Condition Header" is currently showing by checking for "Tracking ID:"
Then User should be able to view "Not Ready,Ready for Use,Do Not Use Anymore" options for "Status:" dropdown

Scenario: Verify Type drop down list in Header tab
Given They determine whether "Condition Header" is currently showing by checking for "Tracking ID:" 
Then User should be able to view "Single,Compound" options for "Type:" dropdown
