package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features="src/test/java/features",glue= {"stepDefinitions"},plugin="json:target/jsonReports/cucumber-report.json")

@CucumberOptions(features="src/test/java/features",
glue= {"stepDefinitions"},
plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, monochrome = true)
//@CucumberOptions(features="src/test/java/features",glue= {"stepDefinitions"},tags= "@DeletePlace")
public class TestRunner {

}
