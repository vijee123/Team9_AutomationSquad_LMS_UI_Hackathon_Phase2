package testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import driverSetup.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "stepDefinitions", tags = "@login", plugin = {
		"pretty", "html:target/cucumber-report.html" })
public class Runner extends AbstractTestNGCucumberTests {
	private static ThreadLocal<String> browser = new ThreadLocal<>();
	private BaseClass base = BaseClass.getInstance();

	@Parameters("browser")
	@BeforeMethod
	public void setup(@Optional("chrome") String browserName) {

		browser.set(browserName); // Set the browser dynamically
		base.setBrowser(browserName); // Pass browser name to BaseClass
		base.initializeDriver(); // Initialize WebDriver

	}

	@AfterMethod
	public void tearDown() {
		base.quitDriver(); // Quit WebDriver after test execution
	}
}