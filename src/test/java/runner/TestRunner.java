package runner;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = {""},
        glue = {"steps"},
        plugin = {"json:target/reports/CucumberReport.json",
                "pretty"
        },
        //strict = true,dryRun = true
        monochrome = true)
public class TestRunner {
}
