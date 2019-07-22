Feature: UI Validations for Creating a Mass Change

Background: User Performs Login
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then User navigates from Landing page to "Condition" application
Then They click on "Mass Change"
Then They check if "Mass Change" is displaying by checking for "Mass Change Search Panel"
Then They press "New"

#Scenario: Verify labels in New Mass Change Request screen
#Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
#Then The determine whether "New Mass Change Panel" contains "Tracking ID,Reason,Notes,Master customer set,Name,Type,Status,Description"
#
#Scenario: Verify the buttons Submit and Cancel in New Mass Change Request screen
#Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
#Then "Submit" should display
#Then "Cancel" should display

Scenario Outline: Create New Mass Change Request
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When They give the below details and click on "Submit"
 | Tracking ID   | Reason   | Notes   | Master customer set   |  Name  | Type   | Status   | Description   |
 | <Tracking ID> | <Reason> | <Notes> | <Master customer set> | <Name> | <Type> | <Status> | <Description> |
Then "Request" should display
Then User deletes newly submitted mass change request

Examples:
  | Tracking ID     |  Reason  | Notes | Master customer set | Name     |  Type        |  Status  | Description |
  | 984651233323543 |   Test   | Test  |    QTP_Master_1     | Support1 | Mass Change  |  Pending | Testing     |
   
Scenario Outline: Create a New Mass Change Request
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When They give the below details and click on "Submit"
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
Then Request Edit Panel should display all the correct fields
Then User deletes newly submitted mass change request

Examples: 
       |Tracking ID            |  Reason   | Notes | Master customer set | Name     | Type        | Status  |Description |
       |897654321015651        | Test      | Test  | QTP_Master_1        |  Support2| Mass Change | Pending |    Testing |

#Scenario Outline: Verify the New Mass Change submitted data in Request
#Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
#When They give the below details and click on "Submit"
#       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
#       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
#Then "Request Edit Close" should display
#Then User deletes newly submitted mass change request
#
#Examples: 
#       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
#	   |780456789456123        | Test      | Test  | QTP_Master_1        |  Support3| Mass Change | Pending |    Testing |
#	   
#Scenario Outline: Checking Tab display after submitting data in request
#Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
#When They give the below details and click on "Submit"
#       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
#       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
#Then "Request Edit Tab" should display
#Then "Request Action Tab" should display
#Then "Request Reporting Tab" should display
#Then User deletes newly submitted mass change request
#
#Examples: 
#       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
#	   |654321548975654		   | Test      | Test  | QTP_Master_1        | Support4 | Mass Change | Pending |    Testing |
#
#Scenario Outline: Checking whether Action Tab in newly submitted request contains correct contents
#Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
#When They give the below details and click on "Submit"
#       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
#       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
#Then They verify that "Request Action Tab" contains "Run Preliminary,Run Final,Rerun,Unlock Request,Stop,Restart,Cancel Request,Delete Request"
#Then User deletes newly submitted mass change request
#
#Examples:
#       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
#	   |216543587654312        | Test      | Test  | QTP_Master_1        |  Support6| Mass Change | Pending |    Testing |
   
#Scenario Outline: Checking whether Reporting Tab in newly submitted request contains correct contents
#Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
#When They give the below details and click on "Submit"
#       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
#       |<Tracking_ID> |<Reason>   |<Notes>|<Master_customer_set>|<Name>|<Type>|<Status> |<Description>|
#Then They verify that "Request Reporting Tab" contains "Preliminary,Final"
#
#Examples:
#       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
#	   |156488816132148        | Test      | Test  | QTP_Master_1        |  Support7| Mass Change | Pending |    Testing |
	   
