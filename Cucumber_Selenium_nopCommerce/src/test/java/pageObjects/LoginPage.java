package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static WebDriver driver;

	public LoginPage(WebDriver webDriver) {
		driver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(id = "Email")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(id = "Password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//button[normalize-space()='Log in']")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	@CacheLookup
	WebElement linkLogout;

	public void setUserName(String uName) {
		txtEmail.clear();
		txtEmail.sendKeys(uName);
	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void clickLogout() {
		linkLogout.click();
	}
}
