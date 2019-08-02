package com.project.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.common.util.RxNovaCommonUtil;
import com.psqframework.core.page.BasePage;

import net.thucydides.core.annotations.Steps;

public class ConditionsFieldAdminNewPage extends BasePage {
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;

	public static Map<String, String> ConditionsFieldAdminDetailsMap;
	static {
		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
		tmp.put("Field Admin", "//em[contains(text(),'Field Admin')]");
		tmp.put("Search Panel", "//fieldset[@id='field_search_form:field_search_criteria']");
		tmp.put("Field Admin New", "//button[@id='j_idt507:j_idt508']//span[@class='ui-button-text'][contains(text(),'New')]");
		tmp.put("Field Admin Header", "//li[contains(text(),'Header')]");
		tmp.put("Field Admin Details", "//li[contains(text(),'Details')]");
		tmp.put("Field Admin Notes", "//li[contains(text(),'Notes')]");
		tmp.put("Field type:", "//td[contains(text(),'Field type:')]");
		tmp.put("Tracking ID:", "//input[@id='condition_field_form:add_tracking_id']");
		tmp.put("Reason:", "//input[@id='condition_field_form:add_tracking_reason']");
		tmp.put("Master customer set:", "//select[@id='condition_field_form:master_customer_set']");
		tmp.put("Argus field name:", "//input[@id='condition_field_form:argus_field_name_input']");
		tmp.put("Business field name:", "//input[@id='condition_field_form:business_field_name']");
		tmp.put("Status:", "//select[@id='condition_field_form:field_status']");
		tmp.put("Notes:", "//textarea[@id='condition_field_form:tracking_notes']");
		tmp.put("Next", "//span[@class='ui-button-text'][contains(text(),'Next')]");
		tmp.put("Associate Notes within a Field", "//fieldset[@id='condition_field_form:j_idt132']");
		tmp.put("Cancel", "//button[@id='condition_field_form:field_cancel_button']//span[@class='ui-button-text'][contains(text(),'Cancel')]");
		tmp.put("Add a Field Breadcrumb", "//a[@id='breadCrumbForm:j_idt53']");
		tmp.put("Details Panel", "//div[@class='ui-fieldset-content']//table");
		tmp.put("PreviousU", "//span[contains(text(),'Previous')]");
		tmp.put("SaveU", "//span[contains(text(),'Save')]");
		tmp.put("CancelU", "//button[@id='condition_field_form:field_cancel_buttons']//span[@class='ui-button-text'][contains(text(),'Cancel')]");
		ConditionsFieldAdminDetailsMap = Collections.unmodifiableMap(tmp);
	}	
	
	public boolean IsTabProperlyDisplayed(String ChildObjKey) {
		String ChildObjPath = ConditionsFieldAdminDetailsMap.get(ChildObjKey);
		boolean IsTabDisplayed = rxNovaCommonUtil.IsTabProperlyDisplayed(ChildObjPath);
		return(IsTabDisplayed);
	}
	
	public boolean isFieldClickable(String ObjKey) throws InterruptedException {
		String ObjPath = ConditionsFieldAdminDetailsMap.get(ObjKey);
		boolean isClickable = rxNovaCommonUtil.isFieldClickable(ObjPath);
		return(isClickable);
	}
	
	public void performClick(String ObjKey) {
		String ObjPath = ConditionsFieldAdminDetailsMap.get(ObjKey);
		rxNovaCommonUtil.performClick(ObjPath);
	}
	
	public void SendKeysToField(String input, String ObjKey) {
		String ObjPath = ConditionsFieldAdminDetailsMap.get(ObjKey);
		$(ObjPath).sendKeys(input);
	}
	
	public void mySelectFromDropdown(String input, String ObjKey) throws InterruptedException {
		String ObjPath = ConditionsFieldAdminDetailsMap.get(ObjKey);
		WebElement currElement = getDriver().findElement(By.xpath(ObjPath));
		rxNovaCommonUtil.selectFromDropdown(currElement, input);
		rxNovaCommonUtil.CheckBusyState();
	}
	
	public boolean ObjectIsCurrentlyEnabled(String ObjKey) {
		String ObjPath = ConditionsFieldAdminDetailsMap.get(ObjKey);
		return($(ObjPath).isCurrentlyEnabled());
	}
	
	public boolean checkDetailsPanelForCorrectLabels(String label) throws InterruptedException {
		rxNovaCommonUtil.WaitForBusyIcon();
		List<WebElement> pageLabels = getDriver().findElements(By.className("firstCommonColumn"));
		List<WebElement> newList = new ArrayList<WebElement>();
		newList.addAll(pageLabels);
		newList.addAll(getDriver().findElements(By.className("tdtop")));
		boolean labelMatch = false;
		for(WebElement i : newList) {
			System.out.println(" This panel label is displayed " + i.getText());
			if(i.getText().contains(label)) {
				labelMatch = true;
				break;
			}
		}
		return(labelMatch);
	}
	
	public boolean ObjectIsDisplayed(String ObjKey) throws InterruptedException {
		String ObjPath = ConditionsFieldAdminDetailsMap.get(ObjKey);
		boolean isDisplayed = rxNovaCommonUtil.ObjectIsDisplayed(ObjPath);
		return(isDisplayed);
	}
	
	public boolean DropdownCheckContents(String expected, String ObjKey) {
		String ObjPath = ConditionsFieldAdminDetailsMap.get(ObjKey);
		boolean hasContents = rxNovaCommonUtil.DropdownCheckContents(expected, ObjPath);
		return(hasContents);
	}
	
	public boolean MCScheckContents(String ObjKey) {
		String ObjPath = ConditionsFieldAdminDetailsMap.get(ObjKey);
		boolean hasContents = rxNovaCommonUtil.MCScheckContents(ObjPath);
		return(hasContents);
	}
}
