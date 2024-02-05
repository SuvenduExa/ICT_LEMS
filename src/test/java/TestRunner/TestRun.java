package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features=".//Features",
				
glue="StepDefinations",
dryRun=false,
monochrome=true,
/*plugin= {"pretty",
		"html:test-output"},*/
plugin= {"pretty",

        "html:test-output","json:target/cucumber.json"},
tags= {}
)
public class TestRun {

}