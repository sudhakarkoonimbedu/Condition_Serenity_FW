package com.project.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.StringUtil;

import com.project.pages.LandingPage.Apps;
import com.psqframework.core.page.BasePage;
import com.psqframework.core.util.Project;

public class RxNovaCommonUtil extends BasePage{
	
	public enum Regions {DR1,DR2,DR3,RX2,QR1,QR2,QR3,UR1,UR2,RX6,QRF,UP1,UP2,UA1,UA2,UA3,UA4,UR3,UR4,UP3,UN1,UP6,UP7,PRODUCTION};
	public Properties pf = new Properties();
	public static String InputRegion=null;
	
	private String RxNova_URL;		
	public static boolean isProduction;
	
	// common place holder for downloading Reports ( used with Drug List report Download)
	//public static String downloadFilepath1 = System.getProperty("user.dir") + "\\target\\DownloadedReport";
//	public static String downloadFilepath1 = Project.Env.downloadDrugListReport();
//	public static String copydownloadFilepath1 = Project.Env.CopyFolderDrugListReport();
	
	public void NavigateApplicationMenu(String strAppMenu) throws InterruptedException
	{
		
		Thread.sleep(2000);
		
		/*try
		{
		Thread.sleep(2000);
		if(!driver.findElement(By.className("argusLogoRebrand")).isDisplayed())
		{
			System.out.println("**************************** In refresh mode ****************************" + strAppMenu);
			driver.navigate().refresh();
			Thread.sleep(10000);
		}
		}catch(NoSuchFrameException s)
		{
			System.out.println("**************************** NoSuchFrameException - In refresh mode ****************************" + strAppMenu);
			driver.navigate().refresh();
			Thread.sleep(10000);
		}		
		catch(Exception e)
		{
			System.out.println("**************************** Exception - In refresh mode ****************************" + strAppMenu);
			driver.navigate().refresh();
			Thread.sleep(10000);
		}
		*/
		
		Set<String> handles = getDriver().getWindowHandles();
		//Sreenu Added Recovery for Application Error
		for(String s: handles)
		{						
			if(getDriver().switchTo().window(s).getTitle().contains("Application Error"))
			{
				System.out.println("Page selected with title " + strAppMenu +": Application Error - Refershing the page - Recovery from NavigateApplicationMenu method" );
				getDriver().navigate().refresh();
				getDriver().manage().window().maximize();
				Thread.sleep(8000);
			}			
		}
		
		
		Boolean boolNavigateApplicationMenu=false;
		int intCounter= 0;
		String[] arrApplication=null;
		if(!strAppMenu.trim().isEmpty())
		{
			arrApplication = strAppMenu.split("\\|");
			for(int i=0; i<=arrApplication.length-1; i++)
			{
				List<WebElement> listofMenuItems=getDriver().findElements(By.tagName("li"));				
			    for(WebElement v:listofMenuItems)
			    {			    	
			    	if (v.getText().equals(arrApplication[i]))
			    	{
			    		v.click();
			    		//System.out.println("Clicked on link -" + v.getText());
			    		//LOGGER.info("***********Clicked on link **************" + v.getText());
			    		getDriver().manage().window().maximize();
			    		Thread.sleep(500);
			    		intCounter++;
			    		boolNavigateApplicationMenu= true;
			    		break;	    		
			    	}
			    }
			}
		}
		
		if(boolNavigateApplicationMenu==false | intCounter != arrApplication.length )
		{
			System.out.println("Unable to Navigate to application menu with details : " + strAppMenu);			
		}
	}
	
	
	public void RxNova_PageSelection(String strAppName) throws Throwable
	{
		String SelectApp;
		Boolean boolRxNova_PageSelection=false;
		Set<String> handles = getDriver().getWindowHandles();		
		if(strAppName.toString().contains("|"))
		{
			String[] arrSelectApp = strAppName.split("\\|");			
			SelectApp = arrSelectApp[arrSelectApp.length-1];
		}
		else
		{
			SelectApp = strAppName.trim();	
		}
		
		//Sreenu Added Recovery for Application Error
				for(String s: handles)
				{						
					if(getDriver().switchTo().window(s).getTitle().contains("Application Error"))
					{
						System.out.println("Page selected with title : Application Error - Refershing the page - Recovery from RxNova_PageSelection method" );
						getDriver().navigate().refresh();
						getDriver().manage().window().maximize(); 
						Thread.sleep(8000);
					}			
				}
		
		
		for(String s: handles)
		{						
			if(getDriver().switchTo().window(s).getTitle().contains(SelectApp))
			{
				System.out.println("Page selected with title : " + getDriver().getTitle());				
				boolRxNova_PageSelection = true;
				break;
			}			
		}
		
		if(boolRxNova_PageSelection==false)
		{
			System.out.println("No Application page with name : '" + SelectApp + "' was found");
		}	
	}
	
	
	public void SetTextOnEdit(By objElementName, String strValue) throws Throwable
	{
		Boolean boolSetTextOnEdit=false;	
		int attempt = 0;
		while(attempt < 3)
		{
			try
			{
				if(getDriver().findElements(objElementName).size()!=0 && StringUtil.isNotBlank(strValue))
				{
					String strName = getDriver().findElement(objElementName).getAttribute("name");
					getDriver().findElement(objElementName).sendKeys(strValue);
					boolSetTextOnEdit=true;
					System.out.println("Set text on webelement : " + strName + " Value :" + strValue );
					break;
				}
			}catch(Exception e){				
			}
			attempt++;
		}
		
		if(boolSetTextOnEdit==false)
		{
			System.out.println("Webelement with name  : '" + getDriver().findElement(objElementName).getAttribute("name") + "' was found");
		}
		
	}


