package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstName; ////input[@id='input-firstname']
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_Email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telNumber;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_Password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_confirmPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement chk_privacyPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_Continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement get_Confirmationmessage;
	
	
	
	public void setfirstName(String fname)
	{
		txt_firstName.sendKeys(fname);
	}
	public void setlastName(String Lname)
	{
		txt_lastName.sendKeys(Lname);
	}
	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	public void settelNumber(String tel)
	{
		txt_telNumber.sendKeys(tel);
	}
	public void setPassword(String pwd)
	{
		txt_Password.sendKeys(pwd);
	}
	public void setconfirmPassword(String cpwd)
	{
		txt_confirmPassword.sendKeys(cpwd);
	}
	public void selectPrivacyandPolicy()
	{
		chk_privacyPolicy.click();
	}
	public void click()
	{
		btn_Continue.click();
	}
	public String getconfirmationMessage()
	{
		return get_Confirmationmessage.getText();
	}
	
	


}
