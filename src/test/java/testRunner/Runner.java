package testRunner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driverSetup.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/",
    glue = "stepDefinitions",
    plugin = {
        "pretty", 
        "html:target/cucumber.html", 
        "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "rerun:target/failed_scenarios.txt"
    },
    monochrome = false, 
    dryRun = false
    //tags="@classsenario"
)
public class Runner extends AbstractTestNGCucumberTests {
    
    private static ThreadLocal<String> browser = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browserName) {
        browser.set(browserName); // Set the browser dynamically
        BaseClass.setBrowser(browserName); // Set browser in BaseClass
        BaseClass.initializeDriver(); // Initialize WebDriver
    }

    @AfterMethod
    public void tearDown() {
        BaseClass.quitDriver(); // Quit WebDriver after test execution
    }

    @Override
    @DataProvider(parallel = true) // Enable parallel execution
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
