package com.clarolab;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "json:target/surefire-reports/cucumber-report.json", "json:allure-results/cucumber-result.json"})

public class RunTest {
}