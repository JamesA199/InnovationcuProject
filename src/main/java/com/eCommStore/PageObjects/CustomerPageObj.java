package com.eCommStore.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.eCommStore.utility.Log;
import com.eCommStore.ElementActions.ElementActions;
import com.eCommStore.base.BaseClass;

public class CustomerPageObj extends BaseClass 
{
	
	
    //customers Page
	
	@FindBy(id = "SearchEmail")
	WebElement EmailTxt_id;

	@FindBy(id = "SearchFirstName")
	WebElement FirstNameTxt_id;

	@FindBy(id = "SearchLastName")
	WebElement LastNameTxt_id;
	
	@FindBy(id = "search-customers")
	WebElement SearchBtn_id;
	
	@FindBy(xpath = "//table[@role='grid']")
	WebElement SearchResultsTbl_xpath;

	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement table_xpath;
    
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	String tableRows_xpath;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
	WebElement tableColumns_xpath;


	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement newBtn_xpath;
	
	//initialize the page
	public CustomerPageObj()
	{
		PageFactory.initElements(getDriver(), this);
	}	

	
	public void type_srchEmail(String strEmail)
	{
		ElementActions.type(EmailTxt_id, strEmail);

	}	

	public void type_srchFname(String strFname)
	{
		ElementActions.type(FirstNameTxt_id, strFname);

	}	

	public void type_srchLname(String strLname)
	{
		ElementActions.type(FirstNameTxt_id, strLname);
	}	

	
	public int getNoOfRows()
	{
		int rowCnt = getDriver().findElements(By.xpath("//table[@id='customers-grid']//tbody/tr")).size();
		Log.info("Total row count: " + rowCnt);
		return rowCnt;
	}
        	
	
	public void click_srchBtn()
	{
    	ElementActions.click(getDriver(), SearchBtn_id, "Button");

	}		
	
	
	public void click_newBtn()
	{
    	ElementActions.click(getDriver(), newBtn_xpath, "Button");
		//return new AddNewCustomerPageObj();
	}	
	
}
