package com.project.actors;

import java.util.List;
import java.util.StringTokenizer;

import com.project.common.util.RxNovaCommonUtil;
import com.project.pages.ConditionsMassChangePage;
import com.psqframework.core.util.Verify;

import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ActorConditionsMassChangePage {
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	@Steps
	ConditionsMassChangePage conditionsMassChangePage;
	@Steps
	ActorConditionsHomePage actorOnConditionsHomePage;
	
	@Step
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		boolean isTabDisplayed = conditionsMassChangePage.IsTabProperlyDisplayed(ChildObjKey);
		String styleLoad = "";
		while(isTabDisplayed == false && !styleLoad.contains("none;")) {
			styleLoad = rxNovaCommonUtil.CheckBusyState();
			isTabDisplayed = conditionsMassChangePage.IsTabProperlyDisplayed(ChildObjKey);
		}
		rxNovaCommonUtil.WaitForBusyIcon();
		Verify.actualExpected(isTabDisplayed, true, "'" + ObjKey + "'" + " is not Displayed");
	}
	
	@Step
	public void isFieldClickable(String ObjKey) {
		boolean isClickable = conditionsMassChangePage.isFieldClickable(ObjKey);
		Verify.actualExpected(isClickable, true, ObjKey + "is not clickable");
	}
	
	@Step
	public void clickIfClickable(String ObjKey) {
		isFieldClickable(ObjKey);
		conditionsMassChangePage.performClick(ObjKey);
	}
	
	@Step
	public void checkDetailsPanelForCorrectLabels(String ObjKey, String label) throws InterruptedException {
		String labels = label;
		StringTokenizer tokenizer = new StringTokenizer(labels, ",");
		while(tokenizer.hasMoreTokens()) {
			String currToken = tokenizer.nextToken();
			boolean exists = conditionsMassChangePage.checkDetailsPanelForCorrectLabels(currToken);
			Verify.actualExpected(exists, true, currToken + " does not exist for " + ObjKey);
		}
	}
	
	@Step
	public void ObjectIsDisplayed(String ObjKey) {
		boolean isDisplayed = conditionsMassChangePage.ObjectIsDisplayed(ObjKey);
		Verify.actualExpected(isDisplayed, true, "'" + ObjKey + "'" + " object is not displayed ");
	}
	
	@Step
	public void checkingItemsInMassChangeSearch() throws InterruptedException {
		String labels = "Master customer set:,Request name:,Request type:,Request status:,Run status,Last name:,First name:,From date:,To date:";
		StringTokenizer tokenizer = new StringTokenizer(labels, ",");
		while(tokenizer.hasMoreTokens()) {
			String currToken = tokenizer.nextToken();
			boolean exists = conditionsMassChangePage.checkingItemsInSearch(currToken);
			Verify.actualExpected(exists, true, currToken + " does not exist");
		}
	}
	
	@Step
	public void MCSDropdowncheckContents(String ObjKey) {
		boolean hasContents = conditionsMassChangePage.MCScheckContents(ObjKey);
		if(hasContents == false) {
			Verify.actualExpected(hasContents, true, "Master customer set dropdown does not have any contents available");
		}
		else {
			System.out.println("Master customer set dropdown contains contents");
		}
	}
	
	@Step
	public void DropdownCheckContents(String expected, String ObjKey) {
		boolean hasCorrectContents = conditionsMassChangePage.DropdownCheckContents(expected, ObjKey);
		Verify.actualExpected(hasCorrectContents, true, ObjKey + " Drop-down list does not have expected contents");
	}
	
	@Step 
	public void createNewMassChange(String ObjKey, DataTable NewMassChangeData) throws InterruptedException {
		List<List<String>> enterData = NewMassChangeData.raw();
		SendKeysToField(enterData.get(1).get(0), "Tracking ID:");
		SendKeysToField(enterData.get(1).get(1), "Reason:");
		SendKeysToField(enterData.get(1).get(2), "Notes:");
		SelectFromDropdown(enterData.get(1).get(3), "New Mass Change Master customer set:");
		rxNovaCommonUtil.CheckBusyState();
		SendKeysToField(enterData.get(1).get(4), "Name:");
		SendKeysToField(enterData.get(1).get(7), "Description:");
	}
	
	@Step
	public void SendKeysToField(String input, String ObjKey) {
		conditionsMassChangePage.SendKeysToField(input, ObjKey);
	}
	
	@Step
	public void SelectFromDropdown(String input, String ObjKey) throws InterruptedException {
		conditionsMassChangePage.mySelectFromDropdown(input, ObjKey);
	}
	
	@Step
	public void checkRequestEditPanel() throws InterruptedException {
		String labels = "Tracking ID:,Reason:,Notes:,Description:,Created by:,Created date:,Created time:,Last maintenance user:,Last maintenance date:,Last maintenance time:";
		StringTokenizer tokenizer = new StringTokenizer(labels, ",");
		while(tokenizer.hasMoreTokens()) {
			String currToken = tokenizer.nextToken();
			boolean exists = conditionsMassChangePage.checkRequestEditPanel(currToken);
			Verify.actualExpected(exists, true, currToken + " does not exist");
		}
	}
	
	@Step
	public void deleteRequest() throws InterruptedException {
		clickIfClickable("Request Action Tab");
		clickIfClickable("Delete Request");
		rxNovaCommonUtil.WaitForBusyIcon();
		clickIfClickable("Yes Delete Request");
		rxNovaCommonUtil.CheckBusyState();
	}
	
	@Step
	public void gainInfoFromClickTabs(String ObjKey, String list) {
		clickIfClickable(ObjKey);
		StringTokenizer tokenizer = new StringTokenizer(list, ",");
		while(tokenizer.hasMoreTokens()) {
			String currToken = tokenizer.nextToken();
			boolean exists = conditionsMassChangePage.gainInfoFromClickTabs(ObjKey, currToken);
			Verify.actualExpected(exists, true, currToken + " does not exist for " + ObjKey);
		}
		conditionsMassChangePage.gainInfoFromClickTabs(ObjKey, list);
	}
}
