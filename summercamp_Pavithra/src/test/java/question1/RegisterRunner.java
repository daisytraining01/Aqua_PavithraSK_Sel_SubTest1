package question1;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/summercamp_Pavithra/src/test/java/question1/RegisterDemo.feature",
		glue={"/summercamp_Pavithra/src/test/java/question1/Register_StepDefinition.java"},
		monochrome=false,
		strict=true,
		dryRun=false
		//format={"pretty","html:test-output"}
		)



public class RegisterRunner {

}
