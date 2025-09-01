package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email']") WebElement textEmailAddress;
	@FindBy(xpath="//input[@name='password']") WebElement textpassword;
	@FindBy(xpath="//input[@type='submit']") WebElement btnLogin;
	
	public void setEmail(String email) {
		textEmailAddress.sendKeys(email);
	}
	public void setPassword(String pwd) {
		textpassword.sendKeys(pwd);
	}
	public void clickLogin() {
		btnLogin.click();
	}
}
