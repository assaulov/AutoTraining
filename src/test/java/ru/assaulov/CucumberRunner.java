package ru.assaulov;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "pretty", "json:target/cucumber-report/report.json"},
        features = "src/test/java/ru/assaulov/features",
        glue = "ru.assaulov.stepdefs"
)
public class CucumberRunner {
}