#Scenario Outline:
#Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
#When They give the below details and click on "Submit"
#       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
#       |<Tracking_ID> |<Reason>   |<Notes>|<Master_customer_set>|<Name>|<Type>|<Status> |<Description>|
#Then They press the "Browse Requests"
#Then They check if the submitted Mass Change requests are displayed
#Then They check if "Browse Requests Request type" dropdown should display "Conditions Entity Report,Conditions Associations Report,Sample Claim Test Data Report,Conditions Field Admin Usage Report,Conditions Mass Change,Conditions Mass Change Upload,Conditions Mass Change Upload Report,Conditions Mass Change Preliminary,Conditions Mass Change Final,Conditions Mass Change Preliminary Report,Conditions Mass Change Final Report"
#
#Examples:
#       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
#	   |156488816132148        | Test      | Test  | QTP_Master_1        |  Support7| Mass Change | Pending |    Testing |
#
#Scenario Outline:
#Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
#When They give the below details and click on "Submit"
#       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
#       |<Tracking_ID> |<Reason>   |<Notes>|<Master_customer_set>|<Name>|<Type>|<Status> |<Description>|
#Then They press the "Browse Requests"
#Then "Browse Requests Refresh" should display
#
#Examples:
#       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
#	   |546897431223549        | Test      | Test  | QTP_Master_1        |  Support8| Mass Change | Pending |    Testing |
#	   
#Scenario Outline:
#Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
#When They give the below details and click on "Submit"
#       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
#       |<Tracking_ID> |<Reason>   |<Notes>|<Master_customer_set>|<Name>|<Type>|<Status> |<Description>|
#Then They press the "Browse Requests"
#Then "Browse Requests Close" should display
#
#Examples:
#       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
#	   |421326987545642        | Test      | Test  | QTP_Master_1        |  Support9| Mass Change | Pending |    Testing |
#	   
#Scenario Outline:
#Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
#When They give the below details and click on "Submit"
#       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
#       |<Tracking_ID> |<Reason>   |<Notes>|<Master_customer_set>|<Name>|<Type>|<Status> |<Description>|
#Then They press the "Browse Requests"
#Then "Browse Requests Delete" should display
#Then Ensure "Browse Requests Delete" should be disabled
#
#Examples:
#       |Tracking ID            |  Reason   | Notes | Master customer set |Name       | Type        | Status  |Description |
#	   |369654321421884        | Test      | Test  | QTP_Master_1        |  Support10| Mass Change | Pending |    Testing |
#	   
#Scenario Outline: Search a Mass Change Request
#Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel"
#When They give the below details for searching based on Request name, type, & status and click on "Search"
#       |Master customer set   |  Request name   | Request type | Request status |
#       |<Master_customer_set> |<Request_name>   |<Request_type>|<Request_status>|
#Then Then submitted mass changes should display
#
#Examples:
#       |Master customer set   |  Request name   | Request type | Request status |
#       | QTP_Master_1         | Support10       | Mass Change  | Pending        |
#
#Scenario Outline: Search a New Mass Change 	Request
#Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel"
#When They give the below details for searching based on last & first name and click on "Search"
#       |Last name   |  First name   | 
#       |<Last_name> |<First_name>   |
#Then Then submitted mass changes should display
#
#Examples: 
#|Last name   |  First name   | 
#|Nallajaru   | Sreenubabu    |
#
#Scenario Outline: Search a  Mass Change Request
#Given They check if "Mass Change" is displaying by checking for "Mass Change Search Panel" 
#When They give the below details for searching based on from date & to date and click on "Search"
#       |From date   |  To date   | 
#       |<From_date> |<To_date>   |
#Then Then submitted mass changes should display
#
#Examples: 
#       |From date    |  To date      | 
#       |<01/01/2018> |<12/31/9999>   |
#
##Scenario: Verify the New Mass Change submitted data in Request tab
##Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
##When verify the New Mass Change submitted data displays
##Then submitted data for Master Customer set, Request Name, Request Type,Request Status,Tracking ID,Reason,Notes,Description,Created by,created date,created time,Last maintenance user,Last maintenance date,Last maintenance time should display 
##
##Scenario: Verify the display of submitted Mass Change conditions in Entries tab
##Given User is on Entries tab 
##When verify the submitted Mass Change conditions
##Then all the submitted Mass Change conditions should display
##
##Scenario: Verify the submitted Mass Change Reports in Browse Requests page
##Given User is on Browse Requests page
##When verify the submitted Mass Change Reports
##Then submitted Mass Change Reports should display in Browse Requests page
##
##Scenario: Verify the Request Type dropdown list in Browse Requests page
##Given User is on Browse Requests page
##When verify the Request Type dropdown list
##Then Request Type dropdown list should display the reports Conditions Entity Report, Conditions Associations Report, Sample Claim Testdata Report, Conditions Field Admin usage Report,Conditions Mass Change, Conditions Mass Change Upload,Conditions Mass Change Upload Report, Conditions Mass Change Preliminary,Conditions Mass Change Final,Conditions Mass Change Preliminary Report andConditions Mass Change Final Report
##
##Scenario: Verify the Refresh button in Browse Requests page
##Given User is on Browse Requests page
##When verify the Refresh button
##Then Refresh button should display at the top right corner in Browse Requests page
##
##Scenario: Verify the Close button in Browse Requests page
##Given User is on Browse Requests page
##When verify the Close button
##Then Close button should display at the bottom right corner in Browse Requests page
##
##Scenario: Verify the Delete button in Browse Requests page
##Given User is on Browse Requests page
##When verify the Delete button
##Then Delete button should be disabled and display at the bottom left corner in Browse Requests page
##
##Scenario: Verify the submitted Conditions Mass Change Reports in Browse Requests page
##Given User is on Browse Requests page
##When verify the Check box icon displays before each report, Reports display in type pdf format and Delete link exists for each Report
##Then Check box icon should display before each report, Reports should display in type pdf format and Delete link should exist for each Report
##
##Scenario Outline: Search a Mass Change	Request
##Given the User is on Mass Change header screen  
##When below details are provided and click on search
##       |Master customer set   |  Request name   | Request type | Request status |Run status  |
##       |<Master_customer_set> |<Request_name>   |<Request_type>|<Request_status>|<Run_status>|
##Then  Mass Change should be displayed
##
##Examples: 
##       |Master customer set   |  Request name   | Request type | Request status |Run status  |
##       |<Humana>              |<Test>           |<Mass Change> |<Pending>       |<Submitted> |
##				 
##
##Scenario Outline: Search a New Mass Change 	Request
##Given the User is on Mass Change header screen and provide Created by information 
##When below details are provided and click on search
##       |Last name   |  First name   | 
##       |<Last_name> |<First_name>   |
##Then  Mass Change should be displayed
##
##Examples: 
##|Last name   |  First name   | 
##|<DST1>      |<DST2>         |
##				 
##
##Scenario Outline: Search a  Mass Change Request
##Given the User is on Mass Change header screen and provide Created Range information 
##When below details are provided and click on search
##       |From date   |  To date   | 
##       |<From_date> |<To_date>   |
##Then  Mass Change should be displayed
##
##Examples: 
##       |From date    |  To date      | 
##       |<01/01/2018> |<12/31/9999>   |   
###Delete New Mass Change Requests
#
#
