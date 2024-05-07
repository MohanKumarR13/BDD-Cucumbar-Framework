package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(features="D:\\Workplace_\\Cucumber_Selenium\\featurefile\\OpenHRM.feature",glue="stepdefination")
public class TestRunnerClass {

}
