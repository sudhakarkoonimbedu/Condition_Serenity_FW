Feature: Condition Details Tab UI Verificaition

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
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   |
 |	123456789954621  | Argus Master Customer Set |  00100461      | Samyu       | Ready for Use   | Single | 

Scenario: Ensuring Default Enable of Header Tab
Then They check whether the "Conditions Header" is currently enabled

Scenario: Ensuring Disable of Tabs
Then They check if "Pre-Test" is disabled
Then They check if "Associations" is disabled

Scenario: User Creates Condition
Then They check if the "Details" is currently showing by checking for "Source:"
When They enter the following details data and press "Next"
 | Source        | Field Name | Operator       |      Value      |
 | Field         |    NDC     | Is the Same As |   00298157935   |
Then They click "Conditions Tags/Notes Save"

Scenario: User Deletes Condition
Given User navigates from Landing page to "Condition" application
Then User switches windows to most recent window
When They check whether the "Condition Home" is displayed
When User enters the following data into Condition Home Search Panel and presses "Conditions Search"
    | Master customer set               | Type       | Condition ID  | Name       |
    | Argus Master Customer Set         | Single     | 00100461      | Samyu      |
When They click "Conditions Header Delete"
Then They enter the following tracking id "123456789954621" and press "Conditions Header 2nd Delete"

Scenario Outline: User Ensures that the Conditions Details Tab contains Source, Field Name, Operator, and Value labels when Field is selected for Source
Given They check if the "Details" is currently showing by checking for "Source:"
When They specify "Field" for "Source:" 
Then They determine whether the following "<labels>" are displayed in the Details panel

Examples:
 | labels |
 | Field Name:|
 | Operator:|
 | Value:|

Scenario: Verify the item Field from Source dropdown list
Given They check if the "Details" is currently showing by checking for "Source:"
When They specify "Field" for "Source:"  
And They choose "NDC" as the field name and verify operator dropdown list displays the items "Is the Same As,Is Not the Same As"
Then They check if the "Value For Field" is currently showing by checking for "Value for Field"

Scenario: Verify the item Drug List from Source dropdown list
Given They check if the "Details" is currently showing by checking for "Source:"
When They specify "Drug List" for "Source:"
When They check if "Benefit customer set:" dropdown list displays list of existing Benefit customer set details
Then They verify the "Operator:" dropdown list displays the items "Is Included In,Is Not Included In"
Then They check if the "Value:" is currently showing by checking for "Value:"

Scenario: Verify the item Pharmacy List from Source dropdown list
Given They check if the "Details" is currently showing by checking for "Source:"
When They specify "Pharmacy List" for "Source:"
Then They verify the "Operator:" dropdown list displays the items "Is Included In,Is Not Included In"
Then They check if the "Value:" is currently showing by checking for "Value:"

Scenario: Verify the item Prescriber List from Source dropdown list 
Given They check if the "Details" is currently showing by checking for "Source:"
When They specify "Prescriber List" for "Source:"
Then They verify the "Operator:" dropdown list displays the items "Is Included In,Is Not Included In"
Then They check if the "Value:" is currently showing by checking for "Value:"

Scenario: Verify the display of Upper Row of Previous, Next, and Cancel buttons
Given They check if the "Details" is currently showing by checking for "Source:"
Then They check if the "PreviousU" is currently showing by checking for "PreviousU"
Then They check if the "NextU" is currently showing by checking for "NextU"
Then They check if the "CancelU" is currently showing by checking for "CancelU"

Scenario: Verify the display of Lower Row of Previous, Next, and Cancel buttons
Given They check if the "Details" is currently showing by checking for "Source:"
Then They check if the "PreviousD" is currently showing by checking for "PreviousD"
Then They check if the "NextD" is currently showing by checking for "NextD"
Then They check if the "CancelD" is currently showing by checking for "CancelD"