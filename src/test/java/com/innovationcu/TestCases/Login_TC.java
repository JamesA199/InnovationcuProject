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

		Thread.sleep(1000);
    	
		getDriver().switchTo().window(loginpage);
		getDriver().close();
		Log.info("Closed login tab");
		
	}

}
