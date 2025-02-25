package testRunner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import driverSetup.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
			features = { "src/test/resources/features/01Login.feature","src/test/resources/features/02Dashboard.feature","src/test/resources/features/04Batch.feature","src/test/resources/features/05Class.feature","src/test/resources/features/06Logout.feature" },
			glue = "stepDefinitions",
			plugin = { "html:target/cucumber.html", "json:target/cucumber.json",
				    	//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					    //"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
						"rerun:target/failed_scenarios.txt" },
			monochrome = false, 
			//tags = "@Login", 
			dryRun = false 
			   
			)
			
	public class Runner extends AbstractTestNGCucumberTests {
		
		@Override
		@DataProvider(parallel = false)
		public Object[][] scenarios() {
			return super.scenarios();
		}
	}


