package com.eCommStore.UserFlows;

import com.eCommStore.base.BaseClass;
import com.eCommStore.utility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eCommStore.ElementActions.ElementActions;
import com.eCommStore.PageObjects.CustomerPageObj;
import com.eCommStore.PageObjects.LoginPageObj;
import com.eCommStore.UserFlows.UserFlows;

public class UserFlows extends BaseClass
{
	static LoginPageObj loginPageobj;
	static CustomerPageObj customerPageObj;
	
	public static void tab_UserMethods(Boolean bcloseTabFlag, int itabIndex, String strtabTitle)
	{
		
		ElementActions.switchTabs(itabIndex, strtabTitle); //switch to the page and give it focus.	
	
		if (bcloseTabFlag == true)
		{
			ElementActions.closeBrsTab(1, prop.getProperty("LoginPageTitle"));
		}
	}
	
	public static void login_Steps(String uname, String pword) throws Throwable
	{
		loginPageobj=new LoginPageObj();
		
		loginPageobj.type_userName(uname);
		loginPageobj.type_pWord(pword);
		loginPageobj.click_LoginBtn();
	
	}
	
	public static boolean srchCustomerByName(String strName)
	{
		customerPageObj=new CustomerPageObj();
		
        boolean bflag = false;
        System.out.println("rows "+customerPageObj.getNoOfRows());
        for(int i=1;i<customerPageObj.getNoOfRows() + 1;i++)
        {
            System.out.println("start");
            WebElement table = getDriver().findElement(By.xpath ("//table[@id='customers-grid']"));
            System.out.println("WebElement" +table);
            String nameId = table.findElement(By.xpath ("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]")).getText();
            if (strName.equals(nameId))
            {
                Log.info("Found name in customers table in row " + i + ": " + nameId);
                bflag = true;
                break;
            }

        }
		if (bflag == false)
		{
            Log.info("***Fail-Did NOT find "+strName);
 			Assert.fail("***Fail-Did NOT find "+strName);

		}
        return bflag;		

	}
	public static boolean srchCustomerByEmail(String strEmail)
	{
		customerPageObj=new CustomerPageObj();
		
        boolean bflag = false;
    			
        for(int i=1;i<customerPageObj.getNoOfRows();i++)
        {
        	
            WebElement table = getDriver().findElement(By.xpath ("//*[@id='customers-grid']"));
            String emailId = table.findElement(By.xpath ("//*[@id='customers-grid']/tbody/tr['" + i + "']/td[2]")).getText();
            if (strEmail.equals(emailId))
            {
                Log.info("Found email in customers table in row " + i + ": " + emailId);
                bflag = true;
                break;
            }

        }
		if (bflag == false)
		{
            Log.info("***Fail-Did NOT find "+strEmail);
 			Assert.fail("***Fail-Did NOT find "+strEmail);

		}
        return bflag;		

	}

	public static boolean srchCustomerTablebyCol(String strSrchData, String strcolName, int icolIndex)
	{
		customerPageObj=new CustomerPageObj();
		
        boolean bflag = false;
        Log.info("Looking for customer data: "+strSrchData+" under column name: "+strcolName);		
        for(int irow=1;irow < customerPageObj.getNoOfRows() + 1;irow++)
        {
            WebElement table = getDriver().findElement(By.xpath ("//table[@id='customers-grid']"));
            String strSrchResults = table.findElement(By.xpath ("//table[@id='customers-grid']/tbody/tr[" + irow + "]/td[" + icolIndex + "]")).getText();
            //Log.info("Found this..."+strSrchResults+" under column name: "+strcolName+" in row: " + irow);
            if (strSrchData.equals(strSrchResults))
            {
                Log.info("Found "+strSrchData+" under column name: "+strcolName+" in row: " + irow);
                bflag = true;
                break;
            }
        }

		if (bflag == false)
		{
            Log.info("***Fail-Did NOT find "+strSrchData+" under column name.: "+strcolName+" in the customers table.");
 			Assert.fail("***Fail-Did NOT find "+strSrchData+" under column name: "+strcolName+" in the customers table.");

		}
        
        
        return bflag;		

	}	
	
	public static boolean srchandEditCustomerbyCol(String strSrchData, String strcolName, int icolIndex)
	{
		customerPageObj=new CustomerPageObj();
		
        boolean bflag = false;
        Log.info("Looking for customer data: "+strSrchData+" under column name: "+strcolName);		
        for(int irow=1;irow < customerPageObj.getNoOfRows() + 1;irow++)
        {
            WebElement table = getDriver().findElement(By.xpath ("//table[@id='customers-grid']"));
            String strSrchResults = table.findElement(By.xpath ("//table[@id='customers-grid']/tbody/tr[" + irow + "]/td[" + icolIndex + "]")).getText();
            //Log.info("Found this..."+strSrchResults+" under column name: "+strcolName+" in row: " + irow);
            if (strSrchData.equals(strSrchResults))
            {
                Log.info("Found "+strSrchData+" under column name: "+strcolName+" in row: " + irow);
                table.findElement(By.xpath ("//table[@id='customers-grid']/tbody/tr[" + irow + "]/td[7]")).click();
                Log.info("Clicked edit button for: "+strSrchData);
                bflag = true;
                break;
            }
        }

		if (bflag == false)
		{
            Log.info("***Fail-Did NOT find "+strSrchData+" under column name.: "+strcolName+" in the customers table.");
 			Assert.fail("***Fail-Did NOT find "+strSrchData+" under column name: "+strcolName+" in the customers table.");

		}
        
        
        return bflag;		

	}	
	
	
}
