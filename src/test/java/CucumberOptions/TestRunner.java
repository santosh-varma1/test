package CucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import resources.Base;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue ="stepDefinitions"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
