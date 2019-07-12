Feature: Field Admin Notes Tab UI Verification

Background:
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then They check whether the application displays the Environment selection screen
And They select Region and check whether the Landing Page is displayed
Then User navigates from Landing page to "Condition" application
When They check whether the "Condition Home" is displayed 
Then They click on "Field Admin"
And They check if "Field Admin" is showing by checking for "Search Panel"
Then They press on "Field Admin New"

Scenario: Verifying Default Enable of Conditions Header
Then They check if "Field Admin Header" is showing by checking for "Tracking ID:" 

Scenario: Verify Enable of Notes Tab
Given They enter the following data for Header and press "Next"
 | Tracking ID       | Master customer set       | Argus field name   | Business field name     | Status          |
 |	123456789954621  |   MCS_SreenuBabu          |         NDC        |  lkjdfaij               | Ready for Use   |
Then They check if "Field Admin Details" is showing by checking for "Field type:"
And They press on "Next"
Then They check whether "Field Admin Notes" is currently enabled

Scenario: Verify the label Notes displays for Notes Table
Given They enter the following data for Header and press "Next"
 | Tracking ID       | Master customer set       | Argus field name   | Business field name     | Status          |
 |	123456789954621  |   MCS_SreenuBabu          |         NDC        |  lkjdfaij               | Ready for Use   |
Then They check if "Field Admin Details" is showing by checking for "Field type:"
And They press on "Next"
And They check whether "Field Admin Notes" is currently enabled
Then They check if "Associate Notes within a Field" is displayed

Scenario: Verify the Previous, Save, and Cancel Buttons
Given They enter the following data for Header and press "Next"
 | Tracking ID       | Master customer set       | Argus field name   | Business field name     | Status          |
 |	123456789954621  |   MCS_SreenuBabu          |         NDC        |  lkjdfaij               | Ready for Use   |
Then They check if "Field Admin Details" is showing by checking for "Field type:"
And They press on "Next"
And They check whether "Field Admin Notes" is currently enabled
Then They check whether "PreviousU" is currently enabled
Then They check whether "SaveU" is currently enabled
Then They check whether "CancelU" is currently enabled


