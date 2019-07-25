package com.project.pages;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.common.util.RxNovaCommonUtil;
import com.psqframework.core.page.BasePage;

public class ConditionsReportingPage extends BasePage {
	
	RxNovaCommonUtil rxNovaCommonUtil;
	
	public static Map<String, String> ConditionsReportingMap;
	static {
		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
		tmp.put("Reporting", "//em[contains(text(),'Reporting')]");
		tmp.put("Report type:", "//select[@id='reporting_form:report_type']");
		tmp.put("Report format:", "//select[@id='reporting_form:report_format']");
		tmp.put("Report name:", "//input[@id='reporting_form:report_name']");
		tmp.put("Associations Criteria Panel", "//fieldset[@id='reporting_form:association_report_panel']");
		tmp.put("Entity Criteria Panel", "//fieldset[@id='reporting_form:entity_report_criteria_panel']");
		tmp.put("Master customer set for Association", "//select[@id='reporting_form:customerSet_for_association']");
		tmp.put("Benefit customer set for Association", "//select[@id='reporting_form:benefit_for_association']");
		tmp.put("Condition ID for Association", "//input[@id='reporting_form:condition_id_association']");
		tmp.put("Condition ID CD for Association", "//input[@id='reporting_form:j_idt447']");
		tmp.put("Condition ID Table for Association", "//div[@id='reporting_form:condition_id_table']");
		tmp.put("Application type for Association", "//select[@id='reporting_form:associationApplication']");
		tmp.put("Component type for Association", "//select[@id='reporting_form:reporting_component']");
		tmp.put("Effective date from for Association", "//select[@id='reporting_form:reporting_component']");
		tmp.put("Effective date to for Association", "//input[@id='reporting_form:effectime_to']");
		tmp.put("Remove Selected Button for Association", "//span[contains(text(),'Remove Selected')]");
		tmp.put("Add Button for Association", "//span[contains(text(),'Add')]");
		tmp.put("Report Button for Association", "//span[@class='ui-button-text'][contains(text(),'Report')]");
		tmp.put("Reset Button for Association", "//button[@id='reporting_form:j_idt469']//span[@class='ui-button-text'][contains(text(),'Reset')]");
		tmp.put("Master customer set for Entity", "//select[@id='reporting_form:customerSet_for_entiry']");
		tmp.put("Condition ID for Entity", "//input[@id='reporting_form:condition_id']");
		tmp.put("Condition ID CD for Entity", "//input[@id='reporting_form:j_idt389']");
		tmp.put("Condition ID Table for Entity", "//div[@id='reporting_form:conditions_table']//table");
		tmp.put("Remove Selected Condition ID Button for Entity", "//button[@id='reporting_form:condition_id_remove_button']//span[@class='ui-button-text'][contains(text(),'Remove Selected')]");
		tmp.put("Source for Entity", "//select[@id='reporting_form:condition_source']");
		tmp.put("Type for Entity", "//select[@id='reporting_form:entity_type']");
		tmp.put("Status for Entity", "//select[@id='reporting_form:entity_status']");
		tmp.put("Sub-status for Entity", "//select[@id='reporting_form:subStatus']");
		tmp.put("Tags for Entity", "//input[@id='reporting_form:entity_tag_input']");
		tmp.put("Tags Table for Entity", "//div[@id='reporting_form:tags_table']//table");
		tmp.put("Remove Selected Tags Button for Entity", "//button[@id='reporting_form:remove_select_button']//span[@class='ui-button-text'][contains(text(),'Remove Selected')]");
		tmp.put("Report Button for Entity", "//span[@class='ui-button-text'][contains(text(),'Report')]");
		tmp.put("Reset Button for Entity", "//button[@id='reporting_form:j_idt434']//span[@class='ui-button-text'][contains(text(),'Reset')]");
		tmp.put("Condition ID Add Button for Entity", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/form[1]/div[3]/fieldset[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[5]/button[1]/span[1]");
		tmp.put("Tags Add Button for Entity", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/form[1]/div[3]/fieldset[1]/div[1]/span[3]/table[1]/tbody[1]/tr[1]/td[4]/button[1]/span[1]");
		tmp.put("Tags check all for Entity", "//input[@name='reporting_form:tags_table:j_idt429_checkAll']");
		tmp.put("Field Admin Usage Criteria Panel", "//fieldset[@id='reporting_form:field_admin_usage_panel']//div[@class='ui-fieldset-content']");
		tmp.put("Master customer set for FAU", "//select[@id='reporting_form:customerSet_for_field']");
		tmp.put("Status for FAU", "//select[@id='reporting_form:field_status']");
		tmp.put("Retained in history for FAU", "//select[@id='reporting_form:retained_in_history']");
		tmp.put("Include available Argus Master fields checkbox", "//input[@id='reporting_form:include_available_argus_master']");
		tmp.put("Reset Button for Field Admin Usage", "//button[@id='reporting_form:j_idt380']//span[@class='ui-button-text'][contains(text(),'Reset')]");
		tmp.put("Report Button for Field Admin Usage", "//span[@class='ui-button-text'][contains(text(),'Report')]");
		tmp.put("Coverage Code Add Button for Sample Claim", "//span[contains(text(),'Add')]");
		tmp.put("Remove Button for Sample Claim", "//span[contains(text(),'Remove')]");
		tmp.put("Condition ID CD for Sample Claim", "//input[@id='reporting_form:j_idt487']");
		tmp.put("Coverage Code Table for Sample Claim", "//div[@id='reporting_form:claim_cc_table']");
		tmp.put("Reset Button for Sample Claim", "//button[@id='reporting_form:j_idt502']//span[@class='ui-button-text'][contains(text(),'Reset')]");
		tmp.put("Report Button for Sample Claim", "//span[@class='ui-button-text'][contains(text(),'Report')]");
		tmp.put("Sample Claim Test Data Criteria Panel", "//fieldset[@id='reporting_form:claimtest_report_panel']//div[@class='ui-fieldset-content']");
		ConditionsReportingMap = Collections.unmodifiableMap(tmp);
	}
	
	public boolean IsTabProperlyDisplayed(String ChildObjKey) {
		String ChildObjPath = ConditionsReportingMap.get(ChildObjKey);
		boolean IsTabDisplayed = rxNovaCommonUtil.IsTabProperlyDisplayed(ChildObjPath);
		return(IsTabDisplayed);
	}
	
	public boolean checkPanelsForCorrectLabels(String label) throws InterruptedException {
		rxNovaCommonUtil.CheckBusyState();
		List<WebElement> pageLabels = getDriver().findElements(By.className("firstCommonColumn3"));
		boolean labelMatch = false;
		for(WebElement i : pageLabels) {
			System.out.println(" This panel label is displayed "+i.getText());
			if(i.getText().contains(label)) {
				labelMatch = true;
				break;
			}
		}
		return(labelMatch);
	}
	
	public boolean DropdownCheckContents(String ObjKey, String expected) {
		String ObjPath = ConditionsReportingMap.get(ObjKey);
		System.out.println("this is the object path" + ObjPath);
		boolean hasContents = rxNovaCommonUtil.DropdownCheckContents(expected, ObjPath);
		return(hasContents);
	}
	
	public boolean ObjectIsDisplayed(String ObjKey) throws InterruptedException{
		String ObjPath = ConditionsReportingMap.get(ObjKey);
		boolean isDisplayed = rxNovaCommonUtil.ObjectIsDisplayed(ObjPath);
		return(isDisplayed);
	}
	
	public void mySelectFromDropdown(String input, String ObjKey) throws InterruptedException {
		String ObjPath = ConditionsReportingMap.get(ObjKey);
		WebElement currElement = getDriver().findElement(By.xpath(ObjPath));
		rxNovaCommonUtil.selectFromDropdown(currElement, input);
		rxNovaCommonUtil.CheckBusyState();
	}
	
	public boolean ObjectIsDisabled(String ObjKey) {
		String ObjPath = ConditionsReportingMap.get(ObjKey);
		boolean isDisabled = rxNovaCommonUtil.ObjectIsDisabled(ObjPath);
		return(isDisabled);
	}
	
	public boolean checkingItemsInAssociationsCriteria(String label) throws InterruptedException {
		rxNovaCommonUtil.CheckBusyState();
		List<WebElement> pageLabels = getDriver().findElements(By.className("firstCommonColumn"));
		boolean labelMatch = false;
		for(WebElement i : pageLabels) {
			System.out.println(" This panel label is displayed "+i.getText());
			if(i.getText().contains(label)) {
				labelMatch = true;
				break;
			}
		}
		return(labelMatch);
	}
	
	public boolean checkingItemsInFieldAdminUsageCriteria(String label) throws InterruptedException {
		rxNovaCommonUtil.CheckBusyState();
		List<WebElement> pageLabel = getDriver().findElements(By.className("firstIncludeAvailableArgusMasterFieldsColumn"));
		boolean labelMatch = false;
		for(WebElement i : pageLabel) {
			System.out.println(" This panel label is displayed " + i.getText());
			if(i.getText().contains(label)) {
				labelMatch = true;
				break;
			}
		}
		return(labelMatch);
	}
	
	public boolean checkPrefix(String prefix, String ObjKey) {
		String ObjPath = ConditionsReportingMap.get(ObjKey);
		String checkCD = $(ObjPath).getAttribute("value"); 
		if(checkCD.equals(prefix))
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
	
	public boolean ObjectContainsExpectedText(String ObjKey, String expectedDisplay) {
		String ObjPath = ConditionsReportingMap.get(ObjKey);
		boolean match = rxNovaCommonUtil.ObjectContainsExpectedText(ObjPath, expectedDisplay);
		return(match);
	}
	
//	public static Map<String, String> AssociationsCriteriaMap;
//	static {
//		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
//		tmp.put("Master customer set:", "//select[@id='reporting_form:customerSet_for_association']");
//		tmp.put("Benefit customer set:", "//select[@id='reporting_form:benefit_for_association']");
//		tmp.put("Condition ID:", "//input[@id='reporting_form:condition_id_association']");
//		tmp.put("Condition ID CD", "//input[@id='reporting_form:j_idt447']");
//		tmp.put("Condition ID Table", "//div[@id='reporting_form:condition_id_table']");
//		tmp.put("Application type:", "//select[@id='reporting_form:associationApplication']");
//		tmp.put("Component type:", "//select[@id='reporting_form:reporting_component']");
//		tmp.put("Effective date from:", "//select[@id='reporting_form:reporting_component']");
//		tmp.put("Effective date to:", "//input[@id='reporting_form:effectime_to']");
//		tmp.put("Report Button", "//span[@class='ui-button-text'][contains(text(),'Report')]");
//		tmp.put("Reset Button", "//button[@id='reporting_form:j_idt469']//span[@class='ui-button-text'][contains(text(),'Reset')]");
//		AssociationsCriteriaMap = Collections.unmodifiableMap(tmp);
//	} 
//	
//	public static Map<String, String> EntityCriteriaMap;
//	static {
//		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
//		tmp.put("Master customer set:", "//select[@id='reporting_form:customerSet_for_entiry']");
//		tmp.put("Condition ID:", "//input[@id='reporting_form:condition_id']");
//		tmp.put("Condition ID CD", "//input[@id='reporting_form:j_idt389']");
//		tmp.put("Condition ID Table", "//div[@id='reporting_form:conditions_table']//table");
//		tmp.put("Source:", "//select[@id='reporting_form:condition_source']");
//		tmp.put("Type:", "//select[@id='reporting_form:entity_type']");
//		tmp.put("Status:", "//select[@id='reporting_form:entity_status']");
//		tmp.put("Sub-status:", "//select[@id='reporting_form:subStatus']");
//		tmp.put("Tags:", "//input[@id='reporting_form:entity_tag_input']");
//		tmp.put("Tags Table", "//div[@id='reporting_form:tags_table']");
//		tmp.put("Report Button", "//span[@class='ui-button-text'][contains(text(),'Report')]");
//		tmp.put("Reset Button", "//button[@id='reporting_form:j_idt434']//span[@class='ui-button-text'][contains(text(),'Reset')]");
//		EntityCriteriaMap = Collections.unmodifiableMap(tmp);
//	} 
//	
//	public static Map<String, String> FieldAdminCriteriaMap;
//	static {
//		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
//		tmp.put("Master customer set:", "//select[@id='reporting_form:customerSet_for_field']");
//		tmp.put("Status:", "//select[@id='reporting_form:field_status']");
//		tmp.put("Retained in history:", "//select[@id='reporting_form:retained_in_history']");
//		tmp.put("Include available Argus Master fields:", "//input[@id='reporting_form:include_available_argus_master']");
//		tmp.put("Report Button", "//span[@class='ui-button-text'][contains(text(),'Report')]");
//		tmp.put("Reset Button", "//button[@id='reporting_form:j_idt380']//span[@class='ui-button-text'][contains(text(),'Reset')]");
//		FieldAdminCriteriaMap = Collections.unmodifiableMap(tmp);
//	}
//	
//	public static Map<String, String> SampleClaimTestDataCriteriaMap;
//	static {
//		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
//		tmp.put("Master customer set:", "//select[@id='reporting_form:claim_mcs']");
//		tmp.put("Benefit customer set:", "//select[@id='reporting_form:claim_bcs']");
//		tmp.put("Customer:", "//select[@id='reporting_form:claim_customer']");
//		tmp.put("Client:", "//select[@id='reporting_form:claim_client']");
//		tmp.put("Condition ID:", "//input[@id='reporting_form:claim_condition_id']");
//		tmp.put("Condition ID CD", "//input[@id='reporting_form:j_idt487']");
//		tmp.put("Fill date:", "//input[@id='reporting_form:claim_fill_date']");
//		tmp.put("Coverage code: (1)", "//input[@id='reporting_form:claim_fill_date']");
//		tmp.put("Coverage code: (2)", "//input[@id='reporting_form:claim_cc_2_input']");
//		tmp.put("Coverage Code Table", "//div[@id='reporting_form:claim_cc_table']");
//		tmp.put("Report Button", "//span[@class='ui-button-text'][contains(text(),'Report')]");
//		tmp.put("Reset Button", "//button[@id='reporting_form:j_idt502']//span[@class='ui-button-text'][contains(text(),'Reset')]");
//		SampleClaimTestDataCriteriaMap = Collections.unmodifiableMap(tmp);
//	}

}
