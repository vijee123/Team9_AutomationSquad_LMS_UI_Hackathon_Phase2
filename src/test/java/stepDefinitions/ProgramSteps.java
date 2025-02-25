package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProgramPage;

public class ProgramSteps {
	
	private TestContextSetup context;// pico
	private LoginPage loginPage;
	private ProgramPage programPage;
	private String nameCheck;
	
	public ProgramSteps(TestContextSetup context) throws InterruptedException {
		this.context = context;
		//this.programPage = context.getProgramPage();
		this.loginPage = context.getLoginPage();
	}
}