package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistartionTest extends BaseClass {

	//public WebDriver driver;

	//	@BeforeClass
	//	public void setup() {
	//		driver=new ChromeDriver();
	//		driver.manage().deleteAllCookies();
	//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//		driver.get("https://tutorialsninja.com/demo/");
	//		driver.manage().window().maximize();
	//	}
	//	@AfterClass
	//	public void tearDown() {
	//		driver.quit();
	//	}

	@Test(groups={"Regression" , "Master"})
	public void verify_account_registration() {

		logger.info("****starting TC001_AccountRegistartionTest ****** ");

		try {
			HomePage hp=new HomePage(driver);

			hp.clickMyaccount();
			logger.info("clicking on my account link...");
			hp.clickRegister();
			logger.info("clicking on register link");

			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);

			logger.info("providing customer details...");
			//regpage.setFirstName("john");
			regpage.setFirstName(randomeString().toUpperCase());
			//regpage.setLastName("raji");
			regpage.setLastName(randomeString().toUpperCase());
			//regpage.setEmail("abc@gamil.com");
			regpage.setEmail(randomeString()+"@gmail.com");//randomly generated the email
			//regpage.setTelephonen("1234567890");
			regpage.setTelephonen(randomeNumbers());
			//		regpage.setPassword("xyz345");
			//		regpage.setConfirmPassword("xyz345");

			String password=randomAlphaNumeric();
			regpage.setPassword("password");
			regpage.setConfirmPassword("password");
			regpage.setchdpolicy();
			regpage.clickContinue();

			logger.info("validating expected message...");
			String confmsg=regpage.getCinfirmationMsg();

			//			if(confmsg.equals("Your Account Has Been Created!!")) {
			//				Assert.assertTrue(true);
			//			}
			//			else {                                                      
			//				logger.error("Test failed....");                  //for log file
			//				logger.debug("Debug Logs...");
			//
			//				Assert.assertTrue(false);
			//			}

			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			//			logger.error("Test failed....");
			//		logger.debug("Debug Logs...");
			Assert.fail();
		}
		//	public String randomeString() {
		//		String generatedString=RandomStringUtils.randomAlphabetic(5);
		//		return generatedString;
		//
		//	}
		//	
		//	public String randomeNumbers() {
		//		String generatednumbers=RandomStringUtils.randomNumeric(10);
		//		return generatednumbers;
		//	}
		//	
		//	public String randomAlphaNumeric() {
		//		String genratedString=RandomStringUtils.randomAlphabetic(5);
		//		String generatednumbers=RandomStringUtils.randomNumeric(5);
		//		return (genratedString+"@"+generatednumbers);
		//		
		//	}
		logger.info("****finished TC001_AccountRegistartionTest ****** ");
	}

}
