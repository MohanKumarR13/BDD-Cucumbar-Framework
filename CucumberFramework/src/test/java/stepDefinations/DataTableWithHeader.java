package stepDefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataTableWithHeader {
	static WebDriver driver;

	@Given("You are in entering to login page in the browser")
	public void you_are_in_entering_to_login_page_in_the_browser() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}

	@When("Your valid credentials for login")
	public void your_valid_credentials_for_login(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	List<Map <String,String>>keyValuePair=   dataTable.asMaps(String.class,String.class);
	String userName=keyValuePair.get(0).get("username");
	String password=keyValuePair.get(0).get("password");
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
	}

	@When("Click the login button action")
	public void click_the_login_button_action() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(5000);
	}

	@Then("You should navigating to home page screen")
	public void you_should_navigating_to_home_page_screen() {
		boolean status = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
		Assert.assertTrue(status);
		driver.quit();
	}

}
