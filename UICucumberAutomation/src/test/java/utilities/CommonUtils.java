package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import pageobjectmodel.DirectoryPage;
import pageobjectmodel.HomePage;
import pageobjectmodel.LoginPage;
import pageobjectmodel.TimeSheetPage;
import stepdefinations.Common_StepDefinations;
import webdriver.manager.DriverManager;

public class CommonUtils {
	private static final Logger LOGGER = LogManager.getLogger(CommonUtils.class);

	private static CommonUtils commonUtilsInstance = null;

	private CommonUtils() {

	}

	public static CommonUtils getcommonUtilsInstance() {
		if (commonUtilsInstance == null) {
			commonUtilsInstance = new CommonUtils();
		}
		return commonUtilsInstance;
	}

	public void loadProperties() {
		/*
		 * FileReader fileReader = null; try { fileReader = new
		 * FileReader("config.properties"); } catch (FileNotFoundException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Constants.URL = properties.getProperty("URL");
		Constants.BROWSER = properties.getProperty("BROWSER");
		Constants.UserName = properties.getProperty("UserName");
		Constants.Password = properties.getProperty("Password");
		Constants.EDGEDRIVER = properties.getProperty("EDGEDRIVER");
		Constants.EDGE_DRIVER = properties.getProperty("EDGE_DRIVER");
		Constants.HINT = properties.getProperty("HINT");

	}

	public void initElements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getHomeInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getDirectoryInstance());
		PageFactory.initElements(DriverManager.getDriver(), TimeSheetPage.gettimeInstance());

	}

	public static void screenshot() {
		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(Common_StepDefinations.getScenarioName() + ".png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void highlightElements(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", element);
	}

	public void selectFromDropdown(WebElement dropDown, String howTo, String value) {
		Select select = new Select(dropDown);
		switch (howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;

		case "value":
			select.selectByValue(value);
			break;

		case "text":
			select.selectByVisibleText(value);
			break;

		default:
			LOGGER.info("Please provide valid seleections are: text,value,index");
			break;
		}
	}
}
