package testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true, features = {
		"src/test/java/featurefile/OpenHRM.feature" }, glue = { "stepDefinations" },plugin = {"pretty","html:test.output"})
public class TestRunnerClass  {

	/*
	 * @BeforeClass public void beforeAll() {
	 * 
	 * }
	 * 
	 * @AfterClass public void afterAll() {
	 * 
	 * }
	 */
}
