package com.project.actors;


import com.project.common.util.RxNovaCommonUtil;
import com.project.pages.ConditionsTagsNotesPage;
import com.psqframework.core.util.Verify;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ActorConditionTagsNotesPage {
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	@Steps
	ConditionsTagsNotesPage conditionsTagsNotesPage;
	
	@Step
	public void ObjectIsDisplayed(String ObjKey) {
		boolean isDisplayed = conditionsTagsNotesPage.ObjectIsDisplayed(ObjKey);
		Verify.actualExpected(isDisplayed, true, "'" + ObjKey + "'" + " object is not displayed ");
	}
	
	@Step
	public void ObjectContainsExpectedText(String ObjKey, String expectedDisplay) {
		boolean matchesExpected = conditionsTagsNotesPage.ObjectContainsExpectedText(ObjKey, expectedDisplay);
		Verify.actualExpected(matchesExpected, true, "'" + ObjKey + "'" + " is not blank by default");
	}
	
	@Step
	public void ObjectIsDisabled(String ObjKey) {
		boolean isDisabled = conditionsTagsNotesPage.ObjectIsDisabled(ObjKey);
		Verify.actualExpected(isDisabled, false, "'" + ObjKey + "'" + " is enabled when it should be disabled");
	}
}
