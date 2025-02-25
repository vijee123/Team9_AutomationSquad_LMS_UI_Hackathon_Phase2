package driverSetup;

import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utilities.LoggerLoad;

public class Hooks {
	
	private TestContextSetup context;
    public Hooks(TestContextSetup context) {
        this.context = context;
    }
    @Before
    public void setUp(Scenario scenario) {
        LoggerLoad.info("Starting scenario: " + scenario.getName());
        BaseClass.initializeDriver(); // Initialize driver in a thread-safe manner
    }
    @After
    public void tearDown() {
        LoggerLoad.info("Closing WebDriver...");
        BaseClass.quitDriver(); // Ensure driver is quit properly for parallel tests
    }
    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            LoggerLoad.error("Step Failed, Taking Screenshot");
            final byte[] screenshot = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
    }
}






