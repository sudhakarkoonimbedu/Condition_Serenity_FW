Feature: Verifying UI of Associations Tab After Creation of new Condition (Test cases only refer to Single Condition Type)

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
 |	212154651321468  | Argus Master Customer Set |  00846512      | trsgf       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   89754612315   | 
 |	987654321985462  | Argus Master Customer Set |  95432179      | ddfas       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   54689745612   |
 |	456132187656453  | Argus Master Customer Set |  31321864      | ghisk       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   78946541321   |
 |	654321657987651  | Argus Master Customer Set |  65513157      | lkdfe       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   81213548774   |

Scenario: Verify Enable of Associations Tab
Given The user creates a condition with the following data
 | Tracking ID       | Master customer set       | Condition ID   | Name        | Status          | Type   | Source        | Field Name | Operator       |      Value      |
 |	212154651321468  | Argus Master Customer Set |  00846512      | trsgf       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   89754612315   | 
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
 |	212154651321468  | Argus Master Customer Set |  00846512      | trsgf       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   89754612315   | 
 |	987654321985462  | Argus Master Customer Set |  95432179      | ddfas       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   54689745612   |
 |	456132187656453  | Argus Master Customer Set |  31321864      | ghisk       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   78946541321   |
 |	654321657987651  | Argus Master Customer Set |  65513157      | lkdfe       | Ready for Use   | Single | Field         |    NDC     | Is the Same As |   81213548774   |