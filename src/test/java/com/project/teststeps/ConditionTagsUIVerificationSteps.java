package com.project.teststeps;

import com.project.actors.ActorConditionTagsNotesPage;

import com.project.common.util.RxNovaCommonUtil;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ConditionTagsUIVerificationSteps {
	@Steps
	ActorConditionTagsNotesPage actorOnConditionsTagsNotesPage;
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	
	@Then("^They verify that \"(.*)\" is displayed$")
	public void ObjectIsDisplayed(String ObjKey) {
		actorOnConditionsTagsNotesPage.ObjectIsDisplayed(ObjKey);
	}
	
	@Then("^They verify whether \"(.*)\" displays \"(.*)\"$")
	public void checkCurrentFieldDisplay(String ObjKey, String expectedDisplay) {
		actorOnConditionsTagsNotesPage.ObjectContainsExpectedText(ObjKey, expectedDisplay);
	}
	
	@Then("^They determine whether \"(.*)\" is disabled$")
	public void ObjectIsDisabled(String ObjKey) {
		actorOnConditionsTagsNotesPage.ObjectIsDisabled(ObjKey);
	}
}
