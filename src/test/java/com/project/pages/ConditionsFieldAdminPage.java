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

public class ConditionsFieldAdminPage extends BasePage {
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;

	public static Map<String, String> ConditionsFieldAdminSearchMap;
	static {
		Map<String, String> tmp = new ConcurrentHashMap<String, String>();
		tmp.put("Master customer set:", "//select[@id='field_search_form:masteCustomerSet']");
		tmp.put("System:", "//select[@id='field_search_form:field_system']");
		tmp.put("Argus field name:", "//input[@id='field_search_form:argus_field_name_input']");
		tmp.put("Business field name:", "//input[@id='field_search_form:argus_business_name_input']");
		tmp.put("Status:", "//select[@id='field_search_form:field_status']");
		tmp.put("Search Button", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/button[1]/span[1]");
		tmp.put("Reset Button", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/button[2]/span[1]");
		tmp.put("New Button", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/form[1]/button[1]/span[1]");
		tmp.put("Search Panel", "//fieldset[@id='field_search_form:field_search_criteria']//div[@class='ui-fieldset-content']");
		tmp.put("Results Panel", "/html[1]/body[1]/div[3]/div[3]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/form[2]/fieldset[1]/legend[1]");
		ConditionsFieldAdminSearchMap = Collections.unmodifiableMap(tmp);
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
	
	public boolean DropdownCheckContents(String expected, String ObjKey) {
		String ObjPath = ConditionsFieldAdminSearchMap.get(ObjKey);
		boolean hasContents = rxNovaCommonUtil.DropdownCheckContents(expected, ObjPath);
		return(hasContents);
	}
	
	public boolean MCScheckContents(String ObjKey) {
		String ObjPath = ConditionsFieldAdminSearchMap.get(ObjKey);
		boolean hasContents = rxNovaCommonUtil.MCScheckContents(ObjPath);
		return(hasContents);
	}
	
	public boolean ObjectIsDisplayed(String ObjKey) throws InterruptedException {
		String ObjPath = ConditionsFieldAdminSearchMap.get(ObjKey);
		System.out.println("This is the current obj path " + ObjPath);
		boolean isDisplayed = rxNovaCommonUtil.ObjectIsDisplayed(ObjPath);
		return(isDisplayed);
	}
}
