package stepDefinitions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Then;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.LoggerLoad;

public class DashBoardSteps {
	
	TestContextSetup context;
	private DashboardPage dashboardPage;
	private LoginPage loginPage;
	LoggerLoad loggerLoad;
	
	public DashBoardSteps(TestContextSetup context) {
		this.context = context;
		dashboardPage = context.getDashboardPage();
		loginPage = context.getLoginPage();
		
	}
	
	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
	    loggerLoad.info("Verify the display of LMS title at dashboard page......");
	    Assert.assertTrue(dashboardPage.LMStitleDisplay(),"LMS title is NOT displayed at dashboard page");
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		 loggerLoad.info("Verify whether the display of LMS title is on Top Left Corner at dashboard page......");
		 Assert.assertTrue(dashboardPage.isLMSTitleOnTopLeftCorner(),"LMS title is NOT located at TOP LEFT CORNER at dashboard page...");
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
		 loggerLoad.info("Verify the texts in Navigation bar has correct spelling......");
		 Assert.assertTrue(dashboardPage.LMSMainBarTextSpellingCheck(),"No spelling mistakes found.");

	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		 loggerLoad.info("Verify the Spelling and Space in LMS Title......");
		 SoftAssert sa = new SoftAssert();
		 sa.assertEquals(dashboardPage.checkLMSTitleSpace(),4,"Number of spaces in LMS Title is incorrect...");
		 sa.assertTrue(dashboardPage.checkLMSTitleSpelling(),"LMS title has spelling mistakes....");
		 sa.assertAll();
		 
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		 loggerLoad.info("Verify whether the navigation menu bar is located on the top right side......");
		 Assert.assertTrue(dashboardPage.navigationBarAlignmentCheck(),"The navigation menu bar is NOT located on the right end...");
	}
	
	
	@Then("Admin should see menu bar items in the following sequence of HOME PROGRAM BATCH CLASS and LOGOUT")
	public void admin_should_see_menu_bar_items_in_the_following_sequence_of_home_program_batch_class_and_logout() {
		 loggerLoad.info("Verify whether the navigation menu bar item sequence......");
		 Assert.assertTrue(dashboardPage.navigationMenuItemsSequenceValidation(),"Menu bar items are NOT in the proper sequence....");
	}

	
	@Then("Admin should see piechart")
	public void admin_should_see_piechart() {
		loggerLoad.info("Verify whether the PIE chart is visible in the dashboard page ......");
		Assert.assertTrue(dashboardPage.pieChartVisibility(),"The PIE chart is not displayed...");
	    
	}

	@Then("Admin should see welcome message with user name and role")
	public void admin_should_see_welcome_message_with_user_name_and_role() {
		loggerLoad.info("Verify Username and Role displayed in the Welcome message of dashboard page......");
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(dashboardPage.userNameDisplayVerification(context.getPropUsername()));
		sa.assertTrue(dashboardPage.roleDisplayVerification(context.getPropRole()));
		sa.assertAll();
	}
	
	
	@Then("Admin should see previous page icon disabled")
	public void admin_should_see_previous_page_icon_disabled() {
		loggerLoad.info("Verify whether the Previous page Icon of Staff Data is Disabled in the dashboard page ......");
		Assert.assertTrue(dashboardPage.prevPageIconDisabled(),"Previous page Icon of Staff Data is NOT Disabled...");
	}

	@Then("Admin should see first page icon disabled")
	public void admin_should_see_first_page_icon_disabled() {
		loggerLoad.info("Verify whether the First Page Icon is DISABLED at Dashboard Page......");
	    Assert.assertTrue(dashboardPage.firstPageIconDisabled(),"First Page Icon is NOT displayed at Dashboard Page....");
	}
	

	@Then("Admin should see bar chart for Active and inactive user")
	public void admin_should_see_bar_chart_for_active_and_inactive_user() {
		loggerLoad.info("Verify whether the BAR chart of Active and Inactive User is visible in the dashboard page ......");
		Assert.assertTrue(dashboardPage.barChartVisibility(),"The BAR chart is not displayed in the dashboard page...");
	}

	@Then("Admin should see staff table with pagination icons")
	public void admin_should_see_staff_table_with_pagination_icons() {
		loggerLoad.info("Verify whether the admin can see staff table pagination icons at Dashboard Page......");
		Assert.assertTrue(dashboardPage.verifyStaffTablePageIconsDisplay(),"Page icons is missing at dashboard Staff Table....");
	}
	
	
	@Then("Admin should see {int} staff data in a page")
	public void admin_should_see_staff_data_in_a_page(Integer int1) {
		loggerLoad.info("Verify whether the number of Staff displayed in staff table at Dashboard Page......");
		Assert.assertTrue(dashboardPage.fiveStaffDisplayVerification(),"Number of Staff displayed at Staff table is not 5...");
	}
	
	@Then("Admin should see user count including active and inactive")
	public void admin_should_see_user_count_including_active_and_inactive() {
		loggerLoad.info("Verify whether the user count displayed at Dashboard Page......");
		Assert.assertTrue(dashboardPage.userCountVisibility(),"User Count is not displayed at dashboard page...");
	}

	@Then("Admin should see staff count including Active and inactive")
	public void admin_should_see_staff_count_including_active_and_inactive() {
		loggerLoad.info("Verify whether the staff count displayed at Dashboard Page......");
		Assert.assertTrue(dashboardPage.staffCountVisibility(),"Staff Count is not displayed at dashboard page...");
	}

	@Then("Admin should see Program count including Active and inactive")
	public void admin_should_see_program_count_including_active_and_inactive() {
		loggerLoad.info("Verify whether the program count displayed at Dashboard Page......");
		Assert.assertTrue(dashboardPage.programCountVisibility(),"Program Count is not displayed at dashboard page...");
	}

	@Then("Admin should see batch count including Active and inactive")
	public void admin_should_see_batch_count_including_active_and_inactive() {
		loggerLoad.info("Verify whether the batch count displayed at Dashboard Page......");
		Assert.assertTrue(dashboardPage.batchCountVisibility(),"Batch Count is not displayed at dashboard page...");
	}

	
	
}
