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
import com.eCommStore.PageObjects.LandingPageObj;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utility.Log;

public class addNewCustUseSrchBtn_TC4 extends BaseClass
{
	LandingPageObj landingPageObj;
	LoginPageObj loginPageobj;
	DashboardPageObj dashboardPageObj;
	CustomerPageObj customerPageObj;
	AddNewCustomerPageObj addNewCustomerPageObj;
	
	@Test(groups = {"Regression"})
	public void addNewCustomer_Test() throws Throwable
	{
		landingPageObj = new LandingPageObj();
		loginPageobj = new LoginPageObj();
		dashboardPageObj = new DashboardPageObj();
		addNewCustomerPageObj = new AddNewCustomerPageObj();
		customerPageObj = new CustomerPageObj();
		
		Log.startTestCase("************Start addNewCustUseSrchBtn_TC4************");

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
			addNewCustomerPageObj.type_dob("11/15/20"+ElementActions.randomeNum(2));
			
			String strcompanyName = "companyName"+ElementActions.randomestring(4);
			addNewCustomerPageObj.type_companyName(strcompanyName);
			addNewCustomerPageObj.type_customerRoles("Registered");
			addNewCustomerPageObj.select_ManagerOfVendor("Vendor 1");
			addNewCustomerPageObj.type_adminComment("test customer");
			addNewCustomerPageObj.click_saveBtn();
			Thread.sleep(3000);

			//String[] fname_lname = customerName.split(",");
			
			customerPageObj.type_srchFname(strFname);
			customerPageObj.click_srchBtn();

			Thread.sleep(1000);

			UserFlows.srchCustomerTablebyCol(strEmail, "email", 2);
						
			/*boolean btblFlag = UserFlows.srchCustomerTablebyCol(customerName, "Name", 3);
			if (btblFlag == true)
			{
                Log.info("Found new customer in customers table: "+customerName+" under column name: Name.");
			}
			else
			{
                Log.error("***Fail-Did NOT find new customer in customers table: "+customerName+" under column name: Name.", getDriver());
    			Assert.fail("***Fail-Did NOT find new customer in customers table: "+customerName+" under column name: Name.");
			}
			
			boolean btblFlag1 = UserFlows.srchCustomerTablebyCol(strcompanyName, "Company Name", 5);
			if (btblFlag1 == true)
			{
                Log.info("Found new customer company in customers table: "+strcompanyName+" under column name: Company Name.");
			}
			else
			{
                Log.error("***Fail-Did NOT find new customer company in customers table: "+strcompanyName+" under column name: Company Name.", getDriver());
    			Assert.fail("***Fail-Did NOT find new customer company in customers table: "+strcompanyName+" under column name: Company Name.");
			}	*/		
			Thread.sleep(8000);
			landingPageObj.click_logoutBtn();		
			getDriver().quit(); 
			
		Log.endTestCase("************End addNewCustUseSrchBtn_TC4************");  
		
	}
}
