/**
 * 
 */
package com.eCommStore.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eCommStore.utility.Log;
import com.eCommStore.ElementActions.ElementActions;
import com.eCommStore.base.BaseClass;
/**
 * 
 */
public class LoginPageObj extends BaseClass
{
	@FindBy(id = "Email") 
	WebElement email_InputTxbox;

	@FindBy(id = "Password") 
	WebElement password_InputTxbox;	
	
	@FindBy(xpath = "//button[@type='submit']") 
	WebElement loginBtn;

	@FindBy(xpath = "//strong[normalize-space()='Welcome, please sign in!']") 
	WebElement welcomeMsg;

	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']") 
	WebElement loginMessageErrorMsg;	
	
	//initialize the page
	public LoginPageObj()
	{
		PageFactory.initElements(getDriver(), this);
	}	

	public void type_userName(String uname)
	{
		ElementActions.type(email_InputTxbox, uname);

	}

	public void type_pWord(String pword)
	{

		ElementActions.type(password_InputTxbox, pword);
	}	
	
	
	public DashboardPageObj click_LoginBtn()
	{
    	ElementActions.click(getDriver(), loginBtn, "Button");
    	
		return new DashboardPageObj();
	}	
	
	public boolean isDisplayed_welcomeMsg()
	{
		return ElementActions.isDisplayed(getDriver(), welcomeMsg);


	}	

	public boolean isDisplayed_loginMsgErrorMsg()
	{
		return ElementActions.isDisplayed(getDriver(), loginMessageErrorMsg);


	}	
	
	
}
