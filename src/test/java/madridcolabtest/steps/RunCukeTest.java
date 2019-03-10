package madridcolabtest.steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/resources/madridcolabtest/features",
		glue = {"madridcolabtest.steps"},
		tags = {"@votingSystem"},
		plugin = {
				"pretty",
				"html:target/cucumber",
		}
		
		)
public class RunCukeTest{
	

}
