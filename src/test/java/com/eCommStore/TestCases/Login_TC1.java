package com.eCommStore.TestCases;

import com.eCommStore.PageObjects.LoginPageObj;
import com.eCommStore.UserFlows.UserFlows;

import org.testng.annotations.Test;

import com.eCommStore.PageObjects.LandingPageObj;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utility.Log;

public class Login_TC1 extends BaseClass
{

	LandingPageObj landingPageobj;
	LoginPageObj loginPageobj;
	
	@Test(groups = {"Smoke", "Regression"})
	public void LoginPage_Test() throws Throwable
	{
				
		landingPageobj=new LandingPageObj();
		loginPageobj=new LoginPageObj();

		Log.startTestCase("************Start Login_TC1************");
    		loginPageobj.isDisplayed_welcomeMsg(); //check welcome message has been displayed
			UserFlows.login_Steps(prop.getProperty("username"), prop.getProperty("password"));
			landingPageobj.click_logoutBtn();
			getDriver().quit(); 
			
		Log.endTestCase("************End Login_TC1************");  
		
	}

}
