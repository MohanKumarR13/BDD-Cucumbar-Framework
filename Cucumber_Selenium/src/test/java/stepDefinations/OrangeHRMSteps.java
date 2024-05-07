package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMSteps {
	static WebDriver driver;

	@Given("I launch chrome browser")
	public void i_launch_chrome_browser() {
		// Write code here that turns the phrase above into concrete actions
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();

	}

	@When("I open orange hrm homepage")
	public void i_open_orange_hrm_homepage() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}

	@Then("I verfiy that the logo present on page")
	public void i_verfiy_that_the_logo_present_on_page() {
		// Write code here that turns the phrase above into concrete actions
		boolean display = driver.findElement(By.name("username"))
				.isDisplayed();
		
		if(display) {
			System.out.println("Diplayed the Component");
		}
	

	}

	@And("close browser")
	public void close_browser() {
		// Write code here that turns the phrase above into concrete actions
		driver.quit();
		
	}
}
