package question1;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/java/question1/RegisterDemo.feature",
		glue={"question1"},
		monochrome=false,
		strict=true,
		dryRun=false
		//format={"pretty","html:test-output"}
		)



public class RegisterRunner {

}
