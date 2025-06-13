package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ClassPage extends BasePage {

	private static final Logger logger = LogManager.getLogger(ClassPage.class);
	BasePage bp=new BasePage(driver);
	//applicationData ad=new applicationData();
	protected static final long IMPLICIT_WAIT = 10;
	private WebDriverWait wait;
	@FindBy(xpath = "//button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']//span[contains(text(),'Class')]")
	private WebElement classButton;
	
	@FindBy(xpath = "//div[@class='box' and normalize-space(text())='Manage Class']")
	private WebElement manageClassText;
	
	@FindBy(xpath="//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']//span[contains(text(),' LMS - Learning Management System')]")		
	private WebElement LMSText;
	
	@FindBy(xpath="//span[@class='p-input-icon-left']//input[@id='filterGlobal']")
	private WebElement searchBar1;
	
	String batchNameRow;
	String batchNamePopUpValue;
	int rowSize;
	Map<String, String> fetchRowMap;
//	WebDriverWait wait;
	@FindBy(xpath = "//span[text()='Class']/..")
	WebElement classLink;
	@FindBy(xpath = "//div[contains(@role, 'dialog')]")
	WebElement addNewPopup;
	@FindBy(xpath = "//span[@id='pr_id_85-label']")
	WebElement PopupTitle;
	@FindBy(xpath = "//div[text()=' Manage Class']")
	WebElement pageTitle;
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	WebElement headerTitle;
	@FindBy(id = "filterGlobal")
	WebElement searchBar;
	@FindBy(xpath = "//button[contains(@class, 'mat-focus-indicator mat-menu-item')]")
	
	WebElement addNewBtn;
	@FindBy(xpath = "//span[text()='Cancel']")
	WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;
	@FindBy(xpath = "//span[contains(@class,'p-dialog-header-close-icon ng-tns')]")
	WebElement closeBtn;
	@FindBy(xpath = "//div[contains(@class,'p-dialog-header')]")
	WebElement dialogWindow;
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-calendar']")
	WebElement calenderIcon;
	@FindBy(xpath = "//input[@id='classTopic']")//input[@id='classTopic']
	WebElement classTopic;
	@FindBy(xpath = "//input[@id='classNo']")
	WebElement noOfClasses;
	@FindBy(xpath = "//input[@id='icon']")
	WebElement classDates;
	@FindBy(id = "deleteProgram")
	WebElement deletebtn;
//	@FindBy(id="filterGlobal")WebElement searchbtn;
	@FindBy(xpath = "//span[text()='Confirm']")
	WebElement confirmlabel;
	@FindBy(xpath = "//span[text()='Yes']")
	WebElement yesBtn;
	@FindBy(xpath = "//span[text()='No']")
	WebElement noBtn;
	@FindBy(xpath = "//*[contains(text(),'Are you sure you want to delete')]")
	WebElement contentTxt;
//	@FindBy(xpath="//span[@class='pi pi-times ng-tns-c133-4']")WebElement closeBtn;
	@FindBy(xpath = "//div[contains(@class,'p-toast-summary')]")
	WebElement successPopupTitle;
	@FindBy(xpath = "//div[contains(@class,'p-toast-detail')]")
	WebElement successPopupContent;
	@FindBy(xpath = "//div[contains(@class,'p-datatable-footer')]")
	WebElement footerText;
	
	@FindBy(xpath = "//button[@class='p-button-rounded p-button-danger p-button p-component ng-star-inserted']")
	WebElement cancelbtn;
//	@FindBy(xpath="//span[@class='p-dialog-header-close-icon ng-tns-c132-3 pi pi-times']")WebElement crossbtn;
	@FindBy(xpath = "//*[contains(text(),'Successful Program Created')]")
	WebElement pgmPopSuccessTxt;
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//button[@id='login']")
	WebElement login;
	@FindBy(xpath = "//span[text()='Class']/..")
	WebElement classPage;
	@FindBy(xpath = "//div[contains(@class, 'cdk-overlay-backdrop')]")
	WebElement classBckDrp;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr[1]")
	WebElement firstRow;
	@FindBy(xpath = "//p-dropdown[@id='batchName']//div/div/input[@type='text']")
	WebElement batchNamePopUp;
	@FindBy(xpath = "//input[@id='classDescription']")
	WebElement classDescrip;
	@FindBy(xpath = "//input[@id='icon']")
	WebElement classDate;
	@FindBy(xpath = "//button[@id='saveClass']")
	WebElement saveButton;
	@FindBy(xpath = "//p-dropdown[@id='staffId']/div/input")
	WebElement staffName;
	@FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id='Inactive']")
	WebElement statusInactBtn;
	@FindBy(xpath = "//input[@id='classComments']")
	WebElement comments;
	@FindBy(xpath = "//input[@id='classNotes']")
	WebElement notes;
	@FindBy(xpath = "//input[@id='classRecordingPath']")
	WebElement recording;
