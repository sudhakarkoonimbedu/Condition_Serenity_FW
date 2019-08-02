Feature: Condition Pre-Test Tab UI Verification (Test cases only refer to Single Condition Type)

Background:
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then User navigates from Landing page to "Condition" application
When They check whether the "Condition Home" is displayed 
Then They click on "Conditions New"
Then They check if the "Conditions Header" is currently showing by checking for "Tracking ID:"

Scenario Outline: Delete the created conditions
Given The user searches conditions with the following data and deletes them
 | Tracking ID       | Master customer sset       | Condition ID   | Name        | Status          | Type   | Source        | Field Name   |  Operator       |      Value      |
 |	<Tracking ID>    | <Master customer set>      | <Condition ID> | <Name>      | <Status>        | <Type> | <Source>      | <Field Name> | <Operator>      |      <Value>    |
 
Examples:
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	654319873204562  | Argus Master Customer Set |  78946182      | asdfa       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   98753215465   |  
 |	987613210213546  | Argus Master Customer Set |  45123248      | styur       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   56454123218   | 
 |	855133455656784  | Argus Master Customer Set |  21563489      | oiuol       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   25651321848   | 
 |	984454651322155  | Argus Master Customer Set |  98756426      | yungf       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   43567852565   |
 |	184652132654651  | Argus Master Customer Set |  89754621      | iponm       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   77757758483   |

Scenario: Verify the enable of the Pre-Test tab
Given The user creates a condition with the following data
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	654319873204562  | Argus Master Customer Set |  78946182      | asdfa       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   98753215465   |  
Then They check whether the Pre-Test is enabled after creating a condition

Scenario: Verify the display of Pre-Test Condition Definition
Given The user creates a condition with the following data
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	987613210213546  | Argus Master Customer Set |  45123248      | styur       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   56454123218   | 
When They click "Pre-Test after Condition Creation"
Then They check if the "Pre-Test after Condition Creation" is currently showing by checking for "Condition Definition" after creating a condition

Scenario: Verify the display of label for Pre-Test Condition(s) to be evaluated  
Given The user creates a condition with the following data
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	855133455656784  | Argus Master Customer Set |  21563489      | oiuol       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   25651321848   | 
When They click "Pre-Test after Condition Creation"
Then They verify whether "Condition Pre-Test Message" properly displays "Please enter data for the following condition(s) to be evaluated:"

Scenario: Verify the display of the Pre-Test Condition(s) to be evaluated fields
Given The user creates a condition with the following data
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	984454651322155  | Argus Master Customer Set |  98756426      | yungf       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   43567852565   | 
When They click "Pre-Test after Condition Creation"
Then They check if "Condition ID,Definition,Field Requiring Input,<Enter Test Data>" are shown for "Pre-Test Table"

Scenario: Verify the display of Evaluate button
Given The user creates a condition with the following data
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	184652132654651  | Argus Master Customer Set |  89754621      | iponm       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   77757758483   | 
Given They click "Pre-Test after Condition Creation"
Then They check whether the "Evaluate Button" is currently enabled and delete

Scenario Outline: Delete the created conditions
Given The user searches conditions with the following data and deletes them
 | Tracking ID       | Master customer sset       | Condition ID   | Name        | Status          | Type   | Source        | Field Name   |  Operator       |      Value      |
 |	<Tracking ID>    | <Master customer set>      | <Condition ID> | <Name>      | <Status>        | <Type> | <Source>      | <Field Name> | <Operator>      |      <Value>    |
 
Examples:
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	654319873204562  | Argus Master Customer Set |  78946182      | asdfa       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   98753215465   |  
 |	987613210213546  | Argus Master Customer Set |  45123248      | styur       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   56454123218   | 
 |	855133455656784  | Argus Master Customer Set |  21563489      | oiuol       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   25651321848   | 
 |	984454651322155  | Argus Master Customer Set |  98756426      | yungf       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   43567852565   |
 |	184652132654651  | Argus Master Customer Set |  89754621      | iponm       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   77757758483   |
   