Feature: Condition Tags/Notes Tab UI Verification

Background:
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then User navigates from Landing page to "Condition" application
When They check whether the "Condition Home" is displayed 
Then They click on "Conditions New"
Then They check if the "Conditions Header" is currently showing by checking for "Tracking ID:"
When They enter the following header data and press "Next"
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   |
 |	846543113224679  | Argus Master Customer Set |  00875432      | jfakfg      | Ready for Use   | Single | 
Given They check if the "Details" is currently showing by checking for "Source:"
When They enter the following details data and press "Next"
 | Source        | Field Name | Operator       |      Value      |
 | Field         |    NDC     | Is the Same As |   00845123218   |
Then They check if the "Tags/Notes" is currently showing by checking for "Tags Panel"

Scenario: Verify Tags edit field  
Given They check if the "Tags/Notes" is currently showing by checking for "Tags Panel"
Then They verify that "Tag Input Field" is displayed

Scenario: Verify the message "No records found" displays for Tags table   
Given They check if the "Tags/Notes" is currently showing by checking for "Tags Panel"
Then They verify whether "Tags Table" displays "No records found."

Scenario: Verify Add button beside Tags edit field  
Given They check if the "Tags/Notes" is currently showing by checking for "Tags Panel"
Then They verify that "Add Button" is displayed

Scenario: Verify Remove Selected button  
Given They check if the "Tags/Notes" is currently showing by checking for "Tags Panel"
Then They determine whether "Remove Selected Button" is disabled

Scenario: Verify Check box displays for Tags table  
Given They check if the "Tags/Notes" is currently showing by checking for "Tags Panel"
Then They verify that "Checkbox" is displayed

Scenario: Verify the display of Previous,Save and Cancel buttons
Given They check if the "Tags/Notes" is currently showing by checking for "Tags Panel"
Then They verify that "Previous" is displayed
And They verify that "Save" is displayed
And They verify that "Cancel" is displayed

Scenario: Verify the display of Notes Textbox
Given They check if the "Tags/Notes" is currently showing by checking for "Tags Panel"
Then They verify that "Notes" is displayed



