//	@FindBy(xpath = "//p-toast//p-toastitem")
//	WebElement saveSuccessMsgPop;
	
	@FindBy(xpath = "//div[contains(@class,'p-toast-summary')]")
	WebElement saveSuccessMsgPop;
	@FindBy(xpath = "//span[text()='Cancel']/..")
	WebElement cancelButton;
	@FindBy(xpath = "//input[@id='classTopic']")
	WebElement classTopicPopUp;
	@FindBy(xpath = "//input[@id='filterGlobal']")
	WebElement search;
	@FindBy(xpath = "//small[text()='Class Date is required.']")
	WebElement invalDateErrMsg;
	@FindBy(xpath = "//mat-card-title[text()='Class Comments']/following-sibling::mat-card-subtitle")
	WebElement commentsRow;
	@FindBy(xpath = "//mat-card-title[text()='Class Notes']/following-sibling::mat-card-subtitle")
	WebElement notesRow;
	@FindBy(xpath = "//mat-card-title[text()='Class Recording Path']/following-sibling::mat-card-subtitle")
	WebElement recordingRow;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']") // Example: adjust based on your actual table structure
	WebElement dataTable;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-next')]")
	WebElement nextPageLink;
	
	@FindBy(xpath = "//button[contains(@class,'p-paginator-last')]")
	WebElement lastPageLink;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-first')]")
	WebElement startPageLink;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-prev')]")
	WebElement prevPageLink;
	@FindBy(xpath = "//button[@icon='pi pi-pencil']")
	WebElement editLink;
	
	@FindBy(xpath = "//span[text()='Close']/..")
	WebElement closePopUp;
	
	@FindBy(xpath = "//thead//tr//th[2]")
	WebElement clickSortBatchName;
	@FindBy(xpath = "//thead//tr//th[3]")
	WebElement clickSortClassTopic;
	@FindBy(xpath = "//thead//tr//th[4]")
	WebElement clickSortClassDescription;
	
	@FindBy(xpath = "//thead//tr//th[5]")
	WebElement clickSortStatus;
	
	@FindBy(xpath = "//thead//tr//th[6]")
	WebElement clickSortClassDate;
	
	@FindBy(xpath = "//thead//tr//th[7]")
	WebElement clickSortStaffName;
	
	
	@FindBy(xpath = "//tr//td[2]")
	List<WebElement> sortBatchName;
	@FindBy(xpath = "//tr//td[3]")
	List<WebElement> sortClassTopic;
	@FindBy(xpath = "//tr//td[4]")
	List<WebElement> sortClassDescription;
	
	@FindBy(xpath = "//tr//td[5]")
	List<WebElement> sortStatus;
	
	@FindBy(xpath = "//tr//td[6]")
	List<WebElement> sortClassDate;
	
	@FindBy(xpath = "//tr//td[7]")
	List<WebElement> sortStaffName;
	
	
	@FindBy(xpath = "//button[@id='logout']")
	WebElement logOut;
	
	@FindBy(xpath = "//p[text()='Please login to LMS application']")
	WebElement loginPage;
	@FindBy(xpath = "//div[contains(@role, 'dialog')]")
	WebElement addNewClassPopup;
	@FindBy(xpath = "//label[text()='No of Classes']")
	WebElement noOfClassesLabel;
	@FindBy(xpath = "//input[@placeholder='Select a Batch Name']")
	WebElement batchNamedd;
	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']")
	WebElement staffNamedd;
	@FindBy(xpath = "//input[@id='Active']/../..")
	WebElement statusActiveOption;
	@FindBy(xpath = "//input[@id='Inactive']/../..")
	WebElement statusInactiveOption;
	@FindBy(xpath = "//button[@id='saveClass']")
	WebElement savebtn;
	@FindBy(xpath = "//input[@id = 'classDescription']")
	WebElement classDescText;
	@FindBy(xpath = "//input[@id = 'classComments']")
	WebElement classCommentsText;
	@FindBy(xpath = "//input[@id = 'classNotes']")
	WebElement classNotesText;
	@FindBy(xpath = "//input[@id = 'classRecordingPath']")
	WebElement classRecordingText;
	@FindBy(xpath = "//small[@class='p-invalid ng-star-inserted']")
	List<WebElement> mandatoryErrorMsg;
	@FindBy(xpath = "//mat-card-title/div[2]/div[1]/button")
	WebElement multiDeleteBtn;
	@FindBy(xpath = "//span[contains(@class,'p-paginator-current ng-star-inserted')]")
	WebElement footerPagination;
	@FindBy(xpath = "//i[contains(@class,'p-sortable-column-icon')]")
	List<WebElement> sortIcons;
	@FindBy(xpath = "//button[@icon='pi pi-trash']")
	WebElement deleteBtn;
	@FindBy(xpath = "//div[@class='p-field ng-star-inserted']//input[@id='classTopic']")
	WebElement classTopic1;
    
	@FindBy(xpath="//span[@class='p-input-icon-left']//input[@id='filterGlobal']")
	private WebElement searchBarClass;
	@FindBy(xpath=("//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]"))
	private WebElement  checkboxName;
	@FindBy(xpath="//*[@id=\"batchName\"]")
	private WebElement   batchnamefield;
	@FindBy(xpath = "//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]")
	private WebElement checkbox;
	@FindBy(xpath="//p-dropdown[@id='batchName']")	
	private WebElement batchname;
	@FindBy(xpath="//input[@id='classDescription']")
	private WebElement  classdesriptiontextbox;
	@FindBy(xpath="//input[@placeholder='Select a Staff Name']")
	private WebElement staffname;
	@FindBy(xpath = "//tbody/tr[1]/td[8]/div[1]/span[1]/button[1]/span[1]")
	private WebElement editIcon;
	@FindBy(xpath ="//input[@id='classTopic']")
     private WebElement  classtopicfield;
	@FindBy(xpath ="//span[@class='p-button-icon p-button-icon-left pi pi-check']")
	private WebElement savebutton;
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']//span[contains(text(),'Class')]")
	private WebElement classButton1;
	@FindBy(xpath="///button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']//span[contains(text(),'Class')]")
	private WebElement batchlink;
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']//span[contains(text(),'Class')]")
	private WebElement logoutlink;
	@FindBy(xpath="//tbody/tr[1]/td[8]/div[1]/span[1]/button[2]")
	private WebElement delete;
	
