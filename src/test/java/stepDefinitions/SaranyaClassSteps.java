package stepDefinitions;

import java.time.Duration;

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

public class SaranyaClassSteps {
	private TestContextSetup context;// pico
    private LoginPage loginPage;
    private ClassPage classPage;
    public SaranyaClassSteps(TestContextSetup context) throws InterruptedException {
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









      
    }



