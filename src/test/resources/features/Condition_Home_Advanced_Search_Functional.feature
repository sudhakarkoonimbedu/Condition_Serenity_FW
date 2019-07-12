Feature:  Verification of Advanced Search Functionality

Background: perform Login
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then They check whether the application displays the Environment selection screen
And They select Region and check whether the Landing Page is displayed
Then User navigates from Landing page to "Condition" application
And They wait for the busy icon
Then They check whether "Condition Home" is currently showing by checking for "Advanced Search" 
Then They click on "Conditions New"

Scenario Outline: Search existing conditions 
Given User is on Condition Home Page     
When search for the existing condition with below details and click on Advance search
      
      |Master Customer Set | <MCS>            |
      |type                | <Type>           |
      |Condition ID        | <Condition_ID>   |
      |Condition name      | <Condition_Name> | 
      |status              | <Status>         |
      |source              | <Source>         | 
     
Then Advanced Search Fields should display

Examples: 
     |  MCS      | Type   | Condition_ID | Condition_Name | Status| Source |
     | testshy   |        |              |                |       |        |

Scenario Outline: Search existing conditions with advance search
Given User is on Condition Home Page
When Sub-status data is selected 
     | sub-status | <Sub_Status> | 
Then Selected Sub-Status should display

Examples:
     | Sub_Status |
     | Associated |

Scenario Outline: Enter the Tags
Given User is on Condition Home Page
When Data is entered in Tag field an
When data is entered in Tag filed and click on Add button
 |tags|<Tags>|
Then Tag should display in Tag Name table

Examples:
   |Tags|
   |123 |

Scenario: Click on Search Button

Given User is on Condition Home page
When click on Search Button
Then Existion conditions should display in Results 