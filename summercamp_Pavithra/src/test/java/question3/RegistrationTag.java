package question3;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/java/question3",
		glue={"question3"},
		monochrome=false,
		strict=true,
		dryRun=false,
		tags={"@Test, @Test1, @Test2"}
		//format={"pretty","html:test-output"}
		)



public class RegistrationTag {

}
