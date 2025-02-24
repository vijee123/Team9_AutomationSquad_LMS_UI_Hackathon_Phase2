package driverSetup;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

//import utilities.AddExcelReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;
//import utilities.applicationData;
import utilities.LMSUIConstants;

public class Hooks {
    private BaseClass baseClass = BaseClass.getInstance();
//    @BeforeAll
//	public static void before_all() {
//		applicationData appData = new applicationData();
//		TestContextSetup.getInstance();
//		appData.setModuleNameTestDataMap(AddExcelReader.loadExcelData());
//		applicationData applicationData1 = appData;
//	}
//
//   
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
