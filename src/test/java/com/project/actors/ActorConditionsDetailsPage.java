package com.project.actors;

import static org.junit.Assert.*;

import java.util.List;

import com.project.common.util.RxNovaCommonUtil;
import java.util.ArrayList;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import com.project.pages.ConditionsDetailsPage;
import com.project.pages.ConditionsHomePage;
import com.psqframework.core.util.Verify;

import cucumber.api.DataTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ActorConditionsDetailsPage {
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	@Steps
	ConditionsDetailsPage conditionsDetailsPage;
	@Steps 
	ConditionsHomePage conditionsHomePage;
	@Steps
	ActorConditionsHomePage actorOnConditionsHomePage;
	
	@Step
	public void ObjectIsCurrentlyEnabled(String ObjKey) {
		boolean isEnabled = conditionsDetailsPage.ObjectIsCurrentlyEnabled(ObjKey);
		Verify.actualExpected(isEnabled, true, "'" + ObjKey + "'" + " is not currently enabled");
		if(isEnabled == true) {
			System.out.println(ObjKey + " is currently enabled");
		}
	}
	
	@Step
	public boolean isFieldClickable(String ObjKey) {
		boolean isClickable = conditionsDetailsPage.isFieldClickable(ObjKey);
		Verify.actualExpected(isClickable, true, "'" + ObjKey + "'" + " is not currently clickable");
		return(isClickable);
	}
	
	@Step
	public void clickIfClickable(String ObjKey) throws InterruptedException, Throwable {
		boolean isClickable = isFieldClickable(ObjKey);
		if(isClickable == true) {
			conditionsDetailsPage.performClick(ObjKey);
		}
		else {
			String ObjPath = ConditionsDetailsPage.ConditionsHeaderMap.get(ObjKey);
			WebElement currObj = conditionsDetailsPage.find(By.xpath(ObjPath));
			rxNovaCommonUtil.waitFor(currObj);
		}
	}
	
	@Step
	public void SwitchToMostRecentWindow() throws InterruptedException {
		conditionsDetailsPage.SwitchToMostRecentWindow();
	}
	
	@Step
	public void SendKeysToField(String input, String ObjKey) {
		conditionsDetailsPage.SendKeysToField(input, ObjKey);
	}
	
	@Step
	public void SelectFromDropdown(String input, String ObjKey) throws InterruptedException {
		conditionsDetailsPage.mySelectFromDropdown(input, ObjKey);
	}

	@Step
	public void ObjectIsDisplayed(String ObjKey) {
		boolean isDisplayed = conditionsDetailsPage.ObjectIsDisplayed(ObjKey);
		assertTrue("'" + ObjKey + "'" + " is not Displayed", isDisplayed);
	}
	
	@Step
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		boolean isTabDisplayed = conditionsDetailsPage.IsTabProperlyDisplayed(ChildObjKey);
		if(isTabDisplayed == true) {
			rxNovaCommonUtil.CheckBusyState();
		}
		Verify.actualExpected(isTabDisplayed, true, "'" + ObjKey + "'" + " is not Displayed");
	}
	
	@Step
	public void ObjectIsDisabled(String ObjKey) {
		boolean isDisabled = conditionsDetailsPage.ObjectIsDisabled(ObjKey);
		assertTrue("'" + ObjKey + "'" + " is disabled", isDisabled);
	}
	
	@Step
	public void EnterIDs(int stringTargetLength, String ObjKey) {
		String toEnter = rxNovaCommonUtil.FieldIDGenerator(stringTargetLength);
		conditionsDetailsPage.EnterIDs(toEnter, ObjKey);
	}
	
	@Step
	public void EnterRandomWord(String ObjKey) {
		String toEnter = rxNovaCommonUtil.WordGenerator();
		conditionsDetailsPage.EnterIDs(toEnter, ObjKey);
	}
	
	@Step
	public void SelectRandomlyFromDropdown(String ObjKey) {
		conditionsDetailsPage.SelectRandomlyFromDropdown(ObjKey);
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
		conditionsDetailsPage.SendKeysToField(toEnter, "Tracking ID:");
		//Master customer set value is chosen
		SelectFromDropdown(data.get(1).get(1), "Master customer set:");
		//Condition ID is entered
		toEnter = data.get(1).get(2);
		conditionsDetailsPage.SendKeysToField(toEnter, "Condition ID:");
		//Name is entered 
		toEnter = data.get(1).get(3);
		conditionsDetailsPage.SendKeysToField(toEnter, "Name:");
		//Status value is chosen
		SelectFromDropdown(data.get(1).get(4), "Status:");
		//Type value is chosen
		SelectFromDropdown(data.get(1).get(5), "Type:");
		clickIfClickable(ObjKey);
	}
	
	@Step
	public void EnterRelevantDetailsData (String ObjKey, DataTable enterData) throws Throwable {
		List<List<String>> data = enterData.raw();
		String toEnter = "";
		//enter source information
		SelectFromDropdown(data.get(1).get(0), "Source:");
		rxNovaCommonUtil.CheckBusyState();
		//enter field name
		toEnter = data.get(1).get(1);
		System.out.println(toEnter);
		String objpath = ConditionsDetailsPage.ConditionsHeaderMap.get("Field Name:");
		rxNovaCommonUtil.SelectValueFromFieldIntellisence(By.xpath(objpath), toEnter);
		//enter operator information
		toEnter = data.get(1).get(2);
		SelectFromDropdown(toEnter, "Operator for Field");
		//enter value information
		toEnter = data.get(1).get(3);
		conditionsDetailsPage.SendKeysToField(toEnter, "Value for Field");
		clickIfClickable(ObjKey);

	}
	
	@Step
	public void EnteringTrackingIDforConditionDeletion(String ID, String ObjKey) throws InterruptedException, Throwable {
		String ObjPath = ConditionsDetailsPage.ConditionsHeaderMap.get("Conditions Header Delete Tracking ID");
		rxNovaCommonUtil.sendKeysToObject(ObjPath, ID);
		clickIfClickable(ObjKey);
	}
	
	@Step
	public void checkPanelsForCorrectLabels(String label) throws InterruptedException {
	boolean stringsExist = conditionsDetailsPage.checkPanelsForCorrectLabels(label);
	assertTrue(label + " does not exist", stringsExist);
	}
	
	@Step
	public void verifyingOperatorField(String toEnter, String expected) throws Throwable {
		String objpath = ConditionsDetailsPage.ConditionsHeaderMap.get("Field Name:");
		rxNovaCommonUtil.SelectValueFromFieldIntellisence(By.xpath(objpath), toEnter);
		objpath = ConditionsDetailsPage.ConditionsHeaderMap.get("Operator for Field");
		boolean exist = rxNovaCommonUtil.DropdownCheckContents(expected, objpath);
		assertTrue("Operator dropdown does not contain the correct contents", exist);
	}
	
	@Step
	public void benefitCustomerDrpDown(String ObjKey) {
		boolean exist = conditionsDetailsPage.MCScheckContents(ObjKey);
		assertTrue("Benefit Customer set does not display any contents", exist);
	}
	
	@Step
	public void verifyingOperatorFieldwithoutEntry(String ObjKey, String expected) {
		boolean exist = conditionsDetailsPage.DropdownCheckContents(ObjKey, expected);
		assertTrue(ObjKey + "does not display any contents", exist);
	}
	
	@Step
	public void verifyingTableContents(String expected, String ObjKey) throws Throwable {
		List<String> TableElementKeys = new ArrayList<String>();
		TableElementKeys.add("Assoc Table App Type");
		TableElementKeys.add("Assoc Table Customer Set");
		TableElementKeys.add("Assoc Table ID");
		TableElementKeys.add("Assoc Table Priority");
		TableElementKeys.add("Assoc Table Start Date");
		TableElementKeys.add("Assoc Table End Date");
		
		boolean correctContents = false;
		boolean checkCorrectContents = true;
		
		for(String i : TableElementKeys) {
			correctContents = conditionsDetailsPage.verifyingTableContents(expected, i);
			if(correctContents == false) {
				System.out.println("The Associations table does not contain " + i);
				checkCorrectContents = false;
			}
		}
		
		if(checkCorrectContents == false) {
			userDeletesCondition();
			Verify.actualExpected(checkCorrectContents, true, ObjKey + " does not display correct contents");
		}
		else {
			userDeletesCondition();
		}
	}
	
	@Step
	public void userDeletesCondition() throws Throwable {
		clickIfClickable("Conditions Header after Condition Creation");
		String ObjPath = ConditionsDetailsPage.ConditionsHeaderMap.get("Conditions Header Delete");
		WebElement DeleteObj = conditionsDetailsPage.find(By.xpath(ObjPath));
		rxNovaCommonUtil.waitFor(DeleteObj);
		clickIfClickable("Conditions Header Delete");
		EnteringTrackingIDforConditionDeletion("123456789954621", "Conditions Header 2nd Delete");
		ObjPath = ConditionsHomePage.ConditionsHomeMap.get("Condition Deleted Message");
		DeleteObj = conditionsHomePage.find(By.xpath(ObjPath));
		rxNovaCommonUtil.WaitForBusyIcon();
	}
	
	@Step
	public void isAssociationsEnabled() throws Throwable {
		boolean isEnabled = conditionsDetailsPage.ObjectIsCurrentlyEnabled("Associations after Condition Creation");
		if(isEnabled == false) {
			userDeletesCondition();
			Verify.actualExpected(isEnabled, true, "Associations is not currently enabled");
		}
		else {
			userDeletesCondition();
		}
	}
	
	@Step
	public void verifyAssociationsDisplay(String ObjKey, String ChildObjKey) throws Throwable {
		String ChildObjPath = ConditionsDetailsPage.ConditionsHeaderMap.get(ChildObjKey);
		WebElement ChildObj = conditionsDetailsPage.find(By.xpath(ChildObjPath));
		rxNovaCommonUtil.waitFor(ChildObj);
		boolean isTabDisplayed = rxNovaCommonUtil.IsTabProperlyDisplayed(ChildObjPath);
		if(isTabDisplayed == false) {
			userDeletesCondition();
			Verify.actualExpected(isTabDisplayed, true, "'" + ObjKey + "'" + " is not properly displayed");
		}
		else {
			userDeletesCondition();
		}
	}
	
	@Step
	public void verifyMessages() throws Throwable {
		WebElement TableObj = conditionsDetailsPage.find(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/form[3]/div[1]/div[5]/fieldset[1]/div[1]/div[2]"));
		boolean isMessageDisplayed = conditionsDetailsPage.TableMessageProperlyDisplayed(TableObj, "**Only first 299 active associations are displayed.**");
		if(isMessageDisplayed == false) {
			System.out.println("Footnote for 299 active associations at bottom of Associations Table is not properly displayed");
		}
		TableObj = conditionsDetailsPage.find(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/form[3]/div[1]/div[5]/fieldset[1]/div[1]"));
		isMessageDisplayed = isMessageDisplayed && conditionsDetailsPage.TableMessageProperlyDisplayed(TableObj, "**Please view the Conditions Associations report for a full impact analysis.**");
		if(isMessageDisplayed == false) {
			System.out.println("Footnote for full impact analysis at bottom of Associations Table is not properly displayed");
			userDeletesCondition();
			Verify.actualExpected(isMessageDisplayed, true, "Messages below Associations Table are not properly displayed");
		}
		else {
			System.out.println("Messages are properly displayed.");
			userDeletesCondition();
		}
		
		
	}
}
