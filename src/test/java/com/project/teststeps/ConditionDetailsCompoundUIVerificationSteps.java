package com.project.teststeps;

import com.project.actors.ActorConditionsDetailsCompoundPage;
import com.project.common.util.RxNovaCommonUtil;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ConditionDetailsCompoundUIVerificationSteps {
	@Steps
	ActorConditionsDetailsCompoundPage actorOnConditionsDetailsCompPage;
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	
	@Then("^They ensure that they are on \"(.*)\" by checking for \"(.*)\"$")
	public void isTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		actorOnConditionsDetailsCompPage.IsTabDisplayed(ObjKey, ChildObjKey);
	}
	
	@Then("^They check whether \"([^\"]*)\" is displayed in the Details Panel$")
	public void viewLabels(String label) {
		actorOnConditionsDetailsCompPage.viewLabels(label);
	}
	
	@Then("^They determine whether the \"(.*)\" dropdown list contains \"(.*)\" options$")
	public void DropdownCheckContents(String ObjKey, String expected) {
		actorOnConditionsDetailsCompPage.DropdownCheckContents(expected, ObjKey);
	}
	
	@Then("^prefix \"(.*)\" should display beside \"(.*)\" edit field$")
	public void checkPrefix(String prefix, String ObjKey) {
		actorOnConditionsDetailsCompPage.checkPrefix(prefix, ObjKey);
	}
	
	@Then("^They ensure that \"(.*)\" is displayed$")
	public void ObjectIsDisplayed(String ObjKey) {
		actorOnConditionsDetailsCompPage.ObjectIsDisplayed(ObjKey);
	}
	
	@Then("^They ensure that \"(.*)\" are shown for \"(.*)\"$")
	public void checkingConditionsTable(String expected, String ObjKey) throws Throwable {
		actorOnConditionsDetailsCompPage.verifyingTableContents(expected, ObjKey);
	}

	@Then("^They ensure that \"(.*)\" is disabled by default$")
	public void ObjectIsDisabled(String ObjKey) {
		actorOnConditionsDetailsCompPage.ObjectIsDisabled(ObjKey);
	}
	
}
