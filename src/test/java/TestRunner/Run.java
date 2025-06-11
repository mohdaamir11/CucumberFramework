package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;  // for running with Testng
import io.cucumber.testng.CucumberOptions;           // for running with Testng

//import io.cucumber.junit.Cucumber;               // for running with junit
//import io.cucumber.junit.CucumberOptions;         // for running with junit

//@RunWith(Cucumber.class)            // for running with junit
@CucumberOptions(
	    features = {"Features/LoginFeature.feature"},
	    glue = {"StepDefination"},
	    dryRun = false,
	    monochrome = true,
	    tags = "@sanity", // to execute only sanity tagged 
	    plugin ={"pretty","html:target//Cucumber-reports/reports/reports1.html"}
	)

// plugin ={"pretty","html:target//Cucumber-reports/reports/reports1.html"}
//plugin ={"pretty","json:target//Cucumber-reports/reports/report_json.json"}
//plugin ={"pretty","junit:target//Cucumber-reports/reports/report_xml.xml"}

public class Run extends AbstractTestNGCucumberTests {

	// this class will be empty  

}
