Feature: Verifying UI of Associations Tab After Creation of new Condition

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
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   |
 |	123456789954621  | Argus Master Customer Set |  00100461      | Samyu       | Ready for Use   | Single | 
Then They check if the "Details" is currently showing by checking for "Source:"
When They enter the following details data and press "Next"
 | Source        | Field Name | Operator       |      Value      |
 | Field         |    NDC     | Is the Same As |   00298157935   |
Then They click "Conditions Tags/Notes Save"
Then They wait for the busy icon

Scenario: Verify Enable of Associations Tab
Then They check whether the Associations is currently enabled after creating a condition
#
#Scenario: Verifying "Association(s)" display
#Given They click "Associations after Condition Creation"
#When They check if the "Associations after Condition Creation" is currently showing by checking for "Association(s)" after creating a condition
#
#Scenario: Verify the display of table labels in Associations Table
#Given They click "Associations after Condition Creation"
#Then They check if "Application type,Customer Set,ID,Priority,Start Date,End Date" are shown for "Associations Table"
#
#Scenario: Verify the display of the messages at the bottom of the page
#Given They click "Associations after Condition Creation"
#Then They verify the messages at the bottom of the page
