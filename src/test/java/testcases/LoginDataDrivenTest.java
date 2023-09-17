package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Homepage;
import pageobject.Login;
import pageobject.Myaccountpage;
import testbase.Baseclass;
import utilities.DataProviders;

public class LoginDataDrivenTest extends Baseclass {
	@Test(dataProvider= "LoginData", dataProviderClass = DataProviders.class )
	public void test_LoginDDT(String email, String pwd, String exp)
	{
		Homepage home = new Homepage(driver);
		home.clickMyAccount();
		home.Login();
		
		Login login = new Login(driver);
		login.enteremail(email);
		login.enterpassword(pwd);
		login.clickloginbutton();
		
		Myaccountpage map = new Myaccountpage(driver);
		boolean targetpage =	map.IsAccountPageExist();
		
		if(exp.equals("Valid"))
		{ if (targetpage==true)
			{
			map.accLogout();
			Assert.assertTrue(true);
			}
		else {
			Assert.assertFalse(false);
		}
				
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
			map.accLogout();
			Assert.assertFalse(false);	
			}
			else {
				Assert.assertTrue(true);
				
			}
			
			
		}
		

		
		
	}
		
		
		
		
		
		
		
		
		
	}
	
	

}
