package com.project.teststeps;

import com.project.actors.ActorConditionsHeaderPage;
import com.project.actors.ActorLaunchPage;
import com.project.actors.ActorRegionSelectionPage;
import com.project.common.util.RxNovaCommonUtil;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ConditionHeaderUIVerificationSteps {
	@Steps
	ActorLaunchPage actorOnLaunchPage;
	@Steps
	ActorRegionSelectionPage actorOnRegionSelectionPage;
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	@Steps
	ActorConditionsHeaderPage actorOnConditionsHeaderPage;
	
	@Then("^They check if \"(.*)\" displays$")
	public void ObjectIsDisplayed(String ObjKey) {
		actorOnConditionsHeaderPage.ObjectIsDisplayed(ObjKey);
	}
	
	@Then("^They determine whether \"(.*)\" is currently showing by checking for \"(.*)\"$")
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		actorOnConditionsHeaderPage.IsTabDisplayed(ObjKey, ChildObjKey);
	}
	
	@Then("^They determine whether the following \"([^\"]*)\" are displayed in the Header panel$")
	public void checkPanelsForCorrectLabels(String label) throws InterruptedException {
		actorOnConditionsHeaderPage.checkPanelsForCorrectLabels(label);
	}
	
	@Then("^They determine whether the \"(.*)\" is displayed in the Header panel$")
	public void isNotesDisplayed(String label) throws InterruptedException {
		actorOnConditionsHeaderPage.isNotesDisplayed(label);
	}
	
	@Then("^They check whether Next and Cancel buttons are displayed$")
	public void checkNextandCancel() throws Throwable {
		actorOnConditionsHeaderPage.checkNextandCancel();
	}
	
	@Then("^They should be able to view contents of \"(.*)\"$")
	public void MCScheckContents(String ObjKey) {
		actorOnConditionsHeaderPage.MCSDropdowncheckContents(ObjKey);
	}
	
	@Then("^User should be able to view the prefix \"(.*)\" in the \"(.*)\" field$")
	public void checkPrefix(String prefix, String ObjKey) {
		actorOnConditionsHeaderPage.checkPrefix(prefix, ObjKey);
	}
	
	@Then("^User should be able to view \"(.*)\" options for \"(.*)\" dropdown$")
	public void DropdownCheckContents(String expected, String ObjKey) {
		actorOnConditionsHeaderPage.DropdownCheckContents(expected, ObjKey);
	}
}
