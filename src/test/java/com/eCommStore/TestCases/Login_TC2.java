package com.eCommStore.TestCases;

import com.eCommStore.PageObjects.LoginPageObj;
import com.eCommStore.UserFlows.UserFlows;

import org.testng.annotations.Test;

import com.eCommStore.PageObjects.LandingPageObj;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utility.Log;

public class Login_TC2 extends BaseClass
{

	LandingPageObj landingPageobj;
	LoginPageObj loginPageobj;
	
	@Test(groups = {"Smoke", "Regression"})
	public void LoginPage_Test() throws Throwable
	{
				
		landingPageobj=new LandingPageObj();
		loginPageobj=new LoginPageObj();

		Log.startTestCase("************Start Login_TC2************");
			boolean bwelFlag = loginPageobj.isDisplayed_welcomeMsg(); //check welcome message has been displayed
		
			if (bwelFlag == true)
			{
				Log.info("Wecome message is displayed.");  
			}
			else
			{
				Log.warn("Wecome message is NOT displayed.");  
			}
			UserFlows.login_Steps(prop.getProperty("username"), "tet");
			
			boolean berrFlag = loginPageobj.isDisplayed_loginMsgErrorMsg(); //check  login error message has been displayed
			
			if (berrFlag == true)
			{
				Log.info("login error message is displayed.");  
			}
			else
			{
				Log.warn("login error message is NOT displayed.");  
			}			
			getDriver().quit(); 
			
		Log.endTestCase("************End Login_TC2************");  
		
	}

}
