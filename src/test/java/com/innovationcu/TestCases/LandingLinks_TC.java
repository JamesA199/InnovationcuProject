package com.innovationcu.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.innovationcu.base.BaseClass;
import com.innovationcu.PageObjects.BusinessPage;
import com.innovationcu.PageObjects.LandingPage;
import com.innovationcu.utility.Log;

public class LandingLinks_TC extends BaseClass 
{
		LandingPage landingPageobj;
		BusinessPage businessPageobj;
		
	  @Test(groups = {"Smoke"})
	  public void OpenLinks_Test() 
	  {
			landingPageobj=new LandingPage();
			businessPageobj=new BusinessPage();
			
			Log.startTestCase("OpenLinks_Test"); 	
			
			
			Log.info("clickBusinessLnk"); 	
			businessPageobj = landingPageobj.clickBusinessLnk();
			String webPgeTitle1 = getDriver().getTitle();		
		  	if (webPgeTitle1.equals("The Best Business Bank Account in Canada | Innovation Federal Credit Union"))
		  	{
				Log.info("Business page title: "+webPgeTitle1);
		  		Assert.assertTrue(true);
		  	}
		  	else
		  	{
				Log.info("Did not find Business page title: "+webPgeTitle1);
		  		Assert.assertTrue(false);
		  	}	  
		  	
		  	boolean bFlag = businessPageobj.isDisplayedpreapprovedfinancing();
		  	if (bFlag == true)
		  	{
				Log.info("pre-Approved Financing link is displayed.");
				Log.endTestCase("OpenLinks_Test"); 	
		  		Assert.assertTrue(true);
		  	}
		  	else
		  	{
				Log.info("pre-Approved Financing link is NOT displayed.");
				Log.endTestCase("OpenLinks_Test"); 	
		  		Assert.assertTrue(false);
		  	}
		  	
	  	
	  	
	  }
}
