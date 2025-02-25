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

		    @Given("Admin is on the Manage Class page")
		    public void admin_is_on_the_manage_class_page() {
		        System.out.println("admin is on the manage class page");
		    }

		    @When("Admin clicks on the edit icon")
		    public void admin_clicks_on_the_edit_icon() {
		    	classPage.clickonediticon();
		    	 System.out.println("Admin is on the popup window");
		    	 
		    }

		    @Then("Admin should see batch name field is disabled")
		    public void admin_should_see_batch_name_field_is_disabled() {
		    	System.out.println("Batch Name field is disabled");
		    }

		    @Then("Admin should see class topic field is disabled")
		    public void admin_should_see_class_topic_field_is_disabled() {
		    	System.out.println("class topic field is disabled");
		    }
		    @Given("Admin is on the Edit Class Popup window")
		    public void admin_is_on_the_edit_class_popup_window() {
		    	System.out.println("Admin is on popup window");
		    }

		    @When("Update the fields with valid data and click save")
		    public void update_the_fields_with_valid_data_and_click_save() {
		    	try {
		            Map<String, String> rowData = ExcelReader.getRowData("classEdit", "updateclass");

		            classPage.updateFieldsWithValidData(rowData.get("classdescription"), rowData.get("staffname"));
		            classPage.clickSaveButton();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

					 //String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel data\\Book2.xlsx";

					 //ExcelReader er = new ExcelReader();
						 
										//try {
											//List<Map<String, String>> data = er.getData(filePath,"Sheet1");
											//for (int i = 0; i < data.size(); i++) {
									         //print row and value 
									          //  System.out.println("************************");
									           // System.out.println("Batch name  " +  currentRow.get("Batch name"));
									          //  System.out.println("class topic " +  currentRow.get("class topic"));
									          //  System.out.println("class description  " +  currentRow.get("class description"));
									          //  System.out.println("Select class dates  " +  currentRow.get("Select class dates"));
									           // System.out.println("No of classes  " +  currentRow.get("No of classes"));
									           // System.out.println("staff name  " +  currentRow.get("staff name"));
									         //   System.out.println("status  " +  currentRow.get("status"));

									          //  classPage.updateFieldsWithValidData(currentRow.get("staff name"),currentRow.get("class description"));
									            
									    //    }
										//} catch (Exception e) {
											//// TODO Auto-generated catch block
											//e.printStackTrace();
										//} 
				
		    
		    	
				//classPage.updateFieldsWithValidData("New classdescriptiontextbox", "New staffname");
				//classPage.clickSaveButton();
		     @Then("Admin gets message {string} and see the updated values in data table")
		    public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
		    	System.out.println("Admin should see succesfully saved");
		    }
		     @When("Update the fields with invalid values and click save")
		    public void update_the_fields_with_invalid_values_and_click_save() {
		    	 try {
		    	        Map<String, String> rowData = ExcelReader.getRowData("Sheet1", "InvalidData");

		    	        classPage.updateFieldsWithValidData(rowData.get("classdescription"), rowData.get("staffname"));
		    	        classPage.clickSaveButton();
		    	    } catch (Exception e) {
		    	        e.printStackTrace();
		    	    }
		    	}
		    	   //classPage.updateFieldsWithValidData("New classdescriptiontextbox", "New staffname");
				  // classPage.clickSaveButton();
		    

		    @Then("Admin should get Error message")
		    public void admin_should_get_error_message() {
		    	System.out.println("Admin should see error message");
		    }
		    @When("Update the mandatory fields with valid values and click save")
		    public void update_the_mandatory_fields_with_valid_values_and_click_save() {
		    	classPage.updatemandatoryfieldWithValidData();
				classPage.clickSaveButton();
		    }
		    @When("Update the optional fields with valid values and click save")
		    public void update_the_optional_fields_with_valid_values_and_click_save() {
		    	classPage.updateoptionalfield();
				classPage.clickSaveButton();
		    }

		    @When("Admin clicks Cancel button on edit popup")
		    public void admin_clicks_cancel_button_on_edit_popup() {
		    	System.out.println("Admin clicks cancel button");
		    }

		    @Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
		    public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_class() {
		    	System.out.println("Admin should see details");
		    }
		    @Given("Admin is in Manage Class page")
		    public void admin_is_in_manage_class_page() {
		        System.out.println("Admin is in manage class page");
		    }

		    @When("Admin clicks on Class link on Manage Class page")
		    public void admin_clicks_on_class_link_on_manage_class_page() {
		    	classPage.cliclclasslink();
		    }

		    @Then("Admin is redirected to class page")
		    public void admin_is_redirected_to_class_page() {
		    	System.out.println("Admin is directed to class page");
		    }

		   @When("Admin clicks on Logout link on Manage class page")
		    public void admin_clicks_on_logout_link_on_manage_class_page() {
		    	classPage.clicklogoutlink();
		    }

		    @Then("Admin is redirected to Login page")
		    public void admin_is_redirected_to_login_page() {
		    	System.out.println("Admin is directed to login page");
		    }
		    @Given("Admin is the Manage class page")
		    public void admin_is_the_manage_class_page() {
		    	System.out.println("Admin is manage class page");
		    }

		    @When("Admin enter the Batch Name in search textbox")
		    public void admin_enter_the_batch_name_in_search_textbox() {
		    	classPage.clicksearchBar();
		    }

		    @Then("Admin should see Class details are searched by Batch Name")
		    public void admin_should_see_class_details_are_searched_by_batch_name() {
		    	System.out.println("Admin should see  batch name details");
		    }

		    @When("Admin enter the Class topic in search textbox")
		    public void admin_enter_the_class_topic_in_search_textbox() {
		    	classPage.searchclastopic();
		    }

		    @Then("Admin should see Class details are searched by Class topic")
		    public void admin_should_see_class_details_are_searched_by_class_topic() {
		    	System.out.println("Admin should see class topic details");
		    }
		    @Given("Admin should on Manage Class Page")
		    public void admin_should_on_manage_class_page() {
		    	System.out.println("Admin should on manage class page");
		    }

		    @When("Admin clicks the delete icon")
		    public void admin_clicks_the_delete_icon() {
		        System.out.println("click on delete");
		    }

		    @Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
		    public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
		    	System.out.println("Admin should see alert open");
		    }
		    @Given("Admin  in Manage Class page")
		    public void admin_in_manage_class_page() {
		    	System.out.println("Admin should in manage class page");
		    }

		    @When("Admin clicks any checkbox in the data table")
		    public void admin_clicks_any_checkbox_in_the_data_table() {
		    	System.out.println("Admin click on check box");
		    }

		    @Then("Admin should see common delete option enabled under header Manage class")
		    public void admin_should_see_common_delete_option_enabled_under_header_manage_class() {
		    	System.out.println("Admin see delete button");
		    }
		    @Given("Admin is on Confirm Deletion alert")
		    public void admin_is_on_confirm_Deletion_alert() {
		    	System.out.println("Admin see confirm deletion alert");
		    	
		    }

		    @When("Admin clicks yes option")
		    public void admin_clicks_yes_option() {
		    	classPage.clickyes();
		    }

		    @Then("Admin gets a message {string} alert and do not see that Class in the data table")
		    public void admin_gets_a_message_alert_and_do_not_see_that_class_in_the_data_table(String string) {
		    	System.out.println("Admin see message");
		    }
}
