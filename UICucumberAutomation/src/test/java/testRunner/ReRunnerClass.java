package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "@target/failedCase.txt" }, glue = { "stepdefinations"
		 }, dryRun = false, monochrome = true, plugin = { "pretty", "html:test-output/Cucumber.html",
				"json:test-output/jsonreport.json",
				"junit:test-output/xmlreport.xml" }/*,tags = ("@Background")*/ )
public class ReRunnerClass {

}
