package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = {"stepDefenition"},
		junit = "--step-notifications",
		tags = {"@Facebook"}
		)
public class TestRunner_1 {
	

}
