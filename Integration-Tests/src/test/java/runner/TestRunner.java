package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\resources\\features\\Test.feature", 
glue = "stepdefinations", tags = "@TestDemo")
public class TestRunner extends AbstractTestNGCucumberTests {

}
