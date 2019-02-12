package org.gulhe.pandemic;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:Personae.feature"},
        plugin = {"pretty"})
public class Runner {
}
