package stepDefinitions;

import org.testng.Assert;
import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LogoutPage;
import utilities.LoggerLoad;

public class LogoutSteps {
	
	TestContextSetup context;
	private LogoutPage logoutPage;
	LoggerLoad loggerLoad;
	
	public LogoutSteps(TestContextSetup context) {
		this.context = context;
		//logoutPage = context.getLogoutPage();
	}
	}






