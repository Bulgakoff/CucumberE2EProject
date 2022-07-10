package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/featureFolder",
        glue ="stepDefinitionsFolder"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
