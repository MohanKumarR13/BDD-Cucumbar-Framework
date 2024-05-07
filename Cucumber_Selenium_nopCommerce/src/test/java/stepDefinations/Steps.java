package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class Steps {
	public static WebDriver driver;
	public static LoginPage lp;

	@Given("User launch  browser")
	public void user_launch_browser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		lp = new LoginPage(driver);

	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
		driver.navigate().to(url);

	}

	@When("User enters the email as {string} and password as {string}")
	public void user_enters_the_email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click to Login")
	public void click_to_login() throws InterruptedException {
		lp.clickLogin();
		Thread.sleep(3000);

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		System.out.println("Title is" + driver.getTitle());
		if (driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());

			System.out.println("Title is" + driver.getTitle());

		}
		Thread.sleep(2000);

	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(5000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

}
