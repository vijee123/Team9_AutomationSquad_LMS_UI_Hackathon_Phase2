package pageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.LoggerLoad;

public class BatchPage extends BasePage {

	public BatchPage(WebDriver driver) {

		super(driver);

	}

	@FindBy(id = "username")
	WebElement Username;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c158-2']//mat-select[@id='mat-select-0']")
	WebElement dropDownElement;
	@FindBy(xpath = "//div[@id='cdk-overlay-0']//span[@class='mat-option-text']")
	WebElement dropDownOption;
	@FindBy(xpath = "//*[@id='login']")
	WebElement loginButton;
	@FindBy(xpath = "//*[@id=\"dashboard\"]")
	WebElement home;
	@FindBy(xpath = "//span[normalize-space()='Batch']")
	WebElement batchBtn;
	@FindBy(xpath = "//div[normalize-space()='Manage Batch']")
	WebElement manageBatch;
	@FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
	WebElement lblLMS;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-title/div[2]/div[1]/button")
	WebElement deleteBtn;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div")
	WebElement paginationContainer;
	@FindBy(xpath = "//table/tbody/tr")
	private List<WebElement> batchRows;
	@FindBy(xpath = "//table/tbody/tr/td/div[@role='checkbox']")
	private List<WebElement> checkboxes;
	@FindBy(xpath = "//th[contains(@class, 'p-sortable-column')]")
	private List<WebElement> actualHeaders;
	@FindBy(xpath = "//div[@role='checkbox' and contains(@class, 'p-checkbox-box')]")
	WebElement chkBox;
	@FindBy(xpath = "//thead//tr//th")
	private List<WebElement> headerCells;

	@FindBy(xpath = "//button[@role='menuitem']")
	WebElement batchPage;

	@FindBy(xpath = "/html/body/app-root/app-header/mat-toolbar/div/button[3]/span[1]")
	WebElement batchBtnIn;
	@FindBy(xpath = "//span[contains(text(), 'Batch Details')]")
	WebElement batchDetailsPopup;
	@FindBy(xpath = "//*[@id=\"programName\"]/div/div[2]")
	WebElement programName;
	@FindBy(xpath = "//*[@id=\"batchProg\"]")
	WebElement batchName;
	@FindBy(xpath = "//*[@id=\"batchDescription\"]")
	WebElement description;
	@FindBy(xpath = "//*[@id=\"batchNoOfClasses\"]")
	WebElement classes;

	@FindBy(xpath = "//body//app-root//div[@role='dialog']//div//div[2]//p-radiobutton[1]//div[1]//div[2]")
	WebElement radio;

	@FindBy(xpath = "//*[@id=\"programName\"]/div/div[2]/span")
	WebElement programDropdown;

	@FindBy(xpath = "//input[@placeholder='Select a Program name']")
	WebElement selectPgm;

	@FindBy(xpath = "//*[@id=\"batchProg\"]")
	WebElement batchNamePrefix;
	@FindBy(xpath = "//*[@id=\"batchName\"]")
	WebElement batchNameSuffix;
	@FindBy(xpath = "//*[@id=\"text-danger\"]")
	WebElement errorElement;

