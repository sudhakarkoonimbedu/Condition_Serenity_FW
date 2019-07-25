package com.project.actors;

import java.util.StringTokenizer;

import com.project.common.util.RxNovaCommonUtil;
import com.project.pages.ConditionsFieldAdminPage;
import com.psqframework.core.util.Verify;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ActorConditionsFieldAdminSearch {
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	@Steps
	ConditionsFieldAdminPage conditionsFieldAdmin;
	
	@Step
	public void checkDetailsPanelForCorrectLabels(String ObjKey, String label) throws InterruptedException {
		String labels = label;
		StringTokenizer tokenizer = new StringTokenizer(labels, ",");
		while(tokenizer.hasMoreTokens()) {
			String currToken = tokenizer.nextToken();
			boolean exists = conditionsFieldAdmin.checkDetailsPanelForCorrectLabels(currToken);
			Verify.actualExpected(exists, true, currToken + " does not exist for " + ObjKey);
		}
	}
	
	@Step
	public void DropdownCheckContents(String expected, String ObjKey) {
		boolean hasCorrectContents = conditionsFieldAdmin.DropdownCheckContents(expected, ObjKey);
		Verify.actualExpected(hasCorrectContents, true, ObjKey + " Drop-down list does not have expected contents");
	}
	
	@Step
	public void MCSDropdowncheckContents(String ObjKey) {
		boolean hasContents = conditionsFieldAdmin.MCScheckContents(ObjKey);
		if(hasContents == false) {
			Verify.actualExpected(hasContents, true, "Master customer set dropdown does not have any contents available");
		}
		else {
			System.out.println("Master customer set dropdown contains contents");
		}
	}
	
	@Step
	public void ObjectIsDisplayed(String ObjKey) throws InterruptedException {
		boolean isDisplayed = conditionsFieldAdmin.ObjectIsDisplayed(ObjKey);
		Verify.actualExpected(isDisplayed, true, "'" + ObjKey + "'" + " object is not displayed ");
	}
}
