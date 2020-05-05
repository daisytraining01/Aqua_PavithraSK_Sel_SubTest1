package question3;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/summercamp_Pavithra/src/test/java/question3",
		glue={"/summercamp_Pavithra/src/test/java/question3/RegistrationTagStepDef.java"},
		monochrome=false,
		strict=true,
		dryRun=false,
		tags={"@Test, @Test1, @Test2"}
		//format={"pretty","html:test-output"}
		)



public class RegistrationTag {

}
