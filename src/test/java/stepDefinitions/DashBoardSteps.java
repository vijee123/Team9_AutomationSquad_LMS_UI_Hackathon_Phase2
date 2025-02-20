package stepDefinitions;

import org.testng.Assert;
import driverSetup.TestContextSetup;
import io.cucumber.java.en.Then;
import pageObjects.DashboardPage;
import utilities.LoggerLoad;

public class DashBoardSteps {
	
	TestContextSetup context;
	private DashboardPage dashboardPage;
	LoggerLoad loggerLoad;
	
	public DashBoardSteps(TestContextSetup context) {
		this.context = context;
		dashboardPage = context.getDashboardPage();
	}

}
