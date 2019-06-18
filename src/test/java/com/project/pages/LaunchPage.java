package com.project.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.psqframework.core.element.BaseElement;
import com.psqframework.core.page.BasePage;
import com.psqframework.core.util.Project;

import cucumber.api.java.en.Given;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import net.serenitybdd.core.annotations.findby.FindBy;

public class LaunchPage extends BasePage {

	public enum Regions {DR1,DR2,DR3,RX2,QR1,QR2,QR3,UR1,UR2,RX6,QRF,UP1,UP2,UA1,UA2,UA3,UA4,UR3,UR4,UP3,UN1,UP6,UP7,PRODUCTION};
	private String RxNova_URL;	
	public static String InputRegion=null;
	public static boolean isProduction;
	
	@FindBy(id="loginForm:principal")
	private BaseElement userName;
	
	@FindBy(id="loginForm:credentials")
	private BaseElement password;
	
	@FindBy(xpath="//*[@id='loginForm:loginButton']/span")
	private BaseElement loginButton;
	
	@FindBy(id="messagesForm:globalMessages")
	private BaseElement globalMessageinfo;
	
	
	public void performLogin() {
		System.out.println("-----------user enters valid username, valid password and click on Login-------------");
		String InputUsername = null, InputPassword = null;
		/*
		 * System.out.println("UserName :" + UserName); System.out.println(
		 * "Password :" + Password);
		 */
		
		
		
		if (System.getProperty("MavenUsername") == null) {
			//InputUsername = utils.pf.getProperty("UserName");
			System.out.println(" Project.Env.userName() used " + Project.Env.userName());
			InputUsername = Project.Env.userName();
		} else {
			InputUsername = System.getProperty("MavenUsername");
			System.out.println("In MAVEN PARAMETERS username");
		}
		if (System.getProperty("MavenPassword") == null) {
			//InputPassword = utils.pf.getProperty("Password");
			InputPassword = Project.Env.userPassword();
		} else {
			InputPassword = System.getProperty("MavenPassword");
			System.out.println("In MAVEN PARAMETERS password");
		}

		// random number for dynimic login's
		Random r = new Random();
		// int value = r.ints(1000, (10000 +
		// 1000)).limit(1000).findFirst().getAsInt();
		int n = r.nextInt(10) + 1;
		int value = n * 200 * r.nextInt(10);
		System.out.println("Randomly waiting for " + value);
		sleep(value);
		
		userName.fill(InputUsername);
		password.fill(InputPassword);
		
		//old code
		//driver.findElement(By.id("loginForm:principal")).sendKeys(InputUsername);
		//driver.findElement(By.id("loginForm:credentials")).sendKeys(InputPassword);
		
		
		int n1 = r.nextInt(10) + 1;
		int value1 = n1 * 100 * r.nextInt(10);
		System.out.println("Randomly waiting for " + value1);
		sleep(value1);
		
		loginButton.click();		
		//old code
		//driver.findElement(By.xpath("//*[@id='loginForm:loginButton']/span")).click();
		
		
		sleep(5000);
		//System.out.println(" $$$$$$$$$$$$$$$$$$$$$ Current Title :" + driver.getTitle());
		System.out.println(" $$$$$$$$$$$$$$$$$$$$$ Current Title :" + getTitle());
		//if (getDriver().getTitle().contains("Application Error")) {
		if (getTitle().contains("Application Error")) {
			System.out.println("Current Title :" + getDriver().getTitle());
			System.out.println(" $$$$$$$$$$$$$$$$$$$$$ Refreshing the page $$$$$$$$$$$$$$$$$$$$$");
			getDriver().navigate().refresh();
			sleep(3000);
		}
		//if (getDriver().getTitle().contains("RxNova SSO Login")) {
		if (getTitle().contains("RxNova SSO Login")) {
			// driver.findElement(By.id("messagesForm:globalMessages")).getText();
			//System.out.println(getDriver().findElement(By.id("messagesForm:globalMessages")).getText());
			System.out.println(globalMessageinfo.getText());

			// driver.findElement(By.id("messagesForm:globalMessages")).getText();
			// "Login FailureWe're unable to complete the login with the
			// specified credentials. After three consecutive failed attempts
			// your user ID will be locked. (ASEC0101)"

//			if (driver.findElement(By.id("messagesForm:globalMessages")).getText().contains("Login Failure")
//					|| driver.findElement(By.id("messagesForm:globalMessages")).getText().contains("Account Locked")) {
//				Assert.assertEquals("Login Failure", "Login Failure1");
//			}
						
			if (globalMessageinfo.getText().contains("Login Failure")
				|| globalMessageinfo.getText().contains("Account Locked")) {
				assertEquals("Login Failure", "Login Failure1");
		}

		}
	}
	
	
	
	
	public void navigateToRxNovaApplication() 
	{	
				
		System.out.println("-----------Open firefox and start RxNova Application-------------");				
		/*try
		{
			InputRegion = System.getProperty("Region");
			System.out.println("InputRegion from jenkins : " + InputRegion);
			System.out.println("ERROR: ***********************Region parameter is empty*******************");
			
		}
		catch(Exception e)
		{
			InputRegion = utils.pf.getProperty("Region");
			System.out.println("InputRegion from properties file : " + InputRegion);
		}*/
		
		if(System.getProperty("MavenRegion")==null)		{
			//InputRegion = utils.pf.getProperty("Region");	
			InputRegion =  Project.Env.region();
			Log.info("Working on Region - Project.Env.region() " + Project.Env.region().toString());
		}else{		
			InputRegion = System.getProperty("MavenRegion");
			Log.info("Working on Region - InputRegion " + InputRegion);
			System.out.println("In MAVEN PARAMETERS region");
		}
		
		switch(Regions.valueOf(InputRegion.toUpperCase()))
		{
			case QR1:
			case QR2:
			case QR3:
			case QRF:
			case RX6:
				{ RxNova_URL = "https://qc-web/sso-web/login.jsf";isProduction=false; break;}
			case DR1:
			case DR2:
			case DR3:				
			case RX2:
				{RxNova_URL = "https://dev-web/sso-web/login.jsf";isProduction=false; break;}			
			case UP1:			
			case UP3:
			case UP6:
			case UP7:
			case UN1:
			case UA1:
			case UA2:
			case UA3:
			case UA4:
			case UR1:
			case UR2:
			case UR3:
			case UR4:
				{RxNova_URL = "https://beta.argushealth.com/sso-web/login.jsf?";isProduction=false; break;}
			case PRODUCTION:
				{RxNova_URL = "https://www.argushealth.com/sso-web/login.jsf?";isProduction=true;break;}
			default:
				{ System.out.println("Invalid Region - please check the Region name");break;}
		}
		System.out.println("-----------" + RxNova_URL +"-------------");
		//driver.get(RxNova_URL);		
		//invoke(Project.Env.url());
		invoke(RxNova_URL);
		System.out.println("-----------Completed Open firefox and start RxNova Application-------------");
	}

}
