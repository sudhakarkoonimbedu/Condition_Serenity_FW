Feature: Field Admin Details Tab UI Verification

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

Scenario: Verify Details tab
Given They enter the following data for Header and press "Next"
 | Tracking ID       | Master customer set       | Argus field name   | Business field name     | Status          |
 |	123456789954621   |   MCS_SreenuBabu          |         NDC        |  lkjdfaij               | Ready for Use   |
Then They check if "Field Admin Details" is showing by checking for "Field type:"
And They press on "Next"
Then They check whether "Field Admin Notes" is currently enabled

Scenario: Verify Field Type edit field
Given They enter the following data for Header and press "Next"
 | Tracking ID       | Master customer set       | Argus field name   | Business field name     | Status          |
 |	123456789954621  |  MCS_SreenuBabu           |         NDC        |  lkjdfaij               | Ready for Use   |
When They check if "Field Admin Details" is showing by checking for "Field type:"
Then They determine whether the "Details Panel" contains "Field type,Field length ,Retained in history,System,Table name,Column name"

### NOT SURE WHAT THIS REQUIRES ###
#Scenario: Verify Field length edit field
#Given User is on Details tab  
#When verify Field length edit field
#Then Field length edit field should displays
#
#Scenario: Verify Retained in history dropdown list
#Given User is on Details tab  
#When verify Retained in history dropdown list
#Then Retained in history dropdown list should displays the items: Yes/No
#
#Scenario: Verify System edit field
#Given User is on Details tab  
#When verify System edit field
#Then System edit field should displays
#
#Scenario: Verify Table name edit field
#Given User is on Details tab  
#When verify Table name edit field
#Then Table name edit field should displays
#
#Scenario: Verify Column name edit field
#Given User is on Details tab  
#When verify Column name edit field
#Then Column name edit field should displays
