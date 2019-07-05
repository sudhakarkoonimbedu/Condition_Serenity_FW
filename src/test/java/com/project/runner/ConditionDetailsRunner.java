package com.project.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= {
		"src/test/resources/features/Condition_Details_Tab_UI_Verification_Single_Condition.feature"		
		},glue = { "com.project.teststeps" 
		},plugin =  {"pretty","html:target/cucumber-html-report", "json:target/cucumber-json-report.json"})
public class ConditionDetailsRunner {}