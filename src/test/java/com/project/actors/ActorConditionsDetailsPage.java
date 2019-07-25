package com.project.actors;

import static org.junit.Assert.*;

import java.util.List;

import com.project.common.util.RxNovaCommonUtil;
import java.util.ArrayList;
import java.util.Arrays;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import com.project.pages.ConditionsDetailsSinglePage;
import com.project.pages.ConditionsHomePage;
import com.psqframework.core.util.Verify;

import cucumber.api.DataTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ActorConditionsDetailsPage {
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	@Steps
	ConditionsDetailsSinglePage conditionsDetailsPage;
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
			System.out.println("This is the click ObjKey: " + ObjKey);
		}
		else {
			String ObjPath = ConditionsDetailsSinglePage.ConditionsHeaderMap.get(ObjKey);
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
	public void ObjectIsDisplayed(String ObjKey) throws InterruptedException {
		boolean isDisplayed = conditionsDetailsPage.ObjectIsDisplayed(ObjKey);
		assertTrue("'" + ObjKey + "'" + " is not Displayed", isDisplayed);
	}
	
	@Step
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) throws InterruptedException {
		boolean isTabDisplayed = conditionsDetailsPage.IsTabProperlyDisplayed(ChildObjKey);
		String styleLoad = "";
		while(isTabDisplayed == false && !styleLoad.contains("none;")) {
			styleLoad = rxNovaCommonUtil.CheckBusyState();
			isTabDisplayed = conditionsDetailsPage.IsTabProperlyDisplayed(ChildObjKey);
		}
		rxNovaCommonUtil.WaitForBusyIcon();
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
		SelectFromDropdown(data.get(1).get(6), "Source:");
		rxNovaCommonUtil.CheckBusyState();
		//enter field name
		toEnter = data.get(1).get(7);
		System.out.println(toEnter);
		String objpath = ConditionsDetailsSinglePage.ConditionsHeaderMap.get("Field Name:");
		rxNovaCommonUtil.SelectValueFromFieldIntellisence(By.xpath(objpath), toEnter);
		//enter operator information
		toEnter = data.get(1).get(8);
		SelectFromDropdown(toEnter, "Operator for Field");
		//enter value information
		toEnter = data.get(1).get(9);
		conditionsDetailsPage.SendKeysToField(toEnter, "Value for Field");
		clickIfClickable(ObjKey);
	}
	
	@Step
	public void EnterRelevantDetailsDataFewerFields (String ObjKey, DataTable enterData) throws Throwable {
		List<List<String>> data = enterData.raw();
		String toEnter = "";
		//enter source information
		SelectFromDropdown(data.get(1).get(0), "Source:");
		rxNovaCommonUtil.CheckBusyState();
		//enter field name
		toEnter = data.get(1).get(1);
		System.out.println(toEnter);
		String objpath = ConditionsDetailsSinglePage.ConditionsHeaderMap.get("Field Name:");
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
	public void EnterRelevantDetailsDataFewFields (String ObjKey, DataTable enterData) throws Throwable {
		List<List<String>> data = enterData.raw();
		String toEnter = "";
		//enter source information
		SelectFromDropdown(data.get(1).get(6), "Source:");
		rxNovaCommonUtil.CheckBusyState();
		//enter field name
		toEnter = data.get(1).get(7);
		System.out.println(toEnter);
		String objpath = ConditionsDetailsSinglePage.ConditionsHeaderMap.get("Field Name:");
		rxNovaCommonUtil.SelectValueFromFieldIntellisence(By.xpath(objpath), toEnter);
		//enter operator information
		toEnter = data.get(1).get(8);
		SelectFromDropdown(toEnter, "Operator for Field");
		//enter value information
		toEnter = data.get(1).get(9);
		conditionsDetailsPage.SendKeysToField(toEnter, "Value for Field");
		clickIfClickable(ObjKey);
	}
	
	@Step
	public void EnteringTrackingIDforConditionDeletion(String ID, String ObjKey) throws InterruptedException, Throwable {
		String ObjPath = ConditionsDetailsSinglePage.ConditionsHeaderMap.get("Conditions Header Delete Tracking ID");
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
		String objpath = ConditionsDetailsSinglePage.ConditionsHeaderMap.get("Field Name:");
		rxNovaCommonUtil.SelectValueFromFieldIntellisence(By.xpath(objpath), toEnter);
		objpath = ConditionsDetailsSinglePage.ConditionsHeaderMap.get("Operator for Field");
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
		rxNovaCommonUtil.WaitForBusyIcon();
		List<String> TableElementKeys = new ArrayList<String>(Arrays.asList(expected.split(",")));
		
		
		boolean correctContents = false;
		boolean checkCorrectContents = true;
		
		for(String i : TableElementKeys) {
			correctContents = conditionsDetailsPage.verifyingTableContents(i, ObjKey);
			if(correctContents == false) {
				System.out.println("The table does not contain " + i);
				checkCorrectContents = false;
			}
		}
		
		Verify.actualExpected(checkCorrectContents, true, ObjKey + " does not display correct contents");

	}
	
	@Step
	public void userDeletesCondition(DataTable conditionData) throws Throwable {
		List<List<String>> data = conditionData.raw();
		clickIfClickable("Conditions Home Breadcrumb");
		//select master customer set
		System.out.println("These are the following data");
		System.out.println("Master customer set: " + data.get(1).get(1));
		System.out.println("Type: " + data.get(1).get(5));
		System.out.println("Condition ID:" + data.get(1).get(2));
		System.out.println("Name: " + data.get(1).get(3));
		System.out.println("Status: " + data.get(1).get(4));
		/////////////////////////////
		conditionsHomePage.mySelectFromDropdown(data.get(1).get(1), "Master customer set:");
		rxNovaCommonUtil.WaitForBusyIcon();
		conditionsHomePage.mySelectFromDropdown(data.get(1).get(5), "Type:");
		rxNovaCommonUtil.WaitForBusyIcon();
		conditionsHomePage.SendKeysToField(data.get(1).get(2), "Condition ID:");
		rxNovaCommonUtil.WaitForBusyIcon();
		conditionsHomePage.SendKeysToField(data.get(1).get(3), "Name:");
		rxNovaCommonUtil.WaitForBusyIcon();
		conditionsHomePage.mySelectFromDropdown(data.get(1).get(4), "Status:");
		rxNovaCommonUtil.WaitForBusyIcon();
		clickIfClickable("Conditions Home Search");
		rxNovaCommonUtil.WaitForBusyIcon();
//		String ObjPath = ConditionsDetailsSinglePage.ConditionsHeaderMap.get("Conditions Header Delete");
//		WebElement DeleteObj = conditionsDetailsPage.find(By.xpath(ObjPath));
//		rxNovaCommonUtil.waitFor(DeleteObj);
		clickIfClickable("Conditions Header Delete");
		rxNovaCommonUtil.WaitForBusyIcon();
		EnteringTrackingIDforConditionDeletion(data.get(1).get(0), "Conditions Header 2nd Delete");
		rxNovaCommonUtil.WaitForBusyIcon();
		String ObjPath = ConditionsHomePage.ConditionsHomeMap.get("Condition Deleted Message");
		WebElement DeleteObj = conditionsHomePage.find(By.xpath(ObjPath));
		rxNovaCommonUtil.waitFor(DeleteObj);
	}
	
	@Step
	public void isAssociationsEnabled() throws Throwable {
		boolean isEnabled = conditionsDetailsPage.ObjectIsCurrentlyEnabled("Associations after Condition Creation");
		Verify.actualExpected(isEnabled, true, "Associations is not currently enabled");
	}
	
	@Step
	public void isPreTestEnabled() throws Throwable {
		boolean isEnabled = conditionsDetailsPage.ObjectIsCurrentlyEnabled("Pre-Test after Condition Creation");
		Verify.actualExpected(isEnabled, true, "Pre-Test is not currently enabled");	
		if(isEnabled == true) {
			System.out.println("Pre-Test is currently enabled");
		}
	}
	
	@Step
	public void verifyAssociationsDisplay(String ObjKey, String ChildObjKey) throws Throwable {
		String ChildObjPath = ConditionsDetailsSinglePage.ConditionsHeaderMap.get(ChildObjKey);
		WebElement ChildObj = conditionsDetailsPage.find(By.xpath(ChildObjPath));
		rxNovaCommonUtil.waitFor(ChildObj);
		boolean isTabDisplayed = rxNovaCommonUtil.IsTabProperlyDisplayed(ChildObjPath);
		Verify.actualExpected(isTabDisplayed, true, "'" + ObjKey + "'" + " is not properly displayed");
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
		}
		else {
			System.out.println("Messages are properly displayed.");
		}
		Verify.actualExpected(isMessageDisplayed, true, "Messages below Associations Table are not properly displayed");
	}
	
	@Step
	public void verifyPreTestMessages(String ObjKey, String expected) throws Throwable {
		boolean isContained = conditionsDetailsPage.ObjectContainsExpectedText(ObjKey, expected);
		if(isContained == false) {
			System.out.println("Condition(s) to be Evaluated panel does not display correct 'Please enter data for the following condition(s) to be evaluated:' message");
		}
		else {
			System.out.println("Condition(s) to be Evaluated panel does display correct 'Please enter data for the following condition(s) to be evaluated:' message");
		}
		Verify.actualExpected(isContained, true, "Condition(s) to be Evaluated panel does not display correct 'Please enter data for the following condition(s) to be evaluated:' message");
	}
	
	@Step
	public void PreTestObjectEnabled(String ObjKey) throws Throwable {
		boolean isEnabled = conditionsDetailsPage.ObjectIsCurrentlyEnabled(ObjKey);
		if(isEnabled == false) {
			Verify.actualExpected(isEnabled, true, ObjKey + " is not currently enabled");
		}
		else {
			System.out.println(ObjKey + " is currently enabled");
		}
	}
}
