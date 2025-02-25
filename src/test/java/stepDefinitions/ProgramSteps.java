package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.RandomStringUtils;
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
	private String searchBoxWithtext;
	public ProgramSteps(TestContextSetup context) {
	this.context = context;
	this.programPage = context.getProgramPage();
	this.loginPage = context.getLoginPage();
	}
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() throws InterruptedException {
	context.launchBrowser();
	context.launchUrl();
	//loginPage.Login(context.getPropUsername(), context.getPropPassword());
	Thread.sleep(3000);
	System.out.println("Admin is on dashboard page after login");
	}
	@When("Admin clicks Program on the navigation bar")
	public void admin_clicks_program_on_the_navigation_bar() {
	programPage.getProgramBtn();
	}
	@Then("Admin should be navigated to Program module")
	public void admin_should_be_navigated_to_program_module() {
	boolean manageProgramTitleDisplay = programPage.manageProgramTitleDisplay();
	System.out.println(
	"Admin is able to see Manage Program title which indicates admin is navigated to Program module: "
	+ manageProgramTitleDisplay);
	Assert.assertTrue(manageProgramTitleDisplay, "Admin is not able to navigated to Program module");
	}
	//--------- Menu Bar----------
	@Then("Admin should not have any broken links for Program module")
	public void admin_should_not_have_any_broken_links_for_program_module() throws InterruptedException {
	Thread.sleep(3000);
	boolean brokenLinks = programPage.findBrokenLinks(programPage.programPageLinks);
	Assert.assertFalse(brokenLinks,"There are broken links in the page");
	System.out.println("Checked all links for the Program module");
	Assert.assertTrue(programPage.findBrokenLinks(programPage.programPageLinks), "No Broken Links");
	}
	@Then("Admin should see the heading LMS - Learning Management System")
	public void admin_should_see_the_heading_lms_learning_management_system() {
	boolean manageProgramPageLmsTitleDisplay = programPage.manageProgramTitleDisplay();
	System.out.println(
	"Admin is able to see heading LMS - Learning Management System: " + manageProgramPageLmsTitleDisplay);
	Assert.assertTrue(manageProgramPageLmsTitleDisplay,
	"Admin is not able to see the heading LMS - Learning Management System");
	}
	@Then("Admin should see the module names as in order Program, Batch, Class, Logout")
	public void admin_should_see_the_module_names_as_in_order_program_batch_class_logout() {
	List<String> expectedOrderOfModuleNames = List.of("Program", "Batch", "Class", "Logout");
	System.out.println("expectedOrderOfModuleNames: " + expectedOrderOfModuleNames);
	List<String> currentOrderOfModuleNames = programPage.getListOfModuleBtnTexts();
	System.out.println("currentOrderOfModuleNames: " + currentOrderOfModuleNames);
	System.out.println("Admin is able to see the module names as in order Program, Batch, Class, Logout");
	Assert.assertEquals(currentOrderOfModuleNames, expectedOrderOfModuleNames,
	"The module names are not in the expected order.");// Assert.assertEquals(actual,expected,"error msg")
	}
	@Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {
	boolean logoutBtnDisplay = programPage.getLogoutBtn();
	System.out.println("Admin is able to see Logout in menu bar: " + logoutBtnDisplay);
	Assert.assertTrue(logoutBtnDisplay, "Admin is not able to see Logout in menu bar");
	}
	@Then("Admin should see sub menu in menu bar as Add New Program")
	public void admin_should_see_sub_menu_in_menu_bar_as_add_new_program() {
	boolean addNewProgramBtnDisplay = programPage.getAddNewProgramBtn();
	System.out.println("Admin is able to see sub menu in menu bar as Add New Program: " + addNewProgramBtnDisplay);
	Assert.assertTrue(addNewProgramBtnDisplay,
	"Admin is not be able to see sub menu in menu bar as Add New Program");
	}
	//page Validation
	@Then("Admin should see the heading Manage Program")
	public void admin_should_see_the_heading_manage_program() {
	boolean manageProgramTitledisplay = programPage.manageProgramTitleDisplay();
	System.out.println("Admin is able to see the heading Manage Program: " + manageProgramTitledisplay);
	Assert.assertTrue(manageProgramTitledisplay, "Admin is not able to see the heading Manage Program");
	}
	@Then("Admin should able to see Program name, description, and status for each program")
	public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {
	programPage.programDetailsPopupDisplay();
	System.out.println("Admin is able to see Program name, description, and status for each program: "
	+ programPage.programDetailsPopupDisplay());
	Assert.assertTrue(programPage.programDetailsPopupDisplay(),
	"Admin is not able to see Program name, description, and status for each program");
	}
	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
	boolean disabledDeleteBtn = !programPage.getProgramPageDisabledDeleteBtn();
	System.out.println("Admin is able to see a Delete button in left top is disabled: " + disabledDeleteBtn);
	Assert.assertTrue(disabledDeleteBtn, "Admin is able to see a Delete button in left top is not disabled");
	}
	///////////////////////////////////////////////////////////////////////
	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String string) {
	String searchBoxDisplayedWithText = programPage.searchProgramDetails("");
	System.out.println("Search bar text displayed with: " + searchBoxWithtext);
	Assert.assertEquals(searchBoxDisplayedWithText, searchBoxDisplayedWithText,"Admin is not able to see Search bar with text as Search");
	System.out.println("Admin is able to see Search bar with text as Search");
	}
	@Then("Admin should see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit\\/Delete")
	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {
	System.out.println(
	"Admin is able to see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit/Delete: "
	+ programPage.ppdataTableHeaderDisplay());
	Assert.assertTrue(programPage.ppdataTableHeaderDisplay(),
	"Admin is not able to see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit/Delete");
	}
	@Then("Admin should see checkbox default state as unchecked beside Program Name column header as")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header_as() {
	boolean ppDataTableheaderCheckBoxUnChecked = programPage.ppRowCheckBoxUnchecked();
	System.out
	.println("Admin is able to see checkbox default state as unchecked beside Program Name column header: "
	+ ppDataTableheaderCheckBoxUnChecked);
	Assert.assertTrue(ppDataTableheaderCheckBoxUnChecked,
	"Checkbox beside Program Name in header is checked, but it should be unchecked as default");
	}
	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
	System.out.println(
	"Admin is able to see check box default state as unchecked on the left side in all rows against program name: "
	+ programPage.ppRowCheckBoxUnchecked());
	Assert.assertTrue(programPage.ppRowCheckBoxUnchecked(),
	"Some checkboxes are checked, but it should be unchecked as default");
	}
	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
	System.out.println(
	"Admin is able to see the sort arrow icon beside to each column header except Edit and Delete: "
	+ programPage.ppSortIconDispay());
	Assert.assertTrue(programPage.ppSortIconDispay(),
	"Admin is not able to see the sort arrow icon beside to each column header except Edit and Delete");
	}
	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
	try {
	Thread.sleep(1000);
	} catch (InterruptedException e) {
	e.printStackTrace();
	}
	System.out.println("Admin is able to see the Edit and Delete buttons on each row of the data table: "
	+ programPage.dataTableEditDeleteIconDisplay());
	Assert.assertTrue(programPage.dataTableEditDeleteIconDisplay(),
	"Admin is not able to see the Edit and Delete buttons on each row of the data table");
	}
	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table. x- starting record number on that page, y-ending record number on that page, z-Total number of records")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table_x_starting_record_number_on_that_page_y_ending_record_number_on_that_page_z_total_number_of_records() {
	try {
	Thread.sleep(1000);
	} catch (InterruptedException e) {
	e.printStackTrace();
	}
	boolean paginationBarTextDisplay = programPage.getPaginationText().isDisplayed();
	String paginationBarText = programPage.getPaginationText().getText();
	System.out.println("Pagination bar text: " + paginationBarText);
	System.out.println(
	"Admin is able to see the text as Showing x to y of z entries along with Pagination icon below the table: "
	+ paginationBarTextDisplay);
	Assert.assertTrue(paginationBarTextDisplay,
	"Admin is not able to see the text as Showing x to y of z entries along with Pagination icon below the table");
	}
	@Then("Admin should see the footer as In total there are z programs. z- Total number of records")
	public void admin_should_see_the_footer_as_in_total_there_are_z_programs_z_total_number_of_records() {
	try {
	Thread.sleep(1000);
	} catch (InterruptedException e) {
	e.printStackTrace();
	}
	programPage.justClick();
	boolean ppFooterTextDisplay = programPage.footerValidation("program");
	System.out.println("Admin is able to see the footer as In total there are z programs: " + ppFooterTextDisplay);
	Assert.assertTrue(ppFooterTextDisplay, "Admin is not able to see the footer as In total there are z programs");
	}
	//Last Part- program Module
	@Given("Admin is on program module after reaching dashboard")
	public void admin_is_on_program_module_after_reaching_dashboard() {
	context.launchBrowser();
	context.launchUrl();
	loginPage.Login(context.getPropUsername(), context.getPropPassword());
	try {
	Thread.sleep(1000);
	} catch (InterruptedException e) {
	e.printStackTrace();
	}
	programPage.getProgramBtn();
	System.out.println("Admin is on program module after reaching dashboard");
	}
	@When("Admin clicks on New Program under the Program menu bar")
	public void admin_clicks_on_new_program_under_the_program_menu_bar() {
	System.out.println("Admin is on program module");
	programPage.getProgramBtn();
	}
	@Then("Admin should see window title as Program Details")
	public void admin_should_see_window_title_as_program_details() {
	boolean programDetailsPopupDisplay = programPage.programDetailsTitleDisplay();
	System.out.println("Admin is able to see window title as Program Details: " + programDetailsPopupDisplay);
	Assert.assertTrue(programDetailsPopupDisplay, "Admin is not able to see window title as Program Details");
	}
	@Then("Admin should see red star mark beside mandatory field Name")
	public void admin_should_see_red_star_mark_beside_mandatory_field_name() {
	boolean programNameRedStarDisplay = programPage.programDetailsNameAsteriskDisplay();
	try {
	Thread.sleep(1000);
	} catch (InterruptedException e) {
	e.printStackTrace();
	}
	System.out.println(
	"Admin is able to see red star mark beside mandatory field Name: " + programNameRedStarDisplay);
	Assert.assertTrue(programNameRedStarDisplay,
	"Admin is not able to see red star mark beside mandatory field Name");
	}
	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {
	try {
	Thread.sleep(1000);
	} catch (InterruptedException e) {
	e.printStackTrace();
	}
	programPage.getAddNewProgramBtn();
	System.out.println("Admin is on Program details form");
	programPage.programDetailsSaveClick();
	}
	@Then("Admin gets message field is required")
	public void admin_gets_message_field_is_required() {
	boolean fieldTextdisplay = !programPage.programDetailsRedFieldTextDisplay();
	System.out.println("Admin gets message field is required: " + fieldTextdisplay);
	Assert.assertTrue(fieldTextdisplay, "Admin is not getting any message field is required");
	}
	// ---------------@MenuBarProgramAddNewProgram4-------------
	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
	programPage.clickCancel();
	}
	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() {
	System.out.println("Admin can see Program Details form disappear");
	}
	// ---------------@MenuBarProgramAddNewProgram5-------------
	@When("Admin enters the Name in the text box")
	public void admin_enters_the_name_in_the_text_box() {
	programPage.enterProgramName("pDName");
	}
	@When("Admin enters the Description in text box")
	public void admin_enters_the_description_in_text_box() {
	programPage.enterProgramDescription("pDDescription");
	}
	// ---------------@MenuBarProgramAddNewProgram7-------------
	@When("Admin selects the status of the program by clicking on the radio button Active\\/InActive")
	public void admin_selects_the_status_of_the_program_by_clicking_on_the_radio_button_active_in_active() {
	programPage.clickActiveRadoBtn();
	}
	@Then("Admin can see Active\\/Inactive status selected")
	public void admin_can_see_active_inactive_status_selected() {
	String radioBtnValue = programPage.clickActiveRadoBtn();
	System.out.println("Attribute value to check Status radio button: " + radioBtnValue);
	Assert.assertEquals(radioBtnValue, "Active", "Admin can see the status radio button is not selected any");
	}
	// ---------------@MenuBarProgramAddNewProgram8----------- programNamewith
	// number
	@When("Admin enter valid details for mandatory fields {string},{string},{string} and Click on save button")
	public void admin_enter_valid_details_for_mandatory_fields_and_click_on_save_button(String pName, String pDesc, String pStatus) {
	programPage.enterProgramName("pName");
	programPage.enterProgramDescription("pDesc");
	String activeBtnText = programPage.clickActiveRadoBtn();
	if (activeBtnText.equalsIgnoreCase(pStatus)) {
	programPage.clickActiveRadoBtn();
	} else {
	programPage.clickInactiveRadoBtn();
	}
	programPage.programDetailsSaveClick();
	}
	@Then("Admin gets message {string}")
	public void admin_gets_message(String string) {
	programPage.justClick();
	//programPage.waitForElementVisibility(programPage.);
	SoftAssert softAssert = new SoftAssert();
	try {
	boolean messageDisplay = programPage.getProgramPageMessage();
	System.out.println("Admin gets message successful Program created: " + messageDisplay);
	softAssert.assertTrue(messageDisplay, "Success message should be displayed");
	} catch (NoSuchElementException e) {
	softAssert.fail("Success message not found: " + e.getMessage());
	}
	softAssert.assertAll();
	}
	// ---------------@MenuBarProgramAddNewProgram9-------------
	@Then("Admin can see program details form disappear")
	public void admin_can_see_program_details_form_disappear() {
	WebDriverWait wait = new WebDriverWait(context.getDriver(), Duration.ofSeconds(10));
	try {
	// boolean popUpDisappear = wait.until(ExpectedConditions.presenceOfElementLocated(programPage.programDetailsPopupDisplay()));
	// System.out.println("Admin can see program details form disappear: " + popUpDisappear);
	// Assert.assertTrue(popUpDisappear, "Admin can see program details form is not disappear");
	} catch (Exception e) {
	System.err.println(
	"An error occurred while checking for program details form disappearance: " + e.getMessage());
	Assert.fail("Failed to verify if the program details form disappeared due to an unexpected error.");
	}
	}
	// ---------------@MenuBarProgramAddNewProgram10-------------
	@When("Admin searches with newly created Program Name")
	public void admin_searches_with_newly_created_program_name() {
	String newlyCreatedProgramName = "proDetailsNameSix";
	programPage.getsearchTextBox();
	//programPage.clicksearchTextBox().sendkeys(newlyCreatedProgramName));
	System.out.println("Admin searches with newly created Program Name: " + newlyCreatedProgramName);
	}
	@Then("Records of the newly created Program Name is displayed and match the data entered")
	public void records_of_the_newly_created_program_name_is_displayed_and_match_the_data_entered() {
	List<String> expectedValuesOnCreatedProgram = List.of("proDetailsNameSix", "proDescription", "Active");
	System.out.println("Expected value on created program: " + expectedValuesOnCreatedProgram);
	List<String> currentValuesOnCreatedProgram = programPage.listOfCreatedProgramValues();
	System.out.println("currentOrderOfModuleNames: " + currentValuesOnCreatedProgram);
	System.out.println(
	"Admin is able to see the Records of the newly created Program Name is displayed and match the data entered");
	Assert.assertEquals(currentValuesOnCreatedProgram, expectedValuesOnCreatedProgram,
	"The Records of the newly created Program Name displayed is not matched with expected data.");
	}
	// ---------------@MenuBarProgramAddNewProgram11-------------
	@Given("Admin is on Program details form")
	public void admin_is_on_program_details_form() {
	programPage.click_X_CloseIcon();
	}
	//New
	@When("Admin Click on Cross button")
	public void admin_click_on_cross_button() {
	programPage.justClick();
	programPage.clickEditIcon();
	}
	@Given("Admin is logged in to LMS Portal")
	public void admin_is_logged_in_to_lms_portal() {
	Assert.assertTrue(programPage.programDetailsTitleDisplay(), "Program details page is not displayed...");
	}
	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program() {
	Assert.assertEquals(programPage.editIconDisplay(),"Edit option for particular program");
	}
	@Then("Admin should see red ASTERISK mark beside mandatory field Name")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field_name() {
	Assert.assertTrue(programPage.programDetailsNameAsteriskDisplay(), "Asterisk symbol is not displayed...");
	}

    @When("Admin edits the program name and click on save button")
	public void admin_edits_the_program_name_and_click_on_save_button() {
	programPage.justClick();
	programPage.clickEditIcon();
	programPage.enterProgramName("Edited Program Name");
	programPage.programDetailsSaveClick();
	}
	@Then("Updated program name is seen by the Admin")
	public void updated_program_name_is_seen_by_the_admin() {
	Assert.assertEquals(programPage.row1ProgramName(), "Edited Program Name", "Program name is not Updated....");
	}
	@When("Admin edits the description text and click on save button")
	public void admin_edits_the_description_text_and_click_on_save_button() {
	programPage.justClick();
	programPage.clickEditIcon();
	programPage.clickInactiveRadoBtn();
	programPage.programDetailsSaveClick();
	}
	@Then("Admin can see the description is updated")
	public void admin_can_see_the_description_is_updated() {
	Assert.assertEquals(programPage.row1ProgramDescription(), "Inactive", "Description is not updated....");
	}
	@When("Admin can change the status of the program and click on save button")
	public void admin_can_change_the_status_of_the_program_and_click_on_save_button() {
	Assert.assertEquals(programPage.row1ProgramStatus(), "Inactive", "Status is not updated....");
	}
	@Then("Status updated can be viewed by the Admin")
	public void status_updated_can_be_viewed_by_the_admin() {
	Assert.assertEquals(programPage.row1ProgramStatus(), "Inactive", "Status is not updated....");
	}
	@Given("Admin is on Program module")
	public void admin_is_on_program_module() {
	programPage.justClick();
	programPage.clickEditIcon();
	}
	@When("Admin click on cancel button")
	public void admin_click_on_cancel_button() {
	programPage.justClick();
	programPage.clickEditIcon();
	programPage.clickCancel();
	}
	@Then("Admin can see the Program details form disappear")
	public void admin_can_see_the_program_details_form_disappear() {
	Assert.assertTrue(programPage.manageProgramTitleDisplay(), "Program Details form is not Closed....");
	}
	@When("Admin searches with newly updated Program Name")
	public void admin_searches_with_newly_updated_program_name() {
	programPage.justClick();
	programPage.clickEditIcon();
	programPage.enterProgramName("searchdata");
	programPage.programDetailsSaveClick();
	programPage.searchProgramDetails("searchdata");
	}
	@Then("Admin verifies that the details are correctly updated.")
	public void admin_verifies_that_the_details_are_correctly_updated() {
	Assert.assertEquals(programPage.row1ProgramName(), "search data", "Modified data is not updated.....");
	}
	@When("Admin Click on X button")
	public void admin_click_on_x_button() {
	programPage.justClick();
	programPage.clickEditIcon();
	programPage.click_X_CloseIcon();
	}
	@When("Admin clicks on delete button for a program")
	public void admin_clicks_on_delete_button_for_a_program() {
	programPage.justClick();
	programPage.clickDeleteIcon();
	}
	@Then("Admin will get confirm deletion popup")
	public void admin_will_get_confirm_deletion_popup() {
	Assert.assertTrue(programPage.confirmDeletePageTitleDisplay(), "Confirm Delete Page did not pop-up...");
	}
	@When("Admin clicks on YES button")
	public void admin_clicks_on_yes_button() {
	programPage.clickConfirmDeleteYESBtn();
	}
	@Then("Admin can see Successful Program Deleted message")
	public void admin_can_see_successful_program_deleted_message() {
	Assert.assertTrue(programPage.deleteSuccessfulMsgDisplay(),
	"Successful Program Deleted message did not pop-up....");
	}
	@When("Admin Searches for Deleted Program name")
	public void admin_searches_for_deleted_program_name() {
	programPage.addNewProgram("VSVSDelete", "VSVSDelete");
	programPage.deleteProgram("VSDelete");
	}
	@Then("There should be zero results.")
	public void there_should_be_zero_results() {
	programPage.searchProgramDetails("VSVSDelete");
	Assert.assertTrue(programPage.NoProgDisplayOnSearch(), "The program is not deleted.....");
	}
	@Given("Admin is on Program Confirm Deletion Page after selecting a program to delete")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_a_program_to_delete() {
	programPage.getProgramBtn();
	programPage.addNewProgram("VSSVProg", "VSSVProg");
	programPage.searchProgramDetails("VSSVProg");
	programPage.clickDeleteIcon();
	}
	@When("Admin clicks on NO button")
	public void admin_clicks_on_no_button() {
	programPage.clickConfirmDeleteNOBtn();
	}
	@When("Admin Click on X button of Confirm Delete window")
	public void admin_click_on_x_button_of_confirm_delete_window() {
	programPage.clickIconXConfirmDeletePage();
	}
	@When("Admin selects more than one program by clicking on the checkbox")
	public void admin_selects_more_than_one_program_by_clicking_on_the_checkbox() {
	programPage.justClick();
	// -----To Select Top 3 Boxes----
	for (int i = 1; i <= 2; i++) {
	programPage.clickMultipleCheckBoxesOfProgramTable(i);
	}
	}
	@Then("Programs get selected")
	public void programs_get_selected() {
	for (int i = 1; i <= 2; i++) {
	boolean checked = programPage.checkBoxesSelectedStatus(i);
	Assert.assertTrue(checked);
	}
	}
	@When("Admin clicks on the delete button on the left top of the program page")
	public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page() {
	programPage.clickTopLeftDeleteIcon();
	}
	@Given("Admin is on Program Confirm Deletion Page after selecting multiple program to delete")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_multiple_program_to_delete() {
	programPage.getProgramBtn();
	programPage.justClick();
	// -------------To Select Top 3 Check Boxes-----------------
	for (int i = 1; i <= 3; i++) {
	programPage.clickMultipleCheckBoxesOfProgramTable(i);
	}
	}
	@When("Admin Searches for Deleted Program names")
	public void admin_searches_for_deleted_program_names() {
	programPage.justClick();
	programPage.searchProgramDetails("ProgramVJDelete");
	}
	@Then("Admin can see Programs are still selected and not deleted")
	public void admin_can_see_programs_are_still_selected_and_not_deleted() {
	for (int i = 1; i <= 3; i++) {
	boolean checked = programPage.checkBoxesSelectedStatus(i);
	Assert.assertTrue(checked);
	}
	}
	@Then("Admin can see Confirm Deletion form disappear")
	public void admin_can_see_confirm_deletion_form_disappear() {
	Assert.assertTrue(programPage.manageProgramTitleDisplay(), "Confirm delete pop-up is not Closed....");
	}
	@When("Admin enter the program to search By program name")
	public void admin_enter_the_program_to_search_by_program_name() {
	programPage.justClick();
	programPage.searchProgramDetails(nameCheck);
	}
	@Then("Admin should able to see Program name Description and Status for searched program name")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name() {
	programPage.justClick();
	programPage.clickSingleRightArrowPagination();
	}
	@When("Admin enter the program to search By program description")
	public void admin_enter_the_program_to_search_by_program_description() {
	programPage.justClick();
	programPage.searchProgramDetails("description");
	}
	@Then("Admin should able to see Program name Description and Status for searched program description")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_description() throws InterruptedException {
	Thread.sleep(3000);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(programPage.row1ProgramDescription(), "description", "Program Description is not matching");
	sa.assertEquals(programPage.row1ProgramName().isEmpty(), false);
	sa.assertEquals(programPage.row1ProgramStatus().isEmpty(), false);
	sa.assertAll();
	}
	@When("Admin enter the program to search By program name that does not exist")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist() {
	programPage.justClick();
	programPage.searchProgramDetails("kdjfhdjkdhf");
	}
	@When("Admin enter the program to search By partial name of program")
	public void admin_enter_the_program_to_search_by_partial_name_of_program() {
	programPage.justClick();
	programPage.searchProgramDetails("TeamTwo");
	}
	@Then("Admin should able to see partial Program name Description and Status for searched program name")
	public void admin_should_able_to_see_partial_program_name_description_and_status_for_searched_program_name() throws InterruptedException {
	Thread.sleep(1000);
	SoftAssert sa = new SoftAssert();
	String ProgName = programPage.row1ProgramName();
	String partialName = ProgName.substring(0, 7);
	sa.assertEquals(partialName, "TeamTwo", "Program Name is not matching");
	sa.assertEquals(programPage.row1ProgramDescription().isEmpty(), false);
	sa.assertEquals(programPage.row1ProgramStatus().isEmpty(), false);
	sa.assertAll();
	}
	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() {
	programPage.justClick();
	programPage.programNameHeader.click();
	}
	@Then("Admin See the Program Name is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_name_is_sorted_in_ascending_order_descending_order() {
	Assert.assertTrue(programPage.sortProgramName(),
	"Program Name is not sorted Ascending order\\/Descending order");
	}
	@When("Admin clicks on Arrow next to Program Description")
	public void admin_clicks_on_arrow_next_to_program_description() {
	nameCheck = RandomStringUtils.randomAlphabetic(7);
	programPage.addNewProgram(nameCheck, "Description");
	}
	@Then("Admin See the program Description is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_description_is_sorted_in_ascending_order_descending_order() {
	Assert.assertTrue(programPage.sortProgramDesc(),
	"Program Description is not sorted Ascending order\\/Descending order");
	}
	@When("Admin clicks on Arrow next to Program status")
	public void admin_clicks_on_arrow_next_to_program_status() {
	programPage.justClick();
	programPage.programStatusHeader.click();
	}
	@Then("Use See the Program Status is sorted in Ascending order\\/Descending order")
	public void use_see_the_program_status_is_sorted_in_ascending_order_descending_order() {
	Assert.assertTrue(programPage.sortProgramStatus(),
	"Program Status is not sorted Ascending order\\/Descending order");
	}
	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
	programPage.justClick();
	programPage.clickSingleRightArrowPagination();
	}
	@Then("Admin should see the Pagination has NEXT active link")
	public void admin_should_see_the_pagination_has_next_active_link() {
	Assert.assertTrue(programPage.SingleRightArrowEnabled(), "The NEXT link is NOT Enabled......");
	}

     @When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() throws InterruptedException {
	programPage.justClick();
	Thread.sleep(3000);
	programPage.clickDoubleRightArrowPagination();
	}
	@Then("Admins should see the last page record on the table with Next page link are disabled")
	public void admins_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(programPage.SingleRightArrowEnabled(), false, "The NEXT link is NOT Disabled......");
	sa.assertEquals(programPage.doubleRightArrowEnabled(), false, "The LAST PAGE link is NOT Disabled......");
	sa.assertTrue(programPage.currentPageValidation("last"),
	"The Right Double Arrow Link DOES NOT takes to last page of Program Webtable..");
	sa.assertAll();
	}
	@When("Admin clicks Previous page link")
	public void admin_clicks_previous_page_link() throws InterruptedException {
	programPage.clickSingleLeftArrowPagination();
	Thread.sleep(3000);
	}
	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(programPage.SingleLeftArrowEnabled(), true, "The PREVIOUS link NOT Enabled........");
	sa.assertEquals(programPage.doubleLeftArrowEnabled(), true, "The LEFT DOUBLE ARROW link is NOT Enabled......");
	sa.assertTrue(programPage.currentPageValidation("priorLast"),
	"We are NOT at page PRIOR to last page of Program Webtable..");
	sa.assertAll();
	}
	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
	programPage.clickDoubleLeftArrowPagination();
	}
	@Then("Admins should see the very first page record on the table with Previous page link are disabled")
	public void admins_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(programPage.SingleLeftArrowEnabled(), false, "The PREVIOUS link is NOT Disabled........");
	sa.assertEquals(programPage.doubleLeftArrowEnabled(), false,
	"The LEFT DOUBLE ARROW link is NOT Disabled......");
	sa.assertTrue(programPage.currentPageValidation("first"), "We are NOT at FIRST page of Program Webtable..");
	sa.assertAll();
	}
	@Then("Count of programs in footer should match total programs")
	public void count_of_programs_in_footer_should_match_total_programs() throws InterruptedException {
	programPage.justClick();
	Assert.assertTrue(programPage.paginationValidation(),
	"Number of programs displayed on Footer message is INCORRECT");
	}
}

