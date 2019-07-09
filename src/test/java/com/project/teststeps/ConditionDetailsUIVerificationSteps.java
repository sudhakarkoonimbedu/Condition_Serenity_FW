package com.project.teststeps;

import com.project.actors.ActorConditionsDetailsPage;

import cucumber.api.java.en.Then;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Steps;

import com.project.common.util.RxNovaCommonUtil;

public class ConditionDetailsUIVerificationSteps {

	@Steps
	ActorConditionsDetailsPage actorOnConditionsDetailsPage;
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	
	@Then("^They check whether the \"(.*)\" is currently enabled$")
	public void ObjectIsCurrentlyEnabled(String ObjKey) {
		actorOnConditionsDetailsPage.ObjectIsCurrentlyEnabled(ObjKey);
	}
	
	@Then("^They click \"(.*)\"$")
	public void clickIfClickable(String ObjKey) throws InterruptedException, Throwable {
		actorOnConditionsDetailsPage.clickIfClickable(ObjKey);
	}
	
	@Then("^They enter \"(.*)\" into \"(.*)\"$")
	public void SendKeysToField(String input, String ObjKey) {
		actorOnConditionsDetailsPage.SendKeysToField(input, ObjKey);
	}
	
	@Then("^They specify \"(.*)\" for \"(.*)\"$")
	public void SelectFromDropdown(String input, String ObjKey) throws InterruptedException {
		actorOnConditionsDetailsPage.SelectFromDropdown(input, ObjKey);
	}
	
	@Then("^User switches windows to most recent window$")
	public void SwitchToMostRecentWindow() throws InterruptedException {
		actorOnConditionsDetailsPage.SwitchToMostRecentWindow();
	}
	
	@Then("^They check if the \"(.*)\" is currently showing by checking for \"(.*)\"$")
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		actorOnConditionsDetailsPage.IsTabDisplayed(ObjKey, ChildObjKey);
	}
	
	@Then("^They check if \"(.*)\" is disabled$")
	public void ObjectIsDisabled(String ObjKey) {
		actorOnConditionsDetailsPage.ObjectIsDisabled(ObjKey);
	}
	
	@Then("^They enter a (\\d+) digit number into \"(.*)\"$")
	public void EnterIDs(int stringTargetLength, String ObjKey) {
		actorOnConditionsDetailsPage.EnterIDs(stringTargetLength, ObjKey);
	}

	@Then("^They enter a word into \"(.*)\"$")
	public void EnterRandomWord(String ObjKey) {
		actorOnConditionsDetailsPage.EnterRandomWord(ObjKey);
	}
	
	@Then("^They select a value for \"(.*)\" dropdown list$")
	public void SelectRandomlyFromDropown(String ObjKey) {
		actorOnConditionsDetailsPage.SelectRandomlyFromDropdown(ObjKey);
	}
	
	@Then("^They enter the following header data and press \"(.*)\"$")
	public void EnterRelevantHeaderData(String ObjKey, DataTable enterData) throws InterruptedException, Throwable {
		actorOnConditionsDetailsPage.EnterRelevantHeaderData(ObjKey, enterData);
		//create a specific function for this at the actor level, at which the hashmap will be accessed with relevant information
		//in actor level, page objects can be included, i.e. the relevant strings necessary for a function can be included in the 
		//variables of the actor code. This will enable more free-flowing feature files, and will allow less steps to be written in
		//the feature file.
		//the idea is to save the data that you generate, such that the condition that you create can be deleted. This deletion should also
		//be automated. This gives you coverage of a later test case while also allowing you to keep the same data.
		//Then you should be able to continue using the same fixed data every time you check that case, as you will be freeing that case
		//from web app's memory pool. 
		//The only item that requires random generation is the tracking id. All other aspects should be fixed, such that it is 
		//easy to search for the created condition and delete it later on.
	}
	
	@Then("^They enter the following details data and press \"(.*)\"$")
	public void EnterRelevantDetailsData(String ObjKey, DataTable enterData) throws Throwable {
		actorOnConditionsDetailsPage.EnterRelevantDetailsData(ObjKey, enterData);
	}
	
	@Then("^They determine whether the following \"([^\"]*)\" are displayed in the Details panel$")
	public void checkPanelsForCorrectLabels(String label) throws InterruptedException {
		actorOnConditionsDetailsPage.checkPanelsForCorrectLabels(label);
	}
	
	@Then("^They choose \"(.*)\" as the field name and verify operator dropdown list displays the items \"(.*)\"$")
	public void verifyingOperatorField(String toEnter, String expected) throws Throwable {
		actorOnConditionsDetailsPage.verifyingOperatorField(toEnter, expected);
	}
	
	@Then("^They check if \"(.*)\" dropdown list displays list of existing Benefit customer set details$")
	public void benefitCustomerDrpDown(String ObjKey) {
		actorOnConditionsDetailsPage.benefitCustomerDrpDown(ObjKey);
	}
	
	@Then("^They verify the \"(.*)\" dropdown list displays the items \"(.*)\"$")
	public void verifyingOperatorFieldwithoutEntry(String ObjKey, String expected) {
		actorOnConditionsDetailsPage.verifyingOperatorFieldwithoutEntry(ObjKey, expected);
	}
	
	@Then("^They check if \"(.*)\" are shown for \"(.*)\"$")
	public void verifyingTableContents (String expected, String ObjKey) throws InterruptedException, Throwable {
		actorOnConditionsDetailsPage.verifyingTableContents(expected, ObjKey);
	}
	
	@Then("^They wait for the busy icon$")
	public void waitForbusy() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	@Then("^They check whether the Associations is currently enabled after creating a condition$")
	public void isAssociationsEnabled() throws Throwable {
		actorOnConditionsDetailsPage.isAssociationsEnabled();
	}
	
	@Then("^They check if the \"(.*)\" is currently showing by checking for \"(.*)\" after creating a condition$")
	public void verifyAssociationsDisplay(String ObjKey, String ChildObjKey) throws Throwable {
		actorOnConditionsDetailsPage.verifyAssociationsDisplay(ObjKey, ChildObjKey);
	}
	
	@Then("^They verify the messages at the bottom of the page$")
	public void verifyMessages() throws Throwable {
		actorOnConditionsDetailsPage.verifyMessages();
	}
}
