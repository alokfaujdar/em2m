package com.em2m.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
//              "src/test/resources/features/A_LoginPage.feature",
//              "src/test/resources/features/B_HomePage.feature",
//              "src/test/resources/features/C_OrganizationPage.feature",
              "src/test/resources/features/E_VehiclesPage.feature"

        },
        publish = true,
        plugin = {
                "pretty",
                "html:target/html/htmlcucumber-htmlreport.html",
                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "junit:target/cucumber-results.xml"
        },
    monochrome = true,
    glue = {"com/em2m/automation/stepDefinition"},
    dryRun = false
)

public class RunAllTest {
}
