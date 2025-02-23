package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class LoginSteps {
	
	TestContextSetup context;
	private LoginPage loginPage;

	LoggerLoad loggerLoad;

	public LoginSteps(TestContextSetup context) {
		this.context = context;
		loginPage = context.getLoginPage();
	}

	@Given("The browser is open")
	public void the_browser_is_open() {
	    context.launchBrowser();
	    LoggerLoad.info("Admin launched the browser");
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
	 context.launchUrl();   
	 String currentUrl = context.getDriver().getCurrentUrl();
	}
	
	@Given("Admin logs into the application")
	public void admin_logs_into_the_application() {
			LoggerLoad.info("Trying to Login using valid details...");	
			context.launchBrowser();
			context.launchUrl();   
		// Fetch row of data from Excel based on the sheet and scenario
			Map<String, String> rowData = null;
			try {
				rowData = ExcelReader.getRowData("loginData", "validLogin");}
			catch (IOException e) {
				e.printStackTrace();}
			
			 if (rowData.isEmpty()) {
			        System.out.println("No data found for scenario: ");
			        return;}
			 
			 loginPage.assignValueAndLogin(rowData.get("username"), rowData.get("password"), rowData.get("role"));
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		String loginPageTitle = context.getDriver().getTitle();
		Assert.assertEquals(loginPageTitle, "LMS");
		System.out.println("Login page title is : " + loginPageTitle);
		LoggerLoad.info("Admin landed on the home page");
	}
	
	
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
	    context.getDriver().get(loginPage.invalid_url);
	}
	

	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() {
	   Assert.assertTrue(loginPage.invalidUrlmsg(), "Invalid URL is not displayed...");
	}
	
	@Then("Admin should see application name")
	public void admin_should_see_application_name() {
		String applicationName = "LMS - Learning Management System";
		Assert.assertTrue(loginPage.verifyImageText(applicationName));
	}
	
	
	@Then("Admin should verify the broken links")
	public void admin_should_verify_the_broken_links() {
	    boolean brokenLinks = loginPage.findBrokenLinks(loginPage.LoginPageLinks);
	    Assert.assertFalse(brokenLinks,"There are broken links in the page");
	}
	
	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
	    Assert.assertTrue(loginPage.verifyImageText("NumpyNinja"));
	}
	
	@Then("Admin should see Please login to LMS application text displayed")
	public void admin_should_see_please_login_to_lms_application_text_displayed() {
	    Assert.assertTrue(loginPage.verifyPleaseLogInToLMSTextDisplay(), "Please login to LMS application text is NOT displayed");
	    System.out.println("Please login to LMS application text is displayed");
	}
	
	@Then("Admin should see {int} text field")
	public void admin_should_see_text_field(Integer two) {
	    Assert.assertEquals(loginPage.countOfTextboxes(), 2, "There are more than 2 text fields in Login Page");
	}
	
	@Then("Admin should see {string} in the first text field")
	public void admin_should_see_in_the_first_text_field(String string) {
		  int position = loginPage.positionOfText("User");
		  Assert.assertEquals(position,1, "User is not the first text" );
	}
	
	@Then("Admin should see {string} in the second text field")
	public void admin_should_see_in_the_second_text_field(String text) {
		 int position = loginPage.positionOfText("Password");
	    Assert.assertEquals(position,2 ,"Password is not the second text");
	}
	
	@Then("Admin should see asterisk mark symbol next to User {string} text")
	public void admin_should_see_asterisk_mark_symbol_next_to_user_text(String string) {
		Assert.assertTrue(loginPage.asteriskMarkWithText("User"), "There is no asterisk mark symbol next to User text...");
	}
	
	@Then("Admin should see asterisk mark symbol next to password {string} text")
	public void admin_should_see_asterisk_mark_symbol_next_to_password_text(String string) {
		Assert.assertTrue(loginPage.asteriskMarkWithText("Password"), "There is no asterisk mark symbol next to Password text...");
	}
	
	@Then("Admin should see one dropdown")
	public void admin_should_see_one_dropdown() {
	    Assert.assertTrue(loginPage.roleDropdownVisibility(), "Role dropdown is NOT available....");
	}
	
	@Then("Admin should see Select The Role placeholder in dropdown")
	public void admin_should_see_select_the_role_placeholder_in_dropdown() {
	    Assert.assertTrue(loginPage.rolePlaceholderVisibility(),"Role dropdown placeholder is NOT available....");
	}
	
	@Then("Admin should see Admin Staff and Student options in dropdown")
	public void admin_should_see_admin_staff_and_student_options_in_dropdown() {
	    Assert.assertTrue(loginPage.checkAllRoleOptionsAvailability(),"All the Expected Roles are NOT Available....");
	}
	
	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	    Assert.assertTrue(loginPage.loginBtnVisibility(),"Login Button is NOT Visible....");
	}
	
	
	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
		try {
			loginPage.checkSpelling();
			} catch (Exception e) {
					e.printStackTrace();
			}
	}
	
	
	@When("Admin enter required data from login {string} for required {string} and clicks login button")
	public void admin_enter_required_data_from_login_for_required_and_clicks_login_button(String sheet, String scenario) {
		LoggerLoad.info("Trying to Login using "+scenario+" scenario");		
	// Fetch row of data from Excel based on the sheet and scenario
		Map<String, String> rowData = null;
		try {
			rowData = ExcelReader.getRowData(sheet, scenario);}
		catch (IOException e) {
			e.printStackTrace();}
		
		 if (rowData.isEmpty()) {
		        System.out.println("No data found for scenario: " + scenario);
		        return;}
		 
		 loginPage.assignValueAndLogin(rowData.get("username"), rowData.get("password"), rowData.get("role"));
	}
	
		
	@Then("Admin should get proper response on webpage based on {string}")
	public void admin_should_get_proper_response_on_webpage_based_on(String scenario) {
	    Assert.assertTrue(loginPage.loginResponse(scenario),"Login using "+scenario+" scenario failed....");
	    System.out.println("Login test using "+scenario+" scenario passed");
	}
	
	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
		loginPage.verifyUserFieldColor();
		Assert.assertEquals("#000000", loginPage.actualColor);
		LoggerLoad.info("The Hex value for gray color is #000000 : The text is in gray color");
	}

	
	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		loginPage.verifyPasswordFieldColor();
		Assert.assertEquals("#000000", loginPage.actualColor);
		LoggerLoad.info("The Hex value for gray color is #000000 : The text is in gray color");
	}
		
	
	@When("Admin enter required data from login {string} for required {string} and clicks login button with mouse")
	public void admin_enter_required_data_from_login_for_required_and_clicks_login_button_with_mouse(String sheet, String scenario) {
		LoggerLoad.info("Trying to Login by clicking Login button using Mouse...");		
		// Fetch row of data from Excel based on the sheet and scenario
			Map<String, String> rowData = null;
			try {
				rowData = ExcelReader.getRowData(sheet, scenario);}
			catch (IOException e) {
				e.printStackTrace();}
			
			 if (rowData.isEmpty()) {
			        System.out.println("No data found for scenario: " + scenario);
			        return;}
			 
			 loginPage.assignValue(rowData.get("username"), rowData.get("password"), rowData.get("role"));
			 loginPage.loginActionUsingMouse();
	}
	
	
	@When("Admin enter required data from login {string} for required {string} and clicks login button through keyboard")
	public void admin_enter_required_data_from_login_for_required_and_clicks_login_button_through_keyboard(String sheet, String scenario) throws InterruptedException {
		LoggerLoad.info("Trying to Login by clicking Login button using Mouse...");		
		// Fetch row of data from Excel based on the sheet and scenario
			Map<String, String> rowData = null;
			try {
				rowData = ExcelReader.getRowData(sheet, scenario);}
			catch (IOException e) {
				e.printStackTrace();}
			
			 if (rowData.isEmpty()) {
			        System.out.println("No data found for scenario: " + scenario);
			        return;}
			 
			 loginPage.loginActionUsingKeyboard(rowData.get("username"), rowData.get("password"), rowData.get("role"));
	}

	
	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
	    Assert.assertTrue(loginPage.dashboardLabelVisibility());
	}

	
	


}
