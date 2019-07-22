package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.common.util.RxNovaCommonUtil;
import com.psqframework.core.page.BasePage;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.thucydides.core.annotations.Steps;

public class ConditionsHomePage extends BasePage {
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	
	public static Map<String, String> ConditionsHomeMap;
	static {
		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
		tmp.put("Condition Home Icon", "//a[@id='breadCrumbForm:j_idt51']");
		tmp.put("Condition Home Breadcrumb", "//a[@id='breadCrumbForm:j_idt52']");
		tmp.put("Condition Home", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/div[1]/ul[1]/li[1]/a[1]/em[1]");
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
		tmp.put("Reporting", "//em[contains(text(),'Reporting')]");
		tmp.put("Field Admin", "//em[contains(text(),'Field Admin')]");
		tmp.put("Mass Change", "//em[contains(text(),'Mass Change')]");
		tmp.put("Tags Table", "//div[@id='condition_form:tags_table']");
		tmp.put("Results Panel", "//legend[contains(text(),'Results')]");
		tmp.put("Condition Deleted Message", "//div[@id='success_message_form:j_idt193_content']");
		ConditionsHomeMap = Collections.unmodifiableMap(tmp);
	}
	
	public void mySelectFromDropdown(String input, String ObjKey) throws InterruptedException {
		String ObjPath = ConditionsHomeMap.get(ObjKey);
		WebElement currElement = getDriver().findElement(By.xpath(ObjPath));
		rxNovaCommonUtil.selectFromDropdown(currElement, input);
		rxNovaCommonUtil.CheckBusyState();
	}
	
	public void SendKeysToField(String input, String ObjKey) {
		String ObjPath = ConditionsHomeMap.get(ObjKey);
		$(ObjPath).sendKeys(input);
	}
	
	public boolean IsTabProperlyDisplayed(String ChildObjKey) {
		String ChildObjPath = ConditionsHomeMap.get(ChildObjKey);
		boolean IsTabDisplayed = rxNovaCommonUtil.IsTabProperlyDisplayed(ChildObjPath);
		return(IsTabDisplayed);
	}
	
	public boolean ObjectIsDisplayed(String ObjKey){
		String ObjPath = ConditionsHomeMap.get(ObjKey);
		boolean isDisplayed = rxNovaCommonUtil.ObjectIsDisplayed(ObjPath);
		return(isDisplayed);
	}
	
	public boolean ObjectContainsExpectedText(String ObjKey, String expectedDisplay) {
		String ObjPath = ConditionsHomeMap.get(ObjKey);
		boolean containsExpected = rxNovaCommonUtil.ObjectContainsExpectedText(ObjPath, expectedDisplay);
		return(containsExpected);
	}
	
	public boolean checkCurrentDropdownDisplay(String ObjKey, String expectedDisplay) {
		String ObjPath = ConditionsHomeMap.get(ObjKey);
		String currVal = $(ObjPath).getSelectedValue();
		currVal = currVal.replaceAll("_", " ");
		boolean match = false;
		if(currVal.isEmpty() || currVal.equals("Null") || currVal.equals(" ") || currVal.equals(expectedDisplay)) {
			match = true;
		}
		
		return(match);
	}
	
	public boolean checkCurrentFieldDisplay(String ObjKey, String expectedDisplay) {
		String ObjPath = ConditionsHomeMap.get(ObjKey);
		boolean match = rxNovaCommonUtil.checkCurrentFieldDisplay(ObjPath, expectedDisplay);
		return(match);
	}
	
	public boolean viewLabels(String label) {
		List<WebElement> pageLabels = getDriver().findElements(By.className("firstCommonColumn"));
		boolean labelMatch = false;
		for(WebElement i : pageLabels) {
			String checkLabel = label + ":";
			if(i.getText().equals(checkLabel)) {
				labelMatch = true;
				break;
			}
		}
		return(labelMatch);
	}
	
	public boolean MCScheckContents(String ObjKey) {
		String ObjPath = ConditionsHomeMap.get(ObjKey);
		boolean hasContents = rxNovaCommonUtil.MCScheckContents(ObjPath);
		return(hasContents);
	}

	public boolean DropdownCheckContents(String expected, String ObjKey) {
		String ObjPath = ConditionsHomeMap.get(ObjKey);
		boolean hasContents = rxNovaCommonUtil.DropdownCheckContents(expected, ObjPath);
		return(hasContents);
	}
	
	public boolean checkPrefix(String prefix, String ObjKey) {
		String ObjPath = ConditionsHomeMap.get(ObjKey);
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
		String ObjPath = ConditionsHomeMap.get(ObjKey);
		boolean isClickable = rxNovaCommonUtil.isFieldClickable(ObjPath);
		return(isClickable);
	}
	
	public void performClick(String ObjKey) {
		String ObjPath = ConditionsHomeMap.get(ObjKey);
		rxNovaCommonUtil.performClick(ObjPath);
	}
	
	public boolean ObjectIsDisabled(String ObjKey) {
		String ObjPath = ConditionsHomeMap.get(ObjKey);
		boolean isDisabled = rxNovaCommonUtil.ObjectIsDisabled(ObjPath);
		return(isDisabled);
	}
	
}	
