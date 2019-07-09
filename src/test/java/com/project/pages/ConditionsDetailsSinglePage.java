package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.project.common.util.RxNovaCommonUtil;
import com.psqframework.core.page.BasePage;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import net.thucydides.core.annotations.Steps;

public class ConditionsDetailsSinglePage extends BasePage {
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;

	public static Map<String, String> ConditionsHeaderMap;
	static {
		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
		tmp.put("Condition Home", "//em[contains(text(),'Condition Home')]");
		tmp.put("Conditions Home Breadcrumb", "//a[@id='breadCrumbForm:breadcrumb_home_link']");
		tmp.put("Conditions Header", "//li[@class='ui-wizard-step-title ui-state-default ui-state-hover ui-corner-all']");
		tmp.put("Conditions Header after Condition Creation", "//em[contains(text(),'Header')]");
		tmp.put("Yes go to Conditions Home", "//button[@id='cancel_dialog_form:common_breadcrumb_cancel_button']//span[@class='ui-button-text'][contains(text(),'YES')]");
		tmp.put("Details", "//li[contains(text(),'Details')]");
		tmp.put("Tags/Notes", "//li[contains(text(),'Tags/Notes')]");
		tmp.put("Pre-Test", "//li[contains(text(),'Pre-Test')]");
		tmp.put("Pre-Test after Condition Creation", "//em[contains(text(),'Pre-Test')]");
		tmp.put("Associations", "//li[contains(text(),'Associations')]");
		tmp.put("Associations after Condition Creation", "//em[contains(text(),'Associations')]");
		tmp.put("Tracking ID:", "//input[@id='condition_form:header_tracking_id']");
		tmp.put("Reason:", "//input[@id='condition_form:tracking_reason']");
		tmp.put("Master customer set:", "//select[@id='condition_form:condition_master_customer_set']");
		tmp.put("Condition ID:", "//input[@id='condition_form:condition_id']");
		tmp.put("Name:", "//input[@id='condition_form:condition_name']");
		tmp.put("Status:", "//select[@id='condition_form:condition_status']");
		tmp.put("Type:", "//select[@id='condition_form:condition_type']");
		tmp.put("Notes:", "//textarea[@id='condition_form:tracking_notes']");
		tmp.put("Next", "//span[@class='ui-button-text'][contains(text(),'Next')]");
		tmp.put("Source:", "//select[@id='condition_form:source'][1]");
		tmp.put("Field Name:", "//input[@id='condition_form:field_name_input']");
		tmp.put("Operator for Field", "//select[@id='condition_form:operator']");
		tmp.put("Value for Field", "//input[@id='condition_form:field_value']");
		tmp.put("Benefit customer set:", "//select[@id='condition_form:benefitCustomerSet']");
		tmp.put("Operator:", "//select[@id='condition_form:operator_for_list']");
		tmp.put("Value:", "//input[@id='condition_form:list_name_input']");
		tmp.put("Tags Panel", "//legend[contains(text(),'Tags')]");
		tmp.put("Conditions Tags/Notes Save", "//span[contains(text(),'Save')]");
		tmp.put("Error Message", "//div[@id='business_general_msg_form:j_idt55']");
		tmp.put("Conditions Header Delete", "//button[@id='condition_form:j_idt205']//span[@class='ui-button-text'][contains(text(),'Delete')]");
		tmp.put("Conditions Header 2nd Delete", "//button[@id='condition_delete_form:condition_delete_button']//span[@class='ui-button-text'][contains(text(),'Delete')]");	
		tmp.put("Conditions Header Delete Tracking ID", "//input[@id='condition_delete_form:delete_tracking_id']");
		tmp.put("PreviousU", "//button[@id='condition_form:j_idt120']//span[@class='ui-button-text'][contains(text(),'Previous')]");
		tmp.put("NextU", "//button[@id='condition_form:single_detail_next_button_top']//span[@class='ui-button-text'][contains(text(),'Next')]");
		tmp.put("CancelU", "//button[@id='condition_form:single_condition_cancel_top_button']//span[@class='ui-button-text'][contains(text(),'Cancel')]");
		tmp.put("PreviousD", "//button[@id='condition_form:j_idt167']//span[@class='ui-button-text'][contains(text(),'Previous')]");
		tmp.put("NextD", "//button[@id='condition_form:single_detail_next_button_bottom']//span[@class='ui-button-text'][contains(text(),'Next')]");
		tmp.put("CancelD", "//button[@id='condition_form:single_condition_cancel_bottom_button']//span[@class='ui-button-text'][contains(text(),'Cancel')]");
		tmp.put("Association(s)", "//div[@class='emphasizeWords associationTitle']");
		tmp.put("Associations Table", "//div[@id='condition_form:association_table']//table//thead//tr");
		tmp.put("Table App Type", "//th[@id='condition_form:association_table:j_idt411']");
		tmp.put("Table Customer Set", "//th[@id='condition_form:association_table:j_idt414']");
		tmp.put("Table ID", "//th[@id='condition_form:association_table:j_idt417']");
		tmp.put("Table Priority", "//th[@id='condition_form:association_table:j_idt458']");
		tmp.put("Table Start Date", "//th[@id='condition_form:association_table:j_idt461']");
		tmp.put("Table End Date", "//th[@id='condition_form:association_table:j_idt461']");
		tmp.put("Condition Definition", "//legend[contains(text(),'Condition Definition')]");
		tmp.put("Condition Pre-Test Message", "//div[contains(text(),'Please enter data for the following condition(s) t')]");
		tmp.put("Pre-Test Table", "//div[@id='condition_form:singleConditionPreTestList']");
		tmp.put("Evaluate Button", "//span[contains(text(),'Evaluate')]");
		tmp.put("Conditions Home Search", "//span[contains(text(),'Search')]");
		ConditionsHeaderMap = Collections.unmodifiableMap(tmp);
	}	
	
