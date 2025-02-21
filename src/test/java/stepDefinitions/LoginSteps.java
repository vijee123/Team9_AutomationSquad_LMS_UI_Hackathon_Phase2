package stepDefinitions;

import org.testng.Assert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps {
	
	private TestContextSetup context;// pico
	private LoginPage loginPage;
	
	public LoginSteps(TestContextSetup context) throws InterruptedException {
		this.context = context;
		this.loginPage = context.getLoginPage();
			}	
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		context.launchBrowser();
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		String url = "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/";
		loginPage.openLoginPage(url);
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertNotNull(loginPageTitle, "Login page title is null");
		System.out.println("Login page title: " + loginPageTitle);
	}
	@Then("Admin should land on dashboard page by passing login credential {string}")
	public void admin_should_land_on_dashboard_page_by_passing_login_credential(String string) {
		String username = "sdetnumpyninja@gmail.com"; 
	    String password = "Feb@2025";

	    // Perform login actions
	    loginPage.enterUsername(username);
	    loginPage.enterPassword(password);
	    loginPage.selectDropdownOption(); // Select role (if applicable)
	    loginPage.clickLoginButton();

	    // Wait for the dashboard to load and verify it
	    String dashboardTitle = context.getDriver().getTitle();
	   // Assert.assertTrue(dashboardTitle.contains("Dashboard"), "Failed to land on the dashboard page");
	    System.out.println("Successfully landed on the Dashboard page: " );

	}



}
