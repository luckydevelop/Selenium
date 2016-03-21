package stepsDefinition;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features"
        ,glue={"tests"}
        ,format = {"pretty", "html:target/cucumber-htmlreport"
        ,"json:target/cukes/report.json"
        , "junit:target/cukes/junit.xml"})


public class TestRunner {

}

