package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToOrangeHRMWithData {
	public static WebDriver driver;

	@Given("User entering to login page in the browser")
	public void user_entering_to_login_page_in_the_browser() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}

	@When("Entering valid credentials {string} and {string}")
	public void entering_valid_credentials_and(String uName, String pwd) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
	}

	@When("Press login button")
	public void press_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(5000);
	}

	@Then("user should navigating to home page")
	public void user_should_navigating_to_home_page() {
		boolean status = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
		Assert.assertTrue(status);
		driver.quit();
	}
}
