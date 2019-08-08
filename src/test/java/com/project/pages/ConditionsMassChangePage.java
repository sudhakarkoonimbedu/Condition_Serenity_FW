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

public class ConditionsMassChangePage extends BasePage {
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	
	public static Map<String, String> NewMassChangeMap;
	static {
		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
		tmp.put("Mass Change Search Panel", "//fieldset[@id='mass_change_search_form:mass_change_search_criteria']");
		tmp.put("Mass Change Master customer set:", "//select[@id='mass_change_search_form:masterCustomerSet']");
		tmp.put("Request name:", "//input[@id='mass_change_search_form:requestName']");
		tmp.put("Request type:", "//select[@name='mass_change_search_form:j_idt302']");
		tmp.put("Request status:", "//select[@id='mass_change_search_form:j_idt306']");
		tmp.put("Run status", "//select[@id='mass_change_search_form:run_status']");
		tmp.put("Last name:", "//input[@id='mass_change_search_form:lastName']");
		tmp.put("First name:", "//input[@id='mass_change_search_form:firstName']");
		tmp.put("From date:", "//input[@id='mass_change_search_form:mcSearchFromDate']");
		tmp.put("To date:", "//input[@id='mass_change_search_form:mcSearchtoDate']");
		tmp.put("Search", "//button[@id='mass_change_search_form:mass_change_search_button']//span[@class='ui-button-text'][contains(text(),'Search')]");
		tmp.put("Reset", "//button[@id='mass_change_search_form:mass_change_reset_button']//span[@class='ui-button-text'][contains(text(),'Reset')]");
		tmp.put("Mass Change Results Panel", "//fieldset[@id='mass_change_search_result_form:mass_change_search_results']");
		tmp.put("Tracking ID:", "//input[@id='massChange_setup_form:tracking_id']");
		tmp.put("Reason:", "//input[@id='massChange_setup_form:tracking_reason']");
		tmp.put("Notes:", "//textarea[@id='massChange_setup_form:tracking_notes']");
		tmp.put("New Mass Change Master customer set:", "//select[@id='massChange_setup_form:massChange_masterCustormerSet']");
		tmp.put("Name:", "//input[@id='massChange_setup_form:massChange_name']");
		tmp.put("Description:", "//textarea[@id='massChange_setup_form:massChange_description']");
		tmp.put("New", "//button[@id='j_idt291:j_idt292']//span[@class='ui-button-text'][contains(text(),'New')]");
		tmp.put("Submit", "//button[@id='massChange_setup_form:massChange_setup_save_button']//span[@class='ui-button-text'][contains(text(),'Submit')]");
		tmp.put("Cancel", "//button[@id='massChange_setup_form:massChange_setup_cancel_button']//span[@class='ui-button-text'][contains(text(),'Cancel')]");
		tmp.put("Request", "They check if the New Mass Change is added");
		tmp.put("Request Edit Close", "//button[@id='massChange_form:j_idt756']//span[@class='ui-button-text'][contains(text(),'Close')]");
		tmp.put("Request Edit Tab", "//a[contains(text(),'Edit')]");
		tmp.put("Request Action Tab", "//a[@class='emphasizeWords textCenter']");
		tmp.put("Request Reporting Tab", "//a[contains(text(),'Reporting')]");
		tmp.put("Request", "//em[contains(text(),'Request')]");
		tmp.put("Delete Request", "//a[contains(text(),'Delete Request')]");
		tmp.put("Yes Delete Request", "//button[@id='massChange_form:confirm_button']//span[@class='ui-button-text'][contains(text(),'YES')]");
		tmp.put("Browse Requests", "//a[@id='j_idt48:j_idt49']");
		tmp.put("Browse Requests Refresh", "//span[contains(text(),'Refresh')]");
		tmp.put("Browse Requests Request type:", "//select[@id='browseRequestForm:requestType']");
		tmp.put("Browse Requests Close", "//button[@id='browseRequestForm:j_idt852']//span[@class='ui-button-text'][contains(text(),'Close')]");
		tmp.put("Browse Requests Delete", "//span[@class='ui-button-text'][contains(text(),'Delete')]");
		tmp.put("Results Table Bottom Strip", "//div[@id='mass_change_search_result_form:mass_change_result_data_table_paginatorbottom']");
		NewMassChangeMap = Collections.unmodifiableMap(tmp);
	}
	
