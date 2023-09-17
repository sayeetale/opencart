package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Homepage;
import pageobject.Registrationpage;
import testbase.Baseclass;

public class AccountRegistrationTest extends Baseclass {
	
	@Test
	public void testcaseregistration()
	{
		logger.info("***********************************Starting test case************************************************");
		try
		{
	Homepage home = new Homepage(driver);
	logger.info("clicking on myaccount link");
	home.clickMyAccount();
	home.Register();
	
	Registrationpage rp = new Registrationpage(driver);
	
	rp.firstname("sayee");
	rp.lastname("tale");
	rp.email(randomstring()+"@gmail.com");
	rp.phone(randomnumber());
	String storepwd = randomalphanumeric();
	rp.password(storepwd);
	rp.confirmpwd(storepwd);
	rp.checkbox();
	rp.button();
	
	
    Assert.assertEquals(rp.confirmmsg(), "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***********************************Starting test case************************************************");
	
	}
}
