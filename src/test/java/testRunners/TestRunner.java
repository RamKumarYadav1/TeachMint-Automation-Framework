package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = ".//Features//GenerateCertificate.feature",
        glue = "stepDefinitions",   
        //tags = "@regression",
        plugin = {"pretty", "html:Test Reports/Latest Test Report"},
        monochrome = true,
        dryRun = false
)
public class TestRunner
{
	
}
