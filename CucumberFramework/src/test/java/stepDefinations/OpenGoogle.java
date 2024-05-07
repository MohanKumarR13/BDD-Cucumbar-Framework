package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenGoogle {
	public static WebDriver driver;

	@Given("User entering google.co.in")
	public void user_entering_google_co_in() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in");
	}

	@When("User enters {string}")
	public void user_enters(String string) {
		driver.findElement(By.name("q")).sendKeys(string);
	}

	@When("Enters the return key")
	public void enters_the_return_key() {
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

	}

	@Then("user should see the result set")
	public void user_should_see_the_result_set() {
		boolean status = driver.findElement(By.partialLinkText("git")).isDisplayed();
		if (status) {
			System.out.println("User should see the result set");
			driver.quit();
		}

	}

}
