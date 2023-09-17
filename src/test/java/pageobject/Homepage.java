package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {
	
	
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Login;
	
	public void clickMyAccount()
	{
		MyAccount.click();
	}
	
	public void Register()
	{
		Register.click();
		
	}
	
	public void Login()
	{
		Login.click();
		
	}
	
	
	
}
