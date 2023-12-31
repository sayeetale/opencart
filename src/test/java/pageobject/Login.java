package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends Basepage {
	
	public Login (WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement Loginbutton;
	
	
	public void enteremail(String mail)
	{
		email.sendKeys(mail);
	}
	public void enterpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	
	public void clickloginbutton()
	{
		Loginbutton.click();
	}
}
