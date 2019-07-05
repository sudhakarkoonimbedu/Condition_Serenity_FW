package com.project.pages;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.project.common.util.RxNovaCommonUtil;
import com.psqframework.core.page.BasePage;

import net.thucydides.core.annotations.Steps;

public class ConditionsHeaderPage extends BasePage {
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;

	public static Map<String, String> ConditionsHeaderMap;
	static {
		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
		tmp.put("Add a Condition", "//a[@id='breadCrumbForm:j_idt52']");
		tmp.put("Condition Header", "//li[@class='ui-wizard-step-title ui-state-default ui-state-hover ui-corner-all']");
		tmp.put("Tracking ID:", "//input[@id='condition_form:header_tracking_id']");
		tmp.put("Reason:", "//input[@id='condition_form:tracking_reason']");
		tmp.put("Master customer set:", "//select[@id='condition_form:condition_master_customer_set']");
		tmp.put("Condition ID:", "//input[@id='condition_form:condition_id']");
		tmp.put("Condition ID prefix", "//input[@id='condition_form:j_idt105']");
		tmp.put("Name:", "//input[@id='condition_form:condition_name']");
		tmp.put("Status:", "//select[@id='condition_form:condition_status']");
		tmp.put("Type:", "//select[@id='condition_form:condition_type']");
		tmp.put("Notes:", "//textarea[@id='condition_form:tracking_notes']");
		tmp.put("Next Button", "//span[@class='ui-button-text'][contains(text(),'Next')]");
		tmp.put("Cancel Button", "//button[@id='condition_form:condition_cancel_button']//span[@class='ui-button-text'][contains(text(),'Cancel')]");
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
		WebElement currObj = find(By.xpath(ObjPath));
		rxNovaCommonUtil.waitFor(currObj);
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
	
	public boolean isNotesDisplayed(String label) throws InterruptedException {
		rxNovaCommonUtil.CheckBusyState();
		List<WebElement> pageLabels = getDriver().findElements(By.className("tdtop"));
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
}
