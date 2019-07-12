package com.project.pages;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.project.common.util.RxNovaCommonUtil;

import net.thucydides.core.annotations.Steps;

public class ConditionsTagsNotesPage {
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	
	public static Map<String, String> ConditionsTagsNotesMap;
	static {
		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
		tmp.put("Notes", "//textarea[@id='condition_form:condition_notes']");
		tmp.put("Tag Input Field", "//input[@id='condition_form:add_tag_input']");
		tmp.put("Add Button", "//span[contains(text(),'Add')]");
		tmp.put("Tags Table", "//div[@id='condition_form:tags_table']//table");
		tmp.put("Checkbox", "//input[@name='condition_form:tags_table:j_idt190_checkAll']");
		tmp.put("Remove Selected Button", "//span[contains(text(),'Remove Selected')]");
		tmp.put("Previous", "//span[contains(text(),'Previous')]");
		tmp.put("Save", "//span[contains(text(),'Save')]");
		tmp.put("Cancel", "//button[@id='condition_form:condition_tag_cancel_button']//span[@class='ui-button-text'][contains(text(),'Cancel')]");
		ConditionsTagsNotesMap = Collections.unmodifiableMap(tmp);
	}	
	
	public boolean ObjectIsDisplayed(String ObjKey){
		String ObjPath = ConditionsTagsNotesMap.get(ObjKey);
		boolean isDisplayed = rxNovaCommonUtil.ObjectIsDisplayed(ObjPath);
		return(isDisplayed);
	}
	
	public boolean ObjectContainsExpectedText(String ObjKey, String expectedDisplay) {
		String ObjPath = ConditionsTagsNotesMap.get(ObjKey);
		boolean match = rxNovaCommonUtil.ObjectContainsExpectedText(ObjPath, expectedDisplay);
		return(match);
	}
	
	public boolean ObjectIsDisabled(String ObjKey) {
		String ObjPath = ConditionsTagsNotesMap.get(ObjKey);
		boolean isDisabled = rxNovaCommonUtil.ObjectIsDisabled(ObjPath);
		return(isDisabled);
	}
}
