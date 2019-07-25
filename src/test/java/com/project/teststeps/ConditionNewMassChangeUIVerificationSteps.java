package com.project.teststeps;

import org.openqa.selenium.NoSuchElementException;

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
	public void ObjectIsDisplayed(String ObjKey) throws InterruptedException {
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
	
	@Then("^They check that \"(.*)\" dropdown should display \"(.*)\"$")
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
	public void deleteRequest(DataTable enterData) throws InterruptedException {
		rxNovaCommonUtil.WaitForBusyIcon();
		actorOnConditionsMassChangePage.searchRequest(enterData);
		actorOnConditionsMassChangePage.deleteRequest();
	}
	
	@Then("^They verify that \"(.*)\" contains \"(.*)\"$")
	public void gainInfoFromClickTabs(String ObjKey, String list) {
		actorOnConditionsMassChangePage.gainInfoFromClickTabs(ObjKey, list);
	}
	
	@Then("^Ensure \"(.*)\" should be disabled$")
	public void ObjectIsDisabled(String ObjKey) {
		actorOnConditionsMassChangePage.ObjectIsDisabled(ObjKey);
	}
	
	@Then("^They search for the following Mass Change Request based on MCS$")
	public void searchRequestMCS(DataTable enterData) throws InterruptedException {
		actorOnConditionsMassChangePage.searchRequest(enterData);
	}
	
	@Then("^They give the below details for searching based on last & first name$")
	public void searchRequestLastFirst(DataTable enterData) throws InterruptedException {
		actorOnConditionsMassChangePage.searchRequestLastFirst(enterData);
	}
	
	@Then("^They give the below details for searching based on from date & to date$")
	public void searchRequestFromTo(DataTable enterData) throws InterruptedException {
		actorOnConditionsMassChangePage.searchRequestFromTo(enterData);
	}
	
	@Then("^\"(.*)\" should display correct contents$")
	public void checkingRequestTabPanel(String ObjKey) throws InterruptedException {
		actorOnConditionsMassChangePage.checkingRequestTabPanel(ObjKey);
	}
	
	@Then("^They check whether Results Panel contains submitted mass change requests$")
	public void checkingResultsPanelAfterSearch() throws NoSuchElementException, InterruptedException {
		actorOnConditionsMassChangePage.checkingResultsPanelAfterSearch();
	}
	
}
