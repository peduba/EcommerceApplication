package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement link_Myaccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement link_Register;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement link_Login;
	
	
	public void clickRegisterLink()
	{
		link_Register.click();
	}
	
	public void clickLoginLink()
	{
		link_Login.click();
	}
	public void clickMyaccountLink()
	{
		link_Myaccount.click();
	}
	
	
	

}
