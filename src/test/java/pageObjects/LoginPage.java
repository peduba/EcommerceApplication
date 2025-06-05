package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_Email;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_Password;
	@FindBy(xpath="//input[@value='Login']") WebElement btn_Login;
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement myaccount_Header;
	
	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	public void setPassword(String password)
	{
		txt_Password.sendKeys(password);
	}
	public void clickLogin()
	{
		btn_Login.click();
	}
	
	public String headerText()
	{
		return (myaccount_Header.getText());
	}
	
	public boolean isDisplayedMyaccount()
	{
		try {
		return (myaccount_Header.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
	}
	}
	
	
	
	
	
	
	

}
