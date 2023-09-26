package com.innovationcu.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innovationcu.PageObjects.LandingPage;
import com.innovationcu.base.BaseClass;
import com.innovationcu.utility.Log;

public class LandingPage_TC extends BaseClass
{

	LandingPage LandingPageobj;
    
	@Test(groups = {"Regression"})
	public void clickLink_Test1()
	{
		LandingPageobj=new LandingPage();
		Log.startTestCase("test Regression1");
		
		System.out.println("test Regression1");
		Log.info("test Regression1");
		LandingPageobj.clickLoginBtn();
		
		Log.endTestCase("test Regression1");
	}
	
	@Test(groups = {"Smoke"})
	public void clickLink_Test2()
	{
		LandingPageobj=new LandingPage();
		Log.startTestCase("test Smoke1");		
		System.out.println("test smoke1");
		Log.info("test smoke1");
		LandingPageobj.clickLoginBtn();
		Log.endTestCase("test Smoke1");		
	}
	
	@Test(groups = {"Smoke"})
	public void clickLink_Test3()
	{
		Log.startTestCase("test Smoke2");		
		LandingPageobj=new LandingPage();
		System.out.println("test Smoke2");
		Log.info("test Smoke2");
		LandingPageobj.clickLoginBtn();
		Log.endTestCase("test Smoke2");			
	}
}
