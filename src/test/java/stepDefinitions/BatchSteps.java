package stepDefinitions;

import java.util.List;
import org.testng.Assert;
import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.LoginPage;

public class BatchSteps {
	private TestContextSetup context;// pico
	private LoginPage loginPage;
	private BatchPage batchPage;
	
	public BatchSteps(TestContextSetup context) {
		this.context = context;
		this.loginPage = context.getLoginPage();
		this.batchPage = context.getBatchPage();
	}	
		
	}
