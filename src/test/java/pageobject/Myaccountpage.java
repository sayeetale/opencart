package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends Basepage{
	
	public Myaccountpage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement Logout;
	
	
	public boolean IsAccountPageExist()
	{
		try {
		boolean result = MyAccount.isDisplayed();
		return result;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void accLogout()
	{
		Logout.click();
	}
	
	
}
