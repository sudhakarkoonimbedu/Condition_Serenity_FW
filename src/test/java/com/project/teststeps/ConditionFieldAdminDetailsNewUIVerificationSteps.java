package com.project.teststeps;

import com.project.actors.ActorConditionsFieldAdminNew;
import com.project.common.util.RxNovaCommonUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ConditionFieldAdminDetailsNewUIVerificationSteps {

	@Steps
	ActorConditionsFieldAdminNew actorOnFieldAdminDetails;
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	
	
	@Then("^They check if \"(.*)\" is showing by checking for \"(.*)\"$")
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		actorOnFieldAdminDetails.IsTabDisplayed(ObjKey, ChildObjKey);
	}
	
	@Then("^They press on \"(.*)\"$")
	public void clickIfClickable(String ObjKey) throws InterruptedException, Throwable {
		actorOnFieldAdminDetails.clickIfClickable(ObjKey);
	}
	
	@Then("^They enter the following data for Header and press \"(.*)\"$")
	public void EnterRelevantHeaderDetails(String ObjKey, DataTable enterData) throws Throwable, InterruptedException {
		actorOnFieldAdminDetails.EnterRelevantHeaderData(ObjKey, enterData);
	}
	
	@Then("^They check whether \"(.*)\" is currently enabled$")
	public void ObjectIsCurrentlyEnabled(String ObjKey) {
		actorOnFieldAdminDetails.ObjectIsCurrentlyEnabled(ObjKey);
	}
	
	@Then("^They determine whether the \"(.*)\" contains \"(.*)\"$")
	public void checkDetailsPanelForCorrectLabels(String ObjKey, String label) throws InterruptedException {
		actorOnFieldAdminDetails.checkDetailsPanelForCorrectLabels(ObjKey, label);
	}
	
	@Then("^They check if \"(.*)\" is displayed$")
	public void ObjectIsDisplayed(String ObjKey) throws InterruptedException {
		actorOnFieldAdminDetails.ObjectIsDisplayed(ObjKey);
	}
	
	@Then("^They check if \"(.*)\" dropdown list contains \"(.*)\"$")
	public void DropdownCheckContents(String ObjKey, String expected) {
		actorOnFieldAdminDetails.DropdownCheckContents(expected, ObjKey);
	}
	
	@Then("^They check if \"(.*)\" dropdown list contains list of available contents$")
	public void MCScheckContents(String ObjKey) {
		actorOnFieldAdminDetails.MCSDropdowncheckContents(ObjKey);
	}
	
}
