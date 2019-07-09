Feature:  Advance Search.

Background: performLogin

Given User access the RxNova Application
      | userid   | d217068 |
      | password | stage12 |
      | region   | DR1     |


Scenario Outline: Navigate to Conditions Page

Given user verifies Landing Page
When Click on "Plan Setup" and selects "Conditions" from menu
Then Condition Home Page should display

Scenario Outline: Search existing conditions 
Given User is on Condition Home Page     
When search for the existing condition with below details and click on Advance search
      | mastercustomerset | <MCS>          |
      |type               | <Type>         |
      |Condition ID       |<Condition_ID>  |
      |Condition name     |<Condition_Name>| 
      |status             |<Status>        |
      |source             |<Source>        | 
     
Then Advance search fields should dispaly
 
 Examples: 
     |  MCS      | Type   | Condition_ID | Condition_Name | Status| Source |
     | testshy   |        |              |                |       |        |

Scenario Outline: Search existing conditions with advance search
Given User is on Condition Home Page
When sub-status data is selected 
     |sub-status|<Sub_Status|
     
Then selected sub-status shoud display
Examples:

     |Sub_Status|
     |Associated|

Scenario Outline: Enter the Tags
Given User is no Condition Home Page
When data is entered in Tag filed and click on Add button
 |tags|<Tags>|
Then Tag should display in Tag Name table

Examples:
   |Tags|
   |123 |

Scenario Outline: Click on Search Button
Given User is on Condition Home page
When click on Search Button
Then Existion conditions should display in Results 