JavascriptExecutor js = (JavascriptExecutor) driver;
	Map<String, String> classData;
	
	
	public void openPage() {
		driver.get("https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/session");
	}
	
	
	public boolean isOnClassPage() {
		if (driver.getCurrentUrl().contains("session")) {
			return true;
		}
		return false;
	}
	
	//Map<String, String> classData;
	public ClassPage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
		public void clickClassButton() {
			
			JavascriptExecutor  js= (JavascriptExecutor ) driver;
            js.executeScript("window.scrollBy(0,-300);");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(classButton)).click();
      	
		}
		
		public boolean click(WebElement element) {
			try {
				WebElement eleToClick = new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT))
						.until(ExpectedConditions.visibilityOf(element));
				if (eleToClick.isEnabled()) {
					//.eleToClick.click();
					return true;
				} else {
					System.out.println("Element not enabled");
					//throw new IllegalStateException("Element is not enabled");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean clickNextPagelink() {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(nextPageLink.getAttribute("//button[contains(@class,'p-paginator-next')]"))));
		        if (nextPageLink.isDisplayed() && nextPageLink.isEnabled()) {
		            nextPageLink.click();
		            return true;
		        } else {
		            System.out.println("Next Page link is either not displayed or not enabled.");
		            return false;
		        }
		    } catch (TimeoutException e) {
		        System.out.println("Timeout waiting for Next Page link: " + e.getMessage());
		        return false;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return false;
		    }
		}
		public void addNewClass() {
			WebElement addNewClass=driver.findElement(By.xpath("//button[contains(@class, 'mat-focus-indicator mat-menu-item')]"));    		
	        addNewClass.click();
		}
		
		public boolean ismanageClassTextDisplayed() {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.visibilityOf(manageClassText));
			    return manageClassText.isDisplayed();
		}	  
		public boolean isLMSTextDisplayed() {
			String ww=LMSText.getText();
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.visibilityOf(LMSText));
			    return LMSText.isDisplayed();
		}	
		public boolean isSearchBarDisplayed() {
			return searchBar.isDisplayed();
		}
		
		@FindBy(xpath = "//thead//th")
		private List<WebElement> tableHeaders;
		public List<String> getTableHeaders() {
		    List<String> headersText = new ArrayList<>();
		    for (WebElement header : tableHeaders) {
		        headersText.add(header.getText().trim());
		    }
		    return headersText;
		}
		public void waitForDataTableToLoad() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(dataTable));
		}
		public void clearFilter() {
			search.clear();
		}
		
