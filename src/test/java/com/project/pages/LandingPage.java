package com.project.pages;

import com.project.common.util.RxNovaCommonUtil;
import com.psqframework.core.page.BasePage;

import net.thucydides.core.annotations.Steps;

public class LandingPage extends BasePage {
	
	@Steps
	RxNovaCommonUtil RxNovaCommon;
	
	//,,,,,,,,,
		public enum Apps {		
			GROUP("GROUP"),
			AUTH("AUTH"),
			MEMBER("MEMBER"),
			CLAIM("CLAIM"),
			CONDITION("CONDITION"),
			ACCUMULATOR("ACCUMULATOR"),
			BENEFITS("BENEFITS"),
			MESSAGES("MESSAGES"),
			PRESCRIBER("PRESCRIBER"),
			DRUG("DRUG"),		
			ASSIGN_OPTIONS("ASSIGN OPTIONS"),
			COVERAGE_CODE("COVERAGE CODE"),
			MAINTENANCE_HISTORY("MAINTENANCE HISTORY"),
			DRUG_FILE_CHANGE_REPORTS("DRUG FILE CHANGE REPORTS"),
			DATA_DICTIONARY("DATA DICTIONARY"),
			DUR_PROTOCOLS("DUR PROTOCOLS"),
			CUSTOMER_CLIENT("CUSTOMER/CLIENT"),
			DUR_SAFETY("DUR SAFETY"),
			DRUG_LIST("DRUG LIST"),
			PHARMACY_LIST("PHARMACY LIST"),
			PRESCRIBER_LIST("PRESCRIBER LIST"),
			CUSTOMER_SET("CUSTOMER SET"),
			NETWORK_MAINTENANCE("NETWORK MAINTENANCE"),
			PHARMACY_MAINTENANCE("PHARMACY MAINTENANCE"),
			PHARMACY_SERVICE_FEES("PHARMACY SERVICE FEES"),
			FINANCIAL("FINANCIAL"),
			TAGS("TAGS"),
			PRICING("PRICING"),
			RXNOVA_INTEL("RxNova Intel");
			
			private String displayName;
			
			Apps(String displayName)
			{
				//System.out.println("First call is display name returned is displayName " + displayName);
				this.displayName = displayName;
			}
			
			public String displayName()
			{
				//System.out.println("display name returned is displayName " + displayName);
				return displayName;
			}
			
			@Override
			public String toString()
			{
			//	System.out.println("display name returned is toString " + displayName);
				return displayName;
			}
		};
	
	



	
}
