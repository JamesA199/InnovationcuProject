package com.eCommStore.TestCases;

import com.eCommStore.PageObjects.LoginPageObj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eCommStore.ElementActions.ElementActions;
import com.eCommStore.PageObjects.LandingPageObj;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utility.Log;

public class Login_TC2bu extends BaseClass
{

	LandingPageObj landingPageobj;
	LoginPageObj loginPageobj;
	
	@Test(groups = {"Smoke"})
	public void LoginPage_Test() throws InterruptedException
	{
				
		landingPageobj=new LandingPageObj();

		Log.startTestCase("LoginPage_Test");

		Log.info("test login");
		//getDriver().findElement(By.xpath("//span[contains(text(),'Log in')]")).click();
		landingPageobj.click_LoginBtn(); //clicking login button opens a new tab
		Thread.sleep(3000);
		ElementActions.switchTabs(1, "Login | Innovation Federal Credit Union" ); //switch to the login page and give it focus
		
		getDriver().findElement(By.xpath("//input[@id='UserName_Input']")).click();
    	getDriver().findElement(By.xpath("//input[@id='UserName_Input']")).sendKeys("Test user");
    	
    	getDriver().findElement(By.xpath("//input[@id='undefinedInput_Input']")).click();
    	getDriver().findElement(By.xpath("//input[@id='undefinedInput_Input']")).sendKeys("Testpass");
    	//just check that the login button is displayed
    	Boolean bFlag = getDriver().findElement(By.id("LoginTransactionFirstLevelLogin2_Anchor")).isDisplayed();
    	if (bFlag == true)
    	{
			Log.info("Found login button");
    		Assert.assertTrue(true);
    	}
    	else
    	{
			Log.info("Did not find login button");
			Log.endTestCase("LoginPage_Test");  
    		Assert.assertTrue(false);
    	}
		//Get the current window handle
		//String currwindowHandle = getDriver().getWindowHandle();
		/*Set<String> windows = getDriver().getWindowHandles();
		Iterator <String> it = windows.iterator();
		String tabName = it.next();
		getDriver().switchTo().window(tabName);
		String webPgeTitle = getDriver().getTitle();				
		Log.info(webPgeTitle);*/
		//getDriver().switchTo().window(loginpage);
		//getDriver().switchTo().window(tabs.get(0));
		ElementActions.switchTabs(0, "Open a Personal Online Banking Account | Innovation Federal Credit Union");
		
		Thread.sleep(8);
		getDriver().quit(); //close login tab
		Log.endTestCase("LoginPage_Test");  
		
	}

}
