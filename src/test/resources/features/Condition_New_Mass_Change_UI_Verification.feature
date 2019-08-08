Feature: UI Validations for Creating a Mass Change

##Missing Case Coverage -- check if created conditions show up in entries tab of newly submitted mass change requests##

Background: User Performs Login
Given User opens the browser and goes to RxNova URL
When They enter valid username, valid password and click on Login
Then User navigates from Landing page to "Condition" application
Then They click on "Mass Change"
Then They check if "Mass Change" is displaying by checking for "Mass Change Search Panel"
Then They press "New"

Scenario Outline: User deletes created Mass Change Requests
Then User deletes newly submitted mass change request
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
       
Examples:
	   |Tracking ID            |  Reason   | Notes | Master customer set |Name       | Type        | Status  |Description |
	   |984651233323543        | Test      | Test  |    QTP_Master_1     | Support1  | Mass Change | Pending |    Testing |
	   |897654321015651        | Test      | Test  | QTP_Master_1        |  Support2 | Mass Change | Pending |    Testing |
	   |780456789456123        | Test      | Test  | QTP_Master_1        |  Support3 | Mass Change | Pending |    Testing |
	   |654321548975654		   | Test      | Test  | QTP_Master_1        | Support4  | Mass Change | Pending |    Testing |
	   |216543587654312        | Test      | Test  | QTP_Master_1        |  Support6 | Mass Change | Pending |    Testing |
	   |156488816132148        | Test      | Test  | QTP_Master_1        |  Support7 | Mass Change | Pending |    Testing |
	   |8946463124684685       | Test      | Test  | QTP_Master_1        |  Support8 | Mass Change | Pending |    Testing |
	   |6532145464212356       | Test      | Test  | QTP_Master_1        |  Support9 | Mass Change | Pending |    Testing |
	   |2133546478646511       | Test      | Test  | QTP_Master_1        |  Support10| Mass Change | Pending |    Testing |
	   |369654321421884        | Test      | Test  | QTP_Master_1        |  Support11| Mass Change | Pending |    Testing |

Scenario: Verify labels in New Mass Change Request screen
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
Then The determine whether "New Mass Change Panel" contains "Tracking ID,Reason,Notes,Master customer set,Name,Type,Status,Description"

Scenario: Verify the buttons Submit and Cancel in New Mass Change Request screen
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
Then "Submit" should display
Then "Cancel" should display

Scenario Outline: Create New Mass Change Request
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When They give the below details and click on "Submit"
 | Tracking ID   | Reason   | Notes   | Master customer set   |  Name  | Type   | Status   | Description   |
 | <Tracking ID> | <Reason> | <Notes> | <Master customer set> | <Name> | <Type> | <Status> | <Description> |
Then "Request" should display

Examples:
  | Tracking ID     |  Reason  | Notes | Master customer set | Name     |  Type        |  Status  | Description |
  | 984651233323543 |   Test   | Test  |    QTP_Master_1     | Support1 | Mass Change  |  Pending | Testing     |
   
Scenario Outline: Create a New Mass Change Request
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When They give the below details and click on "Submit"
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
Then Request Edit Panel should display all the correct fields

Examples: 
       |Tracking ID            |  Reason   | Notes | Master customer set | Name     | Type        | Status  |Description |
       |897654321015651        | Test      | Test  | QTP_Master_1        |  Support2| Mass Change | Pending |    Testing |

Scenario Outline: Verify the New Mass Change submitted data in Request
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When They give the below details and click on "Submit"
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
Then "Request Edit Close" should display

Examples: 
       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
	   |780456789456123        | Test      | Test  | QTP_Master_1        |  Support3| Mass Change | Pending |    Testing |
	   
Scenario Outline: Checking Tab display after submitting data in request
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When They give the below details and click on "Submit"
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
Then "Request Edit Tab" should display
Then "Request Action Tab" should display
Then "Request Reporting Tab" should display

Examples: 
       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
	   |654321548975654		   | Test      | Test  | QTP_Master_1        | Support4 | Mass Change | Pending |    Testing |

Scenario Outline: Checking whether Action Tab in newly submitted request contains correct contents
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When They give the below details and click on "Submit"
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
Then They verify that "Request Action Tab" contains "Run Preliminary,Run Final,Rerun,Unlock Request,Stop,Restart,Cancel Request,Delete Request"

Examples:
       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
	   |216543587654312        | Test      | Test  | QTP_Master_1        |  Support6| Mass Change | Pending |    Testing |
   
Scenario Outline: Checking whether Reporting Tab in newly submitted request contains correct contents
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When They give the below details and click on "Submit"
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
Then They verify that "Request Reporting Tab" contains "Preliminary,Final"

Examples:
       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
	   |156488816132148        | Test      | Test  | QTP_Master_1        |  Support7| Mass Change | Pending |    Testing |
	   
Scenario Outline: Checking Browse Requests Request type dropdown contents
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When They give the below details and click on "Submit"
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
When They press "Browse Requests"
Then They check if "Browse Requests" is displaying by checking for "Browse Requests Refresh"
Then They check that "Browse Requests Request type:" dropdown should display "Conditions Entity Report,Conditions Associations Report,Sample Claim Test Data Report,Conditions Field Admin Usage Report,Conditions Mass Change,Conditions Mass Change Upload,Conditions Mass Change Upload Report,Conditions Mass Change Preliminary,Conditions Mass Change Final,Conditions Mass Change Preliminary Report,Conditions Mass Change Final Report"

