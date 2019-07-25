package com.project.teststeps;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cucumber.api.java.en.Then;

import com.project.actors.ActorConditionsReportingPage;
import com.project.actors.ActorConditionsHomePage;
import com.project.actors.ActorLaunchPage;
import com.project.actors.ActorRegionSelectionPage;
import com.project.common.util.RxNovaCommonUtil;

import net.thucydides.core.annotations.Steps;

public class ConditionReportingUIVerificationSteps {
	@Steps
	ActorLaunchPage actorOnLaunchPage;
	@Steps
	ActorRegionSelectionPage actorOnRegionSelectionPage;
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	@Steps
	ActorConditionsReportingPage actorOnConditionsReportingPage;
	
	@Then("^They determine if \"(.*)\" is showing by checking for \"(.*)\"$")
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		actorOnConditionsReportingPage.IsTabDisplayed(ObjKey, ChildObjKey);
	}
	
	@Then("^They check whether the following \"([^\"]*)\" are shown in the Reporting Panel$")
	public void checkPanelsForCorrectLabels(String label) throws InterruptedException {
		actorOnConditionsReportingPage.checkPanelsForCorrectLabels(label);
	}
	
	@Then("^They check whether \"(.*)\" dropdown list displays \"(.*)\"$")
	public void verifyingDropdownContents(String ObjKey, String expected) {
		actorOnConditionsReportingPage.verifyingDropdownContents(ObjKey, expected);
	}
	
	@Then("^User is on Conditions Reporting page, they select \"(.*)\" for \"(.*)\"$")
	public void selectingAssociationsType(String expected, String ObjKey) throws InterruptedException {
		actorOnConditionsReportingPage.IsTabDisplayed("Reporting", "Report type:");
		actorOnConditionsReportingPage.SelectFromDropdown(expected, ObjKey);
	}
	
	@Then("^\"(.*)\" must be displayed$")
	public void ObjectIsDisplayed(String ObjKey) throws InterruptedException {
		actorOnConditionsReportingPage.ObjectIsDisplayed(ObjKey);
	}

	@Then("^They select \"(.*)\" for \"(.*)\"$")
	public void SelectFromDropdown(String input, String ObjKey) throws InterruptedException {
		actorOnConditionsReportingPage.SelectFromDropdown(input, ObjKey);
	}
	
	@Then("^They check whether \"(.*)\" is disabled$")
	public void ObjectIsDisabled(String ObjKey) {
		actorOnConditionsReportingPage.ObjectIsDisabled(ObjKey);
	}
	
	@Then("^They check whether all of the correct fields are showing in the Associations Panel$")
	public void checkingItemsInAssociationsCriteria() throws InterruptedException {
		actorOnConditionsReportingPage.checkingItemsInAssociationsCriteria();
	}
	
	@Then("^They check whether all of the correct fields are showing in the Entity Panel$")
	public void checkingItemsInEntityCriteria() throws InterruptedException {
		actorOnConditionsReportingPage.checkingItemsInEntityCriteria();
	}
	
	@Then("^They check whether all of the correct fields are showing in the Field Admin Usage Panel$")
	public void checkingItemsInFieldAdminUsageCriteria() throws InterruptedException {
		actorOnConditionsReportingPage.checkingItemsInFieldAdminUsageCriteria();
	}
	
	@Then("^They check whether all of the correct fields are showing in the Sample Claim Test Data Criteria Panel$")
	public void checkingItemsInSampleClaimTestDataCriteria() throws InterruptedException {
		actorOnConditionsReportingPage.checkingItemsInSampleClaimTestDataCriteria();
	}
	
	@Then("^They determine whether the \"(.*)\" prefix shows up in front of \"(.*)\" field$")
	public void checkPrefix(String prefix, String ObjKey) {
		actorOnConditionsReportingPage.checkPrefix(prefix, ObjKey);
	}
	
	@Then("^They check whether \"(.*)\" displays \"(.*)\"$")
	public void checkCurrentFieldDisplay(String ObjKey, String expectedDisplay) {
		actorOnConditionsReportingPage.ObjectContainsExpectedText(ObjKey, expectedDisplay);
	}
	
}
