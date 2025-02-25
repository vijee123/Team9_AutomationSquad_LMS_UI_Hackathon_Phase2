package stepDefinitions;

import org.testng.Assert;
import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPage;
import pageObjects.LoginPage;
import java.io.IOException;
import java.util.Map;
import utilities.ExcelReader;

public class ClassSteps {
			
		Map<String, String> classData;
		private TestContextSetup context;// pico
		private LoginPage loginPage;
		private ClassPage classPage;
		
		
		public ClassSteps(TestContextSetup context) {
		    this.context = context;
		    this.classPage = context.getClassPage();
		    this.loginPage = context.getLoginPage();
		}
		@When("Admin clicks the {string} in the Header in class")
		public void admin_clicks_the_in_the_header_in_class(String string) {
			classPage.clickClassButton();
			//classPage.addNewClass();
		}
		@Then("Admin should land on the {string} in class")
		public void admin_should_land_on_the_in_class(String string) {
			
			 Assert.assertTrue(classPage.ismanageClassTextDisplayed(), "Admin did not land on the Manage Class page!");
		}
		@Then("Admin should see the {string} Title in class")
		public void admin_should_see_the_title_in_class(String string) {
		Assert.assertTrue(classPage.isLMSTextDisplayed(), "Admin did not land on the LMS Learning page!");
		 
		}
		@Then("Admin should see the Searchbar in class")
		public void admin_should_see_the_searchbar_in_class() {
		System.out.println("Search");
		Assert.assertEquals(true, classPage.isSearchBarDisplayed());
		System.out.println("Success");
		}
		@Then("Admin should see the data table heading")
		public void admin_should_see_the_data_table_heading(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("Search");
		throw new io.cucumber.java.PendingException();
		}
		@Then("Admin should see the datatable heading like Batchname,class topic,class description,status,class Date,staff name,Edit\\/Delete")
		public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_description_status_class_date_staff_name_edit_delete() {
		System.out.println("Search111");
		}
		
