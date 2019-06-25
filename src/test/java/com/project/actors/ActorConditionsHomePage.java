package com.project.actors;

import static org.junit.Assert.*;

import com.project.common.util.RxNovaCommonUtil;
import com.project.pages.ConditionsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ActorConditionsPage {
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtils;
	@Steps
	ConditionsPage conditionsPage;
	
	@Step
	public void ObjectIsDisplayed(String ObjKey) {
		boolean isDisplayed = conditionsPage.ObjectIsDisplayed(ObjKey);
		assertTrue("'" + ObjKey + "'" + " object is not displayed ", isDisplayed);
	}
	
	@Step
	public void ObjectContainsExpectedText(String ObjKey, String expectedDisplay) {
		ObjectIsDisplayed(ObjKey);
		boolean containsExpected = conditionsPage.ObjectContainsExpectedText(ObjKey, expectedDisplay);
		assertTrue("'" + ObjKey + "'" + " does not contain " + expectedDisplay, containsExpected);
		
	}
	
	@Step
	public void checkCurrentDropdownDisplay(String ObjKey, String expectedDisplay) {
		boolean matchesExpected = conditionsPage.checkCurrentDropdownDisplay(ObjKey, expectedDisplay);
		assertTrue("'" + ObjKey + "'" + "is not blank by default", matchesExpected);
	}
	
	@Step
	public void checkCurrentFieldDisplay(String ObjKey, String expectedDisplay) {
		boolean matchesExpected = conditionsPage.checkCurrentFieldDisplay(ObjKey, expectedDisplay);
		assertTrue("'" + ObjKey + "'" + "is not blank by default", matchesExpected);
	}
	
	@Step 
	public void viewLabels(String label) {
		boolean labelExists = conditionsPage.viewLabels(label);
		assertTrue(label + "does not exist.", labelExists);
	}
	
	@Step
	public void MCScheckContents(String ObjKey){
		boolean hasContents = conditionsPage.MCScheckContents(ObjKey);
		assertTrue("MCS Drop-down list does not have contents", hasContents);
	}
	
	@Step
	public void DropdownCheckContents(String expected, String ObjKey) {
		boolean hasCorrectContents = conditionsPage.DropdownCheckContents(expected, ObjKey);
		assertTrue(ObjKey + "Drop-down list does not have expected contents", hasCorrectContents);
	}
	
	@Step
	public void checkPrefix(String prefix, String ObjKey) {
		boolean hasPrefix = conditionsPage.checkPrefix(prefix, ObjKey);
		assertTrue(ObjKey + "does not display correct CD prefix", hasPrefix);
	}
	
	@Step
	public void isFieldClickable(String ObjKey) {
		boolean isClickable = conditionsPage.isFieldClickable(ObjKey);
		assertTrue(ObjKey + "is not clickable", isClickable);
	}
	
	@Step
	public void clickIfClickable(String ObjKey) {
		isFieldClickable(ObjKey);
		conditionsPage.performClick(ObjKey);
	}
	
	@Step
	public void ObjectIsDisabled(String ObjKey) {
		boolean isDisabled = conditionsPage.ObjectIsDisabled(ObjKey);
		assertTrue("'" + ObjKey + "'" + " is disabled", isDisabled);
	}

}
	
