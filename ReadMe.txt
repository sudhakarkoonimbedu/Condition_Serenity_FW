RxNova Conditions Application Automated Regression Test Suite (24.07.2019)

This test suite currently contains slightly more than 200 test scenarios specific to the different facets of the RxNova Conditions Application. Cucumber BDD feature files are used to create
groups of related test scenarios. Standard Page-Object Model is used as a fundamental structure to facilitate the building of test scenarios. 

Currently, the test suite contains mainly UI Verification test scenarios. Some scenarios have some functional test case coverage; i.e. scenarios with respect to the creation of a Condition
or the submission of a New Mass Change Request. As of now, the suite contains 17 different feature files.

These features primarily operate on the following pages/tabs in the Conditions Application:
	- Condition Home 
	- Condition Header (after pressing New in Condition Home)
	- Condition Details (after pressing New in Condition Home) - different features for Single and Compound Condition Scenarios
	- Condition Tags/Notes (after pressing New in Condition Home)
	- Condition Association (after pressing New in Condition Home and fully creating a valid condition)
	- Condition Pre-Test (after pressing New in Condition Home and fully creating a valid condition)
	- Condition Field Admin Search
	- Condition Field Admin Header (after pressing New in Condition Field Admin)
	- Condition Field Admin Details (after pressing New in Condition Field Admin)
	- Condition Field Admin Notes (after pressing New in Condition Field Admin)
	- Condition Reporting (after selecting Conditions Associations as Report type)
	- Condition Reporting (after selecting Conditions Entity as Report type)
	- Condition Reporting (after selecting Field Admin Usage as Report type)
	- Condition Reporting (after selecting Sample Claim Test Data as Report type)
	- Condition Mass Change Search
	- Condition Mass Change New (after pressing New in Condition Mass Change)

This test suite implements HashMaps at the page levels to create an association between strings and xpaths on any page. This facilitates the passing of WebElement Object paths to 
functions as parameters, therefore allowing us to recognize elements at an earlier stage than just the page level. Strings used in feature files are passed in as keys, which can be used to 
access objects on a page.
