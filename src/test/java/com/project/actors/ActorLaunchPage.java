package com.project.actors;

import com.project.common.util.RxNovaCommonUtil;
import com.project.pages.LaunchPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ActorLaunchPage {
	
	@Steps
	RxNovaCommonUtil rxNovaCommonUtils;
	
	LaunchPage launchPage;
		
	@Step	
	public void launch_application(){
		rxNovaCommonUtils.navigateToRxNovaApplication();	
	}
	
	@Step
	public void perform_login(){
		launchPage.performLogin();
	}	

}
