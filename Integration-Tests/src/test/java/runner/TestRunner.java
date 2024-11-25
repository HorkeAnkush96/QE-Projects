package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",  // Path to your feature files
        glue = "stepdefinations",  // Package where step definitions are located
        tags = "@SmokeTest",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},  // Plugins for reporting
        monochrome = true  // Makes the console output more readable
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
