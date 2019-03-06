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
@CucumberOptions(features = "src/test/resources/features/realizar_compra.feature",
                 monochrome = true,
                 snippets = SnippetType.CAMELCASE,
                 dryRun = false,
            	 glue = "steps",
                 strict = false)
public class RunnerFuncionalTest {
	
	//@BeforeClass
	
	public static void reset() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fabiob\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://srbarriga.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("a@a");
		driver.findElement(By.id("senha")).sendKeys("a");
		driver.findElement(By.tagName("button")).click();	
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
}