	@FindBy(xpath = "//button[contains(@class, 'p-dialog-header-close')]")
	private WebElement closeIcon;
	@FindBy(xpath = "//button[span[@class='p-button-label' and text()='Save']]")
	WebElement btnSave;
	@FindBy(xpath = "/p-toastitem/div/div/div/div[2]")
	WebElement successMessage;
	@FindBy(xpath = "//*[@id=\"filterGlobal\"]")
	WebElement searchBox;
	@FindBy(xpath = "//*[@id=\"logout\"]")
	WebElement logout;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]")
	private List<WebElement> filteredBatches;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[3]")
	private WebElement nextPageButton;

	@FindBy(xpath = "//button[contains(@class, 'p-paginator-next') and not(@disabled)]")
	private WebElement enabledNextPageButton;
	@FindBy(xpath = "//*[@id=\"programName\"]/div/div[3]/div/ul/p-dropdownitem[2]/li")
	WebElement programSelect;

	@FindBy(xpath = "//*[@id=\"batchProg\"]")
	WebElement batchProg;
	@FindBy(xpath = "//*[@id=\"text-danger\"]")
	WebElement errorMessage;
	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog[1]/div/div/div[3]/button[1]/span[2]")
	WebElement cancelBtn;
	@FindBy(xpath = "//button[span[text()='Cancel']")
	WebElement cancel;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[7]/div/span[1]")
	WebElement firstRowEditIcon;

	@FindBy(xpath = "//table//tr[1]//button[span[contains(@class, 'pi-pencil')]]")
	WebElement batchPopup;
	@FindBy(xpath = "/html/body/div[2]")
	WebElement editCont;
	@FindBy(xpath = "//*[@id=\"mat-menu-panel-1\"]/div/button")
	WebElement addbBtn;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog[1]/div/div/div[1]/div/button")
	WebElement close;
	@FindBy(xpath = "//*[@id=\"batchName\"]")
	WebElement batchNa;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[7]/div/span[2]/button")
	WebElement deleteIcon;
	@FindBy(xpath = "/html/body/app-root/app-batch/p-confirmdialog/div/div/div[2]/span")
	WebElement deleteConfirmationBox;
	@FindBy(xpath = "/html/body/app-root/app-batch/p-confirmdialog/div/div/div[3]/button[2]")
	WebElement yesButton;
	@FindBy(xpath = "/html/body/app-root/app-batch/p-confirmdialog/div/div/div[3]/button[1]")
	WebElement noButton;
	@FindBy(xpath = "/html/body/app-root/app-batch/p-toast/div/p-toastitem/div/div/div/div[1]")
	WebElement deleteSuccessMessage;
	@FindBy(xpath = "/html/body/app-root/app-batch/p-confirmdialog/div/div/div[1]/div/button")
	WebElement closeDelete;
	@FindBy(xpath = "//div[@role='checkbox' and @aria-checked='false']")
	WebElement checkbox;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]/td[1]/p-tablecheckbox/div/div[2]")
	WebElement nxtcheckbox;

	@FindBy(xpath = "//tbody/tr")
	private WebElement tableRow;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div")
	WebElement dataTable;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[3]")
	WebElement nextPage;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[4]")
	WebElement lastPage;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[3]")
	WebElement previousPage;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[1]")
	WebElement showingEntriesText;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[2]")
	WebElement prevPage;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[1]")
	WebElement firstPage;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[2]/button[1]")
	WebElement fstPage;

	//public void getloginCurrent() {

	//	Username.sendKeys("sdetnumpyninja@gmail.com");
	//	Password.sendKeys("Feb@2025");
	//	dropDownElement.click();
	//	dropDownOption.click();
	//	loginButton.click();
	//}

	public void getHomePage() {
		waitForElementVisibility(home);
		home.click();

	}

	public void getBatch() {
		batchBtn.click();

	}

	public void getManageBatchLabel() {

		assertEquals(manageBatch.getText(), "Manage Batch");

	}

	public void getLblLMS() {
		assertEquals(lblLMS.getText(), "LMS - Learning Management System");

	}

	public void isDeleteDisabled() {

		boolean isDisabled = !deleteBtn.isEnabled();

		Assert.assertTrue(isDisabled, "Delete Icon should be disabled under the header in the Batch Page.");
	}

	public void validatePaginationControls() {

		Assert.assertTrue(paginationContainer.isDisplayed(), "Pagination controls are not visible");

	}

	public boolean testEditIconsInBatchRows() {
		for (WebElement row : batchRows) {
			WebElement editIcon = row.findElement(By.xpath(
					".//button[contains(@class, 'p-button-icon-only') and contains(@class, 'p-button-success')]"));
			if (!editIcon.isDisplayed()) {
				return false; // Return false if any row is missing the edit icon
			}
		}
		return true; // Return true if all rows have the edit icon
	}

	// Method to verify that each row contains an icon
	public boolean testDeleteIconsInBatchRows() {
		for (WebElement row : batchRows) {
			WebElement editIcon = row.findElement(By
					.xpath("//button[contains(@class, 'p-button-danger') and contains(@class, 'p-button-icon-only')]"));
			if (!editIcon.isDisplayed()) {
				return false; // Return false if any row is missing the edit icon
			}
		}
		return true; // Return true if all rows have the edit icon
	}

	public boolean isCheckboxPresentInEachRow() {
		return batchRows.size() == checkboxes.size(); // Ensures each row has a checkbox
	}

	public void validateBatchTableHeaders() {

		// Expected headers
		List<String> expectedHeaders = Arrays.asList("Batch Name", "Batch Description", "Batch Status", "No Of Classes",
				"Program Name");

		// Extract text from headers
		for (int i = 0; i < expectedHeaders.size(); i++) {
			Assert.assertEquals(actualHeaders.get(i).getText().trim(), expectedHeaders.get(i),
					"Header mismatch at index " + i);
		}
	}

	public void validateCheckboxInDatatableHeader() {

		// Step 3: Assert that the checkbox is displayed
		Assert.assertTrue(chkBox.isDisplayed(), "Checkbox is not visible in the datatable header row.");
	}

	public void validateSortIcons() {

		// Iterate through each header and verify the sort icon is present
		for (WebElement headerCell : headerCells) {
			// Look for the sort icon next to the header (assuming it's an <i> or <img> tag)
			WebElement sortIcon = headerCell.findElement(By.xpath("//th[@class='p-sortable-column']//p-sorticon//i"));
			Assert.assertNotNull(sortIcon, "Sort icon not found next to header: " + headerCell.getText());
		}
	}

	public void adminShouldSeeSubMenuAddNewBatch() {
		// Locate the sub-menu element in the menu bar and verify if "Add New Batch" is
		// visible
		boolean isSubMenuVisible = batchPage.isDisplayed();

		// Assert if the sub-menu is visible
		Assert.assertTrue(isSubMenuVisible, "Sub-menu 'Add New Batch' should be visible");
	}

	public void getSubMenu() {
		batchPage.click();

	}

	public void getInBatch() {
		batchBtnIn.click();

	}

	public void validateAddNewBatchOption() {

		Assert.assertTrue(batchDetailsPopup.isDisplayed(), "Batch Details pop-up should be visible");

	}

	public void validateBatchDetailsPopupFieldsEnabled() {

		Assert.assertTrue(batchName.isEnabled(), "Batch Name field is not enabled");
		Assert.assertTrue(classes.isEnabled(), "Number of Classes field is not enabled");
		Assert.assertTrue(description.isEnabled(), "Description field is not enabled");
		Assert.assertTrue(programName.isEnabled(), "Program Name dropdown is not enabled");
	}

	public void validateBatchDetailsPopupFieldsDisplayed() {

		Assert.assertTrue(batchName.isDisplayed(), "Batch Name field is not available");
		Assert.assertTrue(classes.isDisplayed(), "Number of Classes field is not available");
		Assert.assertTrue(description.isDisplayed(), "Description field is not available");
		Assert.assertTrue(programName.isDisplayed(), "Program Name dropdown is not available");
	}

