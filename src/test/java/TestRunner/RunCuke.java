package TestRunner;

import cucumber.api.CucumberOptions;

@CucumberOptions(features= {"Features"},glue= {"StepDefinations"},

plugin= {"html:target/cucumber-reports/cucumber-html-report.html","json:target/cucumber-reports/cucumber.json",

"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class RunCuke extends cucumber.api.testng.AbstractTestNGCucumberTests

{

	
	
}
