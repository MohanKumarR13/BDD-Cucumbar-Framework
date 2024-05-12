package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { ".//Features/" }, glue = {
		"stepdefinations" }, dryRun = false, monochrome = true, plugin = { "pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
// "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" ,
}, publish = true)

/* "pretty", "html:test-output/Cucumber.html" */
/*
 *
 */public class RunnerClass {

}
