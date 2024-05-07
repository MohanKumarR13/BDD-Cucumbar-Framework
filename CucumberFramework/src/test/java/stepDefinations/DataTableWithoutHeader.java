package stepDefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataTableWithoutHeader {
	static WebDriver driver;

	@Given("You are on entering to login page in the browser")
	public void you_are_on_entering_to_login_page_in_the_browser() throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}

	@When("Your valid credentials")
	public void your_valid_credentials(DataTable dataTable) {
		List<String> credentials = dataTable.asList(String.class);
		String userName =  credentials.get(0);
		String password = credentials.get(1);

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
	}

	@When("Click the login button")
	public void click_the_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(5000);
	}

	@Then("You should navigating to home page")
	public void you_should_navigating_to_home_page() {
		boolean status = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
		Assert.assertTrue(status);
		driver.quit();
	}

}
