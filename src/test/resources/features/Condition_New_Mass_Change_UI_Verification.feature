Feature: UI Validations for Creating a Mass Change

Background: User Performs Login
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then They check whether the application displays the Environment selection screen
And They select Region and check whether the Landing Page is displayed
Then User navigates from Landing page to "Condition" application
Then They click on "Mass Change"
Then They check if "Mass Change" is displaying by checking for "Mass Change Search Panel"
Then They press "New"

Scenario: Verify labels in New Mass Change Request screen
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
Then The determine whether "New Mass Change Panel" contains "Tracking ID,Reason,Notes,Master customer set,Name,Type,Status,Description"

Scenario: Verify the buttons Submit and Cancel in New Mass Change Request screen
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
Then "Submit Button" should display
Then "Cancel Button" should display

Scenario Outline: Create a New Mass Change Request
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When below details are provided and click on Submit button
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking_ID> |<Reason>   |<Notes>|<Master_customer_set>|<Name>|<Type>|<Status> |<Description>|
Then New Mass Change should be added

Examples: 
       |Tracking ID   |  Reason   | Notes | Master customer set |Name     | Type        | Status  |Description |
       |<165 >        |<Test>     |<Test> |<Humana>             |<Supprot>|<Mass Change>|<Pending>|   <Testing>|

Scenario: Verify the New Mass Change submitted data in Request tab
Given User is on Request tab 
When verify the New Mass Change submitted data displays
Then submitted data for Master Customer set, Request Name, Request Type,Request Status,Tracking ID,Reason,Notes,Description,Created by,created date,created time,Last maintenance user,Last maintenance date,Last maintenance time should display 

Scenario: Verify the button Cancel displays for New Mass Change submitted data in Request tab
Given User is on Request tab 
When verify the New Mass Change submitted data displays
Then button Cancel should display at the bottom

Scenario: Verify the display of submitted Mass Change conditions in Entries tab
Given User is on Entries tab 
When verify the submitted Mass Change conditions
Then all the submitted Mass Change conditions should display

Scenario: Verify the tabs Edit, Action and Reporting displays in New Mass Change Request screen
Given User is on Condition New Mass Change Request page 
When  verify tabs Edit, Action and Reporting displays in New Mass Change Request page
Then tabs Edit, Action and Reporting should display

Scenario: Verify the options: Run Preliminary, Run Final, Rerun, Unlock request, Stop, Restart, Cancel Request and Delete Request displays in Action tab  for the submitted New Mass Change Request 
Given User is on Condition New Mass Change Request page 
When  verify the options in Action tab
Then options: Run Preliminary, Run Final, Rerun, Unlock request, Stop, Restart, Cancel Request and Delete Request should display in Action tab

Scenario: Verify the options Preliminary and Final displays in Reporting tab for the submitted New Mass Change Request 
Given User is on Condition New Mass Change Request page 
When  verify the options in Reporting tab
Then options Preliminary and Final should display in Reporting tab

Scenario: Verify the submitted Mass Change Reports in Browse Requests page
Given User is on Browse Requests page
When verify the submitted Mass Change Reports
Then submitted Mass Change Reports should display in Browse Requests page

Scenario: Verify the Request Type dropdown list in Browse Requests page
Given User is on Browse Requests page
When verify the Request Type dropdown list
Then Request Type dropdown list should display the reports Conditions Entity Report, Conditions Associations Report, Sample Claim Testdata Report, Conditions Field Admin usage Report,Conditions Mass Change, Conditions Mass Change Upload,Conditions Mass Change Upload Report, Conditions Mass Change Preliminary,Conditions Mass Change Final,Conditions Mass Change Preliminary Report andConditions Mass Change Final Report

Scenario: Verify the Refresh button in Browse Requests page
Given User is on Browse Requests page
When verify the Refresh button
Then Refresh button should display at the top right corner in Browse Requests page

Scenario: Verify the Close button in Browse Requests page
Given User is on Browse Requests page
When verify the Close button
Then Close button should display at the bottom right corner in Browse Requests page

Scenario: Verify the Delete button in Browse Requests page
Given User is on Browse Requests page
When verify the Delete button
Then Delete button should be disabled and display at the bottom left corner in Browse Requests page

Scenario: Verify the submitted Conditions Mass Change Reports in Browse Requests page
Given User is on Browse Requests page
When verify the Check box icon displays before each report, Reports display in type pdf format and Delete link exists for each Report
Then Check box icon should display before each report, Reports should display in type pdf format and Delete link should exist for each Report


