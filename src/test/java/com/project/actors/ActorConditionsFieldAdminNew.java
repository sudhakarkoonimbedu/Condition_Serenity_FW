package com.project.actors;

import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.common.util.RxNovaCommonUtil;
import com.project.pages.ConditionsDetailsSinglePage;
import com.project.pages.ConditionsFieldAdminNewPage;
import com.psqframework.core.util.Verify;

import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ActorConditionsFieldAdminNew {
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	@Steps
	ConditionsFieldAdminNewPage conditionsFieldAdminDetails;
	
	@Step
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		boolean isTabDisplayed = conditionsFieldAdminDetails.IsTabProperlyDisplayed(ChildObjKey);
		String styleLoad = "";
		while(isTabDisplayed == false && !styleLoad.contains("none;")) {
			styleLoad = rxNovaCommonUtil.CheckBusyState();
			isTabDisplayed = conditionsFieldAdminDetails.IsTabProperlyDisplayed(ChildObjKey);
		}
		rxNovaCommonUtil.WaitForBusyIcon();
		Verify.actualExpected(isTabDisplayed, true, "'" + ObjKey + "'" + " is not Displayed");
	}
	
	@Step
	public boolean isFieldClickable(String ObjKey) throws InterruptedException {
		boolean isClickable = conditionsFieldAdminDetails.isFieldClickable(ObjKey);
		Verify.actualExpected(isClickable, true, "'" + ObjKey + "'" + " is not currently clickable");
		return(isClickable);
	}
	
	@Step
	public void clickIfClickable(String ObjKey) throws InterruptedException, Throwable {
		boolean isClickable = isFieldClickable(ObjKey);
		if(isClickable == true) {
			conditionsFieldAdminDetails.performClick(ObjKey);
			System.out.println("This is the click ObjKey: " + ObjKey);
		}
		else {
			String ObjPath = ConditionsDetailsSinglePage.ConditionsHeaderMap.get(ObjKey);
			WebElement currObj = conditionsFieldAdminDetails.find(By.xpath(ObjPath));
			rxNovaCommonUtil.waitFor(currObj);
		}
	}
	
	@Step
	public void SendKeysToField(String input, String ObjKey) {
		conditionsFieldAdminDetails.SendKeysToField(input, ObjKey);
	}
	
	@Step
	public void SelectFromDropdown(String input, String ObjKey) throws InterruptedException {
		conditionsFieldAdminDetails.mySelectFromDropdown(input, ObjKey);
	}
	
	@Step
	public void EnterRelevantHeaderData(String ObjKey, DataTable enterData) throws InterruptedException, Throwable {
		//include hashmap vars here.
		List<List<String>> data = enterData.raw();
		String toEnter = "";
		//enters tracking ID
		if(data.get(1).get(0).equals("")) {
			toEnter = rxNovaCommonUtil.FieldIDGenerator(15);
		}
		else {
			toEnter = data.get(1).get(0);
		}
		conditionsFieldAdminDetails.SendKeysToField(toEnter, "Tracking ID:");
		//Master customer set value is chosen
		SelectFromDropdown(data.get(1).get(1), "Master customer set:");
		//Condition ID is entered
		toEnter = data.get(1).get(2);
		conditionsFieldAdminDetails.SendKeysToField(toEnter, "Argus field name:");
		//Name is entered 
		toEnter = data.get(1).get(3);
		conditionsFieldAdminDetails.SendKeysToField(toEnter, "Business field name:");
		//Status value is chosen
		SelectFromDropdown(data.get(1).get(4), "Status:");
		clickIfClickable(ObjKey);
	}
	
	@Step
	public void ObjectIsCurrentlyEnabled(String ObjKey) {
		boolean isEnabled = conditionsFieldAdminDetails.ObjectIsCurrentlyEnabled(ObjKey);
		Verify.actualExpected(isEnabled, true, "'" + ObjKey + "'" + " is not currently enabled");
		if(isEnabled == true) {
			System.out.println(ObjKey + " is currently enabled");
		}
	}
	
	@Step
	public void checkDetailsPanelForCorrectLabels(String ObjKey, String label) throws InterruptedException {
		String labels = label;
		StringTokenizer tokenizer = new StringTokenizer(labels, ",");
		while(tokenizer.hasMoreTokens()) {
			String currToken = tokenizer.nextToken();
			boolean exists = conditionsFieldAdminDetails.checkDetailsPanelForCorrectLabels(currToken);
			Verify.actualExpected(exists, true, currToken + " does not exist for " + ObjKey);
		}
	}
	
	@Step
	public void ObjectIsDisplayed(String ObjKey) throws InterruptedException {
		boolean isDisplayed = conditionsFieldAdminDetails.ObjectIsDisplayed(ObjKey);
		Verify.actualExpected(isDisplayed, true, "'" + ObjKey + "'" + " object is not displayed ");
	}
	
	@Step
	public void DropdownCheckContents(String expected, String ObjKey) {
		boolean hasCorrectContents = conditionsFieldAdminDetails.DropdownCheckContents(expected, ObjKey);
		Verify.actualExpected(hasCorrectContents, true, ObjKey + " Drop-down list does not have expected contents");
	}
	
	@Step
	public void MCSDropdowncheckContents(String ObjKey) {
		boolean hasContents = conditionsFieldAdminDetails.MCScheckContents(ObjKey);
		if(hasContents == false) {
			Verify.actualExpected(hasContents, true, "Master customer set dropdown does not have any contents available");
		}
		else {
			System.out.println("Master customer set dropdown contains contents");
		}
	}
	
}
