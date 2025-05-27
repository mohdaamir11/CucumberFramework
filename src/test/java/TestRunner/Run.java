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
	    plugin ={"pretty","junit:target//Cucumber-reports/reports/report_xml.xml"}
	)

// plugin ={"pretty","html:target//Cucumber-reports/reports/reports1.html"}
//plugin ={"pretty","json:target//Cucumber-reports/reports/report_json.json"}
//plugin ={"pretty","junit:target//Cucumber-reports/reports/report_xml.xml"}

public class Run {

	// this class will be empty  

}
