package mini.bdd.login.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/resources/feature",
				glue="mini/bdd/login/stepdef"
		)
public class TestRunnerClass extends AbstractTestNGCucumberTests {
		
	
}