//		public void clickNextPagelink() {
//
//			waitForDataTableToLoad();
//			click(nextPageLink);
//		}
		public void clickLastPageLink() {
			waitForDataTableToLoad();
			click(lastPageLink);
		}
		public void clickStrtPageLink() {
			waitForDataTableToLoad();
			click(startPageLink);
		}
		public void clickPrevPageLink() {
			waitForDataTableToLoad();
			click(prevPageLink);
		}

public boolean PrevPageLinkEnabled() {
		        boolean isEnabled = prevPageLink.isEnabled();
		        System.out.println("Previous Page Enabled? " + isEnabled);
		        return isEnabled;
		    }
		    // :white_check_mark: Check if Next Page button is enabled
		  public boolean NextPageLinkEnabled() {
				if (nextPageLink.isEnabled()) {
					return true;
				} else {
					return false;
				}
			}
		    // :white_check_mark: Wait until Next Page button is disabled (for last page validation)
		    public void waitForNextButtonToBeDisabled() {
		    	
		        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(nextPageLink)));
		        System.out.println(":white_check_mark: Next Page button is now disabled.");
		    }
		    // :white_check_mark: Wait until Previous Page button is enabled (for first page validation)
		    public void waitForPrevButtonToBeEnabled() {
		        wait.until(ExpectedConditions.elementToBeClickable(prevPageLink));
		        System.out.println(":white_check_mark: Previous Page button is now enabled.");
		    }
		    // :white_check_mark: Click Page 4 and verify Next button is disabled
		    public void verifyNextButtonDisabledAfterClickingPage4(WebElement page4) {
		        System.out.println("Before clicking Page 4, Next Page Enabled? " + NextPageLinkEnabled());
		        // Click on Page 4
		        page4.click();
		       
		        // Wait for the Next button to be disabled
		        waitForNextButtonToBeDisabled();
		        // Assert that Next Page button is disabled
		        Assert.assertFalse(NextPageLinkEnabled(), ":x: Next button should be disabled on last page!");
		    }
		    // :white_check_mark: Click Previous Page and verify it's enabled
		    public void verifyPrevButtonEnabledAfterClicking() {
		        System.out.println("Before clicking Previous Page, is it enabled? " + PrevPageLinkEnabled());
		        // Click Previous Page button
		        prevPageLink.click();
		       
		        // Wait for the Previous button to be enabled
		        waitForPrevButtonToBeEnabled();
		        // Assert that Previous Page button is enabled
		        Assert.assertTrue(PrevPageLinkEnabled(), ":x: Previous button should be enabled when navigating back!");
		    }
		
		
