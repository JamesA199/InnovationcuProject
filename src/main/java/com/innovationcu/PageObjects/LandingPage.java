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
public class LandingPage extends BaseClass
{
	@FindBy(xpath = "//div/h1/a[@aria-label='Mortgage Cashback Offers']")
	WebElement mortgageCashbackOffersLnk;
	
	@FindBy(xpath = "//a[normalize-space()='Personal']")
	WebElement personalLnk;

	@FindBy(xpath = "//a[normalize-space()='Business']")
	WebElement businessLnk;
	
	@FindBy(xpath = "//a[normalize-space()='Wealth']")
	WebElement wealthLnk;

	@FindBy(xpath = "//span[contains(text(),'Log in')]")
	WebElement loginLnk;
	//a[@cla ss='cmp-loginandsearch__login']//span[contains(text(),'Log in')]

	//accounts dropdown menu link and items
	@FindBy(xpath = "//a[@data-title='Accounts']")
	WebElement accountsLnk;
	
	@FindBy(xpath = "//a[@href='/personal/accounts/no-fee-chequing.html'][normalize-space()='']")
	WebElement nofeechequingLnk;
	
	//initialize the page
	public LandingPage()
	{
		PageFactory.initElements(getDriver(), this);
	}	
	
	public LoginPage clickLoginBtn()
	{
		ActionDriver.click(getDriver(), loginLnk, "Button");
		return new LoginPage();

	}	
	
	public LoginPage clickPersonalLnk()
	{
		ActionDriver.click(getDriver(), personalLnk, "Link");
		return new LoginPage();

	}	
	
	public BusinessPage clickBusinessLnk()
	{
		ActionDriver.click(getDriver(), businessLnk, "Link");
		return new BusinessPage();

	}
	
}
