Feature: Field Admin Search UI Verification

Background:
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then User navigates from Landing page to "Condition" application
When They check whether the "Condition Home" is displayed 
Then They click on "Field Admin"

Scenario: Navigate to Field Admin Tab
Given They check if "Field Admin" is showing by checking for "Search Panel"

Scenario: Verify Search panel 
Given They check if "Field Admin" is showing by checking for "Search Panel"   

Scenario: Verify labels in Search panel  
Given They check if "Field Admin" is showing by checking for "Search Panel"  
Then They verify whether "Search Panel" contains "Master customer set,System,Argus field name,Business field name,Status"

Scenario: Verify Master customer set drop down list in Search panel 
Given They check if "Field Admin" is showing by checking for "Search Panel"  
Then They verify whether "Master customer set:" dropdown contains list of existing customers

Scenario: Verify System drop down list in Search panel 
Given They check if "Field Admin" is showing by checking for "Search Panel"  
Then They verify whether "System:" dropdown contains "CLAIM,GROUP,MEMBER,NDC,PHARMACY,PRESCRIBER"

Scenario: Verify Argus field name edit field in Search panel 
Given They check if "Field Admin" is showing by checking for "Search Panel"  
Then They verify whether "Argus field name:" is displayed

Scenario: Verify Business field name edit field in Search panel 
Given They check if "Field Admin" is showing by checking for "Search Panel"  
Then They verify whether "Business field name:" is displayed

Scenario: Verify Status drop down list in Search panel 
Given They check if "Field Admin" is showing by checking for "Search Panel"  
Then They verify whether "Status:" dropdown contains "Not Ready,Ready for Use,Do Not Use Anymore"

Scenario: Verify Search and Reset buttons in Search panel  
Given They check if "Field Admin" is showing by checking for "Search Panel"
Then They verify whether "Search Button" is displayed
Then They verify whether "Reset Button" is displayed

Scenario: Verify New button  
Given They check if "Field Admin" is showing by checking for "Search Panel" 
Then They verify whether "New Button" is displayed

Scenario: Verify Results panel 
Given They check if "Field Admin" is showing by checking for "Search Panel" 
Then They verify whether "Results Panel" is displayed
