Feature: Field Admin Header Tab UI Verification

Background:
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then User navigates from Landing page to "Condition" application
When They check whether the "Condition Home" is displayed 
Then They click on "Field Admin"
And They check if "Field Admin" is showing by checking for "Search Panel"
Then They press on "Field Admin New"

Scenario: Verifying Default Enable of Conditions Header
Then They check if "Field Admin Header" is showing by checking for "Tracking ID:" 

Scenario: Navigate to Add a Field screen  
Given They check if "Field Admin Header" is showing by checking for "Tracking ID:"  
When They check if "Add a Field Breadcrumb" is displayed 

Scenario: Verify labels in Header tab 
Given They check if "Field Admin Header" is showing by checking for "Tracking ID:" 
Then They determine whether the "Field Admin Header Panel" contains "Tracking ID,Reason,Master customer set,Argus field name,Business field name,Status"

Scenario: Verify Next and Cancel buttons in Header tab
Given They check if "Field Admin Header" is showing by checking for "Tracking ID:" 
Then They check if "Next" is displayed 
Then They check if "Cancel" is displayed

Scenario: Verify Tracking ID edit field in Header tab
Given They check if "Field Admin Header" is showing by checking for "Tracking ID:"
Then They check if "Tracking ID:" is displayed

Scenario: Verify Notes edit field in Header tab
Given They check if "Field Admin Header" is showing by checking for "Tracking ID:"
Then They check if "Notes:" is displayed

Scenario: Verify Reason edit field in Header tab
Given They check if "Field Admin Header" is showing by checking for "Tracking ID:" 
Then They check if "Reason:" is displayed

Scenario: Verify Master customer set drop down list in Header tab
Given They check if "Field Admin Header" is showing by checking for "Tracking ID:" 
Then They check if "Master customer set:" dropdown list contains list of available contents

Scenario: Verify Argus field Name edit field in Header tab
Given They check if "Field Admin Header" is showing by checking for "Tracking ID:" 
Then They check if "Argus field name:" is displayed

Scenario: Verify Business field Name edit field in Header tab
Given They check if "Field Admin Header" is showing by checking for "Tracking ID:" 
Then They check if "Business field name:" is displayed

Scenario: Verify Status drop down list in Header tab
Given They check if "Field Admin Header" is showing by checking for "Tracking ID:" 
Then They check if "Status:" dropdown list contains "Not Ready,Ready for Use,Do Not Use Anymore"