	public boolean IsTabProperlyDisplayed(String ChildObjKey) {
		String ChildObjPath = NewMassChangeMap.get(ChildObjKey);
		boolean IsTabDisplayed = rxNovaCommonUtil.IsTabProperlyDisplayed(ChildObjPath);
		return(IsTabDisplayed);
	}
	
	public boolean isFieldClickable(String ObjKey) throws InterruptedException {
		String ObjPath = NewMassChangeMap.get(ObjKey);
		boolean isClickable = rxNovaCommonUtil.isFieldClickable(ObjPath);
		return(isClickable);
	}
	
	public void performClick(String ObjKey) {
		String ObjPath = NewMassChangeMap.get(ObjKey);
		rxNovaCommonUtil.performClick(ObjPath);
	}
	
	public boolean ObjectIsDisabled(String ObjKey) {
		String ObjPath = NewMassChangeMap.get(ObjKey);
		boolean isDisabled = rxNovaCommonUtil.ObjectIsDisabled(ObjPath);
		return(isDisabled);
	}
	
	public boolean checkPanelLabelsKnowingClass(String currClass, String label) throws InterruptedException {
		rxNovaCommonUtil.CheckBusyState();
		List<WebElement> pageLabels = getDriver().findElements(By.className(currClass));
		boolean labelMatch = false;
		for(WebElement i: pageLabels) {
			if(i.getText().contains(label)) {
				System.out.println(" This panel label is displayed " + i.getText());
				labelMatch = true;
				break;
			}
		}
		return(labelMatch);
	}
	
	public boolean checkDetailsPanelForCorrectLabels(String label) throws InterruptedException {
		rxNovaCommonUtil.CheckBusyState();
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
		String ObjPath = NewMassChangeMap.get(ObjKey);
		boolean isDisplayed = rxNovaCommonUtil.ObjectIsDisplayed(ObjPath);
		return(isDisplayed);
	}
	
	public boolean checkingItemsInSearch(String label) throws InterruptedException {
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
	
	public boolean MCScheckContents(String ObjKey) {
		String ObjPath = NewMassChangeMap.get(ObjKey);
		boolean hasContents = rxNovaCommonUtil.MCScheckContents(ObjPath);
		return(hasContents);
	}
	
	public boolean DropdownCheckContents(String expected, String ObjKey) {
		String ObjPath = NewMassChangeMap.get(ObjKey);
		boolean hasContents = rxNovaCommonUtil.DropdownCheckContents(expected, ObjPath);
		return(hasContents);
	}
	
	public void mySelectFromDropdown(String input, String ObjKey) throws InterruptedException {
		String ObjPath = NewMassChangeMap.get(ObjKey);
		WebElement currElement = getDriver().findElement(By.xpath(ObjPath));
		rxNovaCommonUtil.selectFromDropdown(currElement, input);
		rxNovaCommonUtil.CheckBusyState();
	}
	
	public void SendKeysToField(String input, String ObjKey) {
		String ObjPath = NewMassChangeMap.get(ObjKey);
		$(ObjPath).sendKeys(input);
	}
	
	public boolean checkRequestEditPanel(String label) throws InterruptedException {
		rxNovaCommonUtil.CheckBusyState();
		List<WebElement> pageLabels = new ArrayList<WebElement>(getDriver().findElements(By.className("firstCommonColumn")));
		pageLabels.addAll(getDriver().findElements(By.className("masschangeInformationfirstColumn")));
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
	
	public boolean gainInfoFromClickTabs(String ObjKey, String label) {
		List<WebElement> pageLabels = null;
		if(ObjKey.equals("Request Action Tab")) {
			pageLabels = getDriver().findElements(By.cssSelector("li.nav-menu-bar.mass_change_action_menu a"));
		}
		else if(ObjKey.equals("Request Reporting Tab")) {
			pageLabels = getDriver().findElements(By.cssSelector("li.nav-menu-bar a"));
		}
		boolean labelMatch = false;
		for(WebElement i : pageLabels) {
			System.out.println(" This label is displayed  for " + ObjKey);
			if(i.getText().contains(label)) {
				labelMatch = true;
				break;
			}
		}
		return(labelMatch);
	}

	public boolean checkingResultsPanelAfterSearch() {
		if(getDriver().findElement(By.xpath(NewMassChangeMap.get("Results Table Bottom Strip"))).getText().equals("Total results: 0")) {
			return(false);
		}
		return(true);
	}
	

}
