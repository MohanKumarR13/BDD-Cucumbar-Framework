package stepdefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.HomePage;
import pageobjectmodel.TimeSheetPage;
import utilities.CommonUtils;
import webdriver.manager.DriverManager;

public class VerifyTimesheetStepDefinations {
	private static final Logger LOGGER = LogManager.getLogger(VerifyTimesheetStepDefinations.class);

	@Given("User on homepage")
	public void user_on_homepage() {
		try {
			String url = DriverManager.getDriver().getCurrentUrl();
			if (url.contains("dashboard")) {
				LOGGER.info("User on homepage");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			//CommonUtils.screenshot();
			Assert.fail(e.getMessage());

		}
	}

	@When("User Clicks on the time option from menu")
	public void user_clicks_on_the_time_option_from_menu() {
		try {
			HomePage.getHomeInstance().clickTime();
			LOGGER.info("User Clicks on the time option from menu");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			//CommonUtils.screenshot();
			Assert.fail(e.getMessage());

		}

	}

	@When("User enters name as {string}")
	public void user_enters_name_as(String name) throws Exception {
		try {
			TimeSheetPage.gettimeInstance().enterEmployeeName(name);
			LOGGER.info("User Enters a Name");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			CommonUtils.screenshot();
			Assert.fail(e.getMessage());

		}
	}

	@When("click the view button")
	public void click_the_view_button() {
		try {
			TimeSheetPage.gettimeInstance().clickView();
			LOGGER.info("Click the view button");
			Thread.sleep(5000);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			//CommonUtils.screenshot();
			Assert.fail(e.getMessage());

		}

	}

	@Then("user should see the message as {string}")
	public void user_should_see_the_message_as_no_timesheets_found(String expectedName) {
		try {
			String actualName = TimeSheetPage.gettimeInstance().messageView();
			if (actualName.equalsIgnoreCase(expectedName)) {
				LOGGER.info("User should see the message as Records Found message");
				DriverManager.getDriver().quit();
			}
		} catch (Exception e) {
			LOGGER.error(e);
			//CommonUtils.screenshot();
			Assert.fail(e.getMessage());

		}
	}

}
