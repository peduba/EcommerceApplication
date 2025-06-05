package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public WebDriver driver;
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement myaccount_Header;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement link_Logout;
	
	public void clickLogout()
	{
		link_Logout.click();
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
