Feature: UI Validations for Search a Mass Change

Background: User Performs Login
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then User navigates from Landing page to "Condition" application
Then They click on "Mass Change"

Scenario: Verify that Mass Change screen is displayed
Then They check if "Mass Change" is displaying by checking for "Mass Change Search Panel"

Scenario: Verify that Mass Change Search Panel is displayed
Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel"
Then "Mass Change Search Panel" should display

Scenario: Verify labels in Search panel  
Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel"
Then They verify Mass Change Search Panel contains all the correct contents

Scenario: Verify Search and Reset buttons in Search panel  
Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel"
Then "Search" should display
Then "Reset" should display

Scenario: Verify New button  
Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel"
Then "New" should display

Scenario: Verify Results panel 
Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel"
Then "Mass Change Results Panel" should display

Scenario: Verify Master customer set drop down list in Search panel 
Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel"
Then "Mass Change Master customer set:" drop down list should display list of available Master customer set details

Scenario: Verify Request type drop down list in Search panel
Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel" 
Then They check that "Request type:" dropdown should display "Mass Change"

Scenario: Verify Request status drop down list in Search panel 
Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel" 
Then They check that "Request status:" dropdown should display "Pending,Preliminary,Final,Canceled,Expired"

Scenario: Verify Run status drop down list in Search panel 
Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel" 
Then They check that "Run status" dropdown should display "Submitted,Scheduled,In Progress,Completed,Failed,Stopped"

Scenario: Verify Created by options in Search panel 
Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel" 
Then "Last name:" should display
Then "First name:" should display

Scenario: Verify Created Range options in Search panel 
Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel" 
Then "From date:" should display
Then "To date:" should display           
