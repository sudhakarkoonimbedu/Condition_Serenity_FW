package com.project.teststeps;

import com.project.actors.ActorConditionsFieldAdminSearch;
import com.project.common.util.RxNovaCommonUtil;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ConditionFieldAdminSearchUIVerificationSteps {
	
	@Steps
	ActorConditionsFieldAdminSearch actorOnFieldAdminSearch;
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	
	@Then("^They verify whether \"(.*)\" contains \"(.*)\"$")
	public void checkDetailsPanelForCorrectLabels(String ObjKey, String label) throws InterruptedException {
		actorOnFieldAdminSearch.checkDetailsPanelForCorrectLabels(ObjKey, label);
	}
	
	@Then("^They verify whether \"(.*)\" dropdown contains \"(.*)\"$")
	public void DropdownCheckContents(String ObjKey, String expected) {
		actorOnFieldAdminSearch.DropdownCheckContents(expected, ObjKey);
	}
	
	@Then("^They verify whether \"(.*)\" dropdown contains list of existing customers$")
	public void MCScheckContents(String ObjKey) {
		actorOnFieldAdminSearch.MCSDropdowncheckContents(ObjKey);
	}
	
	@Then("^They verify whether \"(.*)\" is displayed$")
	public void ObjectIsDisplayed(String ObjKey) throws InterruptedException {
		actorOnFieldAdminSearch.ObjectIsDisplayed(ObjKey);
	}
	
}
