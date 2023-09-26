package com.innovationcu.TestCases;

import com.innovationcu.PageObjects.LoginPage;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.innovationcu.PageObjects.LandingPage;
import com.innovationcu.base.BaseClass;
import com.innovationcu.utility.Log;

public class Login_TC extends BaseClass
{

	LandingPage landingPageobj;
	LoginPage loginPageobj;
	
	@Test(groups = {"Smoke"})
	public void LoginPage_Test() throws InterruptedException
	{
				
		landingPageobj=new LandingPage();
		Log.startTestCase("test Regression1");

		Log.info("test login");
		landingPageobj.clickLoginBtn();
		//getDriver().findElement(By.className("//a[@class='cmp-loginandsearch__login']")).click();
		Thread.sleep(3000);
		Set<String> windows = getDriver().getWindowHandles();
		Iterator <String> it = windows.iterator();
		String innovationHmPge = it.next();
		String loginpage = it.next();
		getDriver().switchTo().window(loginpage);
		String webPgeTitle = getDriver().getTitle();				

		Log.info(webPgeTitle);
    	getDriver().findElement(By.xpath("//input[@id='UserName_Input']")).click();
    	getDriver().findElement(By.xpath("//input[@id='UserName_Input']")).sendKeys("Test user");
    	
    	
    	getDriver().findElement(By.xpath("//input[@id='undefinedInput_Input']")).click();
    	getDriver().findElement(By.xpath("//input[@id='undefinedInput_Input']")).sendKeys("Testpass");
    	
    	Boolean vFlag = getDriver().findElement(By.id("LoginTransactionFirstLevelLogin2_Anchor")).isDisplayed();
    	if (vFlag == true)
    	{
			Log.info("Found login button");
			Log.startTestCase("LoginPage_Test");  
    		Assert.assertTrue(true);
    	}
    	else
    	{
			Log.info("Did not find login button");
			Log.startTestCase("LoginPage_Test");  
    		Assert.assertTrue(false);
    	}
    		
    	
		Thread.sleep(3000);
    	
    	getDriver().switchTo().window(innovationHmPge);
    	
		landingPageobj.clickBusinessLnk();
		String webPgeTitle1 = getDriver().getTitle();		
    	if (webPgeTitle1.equals("The Best Business Bank Account in Canada | Innovation Federal Credit Union"))
    	{
			Log.info("Business page title: "+webPgeTitle1);
			Log.startTestCase("test Regression1");  
    		Assert.assertTrue(true);
    	}
    	else
    	{
			Log.info("Did not find Business page title: "+webPgeTitle1);
			Log.startTestCase("test Regression1");  
    		Assert.assertTrue(false);
    	}
	}
	@Test(groups = {"Smoke"})
	public void openCredentialwebsite_Test() throws InterruptedException
	{
		landingPageobj=new LandingPage();
		Log.startTestCase("openCredentialwebsite_Test");

		landingPageobj.clickLoginBtn();
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
