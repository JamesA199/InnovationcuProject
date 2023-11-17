package com.eCommStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eCommStore.ElementActions.ElementActions;
import com.eCommStore.base.BaseClass;

public class DashboardPageObj extends BaseClass 
{
	 //list items	
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customersMnu_xpath;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customersMnuItm_xpath;

	@FindBy(xpath = "//ul[@id='SelectedCustomerRoleIds_listbox']/li[text()='Administrators']")
	WebElement administratorsMnuItm_xpath;	
	
	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	WebElement registeredMnuItm_xpath;	

	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement guestsMnuItm_xpath;		

	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	WebElement vendorsLstitem_xpath;		

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement newBtn_xpath;	 
	 
	 
	//initialize the page
	public DashboardPageObj()
	{
		PageFactory.initElements(getDriver(), this);
	}	
	
	public void click_customersMnuItm()
	{
    	ElementActions.click(getDriver(), customersMnu_xpath, "Link");
    	ElementActions.click(getDriver(), customersMnuItm_xpath, "Link");
    	
		//return new CustomerPageObj();
	}	
	

}
