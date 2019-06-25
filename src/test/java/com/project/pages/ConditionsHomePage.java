package com.project.pages;
import com.project.pageobjectmaps.ConditionsPageMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.common.util.RxNovaCommonUtil;
import com.psqframework.core.page.BasePage;
import java.util.List;
import java.util.StringTokenizer;

import net.thucydides.core.annotations.Steps;

public class ConditionsPage extends BasePage {
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	
	public boolean ObjectIsDisplayed(String ObjKey){
		String ObjPath = ConditionsPageMap.ConditionsMap.get(ObjKey);
		boolean isDisplayed = $(ObjPath).isDisplayed();
		return(isDisplayed);
	}
	
	public boolean ObjectContainsExpectedText(String ObjKey, String expectedDisplay) {
		String ObjPath = ConditionsPageMap.ConditionsMap.get(ObjKey);
		boolean containsExpected = $(ObjPath).getText().contains(expectedDisplay);
		return(containsExpected);
	}
	
	public boolean checkCurrentDropdownDisplay(String ObjKey, String expectedDisplay) {
		String ObjPath = ConditionsPageMap.ConditionsMap.get(ObjKey);
		String currVal = $(ObjPath).getSelectedValue();
		currVal = currVal.replaceAll("_", " ");
		boolean match = false;
		if(currVal.isEmpty() || currVal.equals("Null") || currVal.equals(" ") || currVal.equals(expectedDisplay)) {
			match = true;
		}
		
		return(match);
	}
	
	public boolean checkCurrentFieldDisplay(String ObjKey, String expectedDisplay) {
		String ObjPath = ConditionsPageMap.ConditionsMap.get(ObjKey);
		String currText = $(ObjPath).getText();
		boolean match = false;
		if(currText.isEmpty()) {
			match = true;
		}
		
		return(match);
	}
	
	public boolean viewLabels(String label) {
	//write a loop to get text from those classes and check whether the necessary labels exist there
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
		String ObjPath = ConditionsPageMap.ConditionsMap.get(ObjKey);
		List<String> options = $(ObjPath).getSelectOptions();
		boolean hasContents = options.size() > 1;
		return(hasContents);
	}

	
	public boolean DropdownCheckContents(String expected, String ObjKey) {
		String ObjPath = ConditionsPageMap.ConditionsMap.get(ObjKey);
		List<String> options = $(ObjPath).getSelectOptions();
		boolean hasContents = options.size() > 1;
		if(hasContents == true)
		{
			StringTokenizer tokenizer = new StringTokenizer(expected, ",");
			while(tokenizer.hasMoreTokens()) {
				String currToken = tokenizer.nextToken();
				for(String i : options)
				{
					if(i.equals(currToken))
					{
						hasContents = true;
					}
					else
					{
						hasContents = false;
					}
				}
			}
		}
		return(hasContents);
	}
	
	public boolean checkPrefix(String prefix, String ObjKey) {
		String ObjPath = ConditionsPageMap.ConditionsMap.get(ObjKey);
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
		String ObjPath = ConditionsPageMap.ConditionsMap.get(ObjKey);
		return($(ObjPath).isClickable());
	}
	
	public void performClick(String ObjKey) {
		String ObjPath = ConditionsPageMap.ConditionsMap.get(ObjKey);
		$(ObjPath).click();
	}
	
	public boolean ObjectIsDisabled(String ObjKey) {
		String ObjPath = ConditionsPageMap.ConditionsMap.get(ObjKey);
		String isDisabled = $(ObjPath).getAttribute("aria-disabled");
		boolean disabled = false;
		if(isDisabled.equals("true"))
		{
			disabled = true;
		}
		return(disabled);	
	}
}	
