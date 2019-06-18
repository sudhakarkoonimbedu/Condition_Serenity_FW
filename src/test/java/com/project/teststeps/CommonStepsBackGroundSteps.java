package com.project.teststeps;

import com.project.actors.ActorLaunchPage;
import com.project.actors.ActorRegionSelectionPage;
import com.project.common.util.RxNovaCommonUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class CommonStepsBackGroundSteps {

	@Steps
	ActorLaunchPage actorOnLaunchPage;
	@Steps
	ActorRegionSelectionPage actorOnRegionSelectionPage;
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	
	
	@Given("^Open Browser and Open RxNova URL$")	
	public void NavigateToRxNovaApplication() {
		actorOnLaunchPage.launch_application();
	}
	
	@When("^User enters valid username, valid password and clicks on Login$")	
	public void Login() throws InterruptedException	{
		actorOnLaunchPage.perform_login();
	}
		
	@Then("^Application should display Environment selection screen$")
	public void VerifyUserLogin() throws Throwable {
		actorOnRegionSelectionPage.verify_landing_page_details();	 	
	}
	
	@Then("^User selects Region and Landing page should be displayed$")
	public void RegionSelection() throws Throwable {		
		actorOnRegionSelectionPage.select_application_region();	
	}		
	
	@Given("^Landing Page user navigates to \"(.*)\" application$")
	public void NavigateToApplication(String strApplication) throws Throwable{
		rxNovaCommonUtil.NavigateApplication(strApplication);
	}
	
	
}
