package driverSetup;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utilities.LoggerLoad;

public class Hooks {
    private BaseClass baseClass = BaseClass.getInstance();

    @Before
    public void setUp(Scenario scenario) {
        LoggerLoad.info("Starting scenario: " + scenario.getName());
    }

    @After
    public void tearDown() {
        LoggerLoad.info("Closing WebDriver...");
        baseClass.quitDriver();
    }
}
