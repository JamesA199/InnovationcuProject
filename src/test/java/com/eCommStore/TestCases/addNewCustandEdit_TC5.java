package com.eCommStore.TestCases;

import com.eCommStore.PageObjects.LoginPageObj;
import com.eCommStore.UserFlows.UserFlows;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eCommStore.ElementActions.ElementActions;
import com.eCommStore.PageObjects.AddNewCustomerPageObj;
import com.eCommStore.PageObjects.CustomerPageObj;
import com.eCommStore.PageObjects.DashboardPageObj;
import com.eCommStore.PageObjects.EditCustomerPageObj;
import com.eCommStore.PageObjects.LandingPageObj;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utility.Log;

public class addNewCustandEdit_TC5 extends BaseClass
{
	LandingPageObj landingPageObj;
	LoginPageObj loginPageobj;
	DashboardPageObj dashboardPageObj;
	CustomerPageObj customerPageObj;
	AddNewCustomerPageObj addNewCustomerPageObj;
	EditCustomerPageObj editCustomerPageObj;
	
	@Test(groups = {"Regression"})
	public void addNewCustomer_Test() throws Throwable
	{
		landingPageObj = new LandingPageObj();
		loginPageobj = new LoginPageObj();
		dashboardPageObj = new DashboardPageObj();
		addNewCustomerPageObj = new AddNewCustomerPageObj();
		customerPageObj = new CustomerPageObj();
		editCustomerPageObj = new EditCustomerPageObj();
		
		Log.startTestCase("************Start addNewCustandEdit_TC5************");

			boolean bFlag = loginPageobj.isDisplayed_welcomeMsg(); //check  welcome message has been displayed
			
			if (bFlag == true)
			{
				Log.info("Wecome message is displayed.");  
			}
			else
			{
				Log.warn("Wecome message is NOT displayed.");  
			}
			
			UserFlows.login_Steps(prop.getProperty("username"), prop.getProperty("password"));
			dashboardPageObj.click_customersMnuItm();
			
			Log.info("add a new customer email");  
			customerPageObj.click_newBtn();
			String strEmail = ElementActions.randomestring(8)+"@gmail.com";
			addNewCustomerPageObj.type_email(strEmail);
			addNewCustomerPageObj.type_password("pword");
			String strFname = "fname"+ElementActions.randomestring(4);
			String strLname = "lname"+ElementActions.randomestring(4);
			String customerName = strFname+" "+strLname;
			addNewCustomerPageObj.type_fname(strFname);
			addNewCustomerPageObj.type_lname(strLname);
			
			addNewCustomerPageObj.click_genderType("Female");
			addNewCustomerPageObj.type_dob("11/15/2023");
			
			String strcompanyName = "companyName"+ElementActions.randomestring(4);
			addNewCustomerPageObj.type_companyName(strcompanyName);
			addNewCustomerPageObj.type_customerRoles("Registered");
			addNewCustomerPageObj.select_ManagerOfVendor("Vendor 1");
			addNewCustomerPageObj.type_adminComment("test customer");
			addNewCustomerPageObj.click_saveBtn();
			Thread.sleep(3000);
			//String[] fname_lname = customerName.split(",");
			Log.info("edit the customer's email");  
				UserFlows.srchandEditCustomerbyCol(strEmail, "email", 2);
				String currPageTitle = getDriver().getTitle();
				
				if (currPageTitle.equals(prop.getProperty("EditcustomerPageTitle")))
				{
					Log.info("Page title: "+prop.getProperty("EditcustomerPageTitle")+" is open.");  
				}
				else
				{
					Log.warn("Page title: "+prop.getProperty("EditcustomerPageTitle")+" is NOT displayed.");  
				}
				
				String strEmailedit = ElementActions.randomestring(8)+"@gmail.com";
				editCustomerPageObj.type_email(strEmailedit);
			Log.info("save the updated customer info");  
				editCustomerPageObj.click_saveBtn();
				UserFlows.srchCustomerTablebyCol(strEmailedit, "email", 2);
				Thread.sleep(5000);
				landingPageObj.click_logoutBtn();
				
				
				getDriver().quit(); 

		Log.endTestCase("************End addNewCustandEdit_TC5************");  
		
	}
}
