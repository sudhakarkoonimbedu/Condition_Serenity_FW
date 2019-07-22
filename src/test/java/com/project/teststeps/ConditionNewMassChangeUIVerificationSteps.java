package com.project.teststeps;

import com.project.actors.ActorConditionsMassChangePage;
import com.project.common.util.RxNovaCommonUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ConditionNewMassChangeUIVerificationSteps {

	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	@Steps
	ActorConditionsMassChangePage actorOnConditionsMassChangePage;
	
	@Then("^They check if \"(.*)\" is displaying by checking for \"(.*)\"$")
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		actorOnConditionsMassChangePage.IsTabDisplayed(ObjKey, ChildObjKey);
	}
	
	@When("^They press \"(.*)\"$")
	public void clickIfClickable(String ObjKey) {
		actorOnConditionsMassChangePage.clickIfClickable(ObjKey);
	}
	
	@Then("^The determine whether \"(.*)\" contains \"(.*)\"$")
	public void checkDetailsPanelForCorrectLabels(String ObjKey, String label) throws InterruptedException {
		actorOnConditionsMassChangePage.checkDetailsPanelForCorrectLabels(ObjKey, label);
	}
	
	@Then("^\"(.*)\" should display$")
	public void ObjectIsDisplayed(String ObjKey) {
		actorOnConditionsMassChangePage.ObjectIsDisplayed(ObjKey);
	}
	
	@Then("^They verify Mass Change Search Panel contains all the correct contents$")
	public void checkingItemsInMassChangeSearch() throws InterruptedException {
		actorOnConditionsMassChangePage.checkingItemsInMassChangeSearch();
	}
	
	@Then("^\"(.*)\" drop down list should display list of available Master customer set details$")
	public void MCScheckContents(String ObjKey) {
		actorOnConditionsMassChangePage.MCSDropdowncheckContents(ObjKey);
	}
	
	@Then("^They check whether \"(.*)\" dropdown contains \"(.*)\"$")
	public void DropdownCheckContents(String ObjKey, String expected) {
		actorOnConditionsMassChangePage.DropdownCheckContents(expected, ObjKey);
	}
	
	@Then("^They give the below details and click on \"(.*)\"$")
	public void createNewMassChange(String ObjKey, DataTable NewMassChangeData) throws InterruptedException {
		actorOnConditionsMassChangePage.createNewMassChange(ObjKey, NewMassChangeData);
		actorOnConditionsMassChangePage.clickIfClickable(ObjKey);
		rxNovaCommonUtil.WaitForBusyIcon();
	}
	
	@Then("^Request Edit Panel should display all the correct fields$")
	public void checkRequestEditPanel() throws InterruptedException {
		rxNovaCommonUtil.WaitForBusyIcon();
		actorOnConditionsMassChangePage.checkRequestEditPanel();
	}
	
	@Then("^User deletes newly submitted mass change request$")
	public void deleteRequest() throws InterruptedException {
		rxNovaCommonUtil.WaitForBusyIcon();
		actorOnConditionsMassChangePage.deleteRequest();
		Thread.sleep(2000);
	}
	
	@Then("^They verify that \"(.*)\" contains \"(.*)\"$")
	public void gainInfoFromClickTabs(String ObjKey, String list) {
		actorOnConditionsMassChangePage.gainInfoFromClickTabs(ObjKey, list);
	}
	
}
