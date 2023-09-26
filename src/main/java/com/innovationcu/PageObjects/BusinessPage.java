/**
 * 
 */
package com.innovationcu.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innovationcu.ActionDriver.ActionDriver;
import com.innovationcu.base.BaseClass;

/**
 * 
 */
public class BusinessPage extends BaseClass 
{
	@FindBy(xpath = "//div[@class='d-none d-md-block']//a[@aria-label='Get pre-approved financing!'][normalize-space()='Get pre-approved financing!']")
	WebElement preapprovedfinancingLnk;
	
	//initialize the page
	public BusinessPage()
	{
		PageFactory.initElements(getDriver(), this);
	}	
	
	
	public PreapprovedPage clickBusinessLnk()
	{
		ActionDriver.click(getDriver(), preapprovedfinancingLnk, "Link");
		return new PreapprovedPage();

	}
	
	public boolean isDisplayedpreapprovedfinancing()
	{
		return ActionDriver.isDisplayed(getDriver(), preapprovedfinancingLnk);


	}
}
