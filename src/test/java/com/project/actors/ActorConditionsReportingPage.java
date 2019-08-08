package com.project.actors;

import static org.junit.Assert.assertTrue;

import java.util.StringTokenizer;


import com.project.common.util.RxNovaCommonUtil;
import com.project.pages.ConditionsReportingPage;
import com.psqframework.core.util.Verify;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ActorConditionsReportingPage {

	@Steps
	ConditionsReportingPage conditionsReportingPage;
	@Steps 
	RxNovaCommonUtil rxNovaCommonUtil;
	
	@Step
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		boolean isTabDisplayed = conditionsReportingPage.IsTabProperlyDisplayed(ChildObjKey);
		String styleLoad = "";
		while(isTabDisplayed == false && !styleLoad.contains("none;")) {
			styleLoad = rxNovaCommonUtil.CheckBusyState();
			isTabDisplayed = conditionsReportingPage.IsTabProperlyDisplayed(ChildObjKey);
		}
		rxNovaCommonUtil.CheckBusyState();
		Verify.actualExpected(isTabDisplayed, true, "'" + ObjKey + "'" + " is not Displayed");
	}
	
	@Step
	public void checkPanelsForCorrectLabels(String label) throws InterruptedException {
		boolean stringsExist = conditionsReportingPage.checkPanelsForCorrectLabels(label);
		Verify.actualExpected(stringsExist, true, label + " does not exist");
	}
	
	@Step
	public void verifyingDropdownContents(String ObjKey, String expected) {
		boolean exist = conditionsReportingPage.DropdownCheckContents(ObjKey, expected);
		Verify.actualExpected(exist, true, ObjKey + "does not display any contents");
	}
	
	@Step
	public void ObjectIsDisplayed(String ObjKey) throws InterruptedException {
		boolean isDisplayed = conditionsReportingPage.ObjectIsDisplayed(ObjKey);
		Verify.actualExpected(isDisplayed, true, "'" + ObjKey + "'" + " object is not displayed ");
	}
	
	@Step
	public void SelectFromDropdown(String input, String ObjKey) throws InterruptedException {
		conditionsReportingPage.mySelectFromDropdown(input, ObjKey);
	}
	
	@Step
	public void ObjectIsDisabled(String ObjKey) {
		boolean isDisabled = conditionsReportingPage.ObjectIsDisabled(ObjKey);
		Verify.actualExpected(isDisabled, false, "'" + ObjKey + "'" + " is enabled when it should be disabled");
	}
	
	@Step
	public void checkingItemsInAssociationsCriteria() throws InterruptedException {
		String labels = "Master customer set:,Benefit customer set:,Condition ID:,Application type:,Component type:,Effective date from:,Effective date to:";
		StringTokenizer tokenizer = new StringTokenizer(labels, ",");
		while(tokenizer.hasMoreTokens()) {
			String currToken = tokenizer.nextToken();
			boolean exists = conditionsReportingPage.checkingItemsInAssociationsCriteria(currToken);
			Verify.actualExpected(exists, true, currToken + " does not exist");
		}
	}
	
	@Step
	public void checkingItemsInEntityCriteria() throws InterruptedException {
		String labels = "Master customer set:,Condition ID:,Source:,Type:,Status:,Sub-status:,Tags:";
		StringTokenizer tokenizer = new StringTokenizer(labels, ",");
		while(tokenizer.hasMoreTokens()) {
			String currToken = tokenizer.nextToken();
			boolean exists = conditionsReportingPage.checkingItemsInAssociationsCriteria(currToken);
			Verify.actualExpected(exists, true, currToken + " does not exist");
		}
	}
	
	@Step
	public void checkingItemsInFieldAdminUsageCriteria() throws InterruptedException {
		String labels = "Master customer set:,Status:,Retained in history:";
		StringTokenizer tokenizer = new StringTokenizer(labels, ",");
		while(tokenizer.hasMoreTokens()) {
			String currToken = tokenizer.nextToken();
			boolean exists = conditionsReportingPage.checkingItemsInAssociationsCriteria(currToken);
			if(!tokenizer.hasMoreTokens()) {
				currToken = "Include available Argus Master fields";
				exists = conditionsReportingPage.checkingItemsInFieldAdminUsageCriteria(currToken);
			}
			Verify.actualExpected(exists, true, currToken + " does not exist");
		}
	}
	
	@Step
	public void checkingItemsInSampleClaimTestDataCriteria() throws InterruptedException {
		String labels = "Master customer set:,Benefit customer set:,Customer:,Client:,Condition ID:,Fill date:,Coverage code:";
		StringTokenizer tokenizer = new StringTokenizer(labels, ",");
		while(tokenizer.hasMoreTokens()) {
			String currToken = tokenizer.nextToken();
			boolean exists = conditionsReportingPage.checkingItemsInAssociationsCriteria(currToken);
			Verify.actualExpected(exists, true, currToken + " does not exist");
		}
	}
	
	@Step
	public void checkPrefix(String prefix, String ObjKey) {
		boolean hasPrefix = conditionsReportingPage.checkPrefix(prefix, ObjKey);
		Verify.actualExpected(hasPrefix, true, ObjKey + "does not display correct CD prefix");
	}
	
	@Step
	public void ObjectContainsExpectedText(String ObjKey, String expectedDisplay) {
		boolean matchesExpected = conditionsReportingPage.ObjectContainsExpectedText(ObjKey, expectedDisplay);
		assertTrue("'" + ObjKey + "'" + "is not blank by default", matchesExpected);
	}
}
