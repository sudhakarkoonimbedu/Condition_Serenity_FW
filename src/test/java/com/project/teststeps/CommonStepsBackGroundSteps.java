package com.project.teststeps;

import com.project.actors.ActorLaunchPage;
import com.project.actors.ActorRegionSelectionPage;
import com.project.actors.ActorConditionsHomePage;
import com.project.common.util.RxNovaCommonUtil;

import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import net.thucydides.core.annotations.Steps;


public class CommonStepsBackGroundSteps {

	@Steps
	ActorLaunchPage actorOnLaunchPage;
	@Steps
	ActorRegionSelectionPage actorOnRegionSelectionPage;
	@Steps
	RxNovaCommonUtil rxNovaCommonUtil;
	@Steps
	ActorConditionsHomePage actorOnConditionsPage;
	
	
	@Given("^User opens the browser and goes to RxNova URL$")	
	public void NavigateToRxNovaApplication() {
		actorOnLaunchPage.launch_application();
	}
	
	@When("^They enter valid username, valid password and click on Login$")	
	public void Login() throws InterruptedException	{
		actorOnLaunchPage.perform_login();
	}
		
	@Then("^They check whether the application displays the Environment selection screen$")
	public void VerifyUserLogin() throws Throwable {
		actorOnRegionSelectionPage.verify_landing_page_details();	 	
	}
	
	@And("^They select Region and check whether the Landing Page is displayed$")
	public void RegionSelection() throws Throwable {		
		actorOnRegionSelectionPage.select_application_region();	
	}
	
	@Then("^User navigates from Landing page to \"(.*)\" application$")
	public void NavigateToApplication(String strApplication) throws Throwable{
		rxNovaCommonUtil.NavigateApplication(strApplication);
	}
	
}
