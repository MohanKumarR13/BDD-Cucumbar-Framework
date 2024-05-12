package stepdefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.DirectoryPage;
import pageobjectmodel.HomePage;
import pageobjectmodel.LoginPage;
import utilities.CommonUtils;
import webdriver.manager.DriverManager;

public class VerifyCFONameStepDefinations {
	private static final Logger LOGGER = LogManager.getLogger(VerifyCFONameStepDefinations.class);

	public static Logger getLogger() {
		return LOGGER;
	}

	@Given("User entering to login page in the browser")
	public void user_entering_to_login_page_in_the_browser() throws InterruptedException {
		try {
			
			String url = DriverManager.getDriver().getCurrentUrl();
			if (url.contains("dashboard")) {
				LOGGER.info("User entering to login page in the browser");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			//CommonUtils.screenshot();
			Assert.fail(e.getMessage());

		}
	}

	@When("User Clicks on directory option from menu bar")
	public void user_clicks_on_directory_option_from_menu_bar() throws InterruptedException {
		try {
			HomePage.getHomeInstance().clickDirectory();
			Thread.sleep(5000);
			LOGGER.info("User Clicks on directory option from menu bar");
		} catch (Exception e) {
			LOGGER.error(e);
			//CommonUtils.screenshot();
			Assert.fail(e.getMessage());

		}

	}

	@When("Select the job title as {string} from employeename")
	public void select_the_job_title_as_from_dropdown(String name) throws InterruptedException {
		try {
			
			DirectoryPage.getDirectoryInstance().clickHint(Constants.HINT);

			LOGGER.info("Select the job title as Ceo from Employeename");
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());

		}
	}

	@When("click the search button")
	public void click_the_search_button() throws InterruptedException {
		try {
			DirectoryPage.getDirectoryInstance().clickSearch();
			LOGGER.info("Click the search button");
			Thread.sleep(5000);
		} catch (Exception e) {
			LOGGER.error(e);
			//CommonUtils.screenshot();
			Assert.fail(e.getMessage());

		}
	}

	@Then("user should see the CFO name as {string}")
	public void user_should_see_the_ceo_name_as_peter_mac_anderson(String expectedName) {
		try {
			String actualName = DirectoryPage.getDirectoryInstance().getSearchedNameText();
			if (actualName.equalsIgnoreCase(expectedName)) {
				LOGGER.info("user should see the CFO name as John");
				
			}
		} catch (Exception e) {
			LOGGER.error(e);
			//CommonUtils.screenshot();
			Assert.fail(e.getMessage());

		}
	}

}
