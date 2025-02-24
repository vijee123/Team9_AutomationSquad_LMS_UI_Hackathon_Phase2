package stepDefinitions;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class LogoutSteps {
	
	TestContextSetup context;
	private LogoutPage logoutPage;
	private LoginPage loginPage;
	LoggerLoad loggerLoad;
	
	public LogoutSteps(TestContextSetup context) {
		this.context = context;
		logoutPage = context.getLogoutPage();
		loginPage = context.getLoginPage();
	}
	
	
	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
		LoggerLoad.info("Click Logout Button...");	
		logoutPage.clickLogout();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		LoggerLoad.info("Check whether we reach Login page after logout...");	
		Assert.assertTrue(logoutPage.reachedLoginPage(),"Logout is Unsuccessful..........");
	}

	
	@Given("Admin is logged out of the application")
	public void admin_is_logged_out_of_the_application() {
		LoggerLoad.info("Trying to Login using valid details...");	
		context.launchBrowser();
		context.launchUrl();   
		Map<String, String> rowData = null;
		try {
			rowData = ExcelReader.getRowData("loginData", "validLogin");}
		catch (IOException e) {
			e.printStackTrace();}
		
		 if (rowData.isEmpty()) {
		        System.out.println("No data found for scenario: ");
		        return;}
		 
		 loginPage.assignValueAndLogin(rowData.get("username"), rowData.get("password"), rowData.get("role"));
		 logoutPage.clickLogout();
		 
	}

	@When("Admin clicks browser back button")
	public void admin_clicks_browser_back_button() {
		LoggerLoad.info("Admin clicks browser back button...");	
		loginPage.clickBrowserBack();
		
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
		LoggerLoad.info("Check the error message received on clicking browser back button after logout...");	
		Assert.assertTrue(false);
	}

	
	
	
}






