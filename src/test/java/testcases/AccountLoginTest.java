package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Homepage;
import pageobject.Login;
import pageobject.Myaccountpage;
import testbase.Baseclass;

public class AccountLoginTest extends Baseclass {
	@Test
	public void testlogin()
	{
		Homepage home = new Homepage(driver);
		home.clickMyAccount();
		home.Login();
		
		Login login = new Login(driver);
		login.enteremail(rp.getString("email"));
		login.enterpassword(rp.getString("password"));
		login.clickloginbutton();
		
		Myaccountpage map = new Myaccountpage(driver);
	boolean targetpage =	map.IsAccountPageExist();
		
		try {
			Assert.assertEquals(targetpage, true);
		} catch (Exception e) {
			Assert.fail();
		}
		
		
		
		
		
	}
	

}
