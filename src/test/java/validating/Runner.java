package feature;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/validating/Login.feature"},
        glue = {"feature"},tags= "@run",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true, publish = true)

public class Runner extends AbstractTestNGCucumberTests {

}