//		public boolean PrevPageLinkEnabled() {
//			waitForDataTableToLoad();
//			if (prevPageLink.isEnabled()) {
//				return true;
//			} else {
//				return false;
//			}
//		}
		
		public List<WebElement> getSortBatchName() {
			return sortBatchName;
				
		}
		
		public void clickSortBatchName() {
			click(clickSortBatchName);
			
		}
		
		public List<WebElement> getSortClassTopic() {
			return sortClassTopic;
				
		}
		
		public void clickSortClassTopic() {
			click(clickSortClassTopic);
			
		}
		
		public List<WebElement> getSortClassDescription() {
			return sortClassDescription;
				
		}
		
		public void clickSortClassDescription() {
			click(clickSortClassDescription);
			
		}
		
		public List<WebElement> getSortStatus() {
			return sortStatus;
				
		}
		
		public void clickSortStatus() {
			click(clickSortStatus);
			
		}
		
		public List<WebElement> getSortClassDate() {
			return sortClassDate;
				
		}
		
		public void clickSortClassDate() {
			click(clickSortClassDate);
			
		}
		
		public List<WebElement> getSortStaffName() {
			return sortStaffName;
				
		}
		
		public void clickSortStaffName() {
		//	click(clickSortStaffName);
			
		}

public void SortAscendingOrder(List<WebElement> list) {
		    // Extract text from WebElements and trim spaces
		    List<String> appSort = list.stream()
		                               .map(e -> e.getText().trim()) // Trim to remove extra spaces
		                               .collect(Collectors.toList());
		    System.out.println("Original List: " + appSort);
		    // Create a sorted copy of the original list
		    List<String> expectedSortedList = new ArrayList<>(appSort);
		    expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER);
		    System.out.println("Expected Sorted List: " + expectedSortedList);
		    try {
		        Assert.assertEquals(appSort, expectedSortedList);
		        System.out.println("Sorting test PASSED :white_check_mark:");
		    } catch (AssertionError e) {
		        System.err.println("Sorting test FAILED :x:: " + e.getMessage());
		        // You can also log it using Log4j or another logging framework if needed.
		    }
		}
		
		public void sortDescendingOrder(List<WebElement> list) {
			List<String> appSort = list.stream().map(s -> s.getText()).collect(Collectors.toList());
			System.out.println(appSort);
			List<String> sortedList = appSort.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			System.out.println(sortedList);
			Assert.assertTrue(appSort.equals(sortedList));
		
		
		}
		
		public void logout()
		{
			logOut.click();
		}
	public void vallogout(String string) {
		String valLogin = loginPage.getText();
		Assert.assertEquals(valLogin, string);
	}
	
	public boolean sendKeys(WebElement element, String text) {
		try {
			WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT))
					.until(ExpectedConditions.visibilityOf(element));
			if (ele.isEnabled()) {
				ele.clear();
				ele.sendKeys(text);
				return true;
			} else {
				throw new Exception("Element is not enabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean datePicker(String dates) {
		click(classDates);
		sendKeys(classDates, dates);
		click(calenderIcon);
		classDates.sendKeys(Keys.TAB);
		js.executeScript("arguments[0].scrollIntoView(true);", noOfClasses);
		click(classDates);
		classDates.sendKeys(Keys.TAB);
		return true;
	}
	
	public void deleteClass() {
		
		click(deleteBtn);
	}

public boolean verifyConfirmPopupContent() {
		
		return confirmlabel.isDisplayed() && yesBtn.isDisplayed() && noBtn.isDisplayed() && closeBtn.isDisplayed();
			
	}
	
	public void clickYesBtn() {
		
		click(yesBtn);
		
	}
	
	public String getFooterPaginationText() {
		return bp.getText(footerPagination);
	}
	
	
	public boolean clickDatePicker() {
		click(classDates);
		return true;
	}
	public void emptyInputClick() {
		click(savebtn);
	}
	public boolean verifyDataTableHeaders(List<String> headers) {
		headers.forEach(str -> {
			Assert.assertNotNull(driver.findElement(By.xpath("//th[contains(text(),'" + str + "')]")));
		});
		return true;
	}
	
//	public boolean verifyMultiDeleteBtn() {
//		return isViewable(multiDeleteBtn);
//	}
	
	public Boolean verifyNewClassPopupMandatoryFields() {
		Boolean result = Boolean.FALSE;
		if (addNewClassPopup.isDisplayed()) {
			if (mandatoryErrorMsg != null && !mandatoryErrorMsg.isEmpty() && mandatoryErrorMsg.size() == 6) {
				WebElement batchNameAlert = mandatoryErrorMsg.get(0);
				WebElement classTopicAlert = mandatoryErrorMsg.get(1);
				WebElement classDatesAlert = mandatoryErrorMsg.get(2);
				WebElement noOfClassesAlert = mandatoryErrorMsg.get(3);
				WebElement staffNameAlert = mandatoryErrorMsg.get(4);
				WebElement statusAlert = mandatoryErrorMsg.get(5);
				if (batchNameAlert.isDisplayed() && classTopicAlert.isDisplayed() && classDatesAlert.isDisplayed()
						&& noOfClassesAlert.isDisplayed() && staffNameAlert.isDisplayed()
						&& statusAlert.isDisplayed()) {
					return mandatoryErrorMsg.stream().allMatch(we -> we.getAttribute("style").contains("color: red"));
					// result = Boolean.TRUE;
				}
			} else {
				result = Boolean.FALSE;
			}
		}
		return result;
	}
	public boolean verifySortIcons() {
		return sortIcons.stream().allMatch(we -> we.isDisplayed());
	}
	public void verifyOptionalInput(String testcase) {
	//	classData = applicationData1.getData(Class_Add_Sheet, testcase); // TestData from Excel based on the testcase
		if (classData.get("ClassDescription") != null) {
			sendKeys(classDescText, classData.get("ClassDescription"));
		}
		if (classData.get("Comments") != null) {
			sendKeys(classCommentsText, classData.get("Comments"));
		}
		if (classData.get("Notes") != null) {
			sendKeys(classNotesText, classData.get("Notes"));
		}
		if (classData.get("Recording") != null) {
			sendKeys(classRecordingText, classData.get("Recording"));
		}
		click(savebtn);
	}
	public void verifyCancelBtn() {
		click(cancelBtn);
	}
	//public void verifyCloseBtn() {Overall planning has improved significantly due to the intake form. Analysis of the impact on the current project also helps
	///	click(closeBtn);
	//}
	public boolean isDateDisabled(String day) {
		return driver.findElement(By.xpath("//span[text()='" + day + "' and contains(@class,'p-disabled')]")) != null;
	}
	public String getNoOfClasses() {
		return noOfClasses.getAttribute("ng-reflect-model");
	}

public boolean verifySearhBox() {
		if (searchBar.isEnabled()) {
			return true;
		}
		return false;
	}
	public boolean verifyPopupTextField() throws InterruptedException {
Thread.sleep(5000);
		if (classTopic.isDisplayed() && noOfClasses.isDisplayed() && classDates.isDisplayed()) {
			return true;
		}
		return false;
	}
	public void addNewBtnClick() {
		click(addNewBtn);
	}

	
public void classBtnClick() {
		click(classLink);
	}

	public boolean verifyPageTitle(String expected) {
		if (getText(pageTitle).equals(expected)) {
			return true;
		}
		return false;
	}
	public boolean verifyHeaderTitle(String expected) {
		if (getText(headerTitle).equals(expected)) {
			return true;
		}
		return false;
	}
	public String validateAddNewPopupTitle() {
		if (addNewClassPopup.isDisplayed()) {
			String poptitle = PopupTitle.getText();
			System.out.println("popup title text is: " + poptitle);
			return PopupTitle.getText();
		} else {
			return "";
		}
	}
	public boolean validateAddNewPopup() {
		return addNewClassPopup.isDisplayed();
	}
	public void enterValid(String Batchname,String ClassTopic,String ClassDescription,String SelectClassDates,String NoofClasses,String StaffName,String Status,String Comments,String Notes,String Recording,String ExpectedMsg) {
		batchNamedd.sendKeys(Batchname);
		
		//staffNamedd.sendKeys(null);
		classTopic.sendKeys(ClassTopic);
		classDescText.sendKeys(ClassDescription);
		statusActiveOption.sendKeys(Status);
		//statusInactiveOption.sendKeys(Status);
		
		classCommentsText.sendKeys(Comments);
		classNotesText.sendKeys(Notes);
		classRecordingText.sendKeys(Recording);
		classDates.sendKeys(SelectClassDates);
	}


	public void clickonediticon() {
		clickClassButton(); // will be removed
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 20 seconds pause
//Create a WebDriverWait instance with a timeout of 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxName));

		Actions actions = new Actions(driver);
		actions.moveToElement(checkbox).click().perform();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//WebElement editIcon = wait1.until(ExpectedConditions.elementToBeClickable(editIcon));

		Actions actions1 = new Actions(driver);
		actions1.moveToElement(editIcon).click().perform();
	}

	public boolean batchnameisdisabled() {
		boolean isDisabled = batchnameisdisabled();
		if (isDisabled) {
			System.out.println("Batch Name field is disabled.");
		} else {
			System.out.println("Batch Name field is NOT disabled.");
		}
		return isDisabled;
	}

	public void isClassTopicFieldDisabled() {
		editIcon.click();
		System.out.println("class topic field is disabled");
	}

	public void updateFieldsWithValidData(String staffName, String classDescription) {

		clickonediticon();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(classdesriptiontextbox)).clear();
		classdesriptiontextbox.sendKeys(classDescription);

// staffNameTextbox.sendKeys(staffName);

//wait.until(ExpectedConditions.visibilityOf(classdesriptiontextbox)).clear();
//classdesriptiontextbox.sendKeys(classdesription);

		wait.until(ExpectedConditions.visibilityOf(staffname)).clear();
		staffname.sendKeys(staffName);

	}

	public void clickSaveButton() {
		savebutton.click();
		System.out.println("Admin should see succesfully saved");
	}

	public void fieldswithinvalidvalues() {
		clickonediticon();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(classdesriptiontextbox)).clear();
		classdesriptiontextbox.sendKeys("");

		wait.until(ExpectedConditions.visibilityOf(staffname)).clear();
		staffname.sendKeys("123InvalidTopic!");
