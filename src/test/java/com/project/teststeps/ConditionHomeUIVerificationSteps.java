package com.project.teststeps;

import com.project.actors.ActorLaunchPage;
import com.project.actors.ActorRegionSelectionPage;
import com.project.actors.ActorConditionsHomePage;
import com.project.common.util.RxNovaCommonUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ConditionHomeUIVerificationSteps {
	@Steps
	ActorLaunchPage actorOnLaunchPage;
	@Steps
	ActorRegionSelectionPage actorOnRegionSelectionPage;
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	@Steps
	ActorConditionsHomePage actorOnConditionsPage;

	
	@Then("^They check whether the \"(.*)\" is displayed$")
	public void ObjectIsDisplayed(String ObjKey) throws InterruptedException {
		actorOnConditionsPage.ObjectIsDisplayed(ObjKey);
	}
	
	@Then("^They check whether dropdown current selected option for \"(.*)\" displays \"(.*)\"$")
	public void checkCurrentDropdownDisplay(String ObjKey, String expectedDisplay) {
		actorOnConditionsPage.checkCurrentDropdownDisplay(ObjKey, expectedDisplay);
	}

	@Then("^They check whether field \"(.*)\" displays \"(.*)\"$")
	public void checkCurrentFieldDisplay(String ObjKey, String expectedDisplay) {
		actorOnConditionsPage.checkCurrentFieldDisplay(ObjKey, expectedDisplay);
	}

	@Then("^They should be able to view the the following \"([^\"]*)\" in the Search Panel$")
	public void viewLabels(String label) {
		actorOnConditionsPage.viewLabels(label);
	}
	
	@Then("^They should be able to view the available contents of \"(.*)\"$")
	public void MCSDropdowncheckContents(String ObjKey) {
		actorOnConditionsPage.MCScheckContents(ObjKey);
	}
	
	@Then("^They should be able to view \"(.*)\" contents for \"(.*)\"$")
	public void DropdownCheckContents(String expected, String ObjKey) {
		actorOnConditionsPage.DropdownCheckContents(expected, ObjKey);
	}
	
	@Then("^User is able view the prefix \"(.*)\" in the \"(.*)\" field$")
	public void checkPrefix(String prefix, String ObjKey) {
		actorOnConditionsPage.checkPrefix(prefix, ObjKey);
	}
	
	@Then("^They check whether \"(.*)\" field is clickable$")
	public void isFieldClickable(String ObjKey) throws InterruptedException {
		actorOnConditionsPage.isFieldClickable(ObjKey);
	}
	
	@When("^They click on \"(.*)\"$")
	public void clickIfClickable(String ObjKey) throws InterruptedException {
		actorOnConditionsPage.clickIfClickable(ObjKey);
	}
	
	@When("^They check whether \"(.*)\" contains \"(.*)\"$")
	public void ObjectContainsExpectedText(String ObjKey, String expectedDisplay) throws InterruptedException {
		actorOnConditionsPage.ObjectContainsExpectedText(ObjKey, expectedDisplay);
	}
	
	@Then("^\"(.*)\" should be disabled$")
	public void ObjectIsDisabled(String ObjKey) {
		actorOnConditionsPage.ObjectIsDisabled(ObjKey);
	}
	
	@When("^They check whether \"(.*)\" is currently showing by checking for \"(.*)\"$")
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		actorOnConditionsPage.IsTabDisplayed(ObjKey, ChildObjKey);
	}
	
}