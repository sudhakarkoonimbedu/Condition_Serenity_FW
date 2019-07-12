Feature: Condition Reporting UI Verifcation for Conditions Associations Report Type

Background:
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then They check whether the application displays the Environment selection screen
And They select Region and check whether the Landing Page is displayed
Then User navigates from Landing page to "Condition" application
When They check whether the "Condition Home" is displayed 
Then They click on "Reporting"

Scenario: Verifying whether Reporting tab is properly displayed
Then They determine if "Reporting" is showing by checking for "Report type:"

Scenario Outline: Verify the Reporting page fields
Given They determine if "Reporting" is showing by checking for "Report type:"
Then They check whether the following "<label>" are shown in the Reporting Panel

Examples:
 | label |
 | Report type |
 | Report format |
 | Report name | 

Scenario: Verify the Report Type dropdown list
Given They determine if "Reporting" is showing by checking for "Report type:"
Then They check whether "Report type:" dropdown list displays "Conditions Associations,Conditions Entity,Field Admin Usage,Sample Claim Test Data"

Scenario: Verify the Report Type Conditions Associations
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
Then "Report format:" must be displayed
Then "Report name:" must be displayed
Then "Associations Criteria Panel" must be displayed

Scenario: Verify the Report format dropdown list
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
Then They check whether "Report format:" dropdown list displays "Delimited,Excel"

Scenario: Verify the Associations Criteria Panel
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
Then They check whether all of the correct fields are showing in the Associations Panel

Scenario: Verify the buttons in the Associations Criteria Panel
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
Then "Add Button for Association" must be displayed
Then "Remove Selected Button for Association" must be displayed
Then "Report Button for Association" must be displayed
Then "Reset Button for Association" must be displayed

Scenario: Verifying Remove Selected and CD prefix
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
Then They check whether "Remove Selected Button for Association" is disabled
And They determine whether the "CD" prefix shows up in front of "Condition ID CD for Association" field
And They check whether "Condition ID Table for Association" displays "No records found."

Scenario: Verify the Application Type dropdown list
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
Then They check whether "Application type for Association" dropdown list displays "Benefits,DUR Protocols,DUR Safety,Conditions,Network Maintenance,Pricing, Prescriber,Member,Pharmacy Service Fees,Authorization,Accumulator,Financial"

Scenario: Verify the Components Type Dropdown list for the Benefits Application Type
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
When They select "Benefits" for "Application type for Association"
Then They check whether "Component type for Association" dropdown list displays "Copay Assignments,Copay Limits,Copay Multipliers,Drug Coverage,Dispensing Limits,Refill Too Soon,Error Overrides,Post Pay Reporting,Deductible Processing,MAC Reimbursement"

Scenario: Verify the Components Type Dropdown list for the DUR Protocols Application Type
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
When They select "DUR Protocols" for "Application type for Association"
Then They check whether "Component type for Association" dropdown list displays "Quantity,Step Therapy,Inferred Disease"

Scenario: Verify the Components Type Dropdown list for the DUR Safety Application Type
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
When They select "DUR Safety" for "Application type for Association"
Then They check whether "Component type for Association" dropdown list displays "Morphine Equivalent Dose"

Scenario: Verify the Components Type Dropdown list for the Conditions Application Type
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
When They select "Conditions" for "Application type for Association"
Then They check whether "Component type for Association" is disabled

Scenario: Verify the Components Type Dropdown list for the Network Maintenance Application Type
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
When They select "Network Maintenance" for "Application type for Association"
Then They check whether "Component type for Association" dropdown list displays "MAC Price,Rate Sheet,Pharmacy Component"

Scenario: Verify the Components Type Dropdown list for the Pricing Application Type
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
When They select "Pricing" for "Application type for Association"
Then They check whether "Component type for Association" dropdown list displays "Pricing Options,Client Pricing Unit,Client Pricing Rate Sheet,MIC Options"

Scenario: Verify the Components Type Dropdown list for the Prescriber Application Type
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
When They select "Prescriber" for "Application type for Association"
Then They check whether "Component type for Association" dropdown list displays "Prescriber Options"

Scenario: Verify the Components Type Dropdown list for the Member Application Type
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
When They select "Member" for "Application type for Association"
Then They check whether "Component type for Association" is disabled

Scenario: Verify the Components Type Dropdown list for the Pharmacy Service Fees Application Type
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
When They select "Pharmacy Service Fees" for "Application type for Association"
Then They check whether "Component type for Association" dropdown list displays "Service Fees"

Scenario: Verify the Components Type Dropdown list for the Authorization Application Type
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
When They select "Authorization" for "Application type for Association"
Then They check whether "Component type for Association" dropdown list displays "PreAuth,Restricted,Customized"

Scenario: Verify the Components Type Dropdown list for the Accumulator Application Type
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
When They select "Accumulator" for "Application type for Association"
Then They check whether "Component type for Association" is disabled

Scenario: Verify the Components Type Dropdown list for the Financial Application Type
Given User is on Conditions Reporting page, they select "Conditions Associations" for "Report type:"
When They select "Financial" for "Application type for Association"
Then They check whether "Component type for Association" is disabled