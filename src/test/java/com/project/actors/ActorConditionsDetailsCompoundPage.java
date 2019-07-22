package com.project.actors;

import java.util.ArrayList;
import java.util.List;

import com.project.common.util.RxNovaCommonUtil;
import com.project.pages.ConditionsDetailsCompoundPage;
import com.project.pages.ConditionsHomePage;
import com.psqframework.core.util.Verify;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ActorConditionsDetailsCompoundPage {
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	@Steps
	ConditionsDetailsCompoundPage conditionsDetailsCompoundPage;
	@Steps 
	ConditionsHomePage conditionsHomePage;
	@Steps
	ActorConditionsHomePage actorOnConditionsHomePage;
	
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		boolean isDisplayed = conditionsDetailsCompoundPage.IsTabProperlyDisplayed(ChildObjKey);
		String styleLoad = "";
		while(isDisplayed == false && !styleLoad.contains("none;")) {
			styleLoad = rxNovaCommonUtil.CheckBusyState();
			isDisplayed = conditionsDetailsCompoundPage.IsTabProperlyDisplayed(ChildObjKey);
		}
		rxNovaCommonUtil.WaitForBusyIcon();
		Verify.actualExpected(isDisplayed, true, ObjKey + " is not properly displayed");
	}
	
	@Step 
	public void viewLabels(String label) {
		boolean labelExists = conditionsDetailsCompoundPage.viewLabels(label);
		Verify.actualExpected(labelExists, true, label + " does not exist");
	}
	
	@Step
	public void DropdownCheckContents(String expected, String ObjKey) {
		boolean hasCorrectContents = conditionsDetailsCompoundPage.DropdownCheckContents(expected, ObjKey);
		Verify.actualExpected(hasCorrectContents, true, ObjKey + " Drop-down list does not have expected contents");
	}

	@Step
	public void checkPrefix(String prefix, String ObjKey) {
		boolean hasPrefix = conditionsDetailsCompoundPage.checkPrefix(prefix, ObjKey);
		Verify.actualExpected(hasPrefix, true, ObjKey + " does not display correct CD prefix");
	}
	
	@Step
	public void ObjectIsDisplayed(String ObjKey) {
		boolean isDisplayed = conditionsDetailsCompoundPage.ObjectIsDisplayed(ObjKey);
		Verify.actualExpected(isDisplayed, true, "'" + ObjKey + "'" + " object is not displayed");
	}
	
	@Step
	public void checkingConditionsTable(String ObjKey) {
		boolean isDisplayed = conditionsDetailsCompoundPage.ObjectIsDisplayed(ObjKey);
		Verify.actualExpected(isDisplayed, true, "'" + ObjKey + "'" + "object is not displayed");
	}
	
	@Step
	public void verifyingTableContents(String expected, String ObjKey) throws Throwable {
		List<String> TableElementKeys = new ArrayList<String>();
		TableElementKeys.add("Condition ID");
		TableElementKeys.add("Condition Name");
		
		boolean correctContents = false;
		boolean checkCorrectContents = true;
		
		for(String i : TableElementKeys) {
			correctContents = conditionsDetailsCompoundPage.verifyingTableContents(i, ObjKey);
			if(correctContents == false) {
				System.out.println("The Associations table does not contain " + i);
				checkCorrectContents = false;
			}
		}
		
		if(checkCorrectContents == false) {
			Verify.actualExpected(checkCorrectContents, true, ObjKey + " does not display correct contents");
		}
	}
	
	@Step
	public void ObjectIsDisabled(String ObjKey) {
		boolean isDisabled = conditionsHomePage.ObjectIsDisabled(ObjKey);
		Verify.actualExpected(isDisabled, true, "'" + ObjKey + "'" + " is disabled");
	}
}
