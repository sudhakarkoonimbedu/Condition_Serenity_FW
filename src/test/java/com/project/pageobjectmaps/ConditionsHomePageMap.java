package com.project.pageobjectmaps;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class ConditionsPageMap {
	//Hashes all xpaths within the contentFrame of the page into different containers so that they can be accessed earlier than the Page stage of code.
	//Keys in HashMap are specified names of WebElements; Values are XPaths
		public static Map<String, String> ConditionsMap;
		static {
			Map<String, String> tmp = new ConcurrentHashMap<String, String>();
			tmp.put("Condition Home Icon", "//a[@id='breadCrumbForm:j_idt51']");
			tmp.put("Condition Home Breadcrumb", "//a[@id='breadCrumbForm:j_idt52']");
			tmp.put("Condition Home", "//em[contains(text(),'Condition Home')]");
			tmp.put("Master customer set:", "//select[@id='condition_form:condition_masterCustormerSet']");
			tmp.put("Type:", "//select[@id='condition_form:j_idt208']");
			tmp.put("Condition ID:", "//input[@id='condition_form:condition_id']");
			tmp.put("Condition ID CD", "//input[@id='condition_form:j_idt212']");
			tmp.put("Name:", "//input[@id='condition_form:condition_name']");
			tmp.put("Status:", "//select[@name='condition_form:j_idt217']");
			tmp.put("Source:", "//select[@id='condition_form:condition_source']");
			tmp.put("Advanced Search", "//a[@id='condition_form:advancedSearchBtn']");
			tmp.put("Sub-status:", "//select[@id='condition_form:subStatus']");
			tmp.put("Tags:", "//input[@id='condition_form:condition_tag_input']");
			tmp.put("Add", "//span[contains(text(),'Add')]");
			tmp.put("Tag Check Box", "//input[@name='condition_form:tags_table:j_idt248_checkAll']");
			tmp.put("Remove Selected", "//button[@id='condition_form:remove_select_button']");
			tmp.put("Conditions Search", "//span[contains(text(),'Search')]");
			tmp.put("Conditions Reset", "//span[contains(text(),'Reset')]");
			tmp.put("Conditions New", "//span[@class='ui-button-text'][contains(text(),'New')]");
			tmp.put("Tags Table", "//div[@id='condition_form:tags_table']");
			tmp.put("Results Panel", "//legend[contains(text(),'Results')]");
			ConditionsMap = Collections.unmodifiableMap(tmp);
		}
}
