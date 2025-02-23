package testRunner;


import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	@CucumberOptions(
			features = "src/test/resources/features/01Login.feature",
			glue = "stepDefinitions",
			plugin = { "html:target/cucumber.html", "json:target/cucumber.json",
				    	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
						"rerun:target/failed_scenarios.txt" },
			monochrome = false, 
			tags = "@Login", 
			dryRun = !true 
			)
			
	public class Runner extends AbstractTestNGCucumberTests {
		@Override
		@DataProvider(parallel = false)
		public Object[][] scenarios() {
			return super.scenarios();
		}
	}


