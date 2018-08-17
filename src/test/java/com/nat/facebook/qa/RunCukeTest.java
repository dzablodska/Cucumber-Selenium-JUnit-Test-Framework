package com.nat.facebook.qa;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber" },
        glue = "com.nat.facebook.qa.step",
        features = "classpath:com/nat/facebook/qa/feature/newWorkplace/newWorkplace.feature"
)
public class RunCukeTest {
}
