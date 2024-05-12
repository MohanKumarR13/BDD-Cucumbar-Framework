package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonUtils;
import webdriver.manager.DriverManager;

public class LoginPage {
	WebDriver driver = DriverManager.getDriver();
	private static LoginPage loginInstance;

	private LoginPage() {

	}

	public static LoginPage getInstance() {
		if (loginInstance == null) {
			loginInstance = new LoginPage();
		}
		return loginInstance;
	}

	@FindBy(name = "username")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement password;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginBtn;

	public void enterUserName(String user_Name) {
		By usersName = By.name("username");

		try {

			CommonUtils.getcommonUtilsInstance().highlightElements(driver.findElement(usersName));
			driver.findElement(usersName).sendKeys(user_Name);
		} catch (Exception e) {

			System.out.println("Element Not Found");
			try {
				WebDriverWait wait = new WebDriverWait(driver, 15);
				wait.until(ExpectedConditions.visibilityOfElementLocated(usersName));
			} catch (Exception e2) {
				System.out.println("Element Not Found");

			}

		}
	}

	public void enterPassword(String pwd) {
		CommonUtils.getcommonUtilsInstance().highlightElements(password);
		password.sendKeys(pwd);
	}

	public void clickLoginButton() {
		CommonUtils.getcommonUtilsInstance().highlightElements(loginBtn);

		loginBtn.click();
	}
}
