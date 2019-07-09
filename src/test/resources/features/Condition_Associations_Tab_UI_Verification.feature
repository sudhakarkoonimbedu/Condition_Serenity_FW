Feature: Verifying UI of Associations Tab After Creation of new Condition (Test cases only refer to Single Condition Type)

If running this in parallel with another Feature that creates a condition, ensure that the Condition data is different!

Background:
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then They check whether the application displays the Environment selection screen
And They select Region and check whether the Landing Page is displayed
Then User navigates from Landing page to "Condition" application
When They check whether the "Condition Home" is displayed 
Then They click on "Conditions New"
Then They check if the "Conditions Header" is currently showing by checking for "Tracking ID:"

Scenario: Verify Enable of Associations Tab
Given The user creates a condition with the following data
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	123456789954621  | Argus Master Customer Set |  00100461      | Samyu       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   00298157935   | 
Then They check whether the Associations is currently enabled after creating a condition
 
Scenario: Verifying "Association(s)" display
Given The user creates a condition with the following data
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	987654321985462  | Argus Master Customer Set |  95432179      | ddfas       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   54689745612   | 
When They click "Associations after Condition Creation"
When They check if the "Associations after Condition Creation" is currently showing by checking for "Association(s)" after creating a condition

Scenario: Verify the display of table labels in Associations Table
Given The user creates a condition with the following data
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	456132187656453  | Argus Master Customer Set |  31321864      | ghisk       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   78946541321   | 
When They click "Associations after Condition Creation"
Then They check if "Application type,Customer Set,ID,Priority,Start Date,End Date" are shown for "Associations Table"

Scenario: Verify the display of the messages at the bottom of the page
Given The user creates a condition with the following data
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	654321657987651  | Argus Master Customer Set |  65513157      | lkdfe       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   81213548774   |
Given They click "Associations after Condition Creation"
Then They verify the messages at the bottom of the page

Scenario Outline: Delete the created conditions
Given The user searches conditions with the following data and deletes them
 | Tracking ID       | Master customer sset       | Condition ID   | Name        | Status          | Type   | Source        | Field Name   |  Operator       |      Value      |
 |	<Tracking ID>    | <Master customer set>      | <Condition ID> | <Name>      | <Status>        | <Type> | <Source>      | <Field Name> | <Operator>      |      <Value>    |
 
Examples:
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	123456789954621  | Argus Master Customer Set |  00100461      | Samyu       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   00298157935   | 
 |	987654321985462  | Argus Master Customer Set |  95432179      | ddfas       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   54689745612   |
 |	456132187656453  | Argus Master Customer Set |  31321864      | ghisk       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   78946541321   |
 |	654321657987651  | Argus Master Customer Set |  65513157      | lkdfe       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   81213548774   |