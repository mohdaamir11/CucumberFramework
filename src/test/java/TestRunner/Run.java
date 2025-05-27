package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "Features",
	    glue = {"StepDefination"},
	    dryRun = false,
	    monochrome = true,
	    plugin ={"pretty","html:target//Cucumber-reports/reports/reports1.html"}
	)

//@CucumberOptions(
//		    features = "Features", // update if different
////		features = ".//Features/LoginFeature.feature",
//				glue = {"/CucumberFramework/src/test/java/StepDefination"},  // update if different
////		glue = "/CucumberFramework/src/test/java/StepDefination" ,  // update if different
//        dryRun = false,
//        monochrome = true,
//        plugin = "pretty")

public class Run {

	// this class will be empty  

}
