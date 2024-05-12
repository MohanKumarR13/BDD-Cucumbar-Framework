package webdriver.manager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static WebDriver driver = null;
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);

	public static void launchBrowser() {
		try {
			switch (Constants.BROWSER) {
			case "edge":
				WebDriverManager.edgedriver().setup();
				LOGGER.info("Launch Browser");
				driver=new EdgeDriver();
				
				getDriver().manage().window().maximize();
				break;

			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		DriverManager.driver = driver;
	}
}
