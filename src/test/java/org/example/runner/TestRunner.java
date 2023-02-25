package org.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "org.example.steps",
        features = "src/test/resources/features",
        monochrome = true
)
public class TestRunner {
}
