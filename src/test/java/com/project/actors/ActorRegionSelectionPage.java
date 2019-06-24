package com.project.actors;

import com.project.pages.RegionSelectionPage;
import com.psqframework.core.actor.BaseActor;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ActorRegionSelectionPage extends BaseActor {

	@Steps
	RegionSelectionPage regionSelectionPage;
	
	@Step
	public void verify_landing_page_details(){
		regionSelectionPage.verifylogin();
	}
	
	@Step
	public void select_application_region(){
		regionSelectionPage.selectApplicationRegion();
	}
	
}