	public boolean ObjectIsCurrentlyEnabled(String ObjKey) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		return($(ObjPath).isCurrentlyEnabled());
	}
	
	public void SendKeysToField(String input, String ObjKey) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		$(ObjPath).sendKeys(input);
	}
	
	public void mySelectFromDropdown(String input, String ObjKey) throws InterruptedException {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		WebElement currElement = getDriver().findElement(By.xpath(ObjPath));
		rxNovaCommonUtil.selectFromDropdown(currElement, input);
		rxNovaCommonUtil.CheckBusyState();
	}
	
	public void SwitchToMostRecentWindow() throws InterruptedException {
		rxNovaCommonUtil.SwithToMostRecentWindow();
		rxNovaCommonUtil.switchToContentFrame();
	}
	
	public boolean IsTabProperlyDisplayed(String ChildObjKey) {
		String ChildObjPath = ConditionsHeaderMap.get(ChildObjKey);
		boolean IsTabDisplayed = rxNovaCommonUtil.IsTabProperlyDisplayed(ChildObjPath);
		return(IsTabDisplayed);
	}
	
	public boolean ObjectIsDisplayed(String ObjKey){
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		boolean isDisplayed = rxNovaCommonUtil.ObjectIsDisplayed(ObjPath);
		return(isDisplayed);
	}
	
	public boolean ObjectContainsExpectedText(String ObjKey, String expectedDisplay) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		boolean containsExpected = rxNovaCommonUtil.ObjectContainsExpectedText(ObjPath, expectedDisplay);
		return(containsExpected);
	}
	
	public boolean checkCurrentDropdownDisplay(String ObjKey, String expectedDisplay) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		String currVal = $(ObjPath).getSelectedValue();
		currVal = currVal.replaceAll("_", " ");
		boolean match = false;
		if(currVal.isEmpty() || currVal.equals("Null") || currVal.equals(" ") || currVal.equals(expectedDisplay)) {
			match = true;
		}
		
		return(match);
	}
	
	public boolean checkCurrentFieldDisplay(String ObjKey, String expectedDisplay) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		boolean match = rxNovaCommonUtil.checkCurrentFieldDisplay(ObjPath, expectedDisplay);
		return(match);
	}
	
	public boolean viewLabels(String label) throws InterruptedException {
		List<WebElement> pageLabels = getDriver().findElements(By.className("firstCommonColumn"));
		boolean labelMatch = false;
		for(WebElement i : pageLabels) {
			rxNovaCommonUtil.CheckBusyState();
			String checkLabel = label + ":";
			if(i.getText().equals(checkLabel)) {
				labelMatch = true;
				break;
			}
		}
		return(labelMatch);
	}
	
	public boolean MCScheckContents(String ObjKey) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		boolean hasContents = rxNovaCommonUtil.MCScheckContents(ObjPath);
		return(hasContents);
	}
	
	
	public boolean DropdownCheckContents(String ObjKey, String expected) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		System.out.println("this is the object path" + ObjPath);
		boolean hasContents = rxNovaCommonUtil.DropdownCheckContents(expected, ObjPath);
		return(hasContents);
	}
	
	public boolean checkPrefix(String prefix, String ObjKey) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
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
	
	public boolean isFieldClickable(String ObjKey) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		boolean isClickable = rxNovaCommonUtil.isFieldClickable(ObjPath);
		return(isClickable);
	}
	
	public void performClick(String ObjKey) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		rxNovaCommonUtil.performClick(ObjPath);
	}
	
	public boolean ObjectIsDisabled(String ObjKey) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		boolean isDisabled = rxNovaCommonUtil.ObjectIsDisabled(ObjPath);
		return(isDisabled);
	}
	
	public void EnterIDs(String toEnter, String ObjKey) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		rxNovaCommonUtil.sendKeysToObject(ObjPath, toEnter);
	}
	
	public void SelectRandomlyFromDropdown(String ObjKey) {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		//determine maxValue variable -- this will be the size of the dropdown list; then select by integer
		Select sel = new Select(getDriver().findElement(By.xpath(ObjPath)));
		List<WebElement> list = sel.getOptions();
		int rndInt = 1000;
		while(rndInt >= list.size()) {
			rndInt = rxNovaCommonUtil.RandomIntegerGenerator(list.size());
		}
		rxNovaCommonUtil.selectFromDropdownUsingIndex(rndInt, ObjPath);
	}
	
	public boolean checkPanelsForCorrectLabels(String label) throws InterruptedException {
		rxNovaCommonUtil.CheckBusyState();
		List<WebElement> pageLabels = getDriver().findElements(By.cssSelector(".tdtop"));
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
	
	public boolean verifyingTableContents(String expected, String ObjKey) throws InterruptedException {
		String ObjPath = ConditionsHeaderMap.get(ObjKey);
		rxNovaCommonUtil.WaitForBusyIcon();
		boolean hasContents = rxNovaCommonUtil.TableCheckContents(expected, ObjPath);
		return(hasContents);
	}
	
	public boolean TableMessageProperlyDisplayed(WebElement TableObj, String shouldContain) {
		String textOnPage = TableObj.getText();
		boolean isMessageDisplayed = false;
		if(textOnPage.contains(shouldContain)) {
			isMessageDisplayed = true;
		}
		else {
			isMessageDisplayed = false;
		}
		System.out.println(textOnPage);
		return(isMessageDisplayed);
	}
}
