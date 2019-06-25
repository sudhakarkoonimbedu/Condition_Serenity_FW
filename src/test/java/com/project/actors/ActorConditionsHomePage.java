package com.project.actors;

import static org.junit.Assert.*;

import com.project.pages.ConditionsHomePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ActorConditionsHomePage {
	
	@Steps
	ConditionsHomePage conditionsHomePage;
	
	@Step
	public void ObjectIsDisplayed(String ObjKey) {
		boolean isDisplayed = conditionsHomePage.ObjectIsDisplayed(ObjKey);
		assertTrue("'" + ObjKey + "'" + " object is not displayed ", isDisplayed);
	}
	
	@Step
	public void ObjectContainsExpectedText(String ObjKey, String expectedDisplay) {
		ObjectIsDisplayed(ObjKey);
		boolean containsExpected = conditionsHomePage.ObjectContainsExpectedText(ObjKey, expectedDisplay);
		assertTrue("'" + ObjKey + "'" + " does not contain " + expectedDisplay, containsExpected);
		
	}
	
	@Step
	public void checkCurrentDropdownDisplay(String ObjKey, String expectedDisplay) {
		boolean matchesExpected = conditionsHomePage.checkCurrentDropdownDisplay(ObjKey, expectedDisplay);
		assertTrue("'" + ObjKey + "'" + "is not blank by default", matchesExpected);
	}
	
	@Step
	public void checkCurrentFieldDisplay(String ObjKey, String expectedDisplay) {
		boolean matchesExpected = conditionsHomePage.checkCurrentFieldDisplay(ObjKey, expectedDisplay);
		assertTrue("'" + ObjKey + "'" + "is not blank by default", matchesExpected);
	}
	
	@Step 
	public void viewLabels(String label) {
		boolean labelExists = conditionsHomePage.viewLabels(label);
		assertTrue(label + "does not exist.", labelExists);
	}
	
	@Step
	public void MCScheckContents(String ObjKey){
		boolean hasContents = conditionsHomePage.MCScheckContents(ObjKey);
		assertTrue("MCS Drop-down list does not have contents", hasContents);
	}
	
	@Step
	public void DropdownCheckContents(String expected, String ObjKey) {
		boolean hasCorrectContents = conditionsHomePage.DropdownCheckContents(expected, ObjKey);
		assertTrue(ObjKey + "Drop-down list does not have expected contents", hasCorrectContents);
	}
	
	@Step
	public void checkPrefix(String prefix, String ObjKey) {
		boolean hasPrefix = conditionsHomePage.checkPrefix(prefix, ObjKey);
		assertTrue(ObjKey + "does not display correct CD prefix", hasPrefix);
	}
	
	@Step
	public void isFieldClickable(String ObjKey) {
		boolean isClickable = conditionsHomePage.isFieldClickable(ObjKey);
		assertTrue(ObjKey + "is not clickable", isClickable);
	}
	
	@Step
	public void clickIfClickable(String ObjKey) {
		isFieldClickable(ObjKey);
		conditionsHomePage.performClick(ObjKey);
	}
	
	@Step
	public void ObjectIsDisabled(String ObjKey) {
		boolean isDisabled = conditionsHomePage.ObjectIsDisabled(ObjKey);
		assertTrue("'" + ObjKey + "'" + " is disabled", isDisabled);
	}
	
	@Step
	public void IsTabDisplayed(String ObjKey, String ChildObjKey) {
		boolean isTabDisplayed = conditionsHomePage.IsTabProperlyDisplayed(ChildObjKey);
		assertTrue("'" + ObjKey + "'" + " is not displayed", isTabDisplayed);
	}

}
	