//savebutton.click();
	}

	public void clickSaveButton1() {
		savebutton.click();
		System.out.println("Admin should see succesfully saved");
	}

	public void updatemandatoryfieldWithValidData() {
		clickonediticon();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(staffname)).clear();
		staffname.sendKeys("sami");
//savebutton.click();
	}

	public void clickSaveButton2() {
		savebutton.click();
		System.out.println("Admin should see succesfully saved");
	}

	public void updateoptionalfield() {
		clickonediticon(); // will be removed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(classdesriptiontextbox)).clear();
		classdesriptiontextbox.sendKeys("python");
//savebutton.click();
	}

	public void clickSaveButton3() {
		savebutton.click();
		System.out.println("Admin should see succesfully saved");
	}

	public void cancelbutton() {
		clickonediticon();
		cancelBtn.click();
		System.out.println("Admin should see details");
	}

	public void cliclclasslink() {
		clickClassButton(); // will be removed
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-300);");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(classButton1));
		Actions actions = new Actions(driver);
		actions.moveToElement(classButton1).click().perform();
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
//wait.until(ExpectedConditions.visibilityOf(classbuttonlink)).click();
	}

	public void clicklogoutlink() {
		clickClassButton(); // will be removed
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-300);");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(logoutlink));
	}

	public void clicksearchBar() {
		clickClassButton(); // will be removed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(searchBarClass)).clear();
		searchBarClass.sendKeys("Micro service-01");

	}

	public void searchclastopic() {
		clickClassButton(); // will be removed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(searchBarClass)).clear();
		searchBarClass.sendKeys("core java");
	}

	public void deleteicon() {
		clickClassButton(); // will be removed
// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//wait.until(ExpectedConditions.visibilityOf(delete)).click()
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement deleteElement = wait1.until(ExpectedConditions.elementToBeClickable(delete));

		Actions actions1 = new Actions(driver);
		actions1.moveToElement(deleteElement).click().perform();
		System.out.println("Admin should see alert open ");
	}

	public void checkbox() {
		clickClassButton(); // will be removed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxName));

		Actions actions = new Actions(driver);
		actions.moveToElement(checkbox).click().perform();

	}

	public void clickyes() {
		deleteicon();
		System.out.println("Admin should confirm deletion alert ");
	}
}
