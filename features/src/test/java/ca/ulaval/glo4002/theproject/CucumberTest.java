package ca.ulaval.glo4002.theproject;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
        features = {"src/test/resources"},
        format = {"junit:target/cucumber/junit.xml"})
public class CucumberTest {
}
