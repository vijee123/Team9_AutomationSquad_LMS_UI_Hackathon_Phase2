package stepDefinitions;

import java.util.List;
import org.testng.Assert;
import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.ClassPage;
import pageObjects.LoginPage;

public class ClassSteps {
	private TestContextSetup context;// pico
    private LoginPage loginPage;
    private ClassPage classPage;
    public ClassSteps(TestContextSetup context) throws InterruptedException {
        this.context = context;
        this.classPage = context.getClassPage();
        this.loginPage = context.getLoginPage();
    }
}
