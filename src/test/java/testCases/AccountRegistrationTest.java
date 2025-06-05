package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"regression","master"})
	public void verify_Account_Registration() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyaccountLink();
		hp.clickRegisterLink();
		logger.info("***test case started***");
		AccountRegistrationPage reg= new AccountRegistrationPage(driver);
		reg.setfirstName(randomAlphbets().toUpperCase());
		logger.info("Entered firstname");
		reg.setlastName(randomAlphbets().toUpperCase());
		logger.info("Enterd lastname");
		reg.setEmail(randomAlphbets()+"@gmail.com");
		logger.info("Entered gmail");
		reg.settelNumber(randomNumeric());
		logger.info("Enterd telephone number");
		String password=randomAlphanumeric();
		
		reg.setPassword(password);
		logger.info("Enterd password");
		
		reg.setconfirmPassword(password);
		logger.info("Enterd confirm password");
		
		reg.selectPrivacyandPolicy();
		
		
		reg.click();
		logger.info("click on contine button");
		String confmsg=reg.getconfirmationMessage();
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		if(confmsg.equals("Your Account Has Been Created!!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test case failed");
			logger.debug("debug logs");
			Assert.fail();
		}
		
	}
	
}
