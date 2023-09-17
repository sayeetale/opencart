package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registrationpage extends Basepage {
	
	public Registrationpage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmpwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement confirm;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
	
	public void firstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	public void lastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	public void email(String mail)
	{
		email.sendKeys(mail);
	}
	public void phone(String pnumber)
	{
		telephone.sendKeys(pnumber);
	}
	public void password(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void confirmpwd(String cpwd)
	{
		confirmpwd.sendKeys(cpwd);
	}
	public void checkbox()
	{
		checkbox.click();
	}
	public void button()
	{
		confirm.click();
	}
	
	
	public String confirmmsg()
	{
		
		try {
			return msgconfirmation.getText();
		} 
		catch (Exception e)
		{
	
			return e.getMessage();
		}
		
	}
	
	
	
	}
	
	
	

	

