Feature: BSC DRUG LIST REPORT

  Background: Login into Argus Webpage and Select Region
    Given Open Browser and Open RxNova URL
    When User enters valid username, valid password and clicks on Login
    Then Application should display Environment selection screen
    And User selects Region and Landing page should be displayed

 @SmokeTest
 Scenario: Generate BSC Drug List Report with txt delimited format
    Given Landing Page user navigates to "Drug List" application
    When User switches to Drug List page
    And user deletes available reports using browse requests link
    And Search DrugList for the below details
	    |Benefit_Customer_Set|Argus Master Customer Set|
	    |Type|UNCLASSIFIED SET OF DRUGS|
	    |Identifier|UNARG0001|    
 		And Click on Report Options
 		And Submit the Reporting Options
	 		|Report_Type|NDC DETAIL REPORT|
	 		|Report_Format|Delimited|
  	And view BrowserRequest and report completion status
    Then download the generated report
  	#Then Verify the Downloaded DrugList Report for data content
 
 		#Then Adhoc user deletes available reports using browse requests link
   	#And when user Generates Report using data
      #| DataRole     | BSCA Inq DataFocus SI bsc02 PW Cust All-Reports-PD |
      #| ReportType   | Standard Reports                                   |
      #| ReportChoice | Executive / NDC                                    |
      #| ReportName   | 1002.Top 25 Brand Names by Total Paid              |
      #| Customer     | 192 - BSC MA-PD                                    |
      #| Client       | 192 - 837 - 65 PLUS FRESNO                         |
      #| Group        |                                                    |
      #| BeginDate    | 01/01/2018                                         |
      #| EndDate      | 01/31/2018                                         |
      #| Calculation  | Standard                                           |
      #| FormatType   | PDF                                                |
      #| ReportName   | SmokeTest                                          |
    #Then User clicks on BrowseRequest Link and checks report completion status
    #Then User then download the completed report
    #Then User verifies the Downloaded Report for data content
    
    
    #HUM1CLM
    #CIG1CLM
