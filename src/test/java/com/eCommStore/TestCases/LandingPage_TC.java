package com.eCommStore.TestCases;

import org.testng.annotations.Test;

import com.eCommStore.PageObjects.LandingPageObj;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utility.Log;

public class LandingPage_TC extends BaseClass
{

	LandingPageObj LandingPageobj;
    
	@Test(groups = {"Regression"})
	public void clickLink_Test1()
	{
		LandingPageobj=new LandingPageObj();
		Log.startTestCase("test Regression1");
		
		System.out.println("test Regression1");
		Log.info("test Regression1");
		LandingPageobj.click_LoginBtn();
		
		Log.endTestCase("test Regression1");
	}
	
	@Test(groups = {"Smoke"})
	public void clickLink_Test2()
	{
		LandingPageobj=new LandingPageObj();
		Log.startTestCase("test Smoke1");		
		System.out.println("test smoke1");
		Log.info("test smoke1");
		LandingPageobj.click_LoginBtn();
		Log.endTestCase("test Smoke1");		
	}
	
	@Test(groups = {"Smoke"})
	public void clickLink_Test3()
	{
		Log.startTestCase("test Smoke2");		
		LandingPageobj=new LandingPageObj();
		System.out.println("test Smoke2");
		Log.info("test Smoke2");
		LandingPageobj.click_LoginBtn();
		Log.endTestCase("test Smoke2");			
	}
}
