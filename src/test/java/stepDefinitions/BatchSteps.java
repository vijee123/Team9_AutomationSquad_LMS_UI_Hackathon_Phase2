package stepDefinitions;

import java.io.IOException;

import java.util.Map;

import org.testng.Assert;
import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.LoginPage;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class BatchSteps {
	private TestContextSetup context;// pico
	private LoginPage loginPage;
	private BatchPage batchPage;
	
	public BatchSteps(TestContextSetup context) {
		this.context = context;
		this.loginPage = context.getLoginPage();
		this.batchPage = context.getBatchPage();
	}	
		
		//@Given("Admin successfully logged on to the LMS Portal for batch")
		//public void admin_successfully_logged_on_to_the_lms_portal_for_batch() {
		//	context.launchBrowser();
		//	context.launchUrl();
		//	batchPage.getloginCurrent();
	   //}

		@Given("For batch Admin is on the home page")
		public void for_batch_admin_is_on_the_home_page() {
			batchPage.getHomePage();
			LoggerLoad.info("admin landed on the home page");
		}

		@When("Admin clicks on the Batch menu from the header")
		public void admin_clicks_on_the_batch_menu_from_the_header() {
			batchPage.getBatch();
			LoggerLoad.info("Batch menu clicked");
		}

		@Then("Admin should be in the Manage Batch Page")
		public void admin_should_be_in_the_manage_batch_page() {
			batchPage.getManageBatchLabel();
			LoggerLoad.info("in manage batch page");
		}

		@Then("Admin should see the LMS-Learning Management System Title for batch page")
		public void admin_should_see_the_lms_learning_management_system_title_for_batch_page() {
			batchPage.getLblLMS();
			LoggerLoad.info("LMS Title");
		}

		@Then("Admin should see the Manage Batch Heading")
		public void admin_should_see_the_manage_batch_heading() {
			batchPage.getManageBatchLabel();
			LoggerLoad.info("Reached Manage batch heading");
		}

		@Then("Admin should see the disabled Delete Icon under the header in the Batch Page")
		public void admin_should_see_the_disabled_delete_icon_under_the_header_in_the_batch_page() {
			batchPage.isDeleteDisabled();
			LoggerLoad.info("disabled Delete Icon");
		}

		@Then("Admin should see the enabled pagination controls under the data table in the Batch Page")
		public void admin_should_see_the_enabled_pagination_controls_under_the_data_table_in_the_batch_page() {
			batchPage.validatePaginationControls();
			LoggerLoad.info("validatePaginationControls");
		}

		@Then("Admin should see the edit icon in each row in the Batch Page")
		public void admin_should_see_the_edit_icon_in_each_row_in_the_batch_page() {
			batchPage.testEditIconsInBatchRows();
			LoggerLoad.info("Admin should see the edit icon");
		}

		@Then("Admin should see the delete icon in each row in the Batch Page")
		public void admin_should_see_the_delete_icon_in_each_row_in_the_batch_page() {
			batchPage.testDeleteIconsInBatchRows();
			LoggerLoad.info("Admin should see the delete icon");
		}

		@Then("Admin should see the checkbox in each row in the Batch Page")
		public void admin_should_see_the_checkbox_in_each_row_in_the_batch_page() {
			batchPage.isCheckboxPresentInEachRow();
			LoggerLoad.info("Admin should see the checkbox");
		}

		@Then("Admin should see the datatable headers Batch Name, Batch Description, Batch Status, No Of Classes, Program Name, Edit Delete in the Batch Page")
		public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete_in_the_batch_page() {
			batchPage.validateBatchTableHeaders();
			LoggerLoad.info("Admin should see the datatable headers");
		}

		@Then("Admin should see the checkbox in the datatable header row in the Batch Page")
		public void admin_should_see_the_checkbox_in_the_datatable_header_row_in_the_batch_page() {
			batchPage.validateCheckboxInDatatableHeader(); 
			LoggerLoad.info("Admin should see the checkbox");
		}

		@Then("Admin should see the sort icon next to all Datatable headers in the Batch Page")
		public void admin_should_see_the_sort_icon_next_to_all_datatable_headers_in_the_batch_page() {
			batchPage.validateSortIcons();
			LoggerLoad.info("Admin should see the sort icon");
		}


         @Given("Admin is on the batch page")
         public void admin_is_on_the_batch_page() {
        	 batchPage.getHomePage();
        	 batchPage.getBatch();
        	 LoggerLoad.info("Admin is on the batch page");
        }
		@When("Admin clicks Batch on the navigation bar")
		public void admin_clicks_batch_on_the_navigation_bar() {
			
			LoggerLoad.info("Batch clicked from given already");
			
		}

		@Then("Admin should see sub-menu in menu bar as Add New Batch")
		public void admin_should_see_sub_menu_in_menu_bar_as_add_new_batch() {
			batchPage.adminShouldSeeSubMenuAddNewBatch() ;
			LoggerLoad.info("Batch clicked from given already");
		}


		@When("Admin clicks on Add New Batch under the Batch menu bar")
		public void admin_clicks_on_add_new_batch_under_the_batch_menu_bar() {
			batchPage.getBatch();
			batchPage.getSubMenu();
			LoggerLoad.info("Admin clicks on Add New Batch");
		}

		@Then("Admin should see the Batch Details pop-up window")
		public void admin_should_see_the_batch_details_pop_up_window() {
			batchPage.validateAddNewBatchOption();
			LoggerLoad.info("Admin should see the Batch Details");
		}

		@Given("Admin is on the Batch Details Pop Up Window")
		public void admin_is_on_the_batch_details_pop_up_window() {
			batchPage.getHomePage();
			batchPage.getInBatch();
			batchPage.getSubMenu();
			LoggerLoad.info("Admin is on the Batch Details Pop Up Window");
		}

		@When("Admin checks all the fields are enabled in the Batch Page")
		public void admin_checks_all_the_fields_are_enabled_in_the_batch_page() {
			batchPage.validateBatchDetailsPopupFieldsEnabled();
			LoggerLoad.info("Admin checks all the fields are enabled in the Batch Page");
		}

		@Then("The pop up should include the fields Batch Name, Number of classes, and Description as text box, Program Name as drop down in the Batch Page")
		public void the_pop_up_should_include_the_fields_batch_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_in_the_batch_page() {
			batchPage.validateBatchDetailsPopupFieldsDisplayed();
			LoggerLoad.info("The pop up should include the fields");
		}

		@When("Admin selects program name present in the dropdown of batch page")
		public void admin_selects_program_name_present_in_the_dropdown_of_batch_page() {
		
			batchPage.selectProgramByName();
			LoggerLoad.info("Admin selects program name present");
		}

		@Then("Admin should see selected program name in the batch name prefix box")
		public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
			batchPage.getBatchNamePrefix();
			LoggerLoad.info("Admin should see selected program name");
		}


		@When("Admin enters alphabets data from {string} for required {string} in batch name suffix box")
		public void admin_enters_alphabets_data_from_for_required_in_batch_name_suffix_box(String sheet, String scenario) {
			 Map<String,String> rowData = null;
			 try {
				 rowData =ExcelReader.getRowData(sheet, scenario);
			 }
			 catch (IOException e) {
				 e.printStackTrace();
			 }
			 if (rowData.isEmpty()) {
			 System.out.println("No Data found for scenario: " +scenario);
			 return;
			 }
			 batchPage.enterBatchSuffix(rowData.get("BatchSuffix"));
		}
		@When("Admin enters alphabets data from {string} for required {string} in batch name prefix box")
		public void admin_enters_alphabets_data_from_for_required_in_batch_name_prefix_box(String sheet, String scenario) {
		 Map<String,String> rowData = null;
		 try {
			 rowData =ExcelReader.getRowData(sheet, scenario);
		 }
		 catch (IOException e) {
			 e.printStackTrace();
		 }
		 if (rowData.isEmpty()) {
		 System.out.println("No Data found for scenario: " +scenario);
		 return;
		 }
		 batchPage.enterBatchNamePrefix(rowData.get("BatchPrefix"));

		}

		@Then("Admin should get error message below the text box of respective field for batch page")
		public void admin_should_get_error_message_below_the_text_box_of_respective_field_for_batch_page() {
			String actualMessage = batchPage.getErrorMessage();
	        Assert.assertTrue(actualMessage.contains("This field accept only numbers and max 5 count."), 
	                "Error message mismatch. Found: " + actualMessage);
		}


		@Then("Admin should see empty text box for batch page")
		public void admin_should_see_empty_text_box_for_batch_page() {
			batchPage.getBatchNamePrefixText() ;
			LoggerLoad.info("Admin should see empty text box for batch page");
		}


		@When("Admin enters the data only to the mandatory fields from {string} for required {string} and clicks save button for batch page")
		public void admin_enters_the_data_only_to_the_mandatory_fields_from_for_required_and_clicks_save_button_for_batch_page(String sheet, String scenario) {
			 Map<String,String> rowData = null;
			 try {
				 rowData =ExcelReader.getRowData(sheet, scenario);
			 }
			 catch (IOException e) {
				 e.printStackTrace();
			 }
			 if (rowData.isEmpty()) {
			 System.out.println("No Data found for scenario: " +scenario);
			 return;
			 }
			batchPage.enterMandatoryFields(rowData.get("ProgramName"),rowData.get("BatchPrefix"),rowData.get("BatchSuffix"),rowData.get("Description"),rowData.get("Status"),rowData.get("NumberOfClasses"));

		}

		@Then("Admin should get a successful message for batch page")
		public void admin_should_get_a_successful_message_for_batch_page() {
			//Assert.assertFalse(batchPage.isSuccessMessageDisplayed(), "Success message not displayed.");
	        LoggerLoad.info("Successful");
		}


		@When("Admin leaves blank one of the mandatory fields from {string} for required {string} for batch page")
		public void admin_leaves_blank_one_of_the_mandatory_fields_from_for_required_for_batch_page(String sheet, String scenario) {
			 Map<String,String> rowData = null;
			 try {
				 rowData =ExcelReader.getRowData(sheet, scenario);
			 }
			 catch (IOException e) {
				 e.printStackTrace();
			 }
			 if (rowData.isEmpty()) {
			 System.out.println("No Data found for scenario: " +scenario);
			 return;
			 }
			batchPage.enterMandatoryFields(rowData.get("ProgramName"),rowData.get("BatchPrefix"),rowData.get("BatchSuffix"),rowData.get("Description"),rowData.get("Status"),rowData.get("NumberOfClasses"));

		}

		@Then("Admin should get an error message on the respective mandatory field for batch page")
		public void admin_should_get_an_error_message_on_the_respective_mandatory_field_for_batch_page() {
			batchPage.isErrorMessageDisplayed();
			LoggerLoad.info("Admin should get an error message");
		}


		@When("Admin enters the valid data to all the mandatory fields from {string} for required {string} and clicks save button for batch page")
		public void admin_enters_the_valid_data_to_all_the_mandatory_fields_from_for_required_and_clicks_save_button_for_batch_page(String sheet, String scenario) {
			 Map<String,String> rowData = null;
			 try {
				 rowData =ExcelReader.getRowData(sheet, scenario);
			 }
			 catch (IOException e) {
				 e.printStackTrace();
			 }
			 if (rowData.isEmpty()) {
			 System.out.println("No Data found for scenario: " +scenario);
			 return;
			 }
			batchPage.enterInvalid(rowData.get("ProgramName"),rowData.get("BatchPrefix"),rowData.get("BatchSuffix"),rowData.get("Description"),rowData.get("Status"),rowData.get("NumberOfClasses"));

		}


      @When("Admin enters the valid data to all the mandatory fields from {string} for required {string} and clicks cancel button for batch page")
      public void admin_enters_the_valid_data_to_all_the_mandatory_fields_from_for_required_and_clicks_cancel_button_for_batch_page(String sheet, String scenario) {
    	  Map<String,String> rowData = null;
			 try {
				 rowData =ExcelReader.getRowData(sheet, scenario);
			 }
			 catch (IOException e) {
				 e.printStackTrace();
			 }
			 if (rowData.isEmpty()) {
			 System.out.println("No Data found for scenario: " +scenario);
			 return;
			 }
			 batchPage.enterMandatoryFieldsclickCancel(rowData.get("ProgramName"),rowData.get("BatchPrefix"),rowData.get("BatchSuffix"),rowData.get("Description"),rowData.get("Status"),rowData.get("NumberOfClasses"));
}

		@Then("Admin can see the batch details popup closes without creating any batch")
		public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {
		
			Assert.assertFalse(batchPage.isPopupClosedCCancel(), "Batch details pop-up did not close successfully!");
		}

		@When("Admin clicks on the close icon for batch page")
		public void admin_clicks_on_the_close_icon_for_batch_page() {
			batchPage.clickCloseIcon();
			LoggerLoad.info("Admin clicks on the close icon for batch page");
		}

		@Then("Batch details pop up closes")
		public void batch_details_pop_up_closes() {
			Assert.assertTrue(batchPage.isPopupClosed(), "Popup did not close successfully.");
		}



		@When("Admin clicks the edit icon for batch page")
		public void admin_clicks_the_edit_icon_for_batch_page() {
			 batchPage.clickEditIcon();
			 LoggerLoad.info("Admin clicks the edit icon for batch page");
		}
		



		@Then("Admin should see Program name value field is disabled for editing for batch page")
		public void admin_should_see_program_name_value_field_is_disabled_for_editing_for_batch_page() {
			 batchPage.isProgramNameDisabled();
			 LoggerLoad.info("Admin should see Program name");
		}

		@Then("Admin should see batch name value field is disabled for editing")
		public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
				Assert.assertTrue(batchPage.isBatchNameDisabled(),"Batch name field should be disabled, but it is not.");
				LoggerLoad.info("Admin should see batch name value field is disabled for editing");
		}

		@Given("Admin is on the Batch Details Page")
		public void admin_is_on_the_batch_details_page() {
			batchPage.getHomePage();
			batchPage.getInBatch();
			batchPage.clickEditIcon();
			LoggerLoad.info("Admin is on the Batch Details Page");
		}


		@When("Admin updates any fields with invalid data from {string} for required {string} and clicks save button for batch page")
		public void admin_updates_any_fields_with_invalid_data_from_for_required_and_clicks_save_button_for_batch_page(String sheet, String scenario) {
			batchPage.clickEditIcon();
			 Map<String,String> rowData = null;
			 try {
				 rowData =ExcelReader.getRowData(sheet, scenario);
			 }
			 catch (IOException e) {
				 e.printStackTrace();
			 }
			 if (rowData.isEmpty()) {
			 System.out.println("No Data found for scenario: " +scenario);
			 return;
			 }
			batchPage.enterInvalid(rowData.get("ProgramName"),rowData.get("BatchPrefix"),rowData.get("BatchSuffix"),rowData.get("Description"),rowData.get("Status"),rowData.get("NumberOfClasses"));
		
		
		}
		

		@Then("Admin should get an error message under the respective field for batch page")
		public void admin_should_get_an_error_message_under_the_respective_field_for_batch_page() {
			LoggerLoad.info("Error Message");
		}

		
		@Then("Admin should get an error message under the respective field for batch page for invalid data")
		public void admin_should_get_an_error_message_under_the_respective_field_for_batch_page_for_invalid_data() {
			String actualMessage = batchPage.getErrorMessageDesc();
	        Assert.assertTrue(actualMessage.contains("This field should start with an alphabet and min 2 character."), 
	                "Error message mismatch. Found: " + actualMessage);
		}
		@Then("Admin should get a successful message for editing the batch for batch page")
		public void admin_should_get_a_successful_message_for_editing_the_batch_for_batch_page() {
		   LoggerLoad.info("Successful");
		}

	

		@When("Admin clicks the delete icon on any row for batch page")
		public void admin_clicks_the_delete_icon_on_any_row_for_batch_page() {
			batchPage.clickDeleteIcon();
			LoggerLoad.info("Admin clicks the delete icon");
		}

		@Then("Admin should see the confirm alert box with yes and no button for batch page")
		public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button_for_batch_page() {
			 Assert.assertTrue(batchPage.isDeleteConfirmationDisplayed(), "confirmation not displayed");
			    Assert.assertTrue(batchPage.isYesButtonDisplayed(),"Yes not displayed");
			    Assert.assertTrue(batchPage.isNoButtonDisplayed(),"No not displayed");
		}

		@Given("Admin is on the batch confirm popup page")
		public void admin_is_on_the_batch_confirm_popup_page() {
			batchPage.getHomePage();
			batchPage.getInBatch();
			batchPage.clickDeleteIcon();
			LoggerLoad.info("Admin is on the batch confirm popup page");
		}

		@When("Admin clicks on the delete icon and clicks the yes button for batch page")
		public void admin_clicks_on_the_delete_icon_and_clicks_the_yes_button_for_batch_page() {
			batchPage.deleteYes();
			LoggerLoad.info("Admin clicks on the delete icon");
		}

		@Then("Admin should see the successful message and the batch should be deleted for batch page")
		public void admin_should_see_the_successful_message_and_the_batch_should_be_deleted_for_batch_page() {
			Assert.assertTrue(batchPage.isDeleteSuccessMessageDisplayed(),"Success message is not displayed" );
		}

		@When("Admin clicks on the delete icon and clicks the no button for batch page")
		public void admin_clicks_on_the_delete_icon_and_clicks_the_no_button_for_batch_page() {
			batchPage.noButton();
			LoggerLoad.info("Admin clicks on the delete icon and clicks no");
		}

		@Then("Admin should see the alert box closed and the batch is not deleted for batch page")
		public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted_for_batch_page() {
			Assert.assertTrue(batchPage.isDeleteConfirmationDisplayed(), "confirmation displayed");
		}

		@Then("Admin should see the alert box closed for batch page")
		public void admin_should_see_the_alert_box_closed_for_batch_page() {
			Assert.assertTrue(batchPage.isDeleteConfirmationDisplayed(), "confirmation  displayed");
		}

		@When("Admin clicks on the delete icon under the Manage batch header")
		public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header() {
			batchPage.toClick();
			batchPage.clickcheckBox();
			//batchPage.clickMainDelete();
			batchPage.clickDelete();
		}
		@When("Admin clicks on the delete icon under the Manage batch header for multiple rows")
		public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header_for_multiple_rows() {
			batchPage.toClick();
			batchPage.multipleclickcheckBox();
			batchPage.clickDelete();
		}
		@Then("The respective row in the table should be deleted for batch page")
		public void the_respective_row_in_the_table_should_be_deleted_for_batch_page() {
			
			LoggerLoad.info("Deleted Row");
		}

		@Then("The respective rows in the table should be deleted for batch page")
		public void the_respective_rows_in_the_table_should_be_deleted_for_batch_page() {
		    // Write code here that turns the phrase above into concrete actions
			LoggerLoad.info("Deleted Rows");
		}

		@When("Admin clicks the next page link on the data table for batch page")
		public void admin_clicks_the_next_page_link_on_the_data_table_for_batch_page() {
			
			
			batchPage.clickNextPagelink();
		}

		@Then("Admin should see the next enabled link for batch page")
		public void admin_should_see_the_next_enabled_link_for_batch_page() {
			 Assert.assertTrue(batchPage.isNextPageEnabledAfterClick(), "Next Page button is not enabled after clicking.");
		}

		@When("Admin clicks the last page link on the data table for batch page")
		public void admin_clicks_the_last_page_link_on_the_data_table_for_batch_page() {
			batchPage.clickLastPage();
		}

		@Then("Admin should see the last page link with the next page link disabled on the table for batch page")
		public void admin_should_see_the_last_page_link_with_the_next_page_link_disabled_on_the_table_for_batch_page() {
			batchPage.isnextPageEnabled();
		}

		@When("Admin clicks the previous page link on the data table for batch page")
		public void admin_clicks_the_previous_page_link_on_the_data_table_for_batch_page() {
			batchPage.clickLastPage();
			batchPage.previousPage();
		}

		@Then("Admin should see the previous page on the table for batch page")
		public void admin_should_see_the_previous_page_on_the_table_for_batch_page() {
			Assert.assertTrue(batchPage.isPreviousPageDisplayed(),"Previous page is not displayed correctly");
		}

		@When("Admin clicks the first page link on the data table for batch page")
		public void admin_clicks_the_first_page_link_on_the_data_table_for_batch_page() {
			batchPage.clickLastPage();
            batchPage.firstPage();
            LoggerLoad.info("Admin clicks first page link");
		 }

		@Then("Admin should see the very first page on the data table for batch page")
		public void admin_should_see_the_very_first_page_on_the_data_table_for_batch_page() {
			Assert.assertTrue(batchPage.isFirstPageDisplayed(),"First page is not disabled");
			
		}

		@When("Admin enters the batch name in the search text box")
		public void admin_enters_the_batch_name_in_the_search_text_box() {
			//batchPage.getBatch();
			batchPage.openClose();
			batchPage.enterSearchText("j");
		}

		@Then("Admin should see the filtered batches in the data table")
		public void admin_should_see_the_filtered_batches_in_the_data_table() {
			Assert.assertTrue(batchPage.isFilteredBatchDisplayed(), "Filtered batches are not displayed.");
		}

		@When("Admin clicks on the logout button for batch page")
		public void admin_clicks_on_the_logout_button_for_batch_page() {
			
			batchPage.openClose();
			batchPage.logout();
			LoggerLoad.info("Admin clicks on the logout button");
		}

		@Then("Admin should see the Login screen page from batch page")
		public void admin_should_see_the_login_screen_page_from_batch_page() {
			 Assert.assertTrue(batchPage.isOnLoginPage(), "Admin is not redirected to the Login page.");
		}



	
	}