	public void SelectItemFromWebList(By objElementName, String strValue) throws InterruptedException, NoSuchElementException
	{
		Boolean boolSelectItemFromWebList=false;
		try
		{
			if(getDriver().findElements(objElementName).size()!=0 && StringUtil.isNotBlank(strValue))
			{
				Select itemstoSelect =new Select(getDriver().findElement(objElementName));
				System.out.println("inside SelectItemFromWebList ");
				String strName = getDriver().findElement(objElementName).getAttribute("name");
				itemstoSelect.selectByVisibleText(strValue);			
				boolSelectItemFromWebList = true;
				System.out.println("Selected item in webelement : " + strName + " Value :" + strValue );
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			try{
			if(getDriver().findElements(objElementName).size()!=0 && StringUtil.isNotBlank(strValue))
			{
				Select itemstoSelect =new Select(getDriver().findElement(objElementName));
				String strName = getDriver().findElement(objElementName).getAttribute("name");
				List<WebElement> allOptions = itemstoSelect.getOptions();
				for(WebElement i:allOptions){
					//System.out.println(i.getText());
					if(i.getText().equalsIgnoreCase(strValue)){
						String tvalue = i.getText();
						itemstoSelect.selectByVisibleText(tvalue);
						boolSelectItemFromWebList = true;
						System.out.println("Selected item in webelement : " + strName + " Value :" + strValue );
						break;
					}
				}				
			}
			}catch(Exception s){
			}
		}
		
		if(boolSelectItemFromWebList==false)
		{
			System.out.println("Webelement with name  : '" + getDriver().findElement(objElementName).getAttribute("name") + "' was not found");
		}
	}
	

	public void ClickOnButton(By objElementName)
	{
		Boolean boolClickOnButton=false;		
		if(getDriver().findElements(objElementName).size()!=0)
		{
			String strName = getDriver().findElement(objElementName).getAttribute("name");
			getDriver().findElement(objElementName).click();
			boolClickOnButton = true;
			System.out.println("Clicked on webelement : " + strName);
		}
		
		if(boolClickOnButton==false)
		{
			System.out.println("Webelement with name  : '" + getDriver().findElement(objElementName).getAttribute("name") + "' was found");
		}
	}
	
	
	public void ClickOnButton(String strBtnName)
    {
		Boolean boolClickOnButton=false;		
		 List<WebElement> allButt = getDriver().findElements(By.tagName("button"));
         for (WebElement w : allButt){
             if (w.getText().equals(strBtnName)){
                 w.click();
                 boolClickOnButton = true;
                 break;
             }
         }
         if(boolClickOnButton==false){
          	System.out.println("Webelement with name  : '" + strBtnName + "' was not found");
         }                  
    }

	
	public void ClickOnLink(By objElementName) throws Throwable
	{
		Boolean boolClickOnLink=false;	
		int attempts=0;
		while(attempts < 3)
		{
			try
			{
				WaitUntilWebElementExist(objElementName);
				if(getDriver().findElements(objElementName).size()!=0)
				{
					String strName = getDriver().findElement(objElementName).getAttribute("name");
					getDriver().findElement(objElementName).click();
					boolClickOnLink = true;
					System.out.println("Clicked on webelement : " + strName);
				}
				break;
			}catch(StaleElementReferenceException e){				
			}
			attempts++;
		}
		
		if(boolClickOnLink==false)
		{
			System.out.println("Webelement with name  : '" + getDriver().findElement(objElementName).getAttribute("name") + "' was not found");
		}
	}
	
	
	
	
	public void GetBusyStatus() throws Throwable 
	{
		try
		{
		WebDriverWait wt= new WebDriverWait(getDriver(),60);
		WebElement busyElement=getDriver().findElement(By.id("loading"));
		/*System.out.println("Start Debugging the Busy element");
		System.out.println(busyElement.getAttribute("style").equals(null));
		System.out.println(busyElement.getAttribute("style").isEmpty());
		System.out.println(busyElement.getAttribute("style").equals(""));
		System.out.println("End Debugging the Busy element");*/
		
		if(busyElement.getAttribute("style").equals(null)|| busyElement.getAttribute("style").isEmpty() || busyElement.getAttribute("style").equals(""))
		{
			return;
		}
		else
		{
			if(pf.getProperty("BrowserName").equalsIgnoreCase("IE")||pf.getProperty("BrowserName").equalsIgnoreCase("InternetExplorer"))
			{
				wt.until(ExpectedConditions.attributeToBe(busyElement,"style","DISPLAY: none"));
			}
			else if(pf.getProperty("BrowserName").equalsIgnoreCase("FF")||pf.getProperty("BrowserName").equalsIgnoreCase("firefox"))
			{
				wt.until(ExpectedConditions.attributeToBe(busyElement,"style","display: none;"));
			}else
			{
				wt.until(ExpectedConditions.attributeToBe(busyElement,"style","display: none;"));
			}			
			System.out.println("Performed Wait");
		}
		}
		catch(Exception e)
		{
			Thread.sleep(5000);
		}
	}
	
	
	public void WaitUnitWebListisLoaded(WebElement objlist) throws InterruptedException
	{
		WebDriverWait waitDriver = new WebDriverWait(getDriver(),60);	
		waitDriver.until(ExpectedConditions.attributeToBeNotEmpty(objlist,"innerHTML"));	
	}
	
	public void WaitUntilWebElementExist(By strItem) throws Throwable
	{	
		/*try
		{*/
		System.out.println("Searching for element - Started");
		WebDriverWait wb=new WebDriverWait(getDriver(),20);
		wb.until(ExpectedConditions.presenceOfElementLocated(strItem));
		System.out.println("Searching for element - Ended");
		//}
		/*catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			Thread.sleep(6000);
			WebDriverWait wb=new WebDriverWait(driver,20);
			wb.until(ExpectedConditions.presenceOfElementLocated(strItem));
		}*/	
		
	}
	
	public void ReadProp() throws IOException
	{
		FileInputStream f1= new FileInputStream(System.getProperty("user.dir") + "\\Resource\\RxNovaSettings.properties");
		System.out.println(System.getProperty("user.dir") + "\\Resource\\RxNovaSettings.properties");
		pf.load(f1);		
	}	
	
	public boolean CheckElementPresenceByLocator(By LocatorValue) throws Throwable
	{
		WaitUntilWebElementExist(LocatorValue);
		return getDriver().findElements(LocatorValue).size() != 0;		
	}
	
	public void SwithToMostRecentWindow() throws InterruptedException	
	{		
		for(String WHandles: getDriver().getWindowHandles())
		{
			getDriver().switchTo().window(WHandles);
			System.out.println("SwithToMostRecentWindow -" + getDriver().getTitle());
			getDriver().manage().window().maximize();
		}		
	
	}
	
	
	public void SelectItemFromWebListByNameAndHyphen(By objElementName, String strValue) throws InterruptedException
	{
		Boolean boolSelectItemFromWebListByNameAndHyphen=false;
		
		int attempts=0;
		while(attempts<3)
		{
			try{
		
			String ItemFound = "";
			String strListItem="";
			if(getDriver().findElements(objElementName).size()!=0)
			{
				WebElement strItem=getDriver().findElement(objElementName);
				List<WebElement> strItems=	strItem.findElements(By.tagName("option"));	
				for(int i2=1;i2<strItems.size();i2++)
				{
					strListItem=strItems.get(i2).getText();
					if(strListItem.trim().equalsIgnoreCase(strValue.trim()))
					   {
						  ItemFound = "Found";
						  Select itemstoSelect =new Select(getDriver().findElement(objElementName));
						  String strName = getDriver().findElement(objElementName).getAttribute("name");
						  itemstoSelect.selectByVisibleText(strListItem);			
						  boolSelectItemFromWebListByNameAndHyphen = true;
						  System.out.println("Selected item in webelement : " + strName + " Value :" + strValue );
						  break;
					   }
				 }
				if(!ItemFound.equals("Found"))
				  {
					for(int i3=1;i3<strItems.size();i3++)
					 {
						strListItem=strItems.get(i3).getText();	
					    String[] arrItemSplited=strListItem.split("-");
					    if(arrItemSplited[0].trim().equalsIgnoreCase(strValue.trim()))
						   {
							  Select itemstoSelect =new Select(getDriver().findElement(objElementName));
							  String strName =getDriver().findElement(objElementName).getAttribute("name");
							  itemstoSelect.selectByVisibleText(strListItem);			
							  boolSelectItemFromWebListByNameAndHyphen = true;
							  System.out.println("Selected item in webelement : " + strName + " Value :" + strValue );
							  break;
						   }
					  }
				  }
				
			 	}
			
		}catch(StaleElementReferenceException e){				
		}
		attempts++;
		}
			
		if(boolSelectItemFromWebListByNameAndHyphen==false)
		 {
			System.out.println("Webelement with name  : '" + getDriver().findElement(objElementName).getAttribute("name") + "' was not found");
		 }
	}
	
	
	
	public void SelectItemFromWebListByPartialDisplayName(By objElementName, String strValue) throws InterruptedException
	{
		Boolean boolSelectItemFromWebListByPartialDisplayName=false;
		
		int attempts=0;
		while(attempts<3)
		{
			try{
				String ItemFound = "";
				String strListItem = "";
				if(getDriver().findElements(objElementName).size()!=0)
				{
					System.out.println("inside SelectItemFromWebListByPartialDisplayName");
					WebElement objWebList = getDriver().findElement(objElementName);
					List<WebElement> strItems=	objWebList.findElements(By.tagName("option"));	
					for(int i2=1;i2<strItems.size();i2++)
					{
						strListItem=strItems.get(i2).getText();
						if(strListItem.toLowerCase().trim().contains(strValue.toLowerCase().trim()))
						   {
							  ItemFound = "Found";
							  Select itemstoSelect =new Select(getDriver().findElement(objElementName));
							  String strName =getDriver().findElement(objElementName).getAttribute("name");
							  itemstoSelect.selectByVisibleText(strListItem);			
							  boolSelectItemFromWebListByPartialDisplayName = true;
							  System.out.println("Selected item in webelement : " + strName + " Value :" + strValue );
							  CheckBusyState();
							  break;
						   }
					 }
				 }				
			}catch(StaleElementReferenceException e){				
			}
			attempts++;
		}
		
		if(boolSelectItemFromWebListByPartialDisplayName==false)
		 {
			System.out.println("Webelement with name  : '" + getDriver().findElement(objElementName).getAttribute("name") + "' was not found - Data value provided is  " + strValue);
		 }
	}
	
	
	
	public void SelectValueFromFieldIntellisence(By objElementName, String strValue) throws Throwable
	{
		Boolean boolSelectValueFromFieldIntellisence=false;
		
		if(getDriver().findElements(objElementName).size()!=0 && StringUtil.isNotBlank(strValue))
		{
			String strName =getDriver().findElement(objElementName).getAttribute("name");
			getDriver().findElement(objElementName).sendKeys(strValue);			
			Thread.sleep(2000);
			getDriver().findElement(By.partialLinkText(strValue)).click();
			boolSelectValueFromFieldIntellisence=true;
			System.out.println("Set text on webelement : " + strName + " Value :" + strValue );
		}
		
		if(boolSelectValueFromFieldIntellisence==false)
		{
			System.out.println("Webelement with name  : '" + getDriver().findElement(objElementName).getAttribute("name") + "' was not found");
		}
		
	}
	
	
	public void ClickOnImage(By objElementName) throws InterruptedException
	{
		Boolean boolClickOnImage = false;
		
		int attempts = 0;
		while(attempts < 3)
		{
			try
			{
				if(getDriver().findElements(objElementName).size()!=0)
				{
					String strName =getDriver().findElement(objElementName).getAttribute("name");
					getDriver().findElement(objElementName).click();
					Thread.sleep(2000);
					boolClickOnImage = true;
					System.out.println("Clicked on Image : " + strName);
					break;
				}				
			}
			catch(StaleElementReferenceException e){				
			}
			attempts++;			
		}
		
		
		
		if(boolClickOnImage==false)
		{
			System.out.println("Webelement with name  : '" + getDriver().findElement(objElementName).getAttribute("name") + "' was not found");
		}
	}
	
	
	public void CheckPageLoad() throws InterruptedException
	{
		if(!getDriver().findElement(By.id("contentFrame")).isDisplayed()) 
		{
			getDriver().navigate().refresh();
			Thread.sleep(5000);
		}	
	}
	
	
	public long startTime()
	{
		Date d1 = new Date();
		System.out.println(d1.getTime());
		return d1.getTime();
	}
	
	public void TimeDifference(long inputTime)
	{
		Date d2 = new Date();
		long timedifference = d2.getTime() - inputTime;
		System.out.println("time difference is " + timedifference/1000);		
	}
	
	
	public static void deleteFolder(File folder) {
	    File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isDirectory()) {
	                deleteFolder(f);
	            } else {	            	
	                f.delete();
	            }
	        }
	    }
	    folder.delete();	    
	}
	
	
	
	public static String ReadFolder(File folder) {
	    File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	        	 System.out.println(f.getName());
	        	 System.out.println(f.getPath());
	        	// System.out.println(f.getPath() + "\\" + f.getName());
	        	 return f.getPath();
	        }
	    }
		return null;
	}
	
	
	public void CheckBusyState() {
		WebElement BusyElement = getDriver().findElement(By.xpath("//img[@id='progress']"));

		int cnt = 0;
		int MaxSecond = 120;
		System.out.println("Busy element style details : - " + BusyElement.getAttribute("style"));
		while (!(BusyElement.getAttribute("style").contains("display: none;") && cnt <= MaxSecond))
		// while(BusyElement.getAttribute("style").equalsIgnoreCase("display:
		// none;"))
		{
			try {
				Thread.sleep(500);
				int v1 = cnt++;
				System.out.println("waiting ... : " + v1 +" Seconds");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void WaitForBusyIcon() {
		WebDriverWait wt = new WebDriverWait(getDriver(),60);
		WebElement busyElement = getDriver().findElement(By.id("loading"));
		wt.until(ExpectedConditions.invisibilityOf(busyElement));
	}

	
	public void NavigateApplication(String ApplicationPath) throws Throwable {		
		System.out.println("-----------Landing Page user navigates to Group application -------------");
		String APPPath = "";
		if(ApplicationPath!="")
		{
			String enumValue=null;
			/*if(ApplicationPath.contains("/"))
			{
				enumValue = ApplicationPath.replace("/", "_").toUpperCase();
			}*/
			if(ApplicationPath.contains(" "))
			{
				enumValue = ApplicationPath.replace(" ", "_").toUpperCase();
			}
			else
			{
				enumValue = ApplicationPath.toUpperCase();
			}
			//System.out.println(" application selected is " + Apps.valueOf(enumValue));	
			switch(Apps.valueOf(enumValue))
			{				
				case GROUP:
				{	APPPath = "Customer Setup|Hierarchy|Group"; System.out.println("Group was selected");break;}
				case MEMBER:
				{	APPPath = "Customer Setup|Hierarchy|Member";System.out.println("MEMBER was selected");break;}
				case AUTH:
				{	APPPath = "Auth|Auth";System.out.println("Auth was selected");break;}
				case CLAIM:
				{	APPPath = "Claim|Claim";System.out.println("Claim was selected");break;}
				case CUSTOMER_SET:
				{	APPPath = "Customer Setup|Hierarchy|Customer Set";System.out.println("Customer Set was selected");break;}
				case CUSTOMER_CLIENT:
				{	APPPath = "Customer Setup|Hierarchy|Customer / Client";System.out.println("Customer/Client was selected");break;}
				case ASSIGN_OPTIONS:
				{	APPPath = "Customer Setup|Processing Options|Assign Options";System.out.println("Assign Options was selected");break;}
				case PRICING:
				{	APPPath = "Plan Setup|Pricing";System.out.println("Pricing was selected");break;}
				case ACCUMULATOR:
				{	APPPath = "Plan Setup|Accumulator";System.out.println("Accumulator was selected");break;}	
				case BENEFITS:
				{	APPPath = "Plan Setup|Benefits";System.out.println("Benefits was selected");break;}		
				case CONDITION:
				{	APPPath = "Plan Setup|Conditions";System.out.println("Conditions was selected");break;}
				case COVERAGE_CODE:
				{	APPPath = "Plan Setup|Coverage Code";System.out.println("Coverage Code was selected");break;}					
				case DUR_PROTOCOLS:
				{	APPPath = "Plan Setup|DUR Protocols";System.out.println("DUR Protocols was selected");break;}
				case DUR_SAFETY:
				{	APPPath = "Plan Setup|DUR Safety";System.out.println("DUR Safety was selected");break;}
				case MESSAGES:
				{	APPPath = "Plan Setup|Messages";System.out.println("Messages was selected");break;}
				case DRUG_LIST:
				{	APPPath = "Lists|Drug List";System.out.println("Drug List was selected");break;}
				case PHARMACY_LIST:
				{	APPPath = "Lists|Pharmacy List";System.out.println("Pharmacy List was selected");break;}
				case PRESCRIBER_LIST:
				{	APPPath = "Lists|Prescriber List";System.out.println("Prescriber List was selected");break;}
				case MAINTENANCE_HISTORY:
				{	APPPath = "History|Maintenance History";System.out.println("Maintenance History was selected");break;}
				case PRESCRIBER:
				{	APPPath = "Provider|Prescriber";System.out.println("Prescriber was selected");break;}
				case DRUG:
				{	APPPath = "Drug|Drug";System.out.println("Drug was selected");break;}
				case DRUG_FILE_CHANGE_REPORTS:
				{	APPPath = "Drug|Drug File Change Reports";System.out.println("Drug File Change Reports was selected");break;}
				case DATA_DICTIONARY:
				{	APPPath = "Help|Data Dictionary";System.out.println("Data Dictionary was selected");break;}		
				case NETWORK_MAINTENANCE:
				{	APPPath = "Provider|Network Maintenance";System.out.println("Network Maintenance was selected");break;}
				case PHARMACY_MAINTENANCE:
				{	APPPath = "Provider|Pharmacy Maintenance";System.out.println("Pharmacy Maintenance was selected");break;}
				case PHARMACY_SERVICE_FEES:
				{	APPPath = "Provider|Pharmacy Service Fees";System.out.println("Pharmacy Service Fees was selected");break;}
				case FINANCIAL:
				{	APPPath = "Provider|Financial";System.out.println("Financial was selected");break;}
				case TAGS:
				{	APPPath = "Plan Setup|Tags";System.out.println("Tags was selected");break;}				
				case RXNOVA_INTEL:
				{ APPPath = "RxNova Intel|RxNova Intel";System.out.println("RxNova Intel was selected");break; }
				default :
				{ System.out.println("Invalid Application selection - please check the application name");break;}				
			}			
			NavigateApplicationMenu(APPPath);		
			RxNova_PageSelection(APPPath);
			getDriver().switchTo().defaultContent();
			getDriver().switchTo().frame("contentFrame");
		}
	}	
	

	// Read all the content of text file - Used with BSC DRUGList Reporting Project
	public Scanner readTextContent(String strFilePath) throws FileNotFoundException {
		File myFile = new File(strFilePath);
		Scanner sc = new Scanner(myFile);		
		sc.useDelimiter("\\Z");		
	//	System.out.println(sc.next());
		return sc;
	}
	
	
	// Commonly used to copy files between locations
	private static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
	    FileUtils.copyFile(source, dest);
	}


	public void deleteFile(String fileToDelete) {
		String thisfileToDelete= fileToDelete.replace(" ", "_");
		File file = new File(thisfileToDelete);
		if(file.delete()) 
        { 
            System.out.println("File deleted successfully at location - " + thisfileToDelete); 
        } 
        else
        { 
            System.out.println("Failed to delete the file at location - " + thisfileToDelete + "File may not exists for deletion "); 
        } 
		
	}


	public String renameFile(String fileToRename) throws InterruptedException {
		Thread.sleep(8000);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String ThisDATE = dateFormat.format(date);	
		
		File oldfile = new File(fileToRename);
		String newFileName = fileToRename.replace(" ", "_").replace(".txt",  "_" + ThisDATE + ".txt");
		
		System.out.println(" this is the new file name - " + newFileName);
		File newfile = new File(newFileName );		
		if(oldfile.renameTo(newfile)){
			System.out.println("Rename succesful - " +  newfile);			
		}else{
			
			System.out.println("Rename failed");
		}
		return newFileName;
		
	}
	

	public void switchToContentFrame() {
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame("contentFrame");
	}
	
	
	
public void navigateToRxNovaApplication() 
	{			
		System.out.println("-----------Open firefox and start RxNova Application-------------");				
		try
		{
			InputRegion = System.getProperty("Region");
			System.out.println("InputRegion from jenkins : " + InputRegion);
			System.out.println("ERROR: ***********************Region parameter is empty*******************");			
		}
		catch(Exception e)
		{
			//InputRegion = utils.pf.getProperty("Region");
			InputRegion =  Project.Env.userName();
			System.out.println("InputRegion from properties file : " + InputRegion);
		}
		
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
				{ RxNova_URL = "https:qc-web/sso-web/login.jsf";isProduction=false; break;}
			case DR1:
			case DR2:
			case DR3:				
			case RX2:
				{RxNova_URL = "https:dev-web/sso-web/login.jsf";isProduction=false; break;}			
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
				{RxNova_URL = "https:beta.argushealth.com/sso-web/login.jsf?";isProduction=false; break;}
			case PRODUCTION:
				{RxNova_URL = "https:www.argushealth.com/sso-web/login.jsf?";isProduction=true;break;}
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