// Method to select a program name from dropdown
	public void selectProgramByName() {

		programDropdown.click();
		programSelect.click();

	}

	// Method to get batch name prefix text
	public void getBatchNamePrefix() {

		String expectedProgramName = programSelect.getText(); // Same as selected
		waitForElementVisibility(batchProg);
		String actualBatchNamePrefix = batchProg.getText();
		// Assert.assertEquals(actualBatchNamePrefix, expectedProgramName, "Batch name
		// prefix does not match selected program name");
		LoggerLoad.info("get batchname prefix");

	}

// Enter text into Batch Name Suffix box
	public void enterBatchSuffix(String suffix) {

		batchNameSuffix.clear();

		suffix = suffix.replaceAll("\\.0$", ""); // Removes ".0" only at the end
		batchNameSuffix.sendKeys(suffix);
	}

// Get error message displayed
	public String getErrorMessage() {

		return errorElement.isDisplayed() ? errorElement.getText() : "";
	}

	public void enterBatchNamePrefix(String text) {
		batchNamePrefix.sendKeys(text);
	}

	public void getBatchNamePrefixText() {
		// return batchNamePrefixBox.getAttribute("value"); // Captures text inside the
		// field

		assertEquals(batchNamePrefix.getText(), "");
	}

// Method to click the close icon
	public void clickCloseIcon() {
		closeIcon.click();
	}

// Method to verify if the pop-up is closed
	public boolean isPopupClosed() {
		waitForElementVisibility(closeIcon);
		return closeIcon.isDisplayed(); // If close icon is not visible, popup is closed.
	}

	public void enterdescription(String desc) {
		description.sendKeys(desc);

	}

// Method to select radio button dynamically
	public void selectRadioButton() {

		radio.click();

	}

	public void selectNumClasses(String classNum) {
		classNum = classNum.replaceAll("\\.0$", ""); // Removes ".0" only at the end
		classes.sendKeys(classNum);

	}

// Method to enter mandatory fields
	public void enterMandatoryFields(String programName, String prefix, String suffix, String desc, String status,
			String numClasses) {
		programDropdown.click();
		programSelect.click();
		// selectPgm.sendKeys(programName);
		enterBatchNamePrefix(prefix);
		enterBatchSuffix(suffix);
		enterdescription(desc);
		selectRadioButton();
		selectNumClasses(numClasses);
		btnSave.click();
		LoggerLoad.info("save button clicked");
	}

// Verify success message
	public boolean isSuccessMessageDisplayed() {
		waitForElementVisibility(successMessage);
		return successMessage.isDisplayed();
	}

	public void logout() {

		logout.click();
	}

// Method to check if user is redirected to Login Page
	public boolean isOnLoginPage() {
		return driver.getCurrentUrl().contains("login");
	}

	// Method to enter text in the search box
	public void enterSearchText(String batchName) {
		searchBox.clear();
		waitForElementVisibility(searchBox);
		searchBox.sendKeys(batchName);
	}

// Method to check if filtered results are displayed
	public boolean isFilteredBatchDisplayed() {
		return !filteredBatches.isEmpty(); // Returns true if at least one row is found
	}

