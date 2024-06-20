package com.example.PlaywrightJavaTask;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.example.PlaywrightJavaTask.steps",
    plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
    monochrome = true
)
public class TestRunner {
}