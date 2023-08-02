package com.elbaih.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@SuppressWarnings("NewClassNamingConvention")
@CucumberOptions
        (
                features = "src/main/resources/features",
                glue = "com.elbaih.stepDefs",
                plugin = {
                        "pretty",
                        "html:target/cucumber.html",
                        "json:target/cucumber.json",
                        "junit:target/cucumber.xml",
                        "rerun:target/cucumber.txt",


                }


        )

public class Runners extends AbstractTestNGCucumberTests {
}
