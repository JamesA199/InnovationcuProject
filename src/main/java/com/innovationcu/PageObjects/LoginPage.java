/**
 * 
 */
package com.innovationcu.PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innovationcu.utility.Log;
import com.innovationcu.ActionDriver.ActionDriver;
import com.innovationcu.base.BaseClass;
/**
 * 
 */
public class LoginPage extends BaseClass
{
	@FindBy(id = "UserName_Input") 
	WebElement userName_InputTxbox;
	
		
	//initialize the page
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}	

	public void loginActions(String uname) throws Throwable
	{
		ActionDriver.type(userName_InputTxbox, uname);
		//Action.implicitWait(driver, 10);
		//Action.type(passwordTextBox, pwd);
		//Action.click(driver, loginBtn, "Button");
		//Action.implicitWait(driver, 10);
		//System.out.println("Logged into Web Shop with user: "+uname);
		Log.info("Logged into Web Shop with user: "+uname);
		//return new LandingPage();
	}

}
