package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity" , "Master"})
	public void verify_Login() {
		logger.info("***** starting TC002_LoginTest****");
		
		try {
		//HomePAge
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		//LoginPAge
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email1"));
		//lp.setEmail("conec42703@asimarif.com");
		
		lp.setPassword(p.getProperty("password1"));
		//lp.setPassword("test@1234");
		
		lp.clickLogin();
		
		//MyAccount
		MyAccount macc=new MyAccount(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		//Assert.assertEquals(targetPage, true, "Login failed");
		Assert.assertTrue(targetPage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("***** starting TC002_LoginTest****");
		
		
	}

}
