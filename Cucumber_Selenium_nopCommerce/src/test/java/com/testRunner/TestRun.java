package com.testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,features = {".//Features/Customers.feature",".//Features/Logins.feature"}, glue = {"stepDefinations"}, dryRun = false
,plugin = {"pretty","html:test-output/cucumberNopCommerce.html"}
)

public class TestRun {

}
