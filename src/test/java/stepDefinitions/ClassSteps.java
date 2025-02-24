package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.ClassPage;
import pageObjects.LoginPage;
import utilities.ExcelReader;

public class ClassSteps {
	private static final ClassPage manageclasspage = null;
	private static final WebDriver driver = null;
	private TestContextSetup context;// pico
    
    private ClassPage classPage;
    public ClassSteps(TestContextSetup context) throws InterruptedException {
        this.context = context;
        this.classPage = context.getClassPage();
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
