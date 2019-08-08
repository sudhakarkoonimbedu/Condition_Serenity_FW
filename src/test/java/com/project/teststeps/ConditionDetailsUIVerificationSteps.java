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
	public void ObjectIsCurrentlyEnabled(String ObjKey) throws InterruptedException {
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
	}
	
	@Then("^They enter the following details data and press \"(.*)\"$")
	public void EnterRelevantDetailsDataFewerFields(String ObjKey, DataTable enterData) throws Throwable {
		actorOnConditionsDetailsPage.EnterRelevantDetailsDataFewerFields(ObjKey, enterData);
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
		rxNovaCommonUtil.CheckBusyState();
		actorOnConditionsDetailsPage.verifyAssociationsDisplay(ObjKey, ChildObjKey);
	}
	
	@Then("^They verify the messages at the bottom of the page$")
	public void verifyMessages() throws Throwable {
		actorOnConditionsDetailsPage.verifyMessages();
	}
	
	@Then("^They check whether the Pre-Test is enabled after creating a condition$")
	public void isPreTestEnabled() throws Throwable {
		actorOnConditionsDetailsPage.isPreTestEnabled();
	}
	
	@Then("^They verify whether \"(.*)\" properly displays \"(.*)\"$")
	public void verifyPreTestMessages(String ObjKey, String expected) throws Throwable {
		actorOnConditionsDetailsPage.verifyPreTestMessages(ObjKey, expected);
	}
	
	@Then("^They check whether the \"(.*)\" is currently enabled and delete$")
	public void PreTestObjectEnabled(String ObjKey) throws Throwable {
		actorOnConditionsDetailsPage.PreTestObjectEnabled(ObjKey);
	}
	
	@Then("^The user creates a condition with the following data$")
	public void CreateCondition(DataTable conditionData) throws InterruptedException, Throwable {
		actorOnConditionsDetailsPage.IsTabDisplayed("Header", "Tracking ID:");
		actorOnConditionsDetailsPage.EnterRelevantHeaderData("Next", conditionData);
		actorOnConditionsDetailsPage.IsTabDisplayed("Details", "Source:");
		actorOnConditionsDetailsPage.EnterRelevantDetailsData("Next", conditionData);
		actorOnConditionsDetailsPage.IsTabDisplayed("Tags/Notes", "Tags Panel");
		actorOnConditionsDetailsPage.clickIfClickable("Conditions Tags/Notes Save");
		waitForbusy();
	}
	
	@Then("^The user searches conditions with the following data and deletes them$")
	public void DeleteCondition(DataTable conditionData) throws Throwable {
		actorOnConditionsDetailsPage.userDeletesCondition(conditionData);
	}
}