// Method to check if the Next Page button is enabled
	public boolean isNextPageButtonEnabled() {
		waitForElementVisibility(nextPageButton);
		return nextPageButton.isEnabled();
	}

	public void clickNextPage() {
		waitForElementVisibility(nextPageButton);
		nextPageButton.click();

	}

	// Method to verify that the Next Page button is enabled after clicking
	public boolean isNextPageEnabledAfterClick() {
		return enabledNextPageButton.isDisplayed();
	}

	public boolean isErrorMessageDisplayed() {
		return errorMessage.isDisplayed();
	}

	public void enterMandatoryFieldsclickCancel(String programName, String prefix, String suffix, String desc,
			String status, String numClasses) {
		programDropdown.click();
		programSelect.click();
		// selectPgm.sendKeys(programName);
		enterBatchNamePrefix(prefix);
		enterBatchSuffix(suffix);
		enterdescription(desc);
		selectRadioButton();
		selectNumClasses(numClasses);
		// btnSave.click();
		cancelBtn.click();
		LoggerLoad.info("cancel button clicked");
	}

	public boolean isPopupClosedCCancel() {
		return !cancelBtn.isDisplayed(); // Returns true if the popup is not visible
	}

	public void clickEditIcon() {
		
		addbBtn.click();
		close.click();
		wait.until(ExpectedConditions.visibilityOf(firstRowEditIcon));
		firstRowEditIcon.click();
		

	}

	public boolean isBatchPopupDisplayed() {
		return batchPopup.isDisplayed();
	}// Check if Program Name field is disabled

	public boolean isProgramNameDisabled() {
		return !programDropdown.isEnabled();
	}

	// Check if Batch Name field is disabled
	public boolean isBatchNameDisabled() {
		return !batchNa.isEnabled();
	}

	public void enterInvalid(String programName, String prefix, String suffix, String desc, String status,
			String numClasses) {

		description.clear();
		enterdescription(desc);
		classes.clear();
		selectNumClasses(numClasses);
		btnSave.click();
		LoggerLoad.info("save button clicked");
	}

	public String getErrorMessageDesc() {
		return errorElement.isDisplayed() ? errorElement.getText() : "";

	}

	public void clickDeleteIcon() {

		addbBtn.click();
		close.click();
		wait.until(ExpectedConditions.visibilityOf(firstRowEditIcon));
		deleteIcon.click();

	}

	public boolean isDeleteConfirmationDisplayed() {
		return deleteConfirmationBox.isDisplayed();
	}

	public boolean isYesButtonDisplayed() {
		return yesButton.isDisplayed();
	}

	public boolean isNoButtonDisplayed() {
		return noButton.isDisplayed();
	}

	public void deleteYes() {
		yesButton.click();

	}

	public void noButton() {
		noButton.click();

	}

	public boolean isDeleteSuccessMessageDisplayed() {
		return deleteSuccessMessage.isDisplayed();
	}

	public boolean isAlertBoxDisplayed() {

		return !deleteConfirmationBox.isDisplayed();

	}

	public void clickcheckBox() {
		wait.until(ExpectedConditions.visibilityOf(checkbox));
		checkbox.click();
	}

	public void multipleclickcheckBox() {
		checkbox.click();
		nxtcheckbox.click();
	}

	public void clickMainDelete() {
		deleteBtn.click();

	}

	public boolean isRowDeleted() {
		try {
			return !checkbox.isDisplayed(); // If row is not displayed, deletion was successful
		} catch (Exception e) {
			return true; // Row not found = deleted
		}
	}

	public void toClick() {
		addbBtn.click();
		close.click();
	}

	public void clickDelete() {
		clickMainDelete();
		yesButton.click();
	}

	public void waitForDataTableToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(dataTable));

	}

	public void clickNextPagelink() {

		addbBtn.click();
		close.click();
		wait.until(ExpectedConditions.visibilityOf(nextPage));
		nextPage.click();
	}

	public void clickLastPage() {
		addbBtn.click();
		close.click();
		wait.until(ExpectedConditions.visibilityOf(lastPage));
		lastPage.click();
	}

	public boolean isnextPageEnabled() {

		return nextPageButton.isEnabled();
	}

	public void previousPage() {
		prevPage.click();
	}

	// Method to verify if the previous page is displayed
	public boolean isPreviousPageDisplayed() {
		return showingEntriesText.isDisplayed(); // Modify logic if needed to verify correct page number
	}

	public void firstPage() {
		firstPage.click();

	}

	// Method to verify if the first page is displayed
	public boolean isFirstPageDisplayed() {
		return fstPage.isEnabled();
	}

	public void openClose() {

		addbBtn.click();
		close.click();
	}
}