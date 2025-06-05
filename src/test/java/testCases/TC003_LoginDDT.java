package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass { 
	/*
	   Data is valid - test case passed -logout
	                   login failed - test failed
	   Data is invalid - login success - test fail - logout
	                     login failed - test pass
	 */
	
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="datadriven")
	public void verify_LoginDDT(String email,String pwd,String res)
	{ 
		try {
		logger.info("**** TC003_LoginDDT started ******");
		//Home page
		HomePage hp= new HomePage(driver);
		hp.clickMyaccountLink();
		hp.clickLoginLink();
		//Login page
		LoginPage lt=new LoginPage(driver);
		lt.setEmail(email);
		lt.setPassword(pwd);
		lt.clickLogin();
		//MyAccount Page
		MyAccountPage mac=new MyAccountPage(driver);
		boolean targetPage=mac.isDisplayedMyaccount();
		if(res.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				mac.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(res.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				mac.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**** TC003_LoginDDT finished ******");
	}
	
}