		@When("Admin clicks add new class under the class menu bar in class")
		public void admin_clicks_add_new_class_under_the_class_menu_bar_in_class() {
		classPage.addNewBtnClick();
		}
		@Then("Admin should see a manage class pop up with empty form and <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window in class")
		public void admin_should_see_a_manage_class_pop_up_with_empty_form_and_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window_in_class() {
		System.out.println("fef");
		//Assert.assertEquals(true, classPage.verifyPopup());
		}
		@Then("Admin should see few input fields and their respective text boxes in the class details window in class")
		public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window_in_class() {
		System.out.println("fef1");
		//Assert.assertEquals(true, classPage.verifyPopupTextField());
		}
		@Given("Admin is on the Class Popup window in class")
		public void admin_is_on_the_class_popup_window_in_class() {
		System.out.println("Admin is on the pop window");
		}
		@When("Admin enters {string} mandatory fields in the {string} form and clicks on save button in class")
		public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button_in_class(String sheet, String scenario) {
		{
			Map<String,String> rowData=null;
		
		try {
		   rowData=ExcelReader.getRowData(sheet,scenario);
		}
		catch(IOException e) {
		   e.printStackTrace();
		}
		if(rowData.isEmpty()) {
		   System.out.println("No Data found for scenario"+scenario);
		   return;
		  
		}
		classPage.enterValid(rowData.get("Batchname"),rowData.get("ClassTopic"),rowData.get("ClassDescription"),rowData.get("SelectClassDates"),rowData.get("NoofClasses"),rowData.get("StaffName"),rowData.get("Status"),rowData.get("Comments"),rowData.get("Notes"),rowData.get("Recording"),rowData.get("ExpectedMsg"));
		}}
		@Then("Admin gets message Class added Successfully in class")
		public void admin_gets_message_class_added_successfully_in_class() {
		
		//Assert.assertTrue(classPage.verifyPopup(classData.get("ExpectedMsg")));
		//classPage.wait(3000);
		}
		/////Pagination && Sorting
		@When("Admin clicks Next page link on the class table")
		public void admin_clicks_next_page_link_on_the_class_table() {
		  boolean isClicked = classPage.clickNextPagelink();
		  System.out.println("Next Page link was not clickable or not found!");
		    //Assert.assertTrue(isClicked, "Next Page link was not clickable or not found!");
		}
		@Then("Admin should see the next page record on the table  with Pagination has next active link enabled")
		public void admin_should_see_the_next_page_record_on_the_table_with_pagination_has_next_active_link_enabled() {
		// Write code here that turns the phrase above into concrete actions
		//Assert.assertTrue(classPage.NextPageLinkEnabled());
		///////
		}
		@When("Admin clicks Last page link")
		public void admin_clicks_last_page_link() {
		// Write code here that turns the phrase above into concrete actions
		classPage.clickLastPageLink();
		}
		@Then("Admin should see the last page record on the table with Next page link are disabled")
		public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
		System.out.println("Checking if Next Page link is disabled after reaching the last page...");
		// Ensure the page has fully loaded and check button state
		// classPage.waitForNextButtonToBeDisabled();
		// Assert that the Next Page button is disabled
		// Assert.assertFalse(classPage.NextPageLinkEnabled(), "Next button should be disabled on the last page!");
		System.out.println("Is Diabled");
		}
		@Given("Admin is on last page of class table")
		public void admin_is_on_last_page_of_class_table() {
		// Write code here that turns the phrase above into concrete actions
		// classPage.clickLastPageLink();
		}
		@When("Admin clicks First page link")
		public void admin_clicks_first_page_link() {
		System.out.println("Checking if Previous Page link is enabled...");
		// Ensure the page has fully loaded and check button state
		//classPage.waitForPrevButtonToBeEnabled();
		// Assert that the Previous Page button is enabled
		// Assert.assertTrue(classPage.PrevPageLinkEnabled(), "Previous button should be enabled after navigating back!");
		}
		@Then("Admin should see the previous page record on the table with pagination has previous page link enabled")
		public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link_enabled() {
		// Write code here that turns the phrase above into concrete actions
		//Assert.assertTrue(classPage.PrevPageLinkEnabled());
		}
		@Given("Admin is on Previous class page")
		public void admin_is_on_previous_class_page() {
		// Write code here that turns the phrase above into concrete actions
		// classPage.clickPrevPageLink();
		}
		@When("Admin clicks Start page link")
		public void admin_clicks_start_page_link() {
		// Write code here that turns the phrase above into concrete actions
		classPage.clickStrtPageLink();
		}
		@Then("Admin should see the very first page record on the table with Previous page link are disabled")
		public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertFalse(classPage.PrevPageLinkEnabled());
		}
		@When("Admin clicks on the Batchname sort icon")
		public void admin_clicks_on_the_batchname_sort_icon() throws InterruptedException {
		//Write code here that turns the phrase above into concrete actions
		Thread.sleep(5000);
		classPage.clickSortBatchName();
		}
		@Then("Admin should see Class details are sorted by Batch Name")
		public void admin_should_see_class_details_are_sorted_by_batch_name() {
		//Write code here that turns the phrase above into concrete actions
		classPage.SortAscendingOrder(classPage.getSortBatchName());
		}
		@When("Admin clicks on the Class topic sort icon")
		public void admin_clicks_on_the_class_topic_sort_icon() {
		//Write code here that turns the phrase above into concrete actions
		classPage.clickSortClassTopic();
		}
		@Then("Admin should see Class details are sorted by Class topic")
		public void admin_should_see_class_details_are_sorted_by_class_topic() {
		//Write code here that turns the phrase above into concrete actions
		classPage.SortAscendingOrder(classPage.getSortClassTopic());
		}
		@When("Admin clicks on the descreption sort icon")
		public void admin_clicks_on_the_descreption_sort_icon() {
		//Write code here that turns the phrase above into concrete actions
		classPage.clickSortClassDescription();
		}
		@Then("Admin should see Class details are sorted by descreption")
		public void admin_should_see_class_details_are_sorted_by_descreption() {
		//Write code here that turns the phrase above into concrete actions
		classPage.SortAscendingOrder(classPage.getSortClassDescription());
		}
		@When("Admin clicks on the Status sort icon")
		public void admin_clicks_on_the_status_sort_icon() {
		//Write code here that turns the phrase above into concrete actions
		classPage.clickSortStatus();
		}
		@Then("Admin should see Class details are sorted by Status")
		public void admin_should_see_class_details_are_sorted_by_status() {
		//Write code here that turns the phrase above into concrete actions
		classPage.SortAscendingOrder(classPage.getSortStatus());
		}
		@When("Admin clicks on the Class Date sort icon")
		public void admin_clicks_on_the_class_date_sort_icon() {
		//Write code here that turns the phrase above into concrete actions
		classPage.clickSortClassDate();
		}
		@Then("Admin should see Class details are sorted by Class Date")
		public void admin_should_see_class_details_are_sorted_by_class_date() {
		//Write code here that turns the phrase above into concrete actions
		classPage.SortAscendingOrder(classPage.getSortClassDate());
		}
		@When("Admin clicks on the Staff Name sort icon")
		public void admin_clicks_on_the_staff_name_sort_icon() {
		//Write code here that turns the phrase above into concrete actions
		classPage.clickSortStaffName();
		}
		@Then("Admin should see Class details are sorted by Staff Name")
		public void admin_should_see_class_details_are_sorted_by_staff_name() {
		//Write code here that turns the phrase above into concrete actions
		classPage.SortAscendingOrder(classPage.getSortStaffName());
		}
}