Examples:
       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
	   |8946463124684685       | Test      | Test  | QTP_Master_1        |  Support8| Mass Change | Pending |    Testing |
	   
Scenario Outline: Checking display of Browse Requests Refresh button
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When They give the below details and click on "Submit"
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
When They press "Browse Requests"
Then They check if "Browse Requests" is displaying by checking for "Browse Requests Refresh"
Then "Browse Requests Refresh" should display

Examples:
       |Tracking ID            |  Reason   | Notes | Master customer set |Name      | Type        | Status  |Description |
	   |6532145464212356       | Test      | Test  | QTP_Master_1        |  Support9| Mass Change | Pending |    Testing |

Scenario Outline: Checking display of Browse Requests Close button
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When They give the below details and click on "Submit"
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
Then They press "Browse Requests"
Then "Browse Requests Close" should display

Examples:
       |Tracking ID            |  Reason   | Notes | Master customer set |Name       | Type        | Status  |Description |
	   |2133546478646511       | Test      | Test  | QTP_Master_1        |  Support10| Mass Change | Pending |    Testing |

Scenario Outline: Checking disabled display of Browse Requests Delete
Given They check if "New Mass Change Request" is displaying by checking for "Tracking ID:"
When They give the below details and click on "Submit"
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
Then They press "Browse Requests"
Then "Browse Requests Delete" should display
Then Ensure "Browse Requests Delete" should be disabled

Examples:
       |Tracking ID            |  Reason   | Notes | Master customer set |Name       | Type        | Status  |Description |
	   |369654321421884        | Test      | Test  | QTP_Master_1        |  Support11| Mass Change | Pending |    Testing |
	   
Scenario Outline: Search a Mass Change Request based on MCS, Request name, Request type, Request status, Run status
#Uses previous Mass Change Request from previous test case
Given They search for the following Mass Change Request based on MCS
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
Then "Request Action Tab" should display

Examples:
       |Tracking ID            |  Reason   | Notes | Master customer set |Name       | Type        | Status  |Description |
	   |369654321421884        | Test      | Test  | QTP_Master_1        |  Support11| Mass Change | Pending |    Testing |
	   
Scenario Outline: Search a New Mass Change Request based on Created by: last name, first name
Given They give the below details for searching based on last & first name
       | Master customer set  |Last name   |  First name   | 
       |<Master customer set> |<Last name> |<First name>   |
Then They check whether Results Panel contains submitted mass change requests

Examples: 
|Master customer set |Last name   |  First name   | 
|QTP_Master_1        |Trikkur     | Samyukta      |

Scenario Outline: Search a Mass Change Request based on Created Range: from date, to date
Given They give the below details for searching based on from date & to date
       |Master customer set   |
       |<Master customer set> |
Then They check whether Results Panel contains submitted mass change requests

Examples: 
       |Master customer set | 
       | QTP_Master_1       |

Scenario Outline: Verify the New Mass Change submitted data in Request tab
Given They search for the following Mass Change Request based on MCS
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
When "Request Action Tab" should display
Then "Request Tab Panel" should display correct contents 

Examples:
       |Tracking ID            |  Reason   | Notes | Master customer set |Name       | Type        | Status  |Description |
	   |369654321421884        | Test      | Test  | QTP_Master_1        |  Support11| Mass Change | Pending |    Testing |
	   
Scenario Outline: User deletes created Mass Change Requests
Then User deletes newly submitted mass change request
       |Tracking ID   |  Reason   | Notes | Master customer set |Name  | Type | Status  | Description |
       |<Tracking ID> |<Reason>   |<Notes>|<Master customer set>|<Name>|<Type>|<Status> |<Description>|
       
Examples:
	   |Tracking ID            |  Reason   | Notes | Master customer set |Name       | Type        | Status  |Description |
	   |984651233323543        | Test      | Test  |    QTP_Master_1     | Support1  | Mass Change | Pending |    Testing |
	   |897654321015651        | Test      | Test  | QTP_Master_1        |  Support2 | Mass Change | Pending |    Testing |
	   |780456789456123        | Test      | Test  | QTP_Master_1        |  Support3 | Mass Change | Pending |    Testing |
	   |654321548975654		   | Test      | Test  | QTP_Master_1        | Support4  | Mass Change | Pending |    Testing |
	   |216543587654312        | Test      | Test  | QTP_Master_1        |  Support6 | Mass Change | Pending |    Testing |
	   |156488816132148        | Test      | Test  | QTP_Master_1        |  Support7 | Mass Change | Pending |    Testing |
	   |8946463124684685       | Test      | Test  | QTP_Master_1        |  Support8 | Mass Change | Pending |    Testing |
	   |6532145464212356       | Test      | Test  | QTP_Master_1        |  Support9 | Mass Change | Pending |    Testing |
	   |2133546478646511       | Test      | Test  | QTP_Master_1        |  Support10| Mass Change | Pending |    Testing |
	   |369654321421884        | Test      | Test  | QTP_Master_1        |  Support11| Mass Change | Pending |    Testing |


