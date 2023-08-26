package runners; 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

 @CucumberOptions(
		 plugin = {"pretty","html:target/cucumber.html","summary"},
		 snippets = CAMELCASE,
		 dryRun = true,
		 glue = "stepDefinitions",
		 features = "src/test/resources/feature"
		 )
 public class TestNGRunnerTest extends AbstractTestNGCucumberTests{  
 }