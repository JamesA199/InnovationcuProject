package com.eCommStore.TestCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eCommStore.PageObjects.LandingPageObj;
import com.eCommStore.PageObjects.LoginPageObj;
import com.eCommStore.utility.Log;
import com.eCommStore.base.BaseClass;

public class Credential_TC extends BaseClass 
{
	LandingPageObj landingPageobj;
	LoginPageObj loginPageobj;
	
	@Test(groups = {"Smoke"})
	public void openCredentialwebsite_Test() throws InterruptedException
	{
		landingPageobj=new LandingPageObj();
		Log.startTestCase("openCredentialwebsite_Test");

		landingPageobj.click_LoginBtn();
		Thread.sleep(3000);
		//get open web windows\tabs and switch to the active browser tab 
		Set<String> windows = getDriver().getWindowHandles();
		Iterator <String> it = windows.iterator();
		String innovationHmPge = it.next();
		String loginpage = it.next();
		
		getDriver().switchTo().window(loginpage);
		String webPgeTitle = getDriver().getTitle();				

		Log.info(webPgeTitle);
		getDriver().findElement(By.xpath("//span[normalize-space()='Credential Login']")).click();
		
		Thread.sleep(3000);
		//get open web windows\tabs and switch to the active browser tab 
		Set<String> windows1 = getDriver().getWindowHandles();
		Iterator <String> it1 = windows1.iterator();
		String innovationHmPge1 = it1.next();
		String loginpage1 = it1.next();
		String credentialHmpg = it1.next();
		//getDriver().switchTo().window(innovationHmPge1);
		//getDriver().quit();
		getDriver().switchTo().window(credentialHmpg);
		String webPgeTitle1 = getDriver().getTitle();

	
    	if (webPgeTitle1.equals("Credential Financial Inc."))
    	{
			Log.info("Website opened title: "+webPgeTitle1);
			getDriver().switchTo().window(credentialHmpg);
			getDriver().close();
			Log.info("Close Credential Finincial tab.");
			getDriver().switchTo().window(loginpage1);
			getDriver().close();
			Log.info("Close login tab");
			Log.endTestCase("openCredentialwebsite_Test");  
    		Assert.assertTrue(true);
    	}
    	else
    	{
			Log.info("Website opened: "+webPgeTitle1);
			getDriver().switchTo().window(credentialHmpg);
			getDriver().close();
			Log.info("Close Credential Finincial tab.");
			getDriver().switchTo().window(loginpage1);
			getDriver().close();
			Log.info("Close login tab");
			Log.endTestCase("openCredentialwebsite_Test");  
    		Assert.assertTrue(false);
    	}

	}
}
