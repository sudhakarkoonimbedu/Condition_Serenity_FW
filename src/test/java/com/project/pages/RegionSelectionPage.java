package com.project.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.common.util.RxNovaCommonUtil;
import com.psqframework.core.element.BaseElement;
import com.psqframework.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class RegionSelectionPage extends BasePage {

	@FindBy(className="loginContent")
	private BaseElement loginContent;	
	
	@FindBy(id="messagesForm:globalMessages")
	private BaseElement globalMessageinfo;
	
	public void verifylogin(){
		if(RxNovaCommonUtil.isProduction)
		{
			System.out.println("in prod region");
			return;
		}
		System.out.println("-----------user should be able to login sucessfully-------------");		
		WebDriverWait wb=new WebDriverWait(getDriver(),500);
		wb.until(ExpectedConditions.presenceOfElementLocated(By.className("loginContent")));
	    String val = loginContent.getText();
	        
	    if(val.contains("Please Select The Environment"))
	    {
	    	System.out.println("Sucessful");
	    	//Reporter.log("Sucessful in login");
	    	//Assert.fail("Failed - login");
	    }
	    else if(getTitle().contains("Application Error"))
		{
			System.out.println("Current Title :" + getTitle());
			System.out.println(" $$$$$$$$$$$$$$$$$$$$$ Refreshing the page $$$$$$$$$$$$$$$$$$$$$");
			getDriver().navigate().refresh();
			sleep(3000);
		}else
	    {
	    	System.out.println("Not Sucessful");
	    	//Assert.fail("Failed - login");
	    	getDriver().navigate().refresh();
			sleep(10000);
	    }	
	}
	
	
	public void selectApplicationRegion(){
		if(getTitle().contains("Application Error"))
		{
			System.out.println("Current Title :" + getTitle());
			System.out.println(" $!$$$$$$$$$$$$$$$$$$$$ Refreshing the page $$$$$$$$$$$$$$$$$$$$$");
			getDriver().navigate().refresh();
			sleep(3000);
		}
		if(getTitle().contains("RxNova SSO Login"))
		{
			//driver.findElement(By.id("messagesForm:globalMessages")).getText();
			System.out.println(globalMessageinfo.getText());
					
			if(globalMessageinfo.getText().contains("Login Failure") ||globalMessageinfo.getText().contains("Account Locked"))
			{
				assertEquals("Login Failure","Login Failure1");
			}		
		
		}
		if(RxNovaCommonUtil.isProduction)
		{
			System.out.println("in prod region");
			return;
		}
		System.out.println("-----------User should be able to click on QR1 Region-------------");
		getDriver().findElement(By.linkText(RxNovaCommonUtil.InputRegion)).click();	
		sleep(5000);	
		if(getTitle().contains("Application Error"))
		{
			System.out.println("Current Title :" + getTitle());
			System.out.println(" $!$$$$$$$$$$$$$$$$$$$$ Refreshing the page $$$$$$$$$$$$$$$$$$$$$");
			getDriver().navigate().refresh();
			sleep(3000);
			System.out.println("Current Title after refresh:" + getTitle());
		}
	
	}
	
	
	
}
