package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {
	
	@Test(groups={"sanity","master"})
	public void TC002_verifyLoginFunctionality()
	{
		try {
	HomePage hp=new HomePage(driver);
	hp.clickMyaccountLink();
	hp.clickLoginLink();
	LoginPage lt = new LoginPage(driver);
	lt.setEmail("kirankumarpcs@gmail.com");
	lt.setPassword("Qssi@123");
	lt.clickLogin();
	//String expected_Value=lt.headerText();
	Assert.assertEquals(lt.isDisplayedMyaccount(), true);
		}
		catch(Exception e)
		{
		Assert.fail();
		}
	}
	

}
