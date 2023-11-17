/**
 * 
 */
package com.eCommStore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;

import com.eCommStore.ElementActions.ElementActions;
import com.eCommStore.utility.ExtentManager;
import com.eCommStore.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 */
public class BaseClass 
{
	public static Properties prop;
	//public static WebDriver driver; 
	public static Logger Logger;
	
	//Declare ThreadLocal Driver Parallel testing using Java ThreadLocal Class
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static WebDriver getDriver()
	{
		//get driver from threadlocalmap
		return driver.get();
	}
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke", "Regression"})
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		getDriver().quit();
	}
		
	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig()
	{
		ExtentManager.setExtent();
		Logger = org.apache.log4j.Logger.getLogger("WebShop");
		PropertyConfigurator.configure("Log4j.properties");
		DOMConfigurator.configure("log4j.xml");
		try 
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
			System.out.println("driver: "+ driver);
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchApp(String browserName) 
	{
		//String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
			Log.info("Launched Chrome.");

		} 
		else if (browserName.equalsIgnoreCase("FireFox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new FirefoxDriver());
			Log.info("Launched Firefox.");

		} 
		else if (browserName.equalsIgnoreCase("IE")) 
		{
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
			Log.info("Launched IE.");
		}
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		ElementActions.implicitWait(getDriver(), 10);
		ElementActions.pageLoadTimeOut(getDriver(), 30);
	}
	
	@AfterSuite
	public void aftersuite()
	{
		ExtentManager.endReport();
	}
}
