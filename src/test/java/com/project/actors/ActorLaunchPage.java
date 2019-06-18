package com.project.actors;

import com.project.pages.LaunchPage;

import net.thucydides.core.annotations.Step;

public class ActorLaunchPage {

	LaunchPage launchPage;
	
	@Step	
	public void launch_application(){
		launchPage.navigateToRxNovaApplication();	
	}
	
	@Step
	public void perform_login(){
		launchPage.performLogin();
	}
	
}
