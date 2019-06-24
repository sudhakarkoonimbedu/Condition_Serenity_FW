package com.project.pages;

import com.psqframework.core.element.BaseElement;
import com.psqframework.core.page.BasePage;
import com.psqframework.core.util.Project;

import com.project.common.util.RxNovaCommonUtil;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Steps;

public class LaunchPage extends BasePage {

	@FindBy(id="loginForm:principal")
	private BaseElement userName;
	
	@FindBy(id="loginForm:credentials")
	private BaseElement password;
	
	//@FindBy(xpath="*[@id='loginForm:loginButton']/span")
	@FindBy(id="loginForm:loginButton")
	private BaseElement loginButton;
	
	@FindBy(id="messagesForm:globalMessages")
	private BaseElement globalMessageinfo;
	
	public void performLogin() {
		System.out.println("-----------user enters valid username, valid password and click on Login-------------");
		String InputUsername = null, InputPassword = null;
				
		if (System.getProperty("MavenUsername") == null) {
		    System.out.println(" Project.Env.userName() used " + Project.Env.userName());
			InputUsername = Project.Env.userName();
		} else {
			InputUsername = System.getProperty("MavenUsername");
			System.out.println("In MAVEN PARAMETERS username");
		}
		if (System.getProperty("MavenPassword") == null) {
			InputPassword = Project.Env.userPassword();
		} else {
			InputPassword = System.getProperty("MavenPassword");
			System.out.println("In MAVEN PARAMETERS password");
		}
		
		userName.fill(InputUsername);
		password.fill(InputPassword);
		loginButton.click();
	}

}
