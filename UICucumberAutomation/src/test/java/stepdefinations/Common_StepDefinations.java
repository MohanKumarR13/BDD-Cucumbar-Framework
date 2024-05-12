package stepdefinations;

import java.io.File;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import constants.Constants;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjectmodel.LoginPage;
import utilities.CommonUtils;
import webdriver.manager.DriverManager;

public class Common_StepDefinations {
	public static WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(Common_StepDefinations.class);
	private static String scenarioName=null;
	public static String getScenarioName() {
		return scenarioName;
	}
	@Before
	public void before(Scenario scenario) {
		try {
			scenarioName=scenario.getName();
			CommonUtils.getcommonUtilsInstance().loadProperties();
			LOGGER.info("Driver is null or not");

			if (DriverManager.getDriver() == null) {
				LOGGER.info("Driver is null Instantiating..");
				DriverManager.launchBrowser();
				CommonUtils.getcommonUtilsInstance().initElements();
				login();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void login() throws InterruptedException {
		DriverManager.getDriver().get(Constants.URL);
		LoginPage.getInstance();
		Thread.sleep(5000);
		LoginPage.getInstance().enterUserName(Constants.UserName);
		LoginPage.getInstance().enterPassword(Constants.Password);
		LoginPage.getInstance().clickLoginButton();
		Thread.sleep(7000);
		
	}
	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte []screenshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotTaken, "image/png", "error screen");
			

		}
	}

}
