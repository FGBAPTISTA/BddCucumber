package runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
				 glue = "steps",
				 tags = "@unitários",
				 plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
                 monochrome = true,
                 snippets = SnippetType.CAMELCASE,
                 dryRun = true,
                 strict = false)

public class RunnerTest {

}
