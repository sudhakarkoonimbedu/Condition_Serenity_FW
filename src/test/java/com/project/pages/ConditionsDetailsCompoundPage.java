package com.project.pages;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.common.util.RxNovaCommonUtil;
import com.psqframework.core.page.BasePage;

public class ConditionsDetailsCompoundPage extends BasePage {
	
	RxNovaCommonUtil rxNovaCommonUtil;
	
	public static Map<String, String> ConditionsDetailsCompMap;
	static {
		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
		tmp.put("Condition Home", "//em[contains(text(),'Condition Home')]");
		tmp.put("Conditions Home Breadcrumb", "//a[@id='breadCrumbForm:breadcrumb_home_link']");
		tmp.put("Conditions Header", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/form[4]/div[1]/ul[1]/li[1]");
		tmp.put("Details", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/form[4]/div[1]/ul[1]/li[2]");
		tmp.put("Tags/Notes", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/form[4]/div[1]/ul[1]/li[3]");
		tmp.put("Pre-Test", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/form[4]/div[1]/ul[1]/li[4]");
		tmp.put("Associations", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/form[4]/div[1]/ul[1]/li[5]");
		tmp.put("Compound Operator:", "//select[@id='condition_form:compoundOperator']");
		tmp.put("Condition ID CD", "//input[@id='condition_form:j_idt303']");
		tmp.put("Condition ID:", "//input[@id='condition_form:add_id_input']");
		tmp.put("Add Button", "//span[contains(text(),'Add')]");
		tmp.put("Condition Table", "//div[@id='condition_form:child_condition_table']//table//thead//tr");
		tmp.put("Condition Table Checkbox", "//input[@name='condition_form:child_condition_table:j_idt308_checkAll']");
		tmp.put("Condition Table Message", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/form[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/table[3]/tbody[1]/tr[1]/td[1]/fieldset[1]/legend[1]");
		tmp.put("Remove Selected", "//span[contains(text(),'Remove Selected')]");
		tmp.put("PreviousU", "//button[@id='condition_form:j_idt293']//span[@class='ui-button-text'][contains(text(),'Previous')]");
		tmp.put("NextU", "//button[@id='condition_form:compound_detail_next_button_top']//span[@class='ui-button-text'][contains(text(),'Next')]");
		tmp.put("CancelU", "//button[@id='condition_form:compound_condition_cancel_top_button']//span[@class='ui-button-text'][contains(text(),'Cancel')]");
		tmp.put("PreviousD", "//button[@id='condition_form:j_idt321']//span[@class='ui-button-text'][contains(text(),'Previous')]");
		tmp.put("NextD", "//button[@id='condition_form:compound_detail_next_button_bottom']//span[@class='ui-button-text'][contains(text(),'Next')]");
		tmp.put("CancelD", "//button[@id='condition_form:compound_condition_cancel_bottom_button']//span[@class='ui-button-text'][contains(text(),'Cancel')]");
		tmp.put("Conditions Included In Compound", "//legend[@class='ui-fieldset-legend ui-corner-all ui-state-default']");
		ConditionsDetailsCompMap = Collections.unmodifiableMap(tmp);
	}	
	
	public boolean IsTabProperlyDisplayed(String ChildObjKey) {
		String ChildObjPath = ConditionsDetailsCompMap.get(ChildObjKey);
		boolean IsTabDisplayed = rxNovaCommonUtil.IsTabProperlyDisplayed(ChildObjPath);
		return(IsTabDisplayed);
	}
	
	public boolean viewLabels(String label) {
		List<WebElement> pageLabels = getDriver().findElements(By.className("firstCommonColumn1"));
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
	
	public boolean DropdownCheckContents(String expected, String ObjKey) {
		String ObjPath = ConditionsDetailsCompMap.get(ObjKey);
		boolean hasContents = rxNovaCommonUtil.DropdownCheckContents(expected, ObjPath);
		return(hasContents);
	}
	
	public boolean checkPrefix(String prefix, String ObjKey) {
		String ObjPath = ConditionsDetailsCompMap.get(ObjKey);
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
	
	public boolean ObjectIsDisplayed(String ObjKey) throws InterruptedException{
		String ObjPath = ConditionsDetailsCompMap.get(ObjKey);
		boolean isDisplayed = rxNovaCommonUtil.ObjectIsDisplayed(ObjPath);
		return(isDisplayed);
	}
	
	public boolean verifyingTableContents(String expected, String ObjKey) throws InterruptedException {
		String ObjPath = ConditionsDetailsCompMap.get(ObjKey);
		rxNovaCommonUtil.CheckBusyState();
		boolean hasContents = rxNovaCommonUtil.TableCheckContents(expected, ObjPath);
		return(hasContents);
	}

	public boolean ObjectIsDisabled(String ObjKey) {
		String ObjPath = ConditionsDetailsCompMap.get(ObjKey);
		boolean isDisabled = rxNovaCommonUtil.ObjectIsDisabled(ObjPath);
		return(isDisabled);
	}	
}
